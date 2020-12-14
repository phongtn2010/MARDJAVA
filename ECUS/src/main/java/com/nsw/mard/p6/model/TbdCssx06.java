package com.nsw.mard.p6.model;
import lombok.Data;


import java.io.Serializable;

@Data
public class TbdCssx06 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDCSSX06_SEQ";

    private Long fiIdProcessing;

    private Long fiIdHS;

    private String fiProcessingName;

    private String fiProcessingAddress;

    private String fiProcessingApprovalNumber;
}

