package com.nsw.mard.p1.model;

import lombok.Data;


import java.io.Serializable;

@Data
public class TbdAnimailProductCN01 implements Serializable {
    private Long fiIdAnimailProductCN;

    private boolean fiActive;

    private String fiNSWFileCode;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    private String fiID;

    private String fiHSCode;

    private String fiTypeProduct;

    private String fiBactchNumber;

    private String fiPackageType;

    private long fiNumberPackage;

    private String fiUnitCode;

    private String fiUnit;

    private Double fiNetWeight;

    private String fiNetWeightUnitName;

    private String fiMarkNo;
}
