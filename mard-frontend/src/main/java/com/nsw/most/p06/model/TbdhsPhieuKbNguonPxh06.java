/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p06.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Antsoft
 */
public class TbdhsPhieuKbNguonPxh06 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long fiIdKbNguonPxh;
    
//    @Column(name = "FI_MA_DONG_VI_PHONG_XA")
    private String fiMaDongViPhongXa;
    
//    @Column(name = "FI_TEN_DONG_VI_PHONG_XA")
    private String fiTenDongViPhongXa;
    
//    @Column(name = "FI_MA_HIEU")
    private String fiMaHieu;
    
//    @Column(name = "FI_HANG_NUOC_SAN_XUAT")
    private String fiHangNuocSanXuat;
    
//    @Column(name = "FI_HOAT_DO")
    private BigDecimal fiHoatDo;
    
//    @Column(name = "FI_HOAT_DO_DON_VI")
    private String fiHoatDoDonVi;
    
//    @Column(name = "FI_MA_MUC_DICH_SU_DUNG")
    private String fiMaMucDichSuDung;
    
//    @Column(name = "FI_MUC_DICH_SU_DUNG_KHAC ")
    private String fiMucDichSuDungKhac;
    
//    @Column(name = "FI_ID_HOSO")
    private Long fiIdHoso;
    
//    @Column(name = "FI_MA_HOSO")
    private String fiMaHoso;
    
//    @Column(name = "FI_HOATDONG")
    private Long fiHoatdong;
    
//    @Column(name = "FI_NGUOITAO")
    private String fiNguoitao;
    
//    @Column(name = "FI_NGAYTAO")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaytao;
    
//    @Column(name = "FI_NGAYCAPNHAT")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaycapnhat;

    private String fiTenHoatDoDonVi;

 
    private String fiCongThucHoaHoc;

    private String fiTrangThaiVatLy;


    public TbdhsPhieuKbNguonPxh06() {
    }

    public TbdhsPhieuKbNguonPxh06(Long fiIdKbNguonPxh) {
        this.fiIdKbNguonPxh = fiIdKbNguonPxh;
    }

    public Long getFiIdKbNguonPxh() {
        return fiIdKbNguonPxh;
    }

    public void setFiIdKbNguonPxh(Long fiIdKbNguonPxh) {
        this.fiIdKbNguonPxh = fiIdKbNguonPxh;
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

    public String getFiMaHieu() {
        return fiMaHieu;
    }

    public void setFiMaHieu(String fiMaHieu) {
        this.fiMaHieu = fiMaHieu;
    }

    public String getFiHangNuocSanXuat() {
        return fiHangNuocSanXuat;
    }

    public void setFiHangNuocSanXuat(String fiHangNuocSanXuat) {
        this.fiHangNuocSanXuat = fiHangNuocSanXuat;
    }

    public BigDecimal getFiHoatDo() {
        return fiHoatDo;
    }

    public void setFiHoatDo(BigDecimal fiHoatDo) {
        this.fiHoatDo = fiHoatDo;
    }

    public String getFiHoatDoDonVi() {
        return fiHoatDoDonVi;
    }

    public void setFiHoatDoDonVi(String fiHoatDoDonVi) {
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

    public Date getFiNgaycapnhat() {
        return fiNgaycapnhat;
    }

    public void setFiNgaycapnhat(Date fiNgaycapnhat) {
        this.fiNgaycapnhat = fiNgaycapnhat;
    }


    public String getFiTenHoatDoDonVi() {
        return fiTenHoatDoDonVi;
    }

    public void setFiTenHoatDoDonVi(String fiTenHoatDoDonVi) {
        this.fiTenHoatDoDonVi = fiTenHoatDoDonVi;
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
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdKbNguonPxh != null ? fiIdKbNguonPxh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdhsPhieuKbNguonPxh06)) {
            return false;
        }
        TbdhsPhieuKbNguonPxh06 other = (TbdhsPhieuKbNguonPxh06) object;
        if ((this.fiIdKbNguonPxh == null && other.fiIdKbNguonPxh != null) || (this.fiIdKbNguonPxh != null && !this.fiIdKbNguonPxh.equals(other.fiIdKbNguonPxh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p02.model.TbdhsPhieuKbNguonPxh02[ fiIdKbNguonPxh=" + fiIdKbNguonPxh + " ]";
    }

}
