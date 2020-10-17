package com.nsw.mard.p9.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Persistent class for entity stored in table "TBDHANGHOA09"
 *
 * @author Telosys Tools Generator
 *
 */

@Data
public class Tbdhanghoa09 implements Serializable {
    private Long fiIdProduct;

    private Long fiIdHS;

    private Long fiIdQualityRejectCer;

    private Long fiIdTransportDoc;

    private Long fiIdQuarantineCer;

    private String fiProductCode;

    private String fiProductName;
    private String fiProductScienceName;

    private Long fiQuantityFemale;

    private Long fiQuantityMale;

    private Double fiAge;

    private String fiGender;

    private String fiPackingWay;

    private Double fiNumber;

    private String fiUnitCode;

    private String fiUnitName;


    private Double fiNetWeight;

    private String fiNWUnitCode;

    private String fiNWUnitName;

    private Double fiGrossWeight;

    private String fiGWUnitName;

    private String fiPurposeUse;

    private String fiCountryOrigin;

    private String fiCountryOriginName;

    private String fiImportPortDestCode;

    private String fiImportPortOfDestName;

    private String fiCirculateNo;

    private String fiCriteriaAnalysisNo;

    private String fiDescriptionOfGoods;

    private Long fiResult;

    private String fiReason;

    public Tbdhanghoa09() {
    }

    public Tbdhanghoa09(String fiProductName, Double fiNumber, String fiGender, String fiPurposeUse) {
        this.fiProductName = fiProductName;
        this.fiNumber = fiNumber;
        this.fiGender = fiGender;
        this.fiPurposeUse = fiPurposeUse;
        this.fiAge = 3.0;
    }

    public Tbdhanghoa09(String fiProductName, Double fiNumber, Double fiGrossWeight, Double fiNetWeight, String fiPurposeUse) {
        this.fiProductName = fiProductName;
        this.fiNumber = fiNumber;
        this.fiGrossWeight = fiGrossWeight;
        this.fiNetWeight = fiNetWeight;
        this.fiPurposeUse = fiPurposeUse;
    }

    public Tbdhanghoa09(String fiProductCode, String fiProductName, Double fiNumber, String fiNWUnitCode, String fiNWUnitName, String fiCriteriaAnalysisNo, String fiDescriptionOfGoods, Long fiResult, String fiReason) {
        this.fiProductCode = fiProductCode;
        this.fiProductName = fiProductName;
        this.fiNumber = fiNumber;
        this.fiNWUnitCode = fiNWUnitCode;
        this.fiNWUnitName = fiNWUnitName;
        this.fiCriteriaAnalysisNo = fiCriteriaAnalysisNo;
        this.fiDescriptionOfGoods = fiDescriptionOfGoods;
        this.fiResult = fiResult;
        this.fiReason = fiReason;
    }

    public Tbdhanghoa09(String fiProductCode, String fiProductName, Double fiNumber) {
        this.fiProductCode = fiProductCode;
        this.fiProductName = fiProductName;
        this.fiNumber = fiNumber;
    }
}
