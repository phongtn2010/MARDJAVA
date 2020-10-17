package com.vnsw.ws.p9.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope09 {

    public Envelope09() {
    }
    @XmlElement(name = "Header")
    private com.vnsw.ws.p9.envelop.Header Header;
    @XmlElement(name = "Body")
    private com.vnsw.ws.p9.envelop.Body Body;
    @XmlElement(name = "SystemSignature")
    private String SystemSignature;

    public com.vnsw.ws.p9.envelop.Header getHeader() {
        return Header;
    }

    public void setHeader(com.vnsw.ws.p9.envelop.Header Header) {
        this.Header = Header;
    }

    public com.vnsw.ws.p9.envelop.Body getBody() {
        return Body;
    }

    public void setBody(com.vnsw.ws.p9.envelop.Body Body) {
        this.Body = Body;
    }

    public String getSystemSignature() {
        return SystemSignature;
    }

    public void setSystemSignature(String systemSignature) {
        SystemSignature = systemSignature;
    }

}
