package com.nsw.monre.p05.service;

import com.nsw.monre.p05.model.ResponseJson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


public class RestTemplateClient {

	
	private RestTemplateClient() {
	}


	public static ResponseJson createRestTemplate(String hostName, String uri, Object body, HttpMethod httpMethod, Map<String, Object> params) {

		String host = hostName;

		uri = host + uri;

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);

		if (params != null) {

			for (Map.Entry<String,Object> entry : params.entrySet()) {
			    String key = entry.getKey();
			    Object value = entry.getValue();
			    builder.queryParam(key, String.valueOf(value));
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


		return response.getBody();

	}
	
}