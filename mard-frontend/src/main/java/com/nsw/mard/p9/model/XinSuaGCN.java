package com.nsw.mard.p9.model;

import lombok.Data;

import java.util.List;

@Data
public class XinSuaGCN {
    private String fiReason;
    private String fiNSWFileCode;
    private String fiCertificateNo;
    private String fiTypeCert;
    private Long fiIdCv;
    private List<Attachment> lstAtch;
}
