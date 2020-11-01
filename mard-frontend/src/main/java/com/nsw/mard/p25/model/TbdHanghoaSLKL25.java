package com.nsw.mard.p25.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TbdHanghoaSLKL25 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHANGHOASLKL25_SEQ";

    private Integer fiIdProSLKL;

    private Integer fiIdProduct;

    private Integer fiProSLKLMass;

    private String fiProSLKLMassUnitName;

    private Integer fiProSLKLMassTan;

    private Integer fiProSLKLAmount;

    private String fiProSLKLAmountUnitName;
    private String fiProSLKLMassUnitCode;
    private String fiProSLKLAmountUnitCode;
}
