/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.backend.mard.p08.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Persistent class for entity stored in table "TBDCVCNKD08"
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@Table(name = "TBDCVCNKD08", schema = "MARD")
public class Tbdcvcnkd08 implements Serializable {
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_CV", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDCVCNKD08_SEQ")
    @SequenceGenerator(sequenceName = "TBDCVCNKD08_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDCVCNKD08_SEQ")
    private Long fiIdCV;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_CORR_HS_CODE", length = 50)
    private String fiHSCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_HS_CREATED_DATE")
    private Date fiHSCreatedDate;

    @Column(name = "FI_QUARANTINE_NO", length = 50)
    private String fiQuarantineNo;

    @Column(name = "FI_DISPATCH_NO", length = 50)
    private String fiDispatchNo;

    @Column(name = "FI_VET_HYGIENE_NO", length = 50)
    private String fiVetHygieneNo;

    @Column(name = "FI_DOC_TYPE")
    private Integer fiQuarantineType;

    @Column(name = "FI_SUMMARY")
    private String fiSummary;

    @Column(name = "FI_PREAMBLE", length = 500)
    private String fiPreamble;

    @Column(name = "FI_REPORT_INFO", length = 500)
    private String fiReportInfo;

    @Column(name = "FI_CONTENT", length = 5000)
    private String fiContent;

    @Column(name = "FI_EXECUTION_TIME", length = 250)
    private String fiExecutionTime;

    @Column(name = "FI_PURPOSE")
    private String fiPurpose;

    @Lob
    @Column(name = "FI_RECIPIENT", length = 5000)
    private String fiRecipient;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_DISPATCH_EXPIRES")
    private Date fiDispatchExpires;

    @Column(name = "FI_SIGN_CONFIRM_ADDRESS", length = 250)
    private String fiSignConfirmAddress;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_SIGN_CONFIRM_DATE")
    private Date fiSignConfirmDate;

    @Column(name = "FI_SIGN_CONFIRM_NAME", nullable = false, length = 250)
    private String fiSignConfirmName;

    @Column(name = "FI_SIGN_CONFIRM_TITLE", length = 250)
    private String fiSignConfirmTitle;

    @Column(name = "FI_EDIT_REASON", length = 250)
    private String fiEditReason;

    @Column(name = "FI_DISPATCH_TYPE")
    private Integer fiDispatchType;

    @Column(name = "FI_LINK_FILE", length = 1000)
    private String fiLinkFile;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_CV_ID")
    private List<Tbdcnkdhanghoa08> lstProduct;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_CV_ID")
    private List<Tbdcnkdctyxk08> lstCompany;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_CV_ID")
    private List<Tbdcnkdnmsx08> lstMfr;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_CV_ID")
    private List<Tbdcnkdddcl08> lstIsoLoc;

    public Tbdcvcnkd08() {
        lstProduct = new ArrayList<>();
        lstCompany = new ArrayList<>();
        lstMfr = new ArrayList<>();
        lstIsoLoc = new ArrayList<>();
    }
}
