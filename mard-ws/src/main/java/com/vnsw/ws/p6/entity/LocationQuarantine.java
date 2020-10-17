package com.vnsw.ws.p6.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "LocationQuarantine")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class LocationQuarantine {
    @XmlElement(name = "LocationQuarantineName")
    private String fiLocationQuarantineName;

    @XmlElement(name = "LocationQuarantineAddress")
    private String fiLocationQuarantineAddress;
}
