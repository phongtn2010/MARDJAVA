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
public class TbdFromCompanyList02 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Long fromCompanyId;
    private String fromCompanyName;
    private String fromCompanyAddress;
    private Long regisGood17Id;
    private Long regisGood18Id;

    public TbdFromCompanyList02() {
    }

    public TbdFromCompanyList02(Long fromCompanyId) {
        this.fromCompanyId = fromCompanyId;
    }

    public Long getFromCompanyId() {
        return fromCompanyId;
    }

    public void setFromCompanyId(Long fromCompanyId) {
        this.fromCompanyId = fromCompanyId;
    }

    public String getFromCompanyName() {
        return fromCompanyName;
    }

    public void setFromCompanyName(String fromCompanyName) {
        this.fromCompanyName = fromCompanyName;
    }

    public String getFromCompanyAddress() {
        return fromCompanyAddress;
    }

    public void setFromCompanyAddress(String fromCompanyAddress) {
        this.fromCompanyAddress = fromCompanyAddress;
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
        hash += (fromCompanyId != null ? fromCompanyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdFromCompanyList02)) {
            return false;
        }
        TbdFromCompanyList02 other = (TbdFromCompanyList02) object;
        if ((this.fromCompanyId == null && other.fromCompanyId != null) || (this.fromCompanyId != null && !this.fromCompanyId.equals(other.fromCompanyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.mard.p02.model.TbdFromCompanyList02[ fromCompanyId=" + fromCompanyId + " ]";
    }
    
}
