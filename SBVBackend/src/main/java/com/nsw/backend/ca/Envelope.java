package com.nsw.backend.ca;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope {

	public Envelope() {
	}
	@XmlElement(name = "Header")
	private Header Header;
	@XmlElement(name = "Body")
	private Body Body;
	
	public Body getBody() {
		return Body;
	}

	public void setBody(Body Body) {
		this.Body = Body;
	}

	public Header getHeader() {
		return Header;
	}

	public void setHeader(Header header) {
		Header = header;
	}	
}
