package com.vnsw.ws.p9.controller;

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
import com.vnsw.ws.helper.SoapHelper;
import com.vnsw.ws.p9.common.Constants09;
import com.vnsw.ws.p9.entity.json.SendMessage;
import com.vnsw.ws.p9.envelop.Error;
import com.vnsw.ws.p9.envelop.*;
import com.vnsw.ws.p9.message.send.*;
import com.vnsw.ws.p9.service.BackendService09;
import com.vnsw.ws.p9.service.EnvelopeService09;
import com.vnsw.ws.util.Constants;
import com.vnsw.ws.util.LogUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import java.net.URI;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.vnsw.ws.helper.JsonHelper.createResponse;

@RestController
@RequestMapping("/send/09")
public class SendController09 {
    public static final Logger logger = LoggerFactory.getLogger(SendController09.class);
    private static final String CLASS_NAME = "SendController09";

    @Autowired
    private Environment environment;

    @Autowired
    private EnvelopXmlService convertXmlService;

    @Autowired
    EnvelopeService09 envelopeService;

    @Autowired
    private EncryptService encryptService;

    private final SimpleDateFormat formatterDateTime = new SimpleDateFormat(Constants.XML_DATETIME_FORMAT);
    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    BackendService09 backendService;

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
        Envelope09 envelopeSend = null;
        Header header = null;
        Body body = null;
        Content content = new Content();
        ResponseJson objReturn;
        try {
            // Goi den backend theo IdHoso de dong goi ban tin gui di
            Long fiIdHoso = sendMessage.getFiIdHoso();
            String maHoso = sendMessage.getFiMaHoso();
            String nowStr = formatterDateTime.format(new Date());
            String url = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants09.RES_URI.URI_GET_HS_BY_ID + fiIdHoso;
            ResponseJson response = backendService.getDataFromRestUri(url);
//            String isTest = environment.getRequiredProperty("IS_TEST");
            String isTest = "0";
            Long fileStatus;
            //RequestCancel requestCancel = null;
            if (response != null && response.isSuccess()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonData = mapper.writeValueAsString(response.getData());
                HoSo09 hoso09 = mapper.readValue(jsonData, HoSo09.class);
                if (hoso09 != null) {
                    header = envelopeService.createSendHeader(
                            maHoso,
                            Constants.MARD_PRO.MARD09,
                            sendMessage.getType(),
                            sendMessage.getFunction(),
                            hoso09.getFiQuarantineDepartmentNameCode(),
                            hoso09.getFiMonitoringDepartmentNameCode());
                    switch (sendMessage.getType()) {
                        case Constants09.MARD09_TYPE.TYPE_10: // DN gui ho so
                            content.setHoso(hoso09);
                            body = envelopeService.createBody(content);
                            envelopeSend = envelopeService.createMessage(header, body);
                            // Gui message
                            if (Boolean.TRUE.equals(sendMessage.getXmlOnly())) {
                                String xml = convertXmlService.ObjectToXml(envelopeSend);
                                return createResponse(xml, true, errorMessage, httpStatus, null);
                            }
                            if (isTest.equals(Constants.STATUS.ACTIVE)) {
                                isSuccess = true;
                            } else {
                                objReturn = send(envelopeSend, sendMessage.getSignedXml(), maHoso, sendMessage.getType());
                                isSuccess = objReturn.isSuccess();
                                errorMessage = objReturn.getMessage();
                            }

                            break;
                        case Constants09.MARD09_TYPE.TYPE_13: // DN xin sua ho so
                            YCSuaHS ycSuaHS = new YCSuaHS();
                            ycSuaHS.setFiReason(sendMessage.getReason()); // Set them ly do
                            ycSuaHS.setHoSo09(hoso09);
                            ycSuaHS.setFiRequestDate(DateUtils.truncate(new Date(), Calendar.HOUR));
                            content.setYeucauSuaHS(ycSuaHS);
                            body = envelopeService.createBody(content);
                            envelopeSend = envelopeService.createMessage(header, body);
                            // Gui message
                            if (Boolean.TRUE.equals(sendMessage.getXmlOnly())) {
                                String xml = convertXmlService.ObjectToXml(envelopeSend);
                                return createResponse(xml, true, errorMessage, httpStatus, null);
                            }
                            if (isTest.equals(Constants.STATUS.ACTIVE)) {
                                isSuccess = true;
                            } else {
                                objReturn = send(envelopeSend, sendMessage.getSignedXml(), maHoso, sendMessage.getType());
                                isSuccess = objReturn.isSuccess();
                                errorMessage = objReturn.getMessage();
                            }
                            break;
                        case Constants09.MARD09_TYPE.TYPE_15: // DN xin rut ho so khi chua tiep nhan
                            DNRutHSTruocTiepNhan dnYeuCauRutHS = new DNRutHSTruocTiepNhan();
                            dnYeuCauRutHS.setFiCancelDate(new Date());
                            content.setDnRutHSTruocTiepNhan(dnYeuCauRutHS);
                            body = envelopeService.createBody(content);
                            envelopeSend = envelopeService.createMessage(header, body);
                            if (isTest.equals(Constants.STATUS.ACTIVE)) {
                                isSuccess = true;
                            } else {
                                objReturn = send(envelopeSend, sendMessage.getSignedXml(), maHoso, sendMessage.getType());
                                isSuccess = objReturn.isSuccess();
                                errorMessage = objReturn.getMessage();
                            }
                            break;
                        case Constants09.MARD09_TYPE.TYPE_16: // DN xin rut ho so khi da tiep nhan
                            DNYeuCauRutHSSauTiepNhan cancel = new DNYeuCauRutHSSauTiepNhan();
                            cancel.setFiRequestDate(new Date());
                            if (sendMessage.getType().equals(Constants09.MARD09_TYPE.TYPE_16)) {
                                cancel.setFiReason(sendMessage.getReason());
                            }
                            content.setDnYeuCauRutHSSauTiepNhan(cancel);
                            body = envelopeService.createBody(content);
                            envelopeSend = envelopeService.createMessage(header, body);
                            // Gui message
                            if (isTest.equals(Constants.STATUS.ACTIVE)) {
                                isSuccess = true;
                            } else {
                                objReturn = send(envelopeSend, sendMessage.getSignedXml(), maHoso, sendMessage.getType());
                                isSuccess = objReturn.isSuccess();
                                errorMessage = objReturn.getMessage();
                            }

                            break;

                        case Constants09.MARD09_TYPE.TYPE_23: // DN xin sua giay chunh nhan
                            DNYeuCauSuaGiayPhep dnYeuCauSuaGiayPhep = mapper.readValue(mapper.writeValueAsString(sendMessage.getData()), DNYeuCauSuaGiayPhep.class);
                            dnYeuCauSuaGiayPhep.setFiRequestDate(new Date());
                            //download file va dinh kem vao ban tin
//                            dnYeuCauSuaGiayPhep.getAttachmentList();
                            content.setDnYeuCauSuaGiayPhep(dnYeuCauSuaGiayPhep);
                            body = envelopeService.createBody(content);
                            envelopeSend = envelopeService.createMessage(header, body);
                            // Gui message
                            if (isTest.equals(Constants.STATUS.ACTIVE)) {
                                isSuccess = true;
                            } else {
                                objReturn = send(envelopeSend, sendMessage.getSignedXml(), maHoso, sendMessage.getType());
                                isSuccess = objReturn.isSuccess();
                                errorMessage = objReturn.getMessage();
                            }

                        break;

                        case Constants09.MARD09_TYPE.TYPE_27: // Phan hoi cong van XNCL khong dat
                            DNPhanHoiKQXNCL dnPhanHoiKQXNCL = new DNPhanHoiKQXNCL();
                            dnPhanHoiKQXNCL.setFiResponseUser(sendMessage.getFiNguoitao());
                            dnPhanHoiKQXNCL.setFiDescription(sendMessage.getReason());
                            dnPhanHoiKQXNCL.setFiResponseDate(new Date());
                            content.setDnPhanHoiKQXNCL(dnPhanHoiKQXNCL);
                            body = envelopeService.createBody(content);
                            envelopeSend = envelopeService.createMessage(header, body);
                            // Gui message
                            if (isTest.equals(Constants.STATUS.ACTIVE)) {
                                isSuccess = true;
                            } else {
                                objReturn = send(envelopeSend, sendMessage.getSignedXml(), maHoso, sendMessage.getType());
                                isSuccess = objReturn.isSuccess();
                                errorMessage = objReturn.getMessage();
                            }

//                            fileStatus = Constants09.HosoStatus.CHO_PHUC_KHAO;
//                            if (isSuccess) {
//                                objReturn = backendService.updateHoSoStatus(header, maHoso, fileStatus, "Phản hồi công văn XNCL không đạt: " +  sendMessage.getReason());
//                                isSuccess = objReturn.isSuccess();
//                                errorMessage = objReturn.getMessage();
//
//                            }
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
     * Gửi di va nhan ket qua tra ve
     *
     * @param envelopeSend
     * @return
     * @throws Exception
     */
    private ResponseJson send(Envelope09 envelopeSend, String signedXml, String fiMaHoSo, String msgType) {
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

        Envelope09 envl;
        Error error;

        String documentType = Constants.MARD_PRO.MARD09;
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
            logger.debug("REQ09: " + xml);
            SOAPMessage soapMessage = SoapHelper.createSOAPRequest(xml, officeCode, documentType, nameSpace,
                    nameSpaceKey, methodTag, requestOfficeCode, requestDocumentType, requestPayload);
            //String sendMessage = SoapHelper.getSOAPResponse(soapMessage);
            SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
            responseStr = SoapHelper.getSOAPResponse(soapResponse);
            logger.debug("RES09: " + responseStr);
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

        Envelope09 envelopeReturn = convertXmlService.xmlToEnvelope(xml, Envelope09.class);
        if (envelopeReturn != null) {
            if (checkTypeReturn(envelopeReturn)) {
                isSuccess = true;
            } else {
                List<Error> errors = envelopeReturn.getBody().getContent().getErrorList();
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
    private boolean checkTypeReturn(Envelope09 envelopeReturn) {
        return envelopeReturn != null && envelopeReturn.getHeader() != null
                && envelopeReturn.getHeader().getSubject() != null && Constants09.MARD09_FUNCTION.FUNCTION_99
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
