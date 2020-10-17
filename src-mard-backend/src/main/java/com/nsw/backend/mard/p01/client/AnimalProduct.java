package com.nsw.backend.mard.p01.client;

import lombok.Data;

import java.io.Serializable;

@Data
public class AnimalProduct implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiID;
    private String fiProductNameVni;
    private String fiProductName;
    private String fiPackageTypeVni;
    private String fiPackageType;
    private long fiNumber;
    private String fiUnitCode;
    private String fiUnitVni;
    private String fiUnit;
    private float fiNetWeight;
    private String fiNetWeightUnitName;
}
