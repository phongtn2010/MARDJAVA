package com.vnsw.ws.p25.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ExporterCountry")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ExporterCountry {
    @XmlElement(name = "ExporterCountryName")
    private String fiExporterCountryName;

    @XmlElement(name = "ExporterCountryAddress")
    private String fiExporterCountryAddress;
}
