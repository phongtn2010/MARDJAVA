package com.vnsw.ws.p9.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Attachment")
@Data
public class Attachment {

    @XmlElement(name = "AttachmentId")
    private String fiAttachmentId;

    @XmlElement(name = "AttachmentTypeCode")
    private int fiAttachmentTypeCode;

    @XmlElement(name = "AttachmentTypeName")
    private String fiAttachmentTypeName;

    @XmlElement(name = "AttachmentName")
    private String fiAttachmentName;

    @XmlElement(name = "LinkFile")
    private String fiLinkFile;

}
