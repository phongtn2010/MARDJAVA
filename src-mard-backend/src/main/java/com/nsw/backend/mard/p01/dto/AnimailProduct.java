package com.nsw.backend.mard.p01.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AnimailProduct implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiAnimalProductID;
    private String fiHSCode;
    private String fiProductNameVni;
    private String fiProductName;
    private String fiPackageTypeVni;
    private String fiPackageType;
    private Long fiNumber;
    private String fiUnitCode;
    private String fiUnitVni;
    private String fiUnit;
    private float fiNetWeight;
    private String fiNetWeightUnitCode;
    private String fiNetWeightUnitVni;
    private String fiNetWeightUnit;
    private Date fiFromDateProduct;
    private Date fiToDateProduct;
    private String fiLotIdentificationNo;
    private String fiPurposeVni;
    private String fiPurpose;
    private Float fiShipmentvalue;

}
