package com.vnsw.ws.p25.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.vnsw.ws.common.entity.json.ResponseDownload;
import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.service.EncryptService;
import com.vnsw.ws.common.service.EnvelopXmlService;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.helper.SoapHelper;
import com.vnsw.ws.p25.common.Constants25;
import com.vnsw.ws.p25.entity.json.SendMessage;
import com.vnsw.ws.p25.entity.send.Product;
import com.vnsw.ws.p25.envelop.*;
import com.vnsw.ws.p25.message.send.*;
import com.vnsw.ws.p25.service.BackendService25;
import com.vnsw.ws.p25.service.EnvelopeService25;
import com.vnsw.ws.p9.message.receive.GiayXNCL;
import com.vnsw.ws.util.Constants;
import com.vnsw.ws.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.vnsw.ws.helper.JsonHelper.createResponse;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/send/25")
public class SendController25 {
    public static final Logger logger = LoggerFactory.getLogger(SendController25.class);
    private static final String CLASS_NAME = "SendController25";

    @Autowired
    private Environment environment;

    @Autowired
    private EnvelopXmlService convertXmlService;

    @Autowired
    EnvelopeService25 envelopeService;

    @Autowired
    private EncryptService encryptService;

    private final SimpleDateFormat formatterDateTime = new SimpleDateFormat(Constants.XML_DATETIME_FORMAT);
    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    BackendService25 backendService;
    private Gson gson=null;
    private Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (jsonElement, type, context) -> new Date(jsonElement.getAsJsonPrimitive().getAsLong()))
                    .create();
        }
        return gson;
    }
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
        Envelope25 envelopeSend = null;
        Header25 header = null;
        Body25 body = null;
        Content25 content = new Content25();
        ResponseJson objReturn = null;
        try {
            // Goi den backend theo IdHoso de dong goi ban tin gui di
            Long fiIdHoso = sendMessage.getFiIdHoso();
            String maHoso = sendMessage.getFiMaHoso();
            logger.info("SendAll");
            String url = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants25.RES_URI.URI_GET_HS_BY_ID + fiIdHoso;
            ResponseJson response = backendService.getDataFromRestUri(url);
//            String isTest = environment.getRequiredProperty("IS_TEST");
            String isTest = "0";
            boolean debugMode = Boolean.parseBoolean(environment.getProperty("DEBUG_MODE"));
            String isSend =environment.getProperty("SEND_VNC");
            Long fileStatus;
            //RequestCancel requestCancel = null;
            if (response != null && response.isSuccess()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonData = mapper.writeValueAsString(response.getData());
                header = envelopeService.createSendHeader(
                        maHoso,
                        Constants.MARD_PRO.MARD25,
                        sendMessage.getType(),
                        sendMessage.getFunction(),
                        "CCN");
                Hoso25 hoso25 = mapper.readValue(jsonData, Hoso25.class);
                switch (sendMessage.getType()) {
                    case Constants25.MARD25_TYPE.TYPE_10: // DN gui ho so
                        hoso25.setDepartmentCode("1");
                        hoso25.setDepartmentName("1");
                        hoso25.setFiHSCreatedDate(new Date());
//                        hoso25.getFiProductList().get(0).setFiBanChat("1");
                        content.setHoso25(hoso25);
                        body = envelopeService.createBody(content);
                        envelopeSend = envelopeService.createMessage(header, body);
                        // Gui message
                        if ("1".equals(isSend)) {
//                            String xml = convertXmlService.ObjectToXml(envelopeSend);
                            ResponseJson res=backendService.guiHosoVNC(envelopeSend);
                            logger.info("Gui VNC: "+res.getMessage());
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
                            objReturn.setData(hoso25);
                        }

                        break;
                    case Constants25.MARD25_TYPE.TYPE_15:
                        GuiHSTCCD guiHSTCCD = mapper.readValue(sendMessage.getDataRequest(),GuiHSTCCD.class);
                        for(Product product: guiHSTCCD.getFiProductList()){
                            product.setFiProATList(null);
                            product.setFiProCLList(null);
                            product.setFiProSLKLList(null);
                        }
                        content.setGuiHSTCCD(guiHSTCCD);
                        body = envelopeService.createBody(content);
                        envelopeSend = envelopeService.createMessage(header, body);
                        if (debugMode) {
                            isSuccess = true;
                        } else {
                            objReturn = send(envelopeSend, sendMessage.getSignedXml(), maHoso, sendMessage.getType());
                            isSuccess = objReturn.isSuccess();
                            errorMessage = objReturn.getMessage();
                        }
                        break;
                    case Constants25.MARD25_TYPE.TYPE_11:
                        DNYeucauHuyHoso ycrut =  mapper.readValue(sendMessage.getDataRequest(), DNYeucauHuyHoso.class);
                        ycrut.setFiRequestedDate(new Date());
                        content.setDNYeucauHuyHoso(ycrut);
                        body = envelopeService.createBody(content);
                        envelopeSend = envelopeService.createMessage(header, body);
                        if (debugMode) {
                            isSuccess = true;
                            objReturn = new ResponseJson();
                            objReturn.setSuccess(true);
                            objReturn.setMessage(errorMessage);
                            objReturn.setData(hoso25);
                        } else {
                            objReturn = send(envelopeSend, sendMessage.getSignedXml(), maHoso, sendMessage.getType());
                            isSuccess = objReturn.isSuccess();
                            errorMessage = objReturn.getMessage();
                        }
                        break;
                    case Constants25.MARD25_TYPE.TYPE_17:
                        DNNopKetQua dnNopKetQua =  new Gson().fromJson(sendMessage.getDataRequest(), DNNopKetQua.class);
                        content.setNopKetQua(dnNopKetQua);
                        body = envelopeService.createBody(content);
                        envelopeSend = envelopeService.createMessage(header, body);
                        if (debugMode) {
                            isSuccess = true;
                            objReturn = new ResponseJson();
                            objReturn.setSuccess(true);
                            objReturn.setMessage(errorMessage);
                            objReturn.setData(hoso25);
                        } else {
                            objReturn = send(envelopeSend, sendMessage.getSignedXml(), maHoso, sendMessage.getType());
                            isSuccess = objReturn.isSuccess();
                            errorMessage = objReturn.getMessage();
                        }
                        break;
                    case Constants25.MARD25_TYPE.TYPE_21:
                        UploadBaoCao baoCao =new Gson().fromJson(sendMessage.getDataRequest(),UploadBaoCao.class);
                        content.setUploadBaoCao(baoCao);
                        body = envelopeService.createBody(content);
                        envelopeSend = envelopeService.createMessage(header, body);
                        if (debugMode) {
                            isSuccess = true;
                            objReturn = new ResponseJson();
                            objReturn.setSuccess(true);
                            objReturn.setMessage(errorMessage);
                            objReturn.setData(hoso25);
                        } else {
                            objReturn = send(envelopeSend, sendMessage.getSignedXml(), maHoso, sendMessage.getType());
                            isSuccess = objReturn.isSuccess();
                            errorMessage = objReturn.getMessage();
                        }
                        break;
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
        return createResponse(null, isSuccess, errorMessage, httpStatus, null);
    }

    /**
     * Gửi di va nhan ket qua tra ve
     *
     * @param envelopeSend
     * @return
     * @throws Exception
     */
    private ResponseJson send(Envelope25 envelopeSend, String signedXml, String fiMaHoSo, String msgType) {
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

        Envelope25 envl;
        Error25 error;

        String documentType = Constants.MARD_PRO.MARD25;
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
            logger.debug("REQ 25:" + xml);
            SOAPMessage soapMessage = SoapHelper.createSOAPRequest(xml, officeCode, documentType, nameSpace,
                    nameSpaceKey, methodTag, requestOfficeCode, requestDocumentType, requestPayload);
            //String sendMessage = SoapHelper.getSOAPResponse(soapMessage);
            SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
            responseStr = SoapHelper.getSOAPResponse(soapResponse);

            logger.debug("RES 25:" + responseStr);
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

        Envelope25 envelopeReturn = convertXmlService.xmlToEnvelope(xml, Envelope25.class);
        if (envelopeReturn != null) {
            if (checkTypeReturn(envelopeReturn)) {
                isSuccess = true;
            } else {
                List<Error25> errors = envelopeReturn.getBody().getContent().getErrorList();
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
    private boolean checkTypeReturn(Envelope25 envelopeReturn) {
        return envelopeReturn != null && envelopeReturn.getHeader() != null
                && envelopeReturn.getHeader().getSubject() != null && Constants25.MARD25_FUNCTION.FUNCTION_99
                .equals(envelopeReturn.getHeader().getSubject().getFunction());
    }

    private ResponseDownload download(String filePath, String fileName) throws Exception {
        URI UPLOAD_URL;
        try {
            String url = environment.getRequiredProperty("URI_ADDRESS_FILE_SERVER") + Constants.RES_URI.URL_DOWNLOAD;
            UPLOAD_URL = new URI(url);
            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(StandardCharsets.UTF_8);
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
