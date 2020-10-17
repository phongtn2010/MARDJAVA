/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p10.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vnsw.ws.common.entity.json.ResponseDownload;
import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.service.EncryptService;
import com.vnsw.ws.common.service.EnvelopXmlService;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.JsonHelper;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.p10.envelop.Error10;
import com.vnsw.ws.helper.SoapHelper;
import com.vnsw.ws.p10.common.Constants10;
import com.vnsw.ws.p10.entity.db.Tbddinhkem10;
import com.vnsw.ws.p10.entity.db.Tbdhoso10;
import com.vnsw.ws.p10.entity.json.FeeMessage;
import com.vnsw.ws.p10.entity.json.SendMessage;
import com.vnsw.ws.p10.envelop.Body10;
import com.vnsw.ws.p10.envelop.Content10;
import com.vnsw.ws.p10.envelop.Header10;
import com.vnsw.ws.p10.envelop.Envelope10;
import com.vnsw.ws.p10.message.send.QuarantineCancel;
import com.vnsw.ws.p10.message.send.QuarantineFeeRequest;
import com.vnsw.ws.p10.message.send.RegistrationCerEdit;
import com.vnsw.ws.util.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.vnsw.ws.p10.service.BackendService10;
import com.vnsw.ws.p10.service.EnvelopeService10;
import com.vnsw.ws.util.LogUtil;
import java.util.logging.Level;
import org.apache.commons.codec.binary.Base64;
import java.net.URI;
import java.nio.charset.Charset;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/send/10")
public class SendController10 {

    public static final Logger logger = LoggerFactory.getLogger(SendController10.class);
    private static final String CLASS_NAME = "SendController10";

    @Autowired
    private Environment environment;

    @Autowired
    private EnvelopXmlService convertXmlService;

    @Autowired
    EnvelopeService10 envelopeService;

    @Autowired
    private EncryptService encryptService;

    private final SimpleDateFormat formatterDateTime = new SimpleDateFormat(Constants.XML_DATETIME_FORMAT);
    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    BackendService10 backendService;

    /**
     * Gui moi ho so; gui sua ho so; rut ho so; nop phi; xin sua Chung nhan
     *
     * @param sendMessage
     * @return
     */
    @RequestMapping(value = "/sendAll/", method = RequestMethod.POST)
    public ResponseEntity<ResponseJson> sendAll(@RequestBody SendMessage sendMessage) {
        HttpStatus httpStatus = null;
        String errorMessage = "";
        boolean isSuccess = false;
        httpStatus = HttpStatus.OK;
        Envelope10 envelopeSend = null;
        Header10 header = null;
        Body10 body = null;
        Content10 content = new Content10();
        ResponseJson objReturn;
        try {
            // Goi den backend theo IdHoso de dong goi ban tin gui di
            Long fiIdHoso = sendMessage.getFiIdHoso();
            String maHoso = sendMessage.getFiMaHoso();
            String nowStr = formatterDateTime.format(new Date());
            String url = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants10.RES_URI.URL_GET_HOSO + fiIdHoso;
            ResponseJson response = backendService.getDataFromRestUri(url);
            String isTest = environment.getRequiredProperty("IS_TEST");
            Long fileStatus;
            //RequestCancel requestCancel = null;
            if (response != null && response.isSuccess()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonData = mapper.writeValueAsString(response.getData());
                Tbdhoso10 tbdhoso10 = mapper.readValue(jsonData, Tbdhoso10.class);
                if (tbdhoso10 != null && tbdhoso10.getFiMaHoso() != null && !"".equals(tbdhoso10.getFiMaHoso())) {
                    header = envelopeService.createSendHeader(tbdhoso10.getFiMaHoso(), Constants.MARD_PRO.MARD10,
                            sendMessage.getType(), sendMessage.getFunction(), tbdhoso10.getFiMaDvkd(), tbdhoso10.getFiMaDvgs());
                    switch (sendMessage.getType()) {
                        case Constants10.MARD10_TYPE.TYPE_10: // DN gui ho so
                            setFileInTbdhoso(tbdhoso10);
                            content.setTbdhoso10(tbdhoso10);
                            body = envelopeService.createBody(content);
                            envelopeSend = envelopeService.createMessage(header, body);
                            // Gui message
                            if (isTest.equals(Constants.STATUS.ACTIVE)) {
                                isSuccess = true;
                            } else {
                                objReturn = send(envelopeSend, sendMessage.getSignedXml(), tbdhoso10.getFiMaHoso(), sendMessage.getType());
                                isSuccess = objReturn.isSuccess();
                                errorMessage = objReturn.getMessage();
                            }

                            fileStatus = Constants10.HosoStatus.CHO_TIEP_NHAN;
                            if (sendMessage.getFunction().equals(Constants10.MARD10_FUNCTION.FUNCTION_03)) {
                                fileStatus = Constants10.HosoStatus.DA_SUADOI_BS;
                            }
                            if (isSuccess) {
                                objReturn = backendService.updateHoSoStatus(maHoso, fileStatus, sendMessage.getReason());
                                isSuccess = objReturn.isSuccess();
                                errorMessage = objReturn.getMessage();
                                if (isSuccess) {
                                    // Luu lich su
                                    objReturn = backendService.updateLichSuSend(maHoso, fileStatus);
                                    isSuccess = objReturn.isSuccess();
                                    errorMessage = objReturn.getMessage();
                                }
                            }
                            break;
                        case Constants10.MARD10_TYPE.TYPE_11: // DN xin rut ho so khi chua tiep nhan
                        case Constants10.MARD10_TYPE.TYPE_14: // DN xin rut ho so khi da tiep nhan
                            QuarantineCancel cancel = new QuarantineCancel();
                            cancel.setFiMaHoso(maHoso);
                            cancel.setFiNgayYc(nowStr);
                            fileStatus = Constants10.HosoStatus.DA_HUY;
                            if (sendMessage.getType().equals(Constants10.MARD10_TYPE.TYPE_14)) {
                                cancel.setFiLydo(sendMessage.getReason());
                                fileStatus = Constants10.HosoStatus.CHO_TIEP_NHAN_YC_XIN_RUT;
                            }
                            content.setQuarantineCancel(cancel);
                            body = envelopeService.createBody(content);
                            envelopeSend = envelopeService.createMessage(header, body);
                            // Gui message
                            if (isTest.equals(Constants.STATUS.ACTIVE)) {
                                isSuccess = true;
                            } else {
                                objReturn = send(envelopeSend, sendMessage.getSignedXml(), tbdhoso10.getFiMaHoso(), sendMessage.getType());
                                isSuccess = objReturn.isSuccess();
                                errorMessage = objReturn.getMessage();
                            }

                            if (isSuccess) {
                                objReturn = backendService.updateHoSoStatus(maHoso, fileStatus, sendMessage.getReason());
                                isSuccess = objReturn.isSuccess();
                                errorMessage = objReturn.getMessage();
                                if (isSuccess) {
                                    // Luu lich su
                                    objReturn = backendService.updateLichSuSend(maHoso, fileStatus);
                                    isSuccess = objReturn.isSuccess();
                                    errorMessage = objReturn.getMessage();
                                }
                            }
                            break;
                        case Constants10.MARD10_TYPE.TYPE_16: // DN xin sua ho so
                            tbdhoso10.setFiLydo(sendMessage.getReason()); // Set them ly do
                            content.setTbdhoso10(tbdhoso10);
                            body = envelopeService.createBody(content);
                            envelopeSend = envelopeService.createMessage(header, body);
                            // Gui message
                            if (isTest.equals(Constants.STATUS.ACTIVE)) {
                                isSuccess = true;
                            } else {
                                objReturn = send(envelopeSend, sendMessage.getSignedXml(), tbdhoso10.getFiMaHoso(), sendMessage.getType());
                                isSuccess = objReturn.isSuccess();
                                errorMessage = objReturn.getMessage();
                            }
                            fileStatus = Constants10.HosoStatus.CHO_TIEP_NHAN_YCCS;
                            if (isSuccess) {
                                objReturn = backendService.updateHoSoStatus(maHoso, fileStatus, sendMessage.getReason());
                                isSuccess = objReturn.isSuccess();
                                errorMessage = objReturn.getMessage();
                                if (isSuccess) {
                                    // Luu lich su
                                    objReturn = backendService.updateLichSuSend(maHoso, fileStatus);
                                    isSuccess = objReturn.isSuccess();
                                    errorMessage = objReturn.getMessage();
                                }
                            }
                            break;
                        case Constants10.MARD10_TYPE.TYPE_28: // DN xin sua giay chunh nhan
                            RegistrationCerEdit registrationCerEdit = new RegistrationCerEdit();
                            registrationCerEdit.setFiLoaiGcn(sendMessage.getCerType());
                            registrationCerEdit.setFiLydo(sendMessage.getReason());
                            registrationCerEdit.setFiMaHoso(maHoso);
                            registrationCerEdit.setFiNgayYc(nowStr);
                            content.setRegistrationCerEdit(registrationCerEdit);
                            body = envelopeService.createBody(content);
                            envelopeSend = envelopeService.createMessage(header, body);
                            // Gui message
                            if (isTest.equals(Constants.STATUS.ACTIVE)) {
                                isSuccess = true;
                            } else {
                                objReturn = send(envelopeSend, sendMessage.getSignedXml(), tbdhoso10.getFiMaHoso(), sendMessage.getType());
                                isSuccess = objReturn.isSuccess();
                                errorMessage = objReturn.getMessage();
                            }
                            fileStatus = Constants10.HosoStatus.CHO_TIEP_NHAN_YC_CS_GCN;
                            if (isSuccess) {
                                objReturn = backendService.xinSuaGCN(maHoso, fileStatus, sendMessage.getReason(), sendMessage.getCerType());
                                isSuccess = objReturn.isSuccess();
                                errorMessage = objReturn.getMessage();
                                if (isSuccess) {
                                    // Luu lich su
                                    objReturn = backendService.updateLichSuSend(maHoso, fileStatus);
                                    isSuccess = objReturn.isSuccess();
                                    errorMessage = objReturn.getMessage();
                                }
                            }
                            break;
                    }
                }
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            errorMessage = ex.toString();
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return JsonHelper.createResponse(null, isSuccess, errorMessage, httpStatus, null);
    }

    /**
     * Gui thanh toan phi
     *
     * @param feeMessage
     * @return
     */
    @RequestMapping(value = "/sendPayFee/", method = RequestMethod.POST)
    public ResponseEntity<ResponseJson> sendAll(@RequestBody FeeMessage feeMessage) {
        HttpStatus httpStatus = null;
        String errorMessage = "";
        boolean isSuccess = false;
        httpStatus = HttpStatus.OK;
        Envelope10 envelopeSend = null;
        Header10 header = null;
        Body10 body = null;
        Content10 content = new Content10();
        ResponseJson objReturn;
        try {
            // Goi den backend theo IdHoso de dong goi ban tin gui di
            Long fiIdHoso = feeMessage.getFiIdHoso();
            String maHoso = feeMessage.getFiMaHoso();
            String url = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants10.RES_URI.URL_GET_HOSO + fiIdHoso;
            ResponseJson response = backendService.getDataFromRestUri(url);
            Long fileStatus;
            String isTest = environment.getRequiredProperty("IS_TEST");
            //RequestCancel requestCancel = null;
            if (response != null && response.isSuccess()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonData = mapper.writeValueAsString(response.getData());
                Tbdhoso10 tbdhoso10 = mapper.readValue(jsonData, Tbdhoso10.class);
                if (tbdhoso10 != null && tbdhoso10.getFiMaHoso() != null && !"".equals(tbdhoso10.getFiMaHoso())) {
                    header = envelopeService.createSendHeader(tbdhoso10.getFiMaHoso(), Constants.MARD_PRO.MARD10,
                            feeMessage.getType(), feeMessage.getFunction(), tbdhoso10.getFiMaDvkd(), tbdhoso10.getFiMaDvgs());
                    QuarantineFeeRequest quarantineFeeRequest = new QuarantineFeeRequest();
                    quarantineFeeRequest.setFiChuthich(feeMessage.getFiChuthich());
                    quarantineFeeRequest.setFiMaHoso(maHoso);
                    quarantineFeeRequest.setFiNdSotien(feeMessage.getFiNdSotien());
                    quarantineFeeRequest.setFiNgaynop(feeMessage.getFiNgaynop());
                    quarantineFeeRequest.setFiNguoinop(feeMessage.getFiNguoinop());
                    quarantineFeeRequest.setFiSohoadon(feeMessage.getFiSohoadon());
                    quarantineFeeRequest.setFiSotienCk(feeMessage.getFiSotienCk());
                    // Attachment
                    if(feeMessage.getAttachment() !=null){
                        Tbddinhkem10 tbddinhkem10 = new Tbddinhkem10();
                        tbddinhkem10.setFiMaLoai(feeMessage.getAttachment().getFiMaLoai());
                        tbddinhkem10.setFiTenTep(feeMessage.getAttachment().getFiTenTep());
                        tbddinhkem10.setFiNoiDung(feeMessage.getAttachment().getFiNoiDung());
                        quarantineFeeRequest.setAttachment(tbddinhkem10);
                    }
                    content.setQuarantineFeeRequest(quarantineFeeRequest);
                    body = envelopeService.createBody(content);
                    envelopeSend = envelopeService.createMessage(header, body);
                    // Gui message
                    if (isTest.equals(Constants.STATUS.ACTIVE)) {
                        isSuccess = true;
                    } else {
                        objReturn = send(envelopeSend, feeMessage.getSignedXml(), tbdhoso10.getFiMaHoso(), feeMessage.getType());
                        isSuccess = objReturn.isSuccess();
                        errorMessage = objReturn.getMessage();
                    }

                    fileStatus = Constants10.HosoStatus.DA_NOP_PHI_CK;
                    if (isSuccess) {
                        objReturn = backendService.updateHoSoStatus(maHoso, fileStatus, "");
                        isSuccess = objReturn.isSuccess();
                        errorMessage = objReturn.getMessage();
                        if (isSuccess) {
                            // Luu lich su
                            objReturn = backendService.updateLichSuSend(maHoso, fileStatus);
                            isSuccess = objReturn.isSuccess();
                            errorMessage = objReturn.getMessage();
                        }
                    }
                }
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            errorMessage = ex.toString();
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return JsonHelper.createResponse(null, isSuccess, errorMessage, httpStatus, null);
    }
    
    private Tbdhoso10 setFileInTbdhoso(Tbdhoso10 tbdhoso10) {
        List<Tbddinhkem10> lstDinhkem = tbdhoso10.getLstDinhkem10();
        if (lstDinhkem != null && !lstDinhkem.isEmpty()) {
            for (Tbddinhkem10 tbddinhkem10 : lstDinhkem) {
                if (tbddinhkem10.getFiNoiDung() == null || tbddinhkem10.getFiNoiDung().equals("")) {
                    if (tbddinhkem10.getFiGuiId() != null && !"".equals(tbddinhkem10.getFiGuiId())
                            && tbddinhkem10.getFiDuongDan() != null && !"".equals(tbddinhkem10.getFiDuongDan())) {
                        ResponseDownload res;
                        try {
                            res = download(tbddinhkem10.getFiDuongDan(), tbddinhkem10.getFiGuiId());
                            if (res.getContent() != null) {
                                tbddinhkem10.setFiNoiDung(Base64.encodeBase64String(res.getContent()));
                            }
                        } catch (Exception ex) {
                            java.util.logging.Logger.getLogger(SendController10.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
        return tbdhoso10;
    }

    /**
     * Gửi di va nhan ket qua tra ve
     *
     * @param envelopeSend
     * @return
     * @throws Exception
     */
    private ResponseJson send(Envelope10 envelopeSend, String signedXml, String fiMaHoSo, String msgType) {
        ResponseJson responJson = new ResponseJson();
        boolean isSuccess = false;
        String message = "";
        String xml = "";
        if (signedXml == null || (signedXml != null && "".equals(signedXml))) {
            xml = convertXmlService.ObjectToXml(envelopeSend);
        } else {
            xml = signedXml;
        }

        String isEncrypt = environment.getProperty("ENCRYPT");
        if ("true".equals(isEncrypt)) {
            String key = environment.getProperty("KEY_AES");
            xml = encryptService.encrypt(key, xml);
        }

        String responseStr = "";

        Envelope10 envl;
        Error10 error;

        String documentType = Constants.MARD_PRO.MARD10;
        String officeCode = Constants.BNN;

        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            String url = environment.getProperty("GATEWAY_LINK");
            String nameSpace = environment.getProperty("GATEWAY_NAMESPACE");
            String nameSpaceKey = environment.getProperty("GATEWAY_NAMESPACE_KEY");
            String methodTag = environment.getProperty("GATEWAY_MOTHOD_TAG");
            String requestOfficeCode = environment.getProperty("GATEWAY_PAYLOAD_TAG_OFFICECODE");
            String requestDocumentType = environment.getProperty("GATEWAY_PAYLOAD_TAG_DOCUMENTTYPE");
            String requestPayload = environment.getProperty("GATEWAY_PAYLOAD_TAG_DATA");

            SOAPMessage soapMessage = SoapHelper.createSOAPRequest(xml, officeCode, documentType, nameSpace,
                    nameSpaceKey, methodTag, requestOfficeCode, requestDocumentType, requestPayload);
            //String sendMessage = SoapHelper.getSOAPResponse(soapMessage);
            SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
            responseStr = SoapHelper.getSOAPResponse(soapResponse);
            soapConnection.close();
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            message = ex.getMessage();
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString() + ";" + responseStr;
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

            error = envelopeService.createError(Constants.ERROR.ERR01_CODE, Constants.ERROR.ERR01);
            envl = envelopeService.createEnvelopeError(fiMaHoSo, Constants.MARD_PRO.MARD10, msgType, error);
            responseStr = envl.toString();
        }

        if ("true".equals(isEncrypt)) {
            String key = environment.getProperty("KEY_AES");
            xml = encryptService.decrypt(key, responseStr);
        } else {
            xml = responseStr;
        }

        Envelope10 envelopeReturn = convertXmlService.xmlToEnvelope(xml, Envelope10.class);
        if (envelopeReturn != null) {
            if (checkTypeReturn(envelopeReturn)) {
                isSuccess = true;
            } else {
                List<Error10> errors = envelopeReturn.getBody().getContent().getErrorList();
                String strErrors = errors.toString();
                message = strErrors;
                envelopeSend.getBody().getContent().setErrorList(errors);
                String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                        + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                        + Constants.MESSAGE_SEPARATOR + strErrors;
                RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            }
        }
        responJson.setSuccess(isSuccess);
        responJson.setMessage(message);
        return responJson;
    }
    /**
     * Kiểm tra bản tin trả về
     *
     * @param envelopeReturn
     * @return
     */
    private boolean checkTypeReturn(Envelope10 envelopeReturn) {
        return envelopeReturn != null && envelopeReturn.getHeader() != null
                && envelopeReturn.getHeader().getSubject() != null && Constants10.MARD10_FUNCTION.FUNCTION_99
                .equals(envelopeReturn.getHeader().getSubject().getFunction());
    }
    
    private ResponseDownload download(String filePath, String fileName) throws Exception {
        URI UPLOAD_URL;
        try {
            String url = environment.getRequiredProperty("URI_ADDRESS_FILE_SERVER") + Constants.RES_URI.URL_DOWNLOAD;
            UPLOAD_URL = new URI(url);
            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(Charset.forName("UTF8"));
            restTemplate.getMessageConverters().add(formConverter);
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
            parts.add("filePath", filePath);
            parts.add("fileName", fileName);
            ResponseDownload resDown = restTemplate.postForObject(UPLOAD_URL, parts, ResponseDownload.class);
            return resDown;
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return null;
    }
}
