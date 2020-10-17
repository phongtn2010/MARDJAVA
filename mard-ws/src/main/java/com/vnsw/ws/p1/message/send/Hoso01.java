package com.vnsw.ws.p1.message.send;

import com.vnsw.ws.p1.entity.send.*;
import com.vnsw.ws.util.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "RegistrationProfile")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Hoso01 {

    @XmlElement(name = "RegistrationNo")
    private String fiRegistrationNo;

    @XmlElement(name = "DepartmentCode")
    private String fiDepartmentCode;

    @XmlElement(name = "DepartmentNameVni")
    private String fiDepartmentNameVni;

    @XmlElement(name = "DepartmentName")
    private String fiDepartmentName;

    @XmlElement(name = "TaxCode")
    private String fiTaxCode;

    @XmlElement(name = "ExporterNameVni")
    private String fiExporterNameVni;

    @XmlElement(name = "ExporterName")
    private String fiExporterName;

    @XmlElement(name = "ExporterAdressVni")
    private String fiExporterAdressVni;

    @XmlElement(name = "ExporterAdress")
    private String fiExporterAdress;

    @XmlElement(name = "IdentityNumber")
    private String fiIdentityNumber;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "IdentityIssueDate")
    private Date fiIdentityIssueDate;

    @XmlElement(name = "IdentityIssueAdress")
    private String fiIdentityIssueAdress;

    @XmlElement(name = "ExporterTel")
    private String fiExporterTel;

    @XmlElement(name = "ExporterFax")
    private String fiExporterFax;

    @XmlElement(name = "ExporterEmail")
    private String fiExporterEmail;

    @XmlElement(name = "ObjectType")
    private Integer fiObjectType;

    @XmlElement(name = "TotalAnimalByCharVni")
    private String fiTotalAnimalByCharVni;

    @XmlElement(name = "TotalAnimalByChar")
    private String fiTotalAnimalByChar;

    @XmlElement(name = "DeparturePlaceOfAnimalVni")
    private String fiDeparturePlaceOfAnimalVni;

    @XmlElement(name = "DeparturePlaceOfAnimal")
    private String fiDeparturePlaceOfAnimal;

    @XmlElement(name = "AnimalHealthStatus")
    private String fiAnimalHealthStatus;

    @XmlElement(name = "DiseaseSafeName")
    private String fiDiseaseSafeName;

    @XmlElement(name = "DecisionNo")
    private String fiDecisionNo;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DecisionDate")
    private Date fiDecisionDate;

    @XmlElement(name = "DecisionDepartment")
    private String fiDecisionDepartment;

    @XmlElement(name = "TotalAnimalProductByCharVni")
    private String fiTotalAnimalProductByCharVni;

    @XmlElement(name = "TotalAnimalProductByChar")
    private String fiTotalAnimalProductByChar;

    @XmlElement(name = "AnimalProductTestNo")
    private String fiAnimalProductTestNo;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "AnimalProductTestDate")
    private Date fiAnimalProductTestDate;

    @XmlElement(name = "AnimalProductTestDepartment")
    private String fiAnimalProductTestDepartment;

    @XmlElement(name = "TemperatureProductName")
    private Integer fiTemperatureProductName;

    @XmlElement(name = "ProcessingNameAddressVni")
    private String fiProcessingNameAddressVni;

    @XmlElement(name = "ProcessingNameAddress")
    private String fiProcessingNameAddress;

    @XmlElement(name = "ProcessingTel")
    private String fiProcessingTel;

    @XmlElement(name = "ProcessingFax")
    private String fiProcessingFax;

    @XmlElement(name = "ProcessingNumberRegistration")
    private String fiProcessingNumberRegistration;

    @XmlElement(name = "SlaughterHouseNameAddressVni")
    private String fiSlaughterHouseNameAddressVni;

    @XmlElement(name = "SlaughterHouseNameAddress")
    private String fiSlaughterHouseNameAddress;

    @XmlElement(name = "SlaughterHouseTel")
    private String fiSlaughterHouseTel;

    @XmlElement(name = "SlaughterHouseFax")
    private String fiSlaughterHouseFax;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SlaughterHouseDate")
    private Date fiSlaughterHouseDate;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ProcesssingDate")
    private Date fiProcesssingDate;

    @XmlElement(name = "PortShipmentCode")
    private String fiPortShipmentCode;

    @XmlElement(name = "PortShipmentNameVni")
    private String fiPortShipmentNameVni;

    @XmlElement(name = "PortShipmentName")
    private String fiPortShipmentName;

    @XmlElement(name = "ImporteNameAddressVni")
    private String fiImporteNameAddressVni;

    @XmlElement(name = "ImporteNameAddress")
    private String fiImporteNameAddress;

    @XmlElement(name = "ImporterTel")
    private String fiImporterTel;

    @XmlElement(name = "ImporterFax")
    private String fiImporterFax;

    @XmlElement(name = "ImporterEmail")
    private String fiImporterEmail;

    @XmlElement(name = "EntryPointCode")
    private String fiEntryPointCode;

    @XmlElement(name = "EntryPointNameVni")
    private String fiEntryPointNameVni;

    @XmlElement(name = "EntryPointName")
    private String fiEntryPointName;

    @XmlElement(name = "BorderGateCode")
    private String fiBorderGateCode;

    @XmlElement(name = "BordergateNameVni")
    private String fiBordergateNameVni;

    @XmlElement(name = "BordergateName")
    private String fiBordergateName;

    @XmlElement(name = "MeansTransportNameVni")
    private String fiMeansTransportNameVni;

    @XmlElement(name = "MeansTransportName")
    private String fiMeansTransportName;

    @XmlElement(name = "Containe")
    private String fiContaine;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DepartureDateFrom")
    private Date fiDepartureDateFrom;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ExpectingDateFrom")
    private Date fiExpectingDateFrom;

    @XmlElement(name = "ImporterCountryCode")
    private String fiImporterCountryCode;

    @XmlElement(name = "ImporterCountryNameVni")
    private String fiImporterCountryNameVni;

    @XmlElement(name = "ImporterCountryName")
    private String fiImporterCountryName;

    @XmlElement(name = "TransitCountryCode")
    private String fiTransitCountryCode;

    @XmlElement(name = "TransitCountryNameVni")
    private String fiTransitCountryNameVni;

    @XmlElement(name = "TransitCountryName")
    private String fiTransitCountryName;

    @XmlElement(name = "ConditionsTransport")
    private String fiConditionsTransport;

    @XmlElement(name = "OtherTransport")
    private String fiOtherTransport;

    @XmlElement(name = "TransportAttrachFile")
    private String fiTransportAttrachFile;

    @XmlElement(name = "LocationQuarantineVni")
    private String fiLocationQuarantineVni;

    @XmlElement(name = "LocationQuarantine")
    private String fiLocationQuarantine;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "TimeQuarantine")
    private Date fiTimeQuarantine;

    @XmlElement(name = "HealthCertificateContent")
    private String fiHealthCertificateContent;

    @XmlElement(name = "SignAddress")
    private String fiSignAddress;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignDate")
    private Date fiSignDate;

    @XmlElement(name = "SignName")
    private String fiSignName;

    @XmlElementWrapper(name = "AnimalList")
    @XmlElement(name = "Animal")
    private List<Animal> fiAnimalList;

    @XmlElementWrapper(name = "TestList")
    @XmlElement(name = "Test")
    private List<Test> fiTestList;

    @XmlElementWrapper(name = "VaccinList")
    @XmlElement(name = "Vaccin")
    private List<Vaccin> fiVaccinList;

    @XmlElementWrapper(name = "AnimalProductList")
    @XmlElement(name = "AnimalProduct")
    private List<AnimailProduct> fiAnimalProductList;

    @XmlElementWrapper(name = "AttachmentList")
    @XmlElement(name = "Attachment")
    private List<Attachment> fiAttachmentList;
}
