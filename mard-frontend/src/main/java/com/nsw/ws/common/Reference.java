package com.nsw.ws.common;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Phongnv9
 */

@XmlType(name = "Reference")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reference {

    public Reference() {
    }

    public Reference(String version, String messageId) {
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
