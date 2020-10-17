package com.vnsw.ws.p8.entity;


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

    @XmlElement(name = "NameOfAttachment")
    private String fiNameOfAttachment;

    @XmlElement(name = "LinkFile")
    private String fiLinkFile;

}
