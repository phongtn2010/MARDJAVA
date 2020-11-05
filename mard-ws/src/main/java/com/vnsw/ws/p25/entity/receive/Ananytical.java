package com.vnsw.ws.p25.entity.receive;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Ananytical")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Ananytical {
    @XmlElement(name = "AnanyticalName")
    String fiAnanyticalName;
    @XmlElement(name = "FormOfPublication")
    Integer fiFormOfPublication;
    @XmlElement(name = "Required")
    String fiRequired;
    @XmlElement(name = "RequireUnitID")
    String fiRequireUnitID;
    @XmlElement(name = "RequireUnitName")
    String fiRequireUnitName;
    @XmlElement(name = "Note")
    String fiNote;
}
