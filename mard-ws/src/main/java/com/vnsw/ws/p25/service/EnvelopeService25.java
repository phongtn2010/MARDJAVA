package com.vnsw.ws.p25.service;

import com.vnsw.ws.p25.envelop.*;
import org.w3c.dom.Document;

import javax.xml.xpath.XPath;

public interface EnvelopeService25 {

    String getDocumentType(String xml);

    String getProcedure(String xml);

    String getFunction(String xml);

    String getValueFromXml(String xml, String key);

    String getValueFromXml(XPath xpath, Document doc, String key);

    Error25 createError(String code, String name);

    Error25 createError(String code, String name, Exception ex);

    Header25 createHeaderError(String fiMaHoSo, String documentType, String msgType);

    Header25 createReceiveHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc);

    Header25 createSendHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc, String mardUnitCode);

    Body25 createBodyError(Error25 error);

    Body25 createBody(Content25 content);

    Envelope25 createEnvelopeError(String fiMaHoSo, String documentType, String msgType, Error25 error);

    Envelope25 createResponse(Header25 header, Body25 body);

    Envelope25 createMessage(Header25 header, Body25 body);
}
