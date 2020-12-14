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
public class TbdThanhtoan06 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Long fiIdXnThanhtoan;
//    @Column(name = "FI_NGAY_XU_LY")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgayXuLy;
    
//    @Column(name = "FI_DON_VI_XU_LY")
    private String fiDonViXuLy;
    
//    @Column(name = "FI_ID_HOSO")
    private Long fiIdHoso;
    
//    @Column(name = "FI_MA_HOSO")
    private String fiMaHoso;
    
//    @Column(name = "FI_HOATDONG")
    private Long fiHoatdong;
    
//    @Column(name = "FI_NGAYTAO")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaytao;
    
//    @Column(name = "FI_NGUOITAO")
    private String fiNguoitao;
    
//    @Column(name = "FI_NGAYCAPNHAP")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaycapnhap;

    public TbdThanhtoan06() {
    }

    public TbdThanhtoan06(Long fiIdXnThanhtoan) {
        this.fiIdXnThanhtoan = fiIdXnThanhtoan;
    }

    public Long getFiIdXnThanhtoan() {
        return fiIdXnThanhtoan;
    }

    public void setFiIdXnThanhtoan(Long fiIdXnThanhtoan) {
        this.fiIdXnThanhtoan = fiIdXnThanhtoan;
    }

    public Date getFiNgayXuLy() {
        return fiNgayXuLy;
    }

    public void setFiNgayXuLy(Date fiNgayXuLy) {
        this.fiNgayXuLy = fiNgayXuLy;
    }

    public String getFiDonViXuLy() {
        return fiDonViXuLy;
    }

    public void setFiDonViXuLy(String fiDonViXuLy) {
        this.fiDonViXuLy = fiDonViXuLy;
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

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
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
        hash += (fiIdXnThanhtoan != null ? fiIdXnThanhtoan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdThanhtoan06)) {
            return false;
        }
        TbdThanhtoan06 other = (TbdThanhtoan06) object;
        if ((this.fiIdXnThanhtoan == null && other.fiIdXnThanhtoan != null) || (this.fiIdXnThanhtoan != null && !this.fiIdXnThanhtoan.equals(other.fiIdXnThanhtoan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p02.model.TbdThanhtoan02[ fiIdXnThanhtoan=" + fiIdXnThanhtoan + " ]";
    }

}
