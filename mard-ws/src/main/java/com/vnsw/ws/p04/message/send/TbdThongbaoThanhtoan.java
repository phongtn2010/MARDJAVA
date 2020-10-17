/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.message.send;

import com.vnsw.ws.annotations.DateSerialization;
import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Fujitsu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhytosanitaryFee_1")
public class TbdThongbaoThanhtoan {
    @XmlTransient
    private Long fiIdTb;
    @XmlElement(name = "NSWFileCode")
    private String nswFilecode;
    @XmlElement(name = "PaymentType")
    private Long paymentType;
    @XmlElement(name = "TotalFee")
    private BigDecimal totalFeeSend;
    @XmlElement(name = "Payer")
    private String payer;
    @XmlElement(name = "Date")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date sendDate;
    @XmlElement(name = "Note")
    private String noteSend;
    @XmlElement(name = "DocumentNo")
    private String documentNo;
    @XmlElement(name = "FileName")
    private String fileName;
    @XmlElement(name = "FileByte")
    private String fileByte;
    @XmlTransient
    private Long isActive;
    @XmlTransient
    private Date createDate;

    public TbdThongbaoThanhtoan() {
    }

    public TbdThongbaoThanhtoan(Long fiIdTb) {
        this.fiIdTb = fiIdTb;
    }

    public Long getFiIdTb() {
        return fiIdTb;
    }

    public void setFiIdTb(Long fiIdTb) {
        this.fiIdTb = fiIdTb;
    }

    public String getNswFilecode() {
        return nswFilecode;
    }

    public void setNswFilecode(String nswFilecode) {
        this.nswFilecode = nswFilecode;
    }

   

    public Long getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Long paymentType) {
        this.paymentType = paymentType;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public BigDecimal getTotalFeeSend() {
        return totalFeeSend;
    }

    public void setTotalFeeSend(BigDecimal totalFeeSend) {
        this.totalFeeSend = totalFeeSend;
    }

    public String getNoteSend() {
        return noteSend;
    }

    public void setNoteSend(String noteSend) {
        this.noteSend = noteSend;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileByte() {
        return fileByte;
    }

    public void setFileByte(String fileByte) {
        this.fileByte = fileByte;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdTb != null ? fiIdTb.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdThongbaoThanhtoan)) {
            return false;
        }
        TbdThongbaoThanhtoan other = (TbdThongbaoThanhtoan) object;
        if ((this.fiIdTb == null && other.fiIdTb != null) || (this.fiIdTb != null && !this.fiIdTb.equals(other.fiIdTb))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.mard.p04.model.TbdThongbaoThanhtoan[ fiIdTb=" + fiIdTb + " ]";
    }

}
