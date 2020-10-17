package com.vnsw.ws.p9.entity;


import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "LocationQuarantineList")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class LocationQuarantineList {

    @XmlElement(name = "LocationQuarantine")
    private List<LocationQuarantine> lstLocationQuarantine;
}
