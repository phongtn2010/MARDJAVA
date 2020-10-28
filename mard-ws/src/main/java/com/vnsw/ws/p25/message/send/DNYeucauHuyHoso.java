package com.vnsw.ws.p25.message.send;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "RequestCancel")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class DNYeucauHuyHoso {

    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "RequestDate")
    private Date fiRequestDate;
    @XmlElement(name = "Reason")
    private String fiReason;
    @XmlElement(name = "AttachmentId")
    private Long fiAttachmentId;
    @XmlElement(name = "FileName")
    private String fiFileName;
    @XmlElement(name = "FileLink")
    private String fiFileLink;


}
