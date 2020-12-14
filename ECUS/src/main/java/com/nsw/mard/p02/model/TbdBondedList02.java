/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p02.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Fujitsu
 */
public class TbdBondedList02 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long bondedListId;
    private String bondedName;
    private String certificateNo;
    private Date certificateDate;
    private Date certificateDateValid;
    private String contractNo;
    private Date contractDate;
    private Date contractDateValid;
    private Long regisGood18Id;
    private Long isActive;

    public TbdBondedList02() {
    }

    public TbdBondedList02(Long bondedListId) {
        this.bondedListId = bondedListId;
    }

    public Long getBondedListId() {
        return bondedListId;
    }

    public void setBondedListId(Long bondedListId) {
        this.bondedListId = bondedListId;
    }

    public String getBondedName() {
        return bondedName;
    }

    public void setBondedName(String bondedName) {
        this.bondedName = bondedName;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public Date getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(Date certificateDate) {
        this.certificateDate = certificateDate;
    }

    public Date getCertificateDateValid() {
        return certificateDateValid;
    }

    public void setCertificateDateValid(Date certificateDateValid) {
        this.certificateDateValid = certificateDateValid;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public Date getContractDateValid() {
        return contractDateValid;
    }

    public void setContractDateValid(Date contractDateValid) {
        this.contractDateValid = contractDateValid;
    }

    public Long getRegisGood18Id() {
        return regisGood18Id;
    }

    public void setRegisGood18Id(Long regisGood18Id) {
        this.regisGood18Id = regisGood18Id;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }
}
