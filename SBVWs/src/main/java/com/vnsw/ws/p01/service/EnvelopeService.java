package com.vnsw.ws.p01.service;

import javax.xml.xpath.XPath;

import org.w3c.dom.Document;

import com.vnsw.ws.p01.envelop.Body;
import com.vnsw.ws.p01.envelop.Content;
import com.vnsw.ws.p01.envelop.Envelope;
import com.vnsw.ws.common.envelop.Error;
import com.vnsw.ws.common.envelop.Header;

public interface EnvelopeService {
	String getDocumentType(String xml);
	
	String getProcedure(String xml);

	String getFunction(String xml);

	String getValueFromXml(String xml, String key);

	String getValueFromXml(XPath xpath, Document doc, String key);

	Error createError(String code, String name);

	Error createError(String code, String name, Exception ex);

	Header createHeaderError(String fiMaHoSo, String documentType, String msgType);	

	Header createReceiveHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc);
	
	Header createSendHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc);
	
	Body createBodyError(Error error);
	
	Body createBody(Content content);
	
	Envelope createEnvelopeError(String fiMaHoSo, String documentType, String msgType, Error error);
	
	Envelope createResponse(Header header, Body body);
}