package com.vnsw.ws.p9.message.send;

import com.vnsw.ws.p9.entity.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Hoso09DTO extends BaseDTO {

    // Thong tin ho so
    private Long fiIdHS;
    private Long fiHSType;
    private String fiHSCode;

    private Long fiProductType;

    // Thong tin ca nhan, to chuc dang ky
    private String fiRegistrationNo;
    private String fiImporterAddress;
    private String fiImporterFax;
    private String fiImporterName;
    private String fiImporterTel;
    private String fiImporterEmail;

    private String fiModifyReason;
    // End thong tin ho so

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private Date fiHSCreatedDate;

    // Mau 20a
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private Buyer fiBuyer;

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Seller> lstSeller;

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private String fiStorageLocation;

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private Date fiSamplingDateFrom;

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private Date fiSamplingDateTo;

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private String fiSamplingLocation;

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private String fiContactName;

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private String fiContactAddress;

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private String fiContactTel;

    // End mau 20a

    // Mau 3

    private Date fiQuarantineTime;

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private String fiIntendedPurpose;

    private String fiExportPortDestCode;

    private String fiExportPortDestName;

    private String fiExportCountryCode;

    private String fiImportCountryCode;

    private String fiImportCountryName;

    private String fiTransportType;

    private String fiMonitoringLocName;

    private Date fiMonitoringLocTime;

    private String fiCertificateQuality;

    private String fiContractNo;

    private String fiImportContactPerson;

    private String fiExportContactPerson;

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private List<LocationQuarantine> lstIsolatedLocation;

    // End mau 3
    private Long fiHSStatus;
    private Long fiKDStatus;
    private Long fiGSStatus;

    private String fiTaxCode;
//    private Date fiHSCreatedDate;
//    private String fiIdentityNumber;
//    private Date fiProcessingDate;

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private String fiAccQuarantineDoc;

    private String fiProvidedDocument;

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private String fiQuarantineDepartmentCode;

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private String fiMonitoringDepartmentCode;

    // Thong tin ky ho so (ca nhan, to chuc)
    private String fiSigningLocation;
    private Date fiSignedDate;
    private String fiSignedBy;
    private String fiSignedByTitle;
    // End



    // List chung

    private List<Manufacture> lstMfgFactory;
    private List<Company> lstExporter;
    private List<Goods> lstProduct;
    private List<Document> lstDocument;

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Attachment> lstAtch;

}

