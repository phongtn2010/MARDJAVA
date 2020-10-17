package com.vnsw.ws.p1.evelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Body")
public class Body01 {

    public Body01() {
    }
    @XmlElement(name = "Content")
    private Content01 Content;
    private String Signature;

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String Signature) {
        this.Signature = Signature;
    }
    public Content01 getContent() {
        return Content;
    }

    public void setContent(Content01 Content) {
        this.Content = Content;
    }
}
