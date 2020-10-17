/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.helper;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.nsw.common.model.ResponseUpload;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.service.RabbitMQService;
import com.nsw.util.TypeReference;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
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
    
    @Autowired
    RabbitMQService rabbitMQService;

    private static BackendRequestHelper instance;

    public BackendRequestHelper() {
        // T?o cache danh m?c
//        categoryCache = CacheBuilder.newBuilder()
//                .maximumSize(100)
//                .expireAfterWrite(LONG_CACHE_TIME_IN_SECONDS, TimeUnit.SECONDS)
//                .build(
//                        new CacheLoader<String, ResponseJson>() {
//                    @Override
//                    public ResponseJson load(String key) throws Exception {
//                        ResponseJson result = new ResponseJson();
//                        try {
//                            RestTemplate restTemplate = new RestTemplate();
//                            result = restTemplate.getForObject(key, ResponseJson.class);
//                            if (result != null && result.getData() != null) {
//                                if (result.getData() instanceof List<?>) {
//                                    if (((List<Object>) result.getData()).isEmpty()) {
//                                        throw new Exception();
//                                    }
//                                }
//                                return result;
//                            } else {
//                                throw new Exception();
//                            }
//                        } catch (Exception ex) {
//                            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG
//                                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
//                            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
//                            logger.error(TAG + AppConstant.MESSAGE_SEPARATOR + "CacheBuilder::categoryCache", ex);
//                            throw new Exception(ex);
//                        }
//                        // return result;
//                    }
//                }
//                );
    }

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
            logger.error(TAG + AppConstant.MESSAGE_SEPARATOR + "getFromCache", e);
        }
        return null;
    }

    /**
     * Post một form lên server, trả về kiểu dữ liệu T
     *
     * @param <T>
     * @param uri
     * @param parts
     * @param ref
     * @return
     */
    public <T> @ResponseBody T doFormPostRequest(URI uri, MultiValueMap<String, Object> parts, Class<T> ref) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            formConverter.setCharset(Charset.forName("UTF8"));
            restTemplate.getMessageConverters().add(formConverter);
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            T res = restTemplate.postForObject(uri, parts, ref);
            return res;
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            logger.error(TAG + AppConstant.MESSAGE_SEPARATOR + "doPostRequest", ex);
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
    public <T> @ResponseBody ResponseJson doPostRequest(String restUri, T body) {
        ResponseJson json = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<T> entity = new HttpEntity<>(body, headers);
            json = restTemplate.postForObject(restUri, entity, ResponseJson.class);
        } catch (Exception ex) {
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
//            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
            logger.error(TAG + AppConstant.MESSAGE_SEPARATOR + "doRequest", ex);
            ex.printStackTrace();
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
            logger.error(TAG + AppConstant.MESSAGE_SEPARATOR + "doRequest", ex);
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
            System.out.println("Uri " + restUri + ";");
            RestTemplate restTemplate = new RestTemplate();
            MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
            jsonHttpMessageConverter.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            restTemplate.getMessageConverters().add(jsonHttpMessageConverter);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<T> entity = new HttpEntity<>(body, headers);
            ResponseEntity<ResponseJson> jsonBody = restTemplate.exchange(restUri, method, entity, ResponseJson.class, params);
            return jsonBody.getBody();
        } catch (Exception ex) {
            System.out.println("error do request" + ex.toString());
            logger.error(TAG + AppConstant.MESSAGE_SEPARATOR + "doRequest", ex);

            json = new ResponseJson();

            json.setSuccess(false);
            json.setData(null);
            json.setMessage(ex.getMessage());
        }

        return json;
    }
}
