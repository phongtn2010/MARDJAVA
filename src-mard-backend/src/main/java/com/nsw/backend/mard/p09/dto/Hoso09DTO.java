package com.nsw.backend.mard.p09.dto;

import com.nsw.backend.mard.p09.model.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Hoso09DTO extends Base09DTO {

    // Thong tin ho so
    private Long fiIdHS;
    private Long fiHSType;
    private Long fiProductType;
    private String fiHSCode;
    private String fiModifyReason;
    private Date fiHSCreatedDate;

    private String fiRegistrationNo;
    private String fiNameOfRegistration;
    private String fiAddressOfRegistration;
    private String fiFax;
    private String fiPhone;
    private String fiEmail;

    private String fiQuarantineDepartmentCode;
    private String fiQuarantineDepartmentName;
    private String fiMonitoringDepartmentCode;
    private String fiMonitoringDepartmentName;

    //Thong tin mau 20A
    private Tbdbenmua09 fiBuyer;

    private String fiStorageLocation;
    private Date fiImportingDateFrom;
    private Date fiImportingDateTo;

    private String fiSamplingLocation;
    private Date fiSamplingDateFrom;
    private Date fiSamplingDateTo;

    private String fiContactName;
    private String fiContactAddress;
    private String fiContactTel;

    private List<Tbdbenban09> lstSeller;

    //Thong tin mau 3
    private String fiBillOfLadingNo;
    private Date fiBillOfLadingIssuedDate;
    private String fiQuarantineName;
    private Date fiQuarantineTimeFrom;
    private Date fiQuarantineTimeTo;

    private String fiExportPortDestCode;
    private String fiExportPortDestName;

    private String fiExportCountryCode;

    private String fiImportCountryCode;
    private String fiImportCountryName;
    private String fiTransportType;

    private String fiMonitoringLocName;
    private Date fiMonitoringLocTimeFrom;
    private Date fiMonitoringLocTimeTo;

    private String fiCertificateQuantity;
    private String fiContractNo;

    private String fiImportContactPerson;
    private String fiExportContactPerson;

    private List<Tbdddclkd09> lstIsolatedLocation;
    // End mau 3

    private Long fiHSStatus;
    private Long fiKDStatus;
    private Long fiGSStatus;

    private String fiTaxCode;

    private String fiPurpose;
    private String fiAccQuarantineDoc;
    private String fiProvidedDocument;

    private String fiSigningLocation;
    private Date fiSignedDate;
    private String fiSignedBy;
    private String fiSignedByTitle;
    // End

    private List<Tbdcssxsp09> lstProdMfr;
    private List<Tbdctyxk09> lstExporter;
    private List<Tbdhanghoa09> lstGood;
    private List<Tbdgiayto09> lstDocument;

    private List<Tbddinhkem09> lstAtch;

    public Hoso09DTO() {
        lstAtch = new ArrayList<>();
        lstDocument = new ArrayList<>();
        lstExporter = new ArrayList<>();
        lstIsolatedLocation = new ArrayList<>();
        lstProdMfr = new ArrayList<>();
        lstGood = new ArrayList<>();
        lstSeller = new ArrayList<>();
    }
}
