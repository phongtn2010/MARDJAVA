package com.nsw.backend.mard.p09.dto.send;

import lombok.Data;

import java.io.Serializable;

@Data
public class Seller implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiSellerStateCode;
    private String fiSellerStateName;
    private String fiSellerName;
    private String fiSellerAddress;
    private String fiSellerPhone;
    private String fiSellerFax;
    private String fiPortOfDepartureName;

}
