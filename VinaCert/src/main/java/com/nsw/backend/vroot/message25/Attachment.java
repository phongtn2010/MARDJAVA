package com.nsw.backend.vroot.message25;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Attachment")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Attachment {


    @XmlElement(name = "FileCode")
//    private Long fiLoaifile;
    private Integer fiFileTypeBNN;
    @XmlElement(name = "AttachmentId")
    private Long fiFileId;
    @XmlElement(name = "FileName")
    private String fiFileName;
    @XmlElement(name = "FileLink")
    private String fiFileLink;

}
