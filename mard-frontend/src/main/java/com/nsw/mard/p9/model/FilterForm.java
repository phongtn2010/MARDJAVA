package com.nsw.mard.p9.model;

import lombok.Data;

import java.util.Date;

@Data
public class FilterForm {
    private String fiCompanyTaxCode;
    private boolean fiActive = true;
    private String fiHSCode;
    private Long fiHSStatus = -1L;
    private Long fiGSStatus = -1L;
    private Long fiKDStatus = -1L;
    private String fiQuarantineDepartmentCode;
    private String fiMonitoringDepartmentCode;
    private Date sentStartDate;
    private Date sentEndDate;
    private String licenseNo;
    private Date licenseStartDate;
    private Date licenseEndDate;
    private Integer page = 1;
    private Integer size = 20;
    private String sortBy = "fiHSCode";
    private String order = "asc";
}
