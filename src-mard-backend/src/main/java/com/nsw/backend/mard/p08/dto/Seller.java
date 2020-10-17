package com.nsw.backend.mard.p08.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Seller implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiSellerId;

    private String fiSellerName;
    private String fiSellerStateCode;
    private String fiSellerStateName;
    private String fiSellerAddress;
    private String fiSellerPhone;
    private String fiSellerFax;
}
