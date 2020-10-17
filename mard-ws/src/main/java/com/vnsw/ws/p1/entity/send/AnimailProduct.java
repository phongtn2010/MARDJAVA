package com.vnsw.ws.p1.entity.send;

import com.vnsw.ws.util.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "AnimailProductSend")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class AnimailProduct {

    @XmlElement(name = "Id")
    private Long fiIdAnimailProduct;

    @XmlElement(name = "AnimalProductID")
    private String fiAnimalProductID;

    @XmlElement(name = "HSCode")
    private String fiHSCode;

    @XmlElement(name = "ProductNameVni")
    private String fiProductNameVni;

    @XmlElement(name = "ProductName")
    private String fiProductName;

    @XmlElement(name = "PackageTypeVni")
    private String fiPackageTypeVni;

    @XmlElement(name = "PackageType")
    private String fiPackageType;

    @XmlElement(name = "Number")
    private Long fiNumber;

    @XmlElement(name = "UnitCode")
    private String fiUnitCode;

    @XmlElement(name = "UnitVni")
    private String fiUnitVni;

    @XmlElement(name = "Unit")
    private String fiUnit;

    @XmlElement(name = "NetWeight")
    private float fiNetWeight;

    @XmlElement(name = "NetWeightUnitCode")
    private String fiNetWeightUnitCode;

    @XmlElement(name = "NetWeightUnitVni")
    private String fiNetWeightUnitVni;

    @XmlElement(name = "NetWeightUnit")
    private String fiNetWeightUnit;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "FromDateProduct")
    private Date fiFromDateProduct;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ToDateProduct")
    private Date fiToDateProduct;

    @XmlElement(name = "LotIdentificationNo")
    private String fiLotIdentificationNo;

    @XmlElement(name = "PurposeVni")
    private String fiPurposeVni;

    @XmlElement(name = "Purpose")
    private String fiPurpose;

    @XmlElement(name = "Shipmentvalue")
    private Float fiShipmentvalue;

    @XmlElement(name = "MarkNo")
    private String fiMarkNo;
}
