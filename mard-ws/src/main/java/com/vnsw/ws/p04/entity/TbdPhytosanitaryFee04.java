/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.entity;

import java.math.BigDecimal;
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
@XmlType(name = "PhytosanitaryFee")
public class TbdPhytosanitaryFee04 {
    @XmlTransient
    private Long phytosanitaryFeeId;
    @XmlElement(name = "NSWFileCode")
    private String nswFilecode;
    @XmlElement(name = "TotalFee")
    private BigDecimal totalFee;
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

    public TbdPhytosanitaryFee04() {
    }

    public TbdPhytosanitaryFee04(Long phytosanitaryFeeId) {
        this.phytosanitaryFeeId = phytosanitaryFeeId;
    }

    public Long getPhytosanitaryFeeId() {
        return phytosanitaryFeeId;
    }

    public void setPhytosanitaryFeeId(Long phytosanitaryFeeId) {
        this.phytosanitaryFeeId = phytosanitaryFeeId;
    }

    public String getNswFilecode() {
        return nswFilecode;
    }

    public void setNswFilecode(String nswFilecode) {
        this.nswFilecode = nswFilecode;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
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
        hash += (phytosanitaryFeeId != null ? phytosanitaryFeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdPhytosanitaryFee04)) {
            return false;
        }
        TbdPhytosanitaryFee04 other = (TbdPhytosanitaryFee04) object;
        if ((this.phytosanitaryFeeId == null && other.phytosanitaryFeeId != null) || (this.phytosanitaryFeeId != null && !this.phytosanitaryFeeId.equals(other.phytosanitaryFeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.mard.p04.model.TbdPhytosanitaryFee04[ phytosanitaryFeeId=" + phytosanitaryFeeId + " ]";
    }
    
}
