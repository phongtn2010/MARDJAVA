package com.vnsw.ws.p8.entity.json;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p8.entity.Animal;
import com.vnsw.ws.p8.entity.AnimalCompany;
import com.vnsw.ws.p8.entity.LocationQuarantine;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "AnimalRegistration")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class AnimalRegistration {
    @XmlElementWrapper(name = "AnimalList")
    @XmlElement(name = "Animal")
    private List<Animal> fiAnimalList;

    @XmlElementWrapper(name = "AnimalCompanyList")
    @XmlElement(name = "AnimalCompany")
    private List<AnimalCompany> fiAnimalCompanyList;

    @XmlElementWrapper(name = "LocationQuarantineList")
    @XmlElement(name = "LocationQuarantine")
    private List<LocationQuarantine> fiLocationQuarantineList;

    @XmlElement(name = "AnimalFarm")
    private String fiAnimalFarm;

    @XmlElement(name = "AnimalFarmAddress")
    private String fiAnimalFarmAddress;

    @XmlElement(name = "AnimalExecutionTime")
    private String fiAnimalExecutionTime;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "AnimalExecutionTimeFrom")
    private Date fiAnimalExecutionTimeFrom;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "AnimalExecutionTimeFrom")
    private Date fiAnimalExecutionTimeTo;

    @XmlElement(name = "AnimalPurpose")
    private String fiAnimalPurpose;

    @XmlElement(name = "AnimalAttachedDoc")
    private String fiAnimalAttachedDoc;

}
