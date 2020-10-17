package com.nsw.backend.mard.p07.client;

import lombok.Data;

@Data
public class PhytosanitaryFee {
    private String fiNSWFileCode;

    private Integer fiType; //1. Ap phí - 2. Áp phí bổ sung

    private Double fiTotalFee;

    private String fiTotalFeeText;

    private String fiNote;

    private String fiDepartment;

    private String fiCreaterName;
}
