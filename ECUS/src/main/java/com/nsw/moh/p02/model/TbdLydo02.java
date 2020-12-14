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
public class TbdLydo02 {

    private Long fiIdLydo;
    private Long fiIdHoso;
    private String fiMucdichSd;
    private String fiTenTlDk;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;
    private Date fiNgCapnhat;

    public TbdLydo02() {
    }

    public TbdLydo02(Long fiIdLydo) {
        this.fiIdLydo = fiIdLydo;
    }

    public Long getFiIdLydo() {
        return fiIdLydo;
    }

    public void setFiIdLydo(Long fiIdLydo) {
        this.fiIdLydo = fiIdLydo;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiMucdichSd() {
        return fiMucdichSd;
    }

    public void setFiMucdichSd(String fiMucdichSd) {
        this.fiMucdichSd = fiMucdichSd;
    }

    public String getFiTenTlDk() {
        return fiTenTlDk;
    }

    public void setFiTenTlDk(String fiTenTlDk) {
        this.fiTenTlDk = fiTenTlDk;
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
        hash += (fiIdLydo != null ? fiIdLydo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdLydo02)) {
            return false;
        }
        TbdLydo02 other = (TbdLydo02) object;
        if ((this.fiIdLydo == null && other.fiIdLydo != null) || (this.fiIdLydo != null && !this.fiIdLydo.equals(other.fiIdLydo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.moh.p02.model.TbdLydo02[ fiIdLydo=" + fiIdLydo + " ]";
    }

}
