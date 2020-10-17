package com.nsw.backend.mard.p09.dto.send;

import lombok.Data;

import java.io.Serializable;

@Data
public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;

//    private Long fiGoodsId;

    //    private Integer  fiGoodsSort;
    private String fiCodeOfGoods;
    private String fiNameOfGoods;
    private String fiNameSicenceOfGoods;
    private Long fiAnimalQuantityFemale;
    private Long fiAnimalQuantityMale;
    private Integer fiAge;
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
    private String fiRegistrationNo;
    private String fiOriginationCode;
    private String fiOriginationName;
    private String fiImportPortOfDestinationCode;
    private String fiImportPortOfDestinationName;
}

