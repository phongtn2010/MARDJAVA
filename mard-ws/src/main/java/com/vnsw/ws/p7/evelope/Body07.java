package com.vnsw.ws.p7.evelope;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Body")
public class Body07 {

    public Body07() {
    }
    @XmlElement(name = "Content")
    private Content07 Content;
    private String Signature;

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String Signature) {
        this.Signature = Signature;
    }
    public Content07 getContent() {
        return Content;
    }

    public void setContent(Content07 Content) {
        this.Content = Content;
    }
}
