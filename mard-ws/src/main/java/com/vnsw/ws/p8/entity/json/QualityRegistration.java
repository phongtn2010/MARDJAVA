package com.vnsw.ws.p8.entity.json;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p8.entity.Document;
import com.vnsw.ws.p8.entity.Goods;
import com.vnsw.ws.p8.entity.Manufacturer;
import com.vnsw.ws.p8.entity.Seller;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "QualityRegistration ")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class QualityRegistration {
    @XmlElementWrapper(name = "SellerList")
    @XmlElement(name = "Seller")
    private List<Seller> fiSellerList;

    @XmlElement(name = "PortOfDepartureName")
    private String fiPortOfDepartureName;
    @XmlElement(name = "BuyerName")
    private String fiBuyerName;

    @XmlElement(name = "BuyerIdentityNo")
    private String fiBuyerIdentityNo;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "BuyerDateOfIdentityNo")
    private Date fiBuyerDateOfIdentityNo;

    @XmlElement(name = "BuyerPlaceOfIdentityNo")
    private String fiBuyerPlaceOfIdentityNo;

    @XmlElement(name = "BuyerAddress")
    private String fiBuyerAddress;

    @XmlElement(name = "BuyerPhone")
    private String fiBuyerPhone;

    @XmlElement(name = "BuyerFax")
    private String fiBuyerFax;

    @XmlElement(name = "PortOfDestinationCode")
    private String fiPortOfDestinationCode;

    @XmlElement(name = "PortOfDestinationName")
    private String fiPortOfDestinationName;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ImportingFromDate")
    private Date fiImportingFromDate;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ImportingToDate")
    private Date fiImportingToDate;

    @XmlElement(name = "LocationOfStorage")
    private String fiLocationOfStorage;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfSamplingFrom")
    private Date fiDateOfSamplingFrom;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfSamplingTo")
    private Date fiDateOfSamplingTo;

    @XmlElement(name = "LocationOfSampling")
    private String fiLocationOfSampling;

    @XmlElement(name = "ContactPerson")
    private String fiContactPerson;

    @XmlElement(name = "ContactAddress")
    private String fiContactAddress;

    @XmlElement(name = "ContactTel")
    private String fiContactTel;

    @XmlElement(name = "ContactEmail")
    private String fiContactEmail;

    @XmlElement(name = "PurposeUse")
    private String fiPurposeUse;

    @XmlElement(name = "LicenseOfAnimalNo")
    private String fiLicenseOfAnimalNo;

    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods")
    private List<Goods> fiGoodsList;

    @XmlElementWrapper(name = "ManufacturerList")
    @XmlElement(name = "Manufacturer")
    private List<Manufacturer> fiManufacturerList;

    @XmlElementWrapper(name = "DocumentList")
    @XmlElement(name = "Document")
    private List<Document> fiDocumentList;
}
