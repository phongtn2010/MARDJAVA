package com.nsw.backend.mard.p01.client;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class CertificateProductAnimal implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiNSWFileCode;

    private String fiHealthCertificateNo;
    private String fiDepartmentParentCode;
    private String fiDepartmentParentNameVni;
    private String fiDepartmentParentName;
    private String fiDepartmentChildCode;
    private String fiDepartmentChildNameVni;
    private String fiDepartmentChildName;
    private String fiHealthCertificateForm;
    private String fiExporterNameVni;
    private String fiExporterName;
    private String fiExporterAdressVni;
    private String fiExporterAdress;
    private String fiExporterTel;
    private String fiExporterFax;
    private String fiExporterEmail;
    private String fiConsigneeNameAddressVni;
    private String fiConsigneeNameAddress;

    private String fiProcessingNameAddressVni;
    private String fiProcessingNameAddress;
    private String fiProcessingTel;
    private String fiProcessingFax;
    private String fiMeansTransportVni;
    private String fiMeansTransport;
    private String fiHealthCertificate;
    private String fiHealthCertificateFile;
    private String fiNote;
    private String fiExpertName;
    private Date fiSignResultDate;
    private Date fiHealthCertificateEndDate;
    private String fiSignResultPlaceVni;
    private String fiSignResultPlace;
    private String fiSignResultName;
    private String fiLinkFile;

    private List<AnimalProduct> fiAnimalProductList;

}
