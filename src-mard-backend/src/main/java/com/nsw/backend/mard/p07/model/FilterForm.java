/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p07.model;

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
    private Integer fiHSStatus = -1;
    private Integer fiKDStatus = -1;
    private Integer fiGSStatus = -1;
    private Date sentStartDate;
    private Date sentEndDate;
    private String licenseNo;
    private Date licenseStartDate;
    private Date licenseEndDate;
    private Integer page = 1;
    private Integer size = 20;
    private String sortBy = "fiNSWFileCode";
    private String order = "asc";
    private String fiDepartmentofMonitorCode;
    private String fiDepartmentofQuarantineCode;

    @JsonIgnore
    private List<String> fiLstNSWFileCode;

    public boolean isValidForLicenseQuery() {
        return !StringUtils.isEmpty(licenseNo) || licenseStartDate != null || licenseEndDate != null;
    }
}
