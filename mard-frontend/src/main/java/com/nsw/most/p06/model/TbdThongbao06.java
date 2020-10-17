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
public class TbdThongbao06 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Long fiIdThongbao;
    
//    @Column(name = "FI_NGAY_TB")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgayTb;
    
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
    
//    @Column(name = "FI_NGAYCAPNHAP")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaycapnhap;

    public TbdThongbao06() {
    }

    public TbdThongbao06(Long fiIdThongbao) {
        this.fiIdThongbao = fiIdThongbao;
    }

    public Long getFiIdThongbao() {
        return fiIdThongbao;
    }

    public void setFiIdThongbao(Long fiIdThongbao) {
        this.fiIdThongbao = fiIdThongbao;
    }

    public Date getFiNgayTb() {
        return fiNgayTb;
    }

    public void setFiNgayTb(Date fiNgayTb) {
        this.fiNgayTb = fiNgayTb;
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

    public Date getFiNgaycapnhap() {
        return fiNgaycapnhap;
    }

    public void setFiNgaycapnhap(Date fiNgaycapnhap) {
        this.fiNgaycapnhap = fiNgaycapnhap;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdThongbao != null ? fiIdThongbao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdThongbao06)) {
            return false;
        }
        TbdThongbao06 other = (TbdThongbao06) object;
        if ((this.fiIdThongbao == null && other.fiIdThongbao != null) || (this.fiIdThongbao != null && !this.fiIdThongbao.equals(other.fiIdThongbao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p02.model.TbdThongbao02[ fiIdThongbao=" + fiIdThongbao + " ]";
    }

}
