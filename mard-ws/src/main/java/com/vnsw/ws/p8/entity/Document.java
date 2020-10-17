package com.vnsw.ws.p8.entity;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "Document")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Document {
    @XmlElement(name = "TypeDoc")
    private int fiTypeDoc;

    @XmlElement(name = "Number")
    private String fiNumber;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "Date")
    private Date fiDate;
}
