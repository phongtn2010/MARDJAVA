package com.vnsw.ws.p1.message.receive;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ResponseEditCer")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class TBKQYCSuaCNKD {

    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;

    @XmlElement(name = "Reason")
    private String fiReason;

    @XmlElement(name = "CreaterName")
    private String fiCreaterName;
}
