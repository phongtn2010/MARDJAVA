/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.envelop.Header;
import com.vnsw.ws.common.entity.json.SendMessage;
import com.vnsw.ws.common.service.EncryptService;
import com.vnsw.ws.common.service.EnvelopXmlService;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.helper.SoapHelper;
import com.vnsw.ws.p04.envelop.Content;
import com.vnsw.ws.p04.envelop.Envelope;
import com.vnsw.ws.p04.service.EnvelopeService;
import com.vnsw.ws.p04.common.Constants04;
import com.vnsw.ws.p04.entity.TbdLichsu04;
import com.vnsw.ws.p04.envelop.Body;
import com.vnsw.ws.p04.message.send.DNYeucauRut;
import com.vnsw.ws.p04.message.send.DNYeucauSua;
import com.vnsw.ws.p04.message.send.DNYeucauSuaXNCL;
import com.vnsw.ws.p04.message.send.TbdRegistrationProfile04;
import com.vnsw.ws.p04.message.send.TbdThongbaoThanhtoan;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.vnsw.ws.p04.service.ReceiveService04;

@RestController
@RequestMapping("/send/04")
public class Send04Controller {

    public static final Logger logger = LoggerFactory.getLogger(Send04Controller.class);
    private static final String CLASS_NAME = "Send04Controller";

    @Autowired
    private Environment environment;

    @Autowired
    private EnvelopXmlService convertXmlService;

    @Autowired
    private EncryptService encryptService;

    @Autowired
    private EnvelopeService envelopeService;

    @Autowired
    ReceiveService04 receiveEndpoint02;

    @Autowired
    RabbitMQService rabbitMQService;

    @RequestMapping(value = "/sendAll/", method = RequestMethod.POST)
    public ResponseEntity<ResponseJson> sendAll(@RequestBody SendMessage sendMessage) {
        HttpStatus httpStatus = HttpStatus.OK;
        String errorMessage = "";
        boolean isSuccess = false;

        Envelope envelopeSend = null;
        Header header;
        Body body;
        Content content = new Content();

        try {
            Long fiIdHoso = sendMessage.getFiIdHoso();
            String url = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants04.RES_URI.URL_GET_HOSO + fiIdHoso;
            ResponseJson response = getData(url);
            ResponseJson json;

            if (response != null && response.isSuccess()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonData = mapper.writeValueAsString(response.getData());
                TbdRegistrationProfile04 tbdhoso4 = mapper.readValue(jsonData, TbdRegistrationProfile04.class);
                //to be define

                if (tbdhoso4 != null && tbdhoso4.getNswfileCode() != null && !"".equals(tbdhoso4.getNswfileCode())) {
                    header = envelopeService.createSendHeader(tbdhoso4.getNswfileCode(), Constants.MARD_PRO.MARD_04,
                            sendMessage.getType(), sendMessage.getFunction(), tbdhoso4.getNswfileCode());
                    switch (sendMessage.getType()) {
                        case Constants04.MARD04_TYPE.TYPE_10:
                            if (Constants04.MARD04_FUNCTION.FUNCTION_01.equals(sendMessage.getFunction())
                                    || Constants04.MARD04_FUNCTION.FUNCTION_02.equals(sendMessage.getFunction())
                                    || Constants04.MARD04_FUNCTION.FUNCTION_04.equals(sendMessage.getFunction())) {
                                setTbdRegistrationProfile04(content, tbdhoso4);
                                body = envelopeService.createBody(content);
                                envelopeSend = envelopeService.createResponse(header, body);
                                if (sendMessage.getGetXmlNotSend() != null && "true".equals(sendMessage.getGetXmlNotSend())) {
                                    String xml = convertXmlService.ObjectToXml(envelopeSend);
                                    return createResponse(xml, true, errorMessage, httpStatus, null);
                                }
                                isSuccess = send(envelopeSend, sendMessage.getSignedXml(), tbdhoso4.getNswfileCode(), Constants.MARD_PRO.MARD_04,
                                        sendMessage.getType(), sendMessage.getFunction());
                                if (isSuccess) {
                                    TbdLichsu04 objLichSu = updateTrangThaiHoSo(tbdhoso4);
                                    json = receiveEndpoint02.callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants04.RES_URI.URI_LICHSU_RESPONSE,
                                            objLichSu, Constants.RES_METHOD.POST);
                                    isSuccess = json.isSuccess();
                                }
                            }
                            break;
                        case Constants04.MARD04_TYPE.TYPE_15:
                            if (Constants04.MARD04_FUNCTION.FUNCTION_03.equals(sendMessage.getFunction())) {
                                DNYeucauRut ycRut = new DNYeucauRut();
                                ycRut.setReason(sendMessage.getReason());
                                ycRut.setRequestDate(new Date());
                                ycRut.setNSWFileCode(sendMessage.getFiMaHoso());

                                content.setdNYeucauRut(ycRut);
                                body = envelopeService.createBody(content);
                                envelopeSend = envelopeService.createResponse(header, body);
                                if (sendMessage.getGetXmlNotSend() != null && "true".equals(sendMessage.getGetXmlNotSend())) {
                                    String xml = convertXmlService.ObjectToXml(envelopeSend);
                                    return createResponse(xml, true, errorMessage, httpStatus, null);
                                }
                                isSuccess = send(envelopeSend, sendMessage.getSignedXml(), tbdhoso4.getNswfileCode(), Constants.MARD_PRO.MARD_04,
                                        sendMessage.getType(), sendMessage.getFunction());
                                if (isSuccess) {
                                    TbdLichsu04 objLichSu = null;

                                    objLichSu = createLichSuXinRutThang(tbdhoso4, ycRut);

                                    json = receiveEndpoint02.callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants04.RES_URI.URI_LICHSU_RESPONSE,
                                            objLichSu, Constants.RES_METHOD.POST);
                                    isSuccess = json.isSuccess();
                                }
                            }
                            break;
                        case Constants04.MARD04_TYPE.TYPE_16:
                            if (Constants04.MARD04_FUNCTION.FUNCTION_11.equals(sendMessage.getFunction())) {
                                DNYeucauRut ycRut = new DNYeucauRut();
                                ycRut.setReason(sendMessage.getReason());
                                ycRut.setRequestDate(new Date());
                                ycRut.setNSWFileCode(sendMessage.getFiMaHoso());
                                content.setdNYeucauRut(ycRut);
                                body = envelopeService.createBody(content);
                                envelopeSend = envelopeService.createResponse(header, body);
                                if (sendMessage.getGetXmlNotSend() != null && "true".equals(sendMessage.getGetXmlNotSend())) {
                                    String xml = convertXmlService.ObjectToXml(envelopeSend);
                                    return createResponse(xml, true, errorMessage, httpStatus, null);
                                }
                                isSuccess = send(envelopeSend, sendMessage.getSignedXml(), tbdhoso4.getNswfileCode(), Constants.MARD_PRO.MARD_04,
                                        sendMessage.getType(), sendMessage.getFunction());
                                if (isSuccess) {
                                    TbdLichsu04 objLichSu = null;

                                    objLichSu = createLichSuXinRutSendWs(tbdhoso4, ycRut);

                                    json = receiveEndpoint02.callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants04.RES_URI.URI_LICHSU_RESPONSE,
                                            objLichSu, Constants.RES_METHOD.POST);
                                    isSuccess = json.isSuccess();
                                }
                            }
                            break;
                        case Constants04.MARD04_TYPE.TYPE_13:
                            if (Constants04.MARD04_FUNCTION.FUNCTION_08.equals(sendMessage.getFunction())) {
                                DNYeucauSua ycSua = new DNYeucauSua();
                                ycSua.setReason(sendMessage.getReason());
                                ycSua.setRequestDate(new Date());
                                ycSua.setRegistrationProfile04(tbdhoso4);
                                content.setDNYeucauSua(ycSua);
                                body = envelopeService.createBody(content);
                                envelopeSend = envelopeService.createResponse(header, body);
                                if (sendMessage.getGetXmlNotSend() != null && "true".equals(sendMessage.getGetXmlNotSend())) {
                                    String xml = convertXmlService.ObjectToXml(envelopeSend);
                                    return createResponse(xml, true, errorMessage, httpStatus, null);
                                }
                                isSuccess = send(envelopeSend, sendMessage.getSignedXml(), tbdhoso4.getNswfileCode(), Constants.MARD_PRO.MARD_04,
                                        sendMessage.getType(), sendMessage.getFunction());
                                if (isSuccess) {
                                    TbdLichsu04 objLichSu = null;

                                    objLichSu = createLichSuXinSua(tbdhoso4, ycSua);

                                    json = receiveEndpoint02.callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants04.RES_URI.URI_LICHSU_RESPONSE,
                                            objLichSu, Constants.RES_METHOD.POST);
                                    isSuccess = json.isSuccess();
                                }
                            }
                            break;
                        case Constants04.MARD04_TYPE.TYPE_23:
                            if (Constants04.MARD04_FUNCTION.FUNCTION_21.equals(sendMessage.getFunction())||
                                    Constants04.MARD04_FUNCTION.FUNCTION_22.equals(sendMessage.getFunction())||
                                    Constants04.MARD04_FUNCTION.FUNCTION_24.equals(sendMessage.getFunction())) {
                                TbdThongbaoThanhtoan tbdThongbaoThanhtoan = sendMessage.getTbdThongbaoThanhtoan();
                                 content.setTbdThongbaoThanhtoan(tbdThongbaoThanhtoan);
                                body = envelopeService.createBody(content);
                                envelopeSend = envelopeService.createResponse(header, body);
                                if (sendMessage.getGetXmlNotSend() != null && "true".equals(sendMessage.getGetXmlNotSend())) {
                                    String xml = convertXmlService.ObjectToXml(envelopeSend);
                                    return createResponse(xml, true, errorMessage, httpStatus, null);
                                }
                                isSuccess = send(envelopeSend, sendMessage.getSignedXml(), tbdhoso4.getNswfileCode(), Constants.MARD_PRO.MARD_04,
                                        sendMessage.getType(), sendMessage.getFunction());
                                if (isSuccess) {
                                    TbdLichsu04 objLichSu = null;

                                    objLichSu = createLichSuThanhToanPhi(tbdhoso4, tbdThongbaoThanhtoan, sendMessage);

                                    json = receiveEndpoint02.callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants04.RES_URI.URI_LICHSU_RESPONSE,
                                            objLichSu, Constants.RES_METHOD.POST);
                                    isSuccess = json.isSuccess();
                                }
                            }
                            break;
                        case Constants04.MARD04_TYPE.TYPE_25:
                            if (Constants04.MARD04_FUNCTION.FUNCTION_25.equals(sendMessage.getFunction())) {
                                DNYeucauSuaXNCL ycSuaXNCL = new DNYeucauSuaXNCL();
                                ycSuaXNCL.setReason(sendMessage.getReason());
                                ycSuaXNCL.setRequestDate(new Date());
                                ycSuaXNCL.setNswFilecode(sendMessage.getFiMaHoso());
                                ycSuaXNCL.setRegistrationProfile04(tbdhoso4);
                                content.setdNYeucauSuaXNCL(ycSuaXNCL);
                                body = envelopeService.createBody(content);
                                envelopeSend = envelopeService.createResponse(header, body);
                                if (sendMessage.getGetXmlNotSend() != null && "true".equals(sendMessage.getGetXmlNotSend())) {
                                    String xml = convertXmlService.ObjectToXml(envelopeSend);
                                    return createResponse(xml, true, errorMessage, httpStatus, null);
                                }
                                isSuccess = send(envelopeSend, sendMessage.getSignedXml(), tbdhoso4.getNswfileCode(), Constants.MARD_PRO.MARD_04,
                                        sendMessage.getType(), sendMessage.getFunction());
                                if (isSuccess) {
                                    TbdLichsu04 objLichSu = null;

                                    objLichSu = createLichSuXinSuaXNCL(tbdhoso4, ycSuaXNCL);

                                    json = receiveEndpoint02.callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants04.RES_URI.URI_LICHSU_RESPONSE,
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
            List<com.vnsw.ws.common.envelop.Error> errors;
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

    private boolean send(Envelope envelopeSend, String signedXml, String fiMaHoSo, String documentType, String msgType, String msgFunc) {
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
            writeFileMsg(xml, msgType, msgFunc, fiMaHoSo, false);
        } else {
            xml = signedXml;
        }

        String isEncrypt = environment.getProperty("ENCRYPT");
        if ("true".equals(isEncrypt)) {
            String key = environment.getProperty("KEY_AES");
            xml = encryptService.encrypt(key, xml);
        }

        String responseStr = "";

        Envelope envl;
        com.vnsw.ws.common.envelop.Error error;

        String officeCode = Constants.BNNPTNT;

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

        //log response msg
        writeFileMsg(responseStr, msgType, msgFunc, fiMaHoSo, true);

        if ("true".equals(isEncrypt)) {
            String key = environment.getProperty("KEY_AES");
            xml = encryptService.decrypt(key, responseStr);
        } else {
            xml = responseStr;
        }

        Envelope envelopeReturn = convertXmlService.xmlToEnvelope(xml, Envelope.class);

        if (checkTypeReturn(envelopeReturn)) {
            isSuccess = true;
        } else if (envelopeReturn != null) {
            List<com.vnsw.ws.common.envelop.Error> errors = envelopeReturn.getBody().getContent().getErrorList();
            envelopeSend.getBody().getContent().setErrorList(errors);
        }
        return isSuccess;
    }

    private boolean checkTypeReturn(Envelope envelopeReturn) {
        return envelopeReturn != null && envelopeReturn.getHeader() != null
                && envelopeReturn.getHeader().getSubject() != null && Constants04.MARD04_FUNCTION.FUNCTION_99
                .equals(envelopeReturn.getHeader().getSubject().getFunction());
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
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    LogUtil.addLog(e);
                }
            }
        }
    }

    private void setTbdRegistrationProfile04(Content content, TbdRegistrationProfile04 tbdhoso4) {
        Gson gson = new Gson();
        TbdRegistrationProfile04 tbdRegistrationProfile04 = gson.fromJson(gson.toJson(tbdhoso4), TbdRegistrationProfile04.class);
        tbdRegistrationProfile04.setSeller("");
        tbdRegistrationProfile04.setBuyer("");
        tbdRegistrationProfile04.setSignDate(new Date());
        content.setTbdRegistrationProfile04(tbdRegistrationProfile04);
    }

    private TbdLichsu04 updateTrangThaiHoSo(TbdRegistrationProfile04 tbdhoso4) {
        TbdLichsu04 objLichsu = null;
        if (Constants04.FILE_STATUS.TAO_MOI.equals(tbdhoso4.getCodeStatus())
                || Constants04.FILE_STATUS.CHO_TIEP_NHAN.equals(tbdhoso4.getCodeStatus())) {
            objLichsu = createLichsu(tbdhoso4, Constants04.FILE_STATUS.CHO_TIEP_NHAN,
                    Constants04.FILE_STATUS.CHO_TIEP_NHAN_STR);
        } else if (Constants04.FILE_STATUS.YC_BOSUNG_HS.equals(tbdhoso4.getCodeStatus())) {
            objLichsu = createLichsu(tbdhoso4, Constants04.FILE_STATUS.DA_BOSUNG_HS,
                    Constants04.FILE_STATUS.DA_BOSUNG_HS_STR);
        } else if (Constants04.FILE_STATUS.YC_BOSUNG_HS.equals(tbdhoso4.getCodeStatus())) {
            objLichsu = createLichsu(tbdhoso4, Constants04.FILE_STATUS.DA_BOSUNG_HS,
                    Constants04.FILE_STATUS.DA_BOSUNG_HS_STR);
        }
        return objLichsu;
    }

    private TbdLichsu04 createLichsu(TbdRegistrationProfile04 hoso, Long codeStatus, String nameStatus) {
        TbdLichsu04 obj = new TbdLichsu04();
        obj.setFiMaHoso(hoso.getNswfileCode());
        obj.setFiIdHoso(hoso.getRegistrationProfileId());
        obj.setFiTenTrangthai(nameStatus);
        obj.setFiDonviXuly(Constants04.DONVI.NSW);
        obj.setFiTrangthai(codeStatus);
        obj.setFiNgaytao(new Date());
        obj.setFiNoidung(nameStatus);
        return obj;
    }

    private TbdLichsu04 createLichSuXinRutThang(TbdRegistrationProfile04 tbdhoso4, DNYeucauRut ycRut) {
        TbdLichsu04 obj = createLichsu(tbdhoso4, Constants04.FILE_STATUS.RUT_HS, Constants04.FILE_STATUS.RUT_HS_STR);
        return obj;
    }

    private TbdLichsu04 createLichSuXinRutSendWs(TbdRegistrationProfile04 tbdhoso4, DNYeucauRut ycRut) {
        TbdLichsu04 obj = createLichsu(tbdhoso4, Constants04.FILE_STATUS.XINRUT_HS, Constants04.FILE_STATUS.XINRUT_HS_STR);
        obj.setFiTenTrangthai(Constants04.FILE_STATUS.XINRUT_HS_STR);
        return obj;
    }

    private TbdLichsu04 createLichSuXinSua(TbdRegistrationProfile04 tbdhoso4, DNYeucauSua ycSua) {
        TbdLichsu04 obj = createLichsu(tbdhoso4, Constants04.FILE_STATUS.XINSUA_HS, Constants04.FILE_STATUS.XINSUA_HS_STR);
        return obj;
    }

    private TbdLichsu04 createLichSuXinSuaXNCL(TbdRegistrationProfile04 tbdhoso4, DNYeucauSuaXNCL ycSuaXNCL) {
        TbdLichsu04 obj = createLichsu(tbdhoso4, Constants04.FILE_STATUS.YC_SUA_GIAY_CNKDXNCL, Constants04.FILE_STATUS.YC_SUA_GIAY_CNKDXNCL_STR);
        return obj;
    }

    private TbdLichsu04 createLichSuThanhToanPhi(TbdRegistrationProfile04 tbdhoso4, TbdThongbaoThanhtoan tbdThongbaoThanhtoan, SendMessage sendMessage) {
          TbdLichsu04 objLichsu = null;
        if (Constants04.MARD04_FUNCTION.FUNCTION_21.equals(sendMessage.getFunction())) {
            objLichsu = createLichsu(tbdhoso4, Constants04.FILE_STATUS.DA_THANHTOAN_PHI_ONL,
                    Constants04.FILE_STATUS.DA_THANHTOAN_PHI_ONL_STR);
        } else if (Constants04.MARD04_FUNCTION.FUNCTION_22.equals(sendMessage.getFunction())) {
            objLichsu = createLichsu(tbdhoso4, Constants04.FILE_STATUS.DA_THANHTOAN_PHI,
                    Constants04.FILE_STATUS.DA_THANHTOAN_PHI_STR);
        } else if (Constants04.MARD04_FUNCTION.FUNCTION_24.equals(sendMessage.getFunction())) {
            objLichsu = createLichsu(tbdhoso4, Constants04.FILE_STATUS.TB_DA_THANHTOAN_BS,
                    Constants04.FILE_STATUS.TB_DA_THANHTOAN_BS_STR);
        }
        return objLichsu;
    }

}
