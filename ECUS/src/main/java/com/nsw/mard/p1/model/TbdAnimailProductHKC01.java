package com.nsw.mard.p1.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TbdAnimailProductHKC01 implements Serializable {
    private Long fiIdAnimailProductHKC;

    private boolean fiActive;

    private String fiNSWFileCode;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    private String fiID;

    private String fiTypeProduct;

    private String fiPackageType;

    private long fiNumberPackage;

    private String fiUnitCode;

    private String fiUnit;

    private Double fiNetWeight;

    private String fiNetWeightUnitName;

    private String fiMarkNo;
}
