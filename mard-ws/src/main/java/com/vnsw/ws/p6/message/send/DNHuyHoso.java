package com.vnsw.ws.p6.message.send;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "QuarantineCancel")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class DNHuyHoso {
    @XmlElement(name = "RegistrationComfirmNo")
    private String fiRegistrationComfirmNo;

    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "RequestDate")
    private Date fiRequestDate;
}
