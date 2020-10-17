/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Fujitsu
 */
public class TbdLichsu04 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Long fiId;
    private String fiDonviXuly;
    private String fiNguoiXuly;
    private Date fiThoigian;
    private String fiTenTrangthai;
    private String fiLinkDowload;
    private Long fiIdHoso;
    private String fiMaHoso;
    private String fiNoidung;
    private Long fiTrangthai;
    private Date fiNgaytao;

    public TbdLichsu04() {
    }

    public TbdLichsu04(Long fiId) {
        this.fiId = fiId;
    }

    public Long getFiId() {
        return fiId;
    }

    public void setFiId(Long fiId) {
        this.fiId = fiId;
    }

    public String getFiDonviXuly() {
        return fiDonviXuly;
    }

    public void setFiDonviXuly(String fiDonviXuly) {
        this.fiDonviXuly = fiDonviXuly;
    }

    public String getFiNguoiXuly() {
        return fiNguoiXuly;
    }

    public void setFiNguoiXuly(String fiNguoiXuly) {
        this.fiNguoiXuly = fiNguoiXuly;
    }

    public Date getFiThoigian() {
        return fiThoigian;
    }

    public void setFiThoigian(Date fiThoigian) {
        this.fiThoigian = fiThoigian;
    }

    public String getFiTenTrangthai() {
        return fiTenTrangthai;
    }

    public void setFiTenTrangthai(String fiTenTrangthai) {
        this.fiTenTrangthai = fiTenTrangthai;
    }

    public String getFiLinkDowload() {
        return fiLinkDowload;
    }

    public void setFiLinkDowload(String fiLinkDowload) {
        this.fiLinkDowload = fiLinkDowload;
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

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiId != null ? fiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdLichsu04)) {
            return false;
        }
        TbdLichsu04 other = (TbdLichsu04) object;
        if ((this.fiId == null && other.fiId != null) || (this.fiId != null && !this.fiId.equals(other.fiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.mard.p04.model.TbdLichsu04[ fiId=" + fiId + " ]";
    }
    
}
