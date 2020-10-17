package com.nsw.mard.p9.model;

import lombok.Data;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Tbddvxl09 implements Serializable {
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Long fiIdPU;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    private String fiPUCode;

    private String fiPUDesc;

    private int fiPULevel;

    private Long fiPUParentID;

    private List<Tbddvxl09> lstChildPU;

    public Tbddvxl09() {
        lstChildPU = new ArrayList<>();
    }

    public Tbddvxl09(String fiPUCode, String fiPUDesc, int fiPULevel) {
        this();
        this.fiPUCode = fiPUCode;
        this.fiPUDesc = fiPUDesc;
        this.fiPULevel = fiPULevel;
    }
}