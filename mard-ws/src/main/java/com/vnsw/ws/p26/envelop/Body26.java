package com.vnsw.ws.p26.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Body")
public class Body26 {

    public Body26() {
    }
    @XmlElement(name = "Content")
    private Content26 Content;
//    private String Signature;

//    public String getSignature() {
//        return Signature;
//    }
//
//    public void setSignature(String Signature) {
//        this.Signature = Signature;
//    }
    public Content26 getContent() {
        return Content;
    }

    public void setContent(Content26 Content) {
        this.Content = Content;
    }
}
