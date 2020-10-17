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
 * Persistent class for entity stored in table "TBDCVDDCLKD06" - Địa điểm cách ly kiểm dịch
 *
 * @author Telosys Tools Generator
 */
@Data
public class RegistrationLocationQuarantine implements Serializable {
    @Size(max = 255)
    @NotNull
    private String fiLocationQuarantineName;

    @Size(max = 255)
    @NotNull
    private String fiLocationQuarantineAddress;
}
