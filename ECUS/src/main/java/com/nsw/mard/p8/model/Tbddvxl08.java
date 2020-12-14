/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.mard.p8.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Tbddvxl08 implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long fiIdPU;

    private String fiPUCode;

    private String fiPUDesc;

    private Integer fiPULevel;

    private Long fiPUParentID;

    private List<Tbddvxl08> lstChildPU;

    public Tbddvxl08() {
        lstChildPU = new ArrayList<>();
    }

    public Tbddvxl08(String fiPUCode, String fiPUDesc, int fiPULevel) {
        this();
        this.fiPUCode = fiPUCode;
        this.fiPUDesc = fiPUDesc;
        this.fiPULevel = fiPULevel;
    }

}
