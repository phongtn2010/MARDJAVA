package com.vnsw.ws.p15.message;

import com.vnsw.ws.annotations.DateSerialization;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement(name = "GeneticResponseEditLicense")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiReason", "fiSignConfirmDate", "fiDepartment", "fiCreaterName"})
public class BNNTuChoiYeuCauSuaGP {

    public BNNTuChoiYeuCauSuaGP() {
    }

    @XmlElement(name = "Reason")
    private String fiReason;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate", required = true)
    private Date fiSignConfirmDate;

    @XmlElement(name = "Department")
    private String fiDepartment;

    @XmlElement(name = "CreaterName")
    private String fiCreaterName;

    public String getFiReason() {
        return this.fiReason;
    }

    public void setFiReason(String fiReason) {
        this.fiReason = fiReason;
    }

    public Date getFiSignConfirmDate() {
        return this.fiSignConfirmDate;
    }

    public void setFiSignConfirmDate(Date fiSignConfirmDate) {
        this.fiSignConfirmDate = fiSignConfirmDate;
    }

    public String getFiDepartment() {
        return this.fiDepartment;
    }

    public void setFiDepartment(String fiDepartment) {
        this.fiDepartment = fiDepartment;
    }

    public String getFiCreaterName() {
        return this.fiCreaterName;
    }

    public void setFiCreaterName(String fiCreaterName) {
        this.fiCreaterName = fiCreaterName;
    }


}
