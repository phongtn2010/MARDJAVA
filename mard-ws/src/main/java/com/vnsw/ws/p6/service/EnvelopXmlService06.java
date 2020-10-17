package com.vnsw.ws.p6.service;


/**
 *
 * @author Linhdx
 */
public interface EnvelopXmlService06 {

    String ObjectToXml(Object obj);

    Object xmlToEnvelope(String xml);
}
