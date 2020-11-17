package com.vnsw.ws.p26.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.helper.ValidateXSDHelper;
import com.vnsw.ws.p26.common.Constants26;
import com.vnsw.ws.p26.envelop.*;
import com.vnsw.ws.p26.message.ResponseWrapper;
import com.vnsw.ws.p26.message.receive.*;
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
 * Xử lý bản tin của thủ tục 26 cua MARD
 */
@Service("receive26Service")
public class ReceiveService26Impl implements ReceiveService26 {

    public static final Logger logger = LoggerFactory.getLogger(ReceiveService26Impl.class);

    private static final String CLASS_NAME = "ReceiveEndpoint26Impl";

    @Autowired
    private EnvelopXmlService26 convertXmlService;

    @Autowired
    private EnvelopeService26 envelopeService;

    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    BackendService26 backendService;

    @Override
    public Envelope26 receive(String xml) {
        Envelope26 envelopReturn = null;
        Error26 error = null;
        String type = "00";
        String maHoso = "00";
        String errorMsg = null;

        logger.debug("Receive " + this.getClass().getSimpleName() + ": " + xml);

        if (xml == null || "".equals(xml)) {
            error = new Error26();
            error.setErrorCode(Constants.ERROR.ERR00_CODE);
            error.setErrorName(Constants.ERROR.ERR00);
            envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD25, type, error);
        } else {
            try {
                Envelope26 envelop = (Envelope26) convertXmlService.xmlToEnvelope(xml);
                Header26 header;
                Content26 ct;
                ResponseJson json;
                type = getType(envelop);
                maHoso = envelop.getHeader().getSubject().getReference();
                header = envelopeService.createReceiveHeader(maHoso, Constants.MARD_PRO.MARD25, type,
                        Constants.FUNCTION.FUNC_SUCCESS);
                ct = envelop.getBody().getContent();

                ResponseWrapper responseWrapper = new ResponseWrapper();
                responseWrapper.setHeader(envelop.getHeader());
                ValidateXSDHelper validator = new ValidateXSDHelper();
//                errorMsg = validator.validateWithStringXML(xml, "p25/" + Constants.MARD_PRO.MARD25 + type + envelop.getHeader().getSubject().getFunction() + ".xsd");
                json = new ResponseJson(false, null, 0L, "");
                if (errorMsg == null) {
                    switch (type) {
                        case Constants26.MARD26_TYPE.TYPE_11: //Phan hoi don XMK
                            PhanHoiDonDK phanHoiDonDK =ct.getPhanHoiDonDK();
                            responseWrapper.setData(phanHoiDonDK);
                            if (phanHoiDonDK!=null){
                                json = backendService.phanHoiDonDK(responseWrapper);
                            }
                            envelopReturn= createEnvelopReturn(maHoso,Constants.MARD_PRO.MARD26,header,json);
                            break;
                        case Constants26.MARD26_TYPE.TYPE_12: //CV mien kiem
                            CVMienKiem cvMienKiem =ct.getCvMienKiem();
                            responseWrapper.setData(cvMienKiem);
                            if (cvMienKiem!=null){
                                json=backendService.guiCVMienKiem(responseWrapper);
                            }
                            envelopReturn= createEnvelopReturn(maHoso,Constants.MARD_PRO.MARD26,header,json);
                            break;
                        case Constants26.MARD26_TYPE.TYPE_13: // Thu hoi CV
                            ThuHoiCVMienKiem thuHoiCVMienKiem =ct.getThuHoiCVMienKiem();
                            responseWrapper.setData(thuHoiCVMienKiem);
                            if(thuHoiCVMienKiem!=null){
                                json=backendService.thuHoiCVMienKiem(responseWrapper);
                            }
                            envelopReturn= createEnvelopReturn(maHoso,Constants.MARD_PRO.MARD26,header,json);
                            break;
                        default:
                            error = new Error26();
                            error.setErrorCode(Constants.ERROR.ERR04_CODE);
                            error.setErrorName(Constants.ERROR.ERR04);
                            envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD06, type, error);
                            break;
                    }
                } else {
                    error = new Error26();
                    error.setErrorCode(Constants.ERROR.ERR02_CODE);
                    error.setErrorName(errorMsg);
                    envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD06, type, error);
                }
            } catch (Exception ex) {
                error = new Error26();
                error.setErrorCode(Constants.ERROR.ERR02_CODE);
                error.setErrorName(Constants.ERROR.ERR02);
                envelopReturn = envelopeService.createEnvelopeError(maHoso, Constants.MARD_PRO.MARD25, type, error);

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
    private Envelope26 createEnvelopReturn(String fiMaHoSo, String msgType, Header26 header, ResponseJson json) {
        Envelope26 envelop;
        if (json.isSuccess()) {
            Content26 content = new Content26();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date today = Calendar.getInstance().getTime();
            content.setReceiveDate(formatter.format(today));
            Body26 body = envelopeService.createBody(content);
            envelop = envelopeService.createResponse(header, body);
        } else {
            Error26 error = new Error26();
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
    private String getType(Envelope26 envelop) {
        return envelop.getHeader().getSubject().getType();
    }

    /**
     * Lấy function
     *
     * @param fuction
     * @return
     */

}
