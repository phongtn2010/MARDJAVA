package com.nsw.mard.p1.model;

import lombok.Data;

@Data
public class Tbdtbap01 {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDTBAP01_SEQ";
    private Long fiIdTBAP;

    private boolean fiActive;


    private String fiNSWFileCode;

    private Double fiTotalFee;

    private String fiTotalFeeText;

    private String fiNote;

    private String fiCreaterName;
}
