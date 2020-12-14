/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p06.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Antsoft
 */
public class Tbdhoso06 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdHoso;
    private String fiMaCoQuan;
    private String fiTenCoQuan;
    private Long fiHinhThucCap;
    private String fiSoGiayPhep;
    private Date fiNgayCap;
    private String fiTtcTenToChuc;
    private String fiTtcDiaChi;
    private String fiTtcDienThoai;
    private String fiTtcFax;
    private String fiTtcEmail;
    private String fiNddHoTen;
    private String fiNddChucVu;
    private String fiNddCmnd;
    private String fiTtTiepNhanTen;
    private String fiTtTiepNhanDiaChi;
    private String fiTtTiepNhanDienThoai;
    private String fiTtTiepNhanEmail;
    private String fiTtTiepNhanFax;
    private String fiTtTiepNhanQuocgia;
    private Date fiNkcpxNgayDuKien;
    private String fiNkcpxMaTinh;
    private String fiNkcpxTenTinh;
    private String fiNkcpxMaCuaKhau;
    private String fiNkcpxTenCuaKhau;
    private Long fiTrangThai;
    private String fiNguoiTao;
    private Date fiNgayTao;
    private Date fiNgayCapNhat;
    private Long fiHoatdong;
    private String fiMaHoso;
    private Date fiNgaygui;
    private Date fiNgayTiepnhan;
    private Long fiLydocaplai;
    private List<TbdhsPhieuKbNguonPxk06> lstTbdhsPhieuKbNguonPxk06;
    private List<TbdhsPhieuNguonPxkQsd06> lstTbdhsPhieuNguonPxkQsd06;
    private List<TbdhsPhieuKbNguonPxh06> lstTbdhsPhieuKbNguonPxh06;
    private List<TbdhsDinhkem06> lstTbdhsTeptin06;

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

    public String getFiTtTiepNhanTen() {
        return fiTtTiepNhanTen;
    }

    public void setFiTtTiepNhanTen(String fiTtTiepNhanTen) {
        this.fiTtTiepNhanTen = fiTtTiepNhanTen;
    }

    public String getFiTtTiepNhanDiaChi() {
        return fiTtTiepNhanDiaChi;
    }

    public void setFiTtTiepNhanDiaChi(String fiTtTiepNhanDiaChi) {
        this.fiTtTiepNhanDiaChi = fiTtTiepNhanDiaChi;
    }

    public String getFiTtTiepNhanDienThoai() {
        return fiTtTiepNhanDienThoai;
    }

    public void setFiTtTiepNhanDienThoai(String fiTtTiepNhanDienThoai) {
        this.fiTtTiepNhanDienThoai = fiTtTiepNhanDienThoai;
    }

    public String getFiTtTiepNhanEmail() {
        return fiTtTiepNhanEmail;
    }

    public void setFiTtTiepNhanEmail(String fiTtTiepNhanEmail) {
        this.fiTtTiepNhanEmail = fiTtTiepNhanEmail;
    }

    public String getFiTtTiepNhanFax() {
        return fiTtTiepNhanFax;
    }

    public void setFiTtTiepNhanFax(String fiTtTiepNhanFax) {
        this.fiTtTiepNhanFax = fiTtTiepNhanFax;
    }

    public String getFiTtTiepNhanQuocgia() {
        return fiTtTiepNhanQuocgia;
    }

    public void setFiTtTiepNhanQuocgia(String fiTtTiepNhanQuocgia) {
        this.fiTtTiepNhanQuocgia = fiTtTiepNhanQuocgia;
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

    public Long getFiTrangThai() {
        return fiTrangThai;
    }

    public void setFiTrangThai(Long fiTrangThai) {
        this.fiTrangThai = fiTrangThai;
    }

    public String getFiNguoiTao() {
        return fiNguoiTao;
    }

    public void setFiNguoiTao(String fiNguoiTao) {
        this.fiNguoiTao = fiNguoiTao;
    }

    public Date getFiNgayTao() {
        return fiNgayTao;
    }

    public void setFiNgayTao(Date fiNgayTao) {
        this.fiNgayTao = fiNgayTao;
    }

    public Date getFiNgayCapNhat() {
        return fiNgayCapNhat;
    }

    public void setFiNgayCapNhat(Date fiNgayCapNhat) {
        this.fiNgayCapNhat = fiNgayCapNhat;
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

    public Date getFiNgaygui() {
        return fiNgaygui;
    }

    public void setFiNgaygui(Date fiNgaygui) {
        this.fiNgaygui = fiNgaygui;
    }

    public Date getFiNgayTiepnhan() {
        return fiNgayTiepnhan;
    }

    public void setFiNgayTiepnhan(Date fiNgayTiepnhan) {
        this.fiNgayTiepnhan = fiNgayTiepnhan;
    }

    public Long getFiLydocaplai() {
        return fiLydocaplai;
    }

    public void setFiLydocaplai(Long fiLydocaplai) {
        this.fiLydocaplai = fiLydocaplai;
    }

    public List<TbdhsPhieuKbNguonPxk06> getLstTbdhsPhieuKbNguonPxk06() {
        return lstTbdhsPhieuKbNguonPxk06;
    }

    public void setLstTbdhsPhieuKbNguonPxk06(List<TbdhsPhieuKbNguonPxk06> lstTbdhsPhieuKbNguonPxk06) {
        this.lstTbdhsPhieuKbNguonPxk06 = lstTbdhsPhieuKbNguonPxk06;
    }

    public List<TbdhsPhieuNguonPxkQsd06> getLstTbdhsPhieuNguonPxkQsd06() {
        return lstTbdhsPhieuNguonPxkQsd06;
    }

    public void setLstTbdhsPhieuNguonPxkQsd06(List<TbdhsPhieuNguonPxkQsd06> lstTbdhsPhieuNguonPxkQsd06) {
        this.lstTbdhsPhieuNguonPxkQsd06 = lstTbdhsPhieuNguonPxkQsd06;
    }

    public List<TbdhsPhieuKbNguonPxh06> getLstTbdhsPhieuKbNguonPxh06() {
        return lstTbdhsPhieuKbNguonPxh06;
    }

    public void setLstTbdhsPhieuKbNguonPxh06(List<TbdhsPhieuKbNguonPxh06> lstTbdhsPhieuKbNguonPxh06) {
        this.lstTbdhsPhieuKbNguonPxh06 = lstTbdhsPhieuKbNguonPxh06;
    }

    public List<TbdhsDinhkem06> getLstTbdhsTeptin06() {
        return lstTbdhsTeptin06;
    }

    public void setLstTbdhsTeptin06(List<TbdhsDinhkem06> lstTbdhsTeptin06) {
        this.lstTbdhsTeptin06 = lstTbdhsTeptin06;
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
        if (!(object instanceof Tbdhoso06)) {
            return false;
        }
        Tbdhoso06 other = (Tbdhoso06) object;
        if ((this.fiIdHoso == null && other.fiIdHoso != null) || (this.fiIdHoso != null && !this.fiIdHoso.equals(other.fiIdHoso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p02.model.Tbdhoso06[ fiIdHoso=" + fiIdHoso + " ]";
    }

}
