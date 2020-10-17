package com.vnsw.ws.p1.entity.send;

import lombok.Data;

import javax.xml.bind.annotation.*;

@XmlType(name = "AnimalSend")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Animal {
    @XmlTransient
    private Integer fiIdAnimail;

    @XmlElement(name = "ID")
    private String fiID;

    @XmlElement(name = "HSCode")
    private String fiHSCode;

    @XmlElement(name = "AnimalTypeVni")
    private String fiAnimalTypeVni;

    @XmlElement(name = "AnimalType")
    private String fiAnimalType;

    @XmlElement(name = "BreedVni")
    private String fiBreedVni;

    @XmlElement(name = "Breed")
    private String fiBreed;

    @XmlElement(name = "Age")
    private String fiAge;

    @XmlElement(name = "Sex")
    private Integer fiSex;

    @XmlElement(name = "Number")
    private Integer fiNumber;

    @XmlElement(name = "AnimalNetWeight")
    private Integer fiAnimalNetWeight;

    @XmlElement(name = "AnimalUnitCode")
    private String fiAnimalUnitCode;

    @XmlElement(name = "AnimalUnitVni")
    private String fiAnimalUnitVni;

    @XmlElement(name = "AnimalUnit")
    private String fiAnimalUnit;

    @XmlElement(name = "PurposeVni")
    private String fiPurposeVni;

    @XmlElement(name = "Purpose")
    private String fiPurpose;

    @XmlElement(name = "Shipmentvalue")
    private Float fiShipmentvalue;
}
