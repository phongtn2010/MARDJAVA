package com.nsw.backend.mard.p09.dto.receive;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class TransportResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer fiEditStatus;

    private String fiNSWFileCode;
    private String fiCertificateNo;
    private String fiNameOfRegistration;
    private String fiAddressOfRegistration;
    private String fiIdentityNo;
    private Date fiIssueDate;
    private String fiIssuePlace;
    private String fiPhoneOfRegistration;
    private String fiFaxOfRegistration;
    private String fiEmailOfRegistration;

    private float fiTotalQuantityOrVolumn;
    private String fiTotalQuantityOrVolumnByText;
    private String fiNameOfExporter;
    private String fiAddressOfExporter;
    private String fiOriginationExport;
    private String fiOriginationTransit;
    private String fiPortOfDestinationName;
    private Date fiImportDate;
    private String fiPortOfDestinationAddress;
    private String fiOtherItems;
    private String fiDocumentAttach;
    private String fiTransportType;
    private String fiLicensePlate;
    private String fiAnimalOfAntiseptic;
    private String fiAnimalOfConcentration;
    private String fiTransportTypeOfAntiseptic;
    private String fiTransportTypeOfConcentration;
    private Date fiTransportDate;
    private String fiTransportPlace;
    private String fiTransportStreet;
    private Date fiEffectiveDate;
    private String fiCreaterName;
    private Date fiSignConfirmDate;
    private String fiSignConfirmName;
    private String fiSignConfirmAddress;
    private String fiDepartmentLicenseName;
    private String fiLinkFile;

    private String fiParentDepartmentName;

    private List<Goods> fiGoodsList;
}
