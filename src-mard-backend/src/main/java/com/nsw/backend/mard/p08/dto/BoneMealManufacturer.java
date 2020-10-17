package com.nsw.backend.mard.p08.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BoneMealManufacturer implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiBoneMealManufacturerId;

    private String fiBoneMealManufactureName;
    private String fiBoneMealManufactureAddress;
}
