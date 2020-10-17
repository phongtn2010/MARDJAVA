package com.vnsw.ws.p1.entity.send;

import com.vnsw.ws.util.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "Test")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Test {

    @XmlElement(name = "TestName")
    private String fiTestName;

    @XmlElement(name = "TestNumber")
    private String fiTestNumber;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "TestDate")
    private Date fiTestDate;
}
