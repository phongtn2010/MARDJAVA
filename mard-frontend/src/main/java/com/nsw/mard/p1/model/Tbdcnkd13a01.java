package com.nsw.mard.p1.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Tbdcnkd13a01 implements Serializable {
    private Long fiIdCNKD13A;

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

    private String fiDeparturePlaceVni;

    private String fiDeparturePlace;

    private String fiTotalVni;

    private String fiTotal;

    private String fiDestinationCountryCode;

    private String fiDestinationCountryNameVni;

    private String fiDestinationCountryName;

    private String fiMeansTransportVni;

    private String fiMeansTransport;

    private String fiConsigneeNameAddressVni;

    private String fiConsigneeNameAddress;

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

    private List<Tbddongvat13a01> fiAnimalList;

    public Tbdcnkd13a01() {
        this.fiAnimalList = new ArrayList<>();
    }
}
