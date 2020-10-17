package com.nsw.backend.mard.p08.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Persistent class for entity stored in table "TBDGIAYTO08"
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@Table(name = "TBDGIAYTO08", schema = "MARD")
public class Tbdgiayto08 implements Serializable {
    private static final long serialVersionUID = 1L;
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private static final String SEQUENCE_NAME = "TBDGIAYTO08_SEQ";
    @Id
    @Column(name = "FI_ID_GIAY_TO", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdProduct;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_HS_ID")
    private Long fiIdHS;

    @Column(name = "FI_TYPE_DOC", nullable = false)
    private Long fiTypeDoc;

    @Column(name = "FI_NUMBER", nullable = false, length = 50)
    private String fiNumber;

    @Column(name = "FI_DATE", nullable = false)
    private Date fiDate;
}
