package com.vnsw.receive.gateway.common.service;

import com.vnsw.receive.gateway.common.bo.Envelope;

/**
 *
 * @author Linhdx
 */
public interface EnvelopXmlService {

    String ObjectToXml(Object obj);

    Envelope xmlToEnvelope(String xml);
}
