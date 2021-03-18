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
import com.vnsw.ws.p25.envelop.Content25;
import com.vnsw.ws.p25.envelop.Envelope25;
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

    private static final String URI_VNC_ADDRESS = "URI_VNC_ADDRESS";
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
        String restUri = environment.getRequiredProperty(URI_BACKEND_ADDRESS) + Constants25.RES_URI.URI_XAC_NHAN_DON;
        return callServiceBackend(responseWrapper,restUri);
    }


    @Override
    public ResponseJson phanhoiYeucauSuaHoso(ResponseWrapper responseWrapper) {
        String restUri = environment.getRequiredProperty(URI_BACKEND_ADDRESS) + Constants25.RES_URI.URI_UPDATE_KETQUA_XIN_SUA_HS;
        return callServiceBackend(responseWrapper,restUri);
    }

    @Override
    public ResponseJson ketQuaXuLy(ResponseWrapper responseWrapper) {
        String restUri = environment.getRequiredProperty(URI_BACKEND_ADDRESS) + Constants25.RES_URI.URI_KET_QUA_XU_LY;
        return callServiceBackend(responseWrapper,restUri);
    }

    @Override
    public ResponseJson thuHoiGDK(ResponseWrapper responseWrapper) {
        String restUri = environment.getRequiredProperty(URI_BACKEND_ADDRESS) + Constants25.RES_URI.URI_THU_HOI_GDK;
        return callServiceBackend(responseWrapper,restUri);
    }

    @Override
    public ResponseJson xuLyKQ(ResponseWrapper responseWrapper) {
        String restUri = environment.getRequiredProperty(URI_BACKEND_ADDRESS) + Constants25.RES_URI.URI_TCCD_XU_LY_KQ;
        return callServiceBackend(responseWrapper,restUri);
    }

    @Override
    public ResponseJson tccdGuiKQKT(ResponseWrapper responseWrapper) {
        String restUri = environment.getRequiredProperty(URI_BACKEND_ADDRESS) + Constants25.RES_URI.URI_TCCD_GUI_KQKT;
        return callServiceBackend(responseWrapper,restUri);
    }

    @Override
    public ResponseJson giayXNCL(ResponseWrapper responseWrapper) {
        String restUri = environment.getRequiredProperty(URI_BACKEND_ADDRESS) + Constants25.RES_URI.URI_GIAY_XNCL;
        return callServiceBackend(responseWrapper,restUri);
    }

    @Override
    public ResponseJson thuHoiGiayXNCL(ResponseWrapper responseWrapper) {
        String restUri = environment.getRequiredProperty(URI_BACKEND_ADDRESS) + Constants25.RES_URI.URI_THU_HOIGIAY_XNCL;
        return callServiceBackend(responseWrapper,restUri);
    }

    @Override
    public ResponseJson tiepNhanHD2D(ResponseWrapper responseWrapper) {
        String restUri = environment.getRequiredProperty(URI_BACKEND_ADDRESS) + Constants25.RES_URI.URI_TIEP_NHAN_HS2D;
        return callServiceBackend(responseWrapper,restUri);
    }

    @Override
    public ResponseJson guiHosoVNC(Envelope25 content) {
        try {
            String restUri = environment.getRequiredProperty(URI_VNC_ADDRESS) + "/controller/get-message";
            return callServiceVNC(content,restUri);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseJson(false,null,0L,"");
        }

    }
    private ResponseJson callServiceVNC(Envelope25 content, String restUri){
        ResponseJson responseJson = new ResponseJson();
        try {
            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(StandardCharsets.UTF_8);
            restTemplate.getMessageConverters().add(formConverter);
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity responseEntity = null;
            responseEntity = restTemplate.postForEntity(restUri, content, ResponseJson.class);
//            return (ResponseJson) responseEntity.getBody();
            responseJson = receiveService.callResforEntity(restUri, content, Constants.RES_METHOD.POST);
        } catch (Exception ex) {
            responseJson.setSuccess(false);
            responseJson.setMessage(ex.getMessage());
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            return responseJson;
        }
        return responseJson;
    }

    private ResponseJson callServiceBackend(ResponseWrapper responseWrapper, String restUri){
        ResponseJson responseJson = new ResponseJson();
        try {
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
