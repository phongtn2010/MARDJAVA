package com.vnsw.ws.p04.service;

import com.vnsw.ws.common.envelop.Error;
import com.vnsw.ws.common.envelop.Header;
import com.vnsw.ws.p04.envelop.Body;
import com.vnsw.ws.p04.envelop.Content;
import com.vnsw.ws.p04.envelop.Envelope;

public interface EnvelopeService {
    String getDocumentType(String xml);
    
    String getValueFromXml(String xml, String key);
    
    Error createError(String code, String name);
    
    Error createError(String code, String name, Exception ex);
    
    Header createSendHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc, String fiMaCqxl);
    
    Body createBody(Content content);
    
    Envelope createResponse(Header header, Body body);
    
    Header createReceiveHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc);
    
    Envelope createEnvelopeError(String fiMaHoSo, String documentType, String msgType, Error error);
}
