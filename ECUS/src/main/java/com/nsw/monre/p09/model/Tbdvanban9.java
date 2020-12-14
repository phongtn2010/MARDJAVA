/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.monre.p09.model;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
public class Tbdvanban9 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long fiIdVb;
    private Long fiIdHoso;
    private String fiMaHoso;
    private String fiCoQuanCap;
    private String fiSoVanBan;
    private Date fiNgayKy;
    private String fiNguoiKy;
    private String fiTenTepTin;
    private String fiNoidungTepTin;
    private Long fiMucDich;
    private Date fiThoiGianBatDau;
    private Date fiThoiGianKetThuc;
    private String fiCachThucThuThap;
    private String fiTenToChuc;
    private String fiNguoiDaiDien;
    private String fiDiaChiCc;
    private String fiChucVuCc;
    private String fiSdtCc;
    private String fiFaxCc;
    private String fiSuDungNguonGen;
    private String fiSoLuong;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;
    private Date fiNgCapnhat;
    private Tbddinhkem9 dinhkem;

    public Tbddinhkem9 getDinhkem() {
        return dinhkem;
    }

    public void setDinhkem(Tbddinhkem9 dinhkem) {
        this.dinhkem = dinhkem;
    }

    public Tbdvanban9() {
    }

    public Tbdvanban9(Long fiIdVb) {
        this.fiIdVb = fiIdVb;
    }

    public Long getFiIdVb() {
        return fiIdVb;
    }

    public void setFiIdVb(Long fiIdVb) {
        this.fiIdVb = fiIdVb;
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

    public String getFiCoQuanCap() {
        return fiCoQuanCap;
    }

    public void setFiCoQuanCap(String fiCoQuanCap) {
        this.fiCoQuanCap = fiCoQuanCap;
    }

    public String getFiSoVanBan() {
        return fiSoVanBan;
    }

    public void setFiSoVanBan(String fiSoVanBan) {
        this.fiSoVanBan = fiSoVanBan;
    }

    public Date getFiNgayKy() {
        return fiNgayKy;
    }

    public void setFiNgayKy(Date fiNgayKy) {
        this.fiNgayKy = fiNgayKy;
    }

    public String getFiNguoiKy() {
        return fiNguoiKy;
    }

    public void setFiNguoiKy(String fiNguoiKy) {
        this.fiNguoiKy = fiNguoiKy;
    }

    public String getFiTenTepTin() {
        return fiTenTepTin;
    }

    public void setFiTenTepTin(String fiTenTepTin) {
        this.fiTenTepTin = fiTenTepTin;
    }

    public String getFiNoidungTepTin() {
        return fiNoidungTepTin;
    }

    public void setFiNoidungTepTin(String fiNoidungTepTin) {
        this.fiNoidungTepTin = fiNoidungTepTin;
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

    public String getFiNguoiDaiDien() {
        return fiNguoiDaiDien;
    }

    public void setFiNguoiDaiDien(String fiNguoiDaiDien) {
        this.fiNguoiDaiDien = fiNguoiDaiDien;
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

    
}
