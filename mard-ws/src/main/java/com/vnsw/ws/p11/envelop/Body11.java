package com.vnsw.ws.p11.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Body")
public class Body11 {

    public Body11() {
    }
    @XmlElement(name = "Content")
    private Content11 Content;
    private String Signature;

    public String getSignature() {
        return Signature;
    }
    
    public void setSignature(String Signature) {
        this.Signature = Signature;
    }
    public Content11 getContent() {
        return Content;
    }

    public void setContent(Content11 Content) {
        this.Content = Content;
    }
}
