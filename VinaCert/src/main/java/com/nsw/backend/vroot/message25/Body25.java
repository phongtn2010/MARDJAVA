package com.nsw.backend.vroot.message25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Body")
public class Body25 {

    public Body25() {
    }
    @XmlElement(name = "Content")
    private Content25 Content;
//    private String Signature;

//    public String getSignature() {
//        return Signature;
//    }
//
//    public void setSignature(String Signature) {
//        this.Signature = Signature;
//    }
    public Content25 getContent() {
        return Content;
    }

    public void setContent(Content25 Content) {
        this.Content = Content;
    }
}
