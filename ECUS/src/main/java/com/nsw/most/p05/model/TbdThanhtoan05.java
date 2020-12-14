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
//@XmlType(name = "XacNhan_ThanhToan")
public class TbdThanhtoan05 implements Serializable {

//    @XmlTransient
    private static final long serialVersionUID = 1L;
    
//    @XmlTransient
    private Long fiIdXacnhanThanhtoan;
    
//    @XmlElement(name = "ngay_xu_ly")
    private Date fiNgayXuLy;
    
//    @XmlElement(name = "don_vi_xu_ly")
    private String fiDonViXuLy;
    
//    @XmlTransient
    private Long fiHoatdong;
    
//    @XmlTransient
    private Long fiIdHoso;
    
//    @XmlTransient
    private String fiMaHoso;
    
//    @XmlTransient
    private String fiNguoitao;
    
//    @XmlTransient
    private Date fiNgaytao;
    
//    @XmlTransient
    private Date fiNgaycapnhap;

    public TbdThanhtoan05() {
    }

    public TbdThanhtoan05(Long fiIdXacnhanThanhtoan) {
        this.fiIdXacnhanThanhtoan = fiIdXacnhanThanhtoan;
    }

    public Long getFiIdXacnhanThanhtoan() {
        return fiIdXacnhanThanhtoan;
    }

    public void setFiIdXacnhanThanhtoan(Long fiIdXacnhanThanhtoan) {
        this.fiIdXacnhanThanhtoan = fiIdXacnhanThanhtoan;
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

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
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
        hash += (fiIdXacnhanThanhtoan != null ? fiIdXacnhanThanhtoan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdThanhtoan05)) {
            return false;
        }
        TbdThanhtoan05 other = (TbdThanhtoan05) object;
        if ((this.fiIdXacnhanThanhtoan == null && other.fiIdXacnhanThanhtoan != null) || (this.fiIdXacnhanThanhtoan != null && !this.fiIdXacnhanThanhtoan.equals(other.fiIdXacnhanThanhtoan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p01.model.TbdThanhtoan01[ fiIdXacnhanThanhtoan=" + fiIdXacnhanThanhtoan + " ]";
    }

}
