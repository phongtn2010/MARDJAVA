package com.vnsw.ws.p8.evelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Body")
public class Body08 {

    public Body08() {
    }
    @XmlElement(name = "Content")
    private Content08 Content;
    private String Signature;

    public String getSignature() {
        return Signature;
    }
    
    public void setSignature(String Signature) {
        this.Signature = Signature;
    }
    public Content08 getContent() {
        return Content;
    }

    public void setContent(Content08 Content) {
        this.Content = Content;
    }
}
