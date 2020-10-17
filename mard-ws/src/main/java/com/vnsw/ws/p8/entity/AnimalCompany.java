package com.vnsw.ws.p8.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnimalCompany")
@Data
public class AnimalCompany {
    @XmlElement(name = "AnimalCompanyName")
    private String fiAnimalCompanyName;

    @XmlElement(name = "AnimalCompanyAddress")
    private String fiAnimalCompanyAddress;
}
