package com.nsw.backend.mard.p07.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RegistrationConfirmation {
    private String fiRegistrationComfirmNo;
    private String fiCheckPlace;
    private Date fiCheckTime;
    private Date fiCheckTimeFrom;
    private Date fiCheckTimeTo;
    private String fiCreaterName;

}
