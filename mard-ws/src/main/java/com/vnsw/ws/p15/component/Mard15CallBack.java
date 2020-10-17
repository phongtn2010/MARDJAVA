package com.vnsw.ws.p15.component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

import com.vnsw.ws.p14.model.TbdHoSo14;
import com.vnsw.ws.p15.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
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
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;


/***
*
*
* @class CallBackUtil
* Created by Nguyen Van Quang
* 06/12/2018 11:158:06
*
*/
@Component
public class Mard15CallBack {

	private static final Logger LOGGER = LoggerFactory.getLogger(Mard15CallBack.class);

	private static final String BACKEND_KEY = "URI_BACKEND_ADDRESS";


	private final Environment environment;

	@Autowired
	public Mard15CallBack(Environment environment) {
		this.environment = environment;
	}

	public <T> T createRestTemplate(String uri, Object body, HttpMethod httpMethod, Map<String, Object> params, Class<T> clz) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
		if (params != null) {
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				if (!ObjectUtils.isEmpty(entry.getValue()))
					builder.queryParam(entry.getKey(), String.valueOf(entry.getValue()));
			}
		}
		uri = builder.build().encode().toString();
		System.out.println(uri);
		List<HttpMessageConverter<?>> converters = new ArrayList<>();
		converters.add(new MappingJackson2HttpMessageConverter());
		RestTemplate restTemplate = new RestTemplateBuilder().errorHandler(new RestTemplateResponseErrorHandler()).build();
		restTemplate.setMessageConverters(converters);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Object> entity = new HttpEntity<>(body, headers);
		ResponseEntity<T> response = restTemplate.exchange(uri, httpMethod, entity, clz);
		if (response.getStatusCode() != HttpStatus.OK) {
			throw new AppException("ERROR: " + response.getBody());
		}
		return response.getBody();
	}

	public <T> List<T> readJsonStringToList(String responseJson, Class<T> clz) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, clz);
				return mapper.readValue(mapper.writeValueAsString(responseJson), type);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return Collections.emptyList();
	}

	public <T> T readJsonStringToObject(String responseJson, Class<T> clz) {

		try {
			ObjectMapper mapper = new ObjectMapper();
				return mapper.readValue(mapper.writeValueAsString(responseJson), clz);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public <T> List<T> convertToList(List<T> dtos) {

		try {
			ObjectMapper mapper = new ObjectMapper();
				return mapper.convertValue(dtos, new TypeReference<List<T>>() { });
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return Collections.emptyList();
	}

	public Environment getEnvironment() {

		return environment;

	}

	protected String getURL(String uriKey) {

		return environment.getRequiredProperty(BACKEND_KEY) + uriKey;

	}

	static class AppException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public AppException(Object message) {
			super(String.format("ERROR: %s", message));
		}

	}

	public ResponseEntity<TbdHoSo15> getTbdHoSo15(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo15 tbdHoSo15 = createRestTemplate(getURL("/mard/15/tbdHoSo15/get/") + fiIdHoSo, null, HttpMethod.GET, null, TbdHoSo15.class);
		return ResponseEntity.ok().body(tbdHoSo15);
	}

	/**
	 * @param fiDocumentName - Type: String
	 * @return can return null or throw exception
	 */
	public ResponseEntity<List<TbdHoSo15>> findByFiDocumentName(@RequestParam(name = "fiDocumentName", required = false) String fiDocumentName) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentName", fiDocumentName);
		List<TbdHoSo15> tbdHoSo15s = createRestTemplate(getURL("/mard/15/tbdHoSo15/findByDocumentName"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdHoSo15s = mapper.convertValue(tbdHoSo15s, new TypeReference<List<TbdHoSo15>>() {});
		return ResponseEntity.ok().body(tbdHoSo15s);
	}

	/**
	 * @param fiDocumentType - Type: String
	 * @param fiDocumentName - Type: String
	 * @param fiTaxCode - Type: String
	 * @return can return null or throw exception
	 */
	public ResponseEntity<TbdHoSo15> findByFiDocumentTypeAndFiDocumentNameAndFiTaxCode(@RequestParam(name = "fiDocumentType", required = false) String fiDocumentType, @RequestParam(name = "fiDocumentName", required = false) String fiDocumentName, @RequestParam(name = "fiTaxCode", required = false) String fiTaxCode) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentType", fiDocumentType);
		params.put("fiDocumentName", fiDocumentName);
		params.put("fiTaxCode", fiTaxCode);
		TbdHoSo15 tbdHoSo15 = createRestTemplate(getURL("/mard/15/tbdHoSo15/findByDocumentTypeAndDocumentNameAndFiTaxCode"), null, HttpMethod.GET, params, TbdHoSo15.class);

		return ResponseEntity.ok().body(tbdHoSo15);
	}

	/**
	 * @param fiIdHoSo - Type: Long
	 * @return can return null or throw exception
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<TbdDinhKem15>> findByFiIdHoSoTbdDinhKem15(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdDinhKem15> tbdDinhKem15List = createRestTemplate(getURL("/mard/15/tbdDinhKem15/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem15List = mapper.convertValue(tbdDinhKem15List, new TypeReference<List<TbdDinhKem15>>() {});

		return ResponseEntity.ok().body(tbdDinhKem15List);
	}

	/**
	 * @param fiIdHoSo - Type: Long
	 * @param tbdHoSo15 - Type: TbdHoSo15
	 * @return may can null
	 */
	@RequestMapping(value = "/update/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo15> updateTbdHoSo15(@PathVariable("fiIdHoSo") Long fiIdHoSo, @RequestBody @Valid TbdHoSo15 tbdHoSo15) {
		tbdHoSo15 = createRestTemplate(getURL("/mard/15/tbdHoSo15/update/") + fiIdHoSo, tbdHoSo15, HttpMethod.POST, null, TbdHoSo15.class);
		return ResponseEntity.ok().body(tbdHoSo15);
	}


	/**
	 * @param tbdGiayPhep15 - Type: TbdGiayPhep15
	 * @return may can null
	 */
	public ResponseEntity<TbdGiayPhep15> createTbdGiayPhep15(@RequestBody @Valid TbdGiayPhep15 tbdGiayPhep15) {
		tbdGiayPhep15 = createRestTemplate(getURL("/mard/15/tbdGiayPhep15/create"), tbdGiayPhep15, HttpMethod.POST, null, TbdGiayPhep15.class);
		return ResponseEntity.ok().body(tbdGiayPhep15);
	}

	/**
	 * @param fiId - Type: Long
	 * @param tbdGiayPhep15 - Type: TbdGiayPhep15
	 * @return may can null
	 */
	public ResponseEntity<TbdGiayPhep15> updateTbdGiayPhep15(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdGiayPhep15 tbdGiayPhep15) {
		tbdGiayPhep15 = createRestTemplate(getURL("/mard/15/tbdGiayPhep15/update/") + fiId, tbdGiayPhep15, HttpMethod.POST, null, TbdGiayPhep15.class);
		return ResponseEntity.ok().body(tbdGiayPhep15);
	}

	/**
	 * @param fiId - Type: Long
	 * @return may can throw new Execption
	 */
	public ResponseEntity<TbdGiayPhep15> deleteTbdGiayPhep15(@PathVariable("fiId") Long fiId) {
		TbdGiayPhep15 tbdGiayPhep15 = createRestTemplate(getURL("/mard/15/tbdGiayPhep15/delete/") + fiId, null, HttpMethod.DELETE, null, TbdGiayPhep15.class);
		return ResponseEntity.ok().body(tbdGiayPhep15);
	}

	public ResponseEntity<TbdGiayPhep15> getTbdGiayPhep15(@PathVariable("fiId") Long fiId) {
		TbdGiayPhep15 tbdGiayPhep15 = createRestTemplate(getURL("/mard/15/tbdGiayPhep15/get/") + fiId, null, HttpMethod.GET, null, TbdGiayPhep15.class);
		return ResponseEntity.ok().body(tbdGiayPhep15);
	}

	/**
	 * @param pageableDTO - Type: PageableDTO
	 * @return may can null
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<TbdGiayPhep15>> findAll(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdGiayPhep15> tbdGiayPhep15List = createRestTemplate(getURL("/mard/15/tbdGiayPhep15/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep15List = mapper.convertValue(tbdGiayPhep15List, new TypeReference<List<TbdGiayPhep15>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep15List);
	}

	/**
	 * @param fiIdHoSo - Type: Long
	 * @return can return null or throw exception
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<TbdGiayPhep15>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdGiayPhep15> tbdGiayPhep15List = createRestTemplate(getURL("/mard/15/tbdGiayPhep15/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep15List = mapper.convertValue(tbdGiayPhep15List, new TypeReference<List<TbdGiayPhep15>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep15List);
	}

	/**
	 * @param fiDispatchNo - Type: String
	 * @return can return null or throw exception
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<TbdGiayPhep15>> findByFiDispatchNo(@RequestParam(name = "fiDispatchNo", required = false) String fiDispatchNo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDispatchNo", fiDispatchNo);
		List<TbdGiayPhep15> tbdGiayPhep15List = createRestTemplate(getURL("/mard/15/tbdGiayPhep15/findByFiDispatchNo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep15List = mapper.convertValue(tbdGiayPhep15List, new TypeReference<List<TbdGiayPhep15>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep15List);
	}

	/**
	 * @param tbdGPThuoc15 - Type: TbdGPThuoc15
	 * @return may can null
	 */
	public ResponseEntity<TbdGPThuoc15> createTbdGPThuoc15(@RequestBody @Valid TbdGPThuoc15 tbdGPThuoc15) {
		tbdGPThuoc15 = createRestTemplate(getURL("/mard/15/tbdGPThuoc15/create"), tbdGPThuoc15, HttpMethod.POST, null, TbdGPThuoc15.class);
		return ResponseEntity.ok().body(tbdGPThuoc15);
	}

	/**
	 * @param tbdKetQuaXuLy15 - Type: TbdKetQuaXuLy15
	 * @return may can null
	 */
	public ResponseEntity<TbdKetQuaXuLy15> createTbdKetQuaXuLy15(@RequestBody @Valid TbdKetQuaXuLy15 tbdKetQuaXuLy15) {
		tbdKetQuaXuLy15 = createRestTemplate(getURL("/mard/15/tbdKetQuaXuLy15/create"), tbdKetQuaXuLy15, HttpMethod.POST, null, TbdKetQuaXuLy15.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy15);
	}

	/**
	 * @param tbdThanhToan15 - Type: TbdThanhToan15
	 * @return may can null
	 */
	public ResponseEntity<TbdThanhToan15> createTbdThanhToan15(@RequestBody @Valid TbdThanhToan15 tbdThanhToan15) {
		tbdThanhToan15 = createRestTemplate(getURL("/mard/15/tbdThanhToan15/create"), tbdThanhToan15, HttpMethod.POST, null, TbdThanhToan15.class);
		return ResponseEntity.ok().body(tbdThanhToan15);
	}

	/**
	 * @param tbdThongBaoPhi15 - Type: TbdThongBaoPhi15
	 * @return may can null
	 */
	public ResponseEntity<TbdThongBaoPhi15> createTbdThongBaoPhi15(@RequestBody @Valid TbdThongBaoPhi15 tbdThongBaoPhi15) {
		tbdThongBaoPhi15 = createRestTemplate(getURL("/mard/15/tbdThongBaoPhi15/create"), tbdThongBaoPhi15, HttpMethod.POST, null, TbdThongBaoPhi15.class);
		return ResponseEntity.ok().body(tbdThongBaoPhi15);
	}

	/**
	 * @param fiIdHoSo - Type: Long
	 * @return can return null or throw exception
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<TbdThuoc15>> findByFiIdHoSoTbdThuoc15(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdThuoc15> tbdThuoc15List = createRestTemplate(getURL("/mard/15/tbdThuoc15/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThuoc15List = mapper.convertValue(tbdThuoc15List, new TypeReference<List<TbdThuoc15>>() {});

		return ResponseEntity.ok().body(tbdThuoc15List);
	}

	/**
	 * @param fiIdHoSo - Type: Long
	 * @return can return null or throw exception
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<TbdGPThuoc15>> findByFiIdHoSoTbdGPThuoc15(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdGPThuoc15> tbdThuoc15List = createRestTemplate(getURL("/mard/15/tbdGPThuoc15/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThuoc15List = mapper.convertValue(tbdThuoc15List, new TypeReference<List<TbdGPThuoc15>>() {});

		return ResponseEntity.ok().body(tbdThuoc15List);
	}

	public ResponseEntity<TbdGPThuoc15> deleteTbdGPThuoc15(@PathVariable("fiId") Long fiId) {
		TbdGPThuoc15 tbdGPThuoc15 = createRestTemplate(getURL("/mard/15/tbdGPThuoc15/delete/") + fiId, null, HttpMethod.DELETE, null, TbdGPThuoc15.class);
		return ResponseEntity.ok().body(tbdGPThuoc15);
	}
}