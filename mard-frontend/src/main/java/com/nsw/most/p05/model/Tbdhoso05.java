/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p05.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Antsoft
 */
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "HSCapGiayPhep_NKPX")
public class Tbdhoso05 implements Serializable {

//    @XmlTransient
    private static final long serialVersionUID = 1L;

//    @XmlTransient
    private Long fiIdHoso;

//    @XmlElement(name = "ma_co_quan")
    private String fiMaCoQuan;

//    @XmlElement(name = "ten_co_quan")
    private String fiTenCoQuan;

//    @XmlElement(name = "hinh_thuc_cap")
    private Long fiHinhThucCap;

//    @XmlElement(name = "so_giay_phep")
    private String fiSoGiayPhep;

//    @XmlElement(name = "ngay_cap")
    private Date fiNgayCap;

//    @XmlElement(name = "ttc_ten_to_chuc")
    private String fiTtcTenToChuc;

//    @XmlElement(name = "ttc_dia_chi")
    private String fiTtcDiaChi;

//    @XmlElement(name = "ttc_dien_thoai")
    private String fiTtcDienThoai;

//    @XmlElement(name = "ttc_fax")
    private String fiTtcFax;

//    @XmlElement(name = "ttc_email")
    private String fiTtcEmail;

//    @XmlElement(name = "ndd_ho_ten")
    private String fiNddHoTen;

//    @XmlElement(name = "ndd_chuc_vu")
    private String fiNddChucVu;

//    @XmlElement(name = "ndd_cmnd")
    private String fiNddCmnd;

//    @XmlElement(name = "tt_ben_cung_cap_ten")
    private String fiTtBenCungCapTen;

//    @XmlElement(name = "tt_ben_cung_cap_dia_chi")
    private String fiTtBenCungCapDiaChi;

//    @XmlElement(name = "tt_ben_cung_cap_dien_thoai")
    private String fiTtBenCungCapDienThoai;

//    @XmlElement(name = "tt_ben_cung_cap_fax")
    private String fiTtBenCungCapFax;

//    @XmlElement(name = "tt_ben_cung_cap_email")
    private String fiTtBenCungCapEmail;

//    @XmlElement(name = "nkcpx_ngay_du_kien")
    private Date fiNkcpxNgayDuKien;

//    @XmlElement(name = "nkcpx_ma_tinh")
    private String fiNkcpxMaTinh;

//    @XmlElement(name = "nkcpx_ten_tinh")
    private String fiNkcpxTenTinh;

//    @XmlElement(name = "nkcpx_ma_cua_khau")
    private String fiNkcpxMaCuaKhau;

//    @XmlElement(name = "nkcpx_ten_cua_khau")
    private String fiNkcpxTenCuaKhau;

//    @XmlTransient
    private Long fiHoatdong;

//    @XmlTransient
    private String fiNguoitao;

//    @XmlTransient
    private Date fiNgaytao;

//    @XmlTransient
    private Date fiNgaysua;

//    @XmlTransient
    private Date fiNgaygui;

//    @XmlTransient
    private Long fiTrangthai;

//    @XmlTransient
    private String fiMaHoso;
    
    
    private Long fiLydocaplai;
    private Date fiNgayCapPhep;
    private Long fiTrangThaiLePhi;

//    @XmlElementWrapper(name = "Phieu_khai_bao_nguon_pxk")
//    @XmlElement(name = "Thong_tin_phieu_nguon_pxk")
    private List<TbdhsNkpxTtpnpxk05> lstTbdhsNkpxTtpnpxk05;

//    @XmlElementWrapper(name = "Phieu_khai_bao_nguon_pxh")
//    @XmlElement(name = "Thong_tin_phieu_pxh")
    private List<TbdhsTtpPxh05> lstTbdhsTtpPxh05;

//    @XmlElementWrapper(name = "DS_Teptin")
//    @XmlElement(name = "Tep_tin")
    private List<TbdhsDinhkem05> lstTeptin05;

    public List<TbdhsNkpxTtpnpxk05> getLstTbdhsNkpxTtpnpxk05() {
        return lstTbdhsNkpxTtpnpxk05;
    }

    public void setLstTbdhsNkpxTtpnpxk05(List<TbdhsNkpxTtpnpxk05> lstTbdhsNkpxTtpnpxk05) {
        this.lstTbdhsNkpxTtpnpxk05 = lstTbdhsNkpxTtpnpxk05;
    }

    public List<TbdhsTtpPxh05> getLstTbdhsTtpPxh05() {
        return lstTbdhsTtpPxh05;
    }

    public void setLstTbdhsTtpPxh05(List<TbdhsTtpPxh05> lstTbdhsTtpPxh05) {
        this.lstTbdhsTtpPxh05 = lstTbdhsTtpPxh05;
    }

    public List<TbdhsDinhkem05> getLstTeptin05() {
        return lstTeptin05;
    }

    public void setLstTeptin05(List<TbdhsDinhkem05> lstTeptin05) {
        this.lstTeptin05 = lstTeptin05;
    }

    public Tbdhoso05() {
    }

    public Long getFiTrangThaiLePhi() {
        return fiTrangThaiLePhi;
    }

    public void setFiTrangThaiLePhi(Long fiTrangThaiLePhi) {
        this.fiTrangThaiLePhi = fiTrangThaiLePhi;
    }

    public Tbdhoso05(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiMaCoQuan() {
        return fiMaCoQuan;
    }

    public void setFiMaCoQuan(String fiMaCoQuan) {
        this.fiMaCoQuan = fiMaCoQuan;
    }

    public String getFiTenCoQuan() {
        return fiTenCoQuan;
    }

    public void setFiTenCoQuan(String fiTenCoQuan) {
        this.fiTenCoQuan = fiTenCoQuan;
    }

    public Long getFiHinhThucCap() {
        return fiHinhThucCap;
    }

    public void setFiHinhThucCap(Long fiHinhThucCap) {
        this.fiHinhThucCap = fiHinhThucCap;
    }

    public String getFiSoGiayPhep() {
        return fiSoGiayPhep;
    }

    public void setFiSoGiayPhep(String fiSoGiayPhep) {
        this.fiSoGiayPhep = fiSoGiayPhep;
    }

    public Date getFiNgayCap() {
        return fiNgayCap;
    }

    public void setFiNgayCap(Date fiNgayCap) {
        this.fiNgayCap = fiNgayCap;
    }

    public String getFiTtcTenToChuc() {
        return fiTtcTenToChuc;
    }

    public void setFiTtcTenToChuc(String fiTtcTenToChuc) {
        this.fiTtcTenToChuc = fiTtcTenToChuc;
    }

    public String getFiTtcDiaChi() {
        return fiTtcDiaChi;
    }

    public void setFiTtcDiaChi(String fiTtcDiaChi) {
        this.fiTtcDiaChi = fiTtcDiaChi;
    }

    public String getFiTtcDienThoai() {
        return fiTtcDienThoai;
    }

    public void setFiTtcDienThoai(String fiTtcDienThoai) {
        this.fiTtcDienThoai = fiTtcDienThoai;
    }

    public String getFiTtcFax() {
        return fiTtcFax;
    }

    public void setFiTtcFax(String fiTtcFax) {
        this.fiTtcFax = fiTtcFax;
    }

    public String getFiTtcEmail() {
        return fiTtcEmail;
    }

    public void setFiTtcEmail(String fiTtcEmail) {
        this.fiTtcEmail = fiTtcEmail;
    }

    public String getFiNddHoTen() {
        return fiNddHoTen;
    }

    public void setFiNddHoTen(String fiNddHoTen) {
        this.fiNddHoTen = fiNddHoTen;
    }

    public String getFiNddChucVu() {
        return fiNddChucVu;
    }

    public void setFiNddChucVu(String fiNddChucVu) {
        this.fiNddChucVu = fiNddChucVu;
    }

    public String getFiNddCmnd() {
        return fiNddCmnd;
    }

    public void setFiNddCmnd(String fiNddCmnd) {
        this.fiNddCmnd = fiNddCmnd;
    }

    public String getFiTtBenCungCapTen() {
        return fiTtBenCungCapTen;
    }

    public void setFiTtBenCungCapTen(String fiTtBenCungCapTen) {
        this.fiTtBenCungCapTen = fiTtBenCungCapTen;
    }

    public String getFiTtBenCungCapDiaChi() {
        return fiTtBenCungCapDiaChi;
    }

    public void setFiTtBenCungCapDiaChi(String fiTtBenCungCapDiaChi) {
        this.fiTtBenCungCapDiaChi = fiTtBenCungCapDiaChi;
    }

    public String getFiTtBenCungCapDienThoai() {
        return fiTtBenCungCapDienThoai;
    }

    public void setFiTtBenCungCapDienThoai(String fiTtBenCungCapDienThoai) {
        this.fiTtBenCungCapDienThoai = fiTtBenCungCapDienThoai;
    }

    public String getFiTtBenCungCapFax() {
        return fiTtBenCungCapFax;
    }

    public void setFiTtBenCungCapFax(String fiTtBenCungCapFax) {
        this.fiTtBenCungCapFax = fiTtBenCungCapFax;
    }

    public String getFiTtBenCungCapEmail() {
        return fiTtBenCungCapEmail;
    }

    public void setFiTtBenCungCapEmail(String fiTtBenCungCapEmail) {
        this.fiTtBenCungCapEmail = fiTtBenCungCapEmail;
    }

    public Date getFiNkcpxNgayDuKien() {
        return fiNkcpxNgayDuKien;
    }

    public void setFiNkcpxNgayDuKien(Date fiNkcpxNgayDuKien) {
        this.fiNkcpxNgayDuKien = fiNkcpxNgayDuKien;
    }

    public String getFiNkcpxMaTinh() {
        return fiNkcpxMaTinh;
    }

    public void setFiNkcpxMaTinh(String fiNkcpxMaTinh) {
        this.fiNkcpxMaTinh = fiNkcpxMaTinh;
    }

    public String getFiNkcpxTenTinh() {
        return fiNkcpxTenTinh;
    }

    public void setFiNkcpxTenTinh(String fiNkcpxTenTinh) {
        this.fiNkcpxTenTinh = fiNkcpxTenTinh;
    }

    public String getFiNkcpxMaCuaKhau() {
        return fiNkcpxMaCuaKhau;
    }

    public void setFiNkcpxMaCuaKhau(String fiNkcpxMaCuaKhau) {
        this.fiNkcpxMaCuaKhau = fiNkcpxMaCuaKhau;
    }

    public String getFiNkcpxTenCuaKhau() {
        return fiNkcpxTenCuaKhau;
    }

    public void setFiNkcpxTenCuaKhau(String fiNkcpxTenCuaKhau) {
        this.fiNkcpxTenCuaKhau = fiNkcpxTenCuaKhau;
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

    public Date getFiNgaysua() {
        return fiNgaysua;
    }

    public void setFiNgaysua(Date fiNgaysua) {
        this.fiNgaysua = fiNgaysua;
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

    public Long getFiLydocaplai() {
        return fiLydocaplai;
    }

    public void setFiLydocaplai(Long fiLydocaplai) {
        this.fiLydocaplai = fiLydocaplai;
    }

    public Date getFiNgayCapPhep() {
        return fiNgayCapPhep;
    }

    public void setFiNgayCapPhep(Date fiNgayCapPhep) {
        this.fiNgayCapPhep = fiNgayCapPhep;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdHoso != null ? fiIdHoso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbdhoso05)) {
            return false;
        }
        Tbdhoso05 other = (Tbdhoso05) object;
        if ((this.fiIdHoso == null && other.fiIdHoso != null) || (this.fiIdHoso != null && !this.fiIdHoso.equals(other.fiIdHoso))) {
            return false;
        }
        return true;
    }

    public Date getFiNgaygui() {
        return fiNgaygui;
    }

    public void setFiNgaygui(Date fiNgaygui) {
        this.fiNgaygui = fiNgaygui;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p01.model.Tbdhoso01[ fiIdHoso=" + fiIdHoso + " ]";
    }

}
