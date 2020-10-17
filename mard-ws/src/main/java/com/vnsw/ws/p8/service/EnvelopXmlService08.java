package com.vnsw.ws.p8.service;


/**
 *
 * @author Linhdx
 */
public interface EnvelopXmlService08 {

    String ObjectToXml(Object obj);

    Object xmlToEnvelope(String xml);
}
