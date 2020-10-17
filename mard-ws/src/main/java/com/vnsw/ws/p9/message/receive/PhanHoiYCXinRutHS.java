package com.vnsw.ws.p9.message.receive;

import com.vnsw.ws.annotations.DateSerialization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "ResponseCancel")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhanHoiYCXinRutHS {


    @XmlElement(name = "Reason")
    private String fiReason;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    private Date fiSignConfirmDate;

    @XmlElement(name = "Department")
    private String fiDepartment;

    @XmlElement(name = "CreaterName")
    private String fiCreaterName;

    public PhanHoiYCXinRutHS(String fiReason, Date fiSignConfirmDate, String fiDepartment, String fiCreaterName) {
        this.fiReason = fiReason;
        this.fiSignConfirmDate = fiSignConfirmDate;
        this.fiDepartment = fiDepartment;
        this.fiCreaterName = fiCreaterName;
    }

    public PhanHoiYCXinRutHS() {
    }


    public String getFiReason() {
        return fiReason;
    }

    public void setFiReason(String fiReason) {
        this.fiReason = fiReason;
    }

    public Date getFiSignConfirmDate() {
        return fiSignConfirmDate;
    }

    public void setFiSignConfirmDate(Date fiSignConfirmDate) {
        this.fiSignConfirmDate = fiSignConfirmDate;
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
