package com.nsw.backend.mard.p01.dto;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RegistrationProfile implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiIdHS;

    private boolean fiActive;

    private String fiNSWFileCode;

    @Size(max = 50)
    private String fiRegistrationNo;

    @Size(max = 50)
    private String fiDepartmentCode;

    @Size(max = 250)
    private String fiDepartmentNameVni;

    @Size(max = 250)
    private String fiDepartmentName;

    @Size(max = 15)
    private String fiTaxCode;

    @Size(max = 250)
    private String fiExporterNameVni;

    @Size(max = 250)
    private String fiExporterName;

    @Size(max = 250)
    private String fiExporterAdressVni;

    @Size(max = 250)
    private String fiExporterAdress;

    @Size(max = 250)
    private String fiIdentityNumber;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fiIdentityIssueDate;

    @Size(max = 250)
    private String fiIdentityIssueAdress;

    @Size(max = 50)
    private String fiExporterTel;

    @Size(max = 50)
    private String fiExporterFax;

    @Size(max = 250)
    private String fiExporterEmail;

    private Integer fiObjectType;

    @Size(max = 1000)
    private String fiTotalAnimalByCharVni;

    @Size(max = 1000)
    private String fifiTotalAnimalByChar;

    @Size(max = 250)
    private String fiDeparturePlaceOfAnimalVni;

    @Size(max = 250)
    private String fiDeparturePlaceOfAnimal;

    @Size(max = 200)
    private String fiAnimalHealthStatus;

    @Size(max = 255)
    private String fiDiseaseSafeName;

    @Size(max = 50)
    private String fiDecisionNo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fiDecisionDate;

    @Size(max = 100)
    private String fiDecisionDepartment;

    @Size(max = 1000)
    private String fiTotalAnimalProductByCharVni;

    @Size(max = 1000)
    private String fiTotalAnimalProductByChar;

    @Size(max = 250)
    private String fiAnimalProductTestNo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fiAnimalProductTestDate;

    @Size(max = 250)
    private String fiAnimalProductTestDepartment;

    private Integer fiTemperatureProductName;

    @Size(max = 500)
    private String fiProcessingNameAddressVni;

    @Size(max = 500)
    private String fiProcessingNameAddress;

    @Size(max = 50)
    private String fiProcessingTel;

    @Size(max = 50)
    private String fiProcessingFax;

    @Size(max = 15)
    private String fiProcessingNumberRegistration;

    @Size(max = 500)
    private String fiSlaughterHouseNameAddressVni;

    @Size(max = 500)
    private String fiSlaughterHouseNameAddress;

    @Size(max = 50)
    private String fiSlaughterHouseTel;

    @Size(max = 50)
    private String fiSlaughterHouseFax;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fiSlaughterHouseDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fiProcesssingDate;

    @Size(max = 50)
    private String fiPortShipmentCode;

    @Size(max = 100)
    private String fiPortShipmentNameVni;

    @Size(max = 100)
    private String fiPortShipmentName;

    @Size(max = 500)
    private String fiImporteNameAddressVni;

    @Size(max = 500)
    private String fiImporteNameAddress;

    @Size(max = 50)
    private String fiImporterTel;

    @Size(max = 50)
    private String fiImporterFax;

    @Size(max = 250)
    private String fiImporterEmail;

    @Size(max = 50)
    private String fiEntryPointCode;

    @Size(max = 250)
    private String fiEntryPointNameVni;

    @Size(max = 250)
    private String fiEntryPointName;

    @Size(max = 5)
    private String fiBorderGateCode;

    @Size(max = 250)
    private String fiBordergateNameVni;

    @Size(max = 250)
    private String fiBordergateName;

    @Size(max = 250)
    private String fiMeansTransportNameVni;

    @Size(max = 250)
    private String fiMeansTransportName;

    @Size(max = 500)
    private String fiContaine;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fiDepartureDateFrom;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fiExpectingDateFrom;

    @Size(max = 50)
    private String fiImporterCountryCode;

    @Size(max = 150)
    private String fiImporterCountryNameVni;

    @Size(max = 150)
    private String fiImporterCountryName;

    @Size(max = 50)
    private String fiTransitCountryCode;

    @Size(max = 150)
    private String fiTransitCountryNameVni;

    @Size(max = 150)
    private String fiTransitCountryName;

    @Size(max = 250)
    private String fiConditionsTransport;

    @Size(max = 500)
    private String fiOtherTransport;

    @Size(max = 500)
    private String fiTransportAttrachFile;

    @Size(max = 500)
    private String fiLocationQuarantineVni;

    @Size(max = 250)
    private String fiLocationQuarantine;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fiTimeQuarantine;

    @Size(max = 5000)
    private String fiHealthCertificateContent;

    @Size(max = 100)
    private String fiSignAddress;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fiSignDate;

    @Size(max = 100)
    private String fiSignName;

    private List<Animal> fiAnimalList;
    private List<Test> fiTestList;
    private List<Vaccin> fiVaccinList;
    private List<AnimailProduct> fiAnimailProductList;
    private List<Attachment> fiAttachmentList;

    public RegistrationProfile() {
        super();
        fiAnimalList = new ArrayList<>();
        fiTestList = new ArrayList<>();
        fiVaccinList = new ArrayList<>();
        fiAnimailProductList = new ArrayList<>();
        fiAttachmentList = new ArrayList<>();
    }
}
