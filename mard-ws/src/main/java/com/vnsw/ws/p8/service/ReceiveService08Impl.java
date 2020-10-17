package com.vnsw.ws.p8.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.helper.ValidateXSDHelper;
import com.vnsw.ws.p8.common.Constants08;
import com.vnsw.ws.p8.evelop.*;
import com.vnsw.ws.p8.message.ResponseWrapper;
import com.vnsw.ws.p8.message.receive.*;
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
 * Xử lý bản tin của thủ tục 08 cua MARD
 */
@Service("receive08Service")
public class ReceiveService08Impl implements ReceiveService08 {

    public static final Logger logger = LoggerFactory.getLogger(ReceiveService08Impl.class);

    private static final String CLASS_NAME = "ReceiveEndpoint08Impl";

    @Autowired
    private EnvelopXmlService08 convertXmlService;

    @Autowired
    private EnvelopeService08 envelopeService;

    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    BackendService08 backendService;

    @Override
    public Envelope08 receive(String xml) {
        Envelope08 envelopReturn = null;
        Error08 error = null;
        String type = "00";
        String maHoso = "00";
        String errorMsg = null;

        logger.debug("Receive " + this.getClass().getSimpleName() + ": " + xml);

        if (xml == null || xml.equals("")) {
            error = new Error08();
            error.setErrorCode(Constants.ERROR.ERR00_CODE);
            error.setErrorName(Constants.ERROR.ERR00);
            envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD08, type, error);
        } else {
            try {
                Envelope08 envelop = (Envelope08) convertXmlService.xmlToEnvelope(xml);
                Header08 header;
                Content08 ct;
                ResponseJson json;
                type = getType(envelop);
                maHoso = envelop.getHeader().getSubject().getReference();
                header = envelopeService.createReceiveHeader(maHoso, Constants.MARD_PRO.MARD08, type,
                        Constants.FUNCTION.FUNC_SUCCESS);
                ct = envelop.getBody().getContent();
                ResponseWrapper responseWrapper = new ResponseWrapper();
                responseWrapper.setHeader(envelop.getHeader());
                // Validate xml
                ValidateXSDHelper validator = new ValidateXSDHelper();
                String function = envelop.getHeader().getSubject().getFunction();
                errorMsg = validator.validateWithStringXML(xml, "p08/" + Constants.MARD_PRO.MARD08 + type + function + ".xsd");

                json = new ResponseJson(false, null, 0L, "");
                if(errorMsg == null) {
                    switch (type) {
                        case Constants08.MARD08_TYPE.TYPE_12: // Trả kết quả thẩm định hồ sơ
                            KetQuaThamDinh quarantineResult = ct.getKetQuaThamDinh();
                            responseWrapper.setData(quarantineResult);
                            if (quarantineResult != null) {
                                json = backendService.ketquaThamdinh(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD08, header, json);
                            break;

                        case Constants08.MARD08_TYPE.TYPE_13: // cong van KDNK
                            BNNPhanHoiYeuCauRutHS phanHoiYeuCauRutHS = ct.getBnnPhanHoiYeuCauRutHS();
                            responseWrapper.setData(phanHoiYeuCauRutHS);
                            if (phanHoiYeuCauRutHS != null) {
                                responseWrapper.setData(phanHoiYeuCauRutHS);
                                // Cap nhat lich su theo trang thai
                                json = backendService.phanhoiYeucauRutHoso(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD08, header, json);
                            break;
                        case Constants08.MARD08_TYPE.TYPE_14:  // Đồng ý/ Từ chối yêu cầu xin rút hồ sơ
                            BNNPhanHoiYeuCauRutHS bnnPhanHoiYeuCauRutHS = ct.getBnnPhanHoiYeuCauRutHS();
                            responseWrapper.setData(bnnPhanHoiYeuCauRutHS);
                            if (bnnPhanHoiYeuCauRutHS != null) {
                                json = backendService.phanhoiYeucauRutHoso(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD08, header, json);
                            break;
                        case Constants08.MARD08_TYPE.TYPE_15: //CONG  van VSTY
                            CongVanVSTY congVanVSTY = ct.getCongVanVSTY();
                            responseWrapper.setData(congVanVSTY);
                            if (congVanVSTY != null) {
                                json = backendService.congvanVSTY(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD08, header, json);
                            break;
                        case Constants08.MARD08_TYPE.TYPE_16: // cong van KDNK
                            CongVanKDNK congVanKDNK = ct.getCongVanKDNK();
                            responseWrapper.setData(congVanKDNK);
                            if (congVanKDNK != null) {
                                responseWrapper.setData(congVanKDNK);
                                // Cap nhat lich su theo trang thai
                                json = backendService.congvanKDNK(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD08, header, json);
                            break;
                        case Constants08.MARD08_TYPE.TYPE_18:
                            PhanHoiYeuCauSuaHS phanHoiYeuCauSuaHS = ct.getPhanHoiYeuCauSuaHS();
                            responseWrapper.setData(phanHoiYeuCauSuaHS);
                            if (phanHoiYeuCauSuaHS != null) {
                                json = backendService.phanhoiYeucauSuaHoso(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD08, header, json);
                            break;
                        case Constants08.MARD08_TYPE.TYPE_19: //VSTY khong dat
                            KetQuaVSTYKhongDat ketQuaVSTYKhongDat = ct.getKetQuaVSTYKhongDat();
                            responseWrapper.setData(ketQuaVSTYKhongDat);
                            if (null != ketQuaVSTYKhongDat) {
                                // Cap nhat lich su theo trang thai
                                json = backendService.ketquaVSTYKhongdat(responseWrapper);
                            }
                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD08, header, json);
                            break;
                        default:
                            error = new Error08();
                            error.setErrorCode(Constants.ERROR.ERR04_CODE);
                            error.setErrorName(Constants.ERROR.ERR04);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD08, type, error);
                            break;
                    }
                } else {
                    error = new Error08();
                    error.setErrorCode(Constants.ERROR.ERR02_CODE);
                    error.setErrorName(errorMsg);
                    envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD08, type, error);
                }
            } catch (Exception ex) {
                error = new Error08();
                error.setErrorCode(Constants.ERROR.ERR02_CODE);
                error.setErrorName(Constants.ERROR.ERR02);
                envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD08, type, error);

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
    private Envelope08 createEnvelopReturn(String fiMaHoSo, String msgType, Header08 header, ResponseJson json) {
        Envelope08 envelop;
        if (json.isSuccess()) {
            Content08 content = new Content08();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date today = Calendar.getInstance().getTime();
            content.setReceiveDate(formatter.format(today));
            Body08 body = envelopeService.createBody(content);
            envelop = envelopeService.createResponse(header, body);
        } else {
            Error08 error = new Error08();
            error.setErrorCode(Constants.ERROR.BNN08_CODE);
            String erroInfo = Constants.ERROR.BNN08;
            if(json.getMessage()!=null && !"".equals(json.getMessage())){
                erroInfo += ": " + json.getMessage();
            }
            error.setErrorName(erroInfo);
            envelop = envelopeService.createEnvelopeError(fiMaHoSo, Constants.MARD_PRO.MARD08, msgType, error);
        }
        return envelop;
    }

    /**
     * Lấy type
     *
     * @param envelop
     * @return
     */
    private String getType(Envelope08 envelop) {
        return envelop.getHeader().getSubject().getType();
    }

    /**
     * Lấy function
     *
     * @param envelop
     * @return
     */
}
