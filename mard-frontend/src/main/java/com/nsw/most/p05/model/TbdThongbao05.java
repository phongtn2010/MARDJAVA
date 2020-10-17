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
//@XmlType(name = "Thongbao")
public class TbdThongbao05 implements Serializable {

//    @XmlTransient
    private static final long serialVersionUID = 1L;
    
//    @XmlTransient
    private Long fiIdThongbao;
    
//    @XmlElement(name = "noi_dung")
    private Date fiNgayTb;
    
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

    public TbdThongbao05() {
    }

    public TbdThongbao05(Long fiIdThongbao) {
        this.fiIdThongbao = fiIdThongbao;
    }

    public Long getFiIdThongbao() {
        return fiIdThongbao;
    }

    public void setFiIdThongbao(Long fiIdThongbao) {
        this.fiIdThongbao = fiIdThongbao;
    }

    public Date getFiNgayTb() {
        return fiNgayTb;
    }

    public void setFiNgayTb(Date fiNgayTb) {
        this.fiNgayTb = fiNgayTb;
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
        hash += (fiIdThongbao != null ? fiIdThongbao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdThongbao05)) {
            return false;
        }
        TbdThongbao05 other = (TbdThongbao05) object;
        if ((this.fiIdThongbao == null && other.fiIdThongbao != null) || (this.fiIdThongbao != null && !this.fiIdThongbao.equals(other.fiIdThongbao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p01.model.TbdThongbao01[ fiIdThongbao=" + fiIdThongbao + " ]";
    }

}
