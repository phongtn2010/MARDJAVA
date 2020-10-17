package com.nsw.backend.mard.p01.client;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ResultConfirm implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiNSWFileCode;
    private String fiReason;
    private String fiCreaterName;
    private String fiRegistationConfirmNo;
    private Date fiRegistationConfirmDate;
    private String fiCheckPlace;
    private Date fiCheckTime;
}
