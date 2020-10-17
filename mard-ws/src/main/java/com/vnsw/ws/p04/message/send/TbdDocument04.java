/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.message.send;

import com.vnsw.ws.annotations.DateSerialization;
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
@XmlType(name = "DocumentList")
public class TbdDocument04  {
    @XmlTransient
    private Long documentId;
    @XmlElement(name = "TypeDoc")
    private Long typeDoc;
    @XmlElement(name = "Number")
    private String numberDoc;
    @XmlElement(name = "Date")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date dateDoc;
    @XmlTransient
    private String billNo;
    @XmlTransient
    private Long registrationProfileId;
    @XmlTransient
    private String nswfileCode;
    @XmlTransient
    private Long isActive;
    @XmlTransient
    private String createBy;
    @XmlTransient
    private Date createDate;

    public TbdDocument04() {
    }

    public TbdDocument04(Long documentId) {
        this.documentId = documentId;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public Long getTypeDoc() {
        return typeDoc;
    }

    public void setTypeDoc(Long typeDoc) {
        this.typeDoc = typeDoc;
    }

    public String getNumberDoc() {
        return numberDoc;
    }

    public void setNumberDoc(String numberDoc) {
        this.numberDoc = numberDoc;
    }

    public Date getDateDoc() {
        return dateDoc;
    }

    public void setDateDoc(Date dateDoc) {
        this.dateDoc = dateDoc;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public Long getRegistrationProfileId() {
        return registrationProfileId;
    }

    public void setRegistrationProfileId(Long registrationProfileId) {
        this.registrationProfileId = registrationProfileId;
    }

    public String getNswfileCode() {
        return nswfileCode;
    }

    public void setNswfileCode(String nswfileCode) {
        this.nswfileCode = nswfileCode;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
    
}
