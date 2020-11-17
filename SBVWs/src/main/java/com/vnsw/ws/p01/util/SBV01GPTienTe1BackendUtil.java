package com.vnsw.ws.p01.util;


import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p01.entity.db.GPTienTe1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collections;

public class SBV01GPTienTe1BackendUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(SBV01GPTienTe1BackendUtil.class);

	public static GPTienTe1 createGPTienTe1(String url, GPTienTe1 pGPTienTe1) throws Exception {

		Map<String, Object> params = new HashMap<>();
		ResponseJson responseJson = createRestTemplate(url, pGPTienTe1, HttpMethod.POST, params);
		ObjectMapper mapper = new ObjectMapper();
		if (responseJson.getData() != null) {
			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), GPTienTe1.class);
		}
		return null;
	}

	public static GPTienTe1 updateGPTienTe1(String url, long primaryKey, GPTienTe1 pGPTienTe1) throws Exception {

		Map<String, Object> params = new HashMap<>();
		ResponseJson responseJson = createRestTemplate(url + "/" + primaryKey, pGPTienTe1, HttpMethod.POST, params);
		ObjectMapper mapper = new ObjectMapper();
		if (responseJson.getData() != null) {
			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), GPTienTe1.class);
		}
		return null;
	}

	public static boolean deleteGPTienTe1(String url, long primaryKey) throws Exception {

		Map<String, Object> params = new HashMap<>();
		ResponseJson responseJson = createRestTemplate(url + "/" + primaryKey, null, HttpMethod.POST, params);
		ObjectMapper mapper = new ObjectMapper();
		if (responseJson.getData() != null) {
			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);
		}
		return false;
	}

	public static GPTienTe1 getGPTienTe1(String url, long primaryKey) throws Exception {

		Map<String, Object> params = new HashMap<>();
		ResponseJson responseJson = createRestTemplate(url+ "/" + primaryKey, null, HttpMethod.GET, params);
		ObjectMapper mapper = new ObjectMapper();
		if (responseJson.getData() != null) {
			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), GPTienTe1.class);
		}
		return null;
	}

	public static List<GPTienTe1> getByIdCapGXNHoSo(String url) throws Exception {

		Map<String, Object> params = new HashMap<>();
		ResponseJson responseJson = createRestTemplate(url, null, HttpMethod.GET, params);
		ObjectMapper mapper = new ObjectMapper();
		if (responseJson.getData() != null) {
			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<GPTienTe1>>(){});
		}
		return Collections.emptyList();
	}

	private static ResponseJson createRestTemplate(String uri, Object body, HttpMethod httpMethod, Map<String, Object> params) throws Exception {

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
		if (params != null) {
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				builder.queryParam(entry.getKey(), String.valueOf(entry.getValue()));
			}
		}
		uri = builder.build().encode().toString();
		LOGGER.info("[callback url]["+ uri +"]");
		List<HttpMessageConverter<?>> converters = new ArrayList<>();
		converters.add(new MappingJackson2HttpMessageConverter());
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(converters);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Object> entity = new HttpEntity<Object>(body, headers);
		ResponseEntity<ResponseJson> response = restTemplate.exchange(uri, httpMethod, entity, ResponseJson.class);

		ResponseJson responseJson = response.getBody();
		if (responseJson.isSuccess() == false) {
			LOGGER.error("[createRestTemplate][ERROR >> "+ responseJson.getMessage() +"]");
		}
		return response.getBody();
	}

}