package com.nsw.backend.mard.p07.client;

import lombok.Data;

import java.util.Date;

@Data
public class QualityFail {
    private String fiNSWFileCode;

    private String fiReason;

    private String fiSignConfirmName;

    private Date fiSignConfirmDate;

    private String fiSignConfirmAddress;
}
