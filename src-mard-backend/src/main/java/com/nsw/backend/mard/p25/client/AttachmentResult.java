package com.nsw.backend.mard.p25.client;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@Data
public class AttachmentResult {

    private Long fiLoaiFile;


    private String fiFileId;


    private String fiFileName;


    private String fiFileLink;
}
