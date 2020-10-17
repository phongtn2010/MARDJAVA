package com.vnsw.ws.p10.service;


/**
 *
 * @author Linhdx
 */
public interface EnvelopXmlService10 {

    String ObjectToXml(Object obj);

    Object xmlToEnvelope(String xml);
}
