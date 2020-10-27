/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p25.service;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.p25.common.Constants25;
import com.vnsw.ws.p25.message.ResponseWrapper;
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

@Service("backendService25")
public class BackendService25Impl implements BackendService25 {

    private static final String CLASS_NAME = "BackendServiceImpl";

    private static final String URI_BACKEND_ADDRESS = "URI_BACKEND_ADDRESS";

    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    private Environment environment;

    @Autowired
    ReceiveService25 receiveService;

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
    public ResponseJson xacNhanDon(ResponseWrapper responseWrapper) {
        ResponseJson responseJson = new ResponseJson();
        try {
            String restUri = environment.getRequiredProperty(URI_BACKEND_ADDRESS) + Constants25.RES_URI.URI_XAC_NHAN_DON;
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


    @Override
    public ResponseJson phanhoiYeucauSuaHoso(ResponseWrapper responseWrapper) {
        ResponseJson responseJson = new ResponseJson();
        try {
            String restUri = environment.getRequiredProperty(URI_BACKEND_ADDRESS) + Constants25.RES_URI.URI_UPDATE_KETQUA_XIN_SUA_HS;
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

    @Override
    public ResponseJson ketQuaXuLy(ResponseWrapper responseWrapper) {
        ResponseJson responseJson = new ResponseJson();
        try {
            String restUri = environment.getRequiredProperty(URI_BACKEND_ADDRESS) + Constants25.RES_URI.URI_KET_QUA_XU_LY;
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

    private ResponseJson makeSuccess(){
        return new ResponseJson(true, null, null,"Thành công");
    }


}
