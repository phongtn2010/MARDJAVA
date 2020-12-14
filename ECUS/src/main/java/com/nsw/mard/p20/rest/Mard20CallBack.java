package com.nsw.mard.p20.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

import com.nsw.api.BaseApi;
import com.nsw.common.model.TokenInfo;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.mard.p20.model.TbdHoSo20;
import com.nsw.mard.p20.model.TbdKetQuaXuLy20;
import com.nsw.security.UserCustom;
import org.apache.commons.codec.binary.Base64;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
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
* 11/12/2020 10:2424:50
*
*/
@PropertySource("classpath:mard_api.properties")
public abstract class Mard20CallBack {

	private static final Logger LOGGER = LoggerFactory.getLogger(Mard20CallBack.class);

	private static final String BACKEND_KEY = "mard.14.backend";

	public static final String BACKEND_COMMON = "nsw.common.url";
	public static final String CHECK_SIGNATURE = "/ca/checkCA/";


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
		RestTemplate restTemplate = restTemplateBuilder.errorHandler(new RestTemplateResponseErrorHandler20()).build();
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

	protected TbdKetQuaXuLy20 createHistory(Mard20TbdKetQuaXuLy20Resource fldMard20TbdKetQuaXuLy20Resource, Mard20TbdHoSo20Resource fldMard20TbdHoSo20Resource, String content, long idHoSo) {
		TbdKetQuaXuLy20 tbdKetQuaXuLy20 = new TbdKetQuaXuLy20();
		tbdKetQuaXuLy20.setFiCreateDate(new Date());
		tbdKetQuaXuLy20.setFiContent(content);
		tbdKetQuaXuLy20.setFiProcessor(SecurityUtil.getTaxCode());
		tbdKetQuaXuLy20.setFiNameOfRegistration(SecurityUtil.getTaxName());
		tbdKetQuaXuLy20.setFiIdHoSo(idHoSo);
		TbdHoSo20 tbdHoSo20 = fldMard20TbdHoSo20Resource.getTbdHoSo20(idHoSo).getBody();
		tbdKetQuaXuLy20.setFiStatus(tbdHoSo20.getFiStatus());
		tbdKetQuaXuLy20.setFiCreateDate(new Date());
		tbdKetQuaXuLy20.setFiProcessDate(new Date());
		tbdKetQuaXuLy20.setFiProcessor(SecurityUtil.getTaxCode());
		tbdKetQuaXuLy20.setFiNameOfRegistration(SecurityUtil.getTaxName());
		tbdKetQuaXuLy20.setFiDocumentType(tbdHoSo20.getFiDocumentType());
		tbdKetQuaXuLy20.setFiDocumentName(tbdHoSo20.getFiDocumentName());
		fldMard20TbdKetQuaXuLy20Resource.createTbdKetQuaXuLy20(tbdKetQuaXuLy20);

		return tbdKetQuaXuLy20;
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
	public ResponseJson verifySignature(@RequestBody TokenInfo token) {
		/*String backendCommonUrl = environment.getRequiredProperty(BACKEND_COMMON);
		ResponseJson json = BackendRequestHelper
				.getInstance()
				.doPostRequest(backendCommonUrl + CHECK_SIGNATURE, token);
		return json;*/
		//fake response
		ResponseJson json = new ResponseJson();
		json.setSuccess(true);
		json.setData(null);
		return json;
	}
	protected String getUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserCustom user = (UserCustom) principal;
		return user.getUsername();
	}
	protected String encodeXmlMessage(String xmlOriginal) throws IOException {
		org.apache.commons.codec.binary.Base64 base64 = new Base64();
		String encodeString = new String(base64.encode(xmlOriginal.getBytes("UTF8")), "UTF8");
		return encodeString;
	}

}
