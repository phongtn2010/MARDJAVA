package com.vnsw.ws.p7.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;


@XmlType(name = "RegistrationComfirm")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class XacNhanDonDangKy {
    @XmlElement(name = "RegistrationComfirmNo")
    private String fiRegistrationComfirmNo;

    @XmlElement(name = "CheckPlace")
    private String fiCheckPlace;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "CheckTimeFrom")
    private Date fiCheckTimeFrom;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "CheckTimeTo")
    private Date fiCheckTimeTo;

    @XmlElement(name = "CreaterName")
    private String fiCreaterName;
}
