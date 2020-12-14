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
 * @author Antsoft
 */
public class TbdKqXuly06 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Long fiIdKqXuly;
    
//    @Column(name = "FI_NGAY_XU_LY")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgayXuLy;
    
//    @Column(name = "FI_NOI_DUNG")
    private String fiNoiDung;
    
//    @Column(name = "FI_DV_XULY")
    private String fiDvXuly;
    
//    @Column(name = "FI_LINK_CONGVAN")
    private String fiLinkCongvan;
    
//    @Column(name = "FI_ID_HOSO")
    private Long fiIdHoso;
    
//    @Column(name = "FI_MA_HOSO")
    private String fiMaHoso;
    
//    @Column(name = "FI_TRANGTHAI")
    private Short fiTrangthai;
    
//    @Column(name = "FI_HOATDONG")
    private Long fiHoatdong;
    
//    @Column(name = "FI_NGUOITAO")
    private String fiNguoitao;
    
//    @Column(name = "FI_NGAYTAO")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaytao;
    
//    @Column(name = "FI_NGAYCAPNHAP")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaycapnhap;

    public TbdKqXuly06() {
    }

    public TbdKqXuly06(Long fiIdKqXuly) {
        this.fiIdKqXuly = fiIdKqXuly;
    }

    public Long getFiIdKqXuly() {
        return fiIdKqXuly;
    }

    public void setFiIdKqXuly(Long fiIdKqXuly) {
        this.fiIdKqXuly = fiIdKqXuly;
    }

    public Date getFiNgayXuLy() {
        return fiNgayXuLy;
    }

    public void setFiNgayXuLy(Date fiNgayXuLy) {
        this.fiNgayXuLy = fiNgayXuLy;
    }

    public String getFiNoiDung() {
        return fiNoiDung;
    }

    public void setFiNoiDung(String fiNoiDung) {
        this.fiNoiDung = fiNoiDung;
    }

    public String getFiDvXuly() {
        return fiDvXuly;
    }

    public void setFiDvXuly(String fiDvXuly) {
        this.fiDvXuly = fiDvXuly;
    }

    public String getFiLinkCongvan() {
        return fiLinkCongvan;
    }

    public void setFiLinkCongvan(String fiLinkCongvan) {
        this.fiLinkCongvan = fiLinkCongvan;
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

    public Short getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Short fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaycapnhap() {
        return fiNgaycapnhap;
    }

    public void setFiNgaycapnhap(Date fiNgaycapnhap) {
        this.fiNgaycapnhap = fiNgaycapnhap;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdKqXuly != null ? fiIdKqXuly.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdKqXuly06)) {
            return false;
        }
        TbdKqXuly06 other = (TbdKqXuly06) object;
        if ((this.fiIdKqXuly == null && other.fiIdKqXuly != null) || (this.fiIdKqXuly != null && !this.fiIdKqXuly.equals(other.fiIdKqXuly))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p02.model.TbdKqXuly02[ fiIdKqXuly=" + fiIdKqXuly + " ]";
    }

}
