package com.vnsw.ws.p7.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.p7.common.Constants07;
import com.vnsw.ws.p7.message.ResponseWrapper;
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


@Service("backendService07")
public class BackendService07Impl implements BackendService07 {

    private static final String CLASS_NAME = "BackendServiceImpl";

    private static final String URI_BACKEND_ADDRESS = "URI_BACKEND_ADDRESS";

    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    private Environment environment;

    @Autowired
    ReceiveService07 receiveService;


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
    public ResponseJson updateKQTD(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants07.RES_URI.URI_UPDATE_KQTD);
    }

    @Override
    public ResponseJson updateXacNhanDonDangKy(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants07.RES_URI.URI_UPDATE_XACNHANDON);
    }

    @Override
    public ResponseJson updateKetquaXinSuaHoso(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants07.RES_URI.URI_UPDATE_KETQUA_XIN_SUA_HS);
    }

    @Override
    public ResponseJson updateKetquaXinRutHoso(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants07.RES_URI.URI_UPDATE_KETQUA_XIN_RUT_HS);
    }

    @Override
    public ResponseJson updateThongbaoApphi(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants07.RES_URI.URI_UPDATE_TB_APPHI);
    }

    @Override
    public ResponseJson updateXacnhanPhi(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants07.RES_URI.URI_UPDATE_XACNHAN_PHI);
    }

    @Override
    public ResponseJson updateThongbaoLohangKhongdat(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants07.RES_URI.URI_UPDATE_TB_LOHANG_KHONGDAT);
    }

    @Override
    public ResponseJson updateCNVC(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants07.RES_URI.URI_UPDATE_GIAY_CNVC);
    }

    @Override
    public ResponseJson updateCNKD(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants07.RES_URI.URI_UPDATE_GIAY_CNKD);
    }

    @Override
    public ResponseJson updateTuchoiXinsuaGCN(ResponseWrapper responseWrapper) {
        return callToBackendService(responseWrapper, Constants07.RES_URI.URI_UPDATE_TUCHOI_XINSUA_GCN);
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
