package com.vnsw.ws.p9.message.send;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "ResponseQualityResult")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class DNPhanHoiKQXNCL {

    @XmlElement(name = "Deescription")
    private String fiDescription;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ResponseDate")
    private Date fiResponseDate;

    @XmlElement(name = "ResponseUser")
    private String fiResponseUser;
}
