package com.nsw.backend.mard.p06.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
public class ResponseCancel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiNSWFileCode;

    @Size(max = 50)
    private String fiRegistrationComfirmNo;

    @Size(max = 2000)
    private String fiReason;

    @NotNull
    private Date fiSignConfirmDate;

    @Size(max = 250)
    private String fiDepartment;

    @Size(max = 250)
    private String fiCreateName;
}
