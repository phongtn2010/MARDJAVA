package com.nsw.mard.p9.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Tbdhoso09 extends CmonBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long fiIdHS;

    private Date fiHSCreatedDate;
    private String fiHSCode;
    private Long fiHSType = 1L;
    private Long fiProductType;
    private Long fiHSStatus;
    private Long fiKDStatus;
    private Long fiGSStatus;
    private Long fiPaymentStatus;

    private boolean fiActive = true;
    private String fiModifyReason;
    private String fiRegistrationNo;
    private String fiNameOfRegistration;
    private String fiAddressOfRegistration;
    private String fiPhone;
    private String fiFax;
    private String fiEmail;
    private String fiTaxCode;

    private String fiRegistrationComfirmNo;

    private String fiQuarantineDepartmentCode;
    private String fiQuarantineDepartmentName;
    private String fiMonitoringDepartmentCode;
    private String fiMonitoringDepartmentName;

    private String fiOriginationCode;
    private String fiOriginationName;
    private String fiPurpose;
    private int fiFoodType;
    private String fiManufacture;
    private String fiStorageLocation;
    private Date fiSamplingDateFrom;
    private Date fiSamplingDateTo;
    private String fiSamplingLocation;

    private String fiContactName;
    private String fiContactAddress;
    private String fiContactTel;
    private String fiContactEmail;
    private String fiSigningLocation;
    private Date fiSignedDate;
    private String fiSignedBy;
    private String fiSignedByTitle;

    // mau 3
    private String fiBillOfLadingNo;
    private Date fiBillOfLadingIssuedDate;
    private String fiQuarantineName;
    private String fiQuarantineTime;
    private Date fiQuarantineTimeFrom;
    private Date fiQuarantineTimeTo;

    private String fiExportPortDestCode;
    private String fiExportPortDestName;
    private String fiExportCountryCode;
    private String fiExportCountryName;
    private String fiImportCountryCode;
    private String fiImportCountryName;

    private String fiTransportType;
    private String fiAccQuarantineDoc;
    private String fiMonitoringLocName;
    private Date fiMonitoringLocTimeFrom;
    private Date fiMonitoringLocTimeTo;
    private String fiCertificateQuantity;
    private String fiContractNo;
    private String fiImportContactPerson;
    private String fiExportContactPerson;

    private Integer fiHaveTransport;
    private Integer fiFailXncl;
    private Integer fiFailCnkd;

    private List<Tbdddclkd09> lstIsolatedLocation;
    private List<Tbdctyxk09> lstExporter;
    private List<Tbdcssxsp09> lstProdMfr;
    // het mau 3

    // Giay to
    private List<Tbdgiayto09> lstDocument;

    // Hang hoa
    private List<Tbdhanghoa09> lstGood;
    private List<Tbdbenban09> lstSeller;
    private Tbdbenmua09 fiBuyer;

    private List<Tbddinhkem09> lstAtch;
    private Long fiIdHSParent;

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
