package com.nsw.mard.p15.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

import com.nsw.common.model.json.ResponseJson;
import com.nsw.mard.p14.rest.RestTemplateResponseErrorHandler14;
import com.nsw.mard.p14.rest.SecurityUtil;
import com.nsw.mard.p15.model.TbdHoSo15;
import com.nsw.mard.p15.model.TbdHoSo15DTO;
import com.nsw.mard.p15.model.TbdKetQuaXuLy15;
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
* 11/12/2018 10:1515:50
*
*/
@PropertySource("classpath:mard_api.properties")
public abstract class Mard15CallBack {

	private static final Logger LOGGER = LoggerFactory.getLogger(Mard15CallBack.class);

	private static final String BACKEND_KEY = "mard.14.backend";

	@Autowired
	private Environment environment;

	public <T> T createRestTemplate(String uri, Object body, HttpMethod httpMethod, Map<String, Object> params, Class<T> clz) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
		if (params != null) {
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				if (!ObjectUtils.isEmpty(entry.getValue()))
					builder.queryParam(entry.getKey(), String.valueOf(entry.getValue()).trim());
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

	protected TbdKetQuaXuLy15 createHistory(Mard15TbdKetQuaXuLy15Resource fldMard15TbdKetQuaXuLy15Resource, Mard15TbdHoSo15Resource fldMard15TbdHoSo15Resource, String content, long idHoSo) {
		TbdKetQuaXuLy15 tbdKetQuaXuLy15 = new TbdKetQuaXuLy15();
		tbdKetQuaXuLy15.setFiCreateDate(new Date());
		tbdKetQuaXuLy15.setFiContent(content);
		tbdKetQuaXuLy15.setFiProcessor(SecurityUtil.getTaxCode());
		tbdKetQuaXuLy15.setFiNameOfRegistration(SecurityUtil.getTaxName());
		tbdKetQuaXuLy15.setFiIdHoSo(idHoSo);
		TbdHoSo15 tbdHoSo15 = fldMard15TbdHoSo15Resource.getTbdHoSo15(idHoSo).getBody();
		tbdKetQuaXuLy15.setFiStatus(tbdHoSo15.getFiStatus());
		tbdKetQuaXuLy15.setFiCreateDate(new Date());
		tbdKetQuaXuLy15.setFiProcessDate(new Date());
		tbdKetQuaXuLy15.setFiProcessor(SecurityUtil.getTaxCode());
		tbdKetQuaXuLy15.setFiNameOfRegistration(SecurityUtil.getTaxName());
		tbdKetQuaXuLy15.setFiDocumentType(tbdHoSo15.getFiDocumentType());
		tbdKetQuaXuLy15.setFiDocumentName(tbdHoSo15.getFiDocumentName());
		fldMard15TbdKetQuaXuLy15Resource.createTbdKetQuaXuLy15(tbdKetQuaXuLy15);

		return tbdKetQuaXuLy15;
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