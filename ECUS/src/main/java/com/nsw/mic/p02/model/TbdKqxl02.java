/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mic.p02.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Fujitsu
 */
public class TbdKqxl02 implements Serializable {

    private Long fiIdKetquaxuly;
    private String fiNoiDung;
    private Date fiNgayXuLy;
    private String fiDonViXuLy;
    private String fiLinkCongvan;
    private Long fiTrangThai;
    private Long fiIdHoso;
    private String fiMaHoso;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;
    private Date fiNgaycapnhap;

    public TbdKqxl02() {
    }

    public TbdKqxl02(Long fiIdKetquaxuly) {
        this.fiIdKetquaxuly = fiIdKetquaxuly;
    }

    public Long getFiIdKetquaxuly() {
        return fiIdKetquaxuly;
    }

    public void setFiIdKetquaxuly(Long fiIdKetquaxuly) {
        this.fiIdKetquaxuly = fiIdKetquaxuly;
    }

    public String getFiNoiDung() {
        return fiNoiDung;
    }

    public void setFiNoiDung(String fiNoiDung) {
        this.fiNoiDung = fiNoiDung;
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

    public String getFiLinkCongvan() {
        return fiLinkCongvan;
    }

    public void setFiLinkCongvan(String fiLinkCongvan) {
        this.fiLinkCongvan = fiLinkCongvan;
    }

    public Long getFiTrangThai() {
        return fiTrangThai;
    }

    public void setFiTrangThai(Long fiTrangThai) {
        this.fiTrangThai = fiTrangThai;
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
        hash += (fiIdKetquaxuly != null ? fiIdKetquaxuly.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdKqxl02)) {
            return false;
        }
        TbdKqxl02 other = (TbdKqxl02) object;
        if ((this.fiIdKetquaxuly == null && other.fiIdKetquaxuly != null) || (this.fiIdKetquaxuly != null && !this.fiIdKetquaxuly.equals(other.fiIdKetquaxuly))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.mic.p02.model.TbdKqxl02[ fiIdKetquaxuly=" + fiIdKetquaxuly + " ]";
    }
    
}
