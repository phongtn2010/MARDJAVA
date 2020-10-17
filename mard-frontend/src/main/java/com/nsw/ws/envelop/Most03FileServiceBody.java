package com.nsw.ws.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Phongnv9
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Body")
public class Most03FileServiceBody {

    public Most03FileServiceBody() {
    }
    @XmlElement(name = "Content")
    private Most03FileServiceContent Content;
    private String Signature;

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String Signature) {
        this.Signature = Signature;
    }

    public Most03FileServiceContent getContent() {
        return Content;
    }

    public void setContent(Most03FileServiceContent Content) {
        this.Content = Content;
    }
}
