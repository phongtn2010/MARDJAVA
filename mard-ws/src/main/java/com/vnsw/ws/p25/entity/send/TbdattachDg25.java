package com.vnsw.ws.p25.entity.send;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.sql.Date;

@XmlType(name = "Packing")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class TbdattachDg25 implements Serializable {


    @XmlElement(name = "PackingNo")
    private String fiSoPhieu;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "PackingDate")
    private Date fiNgayPhieu;
    @XmlElement(name = "PackingAttachmentId")
    private Long fiFileId;
    @XmlElement(name = "PackingName")
    private String fiFileName;
    @XmlElement(name = "PackingFileLink")
    private String fiFileLink;

}
