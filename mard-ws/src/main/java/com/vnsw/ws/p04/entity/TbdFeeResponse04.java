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
@XmlType(name = "FeeResponse")
public class TbdFeeResponse04  {
    @XmlTransient
    private Long feeResponseId;
    @XmlElement(name = "NSWFileCode")
    private String nswFilecode;
    @XmlElement(name = "FeeResult")
    private Long feeResult;
    @XmlElement(name = "Note")
    private String note;
    @XmlElement(name = "Department")
    private String department;
    @XmlElement(name = "CreaterName")
    private String createrName;
    @XmlTransient
    private Long isActive;
    @XmlTransient
    private Date createDate;

    public TbdFeeResponse04() {
    }

    public TbdFeeResponse04(Long feeResponseId) {
        this.feeResponseId = feeResponseId;
    }

    public Long getFeeResponseId() {
        return feeResponseId;
    }

    public void setFeeResponseId(Long feeResponseId) {
        this.feeResponseId = feeResponseId;
    }

    public String getNswFilecode() {
        return nswFilecode;
    }

    public void setNswFilecode(String nswFilecode) {
        this.nswFilecode = nswFilecode;
    }

    public Long getFeeResult() {
        return feeResult;
    }

    public void setFeeResult(Long feeResult) {
        this.feeResult = feeResult;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (feeResponseId != null ? feeResponseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdFeeResponse04)) {
            return false;
        }
        TbdFeeResponse04 other = (TbdFeeResponse04) object;
        if ((this.feeResponseId == null && other.feeResponseId != null) || (this.feeResponseId != null && !this.feeResponseId.equals(other.feeResponseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.mard.p04.model.TbdFeeResponse04[ feeResponseId=" + feeResponseId + " ]";
    }
    
}
