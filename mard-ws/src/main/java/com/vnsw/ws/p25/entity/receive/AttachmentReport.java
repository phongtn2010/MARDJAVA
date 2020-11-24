package com.vnsw.ws.p25.entity.receive;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AttachmentReport")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class AttachmentReport {

    @XmlElement(name = "FileCode")
    private Long fiFileTypeID;
    @XmlElement(name = "AttachmentId")
    private Long fiGuidBNN;
    @XmlElement(name = "FileName")
    private String fiFileHD;
    @XmlElement(name = "FileLink")
    private String fiLinkBNN;

}
