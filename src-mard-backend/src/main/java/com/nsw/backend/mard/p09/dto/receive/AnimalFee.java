package com.nsw.backend.mard.p09.dto.receive;

import lombok.Data;

@Data
public class AnimalFee {
    private String fiNSWFileCode;

    private Double fiTotalFee;

    private String fiAmountInWords;

    private String fiNote;

    private String fiDepartment;

    private String fiCreaterName;
}