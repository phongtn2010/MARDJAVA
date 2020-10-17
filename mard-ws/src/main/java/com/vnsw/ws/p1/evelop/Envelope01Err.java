package com.vnsw.ws.p1.evelop;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope01Err {

    public Envelope01Err() {
    }
    @XmlElement(name = "Header")
    private Header01 Header;
    @XmlElement(name = "Body")
    private Body01Err Body;
    @XmlElement(name = "SystemSignature")
    private String SystemSignature;
}
