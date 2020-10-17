package com.vnsw.ws.p16.message;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Others")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiScale", "fiLocation"})
public class Others {

    @XmlElement(name = "Scale", required = true)
    private String fiScale;

    @XmlElement(name = "Location", required = true)
    private String fiLocation;

    public String getFiScale() {
        return fiScale;
    }

    public void setFiScale(String fiScale) {
        this.fiScale = fiScale;
    }

    public String getFiLocation() {
        return fiLocation;
    }

    public void setFiLocation(String fiLocation) {
        this.fiLocation = fiLocation;
    }
}
