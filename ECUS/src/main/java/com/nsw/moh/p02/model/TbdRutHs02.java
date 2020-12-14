/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p02.model;

import java.util.Date;

/**
 * @author HuongMK
 */
public class TbdRutHs02 {

    private Long fiIdRutHs;
    private Long fiIdHoso;
    private String fiMaHoso;
    private Date fiNgayRut;
    private String fiNoidung;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;
    private Date fiNgCapnhat;
    private String fiTenTtCu;
    private Long fiTrangthaiCu;

    public TbdRutHs02() {
    }

    public TbdRutHs02(Long fiIdRutHs) {
        this.fiIdRutHs = fiIdRutHs;
    }

    public Long getFiIdRutHs() {
        return fiIdRutHs;
    }

    public void setFiIdRutHs(Long fiIdRutHs) {
        this.fiIdRutHs = fiIdRutHs;
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

    public Date getFiNgayRut() {
        return fiNgayRut;
    }

    public void setFiNgayRut(Date fiNgayRut) {
        this.fiNgayRut = fiNgayRut;
    }

    public String getFiNoidung() {
        return fiNoidung;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
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

    public String getFiTenTtCu() {
        return fiTenTtCu;
    }

    public void setFiTenTtCu(String fiTenTtCu) {
        this.fiTenTtCu = fiTenTtCu;
    }

    public Long getFiTrangthaiCu() {
        return fiTrangthaiCu;
    }

    public void setFiTrangthaiCu(Long fiTrangthaiCu) {
        this.fiTrangthaiCu = fiTrangthaiCu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdRutHs != null ? fiIdRutHs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdRutHs02)) {
            return false;
        }
        TbdRutHs02 other = (TbdRutHs02) object;
        if ((this.fiIdRutHs == null && other.fiIdRutHs != null) || (this.fiIdRutHs != null && !this.fiIdRutHs.equals(other.fiIdRutHs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.moh.p02.model.TbdRutHs02[ fiIdRutHs=" + fiIdRutHs + " ]";
    }

}
