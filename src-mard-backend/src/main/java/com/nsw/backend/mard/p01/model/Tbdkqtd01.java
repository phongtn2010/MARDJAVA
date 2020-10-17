package com.nsw.backend.mard.p01.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDKQTD01", schema = "MARD")
public class Tbdkqtd01 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TTBDKQTD01_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    @Id
    @Column(name = "FI_ID_KQTD", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIdKQTD;

    @Column(name = "FI_ACTIVE", nullable = false)
    private boolean fiActive;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Column(name = "FI_NSW_FILE_CODE", length = 12)
    private String fiNSWFileCode;

    @Column(name = "FI_REASON", length = 2000)
    private String fiReason;

    @Column(name = "FI_CREATER_NAME", length = 250)
    private String fiCreaterName;

    @Column(name = "FI_REGISTATION_CONFIRM_NO", length = 12)
    private String fiRegistationConfirmNo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_REGISTATION_CONFIRM_DATE")
    private Date fiRegistationConfirmDate;

    @Column(name = "FI_CHECK_PLACE", length = 2000)
    private String fiCheckPlace;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_CHECK_TIME")
    private Date fiCheckTime;


}