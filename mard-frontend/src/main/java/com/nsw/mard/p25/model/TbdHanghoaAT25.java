package com.nsw.mard.p25.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TbdHanghoaAT25 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHANGHOAAT25_SEQ";

    private Integer fiIdProAT;

    private Integer fiIdProduct;

    private String fiProATTarg;

    private String fiProATCompare;

    private String fiProATContent;

    private String fiProATUnitID;

    private String fiProATUnitName;
}
