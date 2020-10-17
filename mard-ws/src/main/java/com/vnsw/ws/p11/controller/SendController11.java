/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p11.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vnsw.ws.common.entity.json.ResponseDownload;
import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.service.EncryptService;
import com.vnsw.ws.common.service.EnvelopXmlService;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.JsonHelper;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.p11.envelop.Error11;
import com.vnsw.ws.helper.SoapHelper;
import com.vnsw.ws.p11.entity.db.Tbdhoso11;
import com.vnsw.ws.p11.entity.json.FeeMessage;
import com.vnsw.ws.p11.entity.json.SendMessage;
import com.vnsw.ws.p11.envelop.Header11;
import com.vnsw.ws.p11.envelop.Body11;
import com.vnsw.ws.p11.envelop.Content11;
import com.vnsw.ws.p11.envelop.Envelope11;
import com.vnsw.ws.p11.common.Constants11;
import com.vnsw.ws.p11.entity.db.Tbddinhkem11;
import com.vnsw.ws.p11.message.send.PhytosanitaryFeeRequest;
import com.vnsw.ws.p11.message.send.PhytosanitaryCerInfo;
import com.vnsw.ws.p11.message.send.PhytosanitaryRequestCancel;
import com.vnsw.ws.p11.message.send.PhytosanitaryRequestEditCer;
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
import com.vnsw.ws.p11.service.BackendService11;
import com.vnsw.ws.p11.service.EnvelopeService11;
import com.vnsw.ws.util.LogUtil;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.logging.Level;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/send/11")
public class SendController11 {

    public static final Logger logger = LoggerFactory.getLogger(SendController11.class);
    private static final String CLASS_NAME = "SendController11";

    @Autowired
    private Environment environment;

    @Autowired
    private EnvelopXmlService convertXmlService;

    @Autowired
    EnvelopeService11 envelopeService;

    @Autowired
    private EncryptService encryptService;

    private final SimpleDateFormat formatterDateTime = new SimpleDateFormat(Constants.XML_DATETIME_FORMAT);
    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    BackendService11 backendService;

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
        Envelope11 envelopeSend = null;
        Header11 header = null;
        Body11 body = null;
        Content11 content = new Content11();
        ResponseJson objReturn;
        try {
            // Goi den backend theo IdHoso de dong goi ban tin gui di
            Long fiIdHoso = sendMessage.getFiIdHoso();
            String maHoso = sendMessage.getFiMaHoso();
            String nowStr = formatterDateTime.format(new Date());
            String url = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants11.RES_URI.URL_GET_HOSO + fiIdHoso;
            ResponseJson response = backendService.getDataFromRestUri(url);
            String isTest = environment.getRequiredProperty("IS_TEST");
            Long fileStatus;
            if (response != null && response.isSuccess()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonData = mapper.writeValueAsString(response.getData());
                Tbdhoso11 tbdhoso11 = mapper.readValue(jsonData, Tbdhoso11.class);
                if (tbdhoso11 != null && tbdhoso11.getFiMaHoso() != null && !"".equals(tbdhoso11.getFiMaHoso())) {
                    header = envelopeService.createSendHeader(tbdhoso11.getFiMaHoso(), Constants.MARD_PRO.MARD11,
                            sendMessage.getType(), sendMessage.getFunction(), tbdhoso11.getFiMadvXl());
                    switch (sendMessage.getType()) {
                        case Constants11.MARD11_TYPE.TYPE_10: // DN gui ho so
                            setFileInTbdhoso(tbdhoso11);
                            content.setTbdhoso11(tbdhoso11);
                            body = envelopeService.createBody(content);
                            envelopeSend = envelopeService.createMessage(header, body);
                            // Gui message
                            if (isTest.equals(Constants.STATUS.ACTIVE)) {
                                isSuccess = true;
                            } else {
                                objReturn = send(envelopeSend, sendMessage.getSignedXml(), tbdhoso11.getFiMaHoso(), sendMessage.getType());
                                isSuccess = objReturn.isSuccess();
                                errorMessage = objReturn.getMessage();
                            }

                            fileStatus = Constants11.HosoStatus.CHO_TIEP_NHAN;
                            if (sendMessage.getFunction().equals(Constants11.MARD11_FUNCTION.FUNCTION_03)) {
                                fileStatus = Constants11.HosoStatus.CHO_TIEP_NHAN_BO_SUNG;
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
                        case Constants11.MARD11_TYPE.TYPE_11: // DN xin rut ho so khi chua tiep nhan
                        case Constants11.MARD11_TYPE.TYPE_16: // DN xin rut ho so khi da tiep nhan
                            PhytosanitaryRequestCancel cancel = new PhytosanitaryRequestCancel();
                            cancel.setFiMaHoso(maHoso);
                            cancel.setFiNgayYc(nowStr);
                            fileStatus = Constants11.HosoStatus.DA_HUY;
                            if (sendMessage.getType().equals(Constants11.MARD11_TYPE.TYPE_16)) {
                                cancel.setFiLydo(sendMessage.getReason());
                                fileStatus = Constants11.HosoStatus.CHO_TIEP_NHAN_YC_XIN_RUT;
                            }
                            content.setPhytosanitaryRequestCancel(cancel);
                            body = envelopeService.createBody(content);
                            envelopeSend = envelopeService.createMessage(header, body);
                            // Gui message
                            if (isTest.equals(Constants.STATUS.ACTIVE)) {
                                isSuccess = true;
                            } else {
                                objReturn = send(envelopeSend, sendMessage.getSignedXml(), tbdhoso11.getFiMaHoso(), sendMessage.getType());
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
                        case Constants11.MARD11_TYPE.TYPE_14: // DN xin sua ho so
                            tbdhoso11.setFiLydoyc(sendMessage.getReason()); // Set them ly do
                            setFileInTbdhoso(tbdhoso11);
                            content.setTbdhoso11(tbdhoso11);
                            body = envelopeService.createBody(content);
                            envelopeSend = envelopeService.createMessage(header, body);
                            // Gui message
                            if (isTest.equals(Constants.STATUS.ACTIVE)) {
                                isSuccess = true;
                            } else {
                                objReturn = send(envelopeSend, sendMessage.getSignedXml(), tbdhoso11.getFiMaHoso(), sendMessage.getType());
                                isSuccess = objReturn.isSuccess();
                                errorMessage = objReturn.getMessage();
                            }
                            fileStatus = Constants11.HosoStatus.CHO_TIEP_NHAN_YCCS;
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
                        case Constants11.MARD11_TYPE.TYPE_24: // DN xin sua giay chunh nhan
                            PhytosanitaryRequestEditCer registrationCerEdit = new PhytosanitaryRequestEditCer();
                            registrationCerEdit.setFiMaHoso(maHoso);
                            registrationCerEdit.setFiNgayYc(nowStr);
                            registrationCerEdit.setFiNoidungYc(sendMessage.getReason());
                            content.setPhytosanitaryRequestEditCer(registrationCerEdit);
                            body = envelopeService.createBody(content);
                            envelopeSend = envelopeService.createMessage(header, body);
                            // Gui message
                            if (isTest.equals(Constants.STATUS.ACTIVE)) {
                                isSuccess = true;
                            } else {
                                objReturn = send(envelopeSend, sendMessage.getSignedXml(), tbdhoso11.getFiMaHoso(), sendMessage.getType());
                                isSuccess = objReturn.isSuccess();
                                errorMessage = objReturn.getMessage();
                            }
                            fileStatus = Constants11.HosoStatus.CHO_TIEP_NHAN_YC_CS_GCN;
                            if (isSuccess) {
                                objReturn = backendService.xinSuaGCN(maHoso, fileStatus, sendMessage.getReason());
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
                        case Constants11.MARD11_TYPE.TYPE_23: // DN cung cap thong tin giay chung nhan
                            // Goi toi backend lay thong tin giay chung nhan dua vao fiMahoso
                            String getCertUrl = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants11.RES_URI.URL_GET_GCN + maHoso;
                            ResponseJson getCertResponse = backendService.getDataFromRestUri(getCertUrl);
                            if (getCertResponse != null && getCertResponse.isSuccess()) {
                                ObjectMapper mapperCert = new ObjectMapper();
                                mapperCert.enable(SerializationFeature.INDENT_OUTPUT);
                                String jsonDataCert = mapperCert.writeValueAsString(getCertResponse.getData());
                                PhytosanitaryCerInfo certInfo = mapper.readValue(jsonDataCert, PhytosanitaryCerInfo.class);
                                if (certInfo != null) {
                                    content.setPhytosanitaryCerInfo(certInfo);
                                    body = envelopeService.createBody(content);
                                    envelopeSend = envelopeService.createMessage(header, body);
                                    // Gui message
                                    if (isTest.equals(Constants.STATUS.ACTIVE)) {
                                        isSuccess = true;
                                    } else {
                                        objReturn = send(envelopeSend, sendMessage.getSignedXml(), tbdhoso11.getFiMaHoso(), sendMessage.getType());
                                        isSuccess = objReturn.isSuccess();
                                        errorMessage = objReturn.getMessage();
                                    }
                                    fileStatus = Constants11.HosoStatus.CUNG_CAP_TT_GIAY_CHUNG_NHAN;
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
        Envelope11 envelopeSend = null;
        Header11 header = null;
        Body11 body = null;
        Content11 content = new Content11();
        ResponseJson objReturn;
        try {
            // Goi den backend theo IdHoso de dong goi ban tin gui di
            Long fiIdHoso = feeMessage.getFiIdHoso();
            String maHoso = feeMessage.getFiMaHoso();
            String url = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants11.RES_URI.URL_GET_HOSO + fiIdHoso;
            ResponseJson response = backendService.getDataFromRestUri(url);
            Long fileStatus;
            String isTest = environment.getRequiredProperty("IS_TEST");
            //RequestCancel requestCancel = null;
            if (response != null && response.isSuccess()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonData = mapper.writeValueAsString(response.getData());
                Tbdhoso11 tbdhoso11 = mapper.readValue(jsonData, Tbdhoso11.class);
                if (tbdhoso11 != null && tbdhoso11.getFiMaHoso() != null && !"".equals(tbdhoso11.getFiMaHoso())) {
                    header = envelopeService.createSendHeader(tbdhoso11.getFiMaHoso(), Constants.MARD_PRO.MARD11,
                            feeMessage.getType(), feeMessage.getFunction(), tbdhoso11.getFiMadvXl());
                    PhytosanitaryFeeRequest phytosanitaryFee = new PhytosanitaryFeeRequest();
                    phytosanitaryFee.setFiMaHoso(maHoso);
                    phytosanitaryFee.setFiGhichu(feeMessage.getFiGhichu());
                    phytosanitaryFee.setFiSotienTt(feeMessage.getFiSotienTt());
                    // Attachment
                    if (feeMessage.getAttachment() != null) {
                        Tbddinhkem11 tbddinhkem11 = new Tbddinhkem11();
                        tbddinhkem11.setFiMaLoai(feeMessage.getAttachment().getFiMaLoai());
                        tbddinhkem11.setFiTenTep(feeMessage.getAttachment().getFiTenTep());
                        tbddinhkem11.setFiNoiDung(feeMessage.getAttachment().getFiNoiDung());
                        phytosanitaryFee.setAttachment(tbddinhkem11);
                    }
                    content.setPhytosanitaryFeeRequest(phytosanitaryFee);
                    body = envelopeService.createBody(content);
                    envelopeSend = envelopeService.createMessage(header, body);
                    // Gui message
                    if (isTest.equals(Constants.STATUS.ACTIVE)) {
                        isSuccess = true;
                    } else {
                        objReturn = send(envelopeSend, feeMessage.getSignedXml(), tbdhoso11.getFiMaHoso(), feeMessage.getType());
                        isSuccess = objReturn.isSuccess();
                        errorMessage = objReturn.getMessage();
                    }

                    fileStatus = Constants11.HosoStatus.DA_NOP_PHI_CK;
                    if (feeMessage.getFunction().equals(Constants11.MARD11_FUNCTION.FUNCTION_16)) {
                        fileStatus = Constants11.HosoStatus.DA_NOP_BS_PHI;
                    }
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

    /**
     * Gửi di va nhan ket qua tra ve
     *
     * @param envelopeSend
     * @return
     * @throws Exception
     */
    private ResponseJson send(Envelope11 envelopeSend, String signedXml, String fiMaHoSo, String msgType) {
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

        Envelope11 envl;
        Error11 error;

        String documentType = Constants.MARD_PRO.MARD11;
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
            envl = envelopeService.createEnvelopeError(fiMaHoSo, Constants.MARD_PRO.MARD11, msgType, error);
            responseStr = envl.toString();
        }

        if ("true".equals(isEncrypt)) {
            String key = environment.getProperty("KEY_AES");
            xml = encryptService.decrypt(key, responseStr);
        } else {
            xml = responseStr;
        }

        Envelope11 envelopeReturn = convertXmlService.xmlToEnvelope(xml, Envelope11.class);
        if (envelopeReturn != null) {
            if (checkTypeReturn(envelopeReturn)) {
                isSuccess = true;
            } else {
                List<Error11> errors = envelopeReturn.getBody().getContent().getErrorList();
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
    private boolean checkTypeReturn(Envelope11 envelopeReturn) {
        return envelopeReturn != null && envelopeReturn.getHeader() != null
                && envelopeReturn.getHeader().getSubject() != null && Constants11.MARD11_FUNCTION.FUNCTION_99
                .equals(envelopeReturn.getHeader().getSubject().getFunction());
    }

    private Tbdhoso11 setFileInTbdhoso(Tbdhoso11 tbdhoso11) {
        List<Tbddinhkem11> lstDinhkem = tbdhoso11.getLstDinhkem11();
        if (lstDinhkem != null && !lstDinhkem.isEmpty()) {
            for (Tbddinhkem11 tbddinhkem11 : lstDinhkem) {
                if (tbddinhkem11.getFiNoiDung() == null || tbddinhkem11.getFiNoiDung().equals("")) {
                    if (tbddinhkem11.getFiGuiId() != null && !"".equals(tbddinhkem11.getFiGuiId())
                            && tbddinhkem11.getFiDuongDan() != null && !"".equals(tbddinhkem11.getFiDuongDan())) {
                        ResponseDownload res;
                        try {
                            res = download(tbddinhkem11.getFiDuongDan(), tbddinhkem11.getFiGuiId());
                            if (res.getContent() != null) {
                                tbddinhkem11.setFiNoiDung(Base64.encodeBase64String(res.getContent()));
                            }
                        } catch (Exception ex) {
                            java.util.logging.Logger.getLogger(SendController11.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
        return tbdhoso11;
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
