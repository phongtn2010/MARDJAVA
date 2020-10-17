package com.vnsw.ws.p12.service;

import com.vnsw.ws.p12.envelop.Body12;
import com.vnsw.ws.p12.envelop.Content12;
import com.vnsw.ws.p12.envelop.Envelope12;
import com.vnsw.ws.p12.envelop.Error12;
import com.vnsw.ws.p12.envelop.Header12;

public interface EnvelopeService {
    String getDocumentType(String xml);
    
    String getValueFromXml(String xml, String key);
    
    Error12 createError(String code, String name);
    
    Error12 createError(String code, String name, Exception ex);
    
    Header12 createSendHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc);
    
    Body12 createBody(Content12 content);
    
    Envelope12 createResponse(Header12 header, Body12 body);
    
    Header12 createReceiveHeader(String fiMaHoSo, String documentType, String msgType, String msgFunc);
    
    Envelope12 createEnvelopeError(String fiMaHoSo, String documentType, String msgType, Error12 error);
}
