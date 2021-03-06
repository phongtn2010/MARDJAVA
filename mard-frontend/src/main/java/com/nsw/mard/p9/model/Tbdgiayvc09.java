package com.nsw.mard.p9.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Tbdgiayvc09 implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long fiIdTransportCer;

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

    private String fiTotalQuantityOrVolumn;

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

    private String fiParentDepartmentName;

    private Integer fiEditStatus;

    private String fiLinkFile;

    private List<TbdGvcHh09> lstGood;

    public Tbdgiayvc09() {
        super();
        lstGood = new ArrayList<>();
    }

}
