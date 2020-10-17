package com.vnsw.ws.p8.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "ProductManufacture")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ProductManufacture {
    @XmlElement(name = "ProductManufactureName")
    private String fiProductManufactureName;

    @XmlElement(name = "ProductManufactureAddress")
    private String fiProductManufactureAddress;
}