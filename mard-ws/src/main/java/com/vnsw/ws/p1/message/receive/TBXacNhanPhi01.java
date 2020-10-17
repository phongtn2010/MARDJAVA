package com.vnsw.ws.p1.message.receive;

import com.vnsw.ws.p1.entity.receive.Attachment;
import com.vnsw.ws.util.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "FeeRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class TBXacNhanPhi01 {

    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;

    @XmlElement(name = "TypeFee")
    private Integer fiTypeFee;

    @XmlElement(name = "PaymentStatus")
    private Integer fiPaymentStatus;

    @XmlElement(name = "Name")
    private String fiName;

    @XmlElement(name = "AccountNumber")
    private String fiAccountNumber;

    @XmlElement(name = "TotalFee")
    private long fiTotalFee;

    @XmlElement(name = "TotalFeeText")
    private String fiTotalFeeText;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DatePayment")
    private Date fiDatePayment;

    @XmlElement(name = "InvoiceNumber")
    private String fiInvoiceNumber;

    @XmlElement(name = "Note")
    private String fiNote;

    @XmlElement(name = "CreaterName")
    private String fiCreaterName;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "FromDate")
    private Date fiFromDate;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ToDate")
    private Date fiToDate;

//    @XmlElementWrapper(name = "Attachment")
    @XmlElement(name = "Attachment")
    private Attachment fiAttachment;
}
