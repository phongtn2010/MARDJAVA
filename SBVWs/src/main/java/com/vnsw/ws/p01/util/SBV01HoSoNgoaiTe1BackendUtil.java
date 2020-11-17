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
import com.vnsw.ws.p01.entity.db.HoSoNgoaiTe1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collections;
import java.util.Date;

public class SBV01HoSoNgoaiTe1BackendUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(SBV01HoSoNgoaiTe1BackendUtil.class);

	public static HoSoNgoaiTe1 createHoSoNgoaiTe1(String url, HoSoNgoaiTe1 pHoSoNgoaiTe1) throws Exception {

		Map<String, Object> params = new HashMap<>();
		ResponseJson responseJson = createRestTemplate(url, pHoSoNgoaiTe1, HttpMethod.POST, params);
		ObjectMapper mapper = new ObjectMapper();
		if (responseJson.getData() != null) {
			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), HoSoNgoaiTe1.class);
		}
		return null;
	}

	public static HoSoNgoaiTe1 updateHoSoNgoaiTe1(String url, long primaryKey, HoSoNgoaiTe1 pHoSoNgoaiTe1) throws Exception {

		Map<String, Object> params = new HashMap<>();
		ResponseJson responseJson = createRestTemplate(url + "/" + primaryKey, pHoSoNgoaiTe1, HttpMethod.POST, params);
		ObjectMapper mapper = new ObjectMapper();
		if (responseJson.getData() != null) {
			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), HoSoNgoaiTe1.class);
		}
		return null;
	}

	public static boolean deleteHoSoNgoaiTe1(String url, long primaryKey) throws Exception {

		Map<String, Object> params = new HashMap<>();
		ResponseJson responseJson = createRestTemplate(url + "/" + primaryKey, null, HttpMethod.POST, params);
		ObjectMapper mapper = new ObjectMapper();
		if (responseJson.getData() != null) {
			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);
		}
		return false;
	}

	public static HoSoNgoaiTe1 getHoSoNgoaiTe1(String url, long primaryKey) throws Exception {

		Map<String, Object> params = new HashMap<>();
		ResponseJson responseJson = createRestTemplate(url+ "/" + primaryKey, null, HttpMethod.GET, params);
		ObjectMapper mapper = new ObjectMapper();
		if (responseJson.getData() != null) {
			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), HoSoNgoaiTe1.class);
		}
		return null;
	}

	public static HoSoNgoaiTe1 findByMaHoSo(String url, String maHoSo) throws Exception {

		Map<String, Object> params = new HashMap<>();
		if (maHoSo == null) maHoSo = ""; 
		params.put("maHoSo", maHoSo);
		ResponseJson responseJson = createRestTemplate(url, null, HttpMethod.GET, params);
		ObjectMapper mapper = new ObjectMapper();
		if (responseJson.getData() != null) {
			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), HoSoNgoaiTe1.class);
		}
		return null;
	}

	public static List<HoSoNgoaiTe1> searchHoSos(String url, String maSoThue, String maHoSo, int trangThai, int hinhThucXNK, String maCuaKhau, Date fromNgayTao, Date toNgayTao, int pageIndex, int pageSize) throws Exception {

		Map<String, Object> params = new HashMap<>();
		if (maSoThue == null) maSoThue = ""; 
		params.put("maSoThue", maSoThue);
		if (maHoSo == null) maHoSo = ""; 
		params.put("maHoSo", maHoSo);
		params.put("trangThai", trangThai);
		params.put("hinhThucXNK", hinhThucXNK);
		if (maCuaKhau == null) maCuaKhau = ""; 
		params.put("maCuaKhau", maCuaKhau);
		if (fromNgayTao != null)
			params.put("fromNgayTao", fromNgayTao.getTime());
		if (toNgayTao != null)
			params.put("toNgayTao", toNgayTao.getTime());
		params.put("pageIndex", pageIndex);
		params.put("pageSize", pageSize);
		ResponseJson responseJson = createRestTemplate(url, null, HttpMethod.GET, params);
		ObjectMapper mapper = new ObjectMapper();
		if (responseJson.getData() != null) {
			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<HoSoNgoaiTe1>>(){});
		}
		return Collections.emptyList();
	}

	public static long countHoSos(String url, String maSoThue, String maHoSo, int trangThai, int hinhThucXNK, String maCuaKhau, Date fromNgayTao, Date toNgayTao) throws Exception {

		Map<String, Object> params = new HashMap<>();
		if (maSoThue == null) maSoThue = ""; 
		params.put("maSoThue", maSoThue);
		if (maHoSo == null) maHoSo = ""; 
		params.put("maHoSo", maHoSo);
		params.put("trangThai", trangThai);
		params.put("hinhThucXNK", hinhThucXNK);
		if (maCuaKhau == null) maCuaKhau = ""; 
		params.put("maCuaKhau", maCuaKhau);
		if (fromNgayTao != null)
			params.put("fromNgayTao", fromNgayTao.getTime());
		if (toNgayTao != null)
			params.put("toNgayTao", toNgayTao.getTime());
		ResponseJson responseJson = createRestTemplate(url, null, HttpMethod.GET, params);
		ObjectMapper mapper = new ObjectMapper();
		if (responseJson.getData() != null) {
			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);
		}
		return 0;
	}

	private static ResponseJson createRestTemplate(String uri, Object body, HttpMethod httpMethod, Map<String, Object> params){

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
		if (params != null) {
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				builder.queryParam(entry.getKey(), String.valueOf(entry.getValue()));
			}
		}
		uri = builder.build().encode().toString();
		LOGGER.info("[callback url: {}]",uri);
		List<HttpMessageConverter<?>> converters = new ArrayList<>();
		converters.add(new MappingJackson2HttpMessageConverter());
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(converters);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Object> entity = new HttpEntity<>(body, headers);
		ResponseEntity<ResponseJson> response = restTemplate.exchange(uri, httpMethod, entity, ResponseJson.class);

		ResponseJson responseJson = response.getBody();
		if (responseJson.isSuccess() == false) {
			LOGGER.error("[createRestTemplate][ERROR >> {} ]",responseJson.getMessage());
		}
		return response.getBody();
	}

}