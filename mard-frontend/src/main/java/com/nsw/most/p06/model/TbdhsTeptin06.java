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
public class TbdhsTeptin06 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Long fiIdTeptin;
    
//    @Column(name = "FI_LOAI_TEP_TIN")
    private Long fiLoaiTepTin;
    
//    @Column(name = "FI_TEN_LOAI_TEP")
    private String fiTenLoaiTep;
    
//    @Column(name = "FI_TEN_TEP_TIN")
    private String fiTenTepTin;
    
//    @Column(name = "FI_TEP_TIN_ID")
    private Long fiTepTinId;
    
//    @Column(name = "FI_HS_CAPGIAYPHEP_PXK_ID")
    private Long fiHsCapgiayphepPxkId;
    
//    @Column(name = "FI_ID_HOSO")
    private Long fiIdHoso;
    
//    @Column(name = "FI_MA_HOSO")
    private String fiMaHoso;
    
//    @Column(name = "FI_HOATDONG")
    private Long fiHoatdong;
    
//    @Column(name = "FI_NGUOITAO")
    private String fiNguoitao;
    
//    @Column(name = "FI_NGAYTAO")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaytao;
    
//    @Column(name = "FI_NG_CAPNHAT")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgCapnhat;

    public TbdhsTeptin06() {
    }

    public TbdhsTeptin06(Long fiIdTeptin) {
        this.fiIdTeptin = fiIdTeptin;
    }

    public Long getFiIdTeptin() {
        return fiIdTeptin;
    }

    public void setFiIdTeptin(Long fiIdTeptin) {
        this.fiIdTeptin = fiIdTeptin;
    }

    public Long getFiLoaiTepTin() {
        return fiLoaiTepTin;
    }

    public void setFiLoaiTepTin(Long fiLoaiTepTin) {
        this.fiLoaiTepTin = fiLoaiTepTin;
    }

    public String getFiTenLoaiTep() {
        return fiTenLoaiTep;
    }

    public void setFiTenLoaiTep(String fiTenLoaiTep) {
        this.fiTenLoaiTep = fiTenLoaiTep;
    }

    public String getFiTenTepTin() {
        return fiTenTepTin;
    }

    public void setFiTenTepTin(String fiTenTepTin) {
        this.fiTenTepTin = fiTenTepTin;
    }

    public Long getFiTepTinId() {
        return fiTepTinId;
    }

    public void setFiTepTinId(Long fiTepTinId) {
        this.fiTepTinId = fiTepTinId;
    }

    public Long getFiHsCapgiayphepPxkId() {
        return fiHsCapgiayphepPxkId;
    }

    public void setFiHsCapgiayphepPxkId(Long fiHsCapgiayphepPxkId) {
        this.fiHsCapgiayphepPxkId = fiHsCapgiayphepPxkId;
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

    public Date getFiNgCapnhat() {
        return fiNgCapnhat;
    }

    public void setFiNgCapnhat(Date fiNgCapnhat) {
        this.fiNgCapnhat = fiNgCapnhat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdTeptin != null ? fiIdTeptin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdhsTeptin06)) {
            return false;
        }
        TbdhsTeptin06 other = (TbdhsTeptin06) object;
        if ((this.fiIdTeptin == null && other.fiIdTeptin != null) || (this.fiIdTeptin != null && !this.fiIdTeptin.equals(other.fiIdTeptin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p02.model.TbdhsTeptin02[ fiIdTeptin=" + fiIdTeptin + " ]";
    }

}
