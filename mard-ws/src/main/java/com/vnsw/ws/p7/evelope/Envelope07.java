package com.vnsw.ws.p7.evelope;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope07 {

    public Envelope07() {
    }
    @XmlElement(name = "Header")
    private Header07 Header;
    @XmlElement(name = "Body")
    private Body07 Body;
    @XmlElement(name = "SystemSignature")
    private String SystemSignature;

    public Header07 getHeader() {
        return Header;
    }

    public void setHeader(Header07 Header) {
        this.Header = Header;
    }

    public Body07 getBody() {
        return Body;
    }

    public void setBody(Body07 Body) {
        this.Body = Body;
    }

    public String getSystemSignature() {
        return SystemSignature;
    }

    public void setSystemSignature(String systemSignature) {
        SystemSignature = systemSignature;
    }

}
