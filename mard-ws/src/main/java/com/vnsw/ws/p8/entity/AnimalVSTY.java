package com.vnsw.ws.p8.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnimalVSTY")
@Data
public class AnimalVSTY {
    @XmlElement(name = "AnimalSort")
    private Long fiAnimalSort;

    @XmlElement(name = "AnimalId")
    private Long fiAnimalId;

    @XmlElement(name = "AnimalName")
    private String fiAnimalName;

    @XmlElement(name = "AnimalQuantityFemale")
    private Long fiAnimalQuantityFemale;

    @XmlElement(name = "AnimalQuantityMale")
    private Long fiAnimalQuantityMale;

    @XmlElement(name = "AnimalExporterStateName")
    private String fiAnimalExporterStateName;

    @XmlElement(name = "AnimalPortOfDestinationName")
    private String fiAnimalPortOfDestinationName;
}
