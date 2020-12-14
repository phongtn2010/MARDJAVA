package com.nsw.mard.p9.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Persistent class for entity stored in table "TBDDDCLKD09"
 *
 * @author Telosys Tools Generator
 */
@Data
public class TbdCnkdKd09 implements Serializable {
    private Long fiId;

    private String fiNSWFileCode;

    private Date fiRequestDate;

    private String fiDepartment;

    private String fiCreaterName;

    private String fiDescription;

    private String fiQualityResult;

    private List<TbdDkCnkdKd09> fiAttachmentList;

    public TbdCnkdKd09() {
        fiAttachmentList = new ArrayList<>();
    }

}
