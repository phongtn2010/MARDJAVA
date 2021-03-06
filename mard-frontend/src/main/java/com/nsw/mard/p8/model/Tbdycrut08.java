package com.nsw.mard.p8.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Tbdycrut08 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiRequestId;

    private Long fiIdHS;

    private String fiHSCode;

    private Date fiRequestedDate;

    private Long fiActive;

    private Long fiStatus;

    private String fiReason;

    private Long fiRequestType;

    private String fiReasonMard;

    private Date fiProcessedDate;

    private String fiProcessingUnit;

    private String fiProcessor;

    public Tbdycrut08() {
    }
}

