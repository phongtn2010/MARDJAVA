/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.helper;

import java.io.StringWriter;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nsw.util.Constants;
import javax.xml.soap.MimeHeaders;

/**
 *
 * @author Phong84NV
 */
public class SoapHelper {

    public static final Logger logger = LoggerFactory.getLogger(SoapHelper.class);
    static final String CLASS_NAME = "SoapHelper";

    /**
     * Dong goi ban tin Soap de goi den service noi bo
     *
     * @param content
     * @param namespace
     * @param methodTag
     * @param namespaceKey
     * @param payloadTag
     * @param nameSpaceKeyForMethodTag
     * @param soapAction
     * @param info
     * @param nameSpaceKeyForPayloadTag
     * @return
     * @since 2017-05-24
     */
    public static SOAPMessage createSOAPRequest(String content, String namespace, String namespaceKey,
            String methodTag, String payloadTag, String nameSpaceKeyForMethodTag, String nameSpaceKeyForPayloadTag, 
            RabbitMQInfo info, String soapAction) {
        SOAPMessage soapMessage = null;
        try {
            MessageFactory messageFactory = MessageFactory.newInstance();
            soapMessage = messageFactory.createMessage();
            if (soapAction != null && !"".equals(soapAction)) {
                MimeHeaders hd = soapMessage.getMimeHeaders();
                hd.addHeader("SOAPAction", soapAction);
            }
            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.addNamespaceDeclaration(namespaceKey, namespace);
            // SOAP Body
            SOAPBody soapBody = envelope.getBody();
            SOAPElement receiveRequest;
            SOAPElement requestPayload;
            if (nameSpaceKeyForMethodTag != null && !"".equals(nameSpaceKeyForMethodTag)) {
                receiveRequest = soapBody.addChildElement(methodTag, nameSpaceKeyForMethodTag);
            } else {
                receiveRequest = soapBody.addChildElement(methodTag);
            }
            if (nameSpaceKeyForPayloadTag != null && !"".equals(nameSpaceKeyForPayloadTag)) {
                requestPayload = receiveRequest.addChildElement(payloadTag, nameSpaceKeyForPayloadTag);
            } else {
                requestPayload = receiveRequest.addChildElement(payloadTag);
            }
            requestPayload.addTextNode(Constants.CDATA.START_TAG + content + Constants.CDATA.END_TAG);
            soapMessage.saveChanges();
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, info);
        }

        return soapMessage;
    }

    /**
     * Tra ve string content
     *
     * @param soapResponse
     * @return
     * @since 2017-05-24
     */
    public static String getSOAPResponse(SOAPMessage soapResponse) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        StringWriter outWriter = new StringWriter();
        StreamResult result = new StreamResult(outWriter);
        transformer.transform(sourceContent, result);
        StringBuffer sb = outWriter.getBuffer();
        String finalstring = sb.toString();

        return replaceExtraTag(finalstring);
    }

    private static String replaceExtraTag(String content) {
        String result = "";
        try {
            int firstIndex;
            int lastIndex;
            String openTag = Constants.ENVELOP_TAG_ENCODE.OPEN_TAG;
            String closeTag = Constants.ENVELOP_TAG_ENCODE.CLOSE_TAG;
            firstIndex = content.indexOf(openTag);
            lastIndex = content.lastIndexOf(closeTag);
            if (firstIndex > -1 && lastIndex > -1) {
                result = content.substring(firstIndex, lastIndex + closeTag.length());
            } else {
                result = content;
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }

        result = result.replace(Constants.TAG_ENCODE.OPEN_TAG, Constants.TAG_NO_ENCODE.OPEN_TAG)
                .replace(Constants.TAG_ENCODE.CLOSE_TAG, Constants.TAG_NO_ENCODE.CLOSE_TAG)
                .replace(Constants.TAG_ENCODE.AND_TAG, Constants.TAG_NO_ENCODE.AND_TAG)
                .replace(Constants.TAG_ENCODE.UNKNOW_TAG, "").trim();

        return result;
    }
}
