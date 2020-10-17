package com.nsw.mard.p6.model;
import lombok.Data;


import java.io.Serializable;

@Data
public class TbdDdclkd06 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDDDCLKD06_SEQ";

    private Long fiIdQuarLoc;

    private Long fiIdHS;

    private String fiLocationQuarantineName;

    private String fiLocationQuarantineAddress;
}

