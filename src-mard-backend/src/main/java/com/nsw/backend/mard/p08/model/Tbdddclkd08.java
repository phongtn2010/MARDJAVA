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
 * Persistent class for entity stored in table "TBDDDCLKD08"
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@Table(name = "TBDDDCLKD08", schema = "MARD")
public class Tbdddclkd08 implements Serializable {
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_COMPANY", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDDDCLKD08_SEQ")
    @SequenceGenerator(sequenceName = "TBDDDCLKD08_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDDDCLKD08_SEQ")
    private Long fiIdQuarLoc;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name = "FI_HS_ID")
    private Long fiIdHS;

    @Column(name = "FI_ISO_LOC_NAME", length = 250)
    private String fiIsoLocName;

    @Column(name = "FI_ISO_LOC_ADDRESS", length = 500)
    private String fiIsoLocAddress;
}
