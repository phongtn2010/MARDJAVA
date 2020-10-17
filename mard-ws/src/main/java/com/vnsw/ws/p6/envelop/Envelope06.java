package com.vnsw.ws.p6.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope06 {

    public Envelope06() {
    }
    @XmlElement(name = "Header")
    private Header06 Header;
    @XmlElement(name = "Body")
    private Body06 Body;
    @XmlElement(name = "SystemSignature")
    private String SystemSignature;

    public Header06 getHeader() {
        return Header;
    }

    public void setHeader(Header06 Header) {
        this.Header = Header;
    }

    public Body06 getBody() {
        return Body;
    }

    public void setBody(Body06 Body) {
        this.Body = Body;
    }

    public String getSystemSignature() {
        return SystemSignature;
    }

    public void setSystemSignature(String systemSignature) {
        SystemSignature = systemSignature;
    }

}
