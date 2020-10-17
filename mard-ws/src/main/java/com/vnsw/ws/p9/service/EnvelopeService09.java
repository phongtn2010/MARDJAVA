package com.vnsw.ws.p9.service;

import com.vnsw.ws.p9.envelop.Error;
import com.vnsw.ws.p9.envelop.Body;
import com.vnsw.ws.p9.envelop.Content;
import com.vnsw.ws.p9.envelop.Envelope09;
import com.vnsw.ws.p9.envelop.Header;
import org.w3c.dom.Document;

import javax.xml.xpath.XPath;

public interface EnvelopeService09 {

    String getDocumentType(String xml);

    String getProcedure(String xml);

    String getFunction(String xml);

    String getValueFromXml(String xml, String key);

    String getValueFromXml(XPath xpath, Document doc, String key);

    Error createError(String code, String name);

    Error createError(String code, String name, Exception ex);

    Header createHeaderError(String fiMaHoSo, String documentType, String msgType);

    Header createReceiveHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc);

    Header createSendHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc, String mardUnitCode1, String mardUnitCode2);

    Body createBodyError(Error error);

    Body createBody(Content content);

    Envelope09 createEnvelopeError(String fiMaHoSo, String documentType, String msgType, Error error);

    Envelope09 createResponse(Header header, Body body);
    
    Envelope09 createMessage(Header header, Body body);
}
