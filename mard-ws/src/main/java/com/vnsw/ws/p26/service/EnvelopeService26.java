package com.vnsw.ws.p26.service;

import com.vnsw.ws.p26.envelop.*;
import org.w3c.dom.Document;

import javax.xml.xpath.XPath;

public interface EnvelopeService26 {

    String getDocumentType(String xml);

    String getProcedure(String xml);

    String getFunction(String xml);

    String getValueFromXml(String xml, String key);

    String getValueFromXml(XPath xpath, Document doc, String key);

    Error26 createError(String code, String name);

    Error26 createError(String code, String name, Exception ex);

    Header26 createHeaderError(String fiMaHoSo, String documentType, String msgType);

    Header26 createReceiveHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc);

    Header26 createSendHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc, String mardUnitCode);

    Body26 createBodyError(Error26 error);

    Body26 createBody(Content26 content);

    Envelope26 createEnvelopeError(String fiMaHoSo, String documentType, String msgType, Error26 error);

    Envelope26 createResponse(Header26 header, Body26 body);

    Envelope26 createMessage(Header26 header, Body26 body);
}
