/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.backend.mard.p06.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Persistent class for entity stored in table "TbdHoso06" - Hồ sơ Đăng ký
 *
 * @author Telosys Tools Generator
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "TBDHOSO06", schema = "MARD")
public class TbdHoso06 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHOSO06_SEQ";

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Integer fiIdHS;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    //Thong tin ho so
    @Column(name = "FI_HS_CODE", length = 50)
    private String fiNSWFileCode;

    @Column(name = "FI_HS_TYPE", nullable = false)
    private Integer fiHSType = 1;

    @Column(name = "FI_HS_STATUS")
    private Integer fiHSStatus;

    @Column(name = "FI_ACTIVE_STATUS")
    private boolean fiActive = true;

    @Column(name = "FI_TAXCODE", length = 13)
    private String fiTaxCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_HS_CREATED_DATE")
    private Date fiHSCreatedDate;

    @Column(name = "FI_CONFIRMATION_NO", length = 50)
    private String fiConfirmationNo;

    //Thông tin đăng ký
    @Column(name = "FI_IMPORTER_NAME", nullable = false, length = 250)
    private String fiImporterName;

    @Column(name = "FI_IMPORTER_ADDRESS", nullable = false, length = 500)
    private String fiImporterAddress;

    @Column(name = "FI_IMPORTER_TEL", nullable = false, length = 15)
    private String fiImporterTel;

    @Column(name = "FI_IMPORTER_FAX", length = 15)
    private String fiImporterFax;

    @Column(name = "FI_IMPORTER_EMAIL", nullable = false, length = 250)
    private String fiImporterEmail;

    @Column(name = "FI_BORDERGATE_NAME")
    private String fiBordergateName;

    @Column(name = "FI_PURPOSE")
    private String fiPurpose;

    @Column(name = "FI_RELATED_DOCUMENTS")
    private String fiRelatedDocuments;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_TIME_QUARANTINE_FR")
    private Date fiTimeQuarantineFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_TIME_QUARANTINE_TO")
    private Date fiTimeQuarantineTo;

    @Column(name = "FI_TIME_QUARANTINE")
    private String fiTimeQuarantine;

    @Column(name = "FI_LICENSE_NO")
    private String fiLicenseNo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_LICENSED_DATE")
    private Date fiLicensedDate;

    @Column(name = "FI_SIGN_ADDRESS", nullable = false, length = 250)
    private String fiSignAddress;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_SIGN_DATE", nullable = false)
    private Date fiSignDate;

    @Column(name = "FI_SIGN_NAME", nullable = false, length = 250)
    private String fiSignName;

    @Column(name = "FI_SIGN_POSITION", nullable = false, length = 250)
    private String fiSignPosition;

    //Các field phục vụ yêu cầu sửa.

    @Column(name = "FI_MODIFY_REASON", length = 250)
    private String fiReason;

    @Column(name = "FI_REQUEST_DATE")
    private String fiRequestDate;

    @Column(name = "FI_HS_ID_PARENT")
    private Integer fiIdHSParent;

    //Danh sách thông tin kèm theo
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<TbdHanghoa06> fiProductList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<TbdCtyxk06> fiExporterCountryList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<TbdCssx06> fiProcessingList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<TbdDdclkd06> fiLocationQuarantineList;

    // Dinh kem
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<TbdDinhkem06> fiAttachmentList;

    @Transient
    private String fiCertNo;

    public TbdHoso06() {
        super();
        fiProductList = new ArrayList<>();
        fiExporterCountryList = new ArrayList<>();
        fiProcessingList = new ArrayList<>();
        fiLocationQuarantineList = new ArrayList<>();
        fiAttachmentList = new ArrayList<>();
    }
}
