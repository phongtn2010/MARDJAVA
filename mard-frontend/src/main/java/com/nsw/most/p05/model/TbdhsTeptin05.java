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
 * @author Antsoft
 */
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "Tep_tin")
public class TbdhsTeptin05 implements Serializable {

    //    @XmlTransient
    //    @XmlElement(name = "ToOrganization")
//    @XmlTransient
    private static final long serialVersionUID = 1L;

//    @XmlTransient
    private Long fiIdTeptin;

//    @XmlTransient
    private Long fiIdHoso;

//    @XmlElement(name = "loai_tep_tin")
    private Integer fiLoaiTepTin;
    
//    @XmlElement(name = "ten_loai_tep")
    private String fiTenLoaiTep;
    
//    @XmlTransient
    private String fiTenTepTin;
    
//    @XmlElement(name = "tep_tin_id")
    private String fiTepTinId;
    
//    @XmlTransient
    private String fiMaHoso;
    
//    @XmlTransient
    private Long fiHoatdong;
    
//    @XmlTransient
    private String fiNguoitao;
    
//    @XmlTransient
    private Date fiNgaytao;
    
//    @XmlTransient
    private Date fiNgaycapnhat;
    
//    @XmlTransient
    private Long fiNguoicapnhap;

    public TbdhsTeptin05() {
    }

    public TbdhsTeptin05(Long fiIdTeptin) {
        this.fiIdTeptin = fiIdTeptin;
    }

    public Long getFiIdTeptin() {
        return fiIdTeptin;
    }

    public void setFiIdTeptin(Long fiIdTeptin) {
        this.fiIdTeptin = fiIdTeptin;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Integer getFiLoaiTepTin() {
        return fiLoaiTepTin;
    }

    public void setFiLoaiTepTin(Integer fiLoaiTepTin) {
        this.fiLoaiTepTin = fiLoaiTepTin;
    }

    public String getFiTenLoaiTep() {
        return fiTenLoaiTep;
    }

    public void setFiTenLoaiTep(String fiTenLoaiTep) {
        this.fiTenLoaiTep = fiTenLoaiTep;
    }

    public String getFiTenTepTin() {
        return fiTenTepTin;
    }

    public void setFiTenTepTin(String fiTenTepTin) {
        this.fiTenTepTin = fiTenTepTin;
    }

    public String getFiTepTinId() {
        return fiTepTinId;
    }

    public void setFiTepTinId(String fiTepTinId) {
        this.fiTepTinId = fiTepTinId;
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

    public Date getFiNgaycapnhat() {
        return fiNgaycapnhat;
    }

    public void setFiNgaycapnhat(Date fiNgaycapnhat) {
        this.fiNgaycapnhat = fiNgaycapnhat;
    }

    public Long getFiNguoicapnhap() {
        return fiNguoicapnhap;
    }

    public void setFiNguoicapnhap(Long fiNguoicapnhap) {
        this.fiNguoicapnhap = fiNguoicapnhap;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdTeptin != null ? fiIdTeptin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdhsTeptin05)) {
            return false;
        }
        TbdhsTeptin05 other = (TbdhsTeptin05) object;
        if ((this.fiIdTeptin == null && other.fiIdTeptin != null) || (this.fiIdTeptin != null && !this.fiIdTeptin.equals(other.fiIdTeptin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p01.model.TbdhsTeptin05[ fiIdTeptin=" + fiIdTeptin + " ]";
    }

}
