package com.nsw.user.model;

import com.nsw.common.model.json.Tab;
import java.io.Serializable;
import java.util.List;
public class User implements Serializable {
    private Integer id;
    private String ssoId;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordAndSalt;
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
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordAndSalt() {
        return passwordAndSalt;
    }

    public void setPasswordAndSalt(String passwordAndSalt) {
        this.passwordAndSalt = passwordAndSalt;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((ssoId == null) ? 0 : ssoId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (ssoId == null) {
            if (other.ssoId != null) {
                return false;
            }
        } else if (!ssoId.equals(other.ssoId)) {
            return false;
        }
        return true;
    }

    /*
	 * DO-NOT-INCLUDE passwords in toString function.
	 * It is done here just for convenience purpose.
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", ssoId=" + ssoId + ", password=" + password
                + ", firstName=" + firstName + ", lastName=" + lastName
                + ", email=" + email + "]";
    }

}
