package com.vnsw.ws.p1.entity.receive;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AnimalProductChina")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class AnimailProductChina {

    @XmlElement(name = "ID")
    private String fiID;

    @XmlElement(name = "HSCode")
    private String fiHSCode;

    @XmlElement(name = "TypeProduct")
    private String fiTypeProduct;

    @XmlElement(name = "BactchNumber")
    private String fiBactchNumber;

    @XmlElement(name = "PackageType")
    private String fiPackageType;

    @XmlElement(name = "NumberPackage")
    private String fiNumberPackage;

    @XmlElement(name = "UnitCode")
    private String fiUnitCode;

    @XmlElement(name = "Unit")
    private String fiUnit;

    @XmlElement(name = "NetWeight")
    private String fiNetWeight;

    @XmlElement(name = "NetWeightUnitName")
    private String fiNetWeightUnitName;

    @XmlElement(name = "MarkNo")
    private String fiMarkNo;
}
