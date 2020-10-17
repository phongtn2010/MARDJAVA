package com.vnsw.ws.p7.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "ResponseEdit")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class PhanhoiYeucauSuaHoso {
    @XmlElement(name = "Reason")
    String fiReason;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    Date fiSignConfirmDate;

    @XmlElement(name = "Department")
    String fiDepartment;

    @XmlElement(name = "CreaterName")
    String fiCreaterName;
}
