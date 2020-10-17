package com.nsw.backend.mard.p01.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiID;
    private String fiHSCode;
    private String fiAnimalTypeVni;
    private String fiAnimalType;
    private String fiBreedVni;
    private String fiBreed;
    private String fiAge;
    private Integer fiSex;
    private Integer fiNumber;
    private Integer fiAnimalNetWeight;
    private String fiAnimalUnitCode;
    private String fiAnimalUnitVni;
    private String fiAnimalUnit;
    private String fiPurposeVni;
    private String fiPurpose;
    private Float fiShipmentvalue;
}
