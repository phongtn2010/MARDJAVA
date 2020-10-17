package com.vnsw.ws.p6.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Processing")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Processing {
    @XmlElement(name = "ProcessingName")
    private String fiProcessingName;

    @XmlElement(name = "ProcessingAddress")
    private String fiProcessingAddress;

    @XmlElement(name = "ProcessingApprovalNUmber")
    private String fiProcessingApprovalNumber;

}
