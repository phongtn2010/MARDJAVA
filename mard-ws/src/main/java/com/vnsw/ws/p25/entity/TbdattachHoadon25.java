package com.vnsw.ws.p25.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.sql.Date;


@XmlType(name = "Attachment")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class TbdattachHoadon25 implements Serializable {
    @XmlElement(name = "InvoiceNo")
    private String fiSoHoadon;
    @XmlElement(name = "InvoiceDate")
    private Date fiNgayHoadon;
    @XmlElement(name = "InvoiceAttachmentId")
    private Long fiFileId;
    @XmlElement(name = "InvoiceName")
    private String fiFileName;
    @XmlElement(name = "InvoiceFileLink")
    private String fiFileLink;

}
