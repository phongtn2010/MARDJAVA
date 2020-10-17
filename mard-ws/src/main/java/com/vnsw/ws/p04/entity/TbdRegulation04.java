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
@XmlType(name = "Regulation")
public class TbdRegulation04  {
    @XmlTransient
    private Long regulationId;
    @XmlElement(name = "AllowPlanting")
    private Long allowPlanting;
    @XmlElement(name = "AllowTransit")
    private Long allowTransit;
    @XmlElement(name = "Notify")
    private Long notify;
    @XmlElement(name = "OtherRule")
    private Long otherRule;
    @XmlElement(name = "OtherRegulation")
    private String otherRegulation;
    @XmlTransient
    private Long phytosanitaryResultId;
    @XmlTransient
    private Long isActive;
    @XmlTransient
    private Date craeteDate;

    public TbdRegulation04() {
    }

    public TbdRegulation04(Long regulationId) {
        this.regulationId = regulationId;
    }

    public Long getRegulationId() {
        return regulationId;
    }

    public void setRegulationId(Long regulationId) {
        this.regulationId = regulationId;
    }

    public Long getAllowPlanting() {
        return allowPlanting;
    }

    public void setAllowPlanting(Long allowPlanting) {
        this.allowPlanting = allowPlanting;
    }

    public Long getAllowTransit() {
        return allowTransit;
    }

    public void setAllowTransit(Long allowTransit) {
        this.allowTransit = allowTransit;
    }

    public Long getNotify() {
        return notify;
    }

    public void setNotify(Long notify) {
        this.notify = notify;
    }

    public Long getOtherRule() {
        return otherRule;
    }

    public void setOtherRule(Long otherRule) {
        this.otherRule = otherRule;
    }

    public String getOtherRegulation() {
        return otherRegulation;
    }

    public void setOtherRegulation(String otherRegulation) {
        this.otherRegulation = otherRegulation;
    }

    public Long getPhytosanitaryResultId() {
        return phytosanitaryResultId;
    }

    public void setPhytosanitaryResultId(Long phytosanitaryResultId) {
        this.phytosanitaryResultId = phytosanitaryResultId;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public Date getCraeteDate() {
        return craeteDate;
    }

    public void setCraeteDate(Date craeteDate) {
        this.craeteDate = craeteDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regulationId != null ? regulationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdRegulation04)) {
            return false;
        }
        TbdRegulation04 other = (TbdRegulation04) object;
        if ((this.regulationId == null && other.regulationId != null) || (this.regulationId != null && !this.regulationId.equals(other.regulationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.mard.p04.model.TbdRegulation04[ regulationId=" + regulationId + " ]";
    }
    
}
