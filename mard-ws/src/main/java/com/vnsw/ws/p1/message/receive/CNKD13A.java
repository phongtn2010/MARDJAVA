package com.vnsw.ws.p1.message.receive;

import com.vnsw.ws.p1.entity.receive.Animal;
import com.vnsw.ws.util.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "CertificateForAnimal")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CNKD13A {

    @XmlElement(name = "HealthCertificateNo")
    private String fiHealthCertificateNo;

    @XmlElement(name = "DepartmentParentCode")
    private String fiDepartmentParentCode;

    @XmlElement(name = "DepartmentParentNameVni")
    private String fiDepartmentParentNameVni;

    @XmlElement(name = "DepartmentParentName")
    private String fiDepartmentParentName;

    @XmlElement(name = "DepartmentChildCode")
    private String fiDepartmentChildCode;

    @XmlElement(name = "DepartmentChildNameVni")
    private String fiDepartmentChildNameVni;

    @XmlElement(name = "DepartmentChildName")
    private String fiDepartmentChildName;

    @XmlElement(name = "HealthCertificateForm")
    private String fiHealthCertificateForm;

    @XmlElement(name = "ExporterNameVni")
    private String fiExporterNameVni;

    @XmlElement(name = "ExporterName")
    private String fiExporterName;

    @XmlElement(name = "ExporterAdressVni")
    private String fiExporterAdressVni;

    @XmlElement(name = "ExporterAdress")
    private String fiExporterAdress;

    @XmlElement(name = "ExporterTel")
    private String fiExporterTel;

    @XmlElement(name = "ExporterFax")
    private String fiExporterFax;

    @XmlElement(name = "ExporterEmail")
    private String fiExporterEmail;

    @XmlElement(name = "DeparturePlaceVni")
    private String fiDeparturePlaceVni;

    @XmlElement(name = "DeparturePlace")
    private String fiDeparturePlace;

    @XmlElement(name = "TotalVni")
    private String fiTotalVni;

    @XmlElement(name = "Total")
    private String fiTotal;

    @XmlElement(name = "DestinationCountryCode")
    private String fiDestinationCountryCode;

    @XmlElement(name = "DestinationCountryNameVni")
    private String fiDestinationCountryNameVni;

    @XmlElement(name = "DestinationCountryName")
    private String fiDestinationCountryName;

    @XmlElement(name = "MeansTransportVni")
    private String fiMeansTransportVni;

    @XmlElement(name = "MeansTransport")
    private String fiMeansTransport;

    @XmlElement(name = "ConsigneeNameAddressVni")
    private String fiConsigneeNameAddressVni;

    @XmlElement(name = "ConsigneeNameAddress")
    private String fiConsigneeNameAddress;

    @XmlElement(name = "HealthCertificate")
    private String fiHealthCertificate;

    @XmlElement(name = "HealthCertificateFile")
    private String fiHealthCertificateFile;

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

    @XmlElement(name = "SignResultPlaceVni")
    private String fiSignResultPlaceVni;

    @XmlElement(name = "SignResultPlace")
    private String fiSignResultPlace;

    @XmlElement(name = "SignResultName")
    private String fiSignResultName;

    @XmlElementWrapper(name = "AnimalList")
    @XmlElement(name = "Animal")
    private List<Animal> fiAnimalList;
}
