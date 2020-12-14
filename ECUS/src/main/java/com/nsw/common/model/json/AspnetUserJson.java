/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.common.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author Phong84NV
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AspnetUserJson implements Serializable{
    private String applicationId;
    private String userId;
    private String userName;
    private String loweredUserName;
    private String mobileAlias;
    private String isAnonymous;
    private String lastActivityDate;
    private String password;
    private String passwordSalt;
    private List<Tab> tabs;
    private String companyName;
    private String companyAddress;
    private String companyEmail;
    private String companyFax;
    private String companyPhoneNumber;
    private String RepresenterName;
    private String RepresenterPhone;
    private String RepresenterMobile;
    private String RepresenterEmail;
    private String companyType;
    private String registrationNo;
    private String departmentManage;
    private String engName;
    private String shortName;
    private String constitutionYear;
    
    public AspnetUserJson() {
        super();
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoweredUserName() {
        return loweredUserName;
    }

    public void setLoweredUserName(String loweredUserName) {
        this.loweredUserName = loweredUserName;
    }

    public String getMobileAlias() {
        return mobileAlias;
    }

    public void setMobileAlias(String mobileAlias) {
        this.mobileAlias = mobileAlias;
    }

    public String getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(String isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public String getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(String lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public List<Tab> getTabs() {
        return tabs;
    }

    public void setTabs(List<Tab> tabs) {
        this.tabs = tabs;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyFax() {
        return companyFax;
    }

    public void setCompanyFax(String companyFax) {
        this.companyFax = companyFax;
    }

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

    public String getRepresenterName() {
        return RepresenterName;
    }

    public void setRepresenterName(String RepresenterName) {
        this.RepresenterName = RepresenterName;
    }

    public String getRepresenterPhone() {
        return RepresenterPhone;
    }

    public void setRepresenterPhone(String RepresenterPhone) {
        this.RepresenterPhone = RepresenterPhone;
    }

    public String getRepresenterMobile() {
        return RepresenterMobile;
    }

    public void setRepresenterMobile(String RepresenterMobile) {
        this.RepresenterMobile = RepresenterMobile;
    }

    public String getRepresenterEmail() {
        return RepresenterEmail;
    }

    public void setRepresenterEmail(String RepresenterEmail) {
        this.RepresenterEmail = RepresenterEmail;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getDepartmentManage() {
        return departmentManage;
    }

    public void setDepartmentManage(String departmentManage) {
        this.departmentManage = departmentManage;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getConstitutionYear() {
        return constitutionYear;
    }

    public void setConstitutionYear(String constitutionYear) {
        this.constitutionYear = constitutionYear;
    }
    
    @Override
    public String toString() {
        return "AspnetUserJson{" + "applicationId=" + applicationId + ", userId=" + userId + ", userName=" + userName + ", loweredUserName=" + loweredUserName + ", mobileAlias=" + mobileAlias + ", isAnonymous=" + isAnonymous + ", lastActivityDate=" + lastActivityDate + ", password=" + password + ", passwordSalt=" + passwordSalt + '}';
    }
}
