package com.vnsw.ws.p8.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BoneMealManufacture")
@Data
public class BoneMealManufacture {
    @XmlElement(name = "BoneMealManufactureName")
    private String fiBoneMealManufactureName;

    @XmlElement(name = "BoneMealManufactureAddress")
    private String fiBoneMealManufactureAddress;
}
