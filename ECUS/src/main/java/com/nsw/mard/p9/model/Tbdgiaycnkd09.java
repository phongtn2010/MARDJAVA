package com.nsw.mard.p9.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Tbdgiaycnkd09 implements Serializable {
    private Long fiIdQuarantineCer;

    private Long fiIdHS;

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

    private Double fiTotalQuantityOrVolumn;

    private String fiTotalQuantityOrVolumnByText;

    private String fiNameOfExporter;

    private String fiAddressOfExporter;

    private String fiNameOfProduce;

    private String fiAddressOfProduce;

    private String fiOriginationExport;

    private String fiOriginationTransit;

    private String fiPortOfDestinationName;

    private Date fiImportDate;

    private String fiPortOfDestinationAddress;

    private String fiOtherItems;

    private String fiDocumentAttach;

    private String fiTransportType;

    private String fiAnimalOfAntiseptic;

    private String fiAnimalOfConcentration;

    private String fiTransportTypeOfAntiseptic;

    private String fiTransportTypeOfConcentration;

    private Date fiEffectiveDate;

    private String fiCreaterName;

    private Date fiSignConfirmDate;

    private String fiSignConfirmName;

    private String fiSignConfirmAddress;

    private String fiDepartmentLicenseName;

    private Integer fiEditStatus;

    private String fiLinkFile;

    private List<TbdCnkdHh09> lstGood;

    private List<Tbdtiemphong09> lstImmunes;

    public Tbdgiaycnkd09() {
        super();
        lstGood = new ArrayList<>();
        lstImmunes = new ArrayList<>();
    }

}