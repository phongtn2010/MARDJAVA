package com.vnsw.ws.p6.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Body")
public class Body06 {

    public Body06() {
    }
    @XmlElement(name = "Content")
    private Content06 Content;
    private String Signature;

    public String getSignature() {
        return Signature;
    }
    
    public void setSignature(String Signature) {
        this.Signature = Signature;
    }
    public Content06 getContent() {
        return Content;
    }

    public void setContent(Content06 Content) {
        this.Content = Content;
    }
}
