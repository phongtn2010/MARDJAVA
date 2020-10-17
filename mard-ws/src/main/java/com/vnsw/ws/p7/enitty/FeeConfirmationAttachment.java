package com.vnsw.ws.p7.enitty;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AttachmentFee")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class FeeConfirmationAttachment {
    @XmlElement(name = "FileName")
    String fiFileName;

    @XmlElement(name = "FileByte")
    String fiFileByte;
}
