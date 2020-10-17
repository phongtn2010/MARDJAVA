package com.vnsw.ws.p8.util;

import com.vnsw.ws.p8.common.Constants08;
import com.vnsw.ws.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.XMLConstants;
import javax.xml.soap.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;


public class Soap08Helper {

    public static final Logger logger = LoggerFactory.getLogger(com.vnsw.ws.helper.SoapHelper.class);

    /**
     * Dong goi ban tin Soap de goi den service noi bo
     *
     * @param content
     * @return
     * @since 2017-05-24
     */
    public static SOAPMessage createSOAPRequest(String content, String officeCode, String documentType,
                                                String namespace, String namespaceKey, String methodTag, String officeCodePayload,
                                                String documentTypePayload, String payloadTag) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(namespaceKey, namespace);
        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement receiveRequest;
        SOAPElement requestPayloadOfficeCode;
        SOAPElement requestPayloadDocumentType;
        SOAPElement requestPayloadData;
        receiveRequest = soapBody.addChildElement(methodTag, namespaceKey);
        requestPayloadOfficeCode = receiveRequest.addChildElement(officeCodePayload, namespaceKey);
        requestPayloadDocumentType = receiveRequest.addChildElement(documentTypePayload, namespaceKey);
        requestPayloadData = receiveRequest.addChildElement(payloadTag, namespaceKey);
        requestPayloadOfficeCode.addTextNode(officeCode);
        requestPayloadDocumentType.addTextNode(documentType);
        requestPayloadData.addTextNode(Constants.CDATA.START_TAG + content + Constants.CDATA.END_TAG);

        soapMessage.saveChanges();
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
        transformerFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
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
            String openTag = Constants08.ENVELOP_TAG_ENCODE.OPEN_TAG;
            String closeTag = Constants08.ENVELOP_TAG_ENCODE.CLOSE_TAG;
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

        result = result.replace(Constants08.TAG_ENCODE.OPEN_TAG, Constants08.TAG_NO_ENCODE.OPEN_TAG)
                .replace(Constants08.TAG_ENCODE.CLOSE_TAG, Constants08.TAG_NO_ENCODE.CLOSE_TAG)
                .replace(Constants08.TAG_ENCODE.AND_TAG, Constants08.TAG_NO_ENCODE.AND_TAG)
                .replace(Constants08.TAG_ENCODE.UNKNOW_TAG, "").trim();

        return result;
    }
}
