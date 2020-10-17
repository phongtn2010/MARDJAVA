package com.nsw.backend.mard.p07.dto;

import com.nsw.backend.mard.p07.model.TbdHoso07;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RegistrationProfile {
    private Integer fiIdHS;

    private String fiNSWFileCode;
    private Integer fiHSType = 1;
    private Integer fiHSStatus;
    private Integer fiGSStatus;
    private Integer fiKDStatus;
    private boolean fiActive = true;
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

    //Thông tin đăng ký
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
    private String fiLocationOfGrow;

    private String fiLocationOfQuarantine;
    private Date fiDateOfQuarantineFrom;
    private Date fiDateOfQuarantineTo;

    private String fiLocationOfMonitor;
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

    private String fiNameOfShip;
    private String fiCodeOfShip;
    private String fiOriginationOfShip;

    private Date fiLoadingUnLoadingTimeFrom;
    private Date fiLoadingUnLoadingTimeTo;
    private String fiLoadingUnloadingPlace;

    private Date fiDateOfCatchFrom;
    private Date fiDateOfCatchTo;
    private String fiLocationOfCatch;
    private String fiMethodCatch;

    private String fiSignAddress;
    private Date fiSignDate;
    private String fiSignName;
    private String fiSignPosition;

    private Long fiQuantityPackage;

    private List<AttachmentFile> fiAttachmentList;

    private List<Goods> fiGoodsList;

    private RegistrationProfile() {
        super();
        fiAttachmentList = new ArrayList<>();
    }

    private void clrLst() {
        fiAttachmentList = new ArrayList<>();
        fiGoodsList = new ArrayList<>();
    }

    public static RegistrationProfile parse(TbdHoso07 regProfile) {
        RegistrationProfile dto = new RegistrationProfile();
        BeanUtils.copyProperties(regProfile, dto);
        dto.clrLst();

        regProfile.getFiAttachmentList().forEach(atch -> {
            AttachmentFile dtoAttach = new AttachmentFile();
            BeanUtils.copyProperties(atch, dtoAttach);
            dtoAttach.setFiAttachmentId(atch.getFiGuid());
            dtoAttach.setFiAttachmentTypeCode(atch.getFiFileTypeCode().toString());
            dtoAttach.setFiLinkFile(atch.getFiPath());
            dtoAttach.setFiNameOfAttachment(atch.getFiFileName());
            dto.getFiAttachmentList().add(dtoAttach);
        });
        regProfile.getFiGoodsList().forEach(good -> {
            Goods goods = new Goods();
            BeanUtils.copyProperties(good, goods);
            if (StringUtils.isEmpty(regProfile.getFiLicenseNo())) {
                goods.setFiCodeOfGoods(regProfile.getFiNSWFileCode() + good.getFiIdProduct().toString());
            }
            dto.getFiGoodsList().add(goods);
        });

        return dto;
    }
}
