package com.vnsw.ws.p9.entity;

import com.vnsw.ws.annotations.DoubleSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(name = "GoodsHoso09")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class GoodsHoso09 {
    @XmlElement(name = "CodeOfGoods")
    private String fiCodeOfGoods;

    @XmlElement(name = "NameOfGoods")
    private String fiNameOfGoods;

    @XmlElement(name = "NameSicenceOfGoods")
    private String fiNameSicenceOfGoods;

    @XmlElement(name = "AnimalQuantityFemale")
    private long fiAnimalQuantityFemale;

    @XmlElement(name = "AnimalQuantityMale")
    private long fiAnimalQuantityMale;

    @XmlElement(name = "IncludeMale")
    private Integer fiIncludeMale;

    @XmlElement(name = "IncludeFemale")
    private Integer fiIncludeFemale;

    @XmlElement(name = "Age")
    private int fiAge;

    @XmlElement(name = "Gender", nillable = true)
    private Integer fiGender = 0;

    @XmlElement(name = "PackageType")
    private String fiWayOfPackinglist;

    @XmlElement(name = "QuantityOrVolumn")
    private Long fiQuantityOrVolumn;

    @XmlElement(name = "QuantityUnitCode")
    private String fiQuantityUnitCode;

    @XmlElement(name = "QuantityUnitName")
    private String fiQuantityUnitName;

    @XmlJavaTypeAdapter(DoubleSerialization.class)
    @XmlElement(name = "NetWeight")
    private Double fiNetWeight;

    @XmlElement(name = "NetWeightUnitCode")
    private String fiNetWeightUnitCode;

    @XmlElement(name = "NetWeightUnitName")
    private String fiNetWeightUnitName;

    @XmlJavaTypeAdapter(DoubleSerialization.class)
    @XmlElement(name = "GrossWeight")
    private Double fiGrossWeight;

    @XmlElement(name = "GrossWeightUnitName")
    private String fiGrossWeightUnitName;

    @XmlElement(name = "PurposeUse")
    private String fiPurposeUse;

    @XmlElement(name = "TotalQuantityOrVolumn")
    private String fiTotalQuantityOrVolumn;

    @XmlElement(name = "RegistrationNo")
    private String fiRegistrationNo;

    @XmlElement(name = "OriginationCode")
    private String fiOriginationCode;

    @XmlElement(name = "OriginationName")
    private String fiOriginationName;

    @XmlElement(name = "ImportPortOfDestinationCode")
    private String fiImportPortOfDestinationCode;

    @XmlElement(name = "ImportPortOfDestinationName")
    private String fiImportPortOfDestinationName;

}
