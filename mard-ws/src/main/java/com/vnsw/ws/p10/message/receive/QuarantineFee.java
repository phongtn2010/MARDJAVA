/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p10.message.receive;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuarantineFee")
public class QuarantineFee {
    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;
    
    @XmlElement(name = "TotalFee")
    private BigDecimal fiTongTien;
    
    @XmlElement(name = "Note")
    private String fiChuthich;
    
    @XmlElement(name = "Department")
    private String fiDvXl;
    
    @XmlElement(name = "CreaterName")
    private String fiNguoiXl;

    public QuarantineFee() {
    }

    public QuarantineFee(String fiMaHoso, BigDecimal fiTongTien, String fiChuthich, String fiDvXl, String fiNguoiXl) {
        this.fiMaHoso = fiMaHoso;
        this.fiTongTien = fiTongTien;
        this.fiChuthich = fiChuthich;
        this.fiDvXl = fiDvXl;
        this.fiNguoiXl = fiNguoiXl;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public BigDecimal getFiTongTien() {
        return fiTongTien;
    }

    public void setFiTongTien(BigDecimal fiTongTien) {
        this.fiTongTien = fiTongTien;
    }

    public String getFiChuthich() {
        return fiChuthich;
    }

    public void setFiChuthich(String fiChuthich) {
        this.fiChuthich = fiChuthich;
    }

    public String getFiDvXl() {
        return fiDvXl;
    }

    public void setFiDvXl(String fiDvXl) {
        this.fiDvXl = fiDvXl;
    }

    public String getFiNguoiXl() {
        return fiNguoiXl;
    }

    public void setFiNguoiXl(String fiNguoiXl) {
        this.fiNguoiXl = fiNguoiXl;
    }
}
