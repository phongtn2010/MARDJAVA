package com.vnsw.ws.p26.entity.receive;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AttachmentResult")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class AttachmentResult {
    @XmlElement(name = "FileCode")
    private Long fiFileCode;

    @XmlElement(name = "AttachmentId")
    private String fiAttachmentId;

    @XmlElement(name = "FileName")
    private String fiNameOfAttachment;

    @XmlElement(name = "FileLink")
    private String fiLinkFile;
}
