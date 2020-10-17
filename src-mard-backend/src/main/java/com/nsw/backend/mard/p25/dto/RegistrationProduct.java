/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.backend.mard.p25.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Persistent class for entity stored in table "TBDHANGHOA06" - Hồ sơ Đăng ký
 *
 * @author Telosys Tools Generator
 */
@Data
public class RegistrationProduct implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer fiId;

    @Size(max = 255)
    @NotNull
    private String fiProductBusinessName;

    @Size(max = 255)
    private String fiProductScienceName;

    @Size(max = 50)
    private String fiPackageUnitCode;

    @Size(max = 100)
    private String fiPackageUnitName;

    @Size(max = 50)
    private String fiOriginCountryCode;

    @Size(max = 100)
    private String fiOriginCountryName;

    private Float fiQuantity;

    private String fiSizeOrType;
}
