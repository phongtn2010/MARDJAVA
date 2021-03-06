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
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collections;

public class Moit07TbdHoSo7BackendUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(Moit07TbdHoSo7BackendUtil.class);

	private Moit07TbdHoSo7BackendUtil() {
	}

	public static TbdHoSo7 createTbdHoSo7(String url, TbdHoSo7 pTbdHoSo7) {

		try {
			Map<String, Object> params = new HashMap<>();
			ResponseJson responseJson = createRestTemplate(url, pTbdHoSo7, HttpMethod.POST, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdHoSo7.class);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public static TbdHoSo7 updateTbdHoSo7(String url, Long primaryKey, TbdHoSo7 pTbdHoSo7) {

		try {
			Map<String, Object> params = new HashMap<>();
			ResponseJson responseJson = createRestTemplate(url + "/" + primaryKey, pTbdHoSo7, HttpMethod.POST, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdHoSo7.class);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public static boolean deleteTbdHoSo7(String url, Long primaryKey) {

		try {
			Map<String, Object> params = new HashMap<>();
			ResponseJson responseJson = createRestTemplate(url + "/" + primaryKey, null, HttpMethod.GET, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return false;
	}

	public static boolean remove(String host, Long primaryKey) {

		try {
			Map<String, Object> params = new HashMap<>();
			ResponseJson responseJson = createRestTemplate( host + "/moit/07/hoSo/remove/" + primaryKey, null, HttpMethod.GET, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return false;
	}

	public static TbdHoSo7 getTbdHoSo7(String url, Long primaryKey) {

		try {
			Map<String, Object> params = new HashMap<>();
			ResponseJson responseJson = createRestTemplate(url+ "/" + primaryKey, null, HttpMethod.GET, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdHoSo7.class);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public static List<TbdHoSo7> findByMaHoSo(String url, String maHoSo) {

		try {
			Map<String, Object> params = new HashMap<>();
			if (maHoSo == null) maHoSo = ""; 
			params.put(MAHOSO, maHoSo);
			ResponseJson responseJson = createRestTemplate(url, null, HttpMethod.GET, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdHoSo7>>(){});
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return Collections.emptyList();
	}

	public static TbdHoSo7 findByIdHoSo(String url, Long idHoSo) {

		try {
			Map<String, Object> params = new HashMap<>();
			params.put(IDHOSO, idHoSo);
			ResponseJson responseJson = createRestTemplate(url, null, HttpMethod.GET, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdHoSo7.class);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public static List<TbdHoSo7> search(String url, TbdHoSo7SearchItem item) {

		try {
			Map<String, Object> params = new HashMap<>();
			ResponseJson responseJson = createRestTemplate(url, item, HttpMethod.POST, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdHoSo7>>(){});
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return Collections.emptyList();
	}

	public static long count(String url, TbdHoSo7SearchItem item) {

		try {
			Map<String, Object> params = new HashMap<>();
			ResponseJson responseJson = createRestTemplate(url, item, HttpMethod.POST, params);
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return 0;
	}
	
	public static ResponseJson page(String url, TbdHoSo7SearchItem item) {

		ResponseJson returnResponseJson = new ResponseJson();
		returnResponseJson.setData(Collections.emptyList());
		returnResponseJson.setTotal(0L);
		try {
			Map<String, Object> params = new HashMap<>();
			ResponseJson responseJson = createRestTemplate(url, item, HttpMethod.POST, params);
			ObjectMapper mapper = new ObjectMapper();
			
			if (responseJson.getData() != null) {
				returnResponseJson.setData(readJsonStringToList(mapper.writeValueAsString(responseJson.getData()), TbdHoSo7DTO.class));
				returnResponseJson.setTotal(responseJson.getTotal());
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return returnResponseJson;
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
		HttpEntity<Object> entity = new HttpEntity<>(headers);
		if (body != null) entity = new HttpEntity<>(body, headers);
		ResponseEntity<ResponseJson> response = restTemplate.exchange(uri, httpMethod, entity, ResponseJson.class);

		ResponseJson responseJson = response.getBody();
		if (!responseJson.isSuccess()) {
			LOGGER.error(responseJson.getMessage());
		}
		return response.getBody();
	}

	private static final String MAHOSO = "maHoSo";
	private static final String IDHOSO = "idHoSo";



}