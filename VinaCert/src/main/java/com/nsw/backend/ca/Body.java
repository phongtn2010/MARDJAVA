package com.nsw.backend.ca;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Body")
public class Body {

	public Body() {
	}

	@XmlElement(name = "VerifyResponse")
	private VerifyResponse verifyResponse;

	public VerifyResponse getVerifyResponse() {
		return verifyResponse;
	}

	public void setVerifyResponse(VerifyResponse verifyResponse) {
		this.verifyResponse = verifyResponse;
	}
}
