package com.vnsw.ws.p1.message.receive;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlType(name = "Result")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class KQTDhoso01 {
    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;

    @XmlElement(name = "Reason")
    private String fiReason;

    @XmlElement(name = "CreaterName")
    private String fiCreaterName;
}
