package com.nsw.backend.vroot.message25;

/**
 *
 * @author Linhdx
 */
public interface EnvelopXmlService {

    String ObjectToXml(Object obj);

    <T> T xmlToEnvelope(String xml, Class<T> jaxbClass);
}
