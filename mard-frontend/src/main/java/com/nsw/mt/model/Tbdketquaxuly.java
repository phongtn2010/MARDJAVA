package com.nsw.mt.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author HP
 */
@XmlRootElement
public class Tbdketquaxuly implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "SequenceGenerator")
    private Long fiTbdketquaxulyId;
    @Column(name = "FI_TEN_BOPHAN")
    private String fiTenBophan;
    @Column(name = "FI_TEN_NHANVIEN")
    private String fiTenNhanvien;
    @Column(name = "FI_NOIDUNG")
    private String fiNoidung;
    @Column(name = "FI_ID_NSW")
    private Long fiIdNsw;
    @Column(name = "FI_ID_MT")
    private Long fiIdMt;
    @Column(name = "FI_NGAYXULY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgayxuly;
    @Column(name = "FI_TEN_FILE")
    private String fiTenFile;
    @Column(name = "FI_LOAI_FILE")
    private String fiLoaiFile;
    @Column(name = "FI_NOIDUNG_FILE")
    private String fiNoidungFile;
    @Column(name = "FI_DUONGDAN_FILE")
    private String fiDuongdanFile;
    @Column(name = "FI_MA_HOSO")
    private String fiMaHoso;
    @Column(name = "FI_LINK_CONGVAN")
    private String fiLinkCongvan;
    public Tbdketquaxuly() {
    }

    public Tbdketquaxuly(Long fiTbdketquaxulyId) {
        this.fiTbdketquaxulyId = fiTbdketquaxulyId;
    }

    public Long getFiTbdketquaxulyId() {
        return fiTbdketquaxulyId;
    }

    public void setFiTbdketquaxulyId(Long fiTbdketquaxulyId) {
        this.fiTbdketquaxulyId = fiTbdketquaxulyId;
    }

    public String getFiTenBophan() {
        return fiTenBophan;
    }

    public void setFiTenBophan(String fiTenBophan) {
        this.fiTenBophan = fiTenBophan;
    }

    public String getFiTenNhanvien() {
        return fiTenNhanvien;
    }

    public void setFiTenNhanvien(String fiTenNhanvien) {
        this.fiTenNhanvien = fiTenNhanvien;
    }

    public String getFiNoidung() {
        return fiNoidung;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public Long getFiIdNsw() {
        return fiIdNsw;
    }

    public void setFiIdNsw(Long fiIdNsw) {
        this.fiIdNsw = fiIdNsw;
    }

    public Long getFiIdMt() {
        return fiIdMt;
    }

    public void setFiIdMt(Long fiIdMt) {
        this.fiIdMt = fiIdMt;
    }

    public Date getFiNgayxuly() {
        return fiNgayxuly;
    }

    public void setFiNgayxuly(Date fiNgayxuly) {
        this.fiNgayxuly = fiNgayxuly;
    }

    public String getFiTenFile() {
        return fiTenFile;
    }

    public void setFiTenFile(String fiTenFile) {
        this.fiTenFile = fiTenFile;
    }

    public String getFiLoaiFile() {
        return fiLoaiFile;
    }

    public void setFiLoaiFile(String fiLoaiFile) {
        this.fiLoaiFile = fiLoaiFile;
    }

    public String getFiNoidungFile() {
        return fiNoidungFile;
    }

    public void setFiNoidungFile(String fiNoidungFile) {
        this.fiNoidungFile = fiNoidungFile;
    }

    public String getFiDuongdanFile() {
        return fiDuongdanFile;
    }

    public void setFiDuongdanFile(String fiDuongdanFile) {
        this.fiDuongdanFile = fiDuongdanFile;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiLinkCongvan() {
        return fiLinkCongvan;
    }

    public void setFiLinkCongvan(String fiLinkCongvan) {
        this.fiLinkCongvan = fiLinkCongvan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiTbdketquaxulyId != null ? fiTbdketquaxulyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbdketquaxuly)) {
            return false;
        }
        Tbdketquaxuly other = (Tbdketquaxuly) object;
        if ((this.fiTbdketquaxulyId == null && other.fiTbdketquaxulyId != null) || (this.fiTbdketquaxulyId != null && !this.fiTbdketquaxulyId.equals(other.fiTbdketquaxulyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.mt.model.Tbdketquaxuly[ fiTbdketquaxulyId=" + fiTbdketquaxulyId + " ]";
    }

}

