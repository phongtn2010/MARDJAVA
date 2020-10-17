package com.vnsw.ws.p1.entity.receive;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AnimalProductM")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class AnimailProductM {

    @XmlElement(name = "ID")
    private String fiID;

    @XmlElement(name = "Commodity")
    private String fiCommodity;

    @XmlElement(name = "Quantity")
    private Long fiQuantity;

    @XmlElement(name = "UnitCode")
    private String fiUnitCode;

    @XmlElement(name = "Unit")
    private String fiUnit;

    @XmlElement(name = "MarkNo")
    private String fiMarkNo;

    @XmlElement(name = "NetWeight")
    private float fiNetWeight;

    @XmlElement(name = "NetWeightUnitName")
    private String fiNetWeightUnitName;

}
