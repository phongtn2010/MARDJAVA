package com.nsw.backend.mard.p01.client;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AnimalProductHKP implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiID;
    private String fiCommodity;
    private Long fiQuantity;
    private String fiUnitCode;
    private String fiUnit;
    private String fiMarkNo;
    private float fiNetWeight;
    private String fiNetWeightUnitName;
    private Date fiFromDateProduct;
    private Date fiToDateProduct;
    private String fiLotIndetificationNo;
}
