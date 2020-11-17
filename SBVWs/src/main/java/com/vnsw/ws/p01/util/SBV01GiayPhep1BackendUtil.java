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
import com.vnsw.ws.p01.entity.db.GiayPhep1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SBV01GiayPhep1BackendUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(SBV01GiayPhep1BackendUtil.class);

	public static GiayPhep1 createGiayPhep1(String url, GiayPhep1 pGiayPhep1) throws Exception {

		Map<String, Object> params = new HashMap<>();
		ResponseJson responseJson = createRestTemplate(url, pGiayPhep1, HttpMethod.POST, params);
		ObjectMapper mapper = new ObjectMapper();
		if (responseJson.getData() != null) {
			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), GiayPhep1.class);
		}
		return null;
	}

	public static GiayPhep1 updateGiayPhep1(String url, long primaryKey, GiayPhep1 pGiayPhep1) throws Exception {

		Map<String, Object> params = new HashMap<>();
		ResponseJson responseJson = createRestTemplate(url + "/" + primaryKey, pGiayPhep1, HttpMethod.POST, params);
		ObjectMapper mapper = new ObjectMapper();
		if (responseJson.getData() != null) {
			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), GiayPhep1.class);
		}
		return null;
	}

	public static boolean deleteGiayPhep1(String url, long primaryKey) throws Exception {

		Map<String, Object> params = new HashMap<>();
		ResponseJson responseJson = createRestTemplate(url + "/" + primaryKey, null, HttpMethod.POST, params);
		ObjectMapper mapper = new ObjectMapper();
		if (responseJson.getData() != null) {
			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);
		}
		return false;
	}

	public static GiayPhep1 getGiayPhep1(String url, long primaryKey) throws Exception {

		Map<String, Object> params = new HashMap<>();
		ResponseJson responseJson = createRestTemplate(url+ "/" + primaryKey, null, HttpMethod.GET, params);
		ObjectMapper mapper = new ObjectMapper();
		if (responseJson.getData() != null) {
			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), GiayPhep1.class);
		}
		return null;
	}

	public static GiayPhep1 findBySoGiayPhep(String url, String soGiayPhep) throws Exception {

		Map<String, Object> params = new HashMap<>();
		if (soGiayPhep == null) soGiayPhep = ""; 
		params.put("soGiayPhep", soGiayPhep);
		ResponseJson responseJson = createRestTemplate(url, null, HttpMethod.GET, params);
		
		ObjectMapper mapper = new ObjectMapper();
		if (responseJson.getData() != null) {
			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), GiayPhep1.class);
		}
		return null;
	}

	public static GiayPhep1 getByIdHoSo(String url, long idHoSo) throws Exception {

		Map<String, Object> params = new HashMap<>();
		params.put("idHoSo", idHoSo);
		ResponseJson responseJson = createRestTemplate(url, null, HttpMethod.GET, params);
		ObjectMapper mapper = new ObjectMapper();
		if (responseJson.getData() != null) {
			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), GiayPhep1.class);
		}
		return null;
	}

	private static ResponseJson createRestTemplate(String uri, Object body, HttpMethod httpMethod, Map<String, Object> params) throws Exception {

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
		if (params != null) {
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				builder.queryParam(entry.getKey(), String.valueOf(entry.getValue()));
			}
		}
		uri = builder.build().encode().toString();
		LOGGER.info("[callback url][{}]", uri);
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
			LOGGER.error("[createRestTemplate][ERROR >> {}]",responseJson.getMessage());
		}
		return response.getBody();
	}

}