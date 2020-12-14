package com.nsw.mard.p14.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

import com.nsw.common.model.json.ResponseJson;
import com.nsw.mard.p14.model.TbdHoSo14;
import com.nsw.mard.p14.model.TbdKetQuaXuLy14;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


/***
*
*
* @class CallBackUtil
* Created by Nguyen Van Quang
* 11/12/2018 10:1414:50
*
*/
@PropertySource("classpath:mard_api.properties")
public abstract class Mard14CallBack {

	private static final Logger LOGGER = LoggerFactory.getLogger(Mard14CallBack.class);

	private static final String BACKEND_KEY = "mard.14.backend";


	@Autowired
	private Environment environment;

	public <T> T createRestTemplate(String uri, Object body, HttpMethod httpMethod, Map<String, Object> params, Class<T> clz) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
		if (params != null) {
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				if (!ObjectUtils.isEmpty(entry.getValue())) {
					builder.queryParam(entry.getKey(), String.valueOf(entry.getValue()).trim());
				}
			}
		}
		uri = builder.build().encode().toString();
		List<HttpMessageConverter<?>> converters = new ArrayList<>();
		converters.add(new MappingJackson2HttpMessageConverter());
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		RestTemplate restTemplate = restTemplateBuilder.errorHandler(new RestTemplateResponseErrorHandler14()).build();
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

	protected static <T> T readObject(ResponseJson responseJson, Class<T> clz) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), clz);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	protected boolean isDevProfile() {
		return "dev".equals(environment.getProperty("mard.14.profile"));
	}

	protected boolean isFcap() {
		return "true".equals(environment.getProperty("mard.14.moduleFcap"));
	}

	protected boolean gotoLogin() {
		if (!isFcap()) {
			if (!StringUtils.hasText(SecurityUtil.getTaxCode())) return true;
		}
		return false;
	}

	protected void showLog(Object o) {
		if (isDevProfile()) {
			if (o != null) {
				System.out.println(o.toString());
			} else {
				System.out.println("NULL");
			}

		}
	}

	protected TbdKetQuaXuLy14 createHistory(Mard14TbdKetQuaXuLy14Resource fldMard14TbdKetQuaXuLy14Resource, Mard14TbdHoSo14Resource fldMard14TbdHoSo14Resource, String content, long idHoSo) {
		TbdKetQuaXuLy14 tbdKetQuaXuLy14 = new TbdKetQuaXuLy14();
		tbdKetQuaXuLy14.setFiCreateDate(new Date());
		tbdKetQuaXuLy14.setFiContent(content);
		tbdKetQuaXuLy14.setFiProcessor(SecurityUtil.getTaxCode());
		tbdKetQuaXuLy14.setFiNameOfRegistration(SecurityUtil.getTaxName());
		tbdKetQuaXuLy14.setFiIdHoSo(idHoSo);
		TbdHoSo14 tbdHoSo14 = fldMard14TbdHoSo14Resource.getTbdHoSo14(idHoSo).getBody();
		tbdKetQuaXuLy14.setFiStatus(tbdHoSo14.getFiStatus());
		tbdKetQuaXuLy14.setFiCreateDate(new Date());
		tbdKetQuaXuLy14.setFiProcessDate(new Date());
		tbdKetQuaXuLy14.setFiProcessor(SecurityUtil.getTaxCode());
		tbdKetQuaXuLy14.setFiNameOfRegistration(SecurityUtil.getTaxName());
		tbdKetQuaXuLy14.setFiDocumentType(tbdHoSo14.getFiDocumentType());
		tbdKetQuaXuLy14.setFiDocumentName(tbdHoSo14.getFiDocumentName());
		fldMard14TbdKetQuaXuLy14Resource.createTbdKetQuaXuLy14(tbdKetQuaXuLy14);

		return tbdKetQuaXuLy14;
	}

	protected <T> boolean isValid(T obj) {
		System.out.println("Validate object: " + obj);
		if (obj == null) return false;
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> violations = validator.validate(obj);
		if (!ObjectUtils.isEmpty(violations)) {
			for (ConstraintViolation<T> violation : violations) {
				LOGGER.error("ERROR: {} - {}", violation.getPropertyPath(), violation.getMessage());
			}
			return false;
		}
		return true;
	}

}