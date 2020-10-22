package com.vnsw.ws.p25.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.helper.ValidateXSDHelper;
import com.vnsw.ws.p25.common.Constants25;
import com.vnsw.ws.p25.envelop.*;
import com.vnsw.ws.p25.message.ResponseWrapper;
import com.vnsw.ws.p25.message.receive.*;
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
 * Xử lý bản tin của thủ tục 25 cua MARD
 */
@Service("receive25Service")
public class ReceiveService25Impl implements ReceiveService25 {

    public static final Logger logger = LoggerFactory.getLogger(ReceiveService25Impl.class);

    private static final String CLASS_NAME = "ReceiveEndpoint06Impl";

    @Autowired
    private EnvelopXmlService25 convertXmlService;

    @Autowired
    private EnvelopeService25 envelopeService;

    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    BackendService25 backendService;

    @Override
    public Envelope25 receive(String xml) {
        Envelope25 envelopReturn = null;
        Error25 error = null;
        String type = "00";
        String maHoso = "00";
        String errorMsg = null;

        logger.debug("Receive " + this.getClass().getSimpleName() + ": " + xml);

        if (xml == null || "".equals(xml)) {
            error = new Error25();
            error.setErrorCode(Constants.ERROR.ERR00_CODE);
            error.setErrorName(Constants.ERROR.ERR00);
            envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD06, type, error);
        } else {
            try {
                Envelope25 envelop = (Envelope25) convertXmlService.xmlToEnvelope(xml);
                Header25 header;
                Content25 ct;
                ResponseJson json;
                type = getType(envelop);
                maHoso = envelop.getHeader().getSubject().getReference();
                header = envelopeService.createReceiveHeader(maHoso, Constants.MARD_PRO.MARD06, type,
                        Constants.FUNCTION.FUNC_SUCCESS);
                ct = envelop.getBody().getContent();

                ResponseWrapper responseWrapper = new ResponseWrapper();
                responseWrapper.setHeader(envelop.getHeader());
                ValidateXSDHelper validator = new ValidateXSDHelper();
                errorMsg = validator.validateWithStringXML(xml, "p06/" + Constants.MARD_PRO.MARD06 + type + envelop.getHeader().getSubject().getFunction() + ".xsd");
                json = new ResponseJson(false, null, 0L, "");
                if (errorMsg == null) {
                    switch (type) {
                        case Constants25.MARD25_TYPE.TYPE_11://Ket qua tham dinh ho so
                            KetQuaXuLy ketQuaXuLy = ct.getKetQuaXuLy();
                            responseWrapper.setData(ketQuaXuLy);

                            if (ketQuaXuLy != null) {
                                json = backendService.ketquaThamdinh(responseWrapper);
                            }

                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD06, header, json);
                            break;

                        case Constants25.MARD25_TYPE.TYPE_14://BNN phan hoi yeu cau huy HS
                            PhanhoiYeucauHuyHoso phanhoiYeucauHuyHoso = ct.getPhanhoiYeucauHuyHoso();
                            responseWrapper.setData(phanhoiYeucauHuyHoso);

                            if (phanhoiYeucauHuyHoso != null) {
                                json = backendService.phanhoiYeucauHuyHoso(responseWrapper);
                            }

                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD06, header, json);
                            break;

                        case Constants25.MARD25_TYPE.TYPE_16://BNN phan hoi yeu cau sua ho so
                            PhanhoiYeucauSuaHoso phanhoiYeucauSuaHoso = ct.getPhanhoiYeucauSuaHoso();
                            responseWrapper.setData(phanhoiYeucauSuaHoso);

                            if (phanhoiYeucauSuaHoso != null) {
                                json = backendService.phanhoiYeucauSuaHoso(responseWrapper);
                            }

                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD06, header, json);
                            break;

                        case Constants25.MARD25_TYPE.TYPE_17://BNN gui cong van VSTY
                            CongVanVSTY congVanVSTY = ct.getCongVanVSTY();
                            responseWrapper.setData(congVanVSTY);

                            if (congVanVSTY != null) {
                                json = backendService.congvanVSTY(responseWrapper);
                            }

                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD06, header, json);
                            break;

                        case Constants25.MARD25_TYPE.TYPE_18://BNN gui cong van KDNK
                            CongVanKDNK congVanKDNK = ct.getCongVanKDNK();
                            responseWrapper.setData(congVanKDNK);

                            if (congVanKDNK != null) {
                                json = backendService.congvanKDNK(responseWrapper);
                            }

                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD06, header, json);
                            break;

                        case Constants25.MARD25_TYPE.TYPE_19://BNN tra KQ VSTY
                            KetquaVSTY ketquaVSTY = ct.getKetquaVSTY();
                            responseWrapper.setData(ketquaVSTY);

                            if (ketquaVSTY != null) {
                                json = backendService.ketquaVSTY(responseWrapper);
                            }

                            envelopReturn = createEnvelopReturn(maHoso, Constants.MARD_PRO.MARD06, header, json);
                            break;
                        default:
                            error = new Error25();
                            error.setErrorCode(Constants.ERROR.ERR04_CODE);
                            error.setErrorName(Constants.ERROR.ERR04);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD06, type, error);
                            break;
                    }
                } else {
                    error = new Error25();
                    error.setErrorCode(Constants.ERROR.ERR02_CODE);
                    error.setErrorName(errorMsg);
                    envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD06, type, error);
                }
            } catch (Exception ex) {
                error = new Error25();
                error.setErrorCode(Constants.ERROR.ERR02_CODE);
                error.setErrorName(Constants.ERROR.ERR02);
                envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD06, type, error);

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
                return (ResponseJson) responseEntity.getBody();
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
     * Tạo Envelope25
     *
     * @param header
     * @param json
     * @return
     */
    private Envelope25 createEnvelopReturn(String fiMaHoSo, String msgType, Header25 header, ResponseJson json) {
        Envelope25 envelop;
        if (json.isSuccess()) {
            Content25 content = new Content25();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date today = Calendar.getInstance().getTime();
            content.setReceiveDate(formatter.format(today));
            Body25 body = envelopeService.createBody(content);
            envelop = envelopeService.createResponse(header, body);
        } else {
            Error25 error = new Error25();
            error.setErrorCode(Constants.ERROR.BNN06_CODE);
            String erroInfo = Constants.ERROR.BNN06;
            if(json.getMessage()!=null && !"".equals(json.getMessage())){
                erroInfo += ": " + json.getMessage();
            }
            error.setErrorName(erroInfo);
            envelop = envelopeService.createEnvelopeError(fiMaHoSo, Constants.MARD_PRO.MARD06, msgType, error);
        }
        return envelop;
    }

    /**
     * Lấy type
     *
     * @param envelop
     * @return
     */
    private String getType(Envelope25 envelop) {
        return envelop.getHeader().getSubject().getType();
    }

    /**
     * Lấy function
     *
     * @param envelop
     * @return
     */
}
