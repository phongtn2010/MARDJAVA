package com.vnsw.ws.p12.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope12 {

    public Envelope12() {
    }
    @XmlElement(name = "Header")
    private Header12 Header;
    @XmlElement(name = "Body")
    private Body12 Body;
    @XmlElement(name = "SystemSignature")
    private String SystemSignature;

    public Header12 getHeader() {
        return Header;
    }

    public void setHeader(Header12 Header) {
        this.Header = Header;
    }

    public Body12 getBody() {
        return Body;
    }

    public void setBody(Body12 Body) {
        this.Body = Body;
    }

    public String getSystemSignature() {
        return SystemSignature;
    }

    public void setSystemSignature(String systemSignature) {
        SystemSignature = systemSignature;
    }

}
