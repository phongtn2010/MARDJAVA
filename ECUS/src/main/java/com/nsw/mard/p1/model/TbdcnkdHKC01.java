package com.nsw.mard.p1.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TbdcnkdHKC01 implements Serializable {
    private Long fiIdCNKDHKC;

    private boolean fiActive;

    private String fiNSWFileCode;


    private String fiHealthCertificateNo;

    private String fiDepartmentCode;

    private String fiDepartmentNameVni;

    private String fiDepartmentName;

    private String fiExportName;

    private String fiExportAdress;

    private String fiExporterTel;

    private String fiExporterFax;

    private String fiExporterEmail;

    private String fiConsigneeNameAddress;

    private String fiConsigneeTel;

    private String fiConsigneeFax;

    private String fiConsigneeEmail;

    private String fiSlaughterHouseNameAddress;

    private String fiSlaughterHouseTel;

    private String fiSlaughterHouseFax;

    private String fiProcessingNameAddress;

    private String fiProcessingTel;

    private String fiProcessingFax;

    private Date fiDateSlaughter;

    private Date fiDateSProcessing;

    private Date fiDateHeatProcessing;

    private Date fiDateExpiry;

    private String fiPortShipmentCode;

    private String fiPortShipmentName;

    private Date fiDateDeparture;

    private String fiMeansTransportName;

    private String fiEntryPointCode;

    private String fiEntryPointName;

    private String fiContaine;

    private String fiHealthCertificate;

    private String fiNote;

    private String fiExpertName;

    private Date fiSignResultDate;

    private Date fiHealthCertificateEndDate;

    private String fiSignResultPlace;

    private String fiSignResultName;

    private String fiLinkFile;

    private List<TbdAnimailProductHKC01> fiAnimalProductList;

    public TbdcnkdHKC01() {
        this.fiAnimalProductList = new ArrayList<>();
    }
}
