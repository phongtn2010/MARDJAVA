/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.send.gateway.helper;

import com.vnsw.send.gateway.util.Constants;
import com.vnsw.send.gateway.util.LogUtils;
import java.io.StringWriter;
import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author Phong84NV
 */
public class SoapHelper {

    private static final String CLASS_NAME = "SoapHelper";

    /**
     *
     * @param content
     * @param namespace
     * @param namespaceKey
     * @param methodTag
     * @param payloadTag
     * @param nameSpaceKeyForMethodTag
     * @param nameSpaceKeyForPayloadTag
     * @param info
     * @param soapAction
     * @return
     */
    public static SOAPMessage createSOAPRequest(String content, String namespace, String namespaceKey,
            String methodTag, String payloadTag, String nameSpaceKeyForMethodTag, String nameSpaceKeyForPayloadTag, RabbitMQInfo info, String soapAction) {
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
    
    public static SOAPMessage createSOAPRequestForNHNN(String content, String namespace, String namespaceKey,
            String methodTag, String payloadTag, String nameSpaceKeyForMethodTag, String nameSpaceKeyForPayloadTag, RabbitMQInfo info, String soapAction) {
        SOAPMessage soapMessage = null;
        try {
            MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
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
     * BTNMT
     *
     * @param content
     * @param headerTo
     * @param namespace
     * @param namespaceKey
     * @param methodTag
     * @param payloadTag
     * @param nameSpaceKeyForMethodTag
     * @param nameSpaceKeyForPayloadTag
     * @param info
     * @param soapAction
     * @return
     */
    public static SOAPMessage createBTNMTSOAPRequest(String content, String headerTo, String namespace, String namespaceKey,
            String methodTag, String payloadTag, String nameSpaceKeyForMethodTag, String nameSpaceKeyForPayloadTag, RabbitMQInfo info, String soapAction) {
        SOAPMessage soapMessage = null;
        try {
            MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
            soapMessage = messageFactory.createMessage();
            
            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.removeNamespaceDeclaration(envelope.getPrefix());
            // 20180116 PhongNV Bo TNMT
            envelope.addNamespaceDeclaration("env", "http://www.w3.org/2003/05/soap-envelope");
            envelope.addNamespaceDeclaration("s", "http://www.w3.org/2003/05/soap-envelope");
            envelope.addNamespaceDeclaration("a", "http://www.w3.org/2005/08/addressing");
            envelope.setPrefix("env");
            // End TNMT

            //envelope.addNamespaceDeclaration(namespaceKey, namespace);
            // SOAP Body
            SOAPBody soapBody = envelope.getBody();
            SOAPElement receiveRequest;
            SOAPElement requestPayload;
            if (nameSpaceKeyForMethodTag != null && !"".equals(nameSpaceKeyForMethodTag)) {
                receiveRequest = soapBody.addChildElement(methodTag, nameSpaceKeyForMethodTag);
            } else {                
                receiveRequest = soapBody.addChildElement(methodTag, "", namespace);
                receiveRequest.addNamespaceDeclaration("", namespace);
            }
            
            if (nameSpaceKeyForPayloadTag != null && !"".equals(nameSpaceKeyForPayloadTag)) {
                requestPayload = receiveRequest.addChildElement(payloadTag, nameSpaceKeyForPayloadTag);
            } else {
                requestPayload = receiveRequest.addChildElement(payloadTag);
            }
            //requestPayload.addTextNode(Constants.CDATA.START_TAG + content + Constants.CDATA.END_TAG);
            requestPayload.addTextNode(content);

            // PhongNV fix bo TNMT
            SOAPFactory soapFactory = SOAPFactory.newInstance();
            SOAPHeader soapHeader = soapMessage.getSOAPHeader();
            if (soapHeader == null) {
                soapHeader = envelope.addHeader();
            }
            soapHeader.setPrefix("env");
            soapBody.setPrefix("env");
            // To
            SOAPHeaderElement sheTo = soapHeader.addHeaderElement(soapFactory.createName("To", "", "http://www.w3.org/2005/08/addressing"));
            sheTo.setValue(headerTo);
            sheTo.setAttribute("s:mustUnderstand", "1");
            sheTo.setPrefix("a");
            // Action
            SOAPHeaderElement sheAction = soapHeader.addHeaderElement(soapFactory.createName("Action", "", "http://www.w3.org/2005/08/addressing"));
            sheAction.setValue(soapAction);
            sheAction.setAttribute("s:mustUnderstand", "1");
            sheAction.setPrefix("a");

            soapMessage.saveChanges();

            MimeHeaders hd = soapMessage.getMimeHeaders();
            if (soapAction != null && !"".equals(soapAction)) {
                hd.setHeader("SOAPAction", soapAction);
            }
            hd.setHeader("Content-Type", "application/soap+xml; charset=utf-8");

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
    public static String getSOAPResponse(SOAPMessage soapResponse, RabbitMQInfo info) {
        String finalstring = "";
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            Source sourceContent = soapResponse.getSOAPPart().getContent();
            StringWriter outWriter = new StringWriter();
            StreamResult result = new StreamResult(outWriter);
            transformer.transform(sourceContent, result);
            StringBuffer sb = outWriter.getBuffer();
            finalstring = sb.toString();
        } catch (Exception ex) {
            LogUtils.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, info);
        }
        return replaceExtraTag(finalstring, info);
    }

    private static String replaceExtraTag(String content, RabbitMQInfo info) {
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
            LogUtils.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, info);
        }

        return result;
    }
}
