package com.vnsw.ws.p1.message.receive;

import com.vnsw.ws.p1.entity.receive.AnimailProductHKC;
import com.vnsw.ws.util.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "CertificateHongKongChicken")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CNKDHongKongChicken {

    @XmlElement(name = "HealthCertificateNo")
    private String fiHealthCertificateNo;

    @XmlElement(name = "DepartmentCode")
    private String fiDepartmentCode;

    @XmlElement(name = "DepartmentNameVni")
    private String fiDepartmentNameVni;

    @XmlElement(name = "DepartmentName")
    private String fiDepartmentName;

    @XmlElement(name = "ExportName")
    private String fiExportName;

    @XmlElement(name = "ExportAdress")
    private String fiExportAdress;

    @XmlElement(name = "ExporterTel")
    private String fiExporterTel;

    @XmlElement(name = "ExporterFax")
    private String fiExporterFax;

    @XmlElement(name = "ExporterEmail")
    private String fiExporterEmail;

    @XmlElement(name = "ConsigneeNameAddress")
    private String fiConsigneeNameAddress;

    @XmlElement(name = "ConsigneeTel")
    private String fiConsigneeTel;

    @XmlElement(name = "ConsigneeFax")
    private String fiConsigneeFax;

    @XmlElement(name = "ConsigneeEmail")
    private String fiConsigneeEmail;

    @XmlElement(name = "SlaughterHouseNameAddress")
    private String fiSlaughterHouseNameAddress;

    @XmlElement(name = "SlaughterHouseTel")
    private String fiSlaughterHouseTel;

    @XmlElement(name = "SlaughterHouseFax")
    private String fiSlaughterHouseFax;

    @XmlElement(name = "ProcessingNameAddress")
    private String fiProcessingNameAddress;

    @XmlElement(name = "ProcessingTel")
    private String fiProcessingTel;

    @XmlElement(name = "ProcessingFax")
    private String fiProcessingFax;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateSlaughter")
    private Date fiDateSlaughter;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateSProcessing")
    private Date fiDateSProcessing;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateHeatProcessing")
    private Date fiDateHeatProcessing;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateExpiry")
    private Date fiDateExpiry;

    @XmlElement(name = "PortShipmentCode")
    private String fiPortShipmentCode;

    @XmlElement(name = "PortShipmentName")
    private String fiPortShipmentName;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateDeparture")
    private Date fiDateDeparture;

    @XmlElement(name = "MeansTransportName")
    private String fiMeansTransportName;

    @XmlElement(name = "EntryPointCode")
    private String fiEntryPointCode;

    @XmlElement(name = "EntryPointName")
    private String fiEntryPointName;

    @XmlElement(name = "Containe")
    private String fiContaine;

    @XmlElement(name = "HealthCertificate")
    private String fiHealthCertificate;

    @XmlElement(name = "Note")
    private String fiNote;

    @XmlElement(name = "ExpertName")
    private String fiExpertName;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignResultDate")
    private Date fiSignResultDate;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "HealthCertificateEndDate")
    private Date fiHealthCertificateEndDate;

    @XmlElement(name = "SignResultPlace")
    private String fiSignResultPlace;

    @XmlElement(name = "SignResultName")
    private String fiSignResultName;

    @XmlElementWrapper(name = "AnimalProductList")
    @XmlElement(name = "AnimalProduct")
    private List<AnimailProductHKC> fiAnimalProductList;
}
