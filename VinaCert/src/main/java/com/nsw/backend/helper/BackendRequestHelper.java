/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.helper;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.nsw.backend.model.JSON.ResponseJson;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import com.nsw.backend.model.ResponeXML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author phongnv
 */
public class BackendRequestHelper {

    private static final String TAG = "BackendRequestHelper";
    //private static final int LONG_CACHE_TIME_IN_SECONDS = 1;// * 60;
    private static LoadingCache<String, ResponseJson> categoryCache;
    private final Logger logger = LoggerFactory.getLogger(BackendRequestHelper.class);
    
//    @Autowired
//    RabbitMQService rabbitMQService;

    private static BackendRequestHelper instance;

    public static BackendRequestHelper getInstance() {
        synchronized (BackendRequestHelper.class) {
            if (instance == null) {
                instance = new BackendRequestHelper();
            }
            return instance;
        }
    }

    public ResponseJson getFromCache(String uri) {
        try {
            if (categoryCache == null) {
                return null;
            }
            return categoryCache.get(uri);
        } catch (ExecutionException e) {
            logger.error(TAG + "getFromCache", e);
        }
        return null;
    }

    /**
     * Th?c hi?n request b?t k?
     *
     * @param <T>
     * @param restUri
     * @param body
     * @return
     */
    public <T> @ResponseBody ResponeXML doPostRequest(String restUri, T body) {
        ResponeXML xmlRespone = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<T> entity = new HttpEntity<>(body, headers);
            xmlRespone = restTemplate.postForObject(restUri, entity, ResponeXML.class);
        } catch (Exception ex) {
            logger.error("loi"+ex);
        }

        return xmlRespone;
    }

    /**
     * Thực hiện get đến backend
     *
     * @param restUri
     * @return
     */
    public @ResponseBody
    ResponseJson doGetRequest(String restUri) {
        if (restUri == null || restUri.isEmpty()) {
            return null;
        }
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            json = restTemplate.getForObject(restUri, ResponseJson.class);
        } catch (Exception ex) {
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
     * Thực hiện request phương thức và thông tin truyền vào
     *
     * @param <T>
     * @param restUri
     * @param method
     * @param body
     * @param params
     * @return
     */
    public <T> @ResponseBody ResponseJson doCustomRequest(String restUri, HttpMethod method, T body, Map<String, String> params) {
        ResponseJson json = null;

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<T> entity = new HttpEntity<>(body, headers);
            ResponseEntity<ResponseJson> jsonBody = restTemplate.exchange(restUri, method, entity, ResponseJson.class, params);
            return jsonBody.getBody();
        } catch (Exception ex) {

            json = new ResponseJson();

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());
        }

        return json;
    }
}
