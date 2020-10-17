package com.nsw.sbv.p01.util;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/***
 *
 *
 * @class CallBackUtil
 * Created by Nguyen Van Quang
 * 22/08/2018 13:00:37
 *
 */
@Component
@PropertySource("classpath:sbv_api.properties")
public class SBV01CallBackUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(SBV01CallBackUtil.class);

    @Autowired
    private Environment environment;

    public Object createRestTemplate(String uri, Object body, HttpMethod httpMethod, Map<String, Object> params) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                builder.queryParam(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        uri = builder.build().encode().toString();
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new MappingJackson2HttpMessageConverter());
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(converters);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity = new HttpEntity<>(body, headers);
        ResponseEntity<Object> response = restTemplate.exchange(uri, httpMethod, entity, Object.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new AppException("ERROR: " + response.getBody());
        }
        return response.getBody();
    }

    public <T> List<T> readJsonStringToList(Object responseJson, Class<T> clz) {

        try {

            ObjectMapper objectMapper = new ObjectMapper();
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, clz);
            return objectMapper.readValue(objectMapper.writeValueAsString(responseJson), type);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public <T> T readJsonStringToObject(Object responseJson, Class<T> clz) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(mapper.writeValueAsString(responseJson), clz);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    public Environment getEnvironment() {

        return environment;

    }

    protected String getURL(String uriKey) {
        return environment.getRequiredProperty("sbv.01.backend") + environment.getRequiredProperty(uriKey);
    }
}