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
@XmlType(name = "ResponseEditCer")
public class TbdRequestEditCer04  {
    @XmlTransient
    private Long requestEditCerId;
    @XmlElement(name = "NSWFileCode")
    private String nswFilecode;
    @XmlTransient
    private Date requestDate;
    @XmlTransient
    private String reasonRequest;
    @XmlTransient
    private Long isActive;
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

    public TbdRequestEditCer04() {
    }

    public TbdRequestEditCer04(Long requestEditCerId) {
        this.requestEditCerId = requestEditCerId;
    }

    public Long getRequestEditCerId() {
        return requestEditCerId;
    }

    public void setRequestEditCerId(Long requestEditCerId) {
        this.requestEditCerId = requestEditCerId;
    }

    public String getNswFilecode() {
        return nswFilecode;
    }

    public void setNswFilecode(String nswFilecode) {
        this.nswFilecode = nswFilecode;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getReasonRequest() {
        return reasonRequest;
    }

    public void setReasonRequest(String reasonRequest) {
        this.reasonRequest = reasonRequest;
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

    public String getReasonResponse() {
        return reasonResponse;
    }

    public void setReasonResponse(String reasonResponse) {
        this.reasonResponse = reasonResponse;
    }

    public Date getSignConfirmDate() {
        return signConfirmDate;
    }

    public void setSignConfirmDate(Date signConfirmDate) {
        this.signConfirmDate = signConfirmDate;
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

    
    
}
