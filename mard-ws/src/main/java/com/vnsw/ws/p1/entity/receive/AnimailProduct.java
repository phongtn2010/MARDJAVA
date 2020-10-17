package com.vnsw.ws.p1.entity.receive;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AnimalProductReceive")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class AnimailProduct {

    @XmlElement(name = "ID")
    private String fiID;

    @XmlElement(name = "ProductNameVni")
    private String fiProductNameVni;

    @XmlElement(name = "ProductName")
    private String fiProductName;

    @XmlElement(name = "PackageTypeVni")
    private String fiPackageTypeVni;

    @XmlElement(name = "PackageType")
    private String fiPackageType;

    @XmlElement(name = "Number")
    private long fiNumber;

    @XmlElement(name = "UnitCode")
    private String fiUnitCode;

    @XmlElement(name = "UnitVni")
    private String fiUnitVni;

    @XmlElement(name = "Unit")
    private String fiUnit;

    @XmlElement(name = "NetWeight")
    private float fiNetWeight;

    @XmlElement(name = "NetWeightUnitName")
    private String fiNetWeightUnitName;

    @XmlElement(name = "MarkNo")
    private String fiMarkNo;
}
