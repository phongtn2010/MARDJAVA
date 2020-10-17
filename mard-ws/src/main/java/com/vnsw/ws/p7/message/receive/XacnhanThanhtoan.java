package com.vnsw.ws.p7.message.receive;


import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.annotations.DoubleSerialization;
import com.vnsw.ws.p7.enitty.Attachment;
import com.vnsw.ws.p7.enitty.FeeConfirmationAttachment;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "FeeRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class XacnhanThanhtoan {
    @XmlElement(name = "NSWFileCode")
    String fiNSWFileCode;

    @XmlElement(name = "TypeFee")
    Integer fiTypeFee;

    @XmlElement(name = "Name")
    String fiName;

    @XmlElement(name = "AccountNumber")
    String fiAccountNumber;

    @XmlJavaTypeAdapter(DoubleSerialization.class)
    @XmlElement(name = "TotalFee")
    Double fiTotalFee;

    @XmlElement(name = "TotalFeeText")
    String fiTotalFeeText;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DatePayment")
    Date fiDatePayment;

    @XmlElement(name = "InvoiceNumber")
    String fiInvoiceNumber;

    @XmlElement(name = "Note")
    String fiNote;

    @XmlElement(name = "CreaterName")
    String fiCreaterName;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "FromDate")
    Date fiFromDate;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ToDate")
    Date fiToDate;

    @XmlElementWrapper(name = "AttachmentList")
    @XmlElement(name = "Attachment")
    List<FeeConfirmationAttachment> fiAttachmentList;
}
