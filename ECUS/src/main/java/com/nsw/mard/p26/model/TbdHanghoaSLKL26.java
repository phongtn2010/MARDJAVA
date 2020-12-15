/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.mard.p26.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Persistent class for entity stored in table "25" - Hồ sơ Đăng ký
 *
 * @author Telosys Tools Generator
 */
@Data
public class TbdHanghoaSLKL26  implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHANGHOASLKL26_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Integer fiIdProSLKL;
    private Integer fiIdSLKL26;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    private Integer fiIdHH26;
    private Integer fiIdProduct;

    private Float fiProSLKLMass;

    private String fiProSLKLMassUnitCode;

    private String fiProSLKLMassUnitName;

    private Float fiProSLKLMassTan;

    private Float fiProSLKLAmount;

    private String fiProSLKLAmountUnitCode;

    private String fiProSLKLAmountUnitName;
}