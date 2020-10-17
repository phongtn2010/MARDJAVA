package com.vnsw.ws.p8.evelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope08 {

    public Envelope08() {
    }
    @XmlElement(name = "Header")
    private Header08 Header;
    @XmlElement(name = "Body")
    private Body08 Body;
    @XmlElement(name = "SystemSignature")
    private String SystemSignature;

    public Header08 getHeader() {
        return Header;
    }

    public void setHeader(Header08 Header) {
        this.Header = Header;
    }

    public Body08 getBody() {
        return Body;
    }

    public void setBody(Body08 Body) {
        this.Body = Body;
    }

    public String getSystemSignature() {
        return SystemSignature;
    }

    public void setSystemSignature(String systemSignature) {
        SystemSignature = systemSignature;
    }

}
