package com.nsw.backend.mard.p01.client;

import lombok.Data;

import java.io.Serializable;

@Data
public class PhytosanitaryFee implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiNSWFileCode;
    private float fiTotalFee;
    private String fiTotalFeeText;
    private String fiNote;
    private String fiCreaterName;
}
