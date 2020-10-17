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
//@XmlType(name = "Thong_tin_Dac_Trung_nguon")
public class TbdgpDactrungnguon05 implements Serializable {

//    @XmlTransient
    private static final long serialVersionUID = 1L;
    
//    @XmlTransient
    private Long fiIdDactrungnguon;
    
//    @XmlElement(name = "ma_dong_vi_phong_xa")
    private String fiMaDongViPx;
    
//    @XmlElement(name = "ten_dong_vi_phong_xa")
    private String fiTenDongViPx;
    
//    @XmlElement(name = "dang_nguon")
    private String fiDangNguon;
    
//    @XmlElement(name = "ma_hieu_so_seri")
    private String fiMaHieuSoSeri;
    
//    @XmlElement(name = "hang_nuoc_san_xuat")
    private String fiHangNuocSanXuat;
    
//    @XmlElement(name = "trang_thai_vat_ly")
    private String fiTrangThaiVatLy;
    
//    @XmlElement(name = "hoat_do")
    private String fiHoatDo;
    
//    @XmlElement(name = "ngay_xac_dinh")
    private String fiNgayXacDinh;
    
//    @XmlElement(name = "cong_viec_bx_lien_quan")
    private String fiCongViecBxLienQuan;
    
//    @XmlElement(name = "thiet_bi_di_kem")
    private String fiThietBiDiKem;
    
//    @XmlElement(name = "noi_su_dung")
    private String fiNoiSuDung;
    
//    @XmlElement(name = "dia_chi")
    private String fiDiaChi;
    
//    @XmlElement(name = "ten_co_so")
    private String fiTenCoSo;
    
//    @XmlTransient
    private Long fiIdCapgiayphep;
    
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

    public TbdgpDactrungnguon05() {
    }

    public TbdgpDactrungnguon05(Long fiIdDactrungnguon) {
        this.fiIdDactrungnguon = fiIdDactrungnguon;
    }

    public Long getFiIdDactrungnguon() {
        return fiIdDactrungnguon;
    }

    public void setFiIdDactrungnguon(Long fiIdDactrungnguon) {
        this.fiIdDactrungnguon = fiIdDactrungnguon;
    }

    public String getFiTenDongViPx() {
        return fiTenDongViPx;
    }

    public void setFiTenDongViPx(String fiTenDongViPx) {
        this.fiTenDongViPx = fiTenDongViPx;
    }

    public String getFiDangNguon() {
        return fiDangNguon;
    }

    public void setFiDangNguon(String fiDangNguon) {
        this.fiDangNguon = fiDangNguon;
    }

    public String getFiMaHieuSoSeri() {
        return fiMaHieuSoSeri;
    }

    public void setFiMaHieuSoSeri(String fiMaHieuSoSeri) {
        this.fiMaHieuSoSeri = fiMaHieuSoSeri;
    }

    public String getFiHangNuocSanXuat() {
        return fiHangNuocSanXuat;
    }

    public void setFiHangNuocSanXuat(String fiHangNuocSanXuat) {
        this.fiHangNuocSanXuat = fiHangNuocSanXuat;
    }

    public String getFiTrangThaiVatLy() {
        return fiTrangThaiVatLy;
    }

    public void setFiTrangThaiVatLy(String fiTrangThaiVatLy) {
        this.fiTrangThaiVatLy = fiTrangThaiVatLy;
    }

    public String getFiHoatDo() {
        return fiHoatDo;
    }

    public void setFiHoatDo(String fiHoatDo) {
        this.fiHoatDo = fiHoatDo;
    }

    public String getFiNgayXacDinh() {
        return fiNgayXacDinh;
    }

    public void setFiNgayXacDinh(String fiNgayXacDinh) {
        this.fiNgayXacDinh = fiNgayXacDinh;
    }

    public String getFiCongViecBxLienQuan() {
        return fiCongViecBxLienQuan;
    }

    public void setFiCongViecBxLienQuan(String fiCongViecBxLienQuan) {
        this.fiCongViecBxLienQuan = fiCongViecBxLienQuan;
    }

    public String getFiThietBiDiKem() {
        return fiThietBiDiKem;
    }

    public void setFiThietBiDiKem(String fiThietBiDiKem) {
        this.fiThietBiDiKem = fiThietBiDiKem;
    }

    public String getFiNoiSuDung() {
        return fiNoiSuDung;
    }

    public void setFiNoiSuDung(String fiNoiSuDung) {
        this.fiNoiSuDung = fiNoiSuDung;
    }

    public String getFiDiaChi() {
        return fiDiaChi;
    }

    public void setFiDiaChi(String fiDiaChi) {
        this.fiDiaChi = fiDiaChi;
    }

    public String getFiTenCoSo() {
        return fiTenCoSo;
    }

    public void setFiTenCoSo(String fiTenCoSo) {
        this.fiTenCoSo = fiTenCoSo;
    }

    public Long getFiIdCapgiayphep() {
        return fiIdCapgiayphep;
    }

    public void setFiIdCapgiayphep(Long fiIdCapgiayphep) {
        this.fiIdCapgiayphep = fiIdCapgiayphep;
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

    public String getFiMaDongViPx() {
        return fiMaDongViPx;
    }

    public void setFiMaDongViPx(String fiMaDongViPx) {
        this.fiMaDongViPx = fiMaDongViPx;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdDactrungnguon != null ? fiIdDactrungnguon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdgpDactrungnguon05)) {
            return false;
        }
        TbdgpDactrungnguon05 other = (TbdgpDactrungnguon05) object;
        if ((this.fiIdDactrungnguon == null && other.fiIdDactrungnguon != null) || (this.fiIdDactrungnguon != null && !this.fiIdDactrungnguon.equals(other.fiIdDactrungnguon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p01.model.TbdgpDactrungnguon01[ fiIdDactrungnguon=" + fiIdDactrungnguon + " ]";
    }

}
