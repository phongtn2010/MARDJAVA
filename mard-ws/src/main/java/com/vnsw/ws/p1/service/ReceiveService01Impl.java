package com.vnsw.ws.p1.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.helper.ValidateXSDHelper;
import com.vnsw.ws.p1.common.Constants01;
import com.vnsw.ws.p1.evelop.*;
import com.vnsw.ws.p1.message.ResponseWrapper;
import com.vnsw.ws.p1.message.receive.*;
import com.vnsw.ws.util.Constants;
import org.apache.http.util.TextUtils;
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
 * Xử lý bản tin của thủ tục 01 cua MARD
 */
@Service("receive01Service")
public class ReceiveService01Impl implements ReceiveService01 {

    public static final Logger logger = LoggerFactory.getLogger(ReceiveService01Impl.class);

    private static final String CLASS_NAME = "ReceiveEndpoint01Impl";
    @Autowired
    RabbitMQService rabbitMQService;
    @Autowired
    BackendService01 backendService;
    @Autowired
    private EnvelopXmlService01 convertXmlService;
    @Autowired
    private EnvelopeService01 envelopeService;

    @Override
    public Envelope01 receive(String xml) {
        Envelope01 envelopReturn = null;
        Error01 error = null;
        String type = "00";
        String maHoso = "00";
        String errorMsg = null;

        logger.debug("Receive " + this.getClass().getSimpleName() + ": " + xml);

        if (xml == null || xml.equals("")) {
            error = new Error01();
            error.setErrorCode(Constants.ERROR.ERR00_CODE);
            error.setErrorName(Constants.ERROR.ERR00);
            envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD01, type, error);
        } else {
            try {
                Envelope01 envelop = (Envelope01) convertXmlService.xmlToEnvelope(xml);
                Header01 header;
                Content01 ct;
                ResponseJson json;
                type = getType(envelop);
                maHoso = envelop.getHeader().getSubject().getReference();
                header = envelopeService.createReceiveHeader(maHoso, Constants.MARD_PRO.MARD01, type,
                        Constants.FUNCTION.FUNC_SUCCESS);
                ct = envelop.getBody().getContent();
                ResponseWrapper responseWrapper = new ResponseWrapper();
                responseWrapper.setHeader(envelop.getHeader());
                // Validate xml
                ValidateXSDHelper validator = new ValidateXSDHelper();
                errorMsg = validator.validateWithStringXML(xml, "p01/" + Constants.MARD_PRO.MARD01 + type + envelop.getHeader().getSubject().getFunction() + ".xsd");
                json = new ResponseJson(false, null, 0L, "");
                if (errorMsg == null) {
                    switch (type) {
                        // Trả kết quả kết quả thẩm định hồ sơ. Từ chối hồ sơ
                        case Constants01.MARD01_TYPE.TYPE_12:
                            KQTDhoso01 kqtDhoso01 = ct.getKqtDhoso01();
                            responseWrapper.setData(kqtDhoso01);

                            if (kqtDhoso01 != null) {
                                json = backendService.updateKQTDhoso01(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD01, header, json);
                            break;
                        // Thông báo đồng ý tiếp nhận hồ sơ
                        case Constants01.MARD01_TYPE.TYPE_13:
                            TBDYhoso01 tbdYhoso = ct.getTbdYhoso01();
                            if (tbdYhoso.getFiRegistationConfirmNo() == null) {
                                tbdYhoso.setFiRegistationConfirmNo("TEMP");
                            }
                            responseWrapper.setData(tbdYhoso);
                            if (tbdYhoso != null) {
                                json = backendService.updateTBDYhoso01(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD01, header, json);
                            break;
                        // Yêu cầu chỉnh sửa hồ sơ ( Đồng ý/ Từ chối)
                        case Constants01.MARD01_TYPE.TYPE_15:
                            KQYCSuaHoSo01 kqycSuaHoSo01 = ct.getKqycSuaHoSo01();
                            responseWrapper.setData(kqycSuaHoSo01);
                            if (kqycSuaHoSo01 != null) {
                                if (TextUtils.isEmpty(responseWrapper.getHeader().getSubject().getReference())) {
                                    responseWrapper.getHeader().getSubject().setReference(kqycSuaHoSo01.getFiNSWFileCode());
                                    responseWrapper.getHeader().getSubject().setPreReference(kqycSuaHoSo01.getFiNSWFileCode());
                                }
                                json = backendService.updateKQYCSuaHoSo01(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD01, header, json);
                            break;
                        // Yêu cầu chỉnh hủy hồ sơ ( Đồng ý/ Từ chối)
                        case Constants01.MARD01_TYPE.TYPE_17:
                            KQYCRutHoSo01 kqycRutHoSo01 = ct.getKqycRutHoSo01();
                            responseWrapper.setData(kqycRutHoSo01);
                            if (kqycRutHoSo01 != null) {
                                json = backendService.updateKQYCRutHoSo01(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD01, header, json);
                            break;
                        // Thông báo ap phí
                        case Constants01.MARD01_TYPE.TYPE_18:
                            TBApPhi01 tbApPhi01 = ct.getTbApPhi01();
                            responseWrapper.setData(tbApPhi01);
                            if (tbApPhi01 != null) {
                                json = backendService.updateTBApPhi01(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD01, header, json);
                            break;
                        // Thông báo xác nhận thanh toán
                        case Constants01.MARD01_TYPE.TYPE_19:
                            TBXacNhanPhi01 tbXacNhanPhi01 = ct.getTbXacNhanPhi01();
                            responseWrapper.setData(tbXacNhanPhi01);
                            if (tbXacNhanPhi01 != null) {
                                json = backendService.updateTBXacNhanPhi01(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD01, header, json);
                            break;
                        // Mẫu 13A
                        case Constants01.MARD01_TYPE.TYPE_20:
                            CNKD13A cnkd13A = ct.getCnkd13A();
                            responseWrapper.setData(cnkd13A);
                            if (cnkd13A != null) {
                                json = backendService.updateCNKD13A(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD01, header, json);
                            break;
                        // Mẫu 13B
                        case Constants01.MARD01_TYPE.TYPE_21:
                            CNKD13B cnkd13B = ct.getCnkd13B();
                            responseWrapper.setData(cnkd13B);
                            if (cnkd13B != null) {
                                json = backendService.updateCNKD13B(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD01, header, json);
                            break;
                        // Mẫu Hong Kong (sản phẩm thịt lợn)
                        case Constants01.MARD01_TYPE.TYPE_22:
                            CNKDHongKongPig cnkdHongKongPig = ct.getCnkdHongKongPig();
                            responseWrapper.setData(cnkdHongKongPig);
                            if (cnkdHongKongPig != null) {
                                json = backendService.updateCNKDHongKongPig(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD01, header, json);
                            break;
                        // Mẫu Malaysia
                        case Constants01.MARD01_TYPE.TYPE_23:
                            CNKDMalaysia cnkdMalaysia = ct.getCnkdMalaysia();
                            responseWrapper.setData(cnkdMalaysia);
                            if (cnkdMalaysia != null) {
                                json = backendService.updateCNKDMalaysia(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD01, header, json);
                            break;
                        // Mẫu Hong Kong (sản phẩm thịt gà)
                        case Constants01.MARD01_TYPE.TYPE_24:
                            CNKDHongKongChicken cnkdHongKongChicken = ct.getCnkdHongKongChicken();
                            responseWrapper.setData(cnkdHongKongChicken);
                            if (cnkdHongKongChicken != null) {
                                json = backendService.updateCNKDHongKongChicken(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD01, header, json);
                            break;
                        // Mẫu Trung Quốc
                        case Constants01.MARD01_TYPE.TYPE_25:
                            CNKDChina cnkdChina = ct.getCnkdChina();
                            responseWrapper.setData(cnkdChina);
                            if (cnkdChina != null) {
                                json = backendService.updateCNKDChina(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD01, header, json);
                            break;
                        // Công văn thông báo kết quả không đạt yêu cầu xuất khẩu
                        case Constants01.MARD01_TYPE.TYPE_26:
                            CVKQYCXuatKhau01 cvkqycXuatKhau01 = ct.getCvkqycXuatKhau01();
                            responseWrapper.setData(cvkqycXuatKhau01);
                            if (cvkqycXuatKhau01 != null) {
                                json = backendService.updateCVKQYCXuatKhau01(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD01, header, json);
                            break;
                        // Thông báo từ chối huỷ cầu sửa giấy CNKD
                        case Constants01.MARD01_TYPE.TYPE_28:
                            TBKQYCHuyCNKD tbkqycHuyCNKD = ct.getTbkqycHuyCNKD();
                            responseWrapper.setData(tbkqycHuyCNKD);
                            if (tbkqycHuyCNKD != null) {
                                json = backendService.updateTBKQYCHuyCNKD(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD01, header, json);
                            break;
                        // Thông báo từ chối sửa giấy CNKD
                        case Constants01.MARD01_TYPE.TYPE_30:
                            TBKQYCSuaCNKD tbkqycSuaCNKD = ct.getTbkqycSuaCNKD();
                            responseWrapper.setData(tbkqycSuaCNKD);
                            if (tbkqycSuaCNKD != null) {
                                json = backendService.updateTBKQYCSuaCNKD(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD01, header, json);
                            break;
                    }
                } else {
                    error = new Error01();
                    error.setErrorCode(Constants.ERROR.ERR02_CODE);
                    error.setErrorName(errorMsg);
                    envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD01, type, error);
                }
            } catch (Exception ex) {
                error = new Error01();
                error.setErrorCode(Constants.ERROR.ERR02_CODE);
                error.setErrorName(Constants.ERROR.ERR02);
                envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD01, type, error);

                String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                        + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                        + Constants.MESSAGE_SEPARATOR + ex.toString();
                RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            }
        }

        return envelopReturn;
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
    private Envelope01 createEnvelopReturn(String fiMaHoSo, String msgType, Header01 header, ResponseJson json) {
        Envelope01 envelop;
        if (json.isSuccess()) {
            Content01 content = new Content01();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date today = Calendar.getInstance().getTime();
            content.setReceiveDate(formatter.format(today));
            Body01 body = envelopeService.createBody(content);
            envelop = envelopeService.createResponse(header, body);
        } else {
            Error01 error = new Error01();
            error.setErrorCode(Constants.ERROR.BNN08_CODE);
            String erroInfo = Constants.ERROR.BNN08;
            if (json.getMessage() != null && !"".equals(json.getMessage())) {
                erroInfo += ": " + json.getMessage();
            }
            error.setErrorName(erroInfo);
            envelop = envelopeService.createEnvelopeError(fiMaHoSo, Constants.MARD_PRO.MARD01, msgType, error);
        }
        return envelop;
    }

    /**
     * Lấy type
     *dich
     * @param envelop
     * @return
     */
    private String getType(Envelope01 envelop) {
        return envelop.getHeader().getSubject().getType();
    }
}
