package com.vnsw.ws.p10.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope10 {

    public Envelope10() {
    }
    @XmlElement(name = "Header")
    private Header10 Header;
    @XmlElement(name = "Body")
    private Body10 Body;
    @XmlElement(name = "SystemSignature")
    private String SystemSignature;

    public Header10 getHeader() {
        return Header;
    }

    public void setHeader(Header10 Header) {
        this.Header = Header;
    }

    public Body10 getBody() {
        return Body;
    }

    public void setBody(Body10 Body) {
        this.Body = Body;
    }

    public String getSystemSignature() {
        return SystemSignature;
    }

    public void setSystemSignature(String systemSignature) {
        SystemSignature = systemSignature;
    }

}
