package com.nsw.backend.mard.p09.dto.receive;

import lombok.Data;

import java.io.Serializable;

@Data
public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiTypeOfGoods;
    private String fiCodeOfGoods;
    private String fiNameOfGoods;

    private Integer fiAge;

    private Integer fiGender;

    private Integer fiIncludeMale;
    private Integer fiIncludeFemale;

    private String fiWayOfPackinglist;

    private Double fiQuantityOrVolumn;
    private String fiQuantityUnitCode;
    private String fiQuantityUnitName;

    private Double fiNetWeight;
    private String fiNetWeightUnitCode;
    private String fiNetWeightUnitName;

    private Double fiGrossWeight;
    private String fiGrossWeightUnitCode;
    private String fiGrossWeightUnitName;

    private String fiPurposeUse;
}
