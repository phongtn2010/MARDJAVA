package com.vnsw.ws.p6.message.receive;


import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p6.entity.ExporterCountry;
import com.vnsw.ws.p6.entity.LocationQuarantine;
import com.vnsw.ws.p6.entity.Processing;
import com.vnsw.ws.p6.entity.Product;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "VeterinaryHygiene")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CongVanVSTY {

    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;

    @XmlElement(name = "DispatchNo")
    private String fiDispatchNo;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DispatchDate")
    private Date fiDispatchDate;

    @XmlElement(name = "DispatchAccountable")
    private String fiDispatchAccountable;

    @XmlElement(name = "Summary")
    private String fiSummary;

    @XmlElement(name = "Preamble")
    private String fiPreamble;

    @XmlElement(name = "ReplyNo")
    private String fiReplyNo;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ReplyDate")
    private Date fiReplyDate;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ReplyImporter")
    private Date fiReplyImporter;

    @XmlElement(name = "ProductType")
    private Integer fiProductType;

    @XmlElementWrapper(name = "ProductList")
    @XmlElement(name = "Product")
    private List<Product> fiProductList;

    @XmlElementWrapper(name = "ExporterCountryList")
    @XmlElement(name = "ExporterCountry")
    private List<ExporterCountry> fiExporterCountryList;

    @XmlElementWrapper(name = "ProcessingList")
    @XmlElement(name = "Processing")
    private List<Processing> fiProcessingList;

    @XmlElement(name = "BordergateName")
    private String fiBordergateName;

    @XmlElement(name = "TimeQuarantine")
    private String fiTimeQuarantine;

    @XmlElement(name = "Purpose")
    private String fiPurpose;

    @XmlElementWrapper(name = "LocationQuarantineList")
    @XmlElement(name = "LocationQuarantine")
    private List<LocationQuarantine> fiLocationQuarantineList;

    @XmlElement(name = "ResponseContent")
    private String fiResponseContent;

    @XmlElement(name = "Recipient")
    private String fiRecipient;

    @XmlElement(name = "SignPosition")
    private String fiSignPosition;

    @XmlElement(name = "SignConfirmName")
    private String fiSignConfirmName;

    @XmlElement(name = "SignConfirmAddress")
    private String fiSignConfirmAddress;

    @XmlElement(name = "ReasonEdit")
    private String fiReasonEdit;

    @XmlElement(name = "LinkFile")
    private String fiLinkFile;

}
