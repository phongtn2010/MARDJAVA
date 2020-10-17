/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p11.message.receive;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhytosanitaryFeeResponse")
public class PhytosanitaryFeeResponse {
    @XmlTransient
    private Long fiIdTb;
    
    @XmlTransient
    private Long fiIdHoso;
    
    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;
    
    @XmlElement(name = "Note")
    private String fiGhichu;
    
    @XmlElement(name = "CreaterName")
    private String fiNguoiXl;
    
    @XmlTransient
    private Long fiHoatdong;
    
    @XmlTransient
    private Long fiTrangthai;
    
    @XmlTransient
    private Date fiNgaytao;
    
    @XmlTransient
    private Date fiNgayCn;
    
    @XmlTransient
    private Long fiTongsotien;
    
    @XmlTransient
    private Long fiLoaiphi;

    public PhytosanitaryFeeResponse() {
    }

    public Long getFiIdTb() {
        return fiIdTb;
    }

    public void setFiIdTb(Long fiIdTb) {
        this.fiIdTb = fiIdTb;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
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

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgayCn() {
        return fiNgayCn;
    }

    public void setFiNgayCn(Date fiNgayCn) {
        this.fiNgayCn = fiNgayCn;
    }

    public Long getFiTongsotien() {
        return fiTongsotien;
    }

    public void setFiTongsotien(Long fiTongsotien) {
        this.fiTongsotien = fiTongsotien;
    }

    public Long getFiLoaiphi() {
        return fiLoaiphi;
    }

    public void setFiLoaiphi(Long fiLoaiphi) {
        this.fiLoaiphi = fiLoaiphi;
    }
}
