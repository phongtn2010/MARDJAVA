package com.nsw.backend.mard.p08.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductManufacturer implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiProductManufacturerId;
    private String fiProductManufactureName;
    private String fiProductManufactureAddress;
}
