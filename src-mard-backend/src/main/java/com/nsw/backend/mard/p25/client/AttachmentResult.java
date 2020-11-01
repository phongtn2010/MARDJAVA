package com.nsw.backend.mard.p25.client;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@Data
public class AttachmentResult {

    private Long fiFileCode;


    private String fiAttachmentId;


    private String fiNameOfAttachment;


    private String fiLinkFile;
}
