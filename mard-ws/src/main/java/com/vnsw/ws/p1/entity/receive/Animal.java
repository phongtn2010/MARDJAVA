package com.vnsw.ws.p1.entity.receive;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AnimalReceive")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Animal {

    @XmlElement(name = "ID")
    private String fiID;

    @XmlElement(name = "AnimalTypeVni")
    private String fiAnimalTypeVni;

    @XmlElement(name = "AnimalType")
    private String fiAnimalType;

    @XmlElement(name = "OfficialMark")
    private String fiOfficialMark;

    @XmlElement(name = "BreedVni")
    private String fiBreedVni;

    @XmlElement(name = "Breed")
    private String fiBreed;

    @XmlElement(name = "Age")
    private String fiAge;

    @XmlElement(name = "Sex")
    private Integer fiSex;
}
