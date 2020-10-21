package com.nsw.mard.p25.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class TbdHoso25 implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long fiIdHS;
    private Long fiHSStatus;
    private Date fiHSCreatedDate;
    private String fiNSWFileCode;
    private String fiNSWFileCodeReplace;
    private String fiGDK;

    private String fiTaxCode;
    private String fiImporterName;
    private String fiImporterAddress;
    private String fiImporterTel;
    private String fiImporterFax;
    private String fiImporterEmail;

    private String fiAddressGath;
    private String fiAddressRegSample;
    private Date fiRegSamFromDate;
    private Date fiRegSamToDate;


    private String fiContactName;
    private String fiContactTel;
    private String fiContactAddress;
    private String fiContactEmail;

    private String fiSignName;
    private String fiSignPosition;
    private String fiSignAddress;

    private String fiSellName;
    private String fiSellCountryCode;
    private String fiSellCountryName;
    private String fiSellAddress;
    private String fiSellTel;
    private String fiSellFax;
    private String fiSellExport;

    private String fiPurchName;
    private String fiPurchTel;
    private String fiPurchAddress;
    private String fiPurchFax;
    private String fiPurchReci;
    private String fiPurchFromDate;
    private Date fiPurchToDate;

    private String fiReason;


    private List<TbdHanghoa25> fiProductList;

    private List<Tbdattach25> fiListAttch;

    private List<TbdattachHoadon25> fiListAttchHoaDon;

    private List<TbdattachHd25> fiListAttchHD;

    private List<TbdattachDg25> fiListAttchPhieu;
}
