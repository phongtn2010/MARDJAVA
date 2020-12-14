/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mic.p02.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Fujitsu
 */
public class TbdThietBiNk02 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long fiIdThietBi;
    private String fiTenMay;
    private String fiKieuIn;
    private String fiSoMauIn;
    private String fiModelMay;
    private String fiSoDinhDanhMay;
    private String fiNuocSx;
    private String fiNamSx;
    private Long fiSoLuong;
    private String fiChatLuong;
    private String fiKhuanKhoBanIn;
    private String fiDonViTinhKhuonKho;
    private String fiTocDoIn;
    private String fiDonViTocDoIn;
    private BigDecimal fiGiaThietBi;
    private String fiTenHangSx;
    private String fiMaTv;
    private String fiMaKieuIn;
    private String fiMaChatLuong;
    private String fiMaTocdo;
    private String fiMaKichThuoc;
    private Long fiIdHoSo;
    private String fiMaHoSo;
    private Date fiNgayTao;
    private String fiNguoiTao;
    private Long fiHoatDong;
    private Long fiIdGiayphep;

    public TbdThietBiNk02() {
    }

    public TbdThietBiNk02(Long fiIdThietBi) {
        this.fiIdThietBi = fiIdThietBi;
    }

    public Long getFiIdThietBi() {
        return fiIdThietBi;
    }

    public void setFiIdThietBi(Long fiIdThietBi) {
        this.fiIdThietBi = fiIdThietBi;
    }

    public String getFiTenMay() {
        return fiTenMay;
    }

    public void setFiTenMay(String fiTenMay) {
        this.fiTenMay = fiTenMay;
    }

    public String getFiKieuIn() {
        return fiKieuIn;
    }

    public void setFiKieuIn(String fiKieuIn) {
        this.fiKieuIn = fiKieuIn;
    }

    public String getFiSoMauIn() {
        return fiSoMauIn;
    }

    public void setFiSoMauIn(String fiSoMauIn) {
        this.fiSoMauIn = fiSoMauIn;
    }

    public String getFiModelMay() {
        return fiModelMay;
    }

    public void setFiModelMay(String fiModelMay) {
        this.fiModelMay = fiModelMay;
    }

    public String getFiSoDinhDanhMay() {
        return fiSoDinhDanhMay;
    }

    public void setFiSoDinhDanhMay(String fiSoDinhDanhMay) {
        this.fiSoDinhDanhMay = fiSoDinhDanhMay;
    }

    public String getFiNuocSx() {
        return fiNuocSx;
    }

    public void setFiNuocSx(String fiNuocSx) {
        this.fiNuocSx = fiNuocSx;
    }

    public String getFiNamSx() {
        return fiNamSx;
    }

    public void setFiNamSx(String fiNamSx) {
        this.fiNamSx = fiNamSx;
    }

    public Long getFiSoLuong() {
        return fiSoLuong;
    }

    public void setFiSoLuong(Long fiSoLuong) {
        this.fiSoLuong = fiSoLuong;
    }

    public String getFiChatLuong() {
        return fiChatLuong;
    }

    public void setFiChatLuong(String fiChatLuong) {
        this.fiChatLuong = fiChatLuong;
    }

    public String getFiKhuanKhoBanIn() {
        return fiKhuanKhoBanIn;
    }

    public void setFiKhuanKhoBanIn(String fiKhuanKhoBanIn) {
        this.fiKhuanKhoBanIn = fiKhuanKhoBanIn;
    }

    public String getFiDonViTinhKhuonKho() {
        return fiDonViTinhKhuonKho;
    }

    public void setFiDonViTinhKhuonKho(String fiDonViTinhKhuonKho) {
        this.fiDonViTinhKhuonKho = fiDonViTinhKhuonKho;
    }

    public String getFiTocDoIn() {
        return fiTocDoIn;
    }

    public void setFiTocDoIn(String fiTocDoIn) {
        this.fiTocDoIn = fiTocDoIn;
    }

    public String getFiDonViTocDoIn() {
        return fiDonViTocDoIn;
    }

    public void setFiDonViTocDoIn(String fiDonViTocDoIn) {
        this.fiDonViTocDoIn = fiDonViTocDoIn;
    }

    public BigDecimal getFiGiaThietBi() {
        return fiGiaThietBi;
    }

    public void setFiGiaThietBi(BigDecimal fiGiaThietBi) {
        this.fiGiaThietBi = fiGiaThietBi;
    }

    public String getFiTenHangSx() {
        return fiTenHangSx;
    }

    public void setFiTenHangSx(String fiTenHangSx) {
        this.fiTenHangSx = fiTenHangSx;
    }

    public String getFiMaTv() {
        return fiMaTv;
    }

    public void setFiMaTv(String fiMaTv) {
        this.fiMaTv = fiMaTv;
    }

    public String getFiMaKieuIn() {
        return fiMaKieuIn;
    }

    public void setFiMaKieuIn(String fiMaKieuIn) {
        this.fiMaKieuIn = fiMaKieuIn;
    }

    public String getFiMaChatLuong() {
        return fiMaChatLuong;
    }

    public void setFiMaChatLuong(String fiMaChatLuong) {
        this.fiMaChatLuong = fiMaChatLuong;
    }

    public String getFiMaTocdo() {
        return fiMaTocdo;
    }

    public void setFiMaTocdo(String fiMaTocdo) {
        this.fiMaTocdo = fiMaTocdo;
    }

    public String getFiMaKichThuoc() {
        return fiMaKichThuoc;
    }

    public void setFiMaKichThuoc(String fiMaKichThuoc) {
        this.fiMaKichThuoc = fiMaKichThuoc;
    }

    public Long getFiIdHoSo() {
        return fiIdHoSo;
    }

    public void setFiIdHoSo(Long fiIdHoSo) {
        this.fiIdHoSo = fiIdHoSo;
    }

    public String getFiMaHoSo() {
        return fiMaHoSo;
    }

    public void setFiMaHoSo(String fiMaHoSo) {
        this.fiMaHoSo = fiMaHoSo;
    }

    public Date getFiNgayTao() {
        return fiNgayTao;
    }

    public void setFiNgayTao(Date fiNgayTao) {
        this.fiNgayTao = fiNgayTao;
    }

    public String getFiNguoiTao() {
        return fiNguoiTao;
    }

    public void setFiNguoiTao(String fiNguoiTao) {
        this.fiNguoiTao = fiNguoiTao;
    }

    public Long getFiHoatDong() {
        return fiHoatDong;
    }

    public void setFiHoatDong(Long fiHoatDong) {
        this.fiHoatDong = fiHoatDong;
    }

    public Long getFiIdGiayphep() {
        return fiIdGiayphep;
    }

    public void setFiIdGiayphep(Long fiIdGiayphep) {
        this.fiIdGiayphep = fiIdGiayphep;
    }

}
