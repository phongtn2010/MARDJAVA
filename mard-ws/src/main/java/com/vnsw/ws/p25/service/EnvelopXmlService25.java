package com.vnsw.ws.p25.service;


/**
 *
 * @author Linhdx
 */
public interface EnvelopXmlService25 {

    String ObjectToXml(Object obj);

    Object xmlToEnvelope(String xml);
}
