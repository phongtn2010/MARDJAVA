package com.vnsw.send.gateway.common.service;

import com.vnsw.send.gateway.common.bo.Envelope;

/**
 *
 * @author Linhdx
 */
public interface EnvelopXmlService {

    String ObjectToXml(Object obj);

    Envelope xmlToEnvelope(String xml);
}
