package com.vnsw.ws.p1.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.service.EncryptService;
import com.vnsw.ws.common.service.EnvelopXmlService;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.JsonHelper;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.helper.SoapHelper;
import com.vnsw.ws.p1.common.Constants01;
import com.vnsw.ws.p1.entity.json.SendMessage;
import com.vnsw.ws.p1.entity.send.AnimailProduct;
import com.vnsw.ws.p1.entity.send.Animal;
import com.vnsw.ws.p1.evelop.*;
import com.vnsw.ws.p1.message.send.*;
import com.vnsw.ws.p1.service.BackendService01;
import com.vnsw.ws.p1.service.EnvelopeService01;
import com.vnsw.ws.util.Constants;
import com.vnsw.ws.util.LogUtil;
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

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.vnsw.ws.helper.JsonHelper.createResponse;

@RestController
@RequestMapping("/send/01")
public class SendController01 {
    public static final Logger logger = LoggerFactory.getLogger(SendController01.class);
    private static final String CLASS_NAME = "SendController01";

    @Autowired
    private Environment environment;

    @Autowired
    private EnvelopXmlService convertXmlService;

    @Autowired
    EnvelopeService01 envelopeService;

    @Autowired
    private EncryptService encryptService;

    private final SimpleDateFormat formatterDateTime = new SimpleDateFormat(Constants.XML_DATETIME_FORMAT);

    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    BackendService01 backendService;

    /**
     * Gui moi ho so; gui sua ho so; rut ho so; nop phi; xin sua Chung nhan
     *
     * @param sendMessage
     * @return
     */
    @RequestMapping(value = "/sendAll", method = RequestMethod.POST)
    public ResponseEntity<ResponseJson> sendAll(@RequestBody SendMessage sendMessage) {
        HttpStatus httpStatus = null;
        String errorMessage = "";
        boolean isSuccess = false;
        httpStatus = HttpStatus.OK;
        Envelope01 envelopeSend = null;
        Header01 header = null;
        Body01 body = null;
        Content01 content = new Content01();
        ResponseJson objReturn = null;

        try {
            // Goi den backend theo IdHoSo de dong goi ban tin gui di
            Long fiIdHoso = sendMessage.getFiIdHoso();
            String maHoso = sendMessage.getFiMaHoso();
            String nowStr = formatterDateTime.format(new Date());
            String url = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants01.RES_URI.URI_GET_HS_BY_ID + fiIdHoso;
            ResponseJson response = backendService.getDataFromRestUri(url);
            String isTest = environment.getRequiredProperty("IS_TEST");
            Long fileStatus;
            if (response != null && response.isSuccess()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonData = mapper.writeValueAsString(response.getData());
                Hoso01 hoso01 = mapper.readValue(jsonData, Hoso01.class);
                if (hoso01.getFiAnimalList().size() == 0)
                    hoso01.setFiAnimalList(null);
                if (hoso01.getFiTestList().size() == 0)
                    hoso01.setFiTestList(null);
                if (hoso01.getFiAttachmentList().size() == 0)
                    hoso01.setFiAttachmentList(null);
                if(hoso01.getFiVaccinList().size() == 0)
                    hoso01.setFiVaccinList(null);
                if (hoso01.getFiAnimalProductList().size() == 0)
                    hoso01.setFiAnimalProductList(null);

                hoso01.setFiRegistrationNo(maHoso);

                List<AnimailProduct> animailProductList = hoso01.getFiAnimalProductList();
                if (animailProductList != null) {
                    animailProductList.forEach(animailProduct01 -> {
                        animailProduct01.setFiAnimalProductID(String.valueOf(animailProduct01.getFiIdAnimailProduct()));
                    });
                }

                hoso01.setFiAnimalProductList(animailProductList);

                List<Animal> animalList = hoso01.getFiAnimalList();
                if(animalList != null){
                    animalList.forEach(animal -> animal.setFiID(String.valueOf(animal.getFiIdAnimail())));
                }

                hoso01.setFiAnimalList(animalList);

                if (hoso01 != null) {
                    header = envelopeService.createSendHeader(
                            maHoso,
                            Constants.MARD_PRO.MARD01,
                            sendMessage.getType(),
                            sendMessage.getFunction(),
                            "CTY");
                    switch (sendMessage.getType()) {
                        // doanh nghiep gui hoso
                        case Constants01.MARD01_TYPE.TYPE_10:

                            content.setHoso01(hoso01);
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
                        // Doanh nghiệp xin rút hồ sơ (khi BNN chưa xử lý)
                        case Constants01.MARD01_TYPE.TYPE_11:
                            XinHuyHoSo01ChuaTiepNhan xinHuyHoSo01ChuaTiepNhan = new XinHuyHoSo01ChuaTiepNhan();
                            xinHuyHoSo01ChuaTiepNhan.setFiReason(sendMessage.getFiReason());
                            xinHuyHoSo01ChuaTiepNhan.setFiRequestDate(new Date());
                            xinHuyHoSo01ChuaTiepNhan.setFiNSWFileCode(maHoso);
                            content.setXinHuyHoSo01ChuaTiepNhan(xinHuyHoSo01ChuaTiepNhan);
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

                            // Sửa hồ sơ (khi BNN chưa cấp GCN)
                        case Constants01.MARD01_TYPE.TYPE_14:
                            XinSuaHoSo01ChuaCNKD xinSuaHoSo01ChuaCNKD = new XinSuaHoSo01ChuaCNKD();
                            xinSuaHoSo01ChuaCNKD.setFiReason(sendMessage.getFiReason());
                            xinSuaHoSo01ChuaCNKD.setFiRegistrationProfile(hoso01);
                            xinSuaHoSo01ChuaCNKD.setFiRequestDate(new Date());
                            content.setXinSuaHoSo01ChuaCNKD(xinSuaHoSo01ChuaCNKD);
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
                            break;

                        // doanh nghiệp xin rút hồ sơ khi đã tiếp nhận
                        case Constants01.MARD01_TYPE.TYPE_16:
                            XinHuyHoSo01 xinHuyHoSo01 = new XinHuyHoSo01();
                            xinHuyHoSo01.setFiReason(sendMessage.getFiReason());
                            xinHuyHoSo01.setFiNSWFileCode(sendMessage.getFiNSWFileCode());
                            xinHuyHoSo01.setFiRequestDate(new Date());
                            content.setXinHuyHoSo01(xinHuyHoSo01);
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

                        // Doanh nghiệp yêu cầu xin hủy giấy CNKD
                        case Constants01.MARD01_TYPE.TYPE_27:
                            DNXinHuyCNKD huyCNKD = new DNXinHuyCNKD();
                            huyCNKD.setFiReason(sendMessage.getFiReason());
                            huyCNKD.setFiNSWFileCode(sendMessage.getFiNSWFileCode());
                            huyCNKD.setFiRequestDate(new Date());
                            content.setDnXinHuyCNKD(huyCNKD);
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

                        // Doanh nghiệp yêu cầu xin sửa giấy CNKD
                        case Constants01.MARD01_TYPE.TYPE_29:
                            DNXinSuaCNKD suaCNKD = new DNXinSuaCNKD();
                            suaCNKD.setFiReason(sendMessage.getFiReason());
                            suaCNKD.setFiNSWFileCode(sendMessage.getFiNSWFileCode());
                            suaCNKD.setFiRequestDate(new Date());
                            suaCNKD.setFiFileAttack(sendMessage.getFiFileAttack());
                            suaCNKD.setFiFileName(sendMessage.getFiFileName());
                            content.setDnXinSuaCNKD(suaCNKD);
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
    private ResponseJson send(Envelope01 envelopeSend, String signedXml, String fiMaHoSo, String msgType) {
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

        Envelope01 envl;
        Error01 error;

        String documentType = Constants.MARD_PRO.MARD01;
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
            logger.error("REQ: " + xml);
            SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
            responseStr = SoapHelper.getSOAPResponse(soapResponse);
            logger.error("RES: " + responseStr);
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

        Envelope01 envelopeReturn = convertXmlService.xmlToEnvelope(xml, Envelope01.class);
        if (envelopeReturn != null) {
            if (checkTypeReturn(envelopeReturn)) {
                isSuccess = true;
            } else {
                Envelope01Err err01Envelope = convertXmlService.xmlToEnvelope(xml, Envelope01Err.class);
                List<Error01> errors = envelopeReturn.getBody().getContent().getErrorList();
                String strErrors = err01Envelope.getBody().getContent();
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

    private boolean checkTypeReturn(Envelope01 envelopeReturn) {
        return envelopeReturn != null && envelopeReturn.getHeader() != null
                && envelopeReturn.getHeader().getSubject() != null && Constants01.MARD01_FUNCTION.FUNCTION_99
                .equals(envelopeReturn.getHeader().getSubject().getFunction());
    }

}
