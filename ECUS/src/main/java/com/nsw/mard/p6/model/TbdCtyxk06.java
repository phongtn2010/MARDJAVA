package com.nsw.mard.p6.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TbdCtyxk06 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDCTYXK06_SEQ";

    private Long fiIdExporter;

    private Long fiIdHS;

    private String fiExporterCountryName;

    private String fiExporterCountryAddress;
}

