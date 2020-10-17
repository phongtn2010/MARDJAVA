package com.vnsw.ws.p1.evelop;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Body")
public class Body01Err {

    public Body01Err() {
    }
    @XmlElement(name = "Content")
    private String Content;
    private String Signature;
}
