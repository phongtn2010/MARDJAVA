package com.nsw.backend.mard.p09.dto.receive;

import lombok.Data;

@Data
public class QualityResultGoods {
    private String fiCodeOfGoods;
    private String fiNameOfGoods;

    private Double fiQuantityOrVolumn;
    private String fiQuantityOrVolumnUnitCode;
    private String fiQuantityOrVolumnUnitName;

    private String fiCriteriaAnalysisNo;
    private String fiDescriptionOfGoods;

    private Long fiResult;
    private String fiReason;
}
