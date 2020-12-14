package com.nsw.mard.p9.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class CmonHh09 {
    private String fiProductCode;

    private String fiProductName;

    private String fiProductScienceName;

    private Long fiQuantityFemale;

    private Long fiQuantityMale;

    private Integer fiAge;

    private Integer fiGender;

    private Integer fiIncludeMale;

    private Integer fiIncludeFemale;

    private String fiPackingWay;

    private Double fiNumber;

    private String fiUnitCode;

    private String fiUnitName;


    private Double fiNetWeight;

    private String fiNWUnitCode;

    private String fiNWUnitName;

    private Double fiGrossWeight;

    private String fiGWUnitCode;

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

}
