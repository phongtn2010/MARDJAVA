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
public class TbdLephi06 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Long fiIdTbLephiTd;
    
//    @Column(name = "FI_PHI_THAMDINH")
    private Long fiPhiThamdinh;
    
//    @Column(name = "FI_NOI_DUNG")
    private String fiNoiDung;
    
//    @Column(name = "FI_LINK_TBPHI")
    private String fiLinkTbphi;
    
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

    public TbdLephi06() {
    }

    public TbdLephi06(Long fiIdTbLephiTd) {
        this.fiIdTbLephiTd = fiIdTbLephiTd;
    }

    public Long getFiIdTbLephiTd() {
        return fiIdTbLephiTd;
    }

    public void setFiIdTbLephiTd(Long fiIdTbLephiTd) {
        this.fiIdTbLephiTd = fiIdTbLephiTd;
    }

    public Long getFiPhiThamdinh() {
        return fiPhiThamdinh;
    }

    public void setFiPhiThamdinh(Long fiPhiThamdinh) {
        this.fiPhiThamdinh = fiPhiThamdinh;
    }

    public String getFiNoiDung() {
        return fiNoiDung;
    }

    public void setFiNoiDung(String fiNoiDung) {
        this.fiNoiDung = fiNoiDung;
    }

    public String getFiLinkTbphi() {
        return fiLinkTbphi;
    }

    public void setFiLinkTbphi(String fiLinkTbphi) {
        this.fiLinkTbphi = fiLinkTbphi;
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
        hash += (fiIdTbLephiTd != null ? fiIdTbLephiTd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdLephi06)) {
            return false;
        }
        TbdLephi06 other = (TbdLephi06) object;
        if ((this.fiIdTbLephiTd == null && other.fiIdTbLephiTd != null) || (this.fiIdTbLephiTd != null && !this.fiIdTbLephiTd.equals(other.fiIdTbLephiTd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p02.model.TbdLephi02[ fiIdTbLephiTd=" + fiIdTbLephiTd + " ]";
    }

}
