package com.nsw.backend.mard.p01.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RequestCancel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiNSWFileCode;
    private Date fiRequestDate;
    private String fiReason;
}
