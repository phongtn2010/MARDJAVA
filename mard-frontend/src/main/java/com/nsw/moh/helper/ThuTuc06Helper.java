/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nsw.constant.AppConstant;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.moh.p06.model.SearchForm06;
import com.nsw.moh.p06.model.SendMessage;
import com.nsw.moh.p06.model.Tbdhoso6;
import com.nsw.service.RabbitMQService;
import com.nsw.util.LogUtil;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Nhan
 */
public class ThuTuc06Helper {

    private static final String CLASS_NAME = "ThuTuc06Helper";
    final Logger logger = LoggerFactory.getLogger(ThuTuc06Helper.class);

    @Autowired
    RabbitMQService rabbitMQService;

    public ResponseJson getDanhMuc(String restUri, RabbitMQInfo mqInfo) {
        ResponseJson result = new ResponseJson();
        try {
            RestTemplate restTemplate = new RestTemplate();
            result = restTemplate.getForObject(restUri, ResponseJson.class);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
        return result;
    }

    /**
     * *
     * Tao moi ho so
     *
     * @param restUri
     * @param hoso
     * @return
     */
    public @ResponseBody
    ResponseJson createHoSo(String restUri, Tbdhoso6 hoso) {
        ResponseJson json = null;

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            System.out.println(restUri);
            HttpEntity<Tbdhoso6> entity = new HttpEntity<>(hoso, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            if (json == null) {
                json = new ResponseJson();
            }

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());
        }

        return json;
    }

    /**
     * Search Ho so
     *
     * @author PhongNV9
     * @since 30/03/2017
     * @param restUri
     * @param searchForm
     * @return
     */
    public ResponseJson searchHoSo(String restUri, SearchForm06 searchForm) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<SearchForm06> entity = new HttpEntity<>(searchForm, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            if (json == null) {
                json = new ResponseJson();
            }
            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());
        }

        return json;
    }

    /**
     * *
     * Cap nhat du lieu ho so
     *
     * @param restUri
     * @param hoso
     * @return
     */
    public ResponseJson updateHoSo(String restUri, Tbdhoso6 hoso) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Tbdhoso6> entity = new HttpEntity<>(hoso, headers);
            ResponseEntity<ResponseJson> jsonBody = restTemplate.exchange(restUri, HttpMethod.PUT, entity, ResponseJson.class);
            return jsonBody.getBody();

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            //if (json == null) {
            json = new ResponseJson();
            //}
            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());
        }
        return json;
    }

    /*
     * Lay thong tin ho so
     *
     * @param restUri
     * @param Id
     * @return
     */
    public Tbdhoso6 getHoSo(String restUri, Long Id) {
        ResponseJson json = null;
        Tbdhoso6 hoso = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(Id.toString(), headers);

            Map<String, String> params = new HashMap<>();
            params.put("id", Id.toString());

            restUri += Id;
            ResponseEntity<ResponseJson> jsonBody = restTemplate.exchange(restUri, HttpMethod.GET, entity, ResponseJson.class, params);

            json = jsonBody.getBody();
            if (json.isSuccess()) {

                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonData = mapper.writeValueAsString(json.getData());
                hoso = mapper.readValue(jsonData, Tbdhoso6.class);
            } else {
                hoso = new Tbdhoso6();
            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            if (hoso == null) {
                hoso = new Tbdhoso6();
            }
        }

        return hoso;
    }

    public ResponseJson sendHoSo(String restUri, SendMessage data, RabbitMQInfo mqInfo) {
        ResponseJson json;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<SendMessage> entity = new HttpEntity<>(data, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);

            //return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json = new ResponseJson();

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }

        return json;
    }

    /**
     * Xoa ho so
     *
     * @param restUri
     * @param Id
     * @return
     */
    public ResponseJson deleteHoSo(String restUri, String Id) {

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(Id, headers);

            Map<String, String> params = new HashMap<>();
            params.put("id", Id);
            restUri += Id + "/";
            ResponseEntity<ResponseJson> jsonBody = restTemplate.exchange(restUri, HttpMethod.DELETE, entity, ResponseJson.class, params);

            return jsonBody.getBody();
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            //logger.error(ex.getMessage());
//            if (json == null) {
//                json = new ResponseJson();
//            }
            ResponseJson json = new ResponseJson();
            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());
            return json;
        }

    }
}
