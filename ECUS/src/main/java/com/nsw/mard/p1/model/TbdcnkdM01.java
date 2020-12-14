package com.nsw.mard.p1.model;

import lombok.Data;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TbdcnkdM01 implements Serializable {
    private Long fiIdCNKDM;

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


    private List<TbdAnimailProductM01> fiAnimalProductList;

    public TbdcnkdM01() {
        this.fiAnimalProductList = new ArrayList<>();
    }
}
