package com.nsw.backend.mard.p07.client;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ResponseCancel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String fiNSWFileCode;

    private String fiRegistrationComfirmNo;
    private String fiReason;
    private Date fiSignConfirmDate;
    private String fiDepartment;
    private String fiCreateName;
}
