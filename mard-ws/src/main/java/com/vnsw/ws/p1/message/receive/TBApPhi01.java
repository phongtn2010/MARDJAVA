package com.vnsw.ws.p1.message.receive;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "PhytosanitaryFee")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class TBApPhi01 {

    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;

    @XmlElement(name = "TotalFee")
    private float fiTotalFee;

    @XmlElement(name = "TotalFeeText")
    private String fiTotalFeeText;

    @XmlElement(name = "Note")
    private String fiNote;

    @XmlElement(name = "CreaterName")
    private String fiCreaterName;
}
