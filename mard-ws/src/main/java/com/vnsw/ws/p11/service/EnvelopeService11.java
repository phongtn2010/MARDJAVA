package com.vnsw.ws.p11.service;

import javax.xml.xpath.XPath;
import org.w3c.dom.Document;
import com.vnsw.ws.p11.envelop.Error11;
import com.vnsw.ws.p11.envelop.Header11;
import com.vnsw.ws.p11.envelop.Body11;
import com.vnsw.ws.p11.envelop.Content11;
import com.vnsw.ws.p11.envelop.Envelope11;

public interface EnvelopeService11 {

    String getDocumentType(String xml);

    String getProcedure(String xml);

    String getFunction(String xml);

    String getValueFromXml(String xml, String key);

    String getValueFromXml(XPath xpath, Document doc, String key);

    Error11 createError(String code, String name);

    Error11 createError(String code, String name, Exception ex);

    Header11 createHeaderError(String fiMaHoSo, String documentType, String msgType);

    Header11 createReceiveHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc);

    Header11 createSendHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc, String unitCode);

    Body11 createBodyError(Error11 error);

    Body11 createBody(Content11 content);

    Envelope11 createEnvelopeError(String fiMaHoSo, String documentType, String msgType, Error11 error);

    Envelope11 createResponse(Header11 header, Body11 body);
    
    Envelope11 createMessage(Header11 header, Body11 body);
}
