package com.nsw.mard.p7.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Persistent class for entity stored in table "TBDCVCNNV07" - Giấy chứng nhận vận chuyển
 *
 * @author Telosys Tools Generator
 */
@Data
public class TbdCvCnvc07 extends CmonBaseEntity implements Serializable {


    private Integer fiIdCV;

    private String fiNSWFileCode;

    private String fiCertificateNo;

    private String fiNameOfRegistration;

    private String fiAddressOfRegistration;

    private String fiPhoneOfRegistration;

    private String fiFaxOfRegistration;

    private String fiEmailOfRegistration;

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

    private String fiImportDate;

    private String fiDocumentAttch;

    private String fiHealthSituation;

    private String fiNameOfAntiseptic;

    private String fiConcentrationOfAntiseptic;

    private String fiNameOfTransfer;

    private String fiAddressOfTransfer;

    private String fiRouteOfTransfer;

    private String fiDeadlineOfTransfer;

    private String fiExpireDate;

    private String fiCreaterName;

    private String fiSignConfirmDate;

    private String fiSignConfirmName;

    private String fiSignConfirmTitle;

    private String fiSignConfirmAddress;

    private String fiDepartmentLisenceName;

    private String fiParentDepartmentName;

    private String fiLinkFile;

    private Integer fiEditStatus;

    private List<TbdCvCnvcHh07> fiGoodsList;

    public TbdCvCnvc07() {
        super();
        fiGoodsList = new ArrayList<>();
    }
}
