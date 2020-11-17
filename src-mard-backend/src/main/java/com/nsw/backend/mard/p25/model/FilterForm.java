/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p25.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

@Data
public class FilterForm {
    private String fiCertNo;
    private String fiCompanyTaxCode;
    private Integer fiProCountryName;
    private String fiProMadeIn;
    private boolean fiActive = true;
    private String fiHSCode;
    private String fiProName;
    private Integer fiHSStatus ;
    private Date sentStartDate;
    private Date sentEndDate;
    private String licenseNo;
    private Date licenseStartDate;
    private Date licenseEndDate;
    private Integer page = 1;
    private Integer size = 20;
    private String sortBy = "fiNSWFileCode";
    private String order = "asc";
    private Integer fiHSType;
    @JsonIgnore
    private List<String> fiLstNSWFileCode;

    public boolean isValidForLicenseQuery() {
        return !StringUtils.isEmpty(licenseNo) || licenseStartDate != null || licenseEndDate != null;
    }

    public String getFiCertNo() {
        return fiCertNo;
    }

    public void setFiCertNo(String fiCertNo) {
        this.fiCertNo = fiCertNo;
    }

    public String getFiCompanyTaxCode() {
        return fiCompanyTaxCode;
    }

    public void setFiCompanyTaxCode(String fiCompanyTaxCode) {
        this.fiCompanyTaxCode = fiCompanyTaxCode;
    }

    public Integer getFiProCountryName() {
        return fiProCountryName;
    }

    public void setFiProCountryName(Integer fiProCountryName) {
        this.fiProCountryName = fiProCountryName;
    }

    public String getFiProMadeIn() {
        return fiProMadeIn;
    }

    public void setFiProMadeIn(String fiProMadeIn) {
        this.fiProMadeIn = fiProMadeIn;
    }

    public boolean isFiActive() {
        return fiActive;
    }

    public void setFiActive(boolean fiActive) {
        this.fiActive = fiActive;
    }

    public String getFiHSCode() {
        return fiHSCode;
    }

    public void setFiHSCode(String fiHSCode) {
        this.fiHSCode = fiHSCode;
    }

    public String getFiProName() {
        return fiProName;
    }

    public void setFiProName(String fiProName) {
        this.fiProName = fiProName;
    }

    public Integer getFiHSStatus() {
        return fiHSStatus;
    }

    public void setFiHSStatus(Integer fiHSStatus) {
        this.fiHSStatus = fiHSStatus;
    }

    public Date getSentStartDate() {
        return sentStartDate;
    }

    public void setSentStartDate(Date sentStartDate) {
        this.sentStartDate = sentStartDate;
    }

    public Date getSentEndDate() {
        return sentEndDate;
    }

    public void setSentEndDate(Date sentEndDate) {
        this.sentEndDate = sentEndDate;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public Date getLicenseStartDate() {
        return licenseStartDate;
    }

    public void setLicenseStartDate(Date licenseStartDate) {
        this.licenseStartDate = licenseStartDate;
    }

    public Date getLicenseEndDate() {
        return licenseEndDate;
    }

    public void setLicenseEndDate(Date licenseEndDate) {
        this.licenseEndDate = licenseEndDate;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getFiHSType() {
        return fiHSType;
    }

    public void setFiHSType(Integer fiHSType) {
        this.fiHSType = fiHSType;
    }

    public List<String> getFiLstNSWFileCode() {
        return fiLstNSWFileCode;
    }

    public void setFiLstNSWFileCode(List<String> fiLstNSWFileCode) {
        this.fiLstNSWFileCode = fiLstNSWFileCode;
    }
}
