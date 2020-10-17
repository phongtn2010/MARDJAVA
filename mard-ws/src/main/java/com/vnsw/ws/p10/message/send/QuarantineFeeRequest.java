/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p10.message.send;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p10.entity.db.Tbddinhkem10;
import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuarantineFeeRequest")
public class QuarantineFeeRequest {
    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;
    
    @XmlElement(name = "TotalFee")
    private BigDecimal fiSotienCk;
    
    @XmlElement(name = "TotalFeeChar")
    private String fiNdSotien;
    
    @XmlElement(name = "Note")
    private String fiChuthich;
    
    @XmlElement(name = "PaymentName")
    private String fiNguoinop;
    
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "PaymentDate")
    private Date fiNgaynop;
    
    @XmlElement(name = "AttachedDocName")
    private String fiSohoadon;
    
    @XmlElement(name = "Attachment")
    private Tbddinhkem10 attachment;

    public QuarantineFeeRequest() {
    }

    public QuarantineFeeRequest(String fiMaHoso, BigDecimal fiSotienCk, String fiNdSotien, String fiChuthich, String fiNguoinop, Date fiNgaynop, String fiSohoadon, Tbddinhkem10 attachment) {
        this.fiMaHoso = fiMaHoso;
        this.fiSotienCk = fiSotienCk;
        this.fiNdSotien = fiNdSotien;
        this.fiChuthich = fiChuthich;
        this.fiNguoinop = fiNguoinop;
        this.fiNgaynop = fiNgaynop;
        this.fiSohoadon = fiSohoadon;
        this.attachment = attachment;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public BigDecimal getFiSotienCk() {
        return fiSotienCk;
    }

    public void setFiSotienCk(BigDecimal fiSotienCk) {
        this.fiSotienCk = fiSotienCk;
    }

    public String getFiNdSotien() {
        return fiNdSotien;
    }

    public void setFiNdSotien(String fiNdSotien) {
        this.fiNdSotien = fiNdSotien;
    }

    public String getFiChuthich() {
        return fiChuthich;
    }

    public void setFiChuthich(String fiChuthich) {
        this.fiChuthich = fiChuthich;
    }

    public String getFiNguoinop() {
        return fiNguoinop;
    }

    public void setFiNguoinop(String fiNguoinop) {
        this.fiNguoinop = fiNguoinop;
    }

    public Date getFiNgaynop() {
        return fiNgaynop;
    }

    public void setFiNgaynop(Date fiNgaynop) {
        this.fiNgaynop = fiNgaynop;
    }

    public String getFiSohoadon() {
        return fiSohoadon;
    }

    public void setFiSohoadon(String fiSohoadon) {
        this.fiSohoadon = fiSohoadon;
    }

    public Tbddinhkem10 getAttachment() {
        return attachment;
    }

    public void setAttachment(Tbddinhkem10 attachment) {
        this.attachment = attachment;
    }
    
}
