package com.vnsw.ws.p10.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Body")
public class Body10 {

    public Body10() {
    }
    @XmlElement(name = "Content")
    private Content10 Content;
    private String Signature;

    public String getSignature() {
        return Signature;
    }
    
    public void setSignature(String Signature) {
        this.Signature = Signature;
    }
    public Content10 getContent() {
        return Content;
    }

    public void setContent(Content10 Content) {
        this.Content = Content;
    }
}
