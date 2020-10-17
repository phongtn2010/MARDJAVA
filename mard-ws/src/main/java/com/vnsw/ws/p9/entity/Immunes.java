package com.vnsw.ws.p9.entity;

import com.vnsw.ws.annotations.DateSerialization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "Immunes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Immunes {
    @XmlElement(name = "DiseaseName")
    private String fiDiseaseName;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "VaccinationDate")
    private Date fiVaccinationDate;

    public Immunes(String fiDiseaseName, Date fiVaccinationDate) {
        this.fiDiseaseName = fiDiseaseName;
        this.fiVaccinationDate = fiVaccinationDate;
    }

    public Immunes() {
    }

    public String getFiDiseaseName() {
        return fiDiseaseName;
    }

    public void setFiDiseaseName(String fiDiseaseName) {
        this.fiDiseaseName = fiDiseaseName;
    }

    public Date getFiVaccinationDate() {
        return fiVaccinationDate;
    }

    public void setFiVaccinationDate(Date fiVaccinationDate) {
        this.fiVaccinationDate = fiVaccinationDate;
    }
}
