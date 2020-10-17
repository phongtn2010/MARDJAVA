package com.nsw.sbv.p01.util;

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

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.sbv.p01.model.HoSoNgoaiTe1SearchItem;
import com.nsw.sbv.p01.model.HoSoNgoaiTeModel;

public class SBV01HoSoNgoaiTeCustomUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(SBV01HoSoNgoaiTeCustomUtil.class);

	
	private SBV01HoSoNgoaiTeCustomUtil() {
	}

	public static ResponseJson search(String url, HoSoNgoaiTe1SearchItem searchItem) {
		ResponseJson returnResponseJson = new ResponseJson();
		returnResponseJson.setData(Collections.emptyList());
		try {
			Map<String, Object> params = new HashMap<>();
			ResponseJson responseJson = createRestTemplate(url, searchItem, HttpMethod.POST, params);
			ObjectMapper mapper = new ObjectMapper();
			
			if (responseJson.getData() != null) {
				returnResponseJson.setData(readJsonStringToList(mapper.writeValueAsString(responseJson.getData()), HoSoNgoaiTeModel.class));
				returnResponseJson.setTotal(responseJson.getTotal());
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return returnResponseJson;
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
	
	private static <T> List<T> readJsonStringToList(String jsonString, Class<T> clz) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, clz);
			return mapper.readValue(jsonString, type);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return Collections.emptyList();
	}
}
