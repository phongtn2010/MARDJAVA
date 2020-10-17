/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p11.message.receive;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhytosanitaryFee")
public class PhytosanitaryFee {
    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;

    @XmlElement(name = "Note")
    private String fiGhichu;

    @XmlElement(name = "CreaterName")
    private String fiNguoiXl;
    
    @XmlElement(name = "TotalFee")
    private BigDecimal fiTongsotien;
    

    public PhytosanitaryFee() {
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiGhichu() {
        return fiGhichu;
    }

    public void setFiGhichu(String fiGhichu) {
        this.fiGhichu = fiGhichu;
    }

    public String getFiNguoiXl() {
        return fiNguoiXl;
    }

    public void setFiNguoiXl(String fiNguoiXl) {
        this.fiNguoiXl = fiNguoiXl;
    }

    public BigDecimal getFiTongsotien() {
        return fiTongsotien;
    }

    public void setFiTongsotien(BigDecimal fiTongsotien) {
        this.fiTongsotien = fiTongsotien;
    }
}
