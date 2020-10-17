package com.nsw.backend.mard.p01.client;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class CertificateChina implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiNSWFileCode;

    private String fiDateHeatProcessing;
    private String fiHealthCertificateNoVni;
    private String fiDepartmentCode;
    private String fiDepartmentNameVni;
    private String fiDepartmentName;
    private String fiAnimalQuarantineOrganizationCode;
    private String fiAnimalQuarantineOrganizationName;
    private String fiExportName;
    private String fiExportAdress;
    private String fiExporterTel;
    private String fiExporterFax;
    private String fiExporterEmail;
    private String fiConsigneeNameAddress;
    private String fiConsigneeTel;
    private String fiConsigneeFax;
    private String fiConsigneeEmail;
    private Integer fiTemperatureProductName;
    private String fiProcessingNameAddress;
    private String fiProcessingNumberRegistration;
    private String fiProcessingTel;
    private String fiProcessingFax;
    private Date fiDateProduct;
    private Date fiDateExpiry;
    private String fiPortShipmentCode;
    private String fiPortShipmentName;
    private Date fiDateDeparture;
    private Integer fiMeansTransportName;
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

    private List<AnimailProductChina> fiAnimalProductList;

}
