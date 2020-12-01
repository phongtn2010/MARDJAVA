package com.vnsw.ws.p25.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "Result")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class KetQuaXuLy {
    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;
    @XmlElement(name = "Reason")
    private String fiReason;
    @XmlElement(name = "AttachmentId")
    private String fiAttachmentId;
    @XmlElement(name = "FileName")
    private String fiFileName;
    @XmlElement(name = "FileLink")
    private String fiFileLink;
    @XmlElement(name = "NameOfStaff")
    private String fiNameOfStaff;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ResponseDate")
    private Date fiResponseDate;

}
