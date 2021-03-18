package com.nsw.backend.vroot.message25;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "QuantityVolume")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class QuantityVolume {

    @XmlElement(name = "Quantity")
    private String fiProSLKLAmount;
    @XmlElement(name = "QuantityUnitCode")
    private String fiProSLKLAmountUnitCode;
    @XmlElement(name = "QuantityUnitName")
    private String fiProSLKLAmountUnitName;
    @XmlElement(name = "Volume")
    private String fiProSLKLMass;
    @XmlElement(name = "VolumeUnitCode")
    private String fiProSLKLMassUnitCode;
    @XmlElement(name = "VolumeUnitName")
    private String fiProSLKLMassUnitName;
    @XmlElement(name = "VolumeTAN")
    private String fiProSLKLMassTan;
}
