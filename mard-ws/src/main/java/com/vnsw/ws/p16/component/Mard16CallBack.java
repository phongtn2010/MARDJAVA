
package com.vnsw.ws.p16.component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

import com.vnsw.ws.p15.component.RestTemplateResponseErrorHandler;
import com.vnsw.ws.p16.model.*;
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
 * 06/12/2018 11:168:06
 *
 */
@Component
public class Mard16CallBack {

	private static final Logger LOGGER = LoggerFactory.getLogger(Mard16CallBack.class);

	private static final String BACKEND_KEY = "URI_BACKEND_ADDRESS";


	private final Environment environment;

	@Autowired
	public Mard16CallBack(Environment environment) {
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

	public ResponseEntity<TbdHoSo16> getTbdHoSo16(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo16 tbdHoSo16 = createRestTemplate(getURL("/mard/16/tbdHoSo16/get/") + fiIdHoSo, null, HttpMethod.GET, null, TbdHoSo16.class);
		return ResponseEntity.ok().body(tbdHoSo16);
	}

	/**
	 * @param fiDocumentName - Type: String
	 * @return can return null or throw exception
	 */
	public ResponseEntity<List<TbdHoSo16>> findByFiDocumentName(@RequestParam(name = "fiDocumentName", required = false) String fiDocumentName) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentName", fiDocumentName);
		List<TbdHoSo16> tbdHoSo16 = createRestTemplate(getURL("/mard/16/tbdHoSo16/findByDocumentName"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdHoSo16 = mapper.convertValue(tbdHoSo16, new TypeReference<List<TbdHoSo16>>() {});
		return ResponseEntity.ok().body(tbdHoSo16);
	}

	/**
	 * @param fiDocumentType - Type: String
	 * @param fiDocumentName - Type: String
	 * @param fiTaxCode - Type: String
	 * @return can return null or throw exception
	 */
	public ResponseEntity<TbdHoSo16> findByFiDocumentTypeAndFiDocumentNameAndFiTaxCode(@RequestParam(name = "fiDocumentType", required = false) String fiDocumentType, @RequestParam(name = "fiDocumentName", required = false) String fiDocumentName, @RequestParam(name = "fiTaxCode", required = false) String fiTaxCode) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentType", fiDocumentType);
		params.put("fiDocumentName", fiDocumentName);
		params.put("fiTaxCode", fiTaxCode);
		TbdHoSo16 tbdHoSo16 = createRestTemplate(getURL("/mard/16/tbdHoSo16/findByDocumentTypeAndDocumentNameAndFiTaxCode"), null, HttpMethod.GET, params, TbdHoSo16.class);

		return ResponseEntity.ok().body(tbdHoSo16);
	}

	/**
	 * @param fiIdHoSo - Type: Long
	 * @return can return null or throw exception
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<TbdDinhKem16>> findByFiIdHoSoTbdDinhKem16(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdDinhKem16> tbdDinhKem16List = createRestTemplate(getURL("/mard/16/tbdDinhKem16/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem16List = mapper.convertValue(tbdDinhKem16List, new TypeReference<List<TbdDinhKem16>>() {});

		return ResponseEntity.ok().body(tbdDinhKem16List);
	}

	/**
	 * @param fiIdHoSo - Type: Long
	 * @param tbdHoSo16 - Type: TbdHoSo16
	 * @return may can null
	 */
	@RequestMapping(value = "/update/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo16> updateTbdHoSo16(@PathVariable("fiIdHoSo") Long fiIdHoSo, @RequestBody @Valid TbdHoSo16 tbdHoSo16) {
		tbdHoSo16 = createRestTemplate(getURL("/mard/16/tbdHoSo16/update/") + fiIdHoSo, tbdHoSo16, HttpMethod.POST, null, TbdHoSo16.class);
		return ResponseEntity.ok().body(tbdHoSo16);
	}


	/**
	 * @param tbdGiayPhep16 - Type: TbdGiayPhep16
	 * @return may can null
	 */
	public ResponseEntity<TbdGiayPhep16> createTbdGiayPhep16(@RequestBody @Valid TbdGiayPhep16 tbdGiayPhep16) {
		tbdGiayPhep16 = createRestTemplate(getURL("/mard/16/tbdGiayPhep16/create"), tbdGiayPhep16, HttpMethod.POST, null, TbdGiayPhep16.class);
		return ResponseEntity.ok().body(tbdGiayPhep16);
	}

	/**
	 * @param fiId - Type: Long
	 * @param tbdGiayPhep16 - Type: TbdGiayPhep16
	 * @return may can null
	 */
	public ResponseEntity<TbdGiayPhep16> updateTbdGiayPhep16(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdGiayPhep16 tbdGiayPhep16) {
		tbdGiayPhep16 = createRestTemplate(getURL("/mard/16/tbdGiayPhep16/update/") + fiId, tbdGiayPhep16, HttpMethod.POST, null, TbdGiayPhep16.class);
		return ResponseEntity.ok().body(tbdGiayPhep16);
	}

	/**
	 * @param fiId - Type: Long
	 * @return may can throw new Execption
	 */
	public ResponseEntity<TbdGiayPhep16> deleteTbdGiayPhep16(@PathVariable("fiId") Long fiId) {
		TbdGiayPhep16 tbdGiayPhep16 = createRestTemplate(getURL("/mard/16/tbdGiayPhep16/delete/") + fiId, null, HttpMethod.DELETE, null, TbdGiayPhep16.class);
		return ResponseEntity.ok().body(tbdGiayPhep16);
	}

	public ResponseEntity<TbdGiayPhep16> getTbdGiayPhep16(@PathVariable("fiId") Long fiId) {
		TbdGiayPhep16 tbdGiayPhep16 = createRestTemplate(getURL("/mard/16/tbdGiayPhep16/get/") + fiId, null, HttpMethod.GET, null, TbdGiayPhep16.class);
		return ResponseEntity.ok().body(tbdGiayPhep16);
	}

	/**
	 * @param pageableDTO - Type: PageableDTO
	 * @return may can null
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<TbdGiayPhep16>> findAll(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdGiayPhep16> tbdGiayPhep16List = createRestTemplate(getURL("/mard/16/tbdGiayPhep16/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep16List = mapper.convertValue(tbdGiayPhep16List, new TypeReference<List<TbdGiayPhep16>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep16List);
	}

	/**
	 * @param fiIdHoSo - Type: Long
	 * @return can return null or throw exception
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<TbdGiayPhep16>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdGiayPhep16> tbdGiayPhep16List = createRestTemplate(getURL("/mard/16/tbdGiayPhep16/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep16List = mapper.convertValue(tbdGiayPhep16List, new TypeReference<List<TbdGiayPhep16>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep16List);
	}

	/**
	 * @param fiDispatchNo - Type: String
	 * @return can return null or throw exception
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<TbdGiayPhep16>> findByFiDispatchNo(@RequestParam(name = "fiDispatchNo", required = false) String fiDispatchNo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDispatchNo", fiDispatchNo);
		List<TbdGiayPhep16> tbdGiayPhep16List = createRestTemplate(getURL("/mard/16/tbdGiayPhep16/findByFiDispatchNo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdGiayPhep16List = mapper.convertValue(tbdGiayPhep16List, new TypeReference<List<TbdGiayPhep16>>() {});

		return ResponseEntity.ok().body(tbdGiayPhep16List);
	}

	/**
	 * @param tbdGPThuoc16 - Type: TbdGPThuoc16
	 * @return may can null
	 */
	public ResponseEntity<TbdGPThuoc16> createTbdGPThuoc16(@RequestBody @Valid TbdGPThuoc16 tbdGPThuoc16) {
		tbdGPThuoc16 = createRestTemplate(getURL("/mard/16/tbdGPThuoc16/create"), tbdGPThuoc16, HttpMethod.POST, null, TbdGPThuoc16.class);
		return ResponseEntity.ok().body(tbdGPThuoc16);
	}

	/**
	 * @param tbdKetQuaXuLy16 - Type: TbdKetQuaXuLy16
	 * @return may can null
	 */
	public ResponseEntity<TbdKetQuaXuLy16> createTbdKetQuaXuLy16(@RequestBody @Valid TbdKetQuaXuLy16 tbdKetQuaXuLy16) {
		tbdKetQuaXuLy16 = createRestTemplate(getURL("/mard/16/tbdKetQuaXuLy16/create"), tbdKetQuaXuLy16, HttpMethod.POST, null, TbdKetQuaXuLy16.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy16);
	}

	/**
	 * @param tbdThanhToan16 - Type: TbdThanhToan16
	 * @return may can null
	 */
	public ResponseEntity<TbdThanhToan16> createTbdThanhToan16(@RequestBody @Valid TbdThanhToan16 tbdThanhToan16) {
		tbdThanhToan16 = createRestTemplate(getURL("/mard/16/tbdThanhToan16/create"), tbdThanhToan16, HttpMethod.POST, null, TbdThanhToan16.class);
		return ResponseEntity.ok().body(tbdThanhToan16);
	}

	/**
	 * @param tbdThongBaoPhi16 - Type: TbdThongBaoPhi16
	 * @return may can null
	 */
	public ResponseEntity<TbdThongBaoPhi16> createTbdThongBaoPhi16(@RequestBody @Valid TbdThongBaoPhi16 tbdThongBaoPhi16) {
		tbdThongBaoPhi16 = createRestTemplate(getURL("/mard/16/tbdThongBaoPhi16/create"), tbdThongBaoPhi16, HttpMethod.POST, null, TbdThongBaoPhi16.class);
		return ResponseEntity.ok().body(tbdThongBaoPhi16);
	}

	/**
	 * @param fiIdHoSo - Type: Long
	 * @return can return null or throw exception
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<TbdThuoc16>> findByFiIdHoSoTbdThuoc16(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdThuoc16> tbdThuoc16List = createRestTemplate(getURL("/mard/16/tbdThuoc16/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThuoc16List = mapper.convertValue(tbdThuoc16List, new TypeReference<List<TbdThuoc16>>() {});

		return ResponseEntity.ok().body(tbdThuoc16List);
	}

	/**
	 * @param fiIdHoSo - Type: Long
	 * @return can return null or throw exception
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<TbdGPThuoc16>> findByFiIdHoSoTbdGPThuoc16(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdGPThuoc16> tbdThuoc16List = createRestTemplate(getURL("/mard/16/tbdGPThuoc16/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThuoc16List = mapper.convertValue(tbdThuoc16List, new TypeReference<List<TbdGPThuoc16>>() {});

		return ResponseEntity.ok().body(tbdThuoc16List);
	}

	public ResponseEntity<TbdGPThuoc16> deleteTbdGPThuoc16(@PathVariable("fiId") Long fiId) {
		TbdGPThuoc16 tbdGPThuoc16 = createRestTemplate(getURL("/mard/16/tbdGPThuoc16/delete/") + fiId, null, HttpMethod.DELETE, null, TbdGPThuoc16.class);
		return ResponseEntity.ok().body(tbdGPThuoc16);
	}
	 public ResponseEntity<List<TbdToKhaiKyThuat16>> findByFiIdHoSoTbdToKhaiKyThuat16(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {
  		Map<String, Object> params = new HashMap<>();
 		params.put("fiIdHoSo", fiIdHoSo);
 		List<TbdToKhaiKyThuat16> tbdToKhaiKyThuat16List = createRestTemplate(getURL("/mard/16/tbdToKhaiKyThuat16/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
  		ObjectMapper mapper = new ObjectMapper();
  		tbdToKhaiKyThuat16List = mapper.convertValue(tbdToKhaiKyThuat16List, new TypeReference<List<TbdToKhaiKyThuat16>>() {});

  		return ResponseEntity.ok().body(tbdToKhaiKyThuat16List);
	}
}