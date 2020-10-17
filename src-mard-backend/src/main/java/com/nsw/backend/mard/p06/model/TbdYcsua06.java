package com.nsw.backend.mard.p06.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Persistent class for entity stored in table "TBYCSUA06" - Yêu cầu sửa Hồ Sơ
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBYCSUA06", schema = "MARD")
public class TbdYcsua06 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBYCSUA06_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiRequestId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name = "FI_HS_ID", nullable = false)
    private Integer fiIdHS;

    @Column(name = "FI_HS_CODE", nullable = false, length = 20)
    private String fiNSWFileCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_REQUESTED_DATE", nullable = false)
    private Date fiRequestedDate;

    @Column(name = "FI_ACTIVE", nullable = false)
    private Integer fiActive;

    @Column(name = "FI_STATUS", nullable = false)
    private Integer fiStatus;

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
    public TbdYcsua06() {
        super();
    }
}
