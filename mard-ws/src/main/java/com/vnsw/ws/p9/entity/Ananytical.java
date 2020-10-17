package com.vnsw.ws.p9.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ananytical")
public class Ananytical {
    @XmlElement(name = "AnanyticalCode")
    private String fiAnanyticalCode;

    @XmlElement(name = "AnanyticalName")
    private String fiAnanyticalName;

    @XmlElement(name = "Required")
    private String fiRequired;

    public Ananytical() {
    }

    public Ananytical(String fiAnanyticalCode, String fiAnanyticalName, String fiRequired) {
        this.fiAnanyticalCode = fiAnanyticalCode;
        this.fiAnanyticalName = fiAnanyticalName;
        this.fiRequired = fiRequired;
    }

    public String getFiAnanyticalCode() {
        return fiAnanyticalCode;
    }

    public void setFiAnanyticalCode(String fiAnanyticalCode) {
        this.fiAnanyticalCode = fiAnanyticalCode;
    }

    public String getFiAnanyticalName() {
        return fiAnanyticalName;
    }

    public void setFiAnanyticalName(String fiAnanyticalName) {
        this.fiAnanyticalName = fiAnanyticalName;
    }

    public String getFiRequired() {
        return fiRequired;
    }

    public void setFiRequired(String fiRequired) {
        this.fiRequired = fiRequired;
    }
}
