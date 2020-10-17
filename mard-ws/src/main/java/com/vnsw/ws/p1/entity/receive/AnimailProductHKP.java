package com.vnsw.ws.p1.entity.receive;

import com.vnsw.ws.util.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "AnimalProductHKP")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class AnimailProductHKP {

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

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "FromDateProduct")
    private Date fiFromDateProduct;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ToDateProduct")
    private Date fiToDateProduct;

    @XmlElement(name = "LotIndetificationNo")
    private String fiLotIndetificationNo;
}
