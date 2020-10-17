package com.vnsw.ws.p8.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Manufacture")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ManufactureKDNK {
    @XmlElement(name = "ManufacturerName")
    private String fiManufactureName;

    @XmlElement(name = "ManufactureAddress")
    private String fiManufactureAddress;
}
