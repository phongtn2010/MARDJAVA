package com.vnsw.ws.p9.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Manufacture")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Manufacture {
    @XmlElement(name = "ManufactureName")
    private String fiManufacturerName;

    @XmlElement(name = "ManufactureAddress")
    private String fiManufacturerAddress;
}
