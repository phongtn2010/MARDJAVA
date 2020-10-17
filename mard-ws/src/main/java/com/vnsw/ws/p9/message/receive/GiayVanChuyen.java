package com.vnsw.ws.p9.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p9.entity.Goods;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;


@XmlType(name = "TransportResult")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class GiayVanChuyen {

    @XmlElement(name = "CertificateNo")
    private String fiCertificateNo;

    @XmlElement(name = "NameOfRegistration")
    private String fiNameOfRegistration;

    @XmlElement(name = "AddressOfRegistration")
    private String fiAddressOfRegistration;

    @XmlElement(name = "IdentityNo")
    private String fiIdentityNo;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "IssueDate")
    private Date fiIssueDate;

    @XmlElement(name = "IssuePlace")
    private String  fiIssuePlace;

    @XmlElement(name = "PhoneOfRegistration")
    private String fiPhoneOfRegistration;

    @XmlElement(name = "FaxOfRegistration")
    private String fiFaxOfRegistration;

    @XmlElement(name = "EmailOfRegistration")
    private String fiEmailOfRegistration;

    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods")
    private List<Goods> fiGoodsList;

    @XmlElement(name = "TotalQuantityOrVolumnByText")
    private String fiTotalQuantityOrVolumnByText;

    @XmlElement(name = "NameOfExporter")
    private String fiNameOfExporter;

    @XmlElement(name = "AddressOfExporter")
    private String fiAddressOfExporter;

    @XmlElement(name = "NameOfProduce")
    private String fiNameOfProduce;

    @XmlElement(name = "AddressOfProduce")
    private String fiAddressOfProduce;

    @XmlElement(name = "OriginationExport")
    private String fiOriginationExport;

    @XmlElement(name = "OriginationTransit")
    private String fiOriginationTransit;

    @XmlElement(name = "PortOfDestinationCode")
    private String fiPortOfDestinationCode;

    @XmlElement(name = "PortOfDestinationName")
    private String fiPortOfDestinationName;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ImportDate")
    private Date fiImportDate;

    @XmlElement(name = "PortOfDestinationAddress")
    private String fiPortOfDestinationAddress;

    @XmlElement(name = "OtherItems")
    private String fiOtherItems;

    @XmlElement(name = "DocumentAttach")
    private String fiDocumentAttach;

    @XmlElement(name = "TransportType")
    private String fiTransportType;

    @XmlElement(name = "AnimalOfAntiseptic")
    private String fiAnimalOfAntiseptic;

    @XmlElement(name = "AnimalOfConcentration")
    private String fiAnimalOfConcentration;

    @XmlElement(name = "TransportTypeOfAntiseptic")
    private String fiTransportTypeOfAntiseptic;

    @XmlElement(name = "TransportTypeOfConcentration")
    private String fiTransportTypeOfConcentration;

    @XmlElement(name = "LicensePlate")
    private String fiLicensePlate;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "TransportDate")
    private Date fiTransportDate;

    @XmlElement(name = "TransportPlace")
    private String fiTransportPlace;

    @XmlElement(name = "TransportStreet")
    private String fiTransportStreet;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "EffectiveDate")
    private Date fiEffectiveDate;

    @XmlElement(name = "CreaterName")
    private String fiCreaterName;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    private Date fiSignConfirmDate;

    @XmlElement(name = "SignConfirmName")
    private String fiSignConfirmName;

    @XmlElement(name = "SignConfirmAddress")
    private String fiSignConfirmAddress;

    @XmlElement(name = "DepartmentLisenceName")
    private String fiDepartmentLicenseName;

    @XmlElement(name = "LinkFile")
    private String fiLinkFile;

    @XmlElement(name = "ParentDepartmentName")
    private String fiParentDepartmentName;
}
