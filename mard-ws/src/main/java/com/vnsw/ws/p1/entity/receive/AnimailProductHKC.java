package com.vnsw.ws.p1.entity.receive;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AnimalProductHKC")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class AnimailProductHKC {

    @XmlElement(name = "ID")
    private String fiID;

    @XmlElement(name = "TypeProduct")
    private String fiTypeProduct;

    @XmlElement(name = "PackageType")
    private String fiPackageType;

    @XmlElement(name = "NumberPackage")
    private long fiNumberPackage;

    @XmlElement(name = "UnitCode")
    private String fiUnitCode;

    @XmlElement(name = "Unit")
    private String fiUnit;

    @XmlElement(name = "NetWeight")
    private float fiNetWeight;

    @XmlElement(name = "NetWeightUnitName")
    private String fiNetWeightUnitName;

    @XmlElement(name = "MarkNo")
    private String fiMarkNo;
}
