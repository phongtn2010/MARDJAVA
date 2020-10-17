package com.vnsw.ws.p7.message.send;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.annotations.DoubleSerialization;
import com.vnsw.ws.p7.enitty.Attachment;
import com.vnsw.ws.p7.enitty.Goods;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "RegistrationProfile")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class RegistrationProfile {
    @XmlElement(name = "DepartmentofMonitorCode")
    String fiDepartmentofMonitorCode;

    @XmlElement(name = "DepartmentofMonitorName")
    String fiDepartmentofMonitorName;

    @XmlElement(name = "DepartmentofQuarantineCode")
    String fiDepartmentofQuarantineCode;

    @XmlElement(name = "DepartmentofQuarantineName")
    String fiDepartmentofQuarantineName;

    @XmlElement(name = "RegistrationComfirmNo")
    String fiRegistrationComfirmNo;

    @XmlElement(name = "fiNSWFileCode")
    String fiNSWFileCode;

    @XmlElement(name = "DepartmentCode")
    String fiDepartmentCode;

    @XmlElement(name = "DepartmentName")
    String fiDepartmentName;

    @XmlElement(name = "DepartmentAddress")
    String fiDepartmentAddress;

    @XmlElement(name = "DepartmentPhone")
    String fiDepartmentPhone;

    @XmlElement(name = "DepartmentFax")
    String fiDepartmentFax;

    @XmlElement(name = "TaxCode")
    String fiTaxCode;

    @XmlElement(name = "NameOfRegistration")
    String fiNameOfRegistration;

    @XmlElement(name = "AddressOfRegistration")
    String fiAddressOfRegistration;

    @XmlElement(name = "PhoneOfRegistration")
    String fiPhoneOfRegistration;

    @XmlElement(name = "NumberOfRegistration")
    String fiNumberOfRegistration;

    @XmlElement(name = "FaxOfRegistration")
    String fiFaxOfRegistration;

    @XmlElement(name = "EmailOfRegistration")
    String fiEmailOfRegistration;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "IdentityIssueDate")
    Date fiIdentityIssueDate;

    @XmlElement(name = "IdentityIssueAdress")
    String fiIdentityIssueAddress;

    @XmlElement(name = "RequestOption")
    String fiRequestOption;

    @XmlElement(name = "OptionOther")
    String fiOptionOther;

    @XmlElement(name = "IdentityNumber")
    String fiIdentityNumber;

    @XmlElement(name = "Importer")
    String fiExporter;

    @XmlElement(name = "ExporterCountryAddress")
    String fiExporterCountryAddress;

    @XmlElement(name = "ProcessingName")
    String fiProcessingName;

    @XmlElement(name = "ProcessingAddress")
    String fiProcessingAddress;

    @XmlElement(name = "Package")
    String fiPackage;

    @XmlElement(name = "ContractsNo")
    String fiContractsNo;

    @XmlElement(name = "OriginationImport")
    String fiOriginationImport;

    @XmlElement(name = "OriginationTransit")
    String fiOriginationTransit;

    @XmlElement(name = "PortOfDepartureName")
    String fiPortOfDepartureName;

    @XmlElement(name = "PortOfDestinationCode")
    String fiPortOfDestinationCode;

    @XmlElement(name = "PortOfDestinationName")
    String fiPortOfDestinationName;

    @XmlElement(name = "TransportType")
    String fiTransportType;

    @XmlElement(name = "PurposeUse")
    String fiPurposeUse;

    @XmlElement(name = "LicenseNo")
    String fiLicenseNo;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "LicenseDate")
    Date fiLicenseDate;

    @XmlElement(name = "LocationOfQuarantine")
    String fiLocationOfQuarantine;

    @XmlElement(name = "LocationOfGrow")
    String fiLocationOfGrow;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfQuarantineFrom")
    Date fiDateOfQuarantineFrom;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfQuarantineTo")
    Date fiDateOfQuarantineTo;

    @XmlElement(name = "LocationOfMonitor")
    String fiLocationOfMonitor;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfMonitorFrom")
    Date fiDateOfMonitorFrom;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfMonitorTo")
    Date fiDateOfMonitorTo;

    @XmlElement(name = "QuantityLicense")
    Integer fiQuantityLicense;

    @XmlElement(name = "TransshipmentGoods")
    Integer fiTransshipmentGoods;

    @XmlElement(name = "BusinessNumberofRegistration")
    String fiBusinessNumberofRegistration;

    @XmlElement(name = "NameOfRepresentRegistration")
    String fiNameOfRepresentRegistration;

    @XmlJavaTypeAdapter(DoubleSerialization.class)
    @XmlElement(name = "TotalOfGoodsWeight")
    Double fiTotalOfGoodsWeight;

    @XmlElement(name = "TotalOfGoodsWeightUnitCode")
    String fiTotalOfGoodsWeightUnitCode;

    @XmlElement(name = "TotalOfGoodsWeightUnitName")
    String fiTotalOfGoodsWeightUnitName;

    @XmlElement(name = "NameOfFishingShip")
    String fiNameOfFishingShip;

    @XmlElement(name = "CodeOfFishingShip")
    String fiCodeOfFishingShip;

    @XmlElement(name = "OriginationOfFishingShip")
    String fiOriginationOfFishingShip;

    @XmlElement(name = "NameOfTransferShip")
    String fiNameOfTransferShip;

    @XmlElement(name = "CodeOfTransferShip")
    String fiCodeOfTransferShip;

    @XmlElement(name = "OriginationOfTransferShip")
    String fiOriginationOfTransferShip;

    @XmlElement(name = "NameOfContainerShip")
    String fiNameOfContainerShip;

    @XmlElement(name = "CodeOfContainerShip")
    String fiCodeOfContainerShip;

    @XmlElement(name = "OriginationOfContainerShip")
    String fiOriginationOfContainerShip;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "LoadingUnLoadingTimeFrom")
    Date fiLoadingUnLoadingTimeFrom;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "LoadingUnLoadingTimeTo")
    Date fiLoadingUnLoadingTimeTo;

    @XmlElement(name = "LoadingUnloadingPlace")
    String fiLoadingUnloadingPlace;

    @XmlElement(name = "NameOfShip")
    String fiNameOfShip;

    @XmlElement(name = "CodeOfShip")
    String fiCodeOfShip;

    @XmlElement(name = "OriginationOfShip")
    String fiOriginationOfShip;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfCatchFrom")
    Date fiDateOfCatchFrom;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfCatchTo")
    Date fiDateOfCatchTo;

    @XmlElement(name = "LocationOfCatch")
    String fiLocationOfCatch;

    @XmlElement(name = "MethodCatch")
    String fiMethodCatch;

    @XmlElement(name = "SignAddress")
    String fiSignAddress;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignDate")
    Date fiSignDate;

    @XmlElement(name = "SignName")
    String fiSignName;

    @XmlElement(name = "SignPosition")
    String fiSignPosition;

    @XmlElement(name = "QuantityPackage")
    private Long fiQuantityPackage;

    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods")
    List<Goods> fiGoodsList;

    @XmlElementWrapper(name = "AttachmentList")
    @XmlElement(name = "Attachment")
    List<Attachment> fiAttachmentList;


}
