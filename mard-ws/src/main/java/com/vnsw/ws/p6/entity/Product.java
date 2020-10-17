package com.vnsw.ws.p6.entity;

import com.vnsw.ws.annotations.DoubleSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Product {
    @XmlElement(name = "Id")
    private Long fiId;

    @XmlElement(name = "ProductBusinessName")
    private String fiProductBusinessName;

    @XmlElement(name = "ProductScienceName")
    private String fiProductScienceName;

    @XmlElement(name = "PackageUnitCode")
    private String fiPackageUnitCode;

    @XmlElement(name = "PackageUnitName")
    private String fiPackageUnitName;

    @XmlElement(name = "OriginCountryCode")
    private String fiOriginCountryCode;

    @XmlElement(name = "OriginCountryName")
    private String fiOriginCountryName;

    @XmlJavaTypeAdapter(DoubleSerialization.class)
    @XmlElement(name = "Quantity")
    private Double fiQuantity;

    @XmlElement(name = "SizeOrType")
    private String fiSizeOrType;
}
