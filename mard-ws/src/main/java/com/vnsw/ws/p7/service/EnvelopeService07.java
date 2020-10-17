package com.vnsw.ws.p7.service;

import com.vnsw.ws.p7.evelope.*;
import org.w3c.dom.Document;

import javax.xml.xpath.XPath;

public interface EnvelopeService07 {

    String getDocumentType(String xml);

    String getProcedure(String xml);

    String getFunction(String xml);

    String getValueFromXml(String xml, String key);

    String getValueFromXml(XPath xpath, Document doc, String key);

    Error07 createError(String code, String name);

    Error07 createError(String code, String name, Exception ex);

    Header07 createHeaderError(String fiMaHoSo, String documentType, String msgType);

    Header07 createReceiveHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc);

    Header07 createSendHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc, String mardUnitCode);

    Body07 createBodyError(Error07 error);

    Body07 createBody(Content07 content);

    Envelope07 createEnvelopeError(String fiMaHoSo, String documentType, String msgType, Error07 error);

    Envelope07 createResponse(Header07 header, Body07 body);

    Envelope07 createMessage(Header07 header, Body07 body);
}
