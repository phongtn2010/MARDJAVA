package com.vnsw.ws.p26.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope26 {

    public Envelope26() {
    }
    @XmlElement(name = "Header")
    private Header26 Header;
    @XmlElement(name = "Body")
    private Body26 Body;

//    @XmlElement(name = "SystemSignature")
//    private String SystemSignature;

    public Header26 getHeader() {
        return Header;
    }

    public void setHeader(Header26 Header) {
        this.Header = Header;
    }

    public Body26 getBody() {
        return Body;
    }

    public void setBody(Body26 Body) {
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
