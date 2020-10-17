package com.vnsw.ws.p9.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "ImmunesList")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImmunesList {
    @XmlElement(name = "Immunes")
    private List<Immunes> immunes;

    public ImmunesList() {
    }

    public ImmunesList(List<Immunes> immunes) {
        this.immunes = immunes;
    }

    public List<Immunes> getImmunes() {
        return immunes;
    }

    public void setImmunes(List<Immunes> immunes) {
        this.immunes = immunes;
    }
}
