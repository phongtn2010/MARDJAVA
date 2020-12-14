package com.nsw.mard.p7.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
public class TbdCnkdKd07 extends CmonBaseEntity implements Serializable {
    private Integer fiId;

    private String fiNSWFileCode;

    private String fiReason;

    private String fiSignConfirmName;

    private Date fiSignConfirmDate;

    private String fiSignConfirmAddress;
}
