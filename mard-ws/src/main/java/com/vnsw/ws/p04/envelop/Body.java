package com.vnsw.ws.p04.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Body")
public class Body {

    public Body() {
    }
    @XmlElement(name = "Content")
    private Content Content;
    
    @XmlElement(name = "Signature")
    private String Signature;

    public String getSignature() {
        return Signature;
    }
    
    public void setSignature(String Signature) {
        this.Signature = Signature;
    }
    public Content getContent() {
        return Content;
    }

    public void setContent(Content Content) {
        this.Content = Content;
    }
}
