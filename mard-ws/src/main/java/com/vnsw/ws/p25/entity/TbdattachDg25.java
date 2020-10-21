package com.vnsw.ws.p25.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.sql.Date;

@XmlType(name = "Attachment")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class TbdattachDg25 implements Serializable {


    @XmlElement(name = "PackingNo")
    private String fiSoPhieu;
    @XmlElement(name = "PackingDate")
    private Date fiNgayPhieu;
    @XmlElement(name = "PackingAttachmentId")
    private Long fiFileId;
    @XmlElement(name = "PackingName")
    private String fiFileName;
    @XmlElement(name = "PackingFileLink")
    private String fiFileLink;

}
