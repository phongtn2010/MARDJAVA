package com.nsw.mard.p8.model;

import lombok.Data;

import java.util.Date;

@Data
public class FilterForm {
    private boolean fiActive = true;
    private String fiCompanyTaxCode;
    private String fiHSCode;
    private Long fiHSStatus;
    private Date sentStartDate;
    private Date sentEndDate;
    private String licenseNo;
    private Date licenseStartDate;
    private Date licenseEndDate;
    private Integer page;
    private Integer size;
    private String sortBy;
    private String order;


    public String getFiCompanyTaxCode() {
        return fiCompanyTaxCode;
    }

    public void setFiCompanyTaxCode(String fiCompanyTaxCode) {
        this.fiCompanyTaxCode = fiCompanyTaxCode;
    }

    public String getFiHSCode() {
        return fiHSCode;
    }

    public void setFiHSCode(String fiHSCode) {
        this.fiHSCode = fiHSCode;
    }

    public Long getFiHSStatus() {
        return fiHSStatus;
    }

    public void setFiHSStatus(Long fiHSStatus) {
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
}