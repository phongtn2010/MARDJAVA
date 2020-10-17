package com.vnsw.ws.p9.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p9.entity.AttachmentXacNhanPhi;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "FeeResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class XacNhanPhi {

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
    private Long fiTotalFee;

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

    @XmlElement(name = "Attachment")
    private AttachmentXacNhanPhi fiAttachment;

    public String getFiFileName() {
        return fiAttachment.getFiFileName();
    }

    public String getFiFileByte() {
        return fiAttachment.getFiFileByte();
    }

}
