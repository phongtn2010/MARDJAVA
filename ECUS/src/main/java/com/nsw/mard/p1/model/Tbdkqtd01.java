package com.nsw.mard.p1.model;

import lombok.Data;

import java.util.Date;

@Data
public class Tbdkqtd01  {
    private Long fiIdKQTD;

    private boolean fiActive;

    private String fiNSWFileCode;

    private String fiReason;

    private String fiCreaterName;

    private String fiRegistationConfirmNo;

    private Date fiRegistationConfirmDate;

    private String fiCheckPlace;

    private Date fiCheckTime;


}