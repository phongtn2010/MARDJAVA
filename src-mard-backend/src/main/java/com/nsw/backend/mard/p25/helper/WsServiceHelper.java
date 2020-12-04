package com.nsw.backend.mard.p25.helper;

import com.nsw.backend.mard.p25.constant.Constant25;
import com.nsw.backend.mard.p25.dto.SendMessage;
import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import com.nsw.backend.mard.p25.model.TbdHanghoaMK25;
import com.nsw.backend.mard.p25.model.TbdHoso25;
import com.nsw.backend.util.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class WsServiceHelper {
    private static final Logger log = LoggerFactory.getLogger(WsServiceHelper.class);

    private WsServiceHelper() {
    }

    public static ResponseJson createSendRequest(String url, SendMessage sendData) {
        log.debug("Attempt send request\nURL: {}\nData: {}", url, sendData);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SendMessage> entity = new HttpEntity<>(sendData, headers);
        ResponseJson response = new ResponseJson();
        response.setSuccess(false);
        try {
            response = restTemplate.postForObject(url, entity, ResponseJson.class);
            log.debug("Response: {}", response);
        }
        catch(Exception ex){
            log.debug("Call WS Error!");
        }
        return response;
    }
}
