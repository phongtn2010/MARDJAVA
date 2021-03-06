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
 * Persistent class for entity stored in table "TBDNMSX08"
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@Table(name = "TBDNMSX08", schema = "MARD")
public class Tbdnmsx08 implements Serializable {
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_FACTORY", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDNMSX08_SEQ")
    @SequenceGenerator(sequenceName = "TBDNMSX08_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDNMSX08_SEQ")
    private Long fiIdFactory;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name = "FI_HS_ID")
    private Long fiIdHS;

    @Column(name = "FI_FACTORY_NAME", length = 250)
    private String fiFactoryName;

    @Column(name = "FI_FACTORY_ADDRESS", length = 500)
    private String fiFactoryAddress;

}
