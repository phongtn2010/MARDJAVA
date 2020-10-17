package com.nsw.mard.p25.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TbdHanghoaCL25 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHANGHOACL25_SEQ";

    private Long fiIdProCL;

    private Long fiIdProduct;

    private String fiProCLTarg;

    private String fiProCLCompare;

    private String fiProCLContent;

    private String fiProCLUnitID;

    private String fiProCLUnitName;
}
