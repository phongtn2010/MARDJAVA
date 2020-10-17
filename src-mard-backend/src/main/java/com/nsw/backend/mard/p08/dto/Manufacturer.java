package com.nsw.backend.mard.p08.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Manufacturer implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiManufacturerId;
    private String fiManufacturerName;
    private String fiManufactureFactoryAddress;
    private String fiCountryCode;
    private String fiCountryName;
}
