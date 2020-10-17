package com.vnsw.ws.p8.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BoneMeal")
@Data
public class BoneMeal {
    @XmlElement(name = "BoneMealSort")
    private Long fiBoneMealSort;

    @XmlElement(name = "BoneMealCode")
    private String fiBoneMealCode;

    @XmlElement(name = "BoneMealName")
    private String fiBoneMealName;

    @XmlElement(name = "BoneMealQuantity")
    private String fiBoneMealQuantity;

    @XmlElement(name = "BoneMealQuantityUnitCode")
    private String fiBoneMealQuantityUnitCode;

    @XmlElement(name = "BoneMealQuantityUnitName")
    private String fiBoneMealQuantityUnitName;

    @XmlElement(name = "BoneMealExporterStateName")
    private String fiBoneMealExporterStateName;

    @XmlElement(name = "BoneMealExporterStateCode")
    private String fiBoneMealExporterStateCode;

    @XmlElement(name = "BoneMealPortOfDestinationName")
    private String fiBoneMealPortOfDestinationName;

    @XmlElement(name = "BoneMealPortOfDestinationCode")
    private String fiBoneMealPortOfDestinationCode;
}
