/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.entity;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Fujitsu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TemporaryCertificate")
public class TbdTemporaryCertificate04 {
    @XmlTransient
    private Long temporaryCertificateId;
    @XmlElement(name = "Undiscovered")
    private Long undiscovered;
    @XmlElement(name = "UndiscoveredContent")
    private String undiscoveredContent;
    @XmlElement(name = "CheckOutside")
    private Long checkOutside;
    @XmlElement(name = "CheckOutsideContent")
    private String checkOutsideContent;
    @XmlElement(name = "NotifyDepartmentCode")
    private String notifyDepartmentCode;
    @XmlElement(name = "NotifyDepartmentName")
    private String notifyDepartmentName;
    @XmlTransient
    private Long temporaryPhytosanitaryId;
    @XmlTransient
    private Long isActive;
    @XmlTransient
    private Date creatDate;

    public TbdTemporaryCertificate04() {
    }

    public TbdTemporaryCertificate04(Long temporaryCertificateId) {
        this.temporaryCertificateId = temporaryCertificateId;
    }

    public Long getTemporaryCertificateId() {
        return temporaryCertificateId;
    }

    public void setTemporaryCertificateId(Long temporaryCertificateId) {
        this.temporaryCertificateId = temporaryCertificateId;
    }

    public Long getUndiscovered() {
        return undiscovered;
    }

    public void setUndiscovered(Long undiscovered) {
        this.undiscovered = undiscovered;
    }

    public String getUndiscoveredContent() {
        return undiscoveredContent;
    }

    public void setUndiscoveredContent(String undiscoveredContent) {
        this.undiscoveredContent = undiscoveredContent;
    }

    public Long getCheckOutside() {
        return checkOutside;
    }

    public void setCheckOutside(Long checkOutside) {
        this.checkOutside = checkOutside;
    }

    public String getCheckOutsideContent() {
        return checkOutsideContent;
    }

    public void setCheckOutsideContent(String checkOutsideContent) {
        this.checkOutsideContent = checkOutsideContent;
    }

    public String getNotifyDepartmentCode() {
        return notifyDepartmentCode;
    }

    public void setNotifyDepartmentCode(String notifyDepartmentCode) {
        this.notifyDepartmentCode = notifyDepartmentCode;
    }

    public String getNotifyDepartmentName() {
        return notifyDepartmentName;
    }

    public void setNotifyDepartmentName(String notifyDepartmentName) {
        this.notifyDepartmentName = notifyDepartmentName;
    }

    public Long getTemporaryPhytosanitaryId() {
        return temporaryPhytosanitaryId;
    }

    public void setTemporaryPhytosanitaryId(Long temporaryPhytosanitaryId) {
        this.temporaryPhytosanitaryId = temporaryPhytosanitaryId;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    
    
}
