package com.vnsw.ws.p26.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "ApplicationResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class PhanHoiDonDK {
    @XmlElement(name = "NSWFileCode")
    String fiMaHoso;
    @XmlElement(name = "NameOfStaff")
    String fiNguoiXL;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ResponseDate")
    private Date fiNgayXL;
}
