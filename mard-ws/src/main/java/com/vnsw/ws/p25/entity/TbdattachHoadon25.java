package com.vnsw.ws.p25.entity;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.sql.Date;


@XmlType(name = "Invoice")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class TbdattachHoadon25 implements Serializable {
    @XmlElement(name = "InvoiceNo")
    private String fiSoHoadon;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "InvoiceDate")
    private Date fiNgayHoadon;
    @XmlElement(name = "InvoiceAttachmentId")
    private Long fiFileId;
    @XmlElement(name = "InvoiceName")
    private String fiFileName;
    @XmlElement(name = "InvoiceFileLink")
    private String fiFileLink;

}
