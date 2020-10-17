package com.vnsw.ws.p8.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "Manufacturer")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Manufacturer {
    @XmlElement(name = "ManufacturerName")
    private String fiManufacturerName;

    @XmlElement(name = "ManufactureFactoryAddress")
    private String fiManufactureFactoryAddress;

    @XmlElement(name = "CountryCode")
    private String fiCountryCode;

    @XmlElement(name = "CountryName")
    private String fiCountryName;
}
