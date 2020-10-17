package com.nsw.backend.mard.p08.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiIdGoods;

    private Integer fiGoodsSort;
    private String fiNameOfGoods;
    private String fiCodeOfGoods;
    private String fiNameSicenceOfGoods;
    private Float fiQuantity;
    private String fiQuantityUnitCode;
    private String fiQuantityUnitName;
    private Float fiNetWeight;
    private String fiNetWeightUnitCode;
    private String fiNetWeightUnitName;
    private Float fiGrossWeight;
    private String fiGrossWeightUnitCode;
    private String fiGrossWeightUnitName;
    private String fiWayOfPackinglist;

    private String fiOriginationCode;
    private String fiOriginationName;
    private String fiCirculateNo;
}
