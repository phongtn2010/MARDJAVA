package com.nsw.mard.p1.model;

import lombok.Data;

import java.util.Date;

@Data
public class FilterForm {
    private String fiCompanyTaxCode;
    private boolean fiActive = true;
    private String fiHSCode;
    private Integer fiHSStatus = -1;
    private Date sentStartDate;
    private Date sentEndDate;
    private String licenseNo;
    private Date licenseStartDate;
    private Date licenseEndDate;
    private Integer page = 1;
    private Integer size = 20;
    private String sortBy = "fiNSWFileCode";
    private String order = "asc";

}
