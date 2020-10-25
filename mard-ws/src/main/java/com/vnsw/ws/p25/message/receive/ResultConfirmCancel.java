package com.vnsw.ws.p25.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "ResultConfirmCancel")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ResultConfirmCancel {
    @XmlElement(name = "NSWFileCode")
    String fiNSWFileCode;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "CancelDate")
    Date fiCancelDate;
    @XmlElement(name = "Reason")
    String fiReason;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    Date fiSignConfirmDate;
    @XmlElement(name = "SignConfirmName")
    String fiSignConfirmName;
    @XmlElement(name = "AniFeedConfirmNo")
    String fiAniFeedConfirmNo;
    @XmlElement(name = "AttachmentId")
    Long fiAttachmentId;
    @XmlElement(name = "FileName")
    String fiFileName;
    @XmlElement(name = "FileLink")
    String fiFileLink;
}
