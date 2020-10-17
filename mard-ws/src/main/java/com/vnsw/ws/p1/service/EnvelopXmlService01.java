package com.vnsw.ws.p1.service;

public interface EnvelopXmlService01 {
    String ObjectToXml(Object obj);

    Object xmlToEnvelope(String xml);
}
