/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p12.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vnsw.ws.common.entity.json.ResponseDownload;
import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.service.EncryptService;
import com.vnsw.ws.common.service.EnvelopXmlService;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.helper.SoapHelper;
import com.vnsw.ws.p12.common.Constants12;
import com.vnsw.ws.p12.entity.db.Tbdlichsu12;
import com.vnsw.ws.p12.entity.json.SendMessage;
import com.vnsw.ws.p12.envelop.Body12;
import com.vnsw.ws.p12.envelop.Content12;
import com.vnsw.ws.p12.envelop.Envelope12;
import com.vnsw.ws.p12.envelop.Error12;
import com.vnsw.ws.p12.envelop.Header12;
import com.vnsw.ws.p12.message.send.Tbdhoso12;
import com.vnsw.ws.p12.service.EnvelopeService;
import com.vnsw.ws.p12.service.ReceiveService12;
import com.vnsw.ws.util.Constants;
import com.vnsw.ws.util.LogUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
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
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/send/12")
public class Send12Controller {

    public static final Logger logger = LoggerFactory.getLogger(Send12Controller.class);
    private static final String CLASS_NAME = "Send12Controller";

    @Autowired
    private Environment environment;

    @Autowired
    private EnvelopXmlService convertXmlService;

    @Autowired
    private EncryptService encryptService;

    @Autowired
    private EnvelopeService envelopeService;

    @Autowired
    ReceiveService12 receiveEndpoint12;

    @Autowired
    RabbitMQService rabbitMQService;

    @RequestMapping(value = "/sendAll/", method = RequestMethod.POST)
    public ResponseEntity<ResponseJson> sendAll(@RequestBody SendMessage sendMessage) {
        HttpStatus httpStatus = HttpStatus.OK;
        String errorMessage = "";
        boolean isSuccess = false;

        Envelope12 envelopeSend = null;
        Header12 header = null;
        Body12 body = null;
        Content12 content = new Content12();

        String documentType = "";

        try {
            Long fiIdHoso = sendMessage.getFiIdHoso();
            String url = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants12.RES_URI.URL_GET_HOSO + fiIdHoso;
            ResponseJson response = getData(url);
            ResponseJson json;

            if (response != null && response.isSuccess()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonData = mapper.writeValueAsString(response.getData());
                Tbdhoso12 tbdhoso12 = mapper.readValue(jsonData, Tbdhoso12.class);
                //to be define

                if (tbdhoso12 != null && tbdhoso12.getFiMaHoso() != null && !"".equals(tbdhoso12.getFiMaHoso())) {
                    if (tbdhoso12.getFiLoaiDon().equals(Constants12.TYPE_INSPECTION.MIEN_KIEM_TRA)) {
                        documentType = Constants.MARD_PRO.MARD12_01;
                    } else if (tbdhoso12.getFiLoaiDon().equals(Constants12.TYPE_INSPECTION.GIAM_KIEM_TRA)) {
                        documentType = Constants.MARD_PRO.MARD12_02;
                    }
                    header = envelopeService.createSendHeader(tbdhoso12.getFiMaHoso(), documentType,
                            sendMessage.getType(), sendMessage.getFunction());
                    switch (sendMessage.getType()) {
                        case Constants12.BNN12_TYPE.TYPE_10:
                            if (Constants12.BNN12_FUNCTION.FUNCTION_01.equals(sendMessage.getFunction())) {
                                content.setTbdhoso12(tbdhoso12);
                                body = envelopeService.createBody(content);
                                envelopeSend = envelopeService.createResponse(header, body);
                                if (sendMessage.getGetXmlNotSend() != null && "true".equals(sendMessage.getGetXmlNotSend())) {
                                    String xml = convertXmlService.ObjectToXml(envelopeSend);
                                    return createResponse(xml, true, errorMessage, httpStatus, null);
                                }
                                isSuccess = send(envelopeSend, sendMessage.getSignedXml(), tbdhoso12.getFiMaHoso(), documentType,
                                        sendMessage.getType(), sendMessage.getFunction());
                                if (isSuccess) {
                                    Tbdlichsu12 objLichSu = updateTrangThaiHoSo(tbdhoso12);
                                    json = receiveEndpoint12.callResforEntity(
                                            environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants12.RES_URI.URI_LICHSU_RESPONSE,
                                            objLichSu, Constants.RES_METHOD.POST);
                                    isSuccess = json.isSuccess();
                                }
                            }
                            break;

                        default:
                            break;
                    }
                }
            }

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        if (!isSuccess) {
            List<Error12> errors;
            if (envelopeSend != null) {
                errors = envelopeSend.getBody().getContent().getErrorList();
                if (errors != null) {
                    errorMessage = errors.get(0).getErrorName();
                }
            }
        }

        return createResponse(null, isSuccess, errorMessage, httpStatus, null);
    }

    @SuppressWarnings("rawtypes")
    public ResponseJson getData(String url) {
        ResponseJson responJson = null;
        try {
            URI UPLOAD_URL = new URI(url);
            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(Charset.forName("UTF8"));
            restTemplate.getMessageConverters().add(formConverter);
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity responseEntity = restTemplate.getForEntity(UPLOAD_URL, ResponseJson.class);
            responJson = (ResponseJson) responseEntity.getBody();
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }

        return responJson;
    }

    @SuppressWarnings("rawtypes")
    public ResponseEntity<ResponseJson> createResponse(List lstResult, boolean isSuccess, String errorMessage,
            HttpStatus httpStatus, Long total) {
        ResponseJson objResponse = new ResponseJson();
        objResponse.setData(lstResult);
        if (total == null) {
            total = lstResult != null ? Long.valueOf(lstResult.size()) : 0L;
        }
        objResponse.setTotal(total);
        objResponse.setSuccess(isSuccess);
        objResponse.setMessage(errorMessage);
        return new ResponseEntity<>(objResponse, httpStatus);
    }

    public ResponseEntity<ResponseJson> createResponse(Object obj, boolean isSuccess, String errorMessage,
            HttpStatus httpStatus, Long total) {
        ResponseJson objResponse = new ResponseJson();
        objResponse.setData(obj);
        objResponse.setTotal(total);
        objResponse.setSuccess(isSuccess);
        objResponse.setMessage(errorMessage);
        return new ResponseEntity<>(objResponse, httpStatus);
    }

    private boolean send(Envelope12 envelopeSend, String signedXml, String fiMaHoSo, String documentType, String msgType, String msgFunc) {
        Boolean isSuccess = false;
        String xml;

        String debugMode = environment.getProperty("DEBUG_MODE");
        logger.info("debugMode:" + debugMode);
        if ("true".equals(debugMode)) {
            xml = convertXmlService.ObjectToXml(envelopeSend);
            writeFileMsg(xml, msgType, msgFunc, fiMaHoSo, false);
            isSuccess = true;
            return isSuccess;
        }

        
        if (signedXml == null || ("".equals(signedXml))) {
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

        Envelope12 envl;
        Error12 error;

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

            SOAPMessage soapResponse = soapConnection.call(soapMessage, url);

            responseStr = SoapHelper.getSOAPResponse(soapResponse);
            soapConnection.close();
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

            error = envelopeService.createError(Constants.ERROR.ERR01_CODE, Constants.ERROR.ERR01);
            envl = envelopeService.createEnvelopeError(fiMaHoSo, documentType, msgType, error);
            responseStr = envl.toString();
        }

        if ("true".equals(isEncrypt)) {
            String key = environment.getProperty("KEY_AES");
            xml = encryptService.decrypt(key, responseStr);
        } else {
            xml = responseStr;
        }

        Envelope12 envelopeReturn = convertXmlService.xmlToEnvelope(xml, Envelope12.class);

        if (checkTypeReturn(envelopeReturn)) {
            isSuccess = true;
        } else {
            if (envelopeReturn != null) {
                List<Error12> errors = envelopeReturn.getBody().getContent().getErrorList();
                envelopeSend.getBody().getContent().setErrorList(errors);
            }
        }
        return isSuccess;
    }

    private boolean checkTypeReturn(Envelope12 envelopeReturn) {
        return envelopeReturn != null && envelopeReturn.getHeader() != null
                && envelopeReturn.getHeader().getSubject() != null && Constants12.BNN12_FUNCTION.FUNCTION_99
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
            LogUtil.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return null;
    }

    private Tbdlichsu12 createLichsu(Tbdhoso12 hoso, Long status, String noidung) {
        Tbdlichsu12 obj = new Tbdlichsu12();
        obj.setFiMaHoso(hoso.getFiMaHoso());
        obj.setFiIdHoso(hoso.getFiIdHoso());
        obj.setFiTenNggui(hoso.getFiTenDn());
        obj.setFiTenDvgui(Constants.DONVI.NSW);
        obj.setFiNoidung(noidung);
        obj.setFiTrangthai(status);
        obj.setFiTenTt(noidung);
        obj.setFiNgaytao(new Date());
        return obj;

    }

    private Tbdlichsu12 updateTrangThaiHoSo(Tbdhoso12 tbdHoso) {
        Tbdlichsu12 objLichsu = null;
        if (Constants12.FILE_STATUS.TAO_MOI.equals(tbdHoso.getFiTrangthai())
                || Constants12.FILE_STATUS.CHO_TIEP_NHAN.equals(tbdHoso.getFiTrangthai())) {
            objLichsu = createLichsu(tbdHoso, Constants12.FILE_STATUS.CHO_TIEP_NHAN,
                    Constants12.FILE_STATUS.CHO_TIEP_NHAN_STR);
        }
        return objLichsu;
    }
    
    private void writeFileMsg(String xml, String msgType, String msgFunc, String fiMaHoSo, boolean isResponse) {
        String dirName = environment.getProperty("DEBUG_FOLDER_MSG_OUTPUT");
        File theDir = new File(dirName);

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            try {
                theDir.mkdir();
            } catch (SecurityException e) {
                LogUtil.addLog(e);
                logger.info(e.getMessage());
            }
        }

        BufferedWriter writer = null;
        try {
            String fileName;
            if (isResponse == false) {
                fileName = dirName + fiMaHoSo + "_" + msgType + "_" + msgFunc + ".xml";
            } else {
                fileName = dirName + fiMaHoSo + "_" + msgType + "_" + msgFunc + "_response.xml";
            }

            writer = new BufferedWriter(new FileWriter(fileName));
//            logger.info("fileName: " + fileName + "\nxml: " + xml);
            writer.write(xml);
        } catch (IOException e) {
            LogUtil.addLog(e);
            logger.info(e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    LogUtil.addLog(e);
                    logger.info(e.getMessage());
                }
            }
        }
    }

}
