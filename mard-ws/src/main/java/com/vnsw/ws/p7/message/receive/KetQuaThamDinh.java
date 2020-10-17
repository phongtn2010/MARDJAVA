package com.vnsw.ws.p7.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "Result")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class KetQuaThamDinh {
    @XmlElement(name = "Reason")
    private String fiReason;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ResultDate")
    private Date fiResultDate;

    @XmlElement(name = "Department")
    private String fiDepartment;

    @XmlElement(name = "CreaterName")
    private String fiCreaterName;


}
