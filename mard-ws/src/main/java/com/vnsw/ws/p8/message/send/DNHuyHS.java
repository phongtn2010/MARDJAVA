package com.vnsw.ws.p8.message.send;

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
public class DNHuyHS {
    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;

    @XmlElement(name = "RegistrationComfirmNo")
    private String fiRegistrationComfirmNo;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "RequestDate")
    private Date fiRequestDate;
}
