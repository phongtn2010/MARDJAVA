package com.vnsw.ws.p12.envelop;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "Reference")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reference12 {

    public Reference12() {
    }

    public Reference12(String version, String messageId) {
        this.setMessageId(messageId);
        this.setVersion(version);
    }
    
    @XmlElement(name = "version")
    @Size(max = 50)
    private String version;
    @Size(max = 35)
    @XmlElement(name = "messageId")
    private String messageId;

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageId() {
        return messageId;
    }
}
