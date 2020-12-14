package com.nsw.mard.p1.model;

import lombok.Data;

import java.util.Date;

@Data
public class XinsuaGiayphep {
    private String fiNSWFileCode;

    private Date fiRequestDate;

    private String fiFileName;

    private String fiFileAttack;

    private String fiReason;
}
