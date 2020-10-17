package com.vnsw.ws.p8.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "GoodsKDNK")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class GoodsKDNK {
    @XmlElement(name = "GoodsSort")
    private long fiGoodsSort;

    @XmlElement(name = "CodeOfGoods")
    private String fiCodeOfGoods;

    @XmlElement(name = "NameOfGoods")
    private String fiNameOfGoods;

    @XmlElement(name = "NameSicenceOfGoods")
    private String fiNameSicenceOfGoods;

    @XmlElement(name = "AnimalQuantityFemale")
    private Long fiAnimalQuantityFemale;

    @XmlElement(name = "AnimalQuantityMale")
    private Long fiAnimalQuantityMale;

    @XmlElement(name = "Age")
    private Long fiAge;

    @XmlElement(name = "WayOfPackinglist")
    private String fiWayOfPackinglist;

    @XmlElement(name = "QuantityOrVolumn")
    private Float fiQuantityOrVolumn;

    @XmlElement(name = "QuantityUnitCode")
    private String fiQuantityUnitCode;

    @XmlElement(name = "QuantityUnitName")
    private String fiQuantityUnitName;

    @XmlElement(name = "NetWeight")
    private Float fiNetWeight;

    @XmlElement(name = "NetWeightUnitCode")
    private String fiNetWeightUnitCode;

    @XmlElement(name = "NetWeightUnitName")
    private String fiNetWeightUnitName;

    @XmlElement(name = "GrossWeight")
    private Float fiGrossWeight;

    @XmlElement(name = "GrossWeightUnitCode")
    private String fiGrossWeightUnitCode;

    @XmlElement(name = "GrossWeightUnitName")
    private String fiGrossWeightUnitName;

    @XmlElement(name = "OriginationCode")
    private String fiOriginationCode;

    @XmlElement(name = "OriginationName")
    private String fiOriginationName;

    @XmlElement(name = "PurposeUse")
    private String fiPurposeUse;

    @XmlElement(name = "ImportPortOfDestinationCode")
    private String fiImportPortOfDestinationCode;

    @XmlElement(name = "ImportPortOfDestinationName")
    private String fiImportPortOfDestinationName;
}
