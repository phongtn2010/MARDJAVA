package com.nsw.monre.p01.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.transform.OutputKeys;

public class SendUtil {

	private static final Logger log = LoggerFactory.getLogger(SendUtil.class);

	private static final String NAME_SPACE = "http://tempuri.org/";
	private static final String PREFIX = "tem";

	public static ResponseMessage callWs(String url, String username, String signatureXml) {
		try {
			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage soapMessage = messageFactory.createMessage();
			SOAPPart part = soapMessage.getSOAPPart();
			SOAPEnvelope envelope = part.getEnvelope();
			SOAPBody body = envelope.getBody();

			
			Name send = envelope.createName("Verify", PREFIX, NAME_SPACE);
			SOAPBodyElement bodyElement = body.addBodyElement(send);

			Name user = envelope.createName("user", PREFIX, NAME_SPACE);
			SOAPElement requestEle = bodyElement.addChildElement(user);
			requestEle.addTextNode(username);
			
			Name signature = envelope.createName("signature", PREFIX, NAME_SPACE);
			SOAPElement signaturetEle = bodyElement.addChildElement(signature);
			signaturetEle.addTextNode(signatureXml);
			
			MimeHeaders headers = soapMessage.getMimeHeaders();
			headers.addHeader("SOAPAction", "http://tempuri.org/ICaService/Verify");
			soapMessage.saveChanges();

			logMessage(soapMessage);
			
		
			
			SOAPConnectionFactory factory = SOAPConnectionFactory.newInstance();
			SOAPConnection connection = factory.createConnection();
			soapMessage = connection.call(soapMessage, new URL(url));
			return getSOAPResponse(soapMessage);
		} catch (Exception e) {

			log.debug(e.getMessage(), e);
		}
		return new ResponseMessage();
	}

	private static String logMessage(SOAPMessage soapResponse) throws Exception {

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
                transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
                transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		Source sourceContent = soapResponse.getSOAPPart().getContent();
		StringWriter outWriter = new StringWriter();
		StreamResult result = new StreamResult(outWriter);
		transformer.transform(sourceContent, result);
		StringBuffer sb = outWriter.getBuffer();
		String finalstring = sb.toString();
		log.info("SOAP message: {}", finalstring);
		return finalstring;
	
	}

	private static ResponseMessage getSOAPResponse(SOAPMessage soapResponse) throws Exception {
		
		logMessage(soapResponse);
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		soapResponse.writeTo(byteArrayOutputStream);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
                transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
                transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		Source sourceContent = soapResponse.getSOAPPart().getContent();
		StringWriter outWriter = new StringWriter();
		StreamResult result = new StreamResult(outWriter);
		transformer.transform(sourceContent, result);
		StringBuffer sb = outWriter.getBuffer();
		String finalstring = sb.toString();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		ResponseMessageHandler messageHandler = new ResponseMessageHandler();
		saxParser.parse(new InputSource(new StringReader(finalstring)), messageHandler);
		return messageHandler.getMessage();
	}


}
