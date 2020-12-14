package com.nsw.mard.p8.model;

import com.nsw.common.model.json.ResponseJson;
import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@Data
public class Tbdhoso08 implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiIdHS;

    private String fiHSCode;

    private Long fiHSType = 1l;

    private Long fiHSStatus;

    private boolean fiActive = true;

    private String fiTaxCode;

    private Date fiHSCreatedDate;

    private String fiRegistrationNo;

    private String fiImporterName;

    private String fiImporterAddress;

    private String fiImporterTel;

    private String fiImporterFax;

    private String fiImporterEmail;

    private String fiProcessingDate;

    private String fiIntendedPurpose;

    private String fiOtherPurpose;

    private String fiProvidedDocument;

    private String fiSigningLocation;

    private Date fiSignedDate = new Date();

    private String fiSignedBy;

    private String fiSignedByTitle;

    private Long fiIdHSParent;

    private Date fiLicensedDate;

    private String fiLicenseNo;

    private String fiModifyReason;

    private String fiSrcPortName;

    private String fiDstPortName;

    private String fiBuyerName;

    private String fiBuyerAddress;

    private String fiBuyerTel;

    private String fiBuyerFax;

    private String fiBuyerIdentityNumber;

    private Date fiBuyerIdentityDate;

    private String fiBuyerIdentityPlace;

    private String fiIdentityNumber;

    private String fiIdentityDate;

    private String fiIdentityPlace;

    private String fiStorageLocation;

    private Date fiImportingDateFrom;

    private Date fiImportingDateTo;

    private String fiSamplingLocation;

    private Date fiSamplingDateFrom;

    private Date fiSamplingDateTo;

    private String fiContactName;

    private String fiContactAddress;

    private String fiContactTel;

    private String fiContactEmail;

    private Integer fiFoodType;

    private String fiAnimalLicenseNo;

    private Integer fiDocType;

    private String fiDocNumber;

    private String fiAnimalFarm;

    private String fiAnimalFarmAddress;

    private Date fiDocDate;

    private List<Tbdgiayto08> lstDocument;

    private List<Tbdctyxk08> lstExporter;

    private List<Tbdhanghoa08> lstProduct;

    private List<Tbdddclkd08> lstIsolatedLocation;

    private List<Tbdcssxsp08> lstProdMfr;

    private List<Tbdnmsx08> lstMfgFactory;

    private List<Tbddinhkem08> lstAtch;

    public Tbdhoso08() {
        lstExporter = new ArrayList<>();
        lstIsolatedLocation = new ArrayList<>();
        lstProduct = new ArrayList<>();
        lstProdMfr = new ArrayList<>();
        lstMfgFactory = new ArrayList<>();
        lstAtch = new ArrayList<>();
    }

}
