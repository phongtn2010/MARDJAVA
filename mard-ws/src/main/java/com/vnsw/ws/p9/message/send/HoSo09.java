package com.vnsw.ws.p9.message.send;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p9.entity.*;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "RegistrationProfile")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class HoSo09 extends BaseDTO {

    // Thong tin ho so
    @XmlElement(name = "ProductType")
    private Long fiProductType;


    @XmlElement(name = "RegistrationType")
    private Long fiRegistrationType;

    // Thong tin ca nhan, to chuc dang ky
    @XmlElement(name = "RegistrationNo")
    private String fiRegistrationNo;

    @XmlElement(name = "NameOfRegistration")
    private String fiNameOfRegistration;

    @XmlElement(name = "AddressOfRegistration")
    private String fiAddressOfRegistration;

    @XmlElement(name = "Phone")
    private String fiPhone;

    @XmlElement(name = "Email")
    private String fiEmail;

    @XmlElement(name = "RegistrationConfirmNo")
    private String fiRegistrationConfirmNo;

    @XmlElement(name = "QuarantineDepartmentNameCode")
    private String fiQuarantineDepartmentNameCode;

    @XmlElement(name = "QuarantineDepartmentName")
    private String fiQuarantineDepartmentName;

    @XmlElement(name = "MonitoringDepartmentNameCode")
    private String fiMonitoringDepartmentNameCode;

    @XmlElement(name = "MonitoringDepartmentName")
    private String fiMonitoringDepartmentName;

    @XmlElementWrapper(name = "SellerList")
    @XmlElement(name = "Seller")
    private List<Seller> fiSellerList;

    @XmlElement(name = "BuyerName")
    private String fiBuyerName;

    @XmlElement(name = "BuyerIdentityNo")
    private String fiBuyerIdentityNo;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "BuyerDateOfIdentity")
    private Date fiBuyerDateOfIdentity;

    @XmlElement(name = "BuyerPlaceOfIdentity")
    private String fiBuyerPlaceOfIdentity;

    @XmlElement(name = "BuyerAddress")
    private String fiBuyerAddress;

    @XmlElement(name = "BuyerPhone")
    private String fiBuyerPhone;

    @XmlElement(name = "BuyerFax")
    private String fiBuyerFax;

    @XmlElement(name = "PortOfDestinationCode")
    private String fiPortOfDestinationCode;

    @XmlElement(name = "PortOfDestinationName")
    private String fiPortOfDestinationName;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ImportingDateFrom")
    private Date fiImportingDateFrom;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ImportingDateTo")
    private Date fiImportingDateTo;

    @XmlElement(name = "BillOfLadingNo")
    private String fiBillOfLadingNo;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "BillOfLadingIssuedDate")
    private Date fiBillOfLadingIssuedDate;

    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods")
    private List<GoodsHoso09> fiGoodsList;

    @XmlElementWrapper(name = "CompanyList")
    @XmlElement(name = "Company")
    private List<Company> fiCompanyList;

    @XmlElementWrapper(name = "ManufactureList")
    @XmlElement(name = "Manufacture")
    private List<Manufacture> fiManufactureList;

    @XmlElementWrapper(name = "LocationQuarantineList")
    @XmlElement(name = "LocationQuarantine")
    private List<LocationQuarantine> fiLocationQuarantineList;

    @XmlElement(name = "MealPurpose")
    private String fiMealPurpose;

    @XmlElement(name = "QuarantineNo")
    private String fiQuarantineNo;

    @XmlElement(name = "LocationOfStorage")
    private String fiLocationOfStorage;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfSamplingFrom")
    private Date fiDateOfSamplingFrom;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfSamplingTo")
    private Date fiDateOfSamplingTo;

    @XmlElement(name = "LocationOfSampling")
    private String fiLocationOfSampling;

    @XmlElement(name = "ContactPerson")
    private String fiContactPerson;

    //mau 3
    @XmlElement(name = "QuarantineLocationName")
    private String fiQuarantineName;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "QuarantineTimeFrom")
    private Date fiQuarantineTimeFrom;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "QuarantineTimeTo")
    private Date fiQuarantineTimeTo;

    @XmlElement(name = "QuarantineTime")
    private String fiQuarantineTime;

    @XmlElement(name = "ExportPortOfDestinationName")
    private String fiExportPortOfDestinationName;

    @XmlElement(name = "ExportCountryCode")
    private String fiExportCountryCode;

    @XmlElement(name = "ExportCountryName")
    private String fiExportCountryName;

    @XmlElement(name = "ImportCountryCode")
    private String fiImportCountryCode;

    @XmlElement(name = "ImportCountryName")
    private String fiImportCountryName;

    @XmlElement(name = "TransportType")
    private String fiTransportType;

    @XmlElement(name = "QuarantineNo")
    private String fiDispatchNo;

    @XmlElement(name = "MonitoringLocationName")
    private String fiMonitoringLocationName;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "MonitoringLocationTimeFrom")
    private Date fiMonitoringLocationTimeFrom;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "MonitoringLocationTimeTo")
    private Date fiMonitoringLocationTimeTo;

    @XmlElement(name = "CertificateQuantity")
    private String fiCertificateQuantity;

    @XmlElement(name = "ContractNo")
    private String fiContractNo;

    @XmlElement(name = "ImportContactPerson")
    private String fiImportContactPerson;

    @XmlElement(name = "ExportContactPerson")
    private String fiExportContactPerson;

    //Thong tin ky don

    @XmlElement(name = "SignAddress")
    private String fiSignAddress;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignDate")
    private Date fiSignDate;

    @XmlElement(name = "SignName")
    private String fiSignName;

    @XmlElement(name = "SignPosition")
    private String fiSignPosition;

    @XmlElementWrapper(name = "DocumentList")
    @XmlElement(name = "Document")
    private List<Document> fiDocumentList;

    @XmlElementWrapper(name = "AttachmentList")
    @XmlElement(name = "Attachment")
    private List<Attachment> fiAttachmentList;

    @XmlElement(name = "ImporterAddress")
    private String fiImporterAddress;

    @XmlElement(name = "ImporterFax")
    private String fiImporterFax;

    @XmlElement(name = "ImporterName")
    private String fiImporterName;

    @XmlElement(name = "ImporterTel")
    private String fiImporterTel;

    @XmlElement(name = "ImporterEmail")
    private String fiImporterEmail;


}


