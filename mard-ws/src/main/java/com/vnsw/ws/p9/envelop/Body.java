package com.vnsw.ws.p9.envelop;

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
    private com.vnsw.ws.p9.envelop.Content Content;
    private String Signature;

    public String getSignature() {
        return Signature;
    }
    
    public void setSignature(String Signature) {
        this.Signature = Signature;
    }
    public com.vnsw.ws.p9.envelop.Content getContent() {
        return Content;
    }

    public void setContent(com.vnsw.ws.p9.envelop.Content Content) {
        this.Content = Content;
    }
}
