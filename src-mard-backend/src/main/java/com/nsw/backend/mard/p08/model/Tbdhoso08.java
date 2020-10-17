package com.nsw.backend.mard.p08.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "TBDHOSO08", schema = "MARD")
public class Tbdhoso08 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_HOSO", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDHOSO08_SEQ")
    @SequenceGenerator(sequenceName = "TBDHOSO08_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDHOSO08_SEQ")
    private Long fiIdHS;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    //Thong tin ho so
    @Column(name = "FI_HS_CODE", length = 50)
    private String fiHSCode;

    @Column(name = "FI_HS_TYPE", nullable = false)
    private Long fiHSType = 1L;

    @Column(name = "FI_HS_STATUS")
    private Long fiHSStatus;

    @Column(name = "FI_ACTIVE_STATUS")
    private boolean fiActive = true;

    @Column(name = "FI_TAXCODE", nullable = false, length = 13)
    private String fiTaxCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_HS_CREATED_DATE")
    private Date fiHSCreatedDate;

    //Thong tin ca nhan, to chuc dang ky
    @Column(name = "FI_CONFIRMATION_NO", length = 50)
    private String fiConfirmationNo;

    @Column(name = "FI_IMPORTER_NAME", nullable = false, length = 250)
    private String fiImporterName;

    @Column(name = "FI_IMPORTER_ADDRESS", nullable = false, length = 500)
    private String fiImporterAddress;

    @Column(name = "FI_IMPORTER_TEL", length = 15)
    private String fiImporterTel;

    @Column(name = "FI_IMPORTER_FAX", length = 15)
    private String fiImporterFax;

    @Column(name = "FI_IMPORTER_EMAIL", length = 250)
    private String fiImporterEmail;

    @Column(name = "FI_ANIMAL_FARM")
    private String fiAnimalFarm;

    @Column(name = "FI_ANIMAL_FARM_ADDR", length = 500)
    private String fiAnimalFarmAddress;

    @Column(name = "FI_PROCESSING_DATE", length = 500)
    private String fiProcessingDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_PROCESSING_DATE_FR", length = 500)
    private Date fiProcessingDateFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_PROCESSING_DATE_TO", length = 500)
    private Date fiProcessingDateTo;

    @Column(name = "FI_PURPOSE")
    private String fiIntendedPurpose;

    @Column(name = "FI_OTHER_PURPOSE")
    private String fiOtherPurpose;

    @Column(name = "FI_PROVIDED_DOCUMENT", length = 500)
    private String fiProvidedDocument;

    @Column(name = "FI_SIGNING_LOCATION", nullable = false, length = 250)
    private String fiSigningLocation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_SIGNED_DATE", nullable = false)
    private Date fiSignedDate;

    @Column(name = "FI_SIGNED_BY", nullable = false, length = 250)
    private String fiSignedBy;

    @Column(name = "FI_SIGNED_BY_TITLE", nullable = false, length = 250)
    private String fiSignedByTitle;

    @Column(name = "FI_ID_HS_PARENT")
    private Long fiIdHSParent;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_LICENSED_DATE")
    private Date fiLicensedDate;

    @Column(name = "FI_LICENSE_NO", length = 250)
    private String fiLicenseNo;

    @Column(name = "FI_MODIFY_REASON", length = 500)
    private String fiModifyReason;

    //  Dang ky XNCL
    @Column(name = "FI_SRC_PORT_NAME")
    private String fiSrcPortName;

    @Column(name = "FI_DST_PORT_CODE")
    private String fiDstPortName;

    @Column(name = "FI_BUYER_NAME")
    private String fiBuyerName;

    @Column(name = "FI_BUYER_ADDRESS")
    private String fiBuyerAddress;

    @Column(name = "FI_BUYER_TEL", length = 50)
    private String fiBuyerTel;

    @Column(name = "FI_BUYER_FAX", length = 50)
    private String fiBuyerFax;

    @Column(name = "FI_IDENTITY_NUMBER", length = 13)
    private String fiIdentityNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_IDENTITY_DATE", length = 13)
    private Date fiIdentityDate;

    @Column(name = "FI_IDENTITY_PLACE", length = 50)
    private String fiIdentityPlace;

    @Column(name = "FI_BUYER_IDENTITY_NUMBER", length = 13)
    private String fiBuyerIdentityNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_BUYER_IDENTITY_DATE", length = 13)
    private Date fiBuyerIdentityDate;

    @Column(name = "FI_BUYER_IDENTITY_PLACE", length = 50)
    private String fiBuyerIdentityPlace;

    @Column(name = "FI_STORAGE_LOC")
    private String fiStorageLocation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_IMPORTING_DATE_FROM")
    private Date fiImportingDateFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_IMPORTING_DATE_TO")
    private Date fiImportingDateTo;

    @Column(name = "FI_SAMPLING_LOC")
    private String fiSamplingLocation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_SAMPLING_DATE_FROM")
    private Date fiSamplingDateFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_SAMPLING_DATE_TO")
    private Date fiSamplingDateTo;

    @Column(name = "FI_CONTACT_NAME")
    private String fiContactName;

    @Column(name = "FI_CONTACT_ADDRESS")
    private String fiContactAddress;

    @Column(name = "FI_CONTACT_TEL", length = 15)
    private String fiContactTel;

    @Column(name = "FI_CONTACT_EMAIL", length = 50)
    private String fiContactEmail;

    @Column(name = "FI_FOOD_TYPE")
    private Integer fiFoodType;

    @Column(name = "FI_ANIMAL_LICENSE_NO")
    private String fiAnimalLicenseNo;

    @Column(name = "FI_DOC_TYPE")
    private Integer fiDocType;

    @Column(name = "FI_DOC_NUMBER")
    private String fiDocNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_DOC_DATE")
    private Date fiDocDate;

    //Child-list
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<Tbdctyxk08> lstExporter;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<Tbdgiayto08> lstDocument;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<Tbdhanghoa08> lstProduct;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<Tbdddclkd08> lstIsolatedLocation;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<Tbdcssxsp08> lstProdMfr;

    //    Dang ky kiem dich Bot thit xuong
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<Tbdnmsx08> lstMfgFactory;

    // Dinh kem
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_MA_DT")
    private List<Tbddinhkem08> lstAtch;

    public Tbdhoso08() {
        super();
        clearLst();
    }

    private void clearLst() {
        lstExporter = new ArrayList<>();
        lstIsolatedLocation = new ArrayList<>();
        lstProduct = new ArrayList<>();
        lstProdMfr = new ArrayList<>();
        lstMfgFactory = new ArrayList<>();
        lstAtch = new ArrayList<>();
        lstDocument = new ArrayList<>();
    }

    public void initListIfNull() {
        if (lstExporter == null) lstExporter = new ArrayList<>();
        if (lstIsolatedLocation == null) lstIsolatedLocation = new ArrayList<>();
        if (lstProduct == null) lstProduct = new ArrayList<>();
        if (lstProdMfr == null) lstProdMfr = new ArrayList<>();
        if (lstMfgFactory == null) lstMfgFactory = new ArrayList<>();
        if (lstAtch == null) lstAtch = new ArrayList<>();
        if (lstDocument == null) lstDocument = new ArrayList<>();
    }
}
