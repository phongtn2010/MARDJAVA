package com.vnsw.ws.p9.service;


/**
 *
 * @author Linhdx
 */
public interface EnvelopXmlService09 {

    String ObjectToXml(Object obj);

    Object xmlToEnvelope(String xml);
}
