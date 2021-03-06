package com.nsw.backend.mard.p09.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Persistent class for entity stored in table "TBDYCRUT09" - Yêu cầu rút Hồ Sơ
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@Table(name = "TBDYCRUT09", schema = "MARD")
public class Tbdycrut09 extends CmonBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_YC", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDYCRUT09_SEQ")
    @SequenceGenerator(sequenceName = "TBDYCRUT09_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDYCRUT09_SEQ")
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

    @Column(name = "FI_REQUEST_TYPE")
    private Long fiRequestType;

    @Column(name = "FI_REASON_MARD", length = 2000)
    private String fiReasonMard;

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
    public Tbdycrut09() {
        super();
    }

}
