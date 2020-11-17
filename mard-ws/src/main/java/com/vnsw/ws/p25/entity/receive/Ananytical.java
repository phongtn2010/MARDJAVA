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
    String fiTenChiTieu;
    @XmlElement(name = "FormOfPublication")
    Integer fiHinhThucCB;
    @XmlElement(name = "Required")
    String fiHamLuong;
    @XmlElement(name = "RequireUnitID")
    String fiMaDVT;
    @XmlElement(name = "RequireUnitName")
    String fiTenDVT;
    @XmlElement(name = "Note")
    String fiGhiChu;
}
