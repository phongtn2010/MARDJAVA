package com.nsw.backend.mard.p01.client;

import lombok.Data;

import java.io.Serializable;

@Data
public class AnimailProductChina implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiID;
    private String fiHSCode;
    private String fiTypeProduct;
    private String fiBactchNumber;
    private String fiPackageType;
    private long fiNumberPackage;
    private String fiUnitCode;
    private String fiUnit;
    private float fiNetWeight;
    private String fiNetWeightUnitName;
}
