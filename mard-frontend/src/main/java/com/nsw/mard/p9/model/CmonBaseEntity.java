package com.nsw.mard.p9.model;

import lombok.Data;

import java.util.Date;

@Data
public class CmonBaseEntity {
    private Date fiCreatedDate;
    private String fiCreatedBy;
    private Date fiUpdatedDate;
    private String fiUpdatedBy;
}
