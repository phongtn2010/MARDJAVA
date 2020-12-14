/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p02.model;

import java.util.Date;

/**
 *
 * @author HuongMK
 */
public class TbdGpHanghoa02 {

    private Long fiIdGpHh;
    private Long fiIdGiayphep;
    private String fiLoaimau;
    private String fiNguongoc;
    private Long fiSoluong;
    private String fiDonviTinh;
    private String fiHinhthuc;
    private String fiNoigui;
    private String fiNoiNhan;
    private String fiDuongVanchuyen;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;
    private Date fiNgCapnhat;

    public TbdGpHanghoa02() {
    }

    public TbdGpHanghoa02(Long fiIdGpHh) {
        this.fiIdGpHh = fiIdGpHh;
    }

    public Long getFiIdGpHh() {
        return fiIdGpHh;
    }

    public void setFiIdGpHh(Long fiIdGpHh) {
        this.fiIdGpHh = fiIdGpHh;
    }

    public Long getFiIdGiayphep() {
        return fiIdGiayphep;
    }

    public void setFiIdGiayphep(Long fiIdGiayphep) {
        this.fiIdGiayphep = fiIdGiayphep;
    }

    public String getFiLoaimau() {
        return fiLoaimau;
    }

    public void setFiLoaimau(String fiLoaimau) {
        this.fiLoaimau = fiLoaimau;
    }

    public String getFiNguongoc() {
        return fiNguongoc;
    }

    public void setFiNguongoc(String fiNguongoc) {
        this.fiNguongoc = fiNguongoc;
    }

    public Long getFiSoluong() {
        return fiSoluong;
    }

    public void setFiSoluong(Long fiSoluong) {
        this.fiSoluong = fiSoluong;
    }

    public String getFiDonviTinh() {
        return fiDonviTinh;
    }

    public void setFiDonviTinh(String fiDonviTinh) {
        this.fiDonviTinh = fiDonviTinh;
    }

    public String getFiHinhthuc() {
        return fiHinhthuc;
    }

    public void setFiHinhthuc(String fiHinhthuc) {
        this.fiHinhthuc = fiHinhthuc;
    }

    public String getFiNoigui() {
        return fiNoigui;
    }

    public void setFiNoigui(String fiNoigui) {
        this.fiNoigui = fiNoigui;
    }

    public String getFiNoiNhan() {
        return fiNoiNhan;
    }

    public void setFiNoiNhan(String fiNoiNhan) {
        this.fiNoiNhan = fiNoiNhan;
    }

    public String getFiDuongVanchuyen() {
        return fiDuongVanchuyen;
    }

    public void setFiDuongVanchuyen(String fiDuongVanchuyen) {
        this.fiDuongVanchuyen = fiDuongVanchuyen;
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
        hash += (fiIdGpHh != null ? fiIdGpHh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdGpHanghoa02)) {
            return false;
        }
        TbdGpHanghoa02 other = (TbdGpHanghoa02) object;
        if ((this.fiIdGpHh == null && other.fiIdGpHh != null) || (this.fiIdGpHh != null && !this.fiIdGpHh.equals(other.fiIdGpHh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vnsw.ws.p02.entity.TbdGpHanghoa02[ fiIdGpHh=" + fiIdGpHh + " ]";
    }
    
}
