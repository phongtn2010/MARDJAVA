/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.backend.mard.p08.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Persistent class for entity stored in table "TBDCSSXSP08"
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@Table(name = "TBDCSSXSP08", schema = "MARD")
public class Tbdcssxsp08 implements Serializable {
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_MFR", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDCSSXSP08_SEQ")
    @SequenceGenerator(sequenceName = "TBDCSSXSP08_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDCSSXSP08_SEQ")
    private Long fiIdMfr;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name = "FI_HS_ID")
    private Long fiIdHS;

    @Column(name = "FI_MFR_NAME", length = 250)
    private String fiMfrName;

    @Column(name = "FI_MFR_ADDRESS", length = 500)
    private String fiMfrAddress;

    @Column(name = "FI_MFR_COUNTRY_ORIGIN", length = 50)
    private String fiMfrCountryrigin;

}
