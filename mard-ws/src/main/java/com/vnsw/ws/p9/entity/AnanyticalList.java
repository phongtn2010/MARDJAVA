package com.vnsw.ws.p9.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "AnanyticalRequiredList")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnanyticalList {
    @XmlElement(name = "Ananytical")
    private List<Ananytical> ananyticals;

    public AnanyticalList(List<Ananytical> ananyticals) {
        this.ananyticals = ananyticals;
    }

    public AnanyticalList() {
    }

    public List<Ananytical> getAnanyticals() {
        return ananyticals;
    }

    public void setAnanyticals(List<Ananytical> ananyticals) {
        this.ananyticals = ananyticals;
    }
}
