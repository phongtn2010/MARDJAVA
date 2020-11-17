package com.vnsw.ws.p26.service;


/**
 *
 * @author Linhdx
 */
public interface EnvelopXmlService26 {

    String ObjectToXml(Object obj);

    Object xmlToEnvelope(String xml);
}
