package com.nsw.sbv.p01.util;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.Objects;

public class SendUtil {

	private SendUtil() {
	}

	private static final Logger log = LoggerFactory.getLogger(SendUtil.class);

	private static final String NAME_SPACE = "http://tempuri.org/";
	private static final String PREFIX = "tem";

	public static ResponseMessage callWs(String url, String username, String signatureXml) {
		log.info("Ban thong kiem tra: username: {} | ban tin: {}", username, signatureXml);
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

			SOAPConnectionFactory factory = SOAPConnectionFactory.newInstance();
			SOAPConnection connection = factory.createConnection();
			soapMessage = connection.call(soapMessage, new URL(url));
			log.info("------------BAN tin gui di--------------- ");
			logMessage(soapMessage);
			return getSOAPResponse(soapMessage);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return new ResponseMessage();
	}

	private static String logMessage(SOAPMessage soapResponse)
			throws SOAPException, TransformerException, ParserConfigurationException, SAXException, IOException {


		return "";

	}

	private static ResponseMessage getSOAPResponse(SOAPMessage soapResponse) throws SOAPException, TransformerException, ParserConfigurationException, SAXException, IOException {

		log.info("------------BAN tin phan hoi--------------- ");
		String xml = logMessage(soapResponse);
		String startTag = "<VerifyResult>";
		String endTag = "</VerifyResult>";
		String status = xml.substring(xml.indexOf(startTag) + startTag.length(), xml.indexOf(endTag));
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setStatus(status.trim());
		if (Objects.equals(responseMessage.getStatus(), "Ok")) {
			responseMessage.setSuccess(true);
		}
		return responseMessage;
	}

}
