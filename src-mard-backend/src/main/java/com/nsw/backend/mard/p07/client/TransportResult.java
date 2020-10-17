package com.nsw.backend.mard.p07.client;

import com.nsw.backend.mard.p07.dto.Goods;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TransportResult {
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
    private Date fiImportDate;
    private String fiDocumentAttch;
    private String fiHealthSituation;
    private String fiNameOfAntiseptic;
    private String fiConcentrationOfAntiseptic;
    private String fiNameOfTransfer;
    private String fiAddressOfTransfer;
    private String fiRouteOfTransfer;
    private Date fiDeadlineOfTransfer;
    private Date fiExpireDate;
    private String fiCreaterName;
    private Date fiSignConfirmDate;
    private String fiSignConfirmName;
    private String fiSignConfirmTitle;
    private String fiSignConfirmAddress;
    private String fiDepartmentLisenceName;
    private String fiLinkFile;
    private String fiParentDepartmentName;

    private List<Goods> fiGoodsList;

    public TransportResult() {
        super();
        fiGoodsList = new ArrayList<>();
    }
}
