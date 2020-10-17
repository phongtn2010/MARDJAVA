package com.vnsw.ws.p1.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.envelop.Header;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.p1.bo.UpdateStatusBO;
import com.vnsw.ws.p1.common.Constants01;
import com.vnsw.ws.p1.evelop.Header01;
import com.vnsw.ws.p1.message.ResponseWrapper;
import com.vnsw.ws.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.nio.charset.StandardCharsets;

@Service("backendService01")
public class BackendService01Impl implements BackendService01 {

    private static final String CLASS_NAME = "BackendServiceImpl";

    private static final String URI_BACKEND_ADDRESS = "URI_BACKEND_ADDRESS";

    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    private Environment environment;

    @Autowired
    ReceiveService01 receiveService;

    @Override
    public ResponseJson getDataFromRestUri(String restUri) {
        ResponseJson responJson = null;
        try {
            URI REST_URL = new URI(restUri);
            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(StandardCharsets.UTF_8);
            restTemplate.getMessageConverters().add(formConverter);
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity responseEntity = restTemplate.getForEntity(REST_URL, ResponseJson.class);
            responJson = (ResponseJson) responseEntity.getBody();
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }

        return responJson;
    }

    @Override
    public ResponseJson updateHoSoStatus(Header01 header, String fiMaHoso, Long fiTrangthai, String fiLydo) {
        ResponseJson responJson = null;
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants01.RES_URI.URI_UPDATE_STATUS_HOSO;
            UpdateStatusBO obj = new UpdateStatusBO();
            obj.setFiMaHoso(fiMaHoso);
            obj.setFiTrangthai(fiTrangthai);
            obj.setFiLydo(fiLydo);
            ResponseWrapper responseWrapper = new ResponseWrapper(header, obj);
            responJson = receiveService.callResforEntity(restUri, responseWrapper, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson updateKQTDhoso01(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants01.RES_URI.URI_UPDATE_KQTD_HOSO01);
    }

    @Override
    public ResponseJson updateTBDYhoso01(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants01.RES_URI.URI_UPDATE_XACNHANDON);
    }

    @Override
    public ResponseJson updateKQYCSuaHoSo01(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants01.RES_URI.URI_UPDATE_KETQUA_XIN_SUA_HS);
    }

    @Override
    public ResponseJson updateKQYCRutHoSo01(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants01.RES_URI.URI_UPDATE_KETQUA_XIN_RUT_HS);
    }

    @Override
    public ResponseJson updateTBApPhi01(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants01.RES_URI.URI_UPDATE_TB_APPHI);
    }

    @Override
    public ResponseJson updateTBXacNhanPhi01(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants01.RES_URI.URI_UPDATE_XACNHAN_PHI);
    }

    @Override
    public ResponseJson updateCVKQYCXuatKhau01(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants01.RES_URI.URI_UPDATE_KQYC_XUAT_KHAU);
    }

    @Override
    public ResponseJson updateTBKQYCHuyCNKD(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants01.RES_URI.URI_UPDATE_KETQUA_HUY_CNKD);
    }

    @Override
    public ResponseJson updateTBKQYCSuaCNKD(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants01.RES_URI.URI_UPDATE_KETQUA_XIN_SUA_CNKD);
    }

    @Override
    public ResponseJson updateCNKD13A(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants01.RES_URI.URI_UPDATE_CNKD_13A);
    }

    @Override
    public ResponseJson updateCNKD13B(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants01.RES_URI.URI_UPDATE_CNKD_13B);
    }

    @Override
    public ResponseJson updateCNKDChina(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants01.RES_URI.URI_UPDATE_CNKD_CHINA);
    }

    @Override
    public ResponseJson updateCNKDHongKongChicken(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants01.RES_URI.URI_UPDATE_CNKD_HONGKONG_CHICKEN);
    }

    @Override
    public ResponseJson updateCNKDHongKongPig(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants01.RES_URI.URI_UPDATE_CNKD_HONGKONG_PIG);
    }

    @Override
    public ResponseJson updateCNKDMalaysia(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants01.RES_URI.URI_UPDATE_CNKD_MALAYSIA);
    }

    private ResponseJson callToBackendService(ResponseWrapper responseWrapper, String path) {
        ResponseJson responseJson = new ResponseJson();
        try {
            String restUri = environment.getRequiredProperty(URI_BACKEND_ADDRESS)
                    + path;
            responseJson = receiveService.callResforEntity(restUri, responseWrapper, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            responseJson.setSuccess(false);
            responseJson.setMessage(ex.getMessage());
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responseJson;
    }
}
