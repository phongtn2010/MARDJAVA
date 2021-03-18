package com.nsw.backend.vroot.message25;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "SafetyCriteria")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class SafetyCriteria {

    @XmlElement(name = "SafetyCriteriaName")
    private String fiProATTarg;
    @XmlElement(name = "SafetyFormOfPublication")
    private String fiProATCompare;
    @XmlElement(name = "SafetyRequire")
    private String fiProATContent;
    @XmlElement(name = "SafetyRequireUnitID")
    private String fiProATUnitID;
    @XmlElement(name = "SafetyRequireUnitName")
    private String fiProATUnitName;
}
