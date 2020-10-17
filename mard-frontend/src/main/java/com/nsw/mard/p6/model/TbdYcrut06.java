package com.nsw.mard.p6.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TbdYcrut06 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDYCRUT06_SEQ";

    private Integer fiRequestId;

    private Integer fiIdHS;

    private String fiNSWFileCode;

    private Date fiRequestedDate;

    private Integer fiActive;

    private Integer fiStatus;

    private String fiReason;

    private Integer fiRequestType;

    private String fiReasonMard;

    private Date fiProcessedDate;

    private String fiProcessingUnit;

    private String fiProcessor;

    public TbdYcrut06() {
        super();
    }

}
