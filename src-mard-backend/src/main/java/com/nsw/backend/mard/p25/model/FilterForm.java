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
    private String fiProCountryName;
    private String fiProMadeIn;

    private String fiHSCode;
    private String fiTenHangHoa;
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
    private String fiHSType;
    @JsonIgnore
    private List<String> fiLstNSWFileCode;

    public boolean isValidForLicenseQuery() {
        return !StringUtils.isEmpty(licenseNo) || licenseStartDate != null || licenseEndDate != null;
    }
}
