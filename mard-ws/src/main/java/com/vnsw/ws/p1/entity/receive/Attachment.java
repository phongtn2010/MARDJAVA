package com.vnsw.ws.p1.entity.receive;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AttachmentReceive")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Attachment {

    @XmlElement(name = "FileName")
    private String fiFileName;

    @XmlElement(name = "FileByte")
    private String fiFileByte;
}
