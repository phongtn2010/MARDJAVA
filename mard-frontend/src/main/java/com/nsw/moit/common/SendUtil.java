package com.nsw.moit.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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

	
	private SendUtil() {
	}

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

	private static String logMessage(SOAPMessage soapResponse) throws TransformerException, SOAPException {

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		Source sourceContent = soapResponse.getSOAPPart().getContent();
                transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
                transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		StringWriter outWriter = new StringWriter();
		StreamResult result = new StreamResult(outWriter);
		transformer.transform(sourceContent, result);
		StringBuffer sb = outWriter.getBuffer();
		String finalstring = sb.toString();
		log.info("SOAP message: {}", finalstring);
		return finalstring;
	
	}

	private static ResponseMessage getSOAPResponse(SOAPMessage soapResponse)  throws TransformerException, SOAPException, IOException, ParserConfigurationException, SAXException {
		
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
		ResponseMessage responseMessage = messageHandler.getMessage();
		switch (responseMessage.getStatus()) {
		case "Ok":
			responseMessage.setMessage("Chữ ký số hợp lệ");
			break;
		case "NotPublicKey":
			responseMessage.setMessage("Chuỗi ký số không chứa public key");
			break;
		case "NotSignanture":
			responseMessage.setMessage("Không có chữ ký");
			break;
		case "NotValidDate":
			responseMessage.setMessage("Chứng thư số hết hạn");
			break;
		case "NotValidSignature":
			responseMessage.setMessage("Chữ ký số không hợp lệ");
			break;
		case "NotRegister":
			responseMessage.setMessage("Chứng thư số chưa đăng ký với hệ thống Hải quan một cửa Quốc gia");
			break;
		case "Revoked":
			responseMessage.setMessage("Chứng thư số đã bị thu hồi");
			break;
		case "Unknown":
			responseMessage.setMessage("Lỗi không xác định, liên hệ quản trị viên để được hỗ trợ");
			break;
		case "Error":
			responseMessage.setMessage("Có lỗi trong quá trình ký, liên hệ quản trị viên để được hỗ trợ");
			break;
		case "ErrorValidateCustoms":
			responseMessage.setMessage("Lỗi kiểm tra chứng thư với hệ thống Hải Quan");
			break;
		case "NotValidXml":
			responseMessage.setMessage("Bản tin sau khi ký không đúng định dạng");
			break;
		case "NotValidCert":
			responseMessage.setMessage("Chữ ký số không đúng định dạng");
			break;
		default:
			responseMessage.setMessage("Lỗi không xác định");
			break;
		}
		return messageHandler.getMessage();
	}

	

}
