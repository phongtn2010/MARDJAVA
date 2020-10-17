package com.vnsw.ws.p8.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p8.entity.CompanyKDNK;
import com.vnsw.ws.p8.entity.GoodsKDNK;
import com.vnsw.ws.p8.entity.LocationQuarantine;
import com.vnsw.ws.p8.entity.ManufactureKDNK;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "Quarantine")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CongVanKDNK {
    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;

    @XmlElement(name = "QuarantineNo")
    private String fiQuarantineNo;

    @XmlElement(name = "Summary")
    private String fiSummary;

    @XmlElement(name = "Preamble")
    private String fiPreamble;

    @XmlElement(name = "ReportInfo")
    private String fiReportInfo;

    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods")
    private List<GoodsKDNK> fiGoodsList;

    @XmlElementWrapper(name = "CompanyList")
    @XmlElement(name = "Company")
    private List<CompanyKDNK> fiCompanyList;

    @XmlElementWrapper(name = "ManufactureList")
    @XmlElement(name = "Manufacture")
    private List<ManufactureKDNK> fiManufactureList;

    @XmlElementWrapper(name = "LocationQuarantineList")
    @XmlElement(name = "LocationQuarantine")
    private List<LocationQuarantine> fiLocationQuarantineList;

    @XmlElement(name = "MealExecutionTime")
    private String fiMealExecutionTime;

    @XmlElement(name = "MealPurpose")
    private String fiMealPurpose;

    @XmlElement(name = "ResponseContent")
    private String fiResponseContent;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DispatchExpires")
    private Date fiDispatchExpires;

    @XmlElement(name = "Recipient")
    private String fiRecipient;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    private Date fiSignConfirmDate;

    @XmlElement(name = "SignConfirmName")
    private String fiSignConfirmName;

    @XmlElement(name = "SignConfirmAddress")
    private String fiSignConfirmAddress;

    @XmlElement(name = "SignerRole")
    private String fiSignerRole;

    @XmlElement(name = "ReasonEdit")
    private String fiReasonEdit;

    @XmlElement(name = "ProductType")
    private String fiProductType;
}


