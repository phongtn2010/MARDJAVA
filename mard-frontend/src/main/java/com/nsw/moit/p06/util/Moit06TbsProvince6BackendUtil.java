package com.nsw.moit.p06.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.moit.p06.model.TbsProvince6;

public class Moit06TbsProvince6BackendUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Moit06TbsProvince6BackendUtil.class);

	private Moit06TbsProvince6BackendUtil() {
	}

	public static TbsProvince6 geTbsProvince6(String url, String primaryKey) {

		try {
			Map<String, Object> params = new HashMap<>();
			params.put("provinceCode", primaryKey);
			ResponseJson responseJson = createRestTemplate(url, null, HttpMethod.GET, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbsProvince6.class);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public static List<TbsProvince6> findAll(String url) {

		try {
			Map<String, Object> params = new HashMap<>();
			ResponseJson responseJson = createRestTemplate(url, null, HttpMethod.GET, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbsProvince6>>(){});
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return Collections.emptyList();
	}

	

	private static ResponseJson createRestTemplate(String uri, Object body, HttpMethod httpMethod, Map<String, Object> params) {

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
		ResponseEntity<ResponseJson> response = restTemplate.exchange(uri, httpMethod, entity, ResponseJson.class);

		ResponseJson responseJson = response.getBody();
		if (!responseJson.isSuccess()) {
			LOGGER.error(responseJson.getMessage());
		}
		return response.getBody();
	}
}
