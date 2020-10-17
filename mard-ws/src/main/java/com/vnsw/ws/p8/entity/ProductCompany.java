package com.vnsw.ws.p8.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ProductCompany")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ProductCompany {
    @XmlElement(name = "ProductCompanyName")
    private String fiProductCompanyName;

    @XmlElement(name = "ProductCompanyAddress")
    private String fiProductCompanyAddress;
}
