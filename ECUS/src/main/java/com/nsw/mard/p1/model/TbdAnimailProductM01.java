package com.nsw.mard.p1.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TbdAnimailProductM01 implements Serializable {
    private Long fiIdAnimailProductM;

    private boolean fiActive;

    private String fiNSWFileCode;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    private String fiID;

    private String fiCommodity;

    private Long fiQuantity;

    private String fiUnitCode;

    private String fiUnit;

    private String fiMarkNo;

    private Double fiNetWeight;

    private String fiNetWeightUnitName;

}
