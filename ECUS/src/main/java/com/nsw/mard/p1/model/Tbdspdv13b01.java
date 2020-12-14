package com.nsw.mard.p1.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Tbdspdv13b01 implements Serializable {
    private Long fiIdSPDV13B;

    private String fiNSWFileCode;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    private String fiID;

    private String fiProductNameVni;

    private String fiProductName;

    private String fiPackageTypeVni;

    private String fiPackageType;

    private long fiNumber;

    private String fiUnitCode;

    private String fiUnitVni;

    private String fiUnit;

    private Double fiNetWeight;

    private String fiNetWeightUnitName;
    private String fiNetWeightUnitNameVni;
}
