package com.nsw.backend.sbv.p01.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.nsw.backend.sbv.p01.model.SendMessage;
import com.nsw.backend.util.ResponseJson;

@RestController
@RequestMapping(value ="/sbv/01/kySo")
public class KySoController extends BaseController {

	private static final String SERVICE_URL_01 = "SEND_SERVICE_URL_01";
	private static final String GET_XML_URL = "/send/01/getXMLContent";

	@Autowired
	private Environment environment;

	public static final Logger LOGGER = LoggerFactory.getLogger(KySoController.class);

	@RequestMapping(value = "/getXmlContent", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> sendAll(@RequestBody SendMessage sendMessage) {

		ResponseJson responseJson = new ResponseJson();

		try {

			String uri = environment.getRequiredProperty(SERVICE_URL_01) + GET_XML_URL;
			
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
			uri = builder.build().encode().toString();
			List<HttpMessageConverter<?>> converters = new ArrayList<>();
			converters.add(new MappingJackson2HttpMessageConverter());
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.setMessageConverters(converters);
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<Object> entity = new HttpEntity<>(sendMessage, headers);
			ResponseEntity<ResponseJson> response = restTemplate.exchange(uri, HttpMethod.POST, entity, ResponseJson.class);
			responseJson = response.getBody();
		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
		}

		return new ResponseEntity<>(responseJson, HttpStatus.OK);

	}
}
