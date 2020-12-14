package com.nsw.mard.p1.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TbdAnimailProductHKP01 implements Serializable {
    private Long fiIdAnimailProductHKP;

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

    private Date fiFromDateProduct;

    private Date fiToDateProduct;

    private String fiLotIndetificationNo;

}
