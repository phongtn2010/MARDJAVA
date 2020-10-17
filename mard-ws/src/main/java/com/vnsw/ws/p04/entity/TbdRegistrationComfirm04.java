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
@XmlType(name = "RegistrationComfirm")
public class TbdRegistrationComfirm04 {

    @XmlTransient
    private Long registrationComfirmId;
    @XmlElement(name = "NSWFileCode")
    private String nswfileCode;
    @XmlElement(name = "RegistrationComfirmNo")
    private String registrationComfirmNo;
    @XmlElement(name = "DepartmentCode")
    private String departmentCode;
    @XmlElement(name = "DepartmentName")
    private String departmentName;
    @XmlElement(name = "AssignCode")
    private String assignCode;
    @XmlElement(name = "AssignName")
    private String assignName;
    @XmlElement(name = "QuarantineLocation")
    private String quarantineLocation;
    @XmlElement(name = "QuarantineDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date quarantineDate;
    @XmlElement(name = "RegistrationType")
    private Long registrationType;
    @XmlElement(name = "FoodsType")
    private Long foodsType;
    @XmlElement(name = "InpectionType")
    private Long inpectionType;
    @XmlElement(name = "NoticeOfExemptionFromInspectionNo")
    private String noticeOfExemption;
    @XmlElement(name = "NoticeDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date noticeDate;
    @XmlTransient
    private Long isActive;
    @XmlTransient
    private String createBy;
    @XmlTransient
    private Date createDate;
    @XmlTransient
    private Long registrationProfileId;
    @XmlElement(name = "SignConfirmDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date signConfirmDate;
    @XmlElement(name = "SignConfirmName")
    private String signConfirmName;
    @XmlElement(name = "SignConfirmAddress")
    private String signConfirmAddress;

    public TbdRegistrationComfirm04() {
    }

    public TbdRegistrationComfirm04(Long registrationComfirmId) {
        this.registrationComfirmId = registrationComfirmId;
    }

    public Long getRegistrationComfirmId() {
        return registrationComfirmId;
    }

    public void setRegistrationComfirmId(Long registrationComfirmId) {
        this.registrationComfirmId = registrationComfirmId;
    }

    public String getNswfileCode() {
        return nswfileCode;
    }

    public void setNswfileCode(String nswfileCode) {
        this.nswfileCode = nswfileCode;
    }

    public String getRegistrationComfirmNo() {
        return registrationComfirmNo;
    }

    public void setRegistrationComfirmNo(String registrationComfirmNo) {
        this.registrationComfirmNo = registrationComfirmNo;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getAssignCode() {
        return assignCode;
    }

    public void setAssignCode(String assignCode) {
        this.assignCode = assignCode;
    }

    public String getAssignName() {
        return assignName;
    }

    public void setAssignName(String assignName) {
        this.assignName = assignName;
    }

    public String getQuarantineLocation() {
        return quarantineLocation;
    }

    public void setQuarantineLocation(String quarantineLocation) {
        this.quarantineLocation = quarantineLocation;
    }

    public Date getQuarantineDate() {
        return quarantineDate;
    }

    public void setQuarantineDate(Date quarantineDate) {
        this.quarantineDate = quarantineDate;
    }

    public Long getFoodsType() {
        return foodsType;
    }

    public void setFoodsType(Long foodsType) {
        this.foodsType = foodsType;
    }

    public Long getInpectionType() {
        return inpectionType;
    }

    public void setInpectionType(Long inpectionType) {
        this.inpectionType = inpectionType;
    }

    public String getNoticeOfExemption() {
        return noticeOfExemption;
    }

    public void setNoticeOfExemption(String noticeOfExemption) {
        this.noticeOfExemption = noticeOfExemption;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
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

    public Date getSignConfirmDate() {
        return signConfirmDate;
    }

    public void setSignConfirmDate(Date signConfirmDate) {
        this.signConfirmDate = signConfirmDate;
    }

    public String getSignConfirmName() {
        return signConfirmName;
    }

    public void setSignConfirmName(String signConfirmName) {
        this.signConfirmName = signConfirmName;
    }

    public String getSignConfirmAddress() {
        return signConfirmAddress;
    }

    public void setSignConfirmAddress(String signConfirmAddress) {
        this.signConfirmAddress = signConfirmAddress;
    }

    public Long getRegistrationProfileId() {
        return registrationProfileId;
    }

    public void setRegistrationProfileId(Long registrationProfileId) {
        this.registrationProfileId = registrationProfileId;
    }

    public Long getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(Long registrationType) {
        this.registrationType = registrationType;
    }

    
}
