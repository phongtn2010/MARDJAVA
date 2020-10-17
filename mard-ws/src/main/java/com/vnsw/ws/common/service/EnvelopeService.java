package com.vnsw.ws.common.service;

import com.vnsw.ws.common.envelop.Envelope;
import javax.xml.xpath.XPath;
import org.w3c.dom.Document;
import com.vnsw.ws.common.envelop.Error;

public interface EnvelopeService {

    String getDocumentType(String xml);

    String getProcedure(String xml);

    String getFunction(String xml);

    String getValueFromXml(String xml, String key);

    String getValueFromXml(XPath xpath, Document doc, String key);

    Error createError(String code, String name);

    Error createError(String code, String name, Exception ex);

    Envelope createEnvelopeError(String fiMaHoSo, String documentType, String msgType, Error error);
}
