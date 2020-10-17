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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuarantineEditResponse")
public class QuarantineEditResponse {
    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;
    
    @XmlTransient
    private Long fiTrangthai;
    
    @XmlElement(name = "Reason")
    private String fiLydo;
    
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    private Date fiNgayXl;
    
    @XmlElement(name = "Department")
    private String fiDonviXl;
    
    @XmlElement(name = "CreaterName")
    private String fiNguoiXl;

    public QuarantineEditResponse() {
    }

    public QuarantineEditResponse(String fiMaHoso, String fiLydo, Date fiNgayXl, String fiDonviXl, String fiNguoiXl) {
        this.fiMaHoso = fiMaHoso;
        this.fiLydo = fiLydo;
        this.fiNgayXl = fiNgayXl;
        this.fiDonviXl = fiDonviXl;
        this.fiNguoiXl = fiNguoiXl;
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

    public String getFiDonviXl() {
        return fiDonviXl;
    }

    public void setFiDonviXl(String fiDonviXl) {
        this.fiDonviXl = fiDonviXl;
    }

    public String getFiNguoiXl() {
        return fiNguoiXl;
    }

    public void setFiNguoiXl(String fiNguoiXl) {
        this.fiNguoiXl = fiNguoiXl;
    }

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }
}
