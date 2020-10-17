package com.vnsw.ws.p8.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Animal")
@Data
public class Animal {

    @XmlElement(name = "AnimalSort")
    private Integer fiAnimalSort;

    @XmlElement(name = "AnimalCode")
    private String fiAnimalCode;

    @XmlElement(name = "AnimalName")
    private String fiAnimalName;

    @XmlElement(name = "AnimalQuantityFemale")
    private String fiAnimalQuantityFemale;

    @XmlElement(name = "AnimalQuantityMale")
    private String fiAnimalQuantityMale;

    @XmlElement(name = "AnimalExporterStateName")
    private String fiAnimalExporterStateName;

    @XmlElement(name = "AnimalExporterStateCode")
    private String fiAnimalExporterStateCode;

    @XmlElement(name = "AnimalPortOfDestinationName")
    private String fiAnimalPortOfDestinationName;

    @XmlElement(name = "AnimalPortOfDestinationCode")
    private String fiAnimalPortOfDestinationCode;
}
