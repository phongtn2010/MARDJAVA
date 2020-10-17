package com.vnsw.ws.p14.component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

import com.vnsw.ws.p14.model.*;
import com.vnsw.ws.p15.component.RestTemplateResponseErrorHandler;
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
* 06/12/2018 11:148:06
*
*/
@Component
public class Mard14CallBack {

	private static final Logger LOGGER = LoggerFactory.getLogger(Mard14CallBack.class);

	private static final String BACKEND_KEY = "URI_BACKEND_ADDRESS";


	private final Environment environment;

	@Autowired
	public Mard14CallBack(Environment environment) {
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

	public ResponseEntity<TbdHoSo14> getTbdHoSo14(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo14 tbdHoSo14 = createRestTemplate(getURL("/mard/14/tbdHoSo14/get/") + fiIdHoSo, null, HttpMethod.GET, null, TbdHoSo14.class);
		return ResponseEntity.ok().body(tbdHoSo14);
	}

	/**
	 * @param fiDocumentName - Type: String
	 * @return can return null or throw exception
	 */
	public ResponseEntity<List<TbdHoSo14>> findByFiDocumentName(@RequestParam(name = "fiDocumentName", required = false) String fiDocumentName) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentName", fiDocumentName);
		List<TbdHoSo14> tbdHoSo14 = createRestTemplate(getURL("/mard/14/tbdHoSo14/findByDocumentName"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdHoSo14 = mapper.convertValue(tbdHoSo14, new TypeReference<List<TbdHoSo14>>() {});

		return ResponseEntity.ok().body(tbdHoSo14);
	}

	/**
	 * @param fiDocumentType - Type: String
	 * @param fiDocumentName - Type: String
	 * @param fiTaxCode - Type: String
	 * @return can return null or throw exception
	 */
	public ResponseEntity<TbdHoSo14> findByFiDocumentTypeAndFiDocumentNameAndFiTaxCode(@RequestParam(name = "fiDocumentType", required = false) String fiDocumentType, @RequestParam(name = "fiDocumentName", required = false) String fiDocumentName, @RequestParam(name = "fiTaxCode", required = false) String fiTaxCode) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentType", fiDocumentType);
		params.put("fiDocumentName", fiDocumentName);
		params.put("fiTaxCode", fiTaxCode);
		TbdHoSo14 tbdHoSo14 = createRestTemplate(getURL("/mard/14/tbdHoSo14/findByDocumentTypeAndDocumentNameAndFiTaxCode"), null, HttpMethod.GET, params, TbdHoSo14.class);

		return ResponseEntity.ok().body(tbdHoSo14);
	}

	/**
	 * @param fiIdHoSo - Type: Long
	 * @return can return null or throw exception
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<TbdDinhKem14>> findByFiIdHoSoTbdDinhKem14(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdDinhKem14> tbdDinhKem14List = createRestTemplate(getURL("/mard/14/tbdDinhKem14/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem14List = mapper.convertValue(tbdDinhKem14List, new TypeReference<List<TbdDinhKem14>>() {});

		return ResponseEntity.ok().body(tbdDinhKem14List);
	}

	/**
	 * @param fiIdHoSo - Type: Long
	 * @param tbdHoSo14 - Type: TbdHoSo14
	 * @return may can null
	 */
	@RequestMapping(value = "/update/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo14> updateTbdHoSo14(@PathVariable("fiIdHoSo") Long fiIdHoSo, @RequestBody @Valid TbdHoSo14 tbdHoSo14) {
		tbdHoSo14 = createRestTemplate(getURL("/mard/14/tbdHoSo14/update/") + fiIdHoSo, tbdHoSo14, HttpMethod.POST, null, TbdHoSo14.class);
		return ResponseEntity.ok().body(tbdHoSo14);
	}


	/**
	 * @param tbdGiayPhep14 - Type: TbdGiayPhep14
	 * @return may can null
	 */
	public ResponseEntity<TbdGiayPhep14> createTbdGiayPhep14(@RequestBody @Valid TbdGiayPhep14 tbdGiayPhep14) {
		tbdGiayPhep14 = createRestTemplate(getURL("/mard/14/tbdGiayPhep14/create"), tbdGiayPhep14, HttpMethod.POST, null, TbdGiayPhep14.class);
		return ResponseEntity.ok().body(tbdGiayPhep14);
	}

	/**
	 * @param fiId - Type: Long
	 * @param tbdGiayPhep14 - Type: TbdGiayPhep14
	 * @return may can null
	 */
	public ResponseEntity<TbdGiayPhep14> updateTbdGiayPhep14(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdGiayPhep14 tbdGiayPhep14) {
		tbdGiayPhep14 = createRestTemplate(getURL("/mard/14/tbdGiayPhep14/update/") + fiId, tbdGiayPhep14, HttpMethod.POST, null, TbdGiayPhep14.class);
		return ResponseEntity.ok().body(tbdGiayPhep14);
	}

	/**
	 * @param fiId - Type: Long
	 * @return may can throw new Execption
	 */
	public ResponseEntity<TbdGiayPhep14> deleteTbdGiayPhep14(@PathVariable("fiId") Long fiId) {
		TbdGiayPhep14 tbdGiayPhep14 = createRestTemplate(getURL("/mard/14/tbdGiayPhep14/delete/") + fiId, null, HttpMethod.DELETE, null, TbdGiayPhep14.class);
		return ResponseEntity.ok().body(tbdGiayPhep14);
	}

	public ResponseEntity<TbdGPThuoc14> deleteTbdGPThuoc14(@PathVariable("fiId") Long fiId) {
		TbdGPThuoc14 tbdGiayPhep14 = createRestTemplate(getURL("/mard/14/tbdGPThuoc14/delete/") + fiId, null, HttpMethod.DELETE, null, TbdGPThuoc14.class);
		return ResponseEntity.ok().body(tbdGiayPhep14);
	}

	public ResponseEntity<TbdGiayPhep14> getTbdGiayPhep14(@PathVariable("fiId") Long fiId) {
		TbdGiayPhep14 tbdGiayPhep14 = createRestTemplate(getURL("/mard/14/tbdGiayPhep14/get/") + fiId, null, HttpMethod.GET, null, TbdGiayPhep14.class);
		return ResponseEntity.ok().body(tbdGiayPhep14);
	}

	/**
	 * @param pageableDTO - Type: PageableDTO
	 * @return may can null
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<TbdGiayPhep14>> findAll(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdGiayPhep14> tbdGiayPhep14List = createRestTemplate(getURL("/mard/14/tbdGiayPhep14/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep14List = mapper.convertValue(tbdGiayPhep14List, new TypeReference<List<TbdGiayPhep14>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep14List);
	}

	/**
	 * @param fiIdHoSo - Type: Long
	 * @return can return null or throw exception
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<TbdGiayPhep14>> findTbdGiayPhep14ByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdGiayPhep14> tbdGiayPhep14List = createRestTemplate(getURL("/mard/14/tbdGiayPhep14/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep14List = mapper.convertValue(tbdGiayPhep14List, new TypeReference<List<TbdGiayPhep14>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep14List);
	}

	public ResponseEntity<List<TbdGPThuoc14>> findTbdGPThuoc14ByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdGPThuoc14> tbdGiayPhep14List = createRestTemplate(getURL("/mard/14/tbdGPThuoc14/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep14List = mapper.convertValue(tbdGiayPhep14List, new TypeReference<List<TbdGPThuoc14>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep14List);
	}

	/**
	 * @param fiDispatchNo - Type: String
	 * @return can return null or throw exception
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<TbdGiayPhep14>> findByFiDispatchNo(@RequestParam(name = "fiDispatchNo", required = false) String fiDispatchNo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDispatchNo", fiDispatchNo);
		List<TbdGiayPhep14> tbdGiayPhep14List = createRestTemplate(getURL("/mard/14/tbdGiayPhep14/findByFiDispatchNo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep14List = mapper.convertValue(tbdGiayPhep14List, new TypeReference<List<TbdGiayPhep14>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep14List);
	}

	/**
	 * @param tbdGPThuoc14 - Type: TbdGPThuoc14
	 * @return may can null
	 */
	public ResponseEntity<TbdGPThuoc14> createTbdGPThuoc14(@RequestBody @Valid TbdGPThuoc14 tbdGPThuoc14) {
		tbdGPThuoc14 = createRestTemplate(getURL("/mard/14/tbdGPThuoc14/create"), tbdGPThuoc14, HttpMethod.POST, null, TbdGPThuoc14.class);
		return ResponseEntity.ok().body(tbdGPThuoc14);
	}

	/**
	 * @param tbdKetQuaXuLy14 - Type: TbdKetQuaXuLy14
	 * @return may can null
	 */
	public ResponseEntity<TbdKetQuaXuLy14> createTbdKetQuaXuLy14(@RequestBody @Valid TbdKetQuaXuLy14 tbdKetQuaXuLy14) {
		tbdKetQuaXuLy14 = createRestTemplate(getURL("/mard/14/tbdKetQuaXuLy14/create"), tbdKetQuaXuLy14, HttpMethod.POST, null, TbdKetQuaXuLy14.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy14);
	}

	/**
	 * @param tbdThanhToan14 - Type: TbdThanhToan14
	 * @return may can null
	 */
	public ResponseEntity<TbdThanhToan14> createTbdThanhToan14(@RequestBody @Valid TbdThanhToan14 tbdThanhToan14) {
		tbdThanhToan14 = createRestTemplate(getURL("/mard/14/tbdThanhToan14/create"), tbdThanhToan14, HttpMethod.POST, null, TbdThanhToan14.class);
		return ResponseEntity.ok().body(tbdThanhToan14);
	}

	/**
	 * @param tbdThongBaoPhi14 - Type: TbdThongBaoPhi14
	 * @return may can null
	 */
	public ResponseEntity<TbdThongBaoPhi14> createTbdThongBaoPhi14(@RequestBody @Valid TbdThongBaoPhi14 tbdThongBaoPhi14) {
		tbdThongBaoPhi14 = createRestTemplate(getURL("/mard/14/tbdThongBaoPhi14/create"), tbdThongBaoPhi14, HttpMethod.POST, null, TbdThongBaoPhi14.class);
		return ResponseEntity.ok().body(tbdThongBaoPhi14);
	}

	/**
	 * @param fiIdHoSo - Type: Long
	 * @return can return null or throw exception
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<TbdThuoc14>> findByFiIdHoSoTbdThuoc14(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdThuoc14> tbdThuoc14List = createRestTemplate(getURL("/mard/14/tbdThuoc14/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThuoc14List = mapper.convertValue(tbdThuoc14List, new TypeReference<List<TbdThuoc14>>() {});

		return ResponseEntity.ok().body(tbdThuoc14List);
	}

	/**
	 * @param fiIdHoSo - Type: Long
	 * @return can return null or throw exception
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<TbdThanhToan14>> findByFiIdHoSoTbdThanhToan14(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdThanhToan14> tbdThanhToan14List = createRestTemplate(getURL("/mard/14/tbdThanhToan14/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThanhToan14List = mapper.convertValue(tbdThanhToan14List, new TypeReference<List<TbdThanhToan14>>() {});

		return ResponseEntity.ok().body(tbdThanhToan14List);
	}

	@RequestMapping(value = "/update/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdThanhToan14> updateTbdThanhToan14(@PathVariable("fiId") Long fiIdHoSo, @RequestBody @Valid TbdThanhToan14 tbdThanhToan14) {
		tbdThanhToan14 = createRestTemplate(getURL("/mard/14/tbdThanhToan14/update/") + fiIdHoSo, tbdThanhToan14, HttpMethod.POST, null, TbdThanhToan14.class);
		return ResponseEntity.ok().body(tbdThanhToan14);
	}

	@RequestMapping(value = "/findByFiDocumentType", method = RequestMethod.POST)
	public ResponseEntity<List<TbsMucDich14>> findTbsMucDichByFiDocumentType(@RequestParam(name = "fiDocumentType")String fiDocumentType) {


		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentType", fiDocumentType);
		List<TbsMucDich14> tbsMucDich14List = createRestTemplate(getURL("/mard/14/tbsMucDich14/findByFiDocumentType"), null, HttpMethod.POST, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsMucDich14List = mapper.convertValue(tbsMucDich14List, new TypeReference<List<TbsMucDich14>>() {});

		return ResponseEntity.ok().body(tbsMucDich14List);
	}


}