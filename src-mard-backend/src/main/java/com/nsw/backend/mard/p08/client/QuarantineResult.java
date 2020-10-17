package com.nsw.backend.mard.p08.client;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class QuarantineResult implements Serializable {

    private static final long serialVersionUID = 1L;
    private String fiNSWFileCode;
    private String fiReason;
    private Date fiResultDate;
    private String fiDepartment;
    private String fiCreaterName;
}
