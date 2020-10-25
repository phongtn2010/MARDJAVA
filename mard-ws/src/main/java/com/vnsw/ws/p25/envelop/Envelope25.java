package com.vnsw.ws.p25.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope25 {

    public Envelope25() {
    }
    @XmlElement(name = "Header")
    private Header25 Header;
    @XmlElement(name = "Body")
    private Body25 Body;

//    @XmlElement(name = "SystemSignature")
//    private String SystemSignature;

    public Header25 getHeader() {
        return Header;
    }

    public void setHeader(Header25 Header) {
        this.Header = Header;
    }

    public Body25 getBody() {
        return Body;
    }

    public void setBody(Body25 Body) {
        this.Body = Body;
    }

//    public String getSystemSignature() {
//        return SystemSignature;
//    }
//
//    public void setSystemSignature(String systemSignature) {
//        SystemSignature = systemSignature;
//    }

}
