package com.nsw.backend.mard.p07.dto;

import lombok.Data;

@Data
public class Goods {
    protected String fiNameOfGoods;
    protected String fiCodeOfGoods;
    protected String fiNameSicenceOfGoods;
    protected String fiSizeOrShape;
    protected Double fiQuantityOrWeight;
    protected String fiQuantityOrWeightUnitCode;
    protected String fiQuantityOrWeightUnitName;
    protected String fiOriginationCode;
    protected String fiOriginationName;
    protected String fiHSCodeOfGoods;
    protected String fiSpecies;
    protected String fiValueOfGoods;
    protected String fiCategoryOfGoods;
    protected String fiClassification;
    protected String fiPreservation;
    private String fiNote;
    private String fiRemedialMeasure;
}
