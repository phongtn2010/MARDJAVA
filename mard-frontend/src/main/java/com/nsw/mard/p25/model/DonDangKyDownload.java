package com.nsw.mard.p25.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DonDangKyDownload {
    private static final long serialVersionUID = 1L;


    private Long fiIdHS;
    private Long fiHSStatus;
    private String fiHSStatusName;
    private Date fiHSCreatedDate;
    private String fiNSWFileCode;
    private String fiNSWFileCodeReplace;
    private String fiGDK;
    private String fiLinkGDK;
    private String fiFileNameGDK;
    private String fiFileIdGDK;
    private String fiHSType;

    private String fiTaxCode;
    private String fiImporterName;
    private String fiImporterAddress;
    private String fiImporterTel;
    private String fiImporterFax;

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

    //    private String fiPurchName;
//    private String fiPurchTel;
//    private String fiPurchAddress;
//    private String fiPurchFax;
    private String fiPurchReci;
    private Date fiPurchFromDate;
    private Date fiPurchToDate;

    private String fiReason;
    private String fiProCVMienGiam;
    private Date fiProCVMienGiamNgay;
    private Integer fiIdDVXL;
    private String fiNameDVXL;

    private List<TbdHanghoa25> fiProductList;

    private List<TbdDinhkem25> fiAttachmentList;
    private List<TbdChiTieuDG25> listChiTieu;
    TbdXacNhanDon25 xacNhanDon;
}
