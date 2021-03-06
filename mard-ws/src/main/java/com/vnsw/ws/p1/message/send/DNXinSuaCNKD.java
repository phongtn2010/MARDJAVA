package com.vnsw.ws.p1.message.send;

import com.vnsw.ws.util.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "RequestEditCer")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class DNXinSuaCNKD {

    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "RequestDate")
    private Date fiRequestDate;

    @XmlElement(name = "FileName")
    private String fiFileName;

    @XmlElement(name = "FileAttack")
    private String fiFileAttack;

    @XmlElement(name = "Reason")
    private String fiReason;
}
