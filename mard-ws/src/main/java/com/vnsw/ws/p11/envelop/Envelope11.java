package com.vnsw.ws.p11.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope11 {

    public Envelope11() {
    }
    @XmlElement(name = "Header")
    private Header11 Header;
    @XmlElement(name = "Body")
    private Body11 Body;
    @XmlElement(name = "SystemSignature")
    private String SystemSignature;

    public Header11 getHeader() {
        return Header;
    }

    public void setHeader(Header11 Header) {
        this.Header = Header;
    }

    public Body11 getBody() {
        return Body;
    }

    public void setBody(Body11 Body) {
        this.Body = Body;
    }

    public String getSystemSignature() {
        return SystemSignature;
    }

    public void setSystemSignature(String systemSignature) {
        SystemSignature = systemSignature;
    }

}
