package com.vnsw.ws.p8.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Seller")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Seller {

    @XmlElement(name = "SellerStateCode")
    private String fiSellerStateCode;

    @XmlElement(name = "SellerStateName")
    private String fiSellerStateName;

    @XmlElement(name = "SellerName")
    private String fiSellerName;

    @XmlElement(name = "SellerAddress")
    private String fiSellerAddress;

    @XmlElement(name = "SellerPhone")
    private String fiSellerPhone;

    @XmlElement(name = "SellerFax")
    private String fiSellerFax;
}
