package com.nsw.backend.mard.p09.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Persistent class for entity stored in table "TBDCSSXSP09"
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@Table(name = "TBDCSSXSP09", schema = "MARD")
@NamedQueries({
        @NamedQuery(name = "Tbdcssxsp09.countAll", query = "SELECT COUNT(x) FROM Tbdcssxsp09 x")
})
public class Tbdcssxsp09 implements Serializable {
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_MFR", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDCSSXSP09_SEQ")
    @SequenceGenerator(sequenceName = "TBDCSSXSP09_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDCSSXSP09_SEQ")
    private Long fiIdMfr;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name = "FI_HS_ID")
    private Long fiIdHS;

    @Column(name = "FI_MFR_NAME", length = 250)
    private String fiCompanyName;

    @Column(name = "FI_MFR_ADDRESS", length = 500)
    private String fiCompanyAddress;
}
