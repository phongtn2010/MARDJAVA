package com.nsw.mard.p1.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Tbdcnkd13b01 implements Serializable {
    private Long fiIdCNKD13B;

    private String fiNSWFileCode;

    private Long fiAttachmentID;

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


    private List<Tbdspdv13b01> fiAnimalProductList;

    public Tbdcnkd13b01() {
        this.fiAnimalProductList = new ArrayList<>();
    }
}
