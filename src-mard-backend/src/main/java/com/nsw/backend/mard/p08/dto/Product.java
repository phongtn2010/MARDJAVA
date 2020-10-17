package com.nsw.backend.mard.p08.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiProductId;
    private Integer fiProductSort;

    private String fiProductCode;
    private String fiProductName;
    private Float fiProductQuantity;
    private String fiProductQuantityUnitCode;
    private String fiProductQuantityUnitName;
    private String fiProductExporterStateName;
    private String fiProductExporterStateCode;
    private String fiProductPortOfDestinationName;
    private String fiProductPortOfDestinationCode;
}
