package com.vnsw.ws.p9.entity;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "Buy")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Buyer {
    @XmlElement(name = "BuyerName")
    private String fiBuyerName;

    @XmlElement(name = "BuyerIdentityNo")
    private String fiBuyerIdentityNo;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "BuyerDateOfIdentity")
    private Date fiBuyerDateOfIdentity;

    @XmlElement(name = "BuyerPlaceOfIdentity")
    private String fiBuyerPlaceOfIdentity;

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
    @XmlElement(name = "ImportingDateFrom")
    private Date fiImportingDateFrom;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ImportingDateTo")
    private Date fiImportingDateTo;

    @XmlElement(name = "BillOfLadingNo")
    private String fiLadingBill;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "BillOfLadingIssuedDate")
    private Date fiLadingBillDate;
}
