package com.vnsw.ws.p04.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.vnsw.ws.common.envelop.Header;

@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope {

    public Envelope() {
    }
    @XmlElement(name = "Header")
    private Header Header;
    @XmlElement(name = "Body")
    private Body Body;

    public Header getHeader() {
        return Header;
    }

    public void setHeader(Header Header) {
        this.Header = Header;
    }

    public Body getBody() {
        return Body;
    }

    public void setBody(Body Body) {
        this.Body = Body;
    }

}
