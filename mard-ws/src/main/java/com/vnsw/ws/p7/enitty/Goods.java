package com.vnsw.ws.p7.enitty;


import com.vnsw.ws.annotations.DoubleSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(name = "Goods")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Goods {
    @XmlElement(name = "NameOfGoods")
    String fiNameOfGoods;

    @XmlElement(name = "CodeOfGoods")
    String fiCodeOfGoods;

    @XmlElement(name = "NameSicenceOfGoods")
    String fiNameSicenceOfGoods;

    @XmlElement(name = "HSCodeOfGoods")
    String fiHSCodeOfGoods;

    @XmlElement(name = "Species")
    String fiSpecies;

    @XmlElement(name = "ValueOfGoods")
    String fiValueOfGoods;

    @XmlElement(name = "CategoryOfGoods")
    String fiCategoryOfGoods;

    @XmlElement(name = "Classification")
    String fiClassification;


    @XmlElement(name = "Preservation")
    String fiPreservation;

    @XmlElement(name = "SizeOrShape")
    String fiSizeOrShape;

    @XmlJavaTypeAdapter(DoubleSerialization.class)
    @XmlElement(name = "QuantityOrWeight")
    Double fiQuantityOrWeight;

    @XmlElement(name = "QuantityOrWeightUnitCode")
    String fiQuantityOrWeightUnitCode;

    @XmlElement(name = "QuantityOrWeightUnitName")
    String fiQuantityOrWeightUnitName;

    @XmlElement(name = "OriginationCode")
    String fiOriginationCode;

    @XmlElement(name = "OriginationName")
    String fiOriginationName;

}
