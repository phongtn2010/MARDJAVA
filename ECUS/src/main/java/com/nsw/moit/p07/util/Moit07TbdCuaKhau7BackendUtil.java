package com.nsw.moit.p07.util;

import com.nsw.moit.p07.model.*;
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

public class Moit07TbdCuaKhau7BackendUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(Moit07TbdCuaKhau7BackendUtil.class);

	private Moit07TbdCuaKhau7BackendUtil() {
	}

	public static TbdCuaKhau7 createTbdCuaKhau7(String url, TbdCuaKhau7 pTbdCuaKhau7) {

		try {
			Map<String, Object> params = new HashMap<>();
			ResponseJson responseJson = createRestTemplate(url, pTbdCuaKhau7, HttpMethod.POST, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdCuaKhau7.class);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public static TbdCuaKhau7 updateTbdCuaKhau7(String url, Long primaryKey, TbdCuaKhau7 pTbdCuaKhau7) {

		try {
			Map<String, Object> params = new HashMap<>();
			ResponseJson responseJson = createRestTemplate(url + "/" + primaryKey, pTbdCuaKhau7, HttpMethod.POST, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdCuaKhau7.class);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public static boolean deleteTbdCuaKhau7(String url, Long primaryKey) {

		try {
			Map<String, Object> params = new HashMap<>();
			ResponseJson responseJson = createRestTemplate(url + "/" + primaryKey, null, HttpMethod.POST, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return false;
	}

	public static TbdCuaKhau7 getTbdCuaKhau7(String url, Long primaryKey) {

		try {
			Map<String, Object> params = new HashMap<>();
			ResponseJson responseJson = createRestTemplate(url+ "/" + primaryKey, null, HttpMethod.GET, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdCuaKhau7.class);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public static List<TbdCuaKhau7> findByIdHoSoAndMaCuaKhau(String url, Long idHoSo, String maCuaKhau) {

		try {
			Map<String, Object> params = new HashMap<>();
			params.put(IDHOSO, idHoSo);
			if (maCuaKhau == null) maCuaKhau = ""; 
			params.put(MACUAKHAU, maCuaKhau);
			ResponseJson responseJson = createRestTemplate(url, null, HttpMethod.GET, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdCuaKhau7>>(){});
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return Collections.emptyList();
	}

	public static List<TbdCuaKhau7> findByIdHoSoAndHoatDongOrderByIdCuaKhauAsc(String url, Long idHoSo, Integer hoatDong) {

		try {
			Map<String, Object> params = new HashMap<>();
			params.put(IDHOSO, idHoSo);
			params.put(HOATDONG, hoatDong);
			ResponseJson responseJson = createRestTemplate(url, null, HttpMethod.GET, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdCuaKhau7>>(){});
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return Collections.emptyList();
	}

	public static List<TbdCuaKhau7> getAllCuaKhaus(String url) {

		try {
			Map<String, Object> params = new HashMap<>();
			ResponseJson responseJson = createRestTemplate(url, null, HttpMethod.GET, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdCuaKhau7>>(){});
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

	private static final String IDHOSO = "idHoSo";
	private static final String MACUAKHAU = "maCuaKhau";
	private static final String HOATDONG = "hoatDong";



}