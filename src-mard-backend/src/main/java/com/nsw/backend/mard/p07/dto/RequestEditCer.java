package com.nsw.backend.mard.p07.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RequestEditCer implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer fiTypeOfRequest;
    private Date fiRequestDate;
    private String fiReason;
    private String fiNSWFileCode;
    private String fiCertificateNo;
    private Integer fiCertType;
}
