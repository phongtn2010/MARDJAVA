/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p02.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Fujitsu
 */
public class TbdRegistration02 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long registrationId;
    private String nswFilecode;
    private String nameOfRegistration;
    private String addressOfRegistration;
    private String tel;
    private String fax;
    private String email;
    private String noOfRegistration;
    private Long typeProduct;
    private String nameTypeProduct;
    private Long templateType;
    private String nameTemplateType;
    private String companyName;
    private String signAddress;
    private Date signDate;
    private String signLocation;
    private String signName;
    private Long isActive;
    private Long codeStatus;
    private String nameStatus;
    private String createBy;
    private Date createDate;
    private String reason;
    private Date sendDate;
    private Date rangeDate;
    private TbdRegistrationGood1702 banKhai17;
    private TbdRegistrationGood1802 banKhai18;
    private List<TbdAttachmentList02> lstDinhKem02;

    public TbdRegistration02() {
    }

    public TbdRegistration02(Long registrationId) {
        this.registrationId = registrationId;
    }

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public String getNswFilecode() {
        return nswFilecode;
    }

    public void setNswFilecode(String nswFilecode) {
        this.nswFilecode = nswFilecode;
    }

    public String getNameOfRegistration() {
        return nameOfRegistration;
    }

    public void setNameOfRegistration(String nameOfRegistration) {
        this.nameOfRegistration = nameOfRegistration;
    }

    public String getAddressOfRegistration() {
        return addressOfRegistration;
    }

    public void setAddressOfRegistration(String addressOfRegistration) {
        this.addressOfRegistration = addressOfRegistration;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoOfRegistration() {
        return noOfRegistration;
    }

    public void setNoOfRegistration(String noOfRegistration) {
        this.noOfRegistration = noOfRegistration;
    }

    public Long getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(Long typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getNameTypeProduct() {
        return nameTypeProduct;
    }

    public void setNameTypeProduct(String nameTypeProduct) {
        this.nameTypeProduct = nameTypeProduct;
    }

    public Long getTemplateType() {
        return templateType;
    }

    public void setTemplateType(Long templateType) {
        this.templateType = templateType;
    }

    public String getNameTemplateType() {
        return nameTemplateType;
    }

    public void setNameTemplateType(String nameTemplateType) {
        this.nameTemplateType = nameTemplateType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSignAddress() {
        return signAddress;
    }

    public void setSignAddress(String signAddress) {
        this.signAddress = signAddress;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getSignLocation() {
        return signLocation;
    }

    public void setSignLocation(String signLocation) {
        this.signLocation = signLocation;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
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

    public TbdRegistrationGood1702 getBanKhai17() {
        return banKhai17;
    }

    public void setBanKhai17(TbdRegistrationGood1702 banKhai17) {
        this.banKhai17 = banKhai17;
    }

    public TbdRegistrationGood1802 getBanKhai18() {
        return banKhai18;
    }

    public void setBanKhai18(TbdRegistrationGood1802 banKhai18) {
        this.banKhai18 = banKhai18;
    }

    public List<TbdAttachmentList02> getLstDinhKem02() {
        return lstDinhKem02;
    }

    public void setLstDinhKem02(List<TbdAttachmentList02> lstDinhKem02) {
        this.lstDinhKem02 = lstDinhKem02;
    }
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getRangeDate() {
        return rangeDate;
    }

    public void setRangeDate(Date rangeDate) {
        this.rangeDate = rangeDate;
    }

}
