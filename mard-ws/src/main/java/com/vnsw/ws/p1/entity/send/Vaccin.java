package com.vnsw.ws.p1.entity.send;

import com.vnsw.ws.util.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "Vaccin")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Vaccin {

    @XmlElement(name = "VaccinationAgainstName")
    private String fiVaccinationAgainstName;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "VaccinationAgainstDate")
    private Date fiVaccinationAgainstDate;
}
