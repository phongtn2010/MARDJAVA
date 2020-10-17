/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.security;

import com.nsw.common.model.json.Tab;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author Phong84NV
 */
public class UserCustom extends User {

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

    public UserCustom(String username, String password,
            boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
            boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public UserCustom(String username, String password,
            boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
            boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
            List<Tab> tabs, String userEmail, String userAddress, String userFax, String userPhone, String userName,
            String representerEmail, String RepresenterName, String representerPhone, String representerMobile,
            String companyType, String registrationNo, String departmentManage, String engName,
            String shortName, String constitutionYear) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.tabs = tabs;
        this.companyAddress = userAddress;
        this.companyEmail = userEmail;
        this.companyFax = userFax;
        this.companyName = userName;
        this.companyPhoneNumber = userPhone;
        this.RepresenterEmail = representerEmail;
        this.RepresenterName = RepresenterName;
        this.RepresenterPhone = representerPhone;
        this.RepresenterMobile = representerMobile;
        this.companyType = companyType;
        this.registrationNo = registrationNo;
        this.departmentManage = departmentManage;
        this.engName = engName;
        this.shortName = shortName;
        this.constitutionYear = constitutionYear;
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

}
