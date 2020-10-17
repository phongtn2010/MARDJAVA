package com.nsw.mard.p1.model;

import lombok.Data;

import java.util.Date;

@Data
public class YeucauSuaHoso {
    private Date fiRequestDate;
    private String fiReason;
    private Tbdhoso01 fiRegistrationProfile;

}
