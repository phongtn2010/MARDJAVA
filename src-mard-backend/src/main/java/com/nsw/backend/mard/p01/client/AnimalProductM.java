package com.nsw.backend.mard.p01.client;

import lombok.Data;

import java.io.Serializable;

@Data
public class AnimalProductM implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiID;
    private String fiCommodity;
    private long fiQuantity;
    private String fiUnitCode;
    private String fiUnit;
    private String fiMarkNo;
    private float fiNetWeight;
    private String fiNetWeightUnitName;
}
