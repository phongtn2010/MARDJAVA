/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p8.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.p8.common.Constants08;
import com.vnsw.ws.p8.message.ResponseWrapper;
import com.vnsw.ws.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.nio.charset.Charset;

@Service("backendService08")
public class BackendService08Impl implements BackendService08 {

    private static final String CLASS_NAME = "BackendServiceImpl";

    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    private Environment environment;

    @Autowired
    ReceiveService08 receiveService;

    /**
     * Lay du lieu tu Backend theo Uri
     *
     * @param restUri
     * @return
     */
    @Override
    public ResponseJson getDataFromRestUri(String restUri) {
        ResponseJson responJson = null;
        try {
            URI REST_URL = new URI(restUri);
            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(Charset.forName("UTF8"));
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

    private ResponseJson makeSuccess(){
        return new ResponseJson(true, null, null,"Thành công");
    }

    @Override
    public ResponseJson ketquaThamdinh(ResponseWrapper responseWrapper) {
        ResponseJson responJson = new ResponseJson();
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants08.RES_URI.URI_UPDATE_KQTD;
            responJson = receiveService.callResforEntity(restUri, responseWrapper, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            responJson.setSuccess(false);
            responJson.setMessage(ex.getMessage());
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson yeucauSuadoiBosung(ResponseWrapper responseWrapper) {
        return makeSuccess();
    }

    @Override
    public ResponseJson yeucauRutHS(ResponseWrapper responseWrapper) {
        return makeSuccess();
    }

    @Override
    public ResponseJson tuchoiYeucauRutHS(ResponseWrapper responseWrapper) {
        return makeSuccess();
    }

    @Override
    public ResponseJson dongyYeuCauRutHS(ResponseWrapper responseWrapper) {
        return makeSuccess();
    }

    @Override
    public ResponseJson tuchoiYeuCauRutHS(ResponseWrapper responseWrapper) {
        return makeSuccess();
    }

    @Override
    public ResponseJson congvanVSTY(ResponseWrapper responseWrapper) {
        ResponseJson responJson = new ResponseJson();
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants08.RES_URI.URI_UPDATE_VSTY;
            responJson = receiveService.callResforEntity(restUri, responseWrapper, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            responJson.setSuccess(false);
            responJson.setMessage(ex.getMessage());
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson congvanKDNK(ResponseWrapper responseWrapper) {
        ResponseJson responJson = new ResponseJson();
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants08.RES_URI.URI_UPDATE_KDNK;
            responJson = receiveService.callResforEntity(restUri, responseWrapper, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            responJson.setSuccess(false);
            responJson.setMessage(ex.getMessage());
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson suaCongvanKDNK(ResponseWrapper responseWrapper) {
        ResponseJson responJson = new ResponseJson();
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants08.RES_URI.URI_UPDATE_KDNK;
            responJson = receiveService.callResforEntity(restUri, responseWrapper, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            responJson.setSuccess(false);
            responJson.setMessage(ex.getMessage());
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson ketquaVSTYKhongdat(ResponseWrapper responseWrapper) {
        ResponseJson responJson = new ResponseJson();
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants08.RES_URI.URI_UPDATE_KQVSTY;
            responJson = receiveService.callResforEntity(restUri, responseWrapper, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            responJson.setSuccess(false);
            responJson.setMessage(ex.getMessage());
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson phanhoiYeucauSuaHoso(ResponseWrapper responseWrapper) {
        ResponseJson responJson = new ResponseJson();
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants08.RES_URI.URI_UPDATE_PHANHOI_YEUCAU_SUAHS;
            responJson = receiveService.callResforEntity(restUri, responseWrapper, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            responJson.setSuccess(false);
            responJson.setMessage(ex.getMessage());
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

    @Override
    public ResponseJson phanhoiYeucauRutHoso(ResponseWrapper responseWrapper) {
        ResponseJson responJson = new ResponseJson();
        try {
            String restUri = environment.getRequiredProperty("URI_BACKEND_ADDRESS") + Constants08.RES_URI.URI_UPDATE_PHANHOI_YEUCAU_RUTHS;
            responJson = receiveService.callResforEntity(restUri, responseWrapper, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            responJson.setSuccess(false);
            responJson.setMessage(ex.getMessage());
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return responJson;
    }

}
