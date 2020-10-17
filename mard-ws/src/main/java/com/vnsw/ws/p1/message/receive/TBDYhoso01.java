package com.vnsw.ws.p1.message.receive;

import com.vnsw.ws.util.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "ResultRegistration")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class TBDYhoso01 {

    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;

    @XmlElement(name = "Reason")
    private String fiReason;

    @XmlElement(name = "CreaterName")
    private String fiCreaterName;

    @XmlElement(name = "RegistationConfirmNo")
    private String fiRegistationConfirmNo;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "RegistationConfirmDate")
    private Date fiRegistationConfirmDate;

    @XmlElement(name = "CheckPlace")
    private String fiCheckPlace;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "CheckTime")
    private Date fiCheckTime;
}
