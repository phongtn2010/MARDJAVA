package com.vnsw.ws.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.vnsw.ws.common.service.EnvelopXmlService;
import com.vnsw.ws.common.service.EncryptService;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.common.envelop.Error;
import com.vnsw.ws.generated.ReceiveRequest;
import com.vnsw.ws.generated.ReceiveResponse;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.p01.service.EnvelopeService;
import com.vnsw.ws.p01.service.ReceiveService1;
import com.vnsw.ws.util.Constants;

@Endpoint
public class ReceiveEndpoint {
    public static final Logger logger = LoggerFactory.getLogger(ReceiveEndpoint.class);
    private static final String NAMESPACE_URI = "http://com/vnsw/ws/generated";
    private static final String CLASS_NAME = "ReceiveEndpoint";

    @Autowired
    private EnvelopXmlService convertXmlService;
    @Autowired
    private Environment environment;
    @Autowired
    RabbitMQService rabbitMQService;
    @Autowired
    private EncryptService encryptService;
    @Autowired
    private EnvelopeService envelopeService;    
    @Autowired
    private ReceiveService1 receiveEndpoint1;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "receiveRequest")
    @ResponsePayload
    public ReceiveResponse receive(@RequestPayload ReceiveRequest request) {
        ReceiveResponse res = new ReceiveResponse();
        Error error;
        String xml = request.getRequestPayload();
        String xmlReturn = "";
        String isEncrypt = environment.getProperty("ENCRYPT");
        if ("true".equals(isEncrypt)) {
            String key = environment.getProperty("KEY_AES");
            xml = encryptService.decrypt(key, xml);
        }
        try {
            String documentType = envelopeService.getDocumentType(xml);
            String msgType = envelopeService.getValueFromXml(xml, "/Envelope/Header/Subject/type");
            String reference = envelopeService.getValueFromXml(xml, "/Envelope/Header/Subject/reference");
            if (documentType != null) {
                switch (documentType) {
                    
                    case Constants.PROCEDUCE.SBV01: 
                        com.vnsw.ws.p01.envelop.Envelope envl1 = receiveEndpoint1.receive(xml);
                        xmlReturn = convertXmlService.ObjectToXml(envl1);
                        break;
                    default:
                        error = envelopeService.createError(Constants.ERROR.ERR01_CODE, Constants.ERROR.ERR01);
                        com.vnsw.ws.p01.envelop.Envelope envEr = envelopeService.createEnvelopeError(reference, Constants.PROCEDUCE.ERROR, msgType, error);
                        xmlReturn = convertXmlService.ObjectToXml(envEr);
                        break;
                }
            } else {
                error = envelopeService.createError(Constants.ERROR.ERR02_CODE, Constants.ERROR.ERR02);
                com.vnsw.ws.p01.envelop.Envelope envl = envelopeService.createEnvelopeError(reference, Constants.PROCEDUCE.ERROR, msgType, error);
                xmlReturn = convertXmlService.ObjectToXml(envl);
            }
        } catch (Exception ex) {
            error = envelopeService.createError(Constants.ERROR.ERR03_CODE, Constants.ERROR.ERR03, ex);
            com.vnsw.ws.p01.envelop.Envelope envl = envelopeService.createEnvelopeError("00", Constants.PROCEDUCE.ERROR, "00", error);
            xmlReturn = convertXmlService.ObjectToXml(envl);

            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }

        if ("true".equals(isEncrypt)) {
            String key = environment.getProperty("KEY_AES");
            xmlReturn = encryptService.encrypt(key, xmlReturn);
        }
        res.setResponsePayload(xmlReturn);
        return res;
    }

}
