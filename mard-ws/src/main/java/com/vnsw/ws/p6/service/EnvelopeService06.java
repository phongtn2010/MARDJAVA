package com.vnsw.ws.p6.service;

import com.vnsw.ws.p6.envelop.*;
import org.w3c.dom.Document;

import javax.xml.xpath.XPath;

public interface EnvelopeService06 {

    String getDocumentType(String xml);

    String getProcedure(String xml);

    String getFunction(String xml);

    String getValueFromXml(String xml, String key);

    String getValueFromXml(XPath xpath, Document doc, String key);

    Error06 createError(String code, String name);

    Error06 createError(String code, String name, Exception ex);

    Header06 createHeaderError(String fiMaHoSo, String documentType, String msgType);

    Header06 createReceiveHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc);

    Header06 createSendHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc, String mardUnitCode);

    Body06 createBodyError(Error06 error);

    Body06 createBody(Content06 content);

    Envelope06 createEnvelopeError(String fiMaHoSo, String documentType, String msgType, Error06 error);

    Envelope06 createResponse(Header06 header, Body06 body);

    Envelope06 createMessage(Header06 header, Body06 body);
}
