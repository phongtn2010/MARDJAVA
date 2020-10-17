/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p05.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Antsoft
 */
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "Phieu_khai_bao_nguon_pxk")
public class TbdhsNkpxTtpnpxk05 implements Serializable {

//    @XmlTransient
    private static final long serialVersionUID = 1L;
    
//    @XmlTransient
    private Long fiIdTtpnpxk;
    
//    @XmlTransient
    private Long fiIdHoso;
    
//    @XmlElement(name = "ma_dong_vi_phong_xa")
    private String fiMaDongViPhongXa;
    
//    @XmlElement(name = "ten_dong_vi_phong_xa")
    private String fiTenDongViPhongXa;
   
//    @XmlElement(name = "ma_hieu")
    private String fiMaHieu;
    
//    @XmlElement(name = "so_seri")
    private String fiSoSeri;
    
//    @XmlElement(name = "hang_san_xuat")
    private String fiHangSanXuat;
    
//    @XmlElement(name = "hoat_do")
    private BigDecimal fiHoatDo;
    
//    @XmlElement(name = "hoat_do_don_vi")
    private Long fiHoatDoDonVi;
    
//    @XmlElement(name = "ngay_xac_dinh_hoat_do")
    private Date fiNgayXacDinhHoatDo;
    
//    @XmlElement(name = "ma_muc_dich_su_dung")
    private String fiMaMucDichSuDung;
    
//    @XmlElement(name = "muc_dich_su_dung_khac")
    private String fiMucDichSuDungKhac;
    
//    @XmlElement(name = "cam_ket_tra_lai_nguon_cho_ncc")
    private Long fiCamKetTraNguon;
    
//    @XmlElement(name = "tb_ma_hieu")
    private String fiTbMaHieu;
    
//    @XmlElement(name = "tb_so_seri")
    private String fiTbSoSeri;
    
//    @XmlElement(name = "tb_hang_nuoc_san_xuat")
    private String fiTbHangNuocSanXuat;
    
//    @XmlElement(name = "tb_nam_san_xuat")
    private Long fiTbNamSanXuat;
    
//    @XmlElement(name = "tb_di_dong_co_dinh")
    private Long fiTbDiDongCoDinh;
    
//    @XmlElement(name = "tb_noi_dat")
    private String fiTbNoiDat;
    
//    @XmlElement(name = "tb_khoi_luong_urani")
    private String fiTbKhoiLuongUrani;
    
//    @XmlTransient
    private Long fiHoatdong;
    
//    @XmlTransient
    private String fiMaHoso;
    
//    @XmlTransient
    private String fiNguoitao;
    
//    @XmlTransient
    private Date fiNgaytao;
    
//    @XmlTransient
    private Date fiNgaycapnhap;
    
    private String fiTenHoatDoDonVi;

    public TbdhsNkpxTtpnpxk05() {
    }

    public TbdhsNkpxTtpnpxk05(Long fiIdTtpnpxk) {
        this.fiIdTtpnpxk = fiIdTtpnpxk;
    }

    public Long getFiIdTtpnpxk() {
        return fiIdTtpnpxk;
    }

    public void setFiIdTtpnpxk(Long fiIdTtpnpxk) {
        this.fiIdTtpnpxk = fiIdTtpnpxk;
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

    public String getFiMaHieu() {
        return fiMaHieu;
    }

    public void setFiMaHieu(String fiMaHieu) {
        this.fiMaHieu = fiMaHieu;
    }

    public String getFiSoSeri() {
        return fiSoSeri;
    }

    public void setFiSoSeri(String fiSoSeri) {
        this.fiSoSeri = fiSoSeri;
    }

    public String getFiHangSanXuat() {
        return fiHangSanXuat;
    }

    public void setFiHangSanXuat(String fiHangSanXuat) {
        this.fiHangSanXuat = fiHangSanXuat;
    }

    public BigDecimal getFiHoatDo() {
        return fiHoatDo;
    }

    public void setFiHoatDo(BigDecimal fiHoatDo) {
        this.fiHoatDo = fiHoatDo;
    }

    

    public Long getFiHoatDoDonVi() {
        return fiHoatDoDonVi;
    }

    public void setFiHoatDoDonVi(Long fiHoatDoDonVi) {
        this.fiHoatDoDonVi = fiHoatDoDonVi;
    }

    public Date getFiNgayXacDinhHoatDo() {
        return fiNgayXacDinhHoatDo;
    }

    public void setFiNgayXacDinhHoatDo(Date fiNgayXacDinhHoatDo) {
        this.fiNgayXacDinhHoatDo = fiNgayXacDinhHoatDo;
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

    public Long getFiCamKetTraNguon() {
        return fiCamKetTraNguon;
    }

    public void setFiCamKetTraNguon(Long fiCamKetTraNguon) {
        this.fiCamKetTraNguon = fiCamKetTraNguon;
    }

    public String getFiTbMaHieu() {
        return fiTbMaHieu;
    }

    public void setFiTbMaHieu(String fiTbMaHieu) {
        this.fiTbMaHieu = fiTbMaHieu;
    }

    public String getFiTbSoSeri() {
        return fiTbSoSeri;
    }

    public void setFiTbSoSeri(String fiTbSoSeri) {
        this.fiTbSoSeri = fiTbSoSeri;
    }

    public String getFiTbHangNuocSanXuat() {
        return fiTbHangNuocSanXuat;
    }

    public void setFiTbHangNuocSanXuat(String fiTbHangNuocSanXuat) {
        this.fiTbHangNuocSanXuat = fiTbHangNuocSanXuat;
    }

    public Long getFiTbNamSanXuat() {
        return fiTbNamSanXuat;
    }

    public void setFiTbNamSanXuat(Long fiTbNamSanXuat) {
        this.fiTbNamSanXuat = fiTbNamSanXuat;
    }

    public Long getFiTbDiDongCoDinh() {
        return fiTbDiDongCoDinh;
    }

    public void setFiTbDiDongCoDinh(Long fiTbDiDongCoDinh) {
        this.fiTbDiDongCoDinh = fiTbDiDongCoDinh;
    }

    public String getFiTbNoiDat() {
        return fiTbNoiDat;
    }

    public void setFiTbNoiDat(String fiTbNoiDat) {
        this.fiTbNoiDat = fiTbNoiDat;
    }

    public String getFiTbKhoiLuongUrani() {
        return fiTbKhoiLuongUrani;
    }

    public void setFiTbKhoiLuongUrani(String fiTbKhoiLuongUrani) {
        this.fiTbKhoiLuongUrani = fiTbKhoiLuongUrani;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
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

    public String getFiTenHoatDoDonVi() {
        return fiTenHoatDoDonVi;
    }

    public void setFiTenHoatDoDonVi(String fiTenHoatDoDonVi) {
        this.fiTenHoatDoDonVi = fiTenHoatDoDonVi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdTtpnpxk != null ? fiIdTtpnpxk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdhsNkpxTtpnpxk05)) {
            return false;
        }
        TbdhsNkpxTtpnpxk05 other = (TbdhsNkpxTtpnpxk05) object;
        if ((this.fiIdTtpnpxk == null && other.fiIdTtpnpxk != null) || (this.fiIdTtpnpxk != null && !this.fiIdTtpnpxk.equals(other.fiIdTtpnpxk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p01.model.TbdhsNkpxTtpnpxk05[ fiIdTtpnpxk=" + fiIdTtpnpxk + " ]";
    }

}
