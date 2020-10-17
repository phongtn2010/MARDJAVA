package com.vnsw.ws.p10.service;

import javax.xml.xpath.XPath;

import org.w3c.dom.Document;
import com.vnsw.ws.p10.envelop.Error10;
import com.vnsw.ws.p10.envelop.Header10;
import com.vnsw.ws.p10.envelop.Body10;
import com.vnsw.ws.p10.envelop.Content10;
import com.vnsw.ws.p10.envelop.Envelope10;

public interface EnvelopeService10 {

    String getDocumentType(String xml);

    String getProcedure(String xml);

    String getFunction(String xml);

    String getValueFromXml(String xml, String key);

    String getValueFromXml(XPath xpath, Document doc, String key);

    Error10 createError(String code, String name);

    Error10 createError(String code, String name, Exception ex);

    Header10 createHeaderError(String fiMaHoSo, String documentType, String msgType);

    Header10 createReceiveHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc);

    Header10 createSendHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc, String mardUnitCode1, String mardUnitCode2);

    Body10 createBodyError(Error10 error);

    Body10 createBody(Content10 content);

    Envelope10 createEnvelopeError(String fiMaHoSo, String documentType, String msgType, Error10 error);

    Envelope10 createResponse(Header10 header, Body10 body);
    
    Envelope10 createMessage(Header10 header, Body10 body);
}
