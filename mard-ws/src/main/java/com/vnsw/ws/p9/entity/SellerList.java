package com.vnsw.ws.p9.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "SellerList")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class SellerList {
    @XmlElement(name = "Seller")
    private List<Seller> lstSeller;
}
