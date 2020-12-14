/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p03.model;

import java.util.Date;

/**
 * @author HuongMK
 */
public class TbdXacnhanPhiDk03 {

    private Long id;
    private String fiTentep;
    private String fiNoidung;
    private Long fiIdXacnhanphi;
    private Long fiHoatdong;
    private Date fiNgaytao;
    private String fiNguoitao;

    public TbdXacnhanPhiDk03() {
    }

    public TbdXacnhanPhiDk03(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFiTentep() {
        return fiTentep;
    }

    public void setFiTentep(String fiTentep) {
        this.fiTentep = fiTentep;
    }

    public String getFiNoidung() {
        return fiNoidung;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public Long getFiIdXacnhanphi() {
        return fiIdXacnhanphi;
    }

    public void setFiIdXacnhanphi(Long fiIdXacnhanphi) {
        this.fiIdXacnhanphi = fiIdXacnhanphi;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdXacnhanPhiDk03)) {
            return false;
        }
        TbdXacnhanPhiDk03 other = (TbdXacnhanPhiDk03) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.mard.p03.model.TbdXacnhanPhiDk03[ id=" + id + " ]";
    }

}
