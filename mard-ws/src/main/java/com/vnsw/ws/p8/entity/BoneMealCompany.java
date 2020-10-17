package com.vnsw.ws.p8.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BoneMealCompany")
@Data
public class BoneMealCompany {
    @XmlElement(name = "BoneMealCompanyName")
    private String fiBoneMealCompanyName;

    @XmlElement(name = "BoneMealCompanyAddress")
    private String fiBoneMealCompanyAddress;
}
