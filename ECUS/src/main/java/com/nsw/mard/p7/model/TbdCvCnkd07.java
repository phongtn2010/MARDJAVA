package com.nsw.mard.p7.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Persistent class for entity stored in table "TBDCVCNKD07" - Giấy chứng nhận kiểm dịch
 *
 * @author Telosys Tools Generator
 */
@Data
public class TbdCvCnkd07 extends CmonBaseEntity implements Serializable {

    private Integer fiIdCV;

    private String fiNSWFileCode;

    private String fiCertificateNo;

    private String fiNameOfRegistration;

    private String fiAddressOfRegistration;

    private String fiPhoneOfRegistration;

    private String fiFaxOfRegistration;

    private String fiEmailOfRegistration;

    private String fiNumberOfRegistration;

    private Double fiTotalQuantityOrWeight;

    private String fiTotalUnitCode;

    private String fiTotalUnitName;

    private String fiPurposeUse;

    private String fiPackage;

    private Integer fiQuantityPackage;

    private String fiNameOfExporter;

    private String fiAddressOfExporter;

    private String fiNameOfProduce;

    private String fiAddressOfProduce;

    private String fiOriginationExport;

    private String fiOriginationTransit;

    private String fiPortOfDestinationCode;

    private String fiPortOfDestinationName;

    private Date fiImportDate;

    private String fiDocumentAttch;

    private String fiLocationOfQuarantine;

    private Date fiDateOfQuarantineFrom;

    private Date fiDateOfQuarantineTo;

    private String fiTestResultNo;

    private Date fiDateOfTestResult;

    private String fiDepartmentOfTestResult;

    private String fiMeetRequirements;

    private String fiNameOfAntiseptic;

    private String fiConcentrationOfAntiseptic;

    private Date fiExpireDate;

    private Integer fiNoExpireDate;

    private String fiCreaterName;

    private String fiSignConfirmDate;

    private String fiSignConfirmName;

    private String fiSignConfirmTitle;

    private String fiSignConfirmAddress;

    private String fiDepartmentLisenceName;

    private String fiLinkFile;

    private Integer fiEditStatus;

    private String fiIncludeCertificateItems;

    private List<TbdCvCnkdHh07> fiGoodsList;

    public TbdCvCnkd07() {
        super();
        fiGoodsList = new ArrayList<>();
    }
}
