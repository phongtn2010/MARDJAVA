package com.nsw.mard.p1.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Tbdhoso01 {
    private Long fiIdHS;

    private String fiNSWFileCode;

    private String fiRegistrationNo;

    private String fiDepartmentCode;

    private String fiDepartmentNameVni;

    private String fiDepartmentName;

    private String fiTaxCode;

    private String fiExporterNameVni;

    private String fiExporterName;

    private String fiExporterAdressVni;

    private String fiExporterAdress;

    private String fiIdentityNumber;

    private Date fiIdentityIssueDate;

    private String fiIdentityIssueAdress;

    private String fiExporterTel;

    private String fiExporterFax;

    private String fiExporterEmail;

    private Integer fiObjectType;

    private String fiTotalAnimalByCharVni;

    private String fiTotalAnimalByChar;

    private String fiDeparturePlaceOfAnimalVni;

    private String fiDeparturePlaceOfAnimal;

    private String fiAnimalHealthStatus;

    private String fiDiseaseSafeName;

    private String fiDecisionNo;

    private Date fiDecisionDate;

    private String fiDecisionDepartment;

    private String fiTotalAnimalProductByCharVni;

    private String fiTotalAnimalProductByChar;

    private String fiAnimalProductTestNo;

    private Date fiAnimalProductTestDate;

    private String fiAnimalProductTestDepartment;

    private Integer fiTemperatureProductName;

    private String fiProcessingNameAddressVni;

    private String fiProcessingNameAddress;

    private String fiProcessingTel;

    private String fiProcessingFax;

    private String fiProcessingNumberRegistration;

    private String fiSlaughterHouseNameAddressVni;

    private String fiSlaughterHouseNameAddress;

    private String fiSlaughterHouseTel;

    private String fiSlaughterHouseFax;

    private Date fiSlaughterHouseDate;

    private Date fiProcesssingDate;

    private String fiPortShipmentCode;

    private String fiPortShipmentNameVni;

    private String fiPortShipmentName;

    private String fiImporteNameAddressVni;

    private String fiImporteNameAddress;

    private String fiImporterTel;

    private String fiImporterFax;

    private String fiImporterEmail;

    private String fiEntryPointCode;

    private String fiEntryPointNameVni;

    private String fiEntryPointName;

    private String fiBorderGateCode;

    private String fiBordergateNameVni;

    private String fiBordergateName;

    private String fiMeansTransportNameVni;

    private String fiMeansTransportName;

    private String fiContaine;

    private Date fiDepartureDateFrom;

    private Date fiExpectingDateFrom;

    private String fiImporterCountryCode;

    private String fiImporterCountryNameVni;

    private String fiImporterCountryName;

    private String fiTransitCountryCode;

    private String fiTransitCountryNameVni;

    private String fiTransitCountryName;

    private String fiConditionsTransport;

    private String fiOtherTransport;

    private String fiTransportAttrachFile;

    private String fiLocationQuarantineVni;

    private String fiLocationQuarantine;

    private Date fiTimeQuarantine;

    private String fiHealthCertificateContent;

    private String fiSignAddress;

    private Date fiSignDate;

    private String fiSignName;

    private String fiCheckPlace;

    private Date fiCheckTime;

    private String fiCreaterName;

    private String fiRegistationConfirmNo;

    private Date fiRegistrationDate;

    private List<Tbddinhkem01> fiAttachmentList;

    private List<TbdTest01> fiTestList;

    private List<TbdAnimalProduct01> fiAnimalProductList;

    private List<TbdVaccin01> fiVaccinList;

    private List<TbdAnimal01> fiAnimalList;

}
