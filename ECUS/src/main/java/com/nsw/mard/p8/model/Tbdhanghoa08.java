/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.mard.p8.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Tbdhanghoa08 implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiIdProduct;

    private Long fiIdHS;

    private Integer fiSort;

    private String fiProductName;

    private String fiProductScienceName;

    private String fiProductCode;

    private String fiCirculateNo;

    private Integer fiQtyMale;

    private Integer fiQtyFemale;

    private Integer fiAge = 0;

    private String fiPackingType; //Unit of measurement

    private Double fiNumber;

    private String fiUnitCode; //Unit of measurement

    private Double fiNetWeight;

    private String fiNWUnitCode; //Unit of measurement

    private Double fiGrossWeight;

    private String fiGWUnitCode; //Unit of measurement

    private String fiPurpose;

    private String fiCountryOrigin;

    private String fiPortName;

    public Tbdhanghoa08() {
    }

    public Tbdhanghoa08(String fiProductName, Double fiNumber, String fiUnitCode, Double fiNetWeight, String fiNWUnitCode, Double fiGrossWeight, String fiGWUnitCode, String fiPurpose, String fiCountryOrigin, String fiPortName) {
        this.fiProductName = fiProductName;
        this.fiNumber = fiNumber;
        this.fiUnitCode = fiUnitCode;
        this.fiNetWeight = fiNetWeight;
        this.fiNWUnitCode = fiNWUnitCode;
        this.fiGrossWeight = fiGrossWeight;
        this.fiGWUnitCode = fiGWUnitCode;
        this.fiPurpose = fiPurpose;
        this.fiCountryOrigin = fiCountryOrigin;
        this.fiPortName = fiPortName;
    }

    public Tbdhanghoa08(String fiProductName, String fiProductScienceName, String fiProductCode, int fiQtyMale, int fiQtyFemale, int fiAge, String fiPurpose, String fiCountryOrigin, String fiPortName) {
        this.fiProductName = fiProductName;
        this.fiProductScienceName = fiProductScienceName;
        this.fiProductCode = fiProductCode;
        this.fiQtyMale = fiQtyMale;
        this.fiQtyFemale = fiQtyFemale;
        this.fiAge = fiAge;
        this.fiPurpose = fiPurpose;
        this.fiCountryOrigin = fiCountryOrigin;
        this.fiPortName = fiPortName;
    }

}