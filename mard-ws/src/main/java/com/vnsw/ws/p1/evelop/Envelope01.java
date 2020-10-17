package com.vnsw.ws.p1.evelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope01 {

    public Envelope01() {
    }
    @XmlElement(name = "Header")
    private Header01 Header;
    @XmlElement(name = "Body")
    private Body01 Body;
    @XmlElement(name = "SystemSignature")
    private String SystemSignature;

    public Header01 getHeader() {
        return Header;
    }

    public void setHeader(Header01 Header) {
        this.Header = Header;
    }

    public Body01 getBody() {
        return Body;
    }

    public void setBody(Body01 Body) {
        this.Body = Body;
    }

    public String getSystemSignature() {
        return SystemSignature;
    }

    public void setSystemSignature(String systemSignature) {
        SystemSignature = systemSignature;
    }

}
