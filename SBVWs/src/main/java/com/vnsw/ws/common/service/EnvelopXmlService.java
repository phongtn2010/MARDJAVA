package com.vnsw.ws.common.service;

/**
 *
 * @author Linhdx
 */
public interface EnvelopXmlService {

    String ObjectToXml(Object obj);

    <T> T xmlToEnvelope(String xml, Class<T> jaxbClass);
}
