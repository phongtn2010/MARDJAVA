package com.nsw.backend.vroot.message25;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "QualityCriteria")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class QualityCriteria {

    @XmlElement(name = "QualityCriteriaName")
    private String fiProCLTarg;
    @XmlElement(name = "QualityFormOfPublication")
    private String fiProCLCompare;
    @XmlElement(name = "QualityRequire")
    private String fiProCLContent;
    @XmlElement(name = "QualityRequireUnitID")
    private String fiProCLUnitID;
    @XmlElement(name = "QualityRequireUnitName")
    private String fiProCLUnitName;

}
