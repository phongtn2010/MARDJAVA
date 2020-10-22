package com.vnsw.ws.p25.message.send;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p25.entity.*;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "AniFeed")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Hoso25 {
    @XmlElement(name = "NSWFileCode")
    String fiNSWFileCode;

    @XmlElement(name = "NSWFileCodeOld")
    String fiNSWFileCodeOld;

    @XmlElement(name = "AniFeedConfirmOldNo")
    String fiGDK;

    @XmlElement(name = "AniFeedConfirmOldId")
    String fiGDKId;

    @XmlElement(name = "AniFeedConfirmOldName")
    String fiGDKName;

    @XmlElement(name = "AniFeedConfirmOldFileLink")
    String fiGDKLink;

    @XmlElement(name = "DepartmentCode")
    String DepartmentCode;

    @XmlElement(name = "DepartmentName")
    String DepartmentName;
    @XmlElement(name = "Seller")
    String fiSellName;
    @XmlElement(name = "SellerState")
    String fiSellCountryName;
    @XmlElement(name = "NameSellerState")
    String fiSellCountryCode;
    @XmlElement(name = "SellerAddress")
    String fiSellAddress;
    @XmlElement(name = "SellerPhone")
    String fiSellTel;
    @XmlElement(name = "SellerFax")
    String fiSellFax;
    @XmlElement(name = "PortOfDepartureName")
    String fiSellExport;

    @XmlElement(name = "Buyer")
    String fiPurchName;
    @XmlElement(name = "BuyerAddress")
    String fiPurchAddress;
    @XmlElement(name = "BuyerPhone")
    String fiPurchTel;
    @XmlElement(name = "BuyerFax")
    String fiPurchFax;
    @XmlElement(name = "PortOfDestinationName")
    String fiPurchReci;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ImportingFromDate")
    Date fiPurchFromDate;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ImportingToDate")
    Date fiPurchToDate;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "CreateDate")
    Date fiHSCreatedDate;
    @XmlElement(name = "SignPlace")
    String fiSignAddress;
    @XmlElement(name = "SignName")
    String fiSignName;
    @XmlElement(name = "TaxCode")
    String fiTaxCode;
    @XmlElement(name = "TypeAniFeed")
    String fiHSType;
//
//    @XmlElement(name = "ImporterName")
//    String fiImporterName;
//    @XmlElement(name = "ImporterTel")
//    String fiImporterTel;
//    @XmlElement(name = "ImporterAddress")
//    String fiImporterAddress;
//    @XmlElement(name = "ImporterEmail")
//    String fiImporterEmail;


    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Product")
    List<Product> fiProductList;

    @XmlElement(name = "LocationOfStorage")
    private String fiAddressGath;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfSamplingFrom")
    private Date fiRegSamFromDate;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfSamplingTo")
    private Date fiRegSamToDate;
    @XmlElement(name = "LocationOfSampling")
    private String fiAddressRegSample;
    @XmlElement(name = "ContactPerson")
    private String fiContactName;
    @XmlElement(name = "ContactAddress")
    private String fiContactAddress;
    @XmlElement(name = "ContactTel")
    private String fiContactTel;
    @XmlElement(name = "ContactEmail")
    private String fiContactEmail;

    @XmlElementWrapper(name = "ContractList")
    @XmlElement(name = "Contract")
    private List<Tbdattach25> fiListAttch;
    @XmlElementWrapper(name = "InvoiceList")
    @XmlElement(name = "Invoice")
    private List<TbdattachHoadon25> fiListAttchHoaDon;
    @XmlElementWrapper(name = "AttachmentList")
    @XmlElement(name = "Attachment")
    private List<TbdattachHd25> fiListAttchHD;
    @XmlElementWrapper(name = "PackingList")
    @XmlElement(name = "Packing")
    private List<TbdattachDg25> fiListAttchPhieu;
}
