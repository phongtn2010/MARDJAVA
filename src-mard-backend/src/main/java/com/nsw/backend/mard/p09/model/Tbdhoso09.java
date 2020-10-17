package com.nsw.backend.mard.p09.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nsw.backend.dic.model.CmonBaseEntity;
import com.nsw.backend.mard.p09.dto.Hoso09DTO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "TBDHOSO09", schema = "MARD")
@NamedQueries({
        @NamedQuery(name = "Tbdhoso09.countAll", query = "SELECT COUNT(x) FROM Tbdhoso09 x")
})
public class Tbdhoso09 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_HOSO", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDHOSO09_SEQ")
    @SequenceGenerator(sequenceName = "TBDHOSO09_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDHOSO09_SEQ")
    private Long fiIdHS;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_HS_CREATED_DATE")
    private Date fiHSCreatedDate;

    //Thong tin ho so
    @Column(name = "FI_HS_CODE", length = 50)
    private String fiHSCode;

    @Column(name = "FI_HS_TYPE", nullable = false)
    private Long fiHSType = 1L;

    @Column(name = "FI_PRODUCT_TYPE", nullable = false)
    private Long fiProductType;

    @Column(name = "FI_HS_STATUS")
    private Long fiHSStatus;

    @Column(name = "FI_KD_STATUS")
    private Long fiKDStatus;

    @Column(name = "FI_GS_STATUS")
    private Long fiGSStatus;

    @Column(name = "FI_PAYMENT_STATUS")
    private Long fiPaymentStatus;

    @Column(name = "FI_ACTIVE_STATUS")
    private boolean fiActive = true;

    @Column(name = "FI_MODIFY_REASON", length = 500)
    private String fiModifyReason;

    //Thong tin ca nhan, to chuc dang ky
    @Column(name = "FI_REGISTRATION_NO", length = 50)
    private String fiRegistrationNo;

    @Column(name = "FI_NAME_REGISTRATION", length = 250, nullable = false)
    private String fiNameOfRegistration;

    @Column(name = "FI_ADDRESS_REGISTRATION", length = 500  , nullable = false)
    private String fiAddressOfRegistration;

    @Column(name = "FI_Phone", length = 50)
    private String fiPhone;

    @Column(name = "FI_FAX", length = 50)
    private String fiFax;

    @Column(name = "FI_EMAIL", length = 250)
    private String fiEmail;

    @Column(name = "FI_TAX_CODE", length = 14, nullable = false)
    private String fiTaxCode;

    @Column(name = "FI_REGISTRATION_CONFIRM_NO", length = 50)
    private String fiRegistrationComfirmNo;

    // kiem dich, giam sat
    @Column(name = "FI_QUARANTINE_DPM_NAME_CODE", length = 50)
    private String fiQuarantineDepartmentCode;

    @Column(name = "FI_QUARANTINE_DPM_NAME", length = 250)
    private String fiQuarantineDepartmentName;

    @Column(name = "FI_MONITORING_DPM_NAME_CODE", length = 50)
    private String fiMonitoringDepartmentCode;

    @Column(name = "FI_MONITORING_DPM_NAME", length = 250)
    private String fiMonitoringDepartmentName;

    @Column(name = "FI_ORIGINATION_CODE", length = 50)
    private String fiOriginationCode;

    @Column(name = "FI_ORIGINATION_NAME", length = 250)
    private String fiOriginationName;

    @Column(name = "FI_PURPOSE")
    private String fiPurpose;

    @Column(name = "FI_FOOD_TYPE")
    private int fiFoodType;

    @Column(name = "FI_MANUFACTURE", length = 250)
    private String fiManufacture;

    @Column(name = "FI_STORAGE_LOC")
    private String fiStorageLocation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_SAMPLING_DATE_FROM")
    private Date fiSamplingDateFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_SAMPLING_DATE_TO")
    private Date fiSamplingDateTo;

    @Column(name = "FI_SAMPLING_LOC")
    private String fiSamplingLocation;

    @Column(name = "FI_CONTACT_NAME")
    private String fiContactName;

    @Column(name = "FI_CONTACT_ADDRESS")
    private String fiContactAddress;

    @Column(name = "FI_CONTACT_TEL", length = 15)
    private String fiContactTel;

    @Column(name = "FI_CONTACT_EMAIL", length = 50)
    private String fiContactEmail;

    @Column(name = "FI_SIGNING_LOCATION", length = 250)
    private String fiSigningLocation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_SIGNED_DATE")
    private Date fiSignedDate;

    @Column(name = "FI_SIGNED_BY", length = 250)
    private String fiSignedBy;

    @Column(name = "FI_SIGNED_BY_TITLE", length = 250)
    private String fiSignedByTitle;

    // mau 3
    @Column(name = "FI_BILL_LADING_NO")
    private String fiBillOfLadingNo;

    @Column(name = "FI_BILL_LADING_DATE")
    private Date fiBillOfLadingIssuedDate;

    @Column(name = "FI_QUARANTINE_NAME")
    private String fiQuarantineName;

    @Column(name = "FI_QUARANTINE_TIME")
    private String fiQuarantineTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_QUARANTINE_TIME_FR")
    private Date fiQuarantineTimeFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FI_QUARANTINE_TIME_TO")
    private Date fiQuarantineTimeTo;

    @Column(name = "FI_EX_PORT_DEST_CODE", length = 250)
    private String fiExportPortDestCode;

    @Column(name = "FI_EX_PORT_DEST_NAME", length = 250)
    private String fiExportPortDestName;

    @Column(name = "FI_EX_COUNTRY_CODE", length = 250)
    private String fiExportCountryCode;

    @Column(name = "FI_EX_COUNTRY_NAME", length = 250)
    private String fiExportCountryName;

    @Column(name = "FI_IM_COUNTRY_CODE", length = 250)
    private String fiImportCountryCode;

    @Column(name = "FI_IM_COUNTRY_NAME", length = 250)
    private String fiImportCountryName;

    @Column(name = "FI_TRANSPORT_TYPE", length = 250)
    private String fiTransportType;

    @Column(name = "FI_ACC_QUA_DOC", length = 500)
    private String fiAccQuarantineDoc;

    @Column(name = "FI_MONITORING_LOC_NAME", length = 500)
    private String fiMonitoringLocName;

    @Column(name = "FI_MONITORING_LOC_TIME")
    private Date fiMonitoringLocTimeFrom;

    @Column(name = "FI_MONT_LOC_TIME_TO")
    private Date fiMonitoringLocTimeTo;

    @Column(name = "FI_CERTIFICATE_QTY", length = 15)
    private String fiCertificateQuantity;

    @Column(name = "FI_CONTRACT_NO", length = 250)
    private String fiContractNo;

    @Column(name = "FI_IM_CONTACT_PERSON", length = 250)
    private String fiImportContactPerson;

    @Column(name = "FI_EX_CONTACT_PERSON", length = 250)
    private String fiExportContactPerson;

    @Column(name = "FI_HAVE_TRANSPORT")
    private Integer fiHaveTransport;

    @Column(name = "FI_FAIL_XNCL")
    private Integer fiFailXncl;

    @Column(name = "FI_FAIL_CNKD")
    private Integer fiFailCnkd;

    // Dia diem kiem dich
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<Tbdddclkd09> lstIsolatedLocation;

    // Danh sach cong ty
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<Tbdctyxk09> lstExporter;

    // Danh sach nha may
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<Tbdcssxsp09> lstProdMfr;

    // het mau 3

    // Giay to
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<Tbdgiayto09> lstDocument;

    // Hang hoa
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<Tbdhanghoa09> lstGood;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_HS_ID")
    private List<Tbdbenban09> lstSeller;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FI_ID_BUYER")
    private Tbdbenmua09 fiBuyer;

    // Dinh kem
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_MA_DT")
    private List<Tbddinhkem09> lstAtch;

    @Column(name = "FI_ID_HS_PARENT")
    private Long fiIdHSParent;

    @Transient
    private String fiCertNo;

    public Tbdhoso09() {
        super();
        clearLst();
    }

    private void clearLst() {
        lstSeller = new ArrayList<>();
        lstIsolatedLocation = new ArrayList<>();
        lstExporter = new ArrayList<>();
        lstProdMfr = new ArrayList<>();
        lstDocument = new ArrayList<>();
        lstGood = new ArrayList<>();
        lstAtch = new ArrayList<>();
    }

    public static Tbdhoso09 parse(Hoso09DTO dto) {
        Tbdhoso09 regProfile = new Tbdhoso09();
        BeanUtils.copyProperties(dto, regProfile);
        regProfile.initEmptyCollectionsIfNull();
        return regProfile;
    }

    public void initEmptyCollectionsIfNull() {
        if (this.lstAtch == null) lstAtch = new ArrayList<>();
        if (this.lstDocument == null) lstDocument = new ArrayList<>();
        if (this.lstExporter == null) lstExporter = new ArrayList<>();
        if (this.lstGood == null) lstGood = new ArrayList<>();
        if (this.lstIsolatedLocation == null) lstIsolatedLocation = new ArrayList<>();
        if (this.lstProdMfr == null) lstProdMfr = new ArrayList<>();
        if (this.lstSeller == null) lstSeller = new ArrayList<>();
    }

    @JsonIgnore
    public boolean isParallel() {
        return this.getFiMonitoringDepartmentCode().equals(this.getFiQuarantineDepartmentCode());
    }
}
