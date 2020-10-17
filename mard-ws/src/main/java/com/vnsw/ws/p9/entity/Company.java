package com.vnsw.ws.p9.entity;


import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Company")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Company {
    @XmlElement(name = "CompanyName")
    private String fiCompanyName;

    @XmlElement(name = "CompanyAddress")
    private String fiCompanyAddress;

}
