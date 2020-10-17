package com.vnsw.ws.p12.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Body")
public class Body12 {

    public Body12() {
    }
    @XmlElement(name = "Content")
    private Content12 Content;
    private String Signature;

    public String getSignature() {
        return Signature;
    }
    
    public void setSignature(String Signature) {
        this.Signature = Signature;
    }
    public Content12 getContent() {
        return Content;
    }

    public void setContent(Content12 Content) {
        this.Content = Content;
    }
}
