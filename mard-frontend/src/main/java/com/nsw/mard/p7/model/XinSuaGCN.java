package com.nsw.mard.p7.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class XinSuaGCN {
    private Integer fiCertType;
    private Date fiRequestDate;
    private String fiReason;
    private String fiNSWFileCode;
    private String fiCertificateNo;
}
