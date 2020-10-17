package com.vnsw.ws.p1.service;

import com.vnsw.ws.p1.evelop.*;
import org.w3c.dom.Document;

import javax.xml.xpath.XPath;

public interface EnvelopeService01 {
    String getDocumentType(String xml);

    String getProcedure(String xml);

    String getFunction(String xml);

    String getValueFromXml(String xml, String key);

    String getValueFromXml(XPath xpath, Document doc, String key);

    Error01 createError(String code, String name);

    Error01 createError(String code, String name, Exception ex);

    Header01 createHeaderError(String fiMaHoSo, String documentType, String msgType);

    Header01 createReceiveHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc);

    Header01 createSendHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc, String mardUnitCode);

    Body01 createBodyError(Error01 error);

    Body01 createBody(Content01 content);

    Envelope01 createEnvelopeError(String fiMaHoSo, String documentType, String msgType, Error01 error);

    Envelope01 createResponse(Header01 header, Body01 body);

    Envelope01 createMessage(Header01 header, Body01 body);

}
