package com.nsw.mard.p1.model;

import lombok.Data;
import java.util.Date;

@Data
public class TbdAnimalProduct01  {
    private String fiHSCode;
    private String fiProductNameVni;
    private String fiProductName;
    private String fiPackageTypeVni;
    private String fiPackageType;
    private Long fiNumber;
    private String fiUnitCode;
    private String fiUnitVni;
    private String fiUnit;
    private String fiMarkNo;
    private Double fiNetWeight;
    private String fiNetWeightUnitCode;
    private String fiNetWeightUnitVni;
    private String fiNetWeightUnit;
    private Date fiFromDateProduct;
    private Date fiToDateProduct;
    private String fiLotIdentificationNo;
    private String fiPurposeVni;
    private String fiPurpose;
    private Double fiShipmentvalue;
}
