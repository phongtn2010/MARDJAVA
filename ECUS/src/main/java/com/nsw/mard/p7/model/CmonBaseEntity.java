package com.nsw.mard.p7.model;

import lombok.Getter;
import lombok.Setter;


import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
public class CmonBaseEntity {
    private static final String SYSTEM_USER = "NSW";
    private Date fiCreatedDate;

    private String fiCreatedBy;

    private Date fiUpdatedDate;

    private String fiUpdatedBy;

}
