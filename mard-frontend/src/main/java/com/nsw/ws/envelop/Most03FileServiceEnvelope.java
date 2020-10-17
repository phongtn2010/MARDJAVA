package com.nsw.ws.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.nsw.ws.common.Header;

/**
 *
 * @author Phongnv9
 */
@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Most03FileServiceEnvelope {

    public Most03FileServiceEnvelope() {
    }
    @XmlElement(name = "Header")
    private Header Header;
    @XmlElement(name = "Body")
    private Most03FileServiceBody Body;
    @XmlElement(name = "SystemSignature")
    private String SystemSignature;

    public Header getHeader() {
        return Header;
    }

    public void setHeader(Header Header) {
        this.Header = Header;
    }

    public Most03FileServiceBody getBody() {
        return Body;
    }

    public void setBody(Most03FileServiceBody Body) {
        this.Body = Body;
    }

    public String getSystemSignature() {
        return SystemSignature;
    }

    public void setSystemSignature(String systemSignature) {
        SystemSignature = systemSignature;
    }

}
