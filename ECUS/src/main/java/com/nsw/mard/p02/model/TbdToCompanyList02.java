/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p02.model;

import java.io.Serializable;

/**
 *
 * @author Fujitsu
 */
public class TbdToCompanyList02 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long toCompanyId;
    private String toCompanyName;
    private String toCompanyAddress;
    private Long regisGood17Id;
    private Long regisGood18Id;

    public TbdToCompanyList02() {
    }

    public TbdToCompanyList02(Long toCompanyId) {
        this.toCompanyId = toCompanyId;
    }

    public Long getToCompanyId() {
        return toCompanyId;
    }

    public void setToCompanyId(Long toCompanyId) {
        this.toCompanyId = toCompanyId;
    }

    public String getToCompanyName() {
        return toCompanyName;
    }

    public void setToCompanyName(String toCompanyName) {
        this.toCompanyName = toCompanyName;
    }

    public String getToCompanyAddress() {
        return toCompanyAddress;
    }

    public void setToCompanyAddress(String toCompanyAddress) {
        this.toCompanyAddress = toCompanyAddress;
    }

    public Long getRegisGood17Id() {
        return regisGood17Id;
    }

    public void setRegisGood17Id(Long regisGood17Id) {
        this.regisGood17Id = regisGood17Id;
    }

    public Long getRegisGood18Id() {
        return regisGood18Id;
    }

    public void setRegisGood18Id(Long regisGood18Id) {
        this.regisGood18Id = regisGood18Id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (toCompanyId != null ? toCompanyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdToCompanyList02)) {
            return false;
        }
        TbdToCompanyList02 other = (TbdToCompanyList02) object;
        if ((this.toCompanyId == null && other.toCompanyId != null) || (this.toCompanyId != null && !this.toCompanyId.equals(other.toCompanyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.mard.p02.model.TbdToCompanyList02[ toCompanyId=" + toCompanyId + " ]";
    }
    
}
