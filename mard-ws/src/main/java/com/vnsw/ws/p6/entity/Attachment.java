package com.vnsw.ws.p6.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Attachment")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Attachment {
    @XmlElement(name = "AttachmentId")
    private String fiAttachmentId;

    @XmlElement(name = "AttachmentTypeCode")
    private Long fiAttachmentTypeCode;

    @XmlElement(name = "NameOfAttachment")
    private String fiNameOfAttachment;

    @XmlElement(name = "LinkFile")
    private String fiLinkFile;
}
