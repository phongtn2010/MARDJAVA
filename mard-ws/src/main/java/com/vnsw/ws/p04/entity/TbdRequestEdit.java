/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.entity;

import com.vnsw.ws.annotations.DateSerialization;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Fujitsu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseEdit")
public class TbdRequestEdit {

    @XmlTransient
    private Long fiIdRequest;
    @XmlTransient
    private Date requestDate;
    @XmlTransient
    private String reason;
    @XmlElement(name = "NSWFileCode")
    private String nswFilecode;
    @XmlTransient
    private Long registrationProfileId;
    @XmlTransient
    private Long isActive;
    @XmlTransient
    private String createBy;
    @XmlTransient
    private Date createDate;
    @XmlElement(name = "Reason")
    private String reasonResponse;
    @XmlElement(name = "SignConfirmDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date signConfirmDate;
    @XmlElement(name = "Department")
    private String department;
    @XmlElement(name = "CreaterName")
    private String createrName;
    @XmlTransient
    private Long codeStatus;
    @XmlTransient
    private String nameStatus;

    public TbdRequestEdit() {
    }

    public TbdRequestEdit(Long fiIdRequest) {
        this.fiIdRequest = fiIdRequest;
    }

    public Long getFiIdRequest() {
        return fiIdRequest;
    }

    public void setFiIdRequest(Long fiIdRequest) {
        this.fiIdRequest = fiIdRequest;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getNswFilecode() {
        return nswFilecode;
    }

    public void setNswFilecode(String nswFilecode) {
        this.nswFilecode = nswFilecode;
    }

    public Long getRegistrationProfileId() {
        return registrationProfileId;
    }

    public void setRegistrationProfileId(Long registrationProfileId) {
        this.registrationProfileId = registrationProfileId;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getReasonResponse() {
        return reasonResponse;
    }

    public void setReasonResponse(String reasonResponse) {
        this.reasonResponse = reasonResponse;
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

    public Date getSignConfirmDate() {
        return signConfirmDate;
    }

    public void setSignConfirmDate(Date signConfirmDate) {
        this.signConfirmDate = signConfirmDate;
    }

    public Long getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(Long codeStatus) {
        this.codeStatus = codeStatus;
    }

    public String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

    
}
