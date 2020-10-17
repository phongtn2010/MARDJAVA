package com.nsw.service;

import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.util.LogUtil;
import java.nio.charset.Charset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service("receiveService")
public class ReceiveServiceImpl implements ReceiveService {

    public static final Logger logger = LoggerFactory.getLogger(ReceiveServiceImpl.class);

    private static final String CLASS_NAME = "ReceiveServiceImpl";

    @Autowired
    RabbitMQService rabbitMQService;

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
        RabbitMQInfo mqInfo = rabbitMQService.getRabbitMQInfo();
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Object> entity = new HttpEntity<>(object, headers);
            ResponseEntity responseEntity = null;
            if ("POST".equals(method)) {
                responseEntity = restTemplate.postForEntity(url, entity, ResponseJson.class);
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
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
            LogUtil.addLog(ex);
        }
        return null;
    }

}
