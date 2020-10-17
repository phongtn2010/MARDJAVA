package com.nsw.mard.p7.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TbdHoso07 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHOSO07_SEQ";

    private Integer fiIdHS;

    private String fiNSWFileCode;

    private Integer fiHSType = 1;

    private Integer fiHSStatus;

    private Integer fiGSStatus;

    private Integer fiKDStatus;

    private boolean fiActive = true;

    private Long fiQuantityPackage;

    private String fiTaxCode;

    private String fiRegistrationComfirmNo;

    private String fiDepartmentofMonitorCode;

    private String fiDepartmentofMonitorName;

    private String fiDepartmentofQuarantineCode;

    private String fiDepartmentofQuarantineName;

    private String fiDepartmentCode;

    private String fiDepartmentName;

    private String fiDepartmentAddress;

    private String fiDepartmentPhone;

    private String fiDepartmentFax;

    private String fiNameOfRegistration;

    private String fiAddressOfRegistration;

    private String fiPhoneOfRegistration;

    private String fiNumberOfRegistration;

    private String fiFaxOfRegistration;

    private String fiEmailOfRegistration;

    private String fiIdentityNumber;

    private Date fiIdentityIssueDate;

    private String fiIdentityIssueAddress;

    private String fiRequestOption;

    private String fiOptionOther;

    private String fiExporter;

    private String fiExporterCountryAddress;

    private String fiProcessingName;

    private String fiProcessingAddress;

    private String fiPackage;

    private String fiContractsNo;

    private String fiOriginationImport;

    private String fiOriginationTransit;

    private String fiPortOfDepartureName;

    private String fiPortOfDestinationName;

    private String fiTransportType;

    private String fiPurposeUse;

    private String fiLicenseNo;

    private Date fiLicenseDate;

    private String fiLocationOfQuarantine;

    private String fiLocationOfGrow;

    private String fiLocationOfMonitor;

    private Date fiDateOfQuarantineFrom;

    private Date fiDateOfQuarantineTo;

    private Date fiDateOfMonitorFrom;

    private Date fiDateOfMonitorTo;

    private Integer fiQuantityLicense;

    private Integer fiTransshipmentGoods;

    private String fiBusinessNumberofRegistration;

    private String fiNameOfRepresentRegistration;

    private Double fiTotalOfGoodsWeight;

    private String fiTotalOfGoodsWeightUnitCode;

    private String fiTotalOfGoodsWeightUnitName;

    private String fiNameOfFishingShip;

    private String fiCodeOfFishingShip;

    private String fiOriginationOfFishingShip;

    private String fiNameOfTransferShip;

    private String fiCodeOfTransferShip;

    private String fiOriginationOfTransferShip;

    private String fiNameOfContainerShip;

    private String fiCodeOfContainerShip;

    private String fiOriginationOfContainerShip;

    private Date fiLoadingUnLoadingTimeFrom;

    private Date fiLoadingUnLoadingTimeTo;

    private String fiLoadingUnloadingPlace;

    private Date fiDateOfCatchFrom;

    private Date fiDateOfCatchTo;

    private String fiLocationOfCatch;

    private String fiMethodCatch;

    private String fiSignAddress;

    private Date fiSignDate = new Date();

    private String fiSignName;

    private String fiSignPosition;

    private String fiModifyReason;

    private List<TbdHanghoa07> fiGoodsList;

    private List<TbdDinhkem07> fiAttachmentList;

    private TbdXacnhan07 fiRegistrationConfirm;

    public TbdHoso07() {
        fiAttachmentList = new ArrayList<>();
    }
}
