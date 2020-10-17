package com.vnsw.ws.p7.service;


/**
 *
 * @author Linhdx
 */
public interface EnvelopXmlService07 {

    String ObjectToXml(Object obj);

    Object xmlToEnvelope(String xml);
}
