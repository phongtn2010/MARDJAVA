package com.vnsw.ws.p8.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Goods")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Goods {
    @XmlElement(name = "CodeOfGoods")
    private String fiCodeOfGoods;

    @XmlElement(name = "NameOfGoods")
    private String fiNameOfGoods;

    @XmlElement(name = "NameSicenceOfGoods")
    private String fiNameSicenceOfGoods;

    @XmlElement(name = "Quantity")
    private long fiQuantity;

    @XmlElement(name = "QuantityUnitCode")
    private String fiQuantityUnitCode;

    @XmlElement(name = "QuantityUnitName")
    private String fiQuantityUnitName;

    @XmlElement(name = "NetWeight")
    private Float fiNetWeight;

    @XmlElement(name = "WayOfPackinglist")
    private String fiWayOfPackinglist;

    @XmlElement(name = "NetWeightUnitCode")
    private String fiNetWeightUnitCode;

    @XmlElement(name = "NetWeightUnitName")
    private String fiNetWeightUnitName;

    @XmlElement(name = "GrossWeight")
    private float fiGrossWeight;

    @XmlElement(name = "GrossWeightUnitCode")
    private String fiGrossWeightUnitCode;

    @XmlElement(name = "GrossWeightUnitName")
    private String fiGrossWeightUnitName;

    @XmlElement(name = "OriginationCode")
    private String fiOriginationCode;

    @XmlElement(name = "OriginationName")
    private String fiOriginationName;

    @XmlElement(name = "CirculateNo")
    private String fiCirculateNo;

}
