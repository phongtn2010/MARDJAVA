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
public class TbdPhYcRut06 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Long fiIdPhYcRut;
    
//    @Column(name = "FI_XU_LY")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiXuLy;
    
//    @Column(name = "FI_NOI_DUNG")
    private String fiNoiDung;
    
//    @Column(name = "FI_DON_VI_XU_LY")
    private String fiDonViXuLy;
    
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

    public TbdPhYcRut06() {
    }

    public TbdPhYcRut06(Long fiIdPhYcRut) {
        this.fiIdPhYcRut = fiIdPhYcRut;
    }

    public Long getFiIdPhYcRut() {
        return fiIdPhYcRut;
    }

    public void setFiIdPhYcRut(Long fiIdPhYcRut) {
        this.fiIdPhYcRut = fiIdPhYcRut;
    }

    public Date getFiXuLy() {
        return fiXuLy;
    }

    public void setFiXuLy(Date fiXuLy) {
        this.fiXuLy = fiXuLy;
    }

    public String getFiNoiDung() {
        return fiNoiDung;
    }

    public void setFiNoiDung(String fiNoiDung) {
        this.fiNoiDung = fiNoiDung;
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
        hash += (fiIdPhYcRut != null ? fiIdPhYcRut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdPhYcRut06)) {
            return false;
        }
        TbdPhYcRut06 other = (TbdPhYcRut06) object;
        if ((this.fiIdPhYcRut == null && other.fiIdPhYcRut != null) || (this.fiIdPhYcRut != null && !this.fiIdPhYcRut.equals(other.fiIdPhYcRut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p02.model.TbdPhYcRut02[ fiIdPhYcRut=" + fiIdPhYcRut + " ]";
    }

}
