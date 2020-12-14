package com.nsw.mard.p8.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Tbdgiayto08 implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final String SEQUENCE_NAME = "TBDGIAYTO08_SEQ";

    private Long fiIdProduct;

    private Long fiIdHS;

    private Long fiTypeDoc;

    private String fiNumber;

    private Date fiDate;
}

