package com.vnsw.ws.p8.controller;

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
import com.vnsw.ws.p8.common.Constants08;
import com.vnsw.ws.p8.entity.json.SendMessage;
import com.vnsw.ws.p8.evelop.*;
import com.vnsw.ws.p8.message.send.DNHuyHS;
import com.vnsw.ws.p8.message.send.DNYeuCauRutHS;
import com.vnsw.ws.p8.message.send.DNYeuCauSuaHS;
import com.vnsw.ws.p8.message.send.Hoso08;
import com.vnsw.ws.p8.service.BackendService08;
import com.vnsw.ws.p8.service.EnvelopeService08;
import com.vnsw.ws.util.Constants;
import com.vnsw.ws.util.LogUtil;
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
import java.util.Date;
import java.util.List;

import static com.vnsw.ws.helper.JsonHelper.createResponse;

@RestController
@RequestMapping("/send/08")
public class SendController08 {
    public static final Logger logger = LoggerFactory.getLogger(SendController08.class);
    private static final String CLASS_NAME = "SendController08";

    @Autowired
    private Environment environment;

    @Autowired
    private EnvelopXmlService convertXmlService;

    @Autowired
    EnvelopeService08 envelopeService;

    @Autowired
    private EncryptService encryptService;

    private final SimpleDateFormat formatterDateTime = new SimpleDateFormat(Constants.XML_DATETIME_FORMAT);
    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    BackendService08 backendService;

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
        Envelope08 envelopeSend = null;
        Header08 header = null;
        Body08 body = null;
        Content08 content = new Content08();
        ResponseJson objReturn = null;
        try {
            // Goi den backend theo IdHoso de dong goi ban tin gui di
            Long fiIdHoso = sendMessage.getFiIdHoso();
            String maHoso = sendMessage.getFiMaHoso();
            String nowStr = formatterDateTime.format(new Date());
            String url = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants08.RES_URI.URI_GET_HS_BY_ID + fiIdHoso;
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
                Hoso08 hoso08 = mapper.readValue(jsonData, Hoso08.class);
                if (hoso08 != null) {
                    header = envelopeService.createSendHeader(
                            maHoso,
                            Constants.MARD_PRO.MARD08,
                            sendMessage.getType(),
                            sendMessage.getFunction(),
                            "CTY");
                    switch (sendMessage.getType()) {
                        case Constants08.MARD08_TYPE.TYPE_10: // DN gui ho so
                            content.setHoso08(hoso08);
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

                            if (isSuccess && objReturn == null) {
                                objReturn = new ResponseJson();
                                objReturn.setSuccess(true);
                                objReturn.setMessage(errorMessage);
                                objReturn.setData(hoso08);
                            }
                            break;
                        case Constants08.MARD08_TYPE.TYPE_13:
                            DNYeuCauRutHS ycSuaHS = new DNYeuCauRutHS();
                            ycSuaHS.setFiReason(sendMessage.getReason()); // Set them ly do
                            ycSuaHS.setFiNSWFileCode(hoso08.getFiNSWFileCode());
                            ycSuaHS.setFiRequestDate(new Date());
                            content.setDnYeuCauRutHS(ycSuaHS);
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

                            if (isSuccess && objReturn == null) {
                                objReturn = new ResponseJson();
                                objReturn.setSuccess(true);
                                objReturn.setMessage(errorMessage);
                                objReturn.setData(hoso08);
                            }

                            break;
                        case Constants08.MARD08_TYPE.TYPE_11: // DN xin rut ho so khi chua tiep nhan
                            DNHuyHS dnHuyHS = new DNHuyHS();
                            dnHuyHS.setFiNSWFileCode(hoso08.getFiNSWFileCode());
                            dnHuyHS.setFiRequestDate(new Date());
                            content.setDnHuyHS(dnHuyHS);
                            body = envelopeService.createBody(content);
                            envelopeSend = envelopeService.createMessage(header, body);
                            if (isTest.equals(Constants.STATUS.ACTIVE)) {
                                isSuccess = true;
                            } else {
                                objReturn = send(envelopeSend, sendMessage.getSignedXml(), maHoso, sendMessage.getType());
                                isSuccess = objReturn.isSuccess();
                                errorMessage = objReturn.getMessage();
                            }
                            if (isSuccess && objReturn == null) {
                                objReturn = new ResponseJson();
                                objReturn.setSuccess(true);
                                objReturn.setMessage(errorMessage);
                                objReturn.setData(hoso08);
                            }
                            break;

                        case Constants08.MARD08_TYPE.TYPE_17:
                            DNYeuCauSuaHS dnYeuCauSuaHS = new DNYeuCauSuaHS();
                            dnYeuCauSuaHS.setFiReason(sendMessage.getReason()); // Set them ly do
                            dnYeuCauSuaHS.setFiRegistrationProfile(hoso08);
                            dnYeuCauSuaHS.setFiRequestDate(new Date());
                            content.setDnYeuCauSuaHS(dnYeuCauSuaHS);
                            body = envelopeService.createBody(content);
                            envelopeSend = envelopeService.createMessage(header, body);

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
                            if (isSuccess && objReturn == null) {
                                objReturn = new ResponseJson();
                                objReturn.setSuccess(true);
                                objReturn.setMessage(errorMessage);
                                objReturn.setData(hoso08);
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
     * Gửi di va nhan ket qua tra ve
     *
     * @param envelopeSend
     * @return
     * @throws Exception
     */
    private ResponseJson send(Envelope08 envelopeSend, String signedXml, String fiMaHoSo, String msgType) {
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

        Envelope08 envl;
        Error08 error;

        String documentType = Constants.MARD_PRO.MARD08;
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
            logger.debug("REQ08: " + xml);

            SOAPMessage soapMessage = SoapHelper.createSOAPRequest(xml, officeCode, documentType, nameSpace,
                    nameSpaceKey, methodTag, requestOfficeCode, requestDocumentType, requestPayload);
            //String sendMessage = SoapHelper.getSOAPResponse(soapMessage);
            SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
            responseStr = SoapHelper.getSOAPResponse(soapResponse);
            logger.debug("RES08: " + responseStr);
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

        Envelope08 envelopeReturn = convertXmlService.xmlToEnvelope(xml, Envelope08.class);
        if (envelopeReturn != null) {
            if (checkTypeReturn(envelopeReturn)) {
                isSuccess = true;
            } else {
                List<Error08> errors = envelopeReturn.getBody().getContent().getErrorList();
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
    private boolean checkTypeReturn(Envelope08 envelopeReturn) {
        return envelopeReturn != null && envelopeReturn.getHeader() != null
                && envelopeReturn.getHeader().getSubject() != null && Constants08.MARD08_FUNCTION.FUNCTION_99
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
