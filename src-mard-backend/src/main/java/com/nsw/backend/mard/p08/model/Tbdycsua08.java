package com.nsw.backend.mard.p08.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Persistent class for entity stored in table "TBDYCSUA08" - Yêu cầu sửa Hồ Sơ
 *
 * @author Telosys Tools Generator
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "TBDYCSUA08", schema = "MARD")
public class Tbdycsua08 extends CmonBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_YC", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDYCSUA08_SEQ")
    @SequenceGenerator(sequenceName = "TBDYCSUA08_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDYCSUA08_SEQ")
    private Long fiRequestId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name = "FI_ID_HS", nullable = false)
    private Long fiIdHS;

    @Column(name = "FI_HS_CODE", nullable = false, length = 20)
    private String fiHSCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_REQUESTED_DATE", nullable = false)
    private Date fiRequestedDate;

    @Column(name = "FI_ACTIVE", nullable = false)
    private Long fiActive;

    @Column(name = "FI_STATUS", nullable = false)
    private Long fiStatus;

    @Column(name = "FI_REASON", length = 2000)
    private String fiReason;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_PROCESSED_DATE")
    private Date fiProcessedDate;

    @Column(name = "FI_PROCESSING_UNIT", length = 250)
    private String fiProcessingUnit;

    @Column(name = "FI_PROCESSOR", length = 250)
    private String fiProcessor;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbdycsua08() {
        super();
    }
}
