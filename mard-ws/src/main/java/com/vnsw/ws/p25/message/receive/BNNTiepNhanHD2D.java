package com.vnsw.ws.p25.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "ResultReception2d")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class BNNTiepNhanHD2D {
    @XmlElement(name = "NSWFileCode")
    String fiNSWFileCode;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ResponseDate")
    Date fiResponeDate;
}
