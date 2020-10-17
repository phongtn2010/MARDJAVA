package com.nsw.backend.mard.p09.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Persistent class for entity stored in table "TBDDDCLKD09"
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@Table(name = "TBDDDCLKD09", schema = "MARD")
@NamedQueries({
        @NamedQuery(name = "Tbdddclkd09.countAll", query = "SELECT COUNT(x) FROM Tbdddclkd09 x")
})
public class Tbdddclkd09 implements Serializable {
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_COMPANY", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDDDCLKD09_SEQ")
    @SequenceGenerator(sequenceName = "TBDDDCLKD09_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDDDCLKD09_SEQ")
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
