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
public class TbdhsPhieuNguonPxkQsd06 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Long fiIdNguonPxkPsd;

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
    private Date fiNgayXacDinhHoatDo;

//    @Column(name = "FI_MA_MUC_DICH_SU_DUNG")
    private String fiMaMucDichSuDung;

//    @Column(name = "FI_MUC_DICH_SU_DUNG_KHAC")
    private String fiMucDichSuDungKhac;

//    @Column(name = "FI_TB_MA_HIEU")
    private String fiTbMaHieu;

//    @Column(name = "FI_TB_SO_SERI")
    private String fiTbSoSeri;

//    @Column(name = "FI_TB_HANG_SAN_XUAT")
    private String fiTbHangSanXuat;
    
//    @XmlElement(name = "tb_nam_san_xuat")
    private Long fiTbNamSanXuat;

//    @Column(name = "FI_TB_MO_TA_HIEN_TRANG")
    private String fiTbMoTaHienTrang;

//    @Column(name = "FI_XL_BIEN_PHAP_XU_LY")
    private String fiXlBienPhapXuLy;

//    @Column(name = "FI_XL_DIA_DIEM_LUU_GIU")
    private String fiXlDiaDiemLuuGiu;

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

    public TbdhsPhieuNguonPxkQsd06() {
    }

    public TbdhsPhieuNguonPxkQsd06(Long fiIdNguonPxkPsd) {
        this.fiIdNguonPxkPsd = fiIdNguonPxkPsd;
    }

    public Long getFiIdNguonPxkPsd() {
        return fiIdNguonPxkPsd;
    }

    public void setFiIdNguonPxkPsd(Long fiIdNguonPxkPsd) {
        this.fiIdNguonPxkPsd = fiIdNguonPxkPsd;
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

    public String getFiTbHangSanXuat() {
        return fiTbHangSanXuat;
    }

    public void setFiTbHangSanXuat(String fiTbHangSanXuat) {
        this.fiTbHangSanXuat = fiTbHangSanXuat;
    }

    public Long getFiTbNamSanXuat() {
        return fiTbNamSanXuat;
    }

    public void setFiTbNamSanXuat(Long fiTbNamSanXuat) {
        this.fiTbNamSanXuat = fiTbNamSanXuat;
    }

    
    
    public String getFiTbMoTaHienTrang() {
        return fiTbMoTaHienTrang;
    }

    public void setFiTbMoTaHienTrang(String fiTbMoTaHienTrang) {
        this.fiTbMoTaHienTrang = fiTbMoTaHienTrang;
    }

    public String getFiXlBienPhapXuLy() {
        return fiXlBienPhapXuLy;
    }

    public void setFiXlBienPhapXuLy(String fiXlBienPhapXuLy) {
        this.fiXlBienPhapXuLy = fiXlBienPhapXuLy;
    }

    public String getFiXlDiaDiemLuuGiu() {
        return fiXlDiaDiemLuuGiu;
    }

    public void setFiXlDiaDiemLuuGiu(String fiXlDiaDiemLuuGiu) {
        this.fiXlDiaDiemLuuGiu = fiXlDiaDiemLuuGiu;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdNguonPxkPsd != null ? fiIdNguonPxkPsd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdhsPhieuNguonPxkQsd06)) {
            return false;
        }
        TbdhsPhieuNguonPxkQsd06 other = (TbdhsPhieuNguonPxkQsd06) object;
        if ((this.fiIdNguonPxkPsd == null && other.fiIdNguonPxkPsd != null) || (this.fiIdNguonPxkPsd != null && !this.fiIdNguonPxkPsd.equals(other.fiIdNguonPxkPsd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.most.p02.model.TbdhsPhieuNguonPxhQsd02[ fiIdNguonPxkPsd=" + fiIdNguonPxkPsd + " ]";
    }

}
