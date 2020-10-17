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
//@XmlType(name = "TB_LePhi_ThamDinh")
public class TbdLephi05 implements Serializable {

//    @XmlTransient
    private static final long serialVersionUID = 1L;

    public static TbdLephi05 save(TbdLephi05 tbdLephi01) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @XmlTransient
    private Long fiIdLephiThamdinh;

//    @XmlElement(name = "co_quan_cap")
    private Date fiNgayThongBao;

//    @XmlElement(name = "phi_thamdinh")
    private Long fiPhiThamdinh;
    
//    @XmlElement(name = "noi_dung")
    private String fiNoiDung;
    
//    @XmlElement(name = "link_thongbaophi")
    private String fiLinkThongbaophi;
    
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

    public TbdLephi05() {
    }

    public TbdLephi05(Long fiIdLephiThamdinh) {
        this.fiIdLephiThamdinh = fiIdLephiThamdinh;
    }

    public Long getFiIdLephiThamdinh() {
        return fiIdLephiThamdinh;
    }

    public void setFiIdLephiThamdinh(Long fiIdLephiThamdinh) {
        this.fiIdLephiThamdinh = fiIdLephiThamdinh;
    }

    public Date getFiNgayThongBao() {
        return fiNgayThongBao;
    }

    public void setFiNgayThongBao(Date fiNgayThongBao) {
        this.fiNgayThongBao = fiNgayThongBao;
    }

    public Long getFiPhiThamdinh() {
        return fiPhiThamdinh;
    }

    public void setFiPhiThamdinh(Long fiPhiThamdinh) {
        this.fiPhiThamdinh = fiPhiThamdinh;
    }

    public String getFiNoiDung() {
        return fiNoiDung;
    }

    public void setFiNoiDung(String fiNoiDung) {
        this.fiNoiDung = fiNoiDung;
    }

    public String getFiLinkThongbaophi() {
        return fiLinkThongbaophi;
    }

    public void setFiLinkThongbaophi(String fiLinkThongbaophi) {
        this.fiLinkThongbaophi = fiLinkThongbaophi;
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
        hash += (fiIdLephiThamdinh != null ? fiIdLephiThamdinh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdLephi05)) {
            return false;
        }
        TbdLephi05 other = (TbdLephi05) object;
        if ((this.fiIdLephiThamdinh == null && other.fiIdLephiThamdinh != null) || (this.fiIdLephiThamdinh != null && !this.fiIdLephiThamdinh.equals(other.fiIdLephiThamdinh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p01.model.TbdLephi01[ fiIdLephiThamdinh=" + fiIdLephiThamdinh + " ]";
    }

}
