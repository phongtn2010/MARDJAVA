/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.receive.gateway.helper;

import com.vnsw.receive.gateway.util.Constants;
import com.vnsw.receive.gateway.util.LogUtils;
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

/**
 *
 * @author Phong84NV
 */
public class SoapHelper {

    private static final String CLASS_NAME = "SoapHelper";

    /**
     * Dong goi ban tin Soap de goi den service noi bo
     *
     * @param content
     * @return
     * @since 2017-05-24
     */
    public static SOAPMessage createSOAPRequest(String content, RabbitMQInfo info)  {
        SOAPMessage soapMessage = null;
        try {
            MessageFactory messageFactory = MessageFactory.newInstance();
            soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.addNamespaceDeclaration(Constants.LOCAL_WEBSERVICE.COMMON_NAMESPACE_KEY,
                    Constants.LOCAL_WEBSERVICE.COMMON_NAMESPACE);
            // SOAP Body
            SOAPBody soapBody = envelope.getBody();
            SOAPElement receiveRequest = soapBody.addChildElement(Constants.LOCAL_WEBSERVICE.COMMON_METHOD_TAG,
                    Constants.LOCAL_WEBSERVICE.COMMON_NAMESPACE_KEY);
            SOAPElement requestPayload = receiveRequest.addChildElement(Constants.LOCAL_WEBSERVICE.COMMON_PAYLOAD_TAG,
                    Constants.LOCAL_WEBSERVICE.COMMON_NAMESPACE_KEY);
            requestPayload.addTextNode(Constants.CDATA.START_TAG + content + Constants.CDATA.END_TAG);
            soapMessage.saveChanges();
        } catch (Exception ex) {
            LogUtils.addLog(ex);
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
    public static String getSOAPResponse(SOAPMessage soapResponse, RabbitMQInfo info)  {
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

    private static String replaceExtraTag(String content, RabbitMQInfo info)  {
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
            result = result.replace(Constants.TAG_ENCODE.OPEN_TAG, Constants.TAG_NO_ENCODE.OPEN_TAG)
                    .replace(Constants.TAG_ENCODE.CLOSE_TAG, Constants.TAG_NO_ENCODE.CLOSE_TAG);
        } catch (Exception ex) {
            LogUtils.addLog(ex);
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, info);
        }
        return result;
    }
}
