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
//@XmlType(name = "Thong_tin_phieu_pxh")
public class TbdhsTtpPxh05 implements Serializable {

   
//    @XmlTransient
    private static final long serialVersionUID = 1L;
    
//    @XmlTransient
    private String fiIdTtpPxh;
    
//    @XmlTransient
    private Long fiIdHoso;
    
//    @XmlElement(name = "ma_dong_vi_phong_xa")
    private String fiMaDongViPhongXa;
    
//    @XmlElement(name = "ten_dong_vi_phong_xa")
    private String fiTenDongViPhongXa;
    
//    @XmlElement(name = "hang_san_xuat")
    private String fiHangSanXuat;
    
//    @XmlElement(name = "cong_thuc_hoa_hoc")
    private String fiCongThucHoaHoc;
    
//    @XmlElement(name = "trang_thai_vat_ly")
    private String fiTrangThaiVatLy;
    
//    @XmlElement(name = "tong_hoat_do_trong_nam")
    private Long fiTongHoatDoTrongNam;
    
//    @XmlElement(name = "hoat_do_don_vi")
    private Long fiHoatDoDonVi;
    
//    @XmlElement(name = "ma_muc_dich_su_dung")
    private String fiMaMucDichSuDung;
    
//    @XmlElement(name = "muc_dich_su_dung_khac")
    private String fiMucDichSuDungKhac;
    
//    @XmlTransient
    private Long fiTrangthai;
    
//    @XmlTransient
    private String fiMaHoso;
    
//    @XmlTransient
    private String fiNguoitao;
    
//    @XmlTransient
    private Long fiHoatdong;
    
//    @XmlTransient
    private Date fiNgaytao;
    
//    @XmlTransient
    private Date fiNgCapnhat;
    
    private String fiTenHoatDoDonVi;

    
    public TbdhsTtpPxh05() {
    }

    public TbdhsTtpPxh05(String fiIdTtpPxh) {
        this.fiIdTtpPxh = fiIdTtpPxh;
    }

    public String getFiIdTtpPxh() {
        return fiIdTtpPxh;
    }

    public void setFiIdTtpPxh(String fiIdTtpPxh) {
        this.fiIdTtpPxh = fiIdTtpPxh;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiMaDongViPhongXa() {
        return fiMaDongViPhongXa;
    }

    public void setFiMaDongViPhongXa(String fiMaDongViPhongXa) {
        this.fiMaDongViPhongXa = fiMaDongViPhongXa;
    }

    public String getFiTenDongViPhongXa() {
        return fiTenDongViPhongXa;
    }

    public void setFiTenDongViPhongXa(String fiTenDongViPhongXa) {
        this.fiTenDongViPhongXa = fiTenDongViPhongXa;
    }

    public String getFiHangSanXuat() {
        return fiHangSanXuat;
    }

    public void setFiHangSanXuat(String fiHangSanXuat) {
        this.fiHangSanXuat = fiHangSanXuat;
    }

    public String getFiCongThucHoaHoc() {
        return fiCongThucHoaHoc;
    }

    public void setFiCongThucHoaHoc(String fiCongThucHoaHoc) {
        this.fiCongThucHoaHoc = fiCongThucHoaHoc;
    }

    public String getFiTrangThaiVatLy() {
        return fiTrangThaiVatLy;
    }

    public void setFiTrangThaiVatLy(String fiTrangThaiVatLy) {
        this.fiTrangThaiVatLy = fiTrangThaiVatLy;
    }

    public Long getFiTongHoatDoTrongNam() {
        return fiTongHoatDoTrongNam;
    }

    public void setFiTongHoatDoTrongNam(Long fiTongHoatDoTrongNam) {
        this.fiTongHoatDoTrongNam = fiTongHoatDoTrongNam;
    }

    public Long getFiHoatDoDonVi() {
        return fiHoatDoDonVi;
    }

    public void setFiHoatDoDonVi(Long fiHoatDoDonVi) {
        this.fiHoatDoDonVi = fiHoatDoDonVi;
    }

    public String getFiMaMucDichSuDung() {
        return fiMaMucDichSuDung;
    }

    public void setFiMaMucDichSuDung(String fiMaMucDichSuDung) {
        this.fiMaMucDichSuDung = fiMaMucDichSuDung;
    }

    public String getFiMucDichSuDungKhac() {
        return fiMucDichSuDungKhac;
    }

    public void setFiMucDichSuDungKhac(String fiMucDichSuDungKhac) {
        this.fiMucDichSuDungKhac = fiMucDichSuDungKhac;
    }

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
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

    public Date getFiNgCapnhat() {
        return fiNgCapnhat;
    }

    public void setFiNgCapnhat(Date fiNgCapnhat) {
        this.fiNgCapnhat = fiNgCapnhat;
    }

    public String getFiTenHoatDoDonVi() {
        return fiTenHoatDoDonVi;
    }

    public void setFiTenHoatDoDonVi(String fiTenHoatDoDonVi) {
        this.fiTenHoatDoDonVi = fiTenHoatDoDonVi;
    }

    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdTtpPxh != null ? fiIdTtpPxh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdhsTtpPxh05)) {
            return false;
        }
        TbdhsTtpPxh05 other = (TbdhsTtpPxh05) object;
        if ((this.fiIdTtpPxh == null && other.fiIdTtpPxh != null) || (this.fiIdTtpPxh != null && !this.fiIdTtpPxh.equals(other.fiIdTtpPxh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p01.model.TbdhsTtpPxh05[ fiIdTtpPxh=" + fiIdTtpPxh + " ]";
    }

}
