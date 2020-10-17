/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p10.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(name = "QuarantineResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class QuarantineResult {
    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;
    
    @XmlTransient
    private Long fiTrangthai;
    
    @XmlElement(name = "Reason")
    private String fiLydo;
    
    
    @XmlElement(name = "ResultDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date fiNgayXl;
    
    @XmlElement(name = "Department")
    private String fiDvXl;
    
    @XmlElement(name = "CreaterName")
    private String fiCvXl;
    
    

    public QuarantineResult() {
    }

    public QuarantineResult(String fiMaHoso, String fiLydo, Date fiNgayXl, String fiDvXl, String fiCvXl) {
        this.fiMaHoso = fiMaHoso;
        this.fiLydo = fiLydo;
        this.fiNgayXl = fiNgayXl;
        this.fiDvXl = fiDvXl;
        this.fiCvXl = fiCvXl;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiLydo() {
        return fiLydo;
    }

    public void setFiLydo(String fiLydo) {
        this.fiLydo = fiLydo;
    }

    public Date getFiNgayXl() {
        return fiNgayXl;
    }

    public void setFiNgayXl(Date fiNgayXl) {
        this.fiNgayXl = fiNgayXl;
    }

    public String getFiDvXl() {
        return fiDvXl;
    }

    public void setFiDvXl(String fiDvXl) {
        this.fiDvXl = fiDvXl;
    }

    public String getFiCvXl() {
        return fiCvXl;
    }

    public void setFiCvXl(String fiCvXl) {
        this.fiCvXl = fiCvXl;
    }

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }
    
}
