package com.nsw.backend.mard.p09.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

@Data
public class FilterForm {
    private String fiCompanyTaxCode;
    private boolean fiActive = true;
    private String fiHSCode;
    private Long fiHSStatus = -1L;
    private Long fiGSStatus = -1L;
    private Long fiKDStatus = -1L;
    private Date sentStartDate;
    private Date sentEndDate;
    private String licenseNo;
    private Date licenseStartDate;
    private Date licenseEndDate;
    private Integer page = 1;
    private Integer size = 20;
    private String sortBy = "fiHSCode";
    private String order = "asc";

    private String fiQuarantineDepartmentCode;
    private String fiMonitoringDepartmentCode;

    @JsonIgnore
    private List<String> fiLstNSWFileCode;

    public boolean isValidForLicenseQuery() {
        return !StringUtils.isEmpty(licenseNo) || licenseStartDate != null || licenseEndDate != null;
    }
}
