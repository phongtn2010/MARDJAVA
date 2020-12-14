/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.monre.p09.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ly Coi
 */
public class Tbdhoso9 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long fiIdHoso;
    private String fiMaHoso;
    private String fiMaCoQuan;
    private String fiTenCoQuan;
    private String fiMaSoThue;
    private String fiTenDn;
    private String fiSoGcnDkkd;
    private Date fiNgaycapGcnDkkd;
    private String fiNoicapGcnDkkd;
    private String fiTruSoChinh;
    private String fiNguoiDaiDien;
    private String fiSdtDn;
    private String fiFaxDn;
    private String fiEmailDn;
    private Date fiNgayGui;
    private Long fiMucDich;
    private Date fiThoiGianBatDau;
    private Date fiThoiGianKetThuc;
    private String fiCachThucThuThap;
    private String fiTenToChuc;
    private String fiNguoiDaiDienCc;
    private String fiDiaChiCc;
    private String fiChucVuCc;
    private String fiSdtCc;
    private String fiFaxCc;
    private String fiSuDungNguonGen;
    private String fiSoLuong;
    private String fiSovb;
    private Date fiNgaycapvb;
    private Date fiNgaytao;
    private String fiNguoitao;
    private String fiCapnhat;
    private Long fiHoatdong;
    private Long fiTrangthai;
    private String fiTenTt;

    
    private List<TbdhsNguongen9> lstNguongen9;

    
    private List<TbdhsMaugen9> lstMaugen9;

    
    private List<Tbddinhkem9> lstDinhKem9;

    public Tbdhoso9() {
    }

    public Tbdhoso9(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
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

    public String getFiMaSoThue() {
        return fiMaSoThue;
    }

    public void setFiMaSoThue(String fiMaSoThue) {
        this.fiMaSoThue = fiMaSoThue;
    }

    public String getFiTenDn() {
        return fiTenDn;
    }

    public void setFiTenDn(String fiTenDn) {
        this.fiTenDn = fiTenDn;
    }

    public String getFiSoGcnDkkd() {
        return fiSoGcnDkkd;
    }

    public void setFiSoGcnDkkd(String fiSoGcnDkkd) {
        this.fiSoGcnDkkd = fiSoGcnDkkd;
    }

    public Date getFiNgaycapGcnDkkd() {
        return fiNgaycapGcnDkkd;
    }

    public void setFiNgaycapGcnDkkd(Date fiNgaycapGcnDkkd) {
        this.fiNgaycapGcnDkkd = fiNgaycapGcnDkkd;
    }

    public String getFiNoicapGcnDkkd() {
        return fiNoicapGcnDkkd;
    }

    public void setFiNoicapGcnDkkd(String fiNoicapGcnDkkd) {
        this.fiNoicapGcnDkkd = fiNoicapGcnDkkd;
    }

    public String getFiTruSoChinh() {
        return fiTruSoChinh;
    }

    public void setFiTruSoChinh(String fiTruSoChinh) {
        this.fiTruSoChinh = fiTruSoChinh;
    }

    public String getFiNguoiDaiDien() {
        return fiNguoiDaiDien;
    }

    public void setFiNguoiDaiDien(String fiNguoiDaiDien) {
        this.fiNguoiDaiDien = fiNguoiDaiDien;
    }

    public String getFiSdtDn() {
        return fiSdtDn;
    }

    public void setFiSdtDn(String fiSdtDn) {
        this.fiSdtDn = fiSdtDn;
    }

    public String getFiFaxDn() {
        return fiFaxDn;
    }

    public void setFiFaxDn(String fiFaxDn) {
        this.fiFaxDn = fiFaxDn;
    }

    public String getFiEmailDn() {
        return fiEmailDn;
    }

    public void setFiEmailDn(String fiEmailDn) {
        this.fiEmailDn = fiEmailDn;
    }

    public Date getFiNgayGui() {
        return fiNgayGui;
    }

    public void setFiNgayGui(Date fiNgayGui) {
        this.fiNgayGui = fiNgayGui;
    }

    public Long getFiMucDich() {
        return fiMucDich;
    }

    public void setFiMucDich(Long fiMucDich) {
        this.fiMucDich = fiMucDich;
    }

    public Date getFiThoiGianBatDau() {
        return fiThoiGianBatDau;
    }

    public void setFiThoiGianBatDau(Date fiThoiGianBatDau) {
        this.fiThoiGianBatDau = fiThoiGianBatDau;
    }

    public Date getFiThoiGianKetThuc() {
        return fiThoiGianKetThuc;
    }

    public void setFiThoiGianKetThuc(Date fiThoiGianKetThuc) {
        this.fiThoiGianKetThuc = fiThoiGianKetThuc;
    }

    public String getFiCachThucThuThap() {
        return fiCachThucThuThap;
    }

    public void setFiCachThucThuThap(String fiCachThucThuThap) {
        this.fiCachThucThuThap = fiCachThucThuThap;
    }

    public String getFiTenToChuc() {
        return fiTenToChuc;
    }

    public void setFiTenToChuc(String fiTenToChuc) {
        this.fiTenToChuc = fiTenToChuc;
    }

    public String getFiNguoiDaiDienCc() {
        return fiNguoiDaiDienCc;
    }

    public void setFiNguoiDaiDienCc(String fiNguoiDaiDienCc) {
        this.fiNguoiDaiDienCc = fiNguoiDaiDienCc;
    }

    public String getFiDiaChiCc() {
        return fiDiaChiCc;
    }

    public void setFiDiaChiCc(String fiDiaChiCc) {
        this.fiDiaChiCc = fiDiaChiCc;
    }

    public String getFiChucVuCc() {
        return fiChucVuCc;
    }

    public void setFiChucVuCc(String fiChucVuCc) {
        this.fiChucVuCc = fiChucVuCc;
    }

    public String getFiSdtCc() {
        return fiSdtCc;
    }

    public void setFiSdtCc(String fiSdtCc) {
        this.fiSdtCc = fiSdtCc;
    }

    public String getFiFaxCc() {
        return fiFaxCc;
    }

    public void setFiFaxCc(String fiFaxCc) {
        this.fiFaxCc = fiFaxCc;
    }

    public String getFiSuDungNguonGen() {
        return fiSuDungNguonGen;
    }

    public void setFiSuDungNguonGen(String fiSuDungNguonGen) {
        this.fiSuDungNguonGen = fiSuDungNguonGen;
    }

    public String getFiSoLuong() {
        return fiSoLuong;
    }

    public void setFiSoLuong(String fiSoLuong) {
        this.fiSoLuong = fiSoLuong;
    }

    public String getFiSovb() {
        return fiSovb;
    }

    public void setFiSovb(String fiSovb) {
        this.fiSovb = fiSovb;
    }

    public Date getFiNgaycapvb() {
        return fiNgaycapvb;
    }

    public void setFiNgaycapvb(Date fiNgaycapvb) {
        this.fiNgaycapvb = fiNgaycapvb;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public String getFiCapnhat() {
        return fiCapnhat;
    }

    public void setFiCapnhat(String fiCapnhat) {
        this.fiCapnhat = fiCapnhat;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public List<TbdhsNguongen9> getLstNguongen9() {
        return lstNguongen9;
    }

    public void setLstNguongen9(List<TbdhsNguongen9> lstNguongen9) {
        this.lstNguongen9 = lstNguongen9;
    }

    public List<TbdhsMaugen9> getLstMaugen9() {
        return lstMaugen9;
    }

    public void setLstMaugen9(List<TbdhsMaugen9> lstMaugen9) {
        this.lstMaugen9 = lstMaugen9;
    }

    public List<Tbddinhkem9> getLstDinhKem9() {
        return lstDinhKem9;
    }

    public void setLstDinhKem9(List<Tbddinhkem9> lstDinhKem9) {
        this.lstDinhKem9 = lstDinhKem9;
    }

    public String getFiTenTt() {
        return fiTenTt;
    }

    public void setFiTenTt(String fiTenTt) {
        this.fiTenTt = fiTenTt;
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
        if (!(object instanceof Tbdhoso9)) {
            return false;
        }
        Tbdhoso9 other = (Tbdhoso9) object;
        if ((this.fiIdHoso == null && other.fiIdHoso != null) || (this.fiIdHoso != null && !this.fiIdHoso.equals(other.fiIdHoso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.monre.p09.model.Tbdhoso9[ fiIdHoso=" + fiIdHoso + " ]";
    }

}
