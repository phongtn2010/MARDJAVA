package com.nsw.mard.p6.model;
import lombok.Data;


import java.io.Serializable;

@Data
public class TbdDonViXuLy06 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDDVXL06_SEQ";

    private Long id;

    private String fiPUCode;

    private String fiPUDesc;

    private String fiPULocation;

    public TbdDonViXuLy06() {
    }

    public TbdDonViXuLy06(String fiPUCode, String fiPUDesc, String fiPULocation) {
        this.fiPUCode = fiPUCode;
        this.fiPUDesc = fiPUDesc;
        this.fiPULocation = fiPULocation;
    }
}

