package com.nsw.backend.mard.p07.client;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseEditCer {
    private String fiNSWFileCode;

    private String fiReason;

    private Date fiSignConfirmDate;

    private String fiDepartment;

    private String fiCreatorName;
}
