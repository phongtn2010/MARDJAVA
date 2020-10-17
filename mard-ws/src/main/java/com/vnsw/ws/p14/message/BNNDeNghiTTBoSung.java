package com.vnsw.ws.p14.message;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "MedicinePPFeeResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiNote", "fiDepartment", "fiCreaterName"})
public class BNNDeNghiTTBoSung {

    @XmlElement(name = "Note")
    private String fiNote;

    @XmlElement(name = "Department")
    private String fiDepartment;

    @XmlElement(name = "CreaterName")
    private String fiCreaterName;

    public String getFiNote() {
        return fiNote;
    }

    public void setFiNote(String fiNote) {
        this.fiNote = fiNote;
    }

    public String getFiDepartment() {
        return fiDepartment;
    }

    public void setFiDepartment(String fiDepartment) {
        this.fiDepartment = fiDepartment;
    }

    public String getFiCreaterName() {
        return fiCreaterName;
    }

    public void setFiCreaterName(String fiCreaterName) {
        this.fiCreaterName = fiCreaterName;
    }
}
