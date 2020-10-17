package com.vnsw.ws.p7.message.receive;


import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.annotations.DoubleSerialization;
import com.vnsw.ws.p7.enitty.Goods;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "QuarantineCertificate")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ChungNhanKiemDich {
    @XmlElement(name = "CertificateNo")
    String fiCertificateNo;

    @XmlElement(name = "NameOfRegistration")
    String fiNameOfRegistration;

    @XmlElement(name = "AddressOfRegistration")
    String fiAddressOfRegistration;

    @XmlElement(name = "PhoneOfRegistration")
    String fiPhoneOfRegistration;

    @XmlElement(name = "FaxOfRegistration")
    String fiFaxOfRegistration;

    @XmlElement(name = "EmailOfRegistration")
    String fiEmailOfRegistration;

    @XmlElement(name = "NumberOfRegistration")
    String fiNumberOfRegistration;

    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods")
    List<Goods> fiGoodsList;

    @XmlJavaTypeAdapter(DoubleSerialization.class)
    @XmlElement(name = "TotalQuantityOrWeight")
    Double fiTotalQuantityOrWeight;

    @XmlElement(name = "TotalUnitCode")
    String fiTotalUnitCode;

    @XmlElement(name = "TotalUnitName")
    String fiTotalUnitName;

    @XmlElement(name = "PurposeUse")
    String fiPurposeUse;

    @XmlElement(name = "Package")
    String fiPackage;

    @XmlElement(name = "QuantityPackage")
    Long fiQuantityPackage;

    @XmlElement(name = "NameOfExporter")
    String fiNameOfExporter;

    @XmlElement(name = "AddressOfExporter")
    String fiAddressOfExporter;

    @XmlElement(name = "NameOfProduce")
    String fiNameOfProduce;

    @XmlElement(name = "AddressOfProduce")
    String fiAddressOfProduce;

    @XmlElement(name = "OriginationExport")
    String fiOriginationExport;

    @XmlElement(name = "OriginationTransit")
    String fiOriginationTransit;

    @XmlElement(name = "PortOfDestinationCode")
    String fiPortOfDestinationCode;

    @XmlElement(name = "PortOfDestinationName")
    String fiPortOfDestinationName;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ImportDate")
    Date fiImportDate;

    @XmlElement(name = "DocumentAttch")
    String fiDocumentAttch;

    @XmlElement(name = "LocationOfQuarantine")
    String fiLocationOfQuarantine;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfQuarantineFrom")
    Date fiDateOfQuarantineFrom;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfQuarantineTo")
    Date fiDateOfQuarantineTo;

    @XmlElement(name = "TestResultNo")
    String fiTestResultNo;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfTestResult")
    Date fiDateOfTestResult;

    @XmlElement(name = "DepartmentOfTestResult")
    String fiDepartmentOfTestResult;

    @XmlElement(name = "MeetRequirements")
    String fiMeetRequirements;

    @XmlElement(name = "NameOfAntiseptic")
    String fiNameOfAntiseptic;

    @XmlElement(name = "ConcentrationOfAntiseptic")
    String fiConcentrationOfAntiseptic;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ExpireDate")
    Date fiExpireDate;

    @XmlElement(name = "NoExpireDate")
    Integer fiNoExpireDate;

    @XmlElement(name = "IncludeCertificateItems")
    private String fiIncludeCertificateItems;

    @XmlElement(name = "CreaterName")
    String fiCreaterName;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    Date fiSignConfirmDate;

    @XmlElement(name = "SignConfirmTitle")
    String fiSignConfirmTitle;

    @XmlElement(name = "SignConfirmName")
    String fiSignConfirmName;

    @XmlElement(name = "SignConfirmAddress")
    String fiSignConfirmAddress;

    @XmlElement(name = "DepartmentLisenceName")
    String fiDepartmentLisenceName;

    @XmlElement(name = "LinkFile")
    String fiLinkFile;

    @XmlElement(name = "ParentDepartmentName")
    String fiParentDepartmentName;

    @XmlElement(name = "NotesForItemNo1")
    private String fiNotesForItemNo1;
}
