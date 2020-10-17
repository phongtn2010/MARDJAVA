package com.vnsw.ws.p7.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.helper.ValidateXSDHelper;
import com.vnsw.ws.p7.common.Constants07;
import com.vnsw.ws.p7.evelope.*;
import com.vnsw.ws.p7.message.ResponseWrapper;
import com.vnsw.ws.p7.message.receive.*;
import com.vnsw.ws.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Xử lý bản tin của thủ tục 07 cua MARD
 */
@Service("receive07Service")
public class ReceiveService07Impl implements ReceiveService07 {

    public static final Logger logger = LoggerFactory.getLogger(ReceiveService07Impl.class);

    private static final String CLASS_NAME = "ReceiveEndpoint07Impl";
    
    @Autowired
    private EnvelopXmlService07 convertXmlService;
    
    @Autowired
    private EnvelopeService07 envelopeService;
    
    @Autowired
    RabbitMQService rabbitMQService;
    
    @Autowired
    BackendService07 backendService;

    @Override
    public Envelope07 receive(String xml) {
        Envelope07 envelopReturn = null;
        Error07 error = null;
        String type = "00";
        String maHoso = "00";
        String errorMsg = null;

        logger.debug("Receive " + this.getClass().getSimpleName() + ": " + xml);

        if (xml == null || xml.equals("")) {
            error = new Error07();
            error.setErrorCode(Constants.ERROR.ERR00_CODE);
            error.setErrorName(Constants.ERROR.ERR00);
            envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD07, type, error);
        } else {
            try {
                Envelope07 envelop = (Envelope07) convertXmlService.xmlToEnvelope(xml);
                Header07 header;
                Content07 ct;
                ResponseJson json;
                type = getType(envelop);
                String function = getFunction(envelop);
                maHoso = envelop.getHeader().getSubject().getReference();
                header = envelopeService.createReceiveHeader(maHoso, Constants.MARD_PRO.MARD07, type,
                        Constants.FUNCTION.FUNC_SUCCESS);
                ct = envelop.getBody().getContent();
                ResponseWrapper responseWrapper = new ResponseWrapper();
                responseWrapper.setHeader(envelop.getHeader());
                // Validate xml
                ValidateXSDHelper validator = new ValidateXSDHelper();
                errorMsg = null;
//                errorMsg = validator.validateWithStringXML(xml, "p07/" + Constants.MARD_PRO.MARD07 + type + function + ".xsd");
                json = new ResponseJson(false, null, 0L, "");
                if (errorMsg == null) {
                    switch (type) {
                        case Constants07.MARD07_TYPE.TYPE_11: // Trả kết quả thẩm định hồ sơ
                            KetQuaThamDinh quarantineResult = ct.getKetQuaThamDinh();
                            responseWrapper.setData(quarantineResult);
                            if (quarantineResult != null) {
                                json = backendService.updateKQTD(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD07, header, json);
                            break;

                        case Constants07.MARD07_TYPE.TYPE_24: //Xac nhan don dang ky
                            XacNhanDonDangKy xacNhanDonDangKy = ct.getXacNhanDonDangKy();
                            responseWrapper.setData(xacNhanDonDangKy);
                            if (xacNhanDonDangKy != null) {
                                json = backendService.updateXacNhanDonDangKy(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD07, header, json);
                            break;
                        case Constants07.MARD07_TYPE.TYPE_21:  // Chung nhan kiem dich
                            ChungNhanKiemDich chungNhanKiemDich = ct.getChungNhanKiemDich();
                            responseWrapper.setData(chungNhanKiemDich);
                            if (chungNhanKiemDich != null) {
                                json = backendService.updateCNKD(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD07, header, json);
                            break;
                        case Constants07.MARD07_TYPE.TYPE_20: //Chung nhan van chuyen
                            ChungNhanVanChuyen chungNhanVanChuyen = ct.getChungNhanVanChuyen();
                            responseWrapper.setData(chungNhanVanChuyen);
                            if (chungNhanVanChuyen != null) {
                                json = backendService.updateCNVC(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD07, header, json);
                            break;
                        case Constants07.MARD07_TYPE.TYPE_13: // cong van KDNK
                            PhanhoiYeucauSuaHoso phanhoiYeucauSuaHoso = ct.getPhanhoiYeucauSuaHoso();
                            responseWrapper.setData(phanhoiYeucauSuaHoso);
                            if (phanhoiYeucauSuaHoso != null) {
                                // Cap nhat lich su theo trang thai
                                json = backendService.updateKetquaXinSuaHoso(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD07, header, json);
                            break;
                        case Constants07.MARD07_TYPE.TYPE_16:
                            PhanhoiYeucauRutHoso phanhoiYeucauRutHoso = ct.getPhanhoiYeucauRutHoso();
                            responseWrapper.setData(phanhoiYeucauRutHoso);
                            if (phanhoiYeucauRutHoso != null) {
                                json = backendService.updateKetquaXinRutHoso(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD07, header, json);
                            break;
                        case Constants07.MARD07_TYPE.TYPE_17: //VSTY khong dat
                            ThongbaoApphi thongbaoApphi = ct.getThongbaoApphi();
                            responseWrapper.setData(thongbaoApphi);
                            if (null != thongbaoApphi) {
                                // Cap nhat lich su theo trang thai
                                json = backendService.updateThongbaoApphi(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD07, header, json);
                            break;

                        case Constants07.MARD07_TYPE.TYPE_18: //VSTY khong dat
                            XacnhanThanhtoan xacNhanPhi = ct.getXacNhanPhi();
                            responseWrapper.setData(xacNhanPhi);
                            if (null != xacNhanPhi) {
                                // Cap nhat lich su theo trang thai
                                json = backendService.updateXacnhanPhi(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD07, header, json);
                            break;


                        case Constants07.MARD07_TYPE.TYPE_19: //VSTY khong dat
                            ThongbaoLohangKhongdat thongbaoLohangKhongdat = ct.getThongbaoLohangKhongdat();
                            responseWrapper.setData(thongbaoLohangKhongdat);
                            if (null != thongbaoLohangKhongdat) {
                                // Cap nhat lich su theo trang thai
                                json = backendService.updateThongbaoLohangKhongdat(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD07, header, json);
                            break;

                        case Constants07.MARD07_TYPE.TYPE_23: //VSTY khong dat
                            TuchoiSuaGCN tuchoiSuaGCN = ct.getTuchoiSuaGCN();
                            responseWrapper.setData(tuchoiSuaGCN);
                            if (null != tuchoiSuaGCN) {
                                // Cap nhat lich su theo trang thai
                                json = backendService.updateTuchoiXinsuaGCN(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD07, header, json);
                            break;
                        default:
                            error = new Error07();
                            error.setErrorCode(Constants.ERROR.ERR04_CODE);
                            error.setErrorName(Constants.ERROR.ERR04);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD07, type, error);
                            break;
                    }
                } else {
                    error = new Error07();
                    error.setErrorCode(Constants.ERROR.ERR02_CODE);
                    error.setErrorName(errorMsg);
                    envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD07, type, error);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                error = new Error07();
                error.setErrorCode(Constants.ERROR.ERR02_CODE);
                error.setErrorName(Constants.ERROR.ERR02);
                envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD07, type, error);

                String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                        + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                        + Constants.MESSAGE_SEPARATOR + ex.toString();
                RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            }
        }
        return envelopReturn;
    }

    private String getFunction(Envelope07 envelop) {
        return envelop.getHeader().getSubject().getFunction();
    }

    /**
     * Goi ham POST, PUT de Them moi, cap nhat du lieu
     *
     * @param url
     * @param object
     * @param method
     * @return
     * @throws Exception
     */
    @SuppressWarnings({"rawtypes"})
    @Override
    public ResponseJson callResforEntity(String url, Object object, String method) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(StandardCharsets.UTF_8);
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
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return null;
    }
    
    /**
     * Tạo Envelope08
     *
     * @param header
     * @param json
     * @return
     */
    private Envelope07 createEnvelopReturn(String fiMaHoSo, String msgType, Header07 header, ResponseJson json) {
        Envelope07 envelop;
        if (json.isSuccess()) {
            Content07 content = new Content07();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date today = Calendar.getInstance().getTime();
            content.setReceiveDate(formatter.format(today));
            Body07 body = envelopeService.createBody(content);
            envelop = envelopeService.createResponse(header, body);
        } else {
            Error07 error = new Error07();
            error.setErrorCode(Constants.ERROR.BNN08_CODE);
            String erroInfo = Constants.ERROR.BNN08;
            if(json.getMessage()!=null && !"".equals(json.getMessage())){
                erroInfo += ": " + json.getMessage();
            }
            error.setErrorName(erroInfo);
            envelop = envelopeService.createEnvelopeError(fiMaHoSo, Constants.MARD_PRO.MARD07, msgType, error);
        }
        return envelop;
    }

    /**
     * Lấy type
     *
     * @param envelop
     * @return
     */
    private String getType(Envelope07 envelop) {
        return envelop.getHeader().getSubject().getType();
    }

    /**
     * Lấy function
     *
     * @param envelop
     * @return
     */
}
