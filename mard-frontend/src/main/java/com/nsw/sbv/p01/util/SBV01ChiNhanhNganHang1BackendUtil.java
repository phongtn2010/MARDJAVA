package com.nsw.sbv.p01.util;

import com.nsw.sbv.p01.model.*;
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
import com.nsw.common.model.json.ResponseJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collections;

public class SBV01ChiNhanhNganHang1BackendUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(SBV01ChiNhanhNganHang1BackendUtil.class);

	private SBV01ChiNhanhNganHang1BackendUtil() {
	}

	public static ChiNhanhNganHang1 getChiNhanhNganHang1(String url, long primaryKey) {

		try {
			Map<String, Object> params = new HashMap<>();
			ResponseJson responseJson = createRestTemplate(url+ "/" + primaryKey, null, HttpMethod.GET, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), ChiNhanhNganHang1.class);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public static ChiNhanhNganHang1 findByMaChiNhanh(String url, String maChiNhanh) {

		try {
			Map<String, Object> params = new HashMap<>();
			if (maChiNhanh == null) maChiNhanh = ""; 
			params.put(MACHINHANH, maChiNhanh);
			ResponseJson responseJson = createRestTemplate(url, null, HttpMethod.GET, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), ChiNhanhNganHang1.class);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public static List<ChiNhanhNganHang1> getAllChiNhanhNganHang1s(String url) {

		try {
			Map<String, Object> params = new HashMap<>();
			ResponseJson responseJson = createRestTemplate(url, null, HttpMethod.GET, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<ChiNhanhNganHang1>>(){});
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

	private static final String MACHINHANH = "maChiNhanh";



}