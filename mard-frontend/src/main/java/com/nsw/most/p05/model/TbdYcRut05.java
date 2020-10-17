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
//@XmlType(name = "DN_Yeucau_Rut")
public class TbdYcRut05 implements Serializable {

//    @XmlTransient
    private static final long serialVersionUID = 1L;

//    @XmlTransient
    private Long fiIdDnYcRut;

//    @XmlElement(name = "ngay_rut")
    private Date fiNgayRut;

//    @XmlElement(name = "noi_dung")
    private String fiNoiDung;
    
//    @XmlTransient
    private Long fiTrangThai;
    
//    @XmlTransient
    private Long fiIdHoso;
    
//    @XmlTransient
    private String fiMaHoso;
    
//    @XmlTransient
    private Long fiHoatdong;
    
//    @XmlTransient
    private String fiNguoitao;
    
//    @XmlTransient
    private Date fiNgaytao;
    
//    @XmlTransient
    private Date fiNgaycapnhap;

    public TbdYcRut05() {
    }

    public TbdYcRut05(Long fiIdDnYcRut) {
        this.fiIdDnYcRut = fiIdDnYcRut;
    }

    public Long getFiIdDnYcRut() {
        return fiIdDnYcRut;
    }

    public void setFiIdDnYcRut(Long fiIdDnYcRut) {
        this.fiIdDnYcRut = fiIdDnYcRut;
    }

    public Date getFiNgayRut() {
        return fiNgayRut;
    }

    public void setFiNgayRut(Date fiNgayRut) {
        this.fiNgayRut = fiNgayRut;
    }

    public String getFiNoiDung() {
        return fiNoiDung;
    }

    public void setFiNoiDung(String fiNoiDung) {
        this.fiNoiDung = fiNoiDung;
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
        hash += (fiIdDnYcRut != null ? fiIdDnYcRut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdYcRut05)) {
            return false;
        }
        TbdYcRut05 other = (TbdYcRut05) object;
        if ((this.fiIdDnYcRut == null && other.fiIdDnYcRut != null) || (this.fiIdDnYcRut != null && !this.fiIdDnYcRut.equals(other.fiIdDnYcRut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p01.model.TbdYcRut01[ fiIdDnYcRut=" + fiIdDnYcRut + " ]";
    }

}
