package com.vnsw.send.gateway.common.service;

import javax.xml.xpath.XPath;

import org.w3c.dom.Document;

import com.vnsw.send.gateway.common.bo.Body;
import com.vnsw.send.gateway.common.bo.Content;
import com.vnsw.send.gateway.common.bo.Envelope;
import com.vnsw.send.gateway.common.bo.Error;
import com.vnsw.send.gateway.common.bo.Header;
/**
*
* @author Linhdx
*/
public interface EnvelopeService {
	String getDocumentType(String xml);
	
	String getProcedure(String xml);

	String getFunction(String xml);

	String getValueFromXml(String xml, String key);

	String getValueFromXml(XPath xpath, Document doc, String key);

	Error createError(String code, String name);

	Error createError(String code, String name, Exception ex);

	Body createBodyError(Error error);

	Header createHeaderError(String xml, String documentType, String type);

	Envelope createResponseError(String xml, String documentType, String type, Error error);

	Envelope createResponseError(String xml, String documentType, String type, String code,
			String name);

	Envelope createResponseError(String xml, String documentType, String type, String code,
			String name, Exception ex);

	Body createBody(Content content);

	Header createHeader(String xml, String documentType, String type);
	Header createHeader(String documentType, String type, String func, String reference, String toId, String toName);

	Envelope createResponse(Header header, Body body);
}