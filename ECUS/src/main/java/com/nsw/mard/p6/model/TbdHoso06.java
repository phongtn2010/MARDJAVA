package com.nsw.mard.p6.model;

import lombok.Data;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class TbdHoso06 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHOSO06_SEQ";

    private Long fiIdHS;

    private String fiNSWFileCode;

    private Long fiHSType = 1l;

    private Long fiHSStatus;

    private boolean fiActive = true;

    private String fiTaxCode;

    private Date fiHSCreatedDate;

    private String fiConfirmationNo;

    private String fiRegistrationNo;

    private String fiImporterName;

    private String fiImporterAddress;

    private String fiImporterTel;

    private String fiImporterFax;

    private String fiImporterEmail;

    private String fiImportPortCode;

    private String fiImportPortName;

    private String fiPurpose;

    private String fiRelatedDocuments;

    private String fiTimeQuarantine;

    private String fiSignAddress;

    private Date fiSignDate;

    private String fiSignName;

    private String fiSignPosition;

    private String fiModifyReason;

    private String fiBordergateName;

    private Long fiIdHSParent;

    private String fiReason;

    private String fiRequestDate;

    private List<TbdHanghoa06> fiProductList;

    private List<TbdCtyxk06> fiExporterCountryList;

    private List<TbdCssx06> fiProcessingList;

    private List<TbdDdclkd06> fiLocationQuarantineList;

    private List<TbdDinhkem06> fiAttachmentList;
}

