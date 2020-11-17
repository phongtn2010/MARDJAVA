package com.vnsw.ws.p25.entity.receive;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "QuantityVolume")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class QuantityVolume {
    @XmlElement(name = "Volume")
    private String fiProSLKLMass;
    @XmlElement(name = "VolumeUnitID")
    private String fiProSLKLMassUnitCode;
    @XmlElement(name = "VolumeUnit")
    private String fiProSLKLMassUnitName;
    @XmlElement(name = "Quantity")
    private String fiProSLKLAmount;
    @XmlElement(name = "QuantityUnitID")
    private String fiProSLKLAmountUnitCode;
    @XmlElement(name = "QuantityUnitName")
    private String fiProSLKLAmountUnitName;
}
