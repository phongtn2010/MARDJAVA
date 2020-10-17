package com.vnsw.ws.p8.service;

import com.vnsw.ws.p8.evelop.*;
import org.w3c.dom.Document;

import javax.xml.xpath.XPath;

public interface EnvelopeService08 {

    String getDocumentType(String xml);

    String getProcedure(String xml);

    String getFunction(String xml);

    String getValueFromXml(String xml, String key);

    String getValueFromXml(XPath xpath, Document doc, String key);

    Error08 createError(String code, String name);

    Error08 createError(String code, String name, Exception ex);

    Header08 createHeaderError(String fiMaHoSo, String documentType, String msgType);

    Header08 createReceiveHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc);

    Header08 createSendHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc, String mardUnitCode);

    Body08 createBodyError(Error08 error);

    Body08 createBody(Content08 content);

    Envelope08 createEnvelopeError(String fiMaHoSo, String documentType, String msgType, Error08 error);

    Envelope08 createResponse(Header08 header, Body08 body);

    Envelope08 createMessage(Header08 header, Body08 body);
}
