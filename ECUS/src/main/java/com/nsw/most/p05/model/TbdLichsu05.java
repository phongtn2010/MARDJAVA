/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p05.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Elino
 */
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "Lichsu")
public class TbdLichsu05 implements Serializable {
 
    private static final long serialVersionUID = 1L;
    private Long fiIdLichsu;
    private String fiDonvixuly;
    private String fiNoidung;
    private String fiLink;
    private Date fiThoigian;
    private Long fiTrangthaihoso;
    private Long fiIdHoso;
    private String fiMaHoso;
    private Date fiNgaycapnhat;
    private Date fiNgaytao;
    private Long fiHoatdong;

    public TbdLichsu05() {
    }

    public TbdLichsu05(Long fiIdLichsu) {
        this.fiIdLichsu = fiIdLichsu;
    }

    public Long getFiIdLichsu() {
        return fiIdLichsu;
    }

    public void setFiIdLichsu(Long fiIdLichsu) {
        this.fiIdLichsu = fiIdLichsu;
    }

    public String getFiDonvixuly() {
        return fiDonvixuly;
    }

    public void setFiDonvixuly(String fiDonvixuly) {
        this.fiDonvixuly = fiDonvixuly;
    }

    public String getFiNoidung() {
        return fiNoidung;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public String getFiLink() {
        return fiLink;
    }

    public void setFiLink(String fiLink) {
        this.fiLink = fiLink;
    }

    public Date getFiThoigian() {
        return fiThoigian;
    }

    public void setFiThoigian(Date fiThoigian) {
        this.fiThoigian = fiThoigian;
    }

    public Long getFiTrangthaihoso() {
        return fiTrangthaihoso;
    }

    public void setFiTrangthaihoso(Long fiTrangthaihoso) {
        this.fiTrangthaihoso = fiTrangthaihoso;
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

    public Date getFiNgaycapnhat() {
        return fiNgaycapnhat;
    }

    public void setFiNgaycapnhat(Date fiNgaycapnhat) {
        this.fiNgaycapnhat = fiNgaycapnhat;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdLichsu != null ? fiIdLichsu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdLichsu05)) {
            return false;
        }
        TbdLichsu05 other = (TbdLichsu05) object;
        if ((this.fiIdLichsu == null && other.fiIdLichsu != null) || (this.fiIdLichsu != null && !this.fiIdLichsu.equals(other.fiIdLichsu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p01.model.TbdLichsu01[ fiIdLichsu=" + fiIdLichsu + " ]";
    }

}
