package com.nsw.backend.mard.p09.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Persistent class for entity stored in table "TBDDDCLKD09"
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@Table(name = "TBDCVXNCLKD09", schema = "MARD")
public class TbdCnkdKd09 implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String SEQUENCE_NAME = "TBDCVXNCLKD09_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_XNCLKD09", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_NSW_FILE_CODE")
    private String fiNSWFileCode;

    @Column(name = "FI_REQUEST_DATE")
    private Date fiRequestDate;

    @Column(name = "FI_DEPARTMENT")
    private String fiDepartment;

    @Column(name = "FI_CREATER_NAME")
    private String fiCreaterName;

    @Column(name = "FI_DESCRIPTION")
    private String fiDescription;

    @Column(name = "FI_QUALITY_RESULT")
    private String fiQualityResult;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_ID_CVKDKD")
    private List<TbdDkCnkdKd09> fiAttachmentList;

    public TbdCnkdKd09() {
        fiAttachmentList = new ArrayList<>();
    }

}
