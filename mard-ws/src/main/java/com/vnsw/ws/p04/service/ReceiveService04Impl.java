/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.entity.json.ResponseUpload;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.common.envelop.Error;
import com.vnsw.ws.common.envelop.Header;
import com.vnsw.ws.common.service.EnvelopXmlService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.helper.ValidateXSDHelper;
import com.vnsw.ws.p04.common.Constants04;
import com.vnsw.ws.p04.entity.TbdAnanyticalCheckedList04;
import com.vnsw.ws.p04.entity.TbdFeeResponse04;
import com.vnsw.ws.p04.entity.TbdKqxl04;
import com.vnsw.ws.p04.entity.TbdLichsu04;
import com.vnsw.ws.p04.entity.TbdPhytosanitaryDetain04;
import com.vnsw.ws.p04.entity.TbdPhytosanitaryFee04;
import com.vnsw.ws.p04.entity.TbdPhytosanitaryResult04;
import com.vnsw.ws.p04.entity.TbdQualityResult04;
import com.vnsw.ws.p04.entity.TbdRegistrationComfirm04;
import com.vnsw.ws.p04.entity.TbdRequestEdit;
import com.vnsw.ws.p04.entity.TbdRequestEditCer04;
import com.vnsw.ws.p04.entity.TbdTemporaryPhytosanitary04;
import com.vnsw.ws.p04.entity.TbdYcRut04;
import com.vnsw.ws.util.Constants;
import com.vnsw.ws.util.LogUtil;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service("ReceiveService02")
@Transactional
public class ReceiveService04Impl implements ReceiveService04 {

    public static final Logger logger = LoggerFactory.getLogger(ReceiveService04Impl.class);

    private static final String CLASS_NAME = "ReceiveService02Impl";

    @Autowired
    private EnvelopeService envelopeService;

    @Autowired
    private Environment environment;

    @Autowired
    private EnvelopXmlService convertXmlService;

    @Autowired
    RabbitMQService rabbitMQService;

    @Override
    public com.vnsw.ws.p04.envelop.Envelope receive(String xml) {
        com.vnsw.ws.p04.envelop.Envelope envelopReturn = null;
        Error error;
        String type = "00";
        String maHoso = "00";
        String errorMsg;

        Header header, headerReceive;
        com.vnsw.ws.p04.envelop.Content ct;
        String documentType = "";
        String function;
        ResponseJson json;

        try {
            //save file xml
            writeFileMsg(xml, "", "", maHoso);

            ValidateXSDHelper validator = new ValidateXSDHelper();
            com.vnsw.ws.p04.envelop.Envelope envelop = convertXmlService.xmlToEnvelope(xml, com.vnsw.ws.p04.envelop.Envelope.class);

            type = getType(envelop);
            function = getFunction(envelop);

            maHoso = envelop.getHeader().getSubject().getReference();

            headerReceive = envelop.getHeader();
            ct = envelop.getBody().getContent();
            documentType = headerReceive.getSubject().getDocumentType();

            header = envelopeService.createReceiveHeader(maHoso, documentType, type,
                    Constants.FUNCTION.FUNC_SUCCESS);

            // Validate xml
            errorMsg = validator.validateWithStringXML(xml, Constants.XSDPREFIX.MARD04 + type + function + ".xsd");
            if (null == errorMsg) {
                json = new ResponseJson();
                // switch type
                switch (type) {
                    case Constants04.MARD04_TYPE.TYPE_11:
                        TbdKqxl04 kqxl = ct.getTbdKqxl04();
                        if (kqxl != null) {
                            if (function.equals(Constants04.MARD04_FUNCTION.FUNCTION_05)
                                    || function.equals(Constants04.MARD04_FUNCTION.FUNCTION_06)) {
                                TbdKqxl04 obj = createKetquaxuly(kqxl, maHoso, function);
                                json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                        + Constants04.RES_URI.URI_KETQUA_XULY, obj, Constants.RES_METHOD.POST);
                                if (json.isSuccess()) {
                                    TbdLichsu04 objLishSu = createLichsuKetquaxuly(kqxl, maHoso, function);
                                    json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants04.RES_URI.URI_LICHSU_RESPONSE,
                                            objLishSu, Constants.RES_METHOD.POST);
                                }
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants04.MARD04_TYPE.TYPE_11, header, json);
                        } else {
                            error = new Error();
                            error.setErrorCode(Constants.ERROR.BNN04_CODE);
                            error.setErrorName(Constants.ERROR.BNN04);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, documentType, type,
                                    error);
                        }
                        break;
                    case Constants04.MARD04_TYPE.TYPE_12:

                        if (function.equals(Constants04.MARD04_FUNCTION.FUNCTION_07)) {
                            TbdRegistrationComfirm04 pheDuyetDon = ct.getTbdRegistrationComfirm04();
                            if (pheDuyetDon != null) {
                                TbdRegistrationComfirm04 obj = createXacNhanDon(pheDuyetDon, maHoso);
                                json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                        + Constants04.RES_URI.URI_XACNHAN_DON, obj, Constants.RES_METHOD.POST);
                                if (json.isSuccess()) {
                                    TbdLichsu04 objLishSu = createLichsuXacNhanDon(maHoso);
                                    json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants04.RES_URI.URI_LICHSU_RESPONSE,
                                            objLishSu, Constants.RES_METHOD.POST);
                                }
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants04.MARD04_TYPE.TYPE_12, header, json);
                        } else if (function.equals(Constants04.MARD04_FUNCTION.FUNCTION_31)) {
                            TbdAnanyticalCheckedList04 chitieuCl = ct.getTbdAnanyticalCheckedList04();
                            if (chitieuCl != null) {
                                TbdAnanyticalCheckedList04 obj = createChiTieuCl(chitieuCl, maHoso);
                                json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                        + Constants04.RES_URI.URI_CHITIEU, obj, Constants.RES_METHOD.POST);
                                if (json.isSuccess()) {
                                    TbdLichsu04 objLishSu = createLichsuChiTieuCl(maHoso);
                                    json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants04.RES_URI.URI_LICHSU_RESPONSE,
                                            objLishSu, Constants.RES_METHOD.POST);
                                }
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants04.MARD04_TYPE.TYPE_12, header, json);
                        } else {
                            error = new Error();
                            error.setErrorCode(Constants.ERROR.BNN04_CODE);
                            error.setErrorName(Constants.ERROR.BNN04);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, documentType, type,
                                    error);
                        }
                        break;
                    case Constants04.MARD04_TYPE.TYPE_14:
                        TbdRequestEdit PHycSua = ct.getTbdRequestEdit();
                        if (PHycSua != null) {
                            if (function.equals(Constants04.MARD04_FUNCTION.FUNCTION_09)
                                    || function.equals(Constants04.MARD04_FUNCTION.FUNCTION_10)) {
                                TbdRequestEdit obj = createPhanHoiYcSua(PHycSua, maHoso, function);
                                json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                        + Constants04.RES_URI.URI_PHANHOI_YC_SUA, obj, Constants.RES_METHOD.POST);
                                if (json.isSuccess()) {
                                    TbdLichsu04 objLishSu = createLichsuYcSua(PHycSua, maHoso, function);
                                    json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants04.RES_URI.URI_LICHSU_RESPONSE,
                                            objLishSu, Constants.RES_METHOD.POST);
                                }
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants04.MARD04_TYPE.TYPE_12, header, json);
                        } else {
                            error = new Error();
                            error.setErrorCode(Constants.ERROR.BNN04_CODE);
                            error.setErrorName(Constants.ERROR.BNN04);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, documentType, type,
                                    error);
                        }
                        break;
                    case Constants04.MARD04_TYPE.TYPE_17:
                        TbdYcRut04 PHYcRut = ct.getTbdYcRut04();
                        if (PHYcRut != null) {
                            if (function.equals(Constants04.MARD04_FUNCTION.FUNCTION_12)
                                    || function.equals(Constants04.MARD04_FUNCTION.FUNCTION_13)) {
                                TbdYcRut04 obj = createPhanHoiYcRut(PHYcRut, maHoso, function);
                                json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                        + Constants04.RES_URI.URI_PHANHOI_YC_RUT, obj, Constants.RES_METHOD.POST);
                                if (json.isSuccess()) {
                                    TbdLichsu04 objLishSu = createLichsuYcRut(PHYcRut, maHoso, function);
                                    json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants04.RES_URI.URI_LICHSU_RESPONSE,
                                            objLishSu, Constants.RES_METHOD.POST);
                                }
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants04.MARD04_TYPE.TYPE_12, header, json);
                        } else {
                            error = new Error();
                            error.setErrorCode(Constants.ERROR.BNN04_CODE);
                            error.setErrorName(Constants.ERROR.BNN04);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, documentType, type,
                                    error);
                        }
                        break;
                    case Constants04.MARD04_TYPE.TYPE_18:
                        TbdPhytosanitaryDetain04 giulaivaxuly = ct.getTbdPhytosanitaryDetain04();
                        if (giulaivaxuly != null) {
                            if (function.equals(Constants04.MARD04_FUNCTION.FUNCTION_14)) {
                                TbdPhytosanitaryDetain04 obj = createLenhgiulaiVaxuly(giulaivaxuly, maHoso);
                                json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                        + Constants04.RES_URI.URI_GIULAI_VA_XULY, obj, Constants.RES_METHOD.POST);
                                if (json.isSuccess()) {
                                    TbdLichsu04 objLishSu = createLichsuLenhgiulaiVaxuly(giulaivaxuly,maHoso);
                                    json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants04.RES_URI.URI_LICHSU_RESPONSE,
                                            objLishSu, Constants.RES_METHOD.POST);
                                }
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants04.MARD04_TYPE.TYPE_12, header, json);
                        } else {
                            error = new Error();
                            error.setErrorCode(Constants.ERROR.BNN04_CODE);
                            error.setErrorName(Constants.ERROR.BNN04);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, documentType, type,
                                    error);
                        }
                        break;
                    case Constants04.MARD04_TYPE.TYPE_19:
                        TbdTemporaryPhytosanitary04 tamcapKQKDTV = ct.getTbdTemporaryPhytosanitary04();
                        if (tamcapKQKDTV != null) {
                            if (function.equals(Constants04.MARD04_FUNCTION.FUNCTION_15)) {
                                TbdTemporaryPhytosanitary04 obj = createTamcapKQKDTV(tamcapKQKDTV, maHoso);
                                json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                        + Constants04.RES_URI.URI_TAMCAP_KQKDTV, obj, Constants.RES_METHOD.POST);
                                if (json.isSuccess()) {
                                    TbdLichsu04 objLishSu = createLichsuTamcapKQKDTV(tamcapKQKDTV,maHoso);
                                    json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants04.RES_URI.URI_LICHSU_RESPONSE,
                                            objLishSu, Constants.RES_METHOD.POST);
                                }
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants04.MARD04_TYPE.TYPE_19, header, json);
                        } else {
                            error = new Error();
                            error.setErrorCode(Constants.ERROR.BNN04_CODE);
                            error.setErrorName(Constants.ERROR.BNN04);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, documentType, type,
                                    error);
                        }
                        break;
                    case Constants04.MARD04_TYPE.TYPE_20:
                        TbdPhytosanitaryResult04 giayXacNhanKDTV = ct.getTbdPhytosanitaryResult04();
                        if (giayXacNhanKDTV != null) {
                            if (function.equals(Constants04.MARD04_FUNCTION.FUNCTION_16)
                                    || function.equals(Constants04.MARD04_FUNCTION.FUNCTION_17)) {
                                TbdPhytosanitaryResult04 obj = createXacNhanKDTV(giayXacNhanKDTV, maHoso);
                                json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                        + Constants04.RES_URI.URI_XACNHAN_KDTV, obj, Constants.RES_METHOD.POST);
                                if (json.isSuccess()) {
                                    TbdLichsu04 objLishSu = createLichsuXacNhanKDTV(giayXacNhanKDTV,maHoso);
                                    json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants04.RES_URI.URI_LICHSU_RESPONSE,
                                            objLishSu, Constants.RES_METHOD.POST);
                                }
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants04.MARD04_TYPE.TYPE_12, header, json);
                        } else {
                            error = new Error();
                            error.setErrorCode(Constants.ERROR.BNN04_CODE);
                            error.setErrorName(Constants.ERROR.BNN04);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, documentType, type,
                                    error);
                        }
                        break;
                    case Constants04.MARD04_TYPE.TYPE_21:
                        TbdQualityResult04 xacNhanChatLuong = ct.getTbdQualityResult04();
                        if (xacNhanChatLuong != null) {
                            if (function.equals(Constants04.MARD04_FUNCTION.FUNCTION_18)
                                    || function.equals(Constants04.MARD04_FUNCTION.FUNCTION_19)) {
                                TbdQualityResult04 obj = createXacNhanChatLuong(xacNhanChatLuong, maHoso);
                                json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                        + Constants04.RES_URI.URI_XACNHAN_CHATLUONG, obj, Constants.RES_METHOD.POST);
                                if (json.isSuccess()) {
                                    TbdLichsu04 objLishSu = createLichSuXacNhanChatLuong(xacNhanChatLuong,maHoso);
                                    json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants04.RES_URI.URI_LICHSU_RESPONSE,
                                            objLishSu, Constants.RES_METHOD.POST);
                                }
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants04.MARD04_TYPE.TYPE_12, header, json);
                        } else {
                            error = new Error();
                            error.setErrorCode(Constants.ERROR.BNN04_CODE);
                            error.setErrorName(Constants.ERROR.BNN04);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, documentType, type,
                                    error);
                        }
                        break;
                    case Constants04.MARD04_TYPE.TYPE_22:
                        TbdPhytosanitaryFee04 TBphi = ct.getTbdPhytosanitaryFee04();
                        if (TBphi != null) {
                            if (function.equals(Constants04.MARD04_FUNCTION.FUNCTION_20)) {
                                TbdPhytosanitaryFee04 obj = createThongBaoPhi(TBphi, maHoso);
                                json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                        + Constants04.RES_URI.URI_THONGBAO_PHI, obj, Constants.RES_METHOD.POST);
                                if (json.isSuccess()) {
                                    TbdLichsu04 objLishSu = createLichSuThongBaoPhi(maHoso);
                                    json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants04.RES_URI.URI_LICHSU_RESPONSE,
                                            objLishSu, Constants.RES_METHOD.POST);
                                }
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants04.MARD04_TYPE.TYPE_12, header, json);
                        } else {
                            error = new Error();
                            error.setErrorCode(Constants.ERROR.BNN04_CODE);
                            error.setErrorName(Constants.ERROR.BNN04);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, documentType, type,
                                    error);
                        }
                        break;
                    case Constants04.MARD04_TYPE.TYPE_25:
                        TbdRequestEditCer04 PHyeucauSuaXNCL = ct.getTbdRequestEditCer04();
                        if (PHyeucauSuaXNCL != null) {
                            if (function.equals(Constants04.MARD04_FUNCTION.FUNCTION_30)) {
                                TbdRequestEditCer04 obj = createPHyeucauSuaXNCL(PHyeucauSuaXNCL, maHoso);
                                json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                        + Constants04.RES_URI.URI_PH_YEUCAU_SUA_XNCL, obj, Constants.RES_METHOD.POST);
                                if (json.isSuccess()) {
                                    TbdLichsu04 objLishSu = createLichSuPHyeucauSuaXNCL(PHyeucauSuaXNCL, maHoso);
                                    json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants04.RES_URI.URI_LICHSU_RESPONSE,
                                            objLishSu, Constants.RES_METHOD.POST);
                                }
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants04.MARD04_TYPE.TYPE_12, header, json);
                        } else {
                            error = new Error();
                            error.setErrorCode(Constants.ERROR.BNN04_CODE);
                            error.setErrorName(Constants.ERROR.BNN04);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, documentType, type,
                                    error);
                        }
                        break;
                    case Constants04.MARD04_TYPE.TYPE_24:
                        TbdFeeResponse04 xacNhanPhi = ct.getTbdFeeResponse04();
                        if (xacNhanPhi != null) {
                            if (function.equals(Constants04.MARD04_FUNCTION.FUNCTION_23)) {
                                TbdFeeResponse04 obj = createXacNhanPhi(xacNhanPhi, maHoso);
                                json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                        + Constants04.RES_URI.URI_XACNHAN_PHI, obj, Constants.RES_METHOD.POST);
                                if (json.isSuccess()) {
                                    TbdLichsu04 objLishSu = createLichSuXacNhanPhi(xacNhanPhi, maHoso);
                                    json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants04.RES_URI.URI_LICHSU_RESPONSE,
                                            objLishSu, Constants.RES_METHOD.POST);
                                }
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants04.MARD04_TYPE.TYPE_12, header, json);
                        } else {
                            error = new Error();
                            error.setErrorCode(Constants.ERROR.BNN04_CODE);
                            error.setErrorName(Constants.ERROR.BNN04);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, documentType, type,
                                    error);
                        }
                        break;

                    default:
                        error = new Error();
                        error.setErrorCode(Constants.ERROR.BNN04_CODE);
                        error.setErrorName(Constants.ERROR.BNN04);
                        envelopReturn = envelopeService.createEnvelopeError(maHoso, documentType, type, error);
                        break;
                }

            } else {
                error = new Error();
                error.setErrorCode(Constants.ERROR.ERR01_CODE);
                error.setErrorName(errorMsg);
                envelopReturn = envelopeService.createEnvelopeError(maHoso, documentType, type, error);
            }

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            error = new Error();
            error.setErrorCode(Constants.ERROR.ERR02_CODE);
            error.setErrorName(Constants.ERROR.ERR02);
            envelopReturn = envelopeService.createEnvelopeError(maHoso, documentType, type, error);

            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            logger.info("errorInfo:" + errorInfo);
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }

        return envelopReturn;
    }

    private String getFunction(com.vnsw.ws.p04.envelop.Envelope envelop) {
        return envelop.getHeader().getSubject().getFunction();
    }

    private String getType(com.vnsw.ws.p04.envelop.Envelope envelop) {
        return envelop.getHeader().getSubject().getType();
    }

    @Override
    public ResponseJson callResforEntity(String url, Object object, String method) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(Charset.forName("UTF8"));
            restTemplate.getMessageConverters().add(formConverter);
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity responseEntity = null;
            if ("POST".equals(method)) {
                responseEntity = restTemplate.postForEntity(url, object, ResponseJson.class);
            } else if ("PUT".equals(method)) {
                restTemplate.put(url, object);
            } else if ("DELETE".equals(method)) {
                restTemplate.delete(url);
            }
            if (responseEntity != null) {
                ResponseJson responJson = (ResponseJson) responseEntity.getBody();
                return responJson;
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return null;
    }

    private com.vnsw.ws.p04.envelop.Envelope createEnvelopReturn(String fiMaHoSo, String msgType, Header header, ResponseJson json) {
        com.vnsw.ws.p04.envelop.Envelope envelop;
        if (json.isSuccess()) {
            com.vnsw.ws.p04.envelop.Content content = new com.vnsw.ws.p04.envelop.Content();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
            Date today = Calendar.getInstance().getTime();
            content.setReceiveDate(formatter.format(today));
            com.vnsw.ws.p04.envelop.Body body = envelopeService.createBody(content);
            envelop = envelopeService.createResponse(header, body);
        } else {
            Error error = new Error();
            error.setErrorCode(Constants.ERROR.BNN04_CODE);
            error.setErrorName(Constants.ERROR.BNN04);
            envelop = envelopeService.createEnvelopeError(fiMaHoSo, header.getSubject().getDocumentType(), msgType, error);
        }
        return envelop;
    }

    /**
     * Call UploadFile Services
     *
     * @return
     */
    private ResponseUpload uploadFile(String base64File, String fileName) {
        URI UPLOAD_URL;
        ResponseUpload uploadInfo = null;
        try {
            String url = environment.getRequiredProperty("URI_ADDRESS_FILE_SERVER") + Constants.RES_URI.URL_UPLOAD;
            UPLOAD_URL = new URI(url);
            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(Charset.forName("UTF8"));
            restTemplate.getMessageConverters().add(formConverter);
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();

            String folederUpload = environment.getRequiredProperty("FOLDER_TEMP_FILE_SERVICE");
            UUID uuid = UUID.randomUUID();
            String fileNameOnServer = uuid.toString() + "_" + fileName;

            byte[] decodedBytes = Base64.decodeBase64(base64File);
            File file = new File(folederUpload + fileNameOnServer);
            try (BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file))) {
                writer.write(decodedBytes);
                writer.flush();
                writer.close();
            }

            parts.add("file", new FileSystemResource(file));
            parts.add("fileName", fileName);
            parts.add("ministry", "most");
            parts.add("procedure", Constants.PROCEDURE.MOST06);

            uploadInfo = restTemplate.postForObject(UPLOAD_URL, parts, ResponseUpload.class);
            file.delete();
            return uploadInfo;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return null;
    }

    private void writeFileMsg(String xml, String msgType, String msgFunc, String fiMaHoSo) {
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
            String fileName = "";
            if ("00".equals(fiMaHoSo)) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
                Date date = new Date();
                fileName = dirName + "MsgReceive_" + dateFormat.format(date) + ".xml";
            } else {
                fileName = dirName + fiMaHoSo + "_" + msgType + "_" + msgFunc + ".xml";
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

    private TbdKqxl04 createKetquaxuly(TbdKqxl04 kqxl, String maHoso, String function) {
        TbdKqxl04 obj = kqxl;
        obj.setFiMaHoso(maHoso);

        switch (function) {
            case Constants04.MARD04_FUNCTION.FUNCTION_05:
                obj.setFiTrangthai(Constants04.FILE_STATUS.TUCHOI_HS);
                break;
            case Constants04.MARD04_FUNCTION.FUNCTION_06:
                obj.setFiTrangthai(Constants04.FILE_STATUS.YC_BOSUNG_HS);
                break;

            default:
                break;
        }

        return obj;
    }

    private TbdLichsu04 createLichsuKetquaxuly(TbdKqxl04 kqxl, String maHoso, String function) {
        TbdLichsu04 obj = new TbdLichsu04();
//         obj.setFiDonvixuly("BKHCN");
        obj.setFiMaHoso(maHoso);
        obj.setFiNgaytao(new Date());
        obj.setFiDonviXuly(kqxl.getFiDonviXl());
//        obj.setFiDonviXuly(Constants04.DONVI.BTTTT);
        obj.setFiNoidung(kqxl.getFiNoiDung());

        switch (function) {
            case Constants04.MARD04_FUNCTION.FUNCTION_05:
                obj.setFiTrangthai(Constants04.FILE_STATUS.TUCHOI_HS);
                obj.setFiTenTrangthai(Constants04.FILE_STATUS.TUCHOI_HS_STR);
                break;
            case Constants04.MARD04_FUNCTION.FUNCTION_06:
                obj.setFiTrangthai(Constants04.FILE_STATUS.YC_BOSUNG_HS);
                obj.setFiTenTrangthai(Constants04.FILE_STATUS.YC_BOSUNG_HS_STR);
                break;

            default:
                break;
        }

        return obj;
    }

    private TbdRegistrationComfirm04 createXacNhanDon(TbdRegistrationComfirm04 pheDuyetDon, String maHoso) {
        TbdRegistrationComfirm04 tbdRegistrationComfirm04 = pheDuyetDon;
        tbdRegistrationComfirm04.setNswfileCode(maHoso);
        return tbdRegistrationComfirm04;
    }

    private TbdLichsu04 createLichsuXacNhanDon(String maHoso) {
        TbdLichsu04 obj = new TbdLichsu04();
        obj.setFiMaHoso(maHoso);
        obj.setFiNgaytao(new Date());
        obj.setFiDonviXuly(Constants04.DONVI.BNNPTNT);
        obj.setFiTrangthai(Constants04.FILE_STATUS.XACNHAN_DON_DK);
        obj.setFiTenTrangthai(Constants04.FILE_STATUS.XACNHAN_DON_DK_STR);
        return obj;
    }

    private TbdRequestEdit createPhanHoiYcSua(TbdRequestEdit ycSua, String maHoso, String function) {
        TbdRequestEdit tbdRequestEdit = ycSua;
        tbdRequestEdit.setNswFilecode(maHoso);
         switch (function) {
            case Constants04.MARD04_FUNCTION.FUNCTION_09:
                tbdRequestEdit.setCodeStatus(Constants04.FILE_STATUS.DONGY_CHINHSUA_HS);
                tbdRequestEdit.setNameStatus(Constants04.FILE_STATUS.DONGY_CHINHSUA_HS_STR);
                break;
            case Constants04.MARD04_FUNCTION.FUNCTION_10:
                tbdRequestEdit.setCodeStatus(Constants04.FILE_STATUS.TC_YC_SUA_HS);
                tbdRequestEdit.setNameStatus(Constants04.FILE_STATUS.TC_YC_SUA_HS_STR);
                break;

            default:
                break;
        }
        return tbdRequestEdit;
    }

    private TbdLichsu04 createLichsuYcSua(TbdRequestEdit PHycSua, String maHoso, String function) {
        TbdLichsu04 obj = new TbdLichsu04();
        obj.setFiMaHoso(maHoso);
        obj.setFiNgaytao(new Date());
        obj.setFiDonviXuly(PHycSua.getDepartment());
        obj.setFiNoidung(PHycSua.getReasonResponse());

        switch (function) {
            case Constants04.MARD04_FUNCTION.FUNCTION_09:
                obj.setFiTrangthai(Constants04.FILE_STATUS.DONGY_CHINHSUA_HS);
                obj.setFiTenTrangthai(Constants04.FILE_STATUS.DONGY_CHINHSUA_HS_STR);
                break;
            case Constants04.MARD04_FUNCTION.FUNCTION_10:
                obj.setFiTrangthai(Constants04.FILE_STATUS.TC_YC_SUA_HS);
                obj.setFiTenTrangthai(Constants04.FILE_STATUS.TC_YC_SUA_HS_STR);
                break;

            default:
                break;
        }

        return obj;
    }

    private TbdYcRut04 createPhanHoiYcRut(TbdYcRut04 PHYcRut, String maHoso, String function) {
        TbdYcRut04 ycrut = PHYcRut;
        ycrut.setFiMaHoso(maHoso);
         switch (function) {
            case Constants04.MARD04_FUNCTION.FUNCTION_12:
                ycrut.setFiTrangthai(Constants04.FILE_STATUS.DONG_Y_XINRUT_HS);
                ycrut.setFiTenTt(Constants04.FILE_STATUS.DONG_Y_XINRUT_HS_STR);
                break;
            case Constants04.MARD04_FUNCTION.FUNCTION_13:
                ycrut.setFiTrangthai(Constants04.FILE_STATUS.TC_XIN_RUT);
                ycrut.setFiTenTt(Constants04.FILE_STATUS.TC_XIN_RUT_STR);
                break;
            default:
                break;
        }

        return ycrut;
    }

    private TbdLichsu04 createLichsuYcRut(TbdYcRut04 PHYcRut, String maHoso, String function) {
        TbdLichsu04 obj = new TbdLichsu04();
        obj.setFiMaHoso(maHoso);
        obj.setFiNgaytao(new Date());
        obj.setFiDonviXuly(PHYcRut.getFiDonviXuly());
        obj.setFiNoidung(PHYcRut.getFiNoidungPhanhoi());

        switch (function) {
            case Constants04.MARD04_FUNCTION.FUNCTION_12:
                obj.setFiTrangthai(Constants04.FILE_STATUS.DONG_Y_XINRUT_HS);
                obj.setFiTenTrangthai(Constants04.FILE_STATUS.DONG_Y_XINRUT_HS_STR);
                break;
            case Constants04.MARD04_FUNCTION.FUNCTION_13:
                obj.setFiTrangthai(Constants04.FILE_STATUS.TC_XIN_RUT);
                obj.setFiTenTrangthai(Constants04.FILE_STATUS.TC_XIN_RUT_STR);
                break;
            default:
                break;
        }

        return obj;
    }

    private TbdPhytosanitaryDetain04 createLenhgiulaiVaxuly(TbdPhytosanitaryDetain04 giulaivaxuly, String maHoso) {
        TbdPhytosanitaryDetain04 lenhGLXl = giulaivaxuly;
        lenhGLXl.setNswFilecode(maHoso);
        return lenhGLXl;
    }

    private TbdLichsu04 createLichsuLenhgiulaiVaxuly(TbdPhytosanitaryDetain04 giulaivaxuly, String maHoso) {
        TbdLichsu04 obj = new TbdLichsu04();
        obj.setFiMaHoso(maHoso);
        obj.setFiNgaytao(new Date());
        obj.setFiDonviXuly(Constants04.DONVI.BNNPTNT);
        obj.setFiTrangthai(Constants04.FILE_STATUS.LENH_GIULAI_XULY);
        obj.setFiTenTrangthai(Constants04.FILE_STATUS.LENH_GIULAI_XULY_STR);
        obj.setFiLinkDowload(giulaivaxuly.getLinkFile());
        return obj;
    }

    private TbdTemporaryPhytosanitary04 createTamcapKQKDTV(TbdTemporaryPhytosanitary04 tamcapKQKDTV, String maHoso) {
        TbdTemporaryPhytosanitary04 tbdTemporaryPhytosanitary04 = tamcapKQKDTV;
        tbdTemporaryPhytosanitary04.setNswFilecode(maHoso);
        return tbdTemporaryPhytosanitary04;
    }

    private TbdLichsu04 createLichsuTamcapKQKDTV(TbdTemporaryPhytosanitary04 tamcapKQKDTV, String maHoso) {
        TbdLichsu04 obj = new TbdLichsu04();
        obj.setFiMaHoso(maHoso);
        obj.setFiNgaytao(new Date());
        obj.setFiDonviXuly(Constants04.DONVI.BNNPTNT);
        obj.setFiTrangthai(Constants04.FILE_STATUS.GIAY_TAMCAP_KIEMDICH);
        obj.setFiTenTrangthai(Constants04.FILE_STATUS.GIAY_TAMCAP_KIEMDICH_STR);
        obj.setFiLinkDowload(tamcapKQKDTV.getLinkFile());
        return obj;
    }

    private TbdPhytosanitaryResult04 createXacNhanKDTV(TbdPhytosanitaryResult04 giayXacNhanKDTV, String maHoso) {
        TbdPhytosanitaryResult04 obj = giayXacNhanKDTV;
        obj.setNswFilecode(maHoso);
        return obj;

    }

    private TbdLichsu04 createLichsuXacNhanKDTV(TbdPhytosanitaryResult04 giayXacNhanKDTV, String maHoso) {
        TbdLichsu04 obj = new TbdLichsu04();
        obj.setFiMaHoso(maHoso);
        obj.setFiNgaytao(new Date());
        obj.setFiDonviXuly(Constants04.DONVI.BNNPTNT);
        obj.setFiTrangthai(Constants04.FILE_STATUS.DA_TRALAI_KQ);
        obj.setFiTenTrangthai(Constants04.FILE_STATUS.DA_TRALAI_KQ_STR);
        obj.setFiLinkDowload(giayXacNhanKDTV.getLinkFile());
        return obj;
    }

    private TbdQualityResult04 createXacNhanChatLuong(TbdQualityResult04 xacNhanChatLuong, String maHoso) {
        TbdQualityResult04 obj = xacNhanChatLuong;
        obj.setNswFilecode(maHoso);
        return obj;
    }

    private TbdLichsu04 createLichSuXacNhanChatLuong(TbdQualityResult04 xacNhanChatLuong,String maHoso) {
        TbdLichsu04 obj = new TbdLichsu04();
        obj.setFiMaHoso(maHoso);
        obj.setFiNgaytao(new Date());
        obj.setFiDonviXuly(Constants04.DONVI.BNNPTNT);
        obj.setFiTrangthai(Constants04.FILE_STATUS.DA_TRALAI_KQ);
        obj.setFiTenTrangthai(Constants04.FILE_STATUS.DA_TRALAI_KQ_STR);
        obj.setFiLinkDowload(xacNhanChatLuong.getLinkFile());
        return obj;
    }

    private TbdPhytosanitaryFee04 createThongBaoPhi(TbdPhytosanitaryFee04 TBphi, String maHoso) {
        TbdPhytosanitaryFee04 obj = TBphi;
        TBphi.setNswFilecode(maHoso);
        return obj;
    }

    private TbdLichsu04 createLichSuThongBaoPhi(String maHoso) {
        TbdLichsu04 obj = new TbdLichsu04();
        obj.setFiMaHoso(maHoso);
        obj.setFiNgaytao(new Date());
        obj.setFiDonviXuly(Constants04.DONVI.BNNPTNT);
        obj.setFiTrangthai(Constants04.FILE_STATUS.TB_AP_PHI);
        obj.setFiTenTrangthai(Constants04.FILE_STATUS.TB_AP_PHI_STR);
        return obj;
    }

    private TbdRequestEditCer04 createPHyeucauSuaXNCL(TbdRequestEditCer04 PHyeucauSuaXNCL, String maHoso) {
        TbdRequestEditCer04 obj = PHyeucauSuaXNCL;
        return obj;

    }

    private TbdLichsu04 createLichSuPHyeucauSuaXNCL(TbdRequestEditCer04 PHyeucauSuaXNCL, String maHoso) {
        TbdLichsu04 obj = new TbdLichsu04();
        obj.setFiMaHoso(maHoso);
        obj.setFiNgaytao(new Date());
        obj.setFiDonviXuly(PHyeucauSuaXNCL.getDepartment());
        obj.setFiNoidung(PHyeucauSuaXNCL.getReasonResponse());
        obj.setFiTrangthai(Constants04.FILE_STATUS.TC_YC_SUA_GIAY_CNKDXNCL);
        obj.setFiTenTrangthai(Constants04.FILE_STATUS.TC_YC_SUA_GIAY_CNKDXNCL_STR);
        return obj;
    }

    private TbdAnanyticalCheckedList04 createChiTieuCl(TbdAnanyticalCheckedList04 chitieuCl, String maHoso) {
        TbdAnanyticalCheckedList04 obj = chitieuCl;
        obj.setNswFilecode(maHoso);
        return obj;
    }

    private TbdLichsu04 createLichsuChiTieuCl(String maHoso) {
        TbdLichsu04 obj = new TbdLichsu04();
        obj.setFiMaHoso(maHoso);
        obj.setFiNgaytao(new Date());
        obj.setFiTrangthai(Constants04.FILE_STATUS.CHI_TIEU_CL);
        obj.setFiTenTrangthai(Constants04.FILE_STATUS.CHI_TIEU_CL_STR);
        return obj;
    }

    private TbdFeeResponse04 createXacNhanPhi(TbdFeeResponse04 xacNhanPhi, String maHoso) {
        TbdFeeResponse04 obj = xacNhanPhi;
        obj.setNswFilecode(maHoso);
        return obj;
    }

    private TbdLichsu04 createLichSuXacNhanPhi(TbdFeeResponse04 xacNhanPhi, String maHoso) {
        TbdLichsu04 obj = new TbdLichsu04();
        obj.setFiMaHoso(maHoso);
        obj.setFiNgaytao(new Date());
        obj.setFiDonviXuly(xacNhanPhi.getDepartment());
        obj.setFiNoidung(xacNhanPhi.getNote());
            if (Objects.equals(xacNhanPhi.getFeeResult(), Constants04.FEE_RESULT.BO_SUNG)){
                obj.setFiTrangthai(Constants04.FILE_STATUS.YC_THANHTOAN_BS);
                obj.setFiTenTrangthai(Constants04.FILE_STATUS.YC_THANHTOAN_BS_STR);
            }
            else if (Objects.equals(xacNhanPhi.getFeeResult(), Constants04.FEE_RESULT.DU_PHI))
            {
                obj.setFiTrangthai(Constants04.FILE_STATUS.XACNHAN_PHI);
                obj.setFiTenTrangthai(Constants04.FILE_STATUS.XACNHAN_PHI_STR);
            }
        return obj;
    }

}
