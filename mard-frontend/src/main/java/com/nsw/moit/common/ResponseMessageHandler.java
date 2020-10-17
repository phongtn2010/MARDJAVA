package com.nsw.moit.common;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ResponseMessageHandler extends DefaultHandler {

	private ResponseMessage message = new ResponseMessage();
	private String curentElement = "";


	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equals(TAG_SEND_RESPONSE)) {
			message = new ResponseMessage();
			curentElement = qName;
		} else if (qName.equals(TAG_SEND_RETURN)) {
			curentElement = qName;
		} else {
			curentElement = "";
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		if (curentElement.equals(TAG_SEND_RETURN)) {
			String msg = new String(ch, start, length);
			message.setStatus(msg);
			if ("Ok".equals(msg)) {
				message.setSuccess(true);
			}
		}
	}

	public ResponseMessage getMessage() {
		return message;
	}

	public void setMessage(ResponseMessage message) {
		this.message = message;
	}

	private static final String TAG_SEND_RESPONSE = "VerifyResponse";
	private static final String TAG_SEND_RETURN = "VerifyResult";

}
