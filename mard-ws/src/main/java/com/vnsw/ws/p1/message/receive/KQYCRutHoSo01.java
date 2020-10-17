package com.vnsw.ws.p1.message.receive;

import com.vnsw.ws.util.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "ResponseCancel")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class KQYCRutHoSo01 {

    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;

    @XmlElement(name = "Reason")
    private String fiReason;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    private Date fiSignConfirmDate;

    @XmlElement(name = "CreaterName")
    private String fiCreaterName;
}
