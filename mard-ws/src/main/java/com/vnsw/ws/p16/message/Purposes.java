package com.vnsw.ws.p16.message;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Purposes")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiPurposes", "fiOtherPurposesValue"})
public class Purposes {

    @XmlElement(name = "Purposes")
    private Integer fiPurposes;

    @XmlElement(name = "OtherPurposesValue")
    private String fiOtherPurposesValue;

    public Integer getFiPurposes() {
        return fiPurposes;
    }

    public void setFiPurposes(Integer fiPurposes) {
        this.fiPurposes = fiPurposes;
    }

    public String getFiOtherPurposesValue() {
        return fiOtherPurposesValue;
    }

    public void setFiOtherPurposesValue(String fiOtherPurposesValue) {
        this.fiOtherPurposesValue = fiOtherPurposesValue;
    }
}
