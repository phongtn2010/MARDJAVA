package com.vnsw.ws.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.vnsw.ws.generated.ObjectFactory;
import com.vnsw.ws.generated.ReceiveRequest;
import com.vnsw.ws.generated.ReceiveResponse;


@Component
public class SBVServiceClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(SBVServiceClient.class);

	@Autowired
	private WebServiceTemplate webServiceTemplate;

	
	public String sayReceive(String message) {
		ObjectFactory factory = new com.vnsw.ws.generated.ObjectFactory();
		ReceiveRequest echo = factory.createReceiveRequest();

		echo.setRequestPayload(message);

		LOGGER.info("Client sending message ", echo.getRequestPayload());

		ReceiveResponse greeting = (ReceiveResponse) webServiceTemplate.marshalSendAndReceive(echo);

		LOGGER.info("Client received greeting='{}'", greeting.getResponsePayload());
		return greeting.getResponsePayload();
	}
	

}
