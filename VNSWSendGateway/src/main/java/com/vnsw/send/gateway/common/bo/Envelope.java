package com.vnsw.send.gateway.common.bo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Phongnv9
 */
@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope {

    public Envelope() {
    }
    @XmlElement(name = "Header")
    private Header Header;
    @XmlElement(name = "Body")
    private Body Body;
    @XmlElement(name = "SystemSignature")
    private String SystemSignature;
    
    
    public Header getHeader() {
        return Header;
    }
    public void setHeader(Header Header) {
        this.Header = Header;
    }

    public Body getBody() {
        return Body;
    }
    public void setBody(Body Body) {
        this.Body = Body;
    }
	public String getSystemSignature() {
		return SystemSignature;
	}
	public void setSystemSignature(String systemSignature) {
		SystemSignature = systemSignature;
	}
    
}
