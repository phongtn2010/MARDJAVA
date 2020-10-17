/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p12.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.entity.json.ResponseUpload;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.helper.ValidateXSDHelper;
import com.vnsw.ws.p12.common.Constants12;
import com.vnsw.ws.p12.entity.db.Tbddinhkem12;
import com.vnsw.ws.p12.entity.db.TbdhsKqxl12;
import com.vnsw.ws.p12.entity.db.Tbdlichsu12;
import com.vnsw.ws.p12.envelop.Body12;
import com.vnsw.ws.p12.envelop.Content12;
import com.vnsw.ws.p12.envelop.Envelope12;
import com.vnsw.ws.p12.envelop.Error12;
import com.vnsw.ws.p12.envelop.Header12;
import com.vnsw.ws.p12.message.receive.KetQuaXuLy;
import com.vnsw.ws.p12.message.receive.Tbdcongvan12;
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
import java.util.List;
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

@Service("helperBnn12Service")
@Transactional
public class ReceiveService12Impl implements ReceiveService12 {

    public static final Logger logger = LoggerFactory.getLogger(ReceiveService12Impl.class);

    private static final String CLASS_NAME = "ReceiveService12Impl";

    @Autowired
    private EnvelopeService envelopeService;

    @Autowired
    private Environment environment;

    @Autowired
    private EnvelopXmlService12 convertXmlService;

    @Autowired
    RabbitMQService rabbitMQService;

    @Override
    public Envelope12 receive(String xml) {
        Envelope12 envelopReturn = null;
        Error12 error;
        String type = "00";
        String maHoso = "00";
        String errorMsg;

        Header12 header, headerReceive;
        Content12 ct;
        String documentType = "";
        String function;
        ResponseJson json;

        try {
            //save file xml
            writeFileMsg(xml, "", "", maHoso);

            ValidateXSDHelper validator = new ValidateXSDHelper();
            Envelope12 envelop = (Envelope12)convertXmlService.xmlToEnvelope(xml);

            type = getType(envelop);
            function = getFunction(envelop);

            maHoso = envelop.getHeader().getSubject().getReference();

            headerReceive = envelop.getHeader();
            ct = envelop.getBody().getContent();
            documentType = headerReceive.getSubject().getDocumentType();
            if (documentType != null && !"".equals(documentType)) {
                if (documentType.equals(Constants.MARD_PRO_RECEIVE.MARD12_01)) {
                    documentType = Constants.MARD_PRO.MARD12_01;
                } else if (documentType.equals(Constants.MARD_PRO_RECEIVE.MARD12_02)) {
                    documentType = Constants.MARD_PRO.MARD12_02;
                }
            }
            
                    
            header = envelopeService.createReceiveHeader(maHoso, documentType, type,
                    Constants.FUNCTION.FUNC_SUCCESS);
            
            
            // Validate xml
            errorMsg = validator.validateWithStringXML(xml, Constants.XSDPREFIX.BNN12 + type + function + ".xsd");
            if (null == errorMsg) {
                json = new ResponseJson();
                // switch type
                switch (type) {
                    case Constants12.BNN12_TYPE.TYPE_11:
                        KetQuaXuLy kqxl = ct.getKetQuaXuLy();
                        if (kqxl != null) {
                            if (function.equals(Constants12.BNN12_FUNCTION.FUNCTION_04)
                                    || function.equals(Constants12.BNN12_FUNCTION.FUNCTION_06)) {
                                TbdhsKqxl12 obj = createKetquaxuly(kqxl, maHoso, function);
                                json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                        + Constants12.RES_URI.URI_KETQUA_XULY, obj, Constants.RES_METHOD.POST);
                                if (json.isSuccess()) {
                                    Tbdlichsu12 objLishSu = createLichsuKetquaxuly(kqxl, maHoso, function);
                                    json = callResforEntity(
                                            environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                            + Constants12.RES_URI.URI_LICHSU_RESPONSE,
                                            objLishSu, Constants.RES_METHOD.POST);
                                }
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants12.BNN12_TYPE.TYPE_11, header, json);
                        } else {
                            error = new Error12();
                            error.setErrorCode(Constants.ERROR.ERR05_CODE);
                            error.setErrorName(Constants.ERROR.ERR05);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, documentType, type,
                                    error);
                        }
                        break;

                    case Constants12.BNN12_TYPE.TYPE_12:
                        List<Tbdcongvan12> lstCongvan = ct.getLstTbdcongvan12s();
                        if (lstCongvan != null && lstCongvan.size() > 0) {
                            if (function.equals(Constants12.BNN12_FUNCTION.FUNCTION_05)) {
//                                List<Tbdcongvan12> lst = createListCongvan(lstCongvan, maHoso);
                                json = callResforEntity(environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                        + Constants12.RES_URI.URI_LIST_CONG_VAN, lstCongvan, Constants.RES_METHOD.POST);
                                if (json.isSuccess()) {
                                    for (Tbdcongvan12 tbdcongvan12 : lstCongvan) {
                                        Tbdlichsu12 objLishSu = createLichsuCongvan(tbdcongvan12);
                                        json = callResforEntity(
                                                environment.getRequiredProperty("URI_BACKEND_ADDRESS")
                                                + Constants12.RES_URI.URI_LICHSU_RESPONSE,
                                                objLishSu, Constants.RES_METHOD.POST);
                                    }
                                }
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants12.BNN12_TYPE.TYPE_11, header, json);
                        } else {
                            error = new Error12();
                            error.setErrorCode(Constants.ERROR.ERR05_CODE);
                            error.setErrorName(Constants.ERROR.ERR05);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, documentType, type,
                                    error);
                        }
                        break;

                    default:
                        error = new Error12();
                        error.setErrorCode(Constants.ERROR.ERR04_CODE);
                        error.setErrorName(Constants.ERROR.ERR04);
                        envelopReturn = envelopeService.createEnvelopeError(maHoso, documentType, type, error);
                        break;
                }

            } else {
                error = new Error12();
                error.setErrorCode(Constants.ERROR.ERR02_CODE);
                error.setErrorName(errorMsg);
                envelopReturn = envelopeService.createEnvelopeError(maHoso, documentType, type, error);
            }

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            error = new Error12();
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

    private String getFunction(Envelope12 envelop) {
        return envelop.getHeader().getSubject().getFunction();
    }

    private String getType(Envelope12 envelop) {
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

    private Envelope12 createEnvelopReturn(String fiMaHoSo, String msgType, Header12 header, ResponseJson json) {
        Envelope12 envelop;
        if (json.isSuccess()) {
            Content12 content = new Content12();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
            Date today = Calendar.getInstance().getTime();
            content.setReceiveDate(formatter.format(today));
            Body12 body = envelopeService.createBody(content);
            envelop = envelopeService.createResponse(header, body);
        } else {
            Error12 error = new Error12();
            error.setErrorCode(Constants.ERROR.ERR00_CODE);
            error.setErrorName(Constants.ERROR.ERR00);
            envelop = envelopeService.createEnvelopeError(fiMaHoSo, header.getSubject().getDocumentType(), msgType, error);
        }
        return envelop;
    }

    private TbdhsKqxl12 createKetquaxuly(KetQuaXuLy kqxl, String reference, String function) {
        TbdhsKqxl12 obj = new TbdhsKqxl12();
        obj.setFiMaHoso(reference);
        obj.setFiLydo(kqxl.getReason());
        obj.setFiNgayXl(kqxl.getResultDate());
        obj.setFiDonviXl(kqxl.getDepartment());
        obj.setFiNguoiXl(kqxl.getCreaterName());
        obj.setFiNgaytraKq(kqxl.getReturnDate());

        switch (function) {
            case Constants12.BNN12_FUNCTION.FUNCTION_04:
                obj.setFiTrangthai(Constants12.FILE_STATUS.DA_TIEP_NHAN);
                obj.setFiTenTt(Constants12.FILE_STATUS.DA_TIEP_NHAN_STR);
                break;
            case Constants12.BNN12_FUNCTION.FUNCTION_06:
                obj.setFiTrangthai(Constants12.FILE_STATUS.DA_THU_HOI);
                obj.setFiTenTt(Constants12.FILE_STATUS.DA_THU_HOI_STR);
                break;
            default:
                break;
        }
        
        if (kqxl.getFileByte() != null && !"".equals(kqxl.getFileByte())
                && kqxl.getFileName()!= null && !"".equals(kqxl.getFileName())) {
            //dinh kem anh
            Tbddinhkem12 dinhKemKqxl = new Tbddinhkem12();
            String fileBase64 = kqxl.getFileByte();
            ResponseUpload uploadInfo = uploadFile(fileBase64, kqxl.getFileName());
            if (uploadInfo != null) {
                dinhKemKqxl.setFiDuongdan(uploadInfo.getFilePath());
                dinhKemKqxl.setFiGuiId(uploadInfo.getFileName());
                dinhKemKqxl.setFiTenTep(kqxl.getFileName());

                obj.setAttach(dinhKemKqxl);
            }
            kqxl.setFileByte(null);
            kqxl.setFileName(null);
        }

        return obj;
    }
    
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
            }

            parts.add("file", new FileSystemResource(file));
            parts.add("fileName", fileName);
            parts.add("ministry", "moh");
            parts.add("procedure", "12");

            uploadInfo
                    = restTemplate.postForObject(UPLOAD_URL, parts, ResponseUpload.class
                    );
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
    
//    private List<Tbdcongvan12> createListCongvan(List<Tbdcongvan12> lstCongvan, String reference) {
//        for (Tbdcongvan12 tbdcongvan12 : lstCongvan) {
//            tbdcongvan12.setFiMaHoso(tbdcongvan12.get);
//        }
//        return lstCongvan;
//    }

    private Tbdlichsu12 createLichsuKetquaxuly(KetQuaXuLy kqxl, String maHoso, String function) {
        Tbdlichsu12 obj = new Tbdlichsu12();
        createLichsu(obj);
        obj.setFiMaHoso(maHoso);
        obj.setFiNgaytao(new Date());
        obj.setFiTenDvgui(kqxl.getDepartment());
        obj.setFiNoidung(kqxl.getReason());

        switch (function) {
            case Constants12.BNN12_FUNCTION.FUNCTION_04:
                obj.setFiTrangthai(Constants12.FILE_STATUS.DA_TIEP_NHAN);
                obj.setFiTenTt(Constants12.FILE_STATUS.DA_TIEP_NHAN_STR);
                break;
            case Constants12.BNN12_FUNCTION.FUNCTION_06:
                obj.setFiTrangthai(Constants12.FILE_STATUS.DA_THU_HOI);
                obj.setFiTenTt(Constants12.FILE_STATUS.DA_THU_HOI_STR);
                break;
            default:
                break;
        }

        return obj;
    }
    
    private Tbdlichsu12 createLichsuCongvan(Tbdcongvan12 congvan) {
        Tbdlichsu12 obj = new Tbdlichsu12();
        createLichsu(obj);
        obj.setFiMaHoso(congvan.getFiMaHoso());
        obj.setFiNgaytao(new Date());
        obj.setFiTenNggui(congvan.getFiNguoiKy());
        obj.setFiNoidung(Constants12.FILE_STATUS.DUOC_CAP_GIAYPHEP_STR);
        obj.setFiTrangthai(Constants12.FILE_STATUS.DUOC_CAP_GIAYPHEP);
        obj.setFiTenTt(Constants12.FILE_STATUS.DUOC_CAP_GIAYPHEP_STR);
        return obj;
    }

    private void createLichsu(Tbdlichsu12 obj) {
        obj.setFiTenDvgui("BNN");
        obj.setFiTenDvnhan("NSW");
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
                logger.info(e.getMessage());
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
