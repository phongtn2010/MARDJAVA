package com.nsw.backend.mard.p01.client;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class CertificateHongKongPig implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fiNSWFileCode;

    private String fiHealthCertificateNoVni;
    private String fiDepartmentCode;
    private String fiDepartmentNameVni;
    private String fiDepartmentName;
    private String fiConsignerName;
    private String fiConsignerAdress;
    private String fiConsigneeNameAddress;

    private String fiSlaughterHouseNameAddress;
    private String fiHealthCertificate;
    private String fiNote;
    private Date fiSignResultDate;
    private Date fiHealthCertificateEndDate;
    private String fiSignResultName;
    private String fiLinkFile;

    private List<AnimalProductHKP> fiAnimalProductList;
}
