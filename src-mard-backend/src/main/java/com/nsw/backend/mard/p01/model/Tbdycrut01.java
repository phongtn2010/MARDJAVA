package com.nsw.backend.mard.p01.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "TBDYCRUT01", schema = "MARD")
public class Tbdycrut01 extends CmonBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDYCRUT01_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_YC_RUT", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiIDYCRUT;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Column(name = "FI_ID_HS", nullable = false)
    private Long fiIdHS;

    @Column(name = "FI_HS_CODE", length = 20)
    private String fiHSCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_REQUESTED_DATE", nullable = false)
    private Date fiRequestedDate;

    @Column(name = "FI_ACTIVE", nullable = false)
    private Long fiActive;

    @Column(name = "FI_STATUS", nullable = false)
    private Long fiStatus;

    @Column(name = "FI_REQUEST_TYPE")
    private Long fiRequestType;

    @Column(name = "FI_NSW_FILE_CODE", length = 50)
    private String fiNSWFileCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_REQUEST_DATE")
    private Date fiRequestDate;

    @Column(name = "FI_REASON", length = 500)
    private String fiReason;

}
