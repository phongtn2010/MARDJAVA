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
public class TbdKqxl02 {

    private Long fiIdKqxl;
    private Long fiIdHoso;
    private String fiMaHoso;
    private String fiNoidung;
    private Date fiNgayXl;
    private String fiDonviXl;
    private String fiLinkCv;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;
    private Date fiNgCapnhat;
    private Long fiTrangthai;
    private String fiTenTt;

    public TbdKqxl02() {
    }

    public TbdKqxl02(Long fiIdKqxl) {
        this.fiIdKqxl = fiIdKqxl;
    }

    public Long getFiIdKqxl() {
        return fiIdKqxl;
    }

    public void setFiIdKqxl(Long fiIdKqxl) {
        this.fiIdKqxl = fiIdKqxl;
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

    public String getFiNoidung() {
        return fiNoidung;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public Date getFiNgayXl() {
        return fiNgayXl;
    }

    public void setFiNgayXl(Date fiNgayXl) {
        this.fiNgayXl = fiNgayXl;
    }

    public String getFiDonviXl() {
        return fiDonviXl;
    }

    public void setFiDonviXl(String fiDonviXl) {
        this.fiDonviXl = fiDonviXl;
    }

    public String getFiLinkCv() {
        return fiLinkCv;
    }

    public void setFiLinkCv(String fiLinkCv) {
        this.fiLinkCv = fiLinkCv;
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

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public String getFiTenTt() {
        return fiTenTt;
    }

    public void setFiTenTt(String fiTenTt) {
        this.fiTenTt = fiTenTt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdKqxl != null ? fiIdKqxl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdKqxl02)) {
            return false;
        }
        TbdKqxl02 other = (TbdKqxl02) object;
        if ((this.fiIdKqxl == null && other.fiIdKqxl != null) || (this.fiIdKqxl != null && !this.fiIdKqxl.equals(other.fiIdKqxl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.moh.p02.model.TbdKqxl02[ fiIdKqxl=" + fiIdKqxl + " ]";
    }

}
