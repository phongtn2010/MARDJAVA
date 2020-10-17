package com.vnsw.ws.p9.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "GoodsXNCL")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class GoodsXNCL {
    @XmlElement(name = "CodeOfGoods")
    private String fiCodeOfGoods;

    @XmlElement(name = "NameOfGoods")
    private String fiNameOfGoods;

    @XmlElement(name = "QuantityOrVolumn")
    private String fiQuantityOrVolumn;

    @XmlElement(name = "QuantityOrVolumnUnitCode")
    private String fiQuantityOrVolumnUnitCode;

    @XmlElement(name = "QuantityOrVolumnUnitName")
    private String fiQuantityOrVolumnUnitName;

    @XmlElement(name = "CriteriaAnalysisNo")
    private String fiCriteriaAnalysisNo;

    @XmlElement(name = "DescriptionOfGoods")
    private String fiDescriptionOfGoods;

    @XmlElement(name = "Result")
    private int fiResult;

    @XmlElement(name = "Reason")
    private String fiReason;
}
