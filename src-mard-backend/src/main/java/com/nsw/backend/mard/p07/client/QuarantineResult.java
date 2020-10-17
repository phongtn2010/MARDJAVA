package com.nsw.backend.mard.p07.client;

import com.nsw.backend.dic.model.CmonBaseEntity;
import com.nsw.backend.mard.p07.dto.Goods;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
public class QuarantineResult extends CmonBaseEntity {
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
    private String fiIncludeCertificateItems;
    private String fiCreaterName;
    private Date fiSignConfirmDate;
    private String fiSignConfirmName;
    private String fiSignConfirmTitle;
    private String fiSignConfirmAddress;
    private String fiDepartmentLisenceName;
    private String fiLinkFile;
    private String fiNotesForItemNo1;
    private String fiParentDepartmentName;

    private List<Goods> fiGoodsList;

    public QuarantineResult() {
        super();
        fiGoodsList = new ArrayList<>();
    }
}
