/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p06.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Antsoft
 */
public class TbdhsPhieuKbNguonPxk06 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long fiIdPhieuKb;
    
//    @Column(name = "FI_MA_DONG_VI_PHONG_XA")
    private String fiMaDongViPhongXa;
    
//    @Column(name = "FI_TEN_DONG_VI_PHONG_XA")
    private String fiTenDongViPhongXa;
    
//    @Column(name = "FI_MA_HIEU")
    private String fiMaHieu;
    
//    @Column(name = "FI_SO_SERI")
    private String fiSoSeri;
    
//    @Column(name = "FI_HANG_SAN_XUAT")
    private String fiHangSanXuat;
    
//    @Column(name = "FI_HOAT_DO")
    private String fiHoatDo;
    
//    @Column(name = "FI_HOAT_DO_DON_VI")
    private String fiHoatDoDonVi;
    
//    @Column(name = "FI_NGAY_XAC_DINH_HOAT_DO")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgayXacDinhHoatDo;
    
//    @Column(name = "FI_MA_MUC_DICH_SU_DUNG")
    private String fiMaMucDichSuDung;
    
//    @Column(name = "FI_MUC_DICH_SU_DUNG_KHAC")
    private String fiMucDichSuDungKhac;
    
//    @Column(name = "FI_XUAT_XU_NGUON")
    private Long fiXuatXuNguon;
    
//    @Column(name = "FI_XUAT_XU_NGUON_NGAYCAP")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiXuatXuNguonNgaycap;
    
//    @Column(name = "FI_XUAT_XU_NGUON_SGP")
    private String fiXuatXuNguonSgp;
    
//    @Column(name = "FI_CAM_KET_TRA_LAI_NGUON")
    private Long fiCamKetTraLaiNguon;
    
//    @Column(name = "FI_TB_MA_HIEU")
    private String fiTbMaHieu;
    
//    @Column(name = "FI_TB_SO_SERI")
    private String fiTbSoSeri;
    
//    @Column(name = "FI_TB_HANG_NUOC_SAN_XUAT")
    private String fiTbHangNuocSanXuat;
    
//    @Column(name = "FI_TB_NAM_SAN_XUAT")
    private Long fiTbNamSanXuat;
    
//    @Column(name = "FI_TB_DI_DONG_CO_DINH")
    private String fiTbDiDongCoDinh;
    
//    @Column(name = "FI_TB_NOI_DAT")
    private String fiTbNoiDat;
    
//    @Column(name = "FI_TB_KHOI_LUONG_URANI")
    private String fiTbKhoiLuongUrani;
    
//    @Column(name = "FI_HS_CAPGIAYPHEP_PXK_ID")
    private Long fiHsCapgiayphepPxkId;
    
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
    
//    @Column(name = "FI_NG_CAPNHAT")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgCapnhat;

    private String fiTenHoatDoDonVi;
    public TbdhsPhieuKbNguonPxk06() {
    }

    public TbdhsPhieuKbNguonPxk06(Long fiIdPhieuKb) {
        this.fiIdPhieuKb = fiIdPhieuKb;
    }

    public Long getFiIdPhieuKb() {
        return fiIdPhieuKb;
    }

    public void setFiIdPhieuKb(Long fiIdPhieuKb) {
        this.fiIdPhieuKb = fiIdPhieuKb;
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

    public Long getFiXuatXuNguon() {
        return fiXuatXuNguon;
    }

    public void setFiXuatXuNguon(Long fiXuatXuNguon) {
        this.fiXuatXuNguon = fiXuatXuNguon;
    }

    public Date getFiXuatXuNguonNgaycap() {
        return fiXuatXuNguonNgaycap;
    }

    public void setFiXuatXuNguonNgaycap(Date fiXuatXuNguonNgaycap) {
        this.fiXuatXuNguonNgaycap = fiXuatXuNguonNgaycap;
    }

    public String getFiXuatXuNguonSgp() {
        return fiXuatXuNguonSgp;
    }

    public void setFiXuatXuNguonSgp(String fiXuatXuNguonSgp) {
        this.fiXuatXuNguonSgp = fiXuatXuNguonSgp;
    }

    public void setFiHangSanXuat(String fiHangSanXuat) {
        this.fiHangSanXuat = fiHangSanXuat;
    }

    public String getFiHoatDo() {
        return fiHoatDo;
    }

    public void setFiHoatDo(String fiHoatDo) {
        this.fiHoatDo = fiHoatDo;
    }

    public String getFiHoatDoDonVi() {
        return fiHoatDoDonVi;
    }

    public void setFiHoatDoDonVi(String fiHoatDoDonVi) {
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

    public Long getFiCamKetTraLaiNguon() {
        return fiCamKetTraLaiNguon;
    }

    public void setFiCamKetTraLaiNguon(Long fiCamKetTraLaiNguon) {
        this.fiCamKetTraLaiNguon = fiCamKetTraLaiNguon;
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

    public String getFiTbDiDongCoDinh() {
        return fiTbDiDongCoDinh;
    }

    public void setFiTbDiDongCoDinh(String fiTbDiDongCoDinh) {
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

    public Long getFiHsCapgiayphepPxkId() {
        return fiHsCapgiayphepPxkId;
    }

    public void setFiHsCapgiayphepPxkId(Long fiHsCapgiayphepPxkId) {
        this.fiHsCapgiayphepPxkId = fiHsCapgiayphepPxkId;
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
        hash += (fiIdPhieuKb != null ? fiIdPhieuKb.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdhsPhieuKbNguonPxk06)) {
            return false;
        }
        TbdhsPhieuKbNguonPxk06 other = (TbdhsPhieuKbNguonPxk06) object;
        if ((this.fiIdPhieuKb == null && other.fiIdPhieuKb != null) || (this.fiIdPhieuKb != null && !this.fiIdPhieuKb.equals(other.fiIdPhieuKb))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p02.model.TbdhsPhieuKbNguonPxk02[ fiIdPhieuKb=" + fiIdPhieuKb + " ]";
    }

}
