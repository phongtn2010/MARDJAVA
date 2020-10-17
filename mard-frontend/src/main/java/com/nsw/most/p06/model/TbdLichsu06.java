/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p06.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Elino
 */
public class TbdLichsu06 implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Long fiIdLichsu;
    
//    @Column(name = "FI_DONVIXULY")
    private String fiDonvixuly;
    
//    @Column(name = "FI_NOIDUNG")
    private String fiNoidung;
    
//    @Column(name = "FI_LINK")
    private String fiLink;
    
//    @Column(name = "FI_THOIGIAN")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiThoigian;
    
//    @Column(name = "FI_TRANGTHAIHOSO")
    private Long fiTrangthaihoso;
    
//    @Column(name = "FI_ID_HOSO")
    private Long fiIdHoso;
    
//    @Column(name = "FI_NGAYCAPNHAT")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaycapnhat;
    
//    @Column(name = "FI_NGAYTAO")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaytao;
    
//    @Column(name = "FI_HOATDONG")
    private Long fiHoatdong;
    
//    @Column(name = "FI_MA_TRANGTHAI")
    private Long fiMaTrangthai;
    
//    @Column(name = "FI_MA_HOSO")
    private String fiMaHoso;
    
    
    public Long getFiMaTrangthai() {
        return fiMaTrangthai;
    }

    public void setFiMaTrangthai(Long fiMaTrangthai) {
        this.fiMaTrangthai = fiMaTrangthai;
    }
    
    
    public TbdLichsu06() {
    }

    public TbdLichsu06(Long fiIdLichsu) {
        this.fiIdLichsu = fiIdLichsu;
    }

    public Long getFiIdLichsu() {
        return fiIdLichsu;
    }

    public void setFiIdLichsu(Long fiIdLichsu) {
        this.fiIdLichsu = fiIdLichsu;
    }

    public String getFiDonvixuly() {
        return fiDonvixuly;
    }

    public void setFiDonvixuly(String fiDonvixuly) {
        this.fiDonvixuly = fiDonvixuly;
    }

    public String getFiNoidung() {
        return fiNoidung;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public String getFiLink() {
        return fiLink;
    }

    public void setFiLink(String fiLink) {
        this.fiLink = fiLink;
    }

    public Date getFiThoigian() {
        return fiThoigian;
    }

    public void setFiThoigian(Date fiThoigian) {
        this.fiThoigian = fiThoigian;
    }

    public Long getFiTrangthaihoso() {
        return fiTrangthaihoso;
    }

    public void setFiTrangthaihoso(Long fiTrangthaihoso) {
        this.fiTrangthaihoso = fiTrangthaihoso;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Date getFiNgaycapnhat() {
        return fiNgaycapnhat;
    }

    public void setFiNgaycapnhat(Date fiNgaycapnhat) {
        this.fiNgaycapnhat = fiNgaycapnhat;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdLichsu != null ? fiIdLichsu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdLichsu06)) {
            return false;
        }
        TbdLichsu06 other = (TbdLichsu06) object;
        if ((this.fiIdLichsu == null && other.fiIdLichsu != null) || (this.fiIdLichsu != null && !this.fiIdLichsu.equals(other.fiIdLichsu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p01.model.TbdLichsu02[ fiIdLichsu=" + fiIdLichsu + " ]";
    }
    
}
