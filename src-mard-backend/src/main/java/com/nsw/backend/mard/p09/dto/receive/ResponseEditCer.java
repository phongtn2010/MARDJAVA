package com.nsw.backend.mard.p09.dto.receive;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseEditCer {
    private boolean isAccepted;

    private String fiCertificateNo;

    private String fiReason;

    private Date fiSignConfirmDate;

    private String fiDepartment;

    private String fiCreaterName;
}
