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
public class TbdgpDactrungnguon06 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Long fiIdDactrungnguon;
    
//    @Column(name = "FI_TEN_DONG_VI_PX")
    private String fiTenDongViPx;
    
//    @Column(name = "FI_DANG_NGUON")
    private String fiDangNguon;
    
//    @Column(name = "FI_MA_HIEU_SO_SERI")
    private String fiMaHieuSoSeri;
    
//    @Column(name = "FI_HANG_NUOC_SX")
    private String fiHangNuocSx;
    
//    @Column(name = "FI_TRANG_THAI_VAT_LY")
    private String fiTrangThaiVatLy;
    
//    @Column(name = "FI_HOAT_DO")
    private String fiHoatDo;
    
//    @Column(name = "FI_MA_DONG_VI_PHONG_XA")
    private String fiMaDongViPhongXa;
    
//    @Column(name = "FI_NGAY_XAC_DINH")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgayXacDinh;
    
//    @Column(name = "FI_CONG_VIEC_BX_LQ")
    private String fiCongViecBxLq;
    
//    @Column(name = "FI_THIET_BI_DK")
    private String fiThietBiDk;
    
//    @Column(name = "FI_NOI_SU_DUNG")
    private String fiNoiSuDung;
    
//    @Column(name = "FI_DIA_CHI")
    private String fiDiaChi;
    
//    @Column(name = "FI_TEN_CO_SO")
    private String fiTenCoSo;
    
//    @Column(name = "FI_HOATDONG")
    private Long fiHoatdong;
    
//    @Column(name = "FI_NGUOI_TAO")
    private String fiNguoiTao;
    
//    @Column(name = "FI_NGAY_TAO")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgayTao;
    
//    @Column(name = "FI_NGAY_CAP_NHAT")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgayCapNhat;
    
//    @Column(name = "FI_CGP_ID")
    private Long fiCgpId;
    
//    @Column(name = "FI_ID_HOSO")
    private Long fiIdHoso;
    
//    @Column(name = "FI_MA_HOSO")
    private String fiMaHoso;

    public TbdgpDactrungnguon06() {
    }

    public TbdgpDactrungnguon06(Long fiIdDactrungnguon) {
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

    public String getFiMaDongViPhongXa() {
        return fiMaDongViPhongXa;
    }

    public void setFiMaDongViPhongXa(String fiMaDongViPhongXa) {
        this.fiMaDongViPhongXa = fiMaDongViPhongXa;
    }
    
    public void setFiMaHieuSoSeri(String fiMaHieuSoSeri) {
        this.fiMaHieuSoSeri = fiMaHieuSoSeri;
    }

    public String getFiHangNuocSx() {
        return fiHangNuocSx;
    }

    public void setFiHangNuocSx(String fiHangNuocSx) {
        this.fiHangNuocSx = fiHangNuocSx;
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

    public Date getFiNgayXacDinh() {
        return fiNgayXacDinh;
    }

    public void setFiNgayXacDinh(Date fiNgayXacDinh) {
        this.fiNgayXacDinh = fiNgayXacDinh;
    }

    public String getFiCongViecBxLq() {
        return fiCongViecBxLq;
    }

    public void setFiCongViecBxLq(String fiCongViecBxLq) {
        this.fiCongViecBxLq = fiCongViecBxLq;
    }

    public String getFiThietBiDk() {
        return fiThietBiDk;
    }

    public void setFiThietBiDk(String fiThietBiDk) {
        this.fiThietBiDk = fiThietBiDk;
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

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
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

    public Long getFiCgpId() {
        return fiCgpId;
    }

    public void setFiCgpId(Long fiCgpId) {
        this.fiCgpId = fiCgpId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdDactrungnguon != null ? fiIdDactrungnguon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdgpDactrungnguon06)) {
            return false;
        }
        TbdgpDactrungnguon06 other = (TbdgpDactrungnguon06) object;
        if ((this.fiIdDactrungnguon == null && other.fiIdDactrungnguon != null) || (this.fiIdDactrungnguon != null && !this.fiIdDactrungnguon.equals(other.fiIdDactrungnguon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p02.model.TbdgpDactrungnguon02[ fiIdDactrungnguon=" + fiIdDactrungnguon + " ]";
    }

}
