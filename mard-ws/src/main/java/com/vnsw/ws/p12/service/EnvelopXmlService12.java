package com.vnsw.ws.p12.service;


/**
 *
 * @author Linhdx
 */
public interface EnvelopXmlService12 {

    String ObjectToXml(Object obj);

    Object xmlToEnvelope(String xml);
}
