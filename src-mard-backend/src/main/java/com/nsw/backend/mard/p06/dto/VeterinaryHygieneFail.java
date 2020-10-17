package com.nsw.backend.mard.p06.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class VeterinaryHygieneFail implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiNSWFileCode;

    private Date fiResultDate;

    private String fiCreaterName;

    private String fiDepartment;

    private Integer fiResult;
}

