package com.vnsw.ws.p11.service;


/**
 *
 * @author Linhdx
 */
public interface EnvelopXmlService11 {

    String ObjectToXml(Object obj);

    Object xmlToEnvelope(String xml);
}
