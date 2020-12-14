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
public class TbdhsMaugen9 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long fiIdMaugen;
    private Long fiIdHoso;
    private String fiTenNguonGen;
    private Long fiIdNguonGen;
    private String fiTenMau;
    private String fiTenMauKhoaHoc;
    private Long fiSoLuong;
    private String fiDonViTinh;
    private String fiDiaDiem;
    private String fiCachThucThuThapMau;
    private Date fiNgaycap;
    private Date fiNgaytao;
    private Long fiHoatdong;

    public TbdhsMaugen9() {
    }

    public TbdhsMaugen9(Long fiIdMaugen) {
        this.fiIdMaugen = fiIdMaugen;
    }

    public Long getFiIdMaugen() {
        return fiIdMaugen;
    }

    public void setFiIdMaugen(Long fiIdMaugen) {
        this.fiIdMaugen = fiIdMaugen;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiTenNguonGen() {
        return fiTenNguonGen;
    }

    public void setFiTenNguonGen(String fiTenNguonGen) {
        this.fiTenNguonGen = fiTenNguonGen;
    }

    public String getFiTenMau() {
        return fiTenMau;
    }

    public void setFiTenMau(String fiTenMau) {
        this.fiTenMau = fiTenMau;
    }

    public String getFiTenMauKhoaHoc() {
        return fiTenMauKhoaHoc;
    }

    public void setFiTenMauKhoaHoc(String fiTenMauKhoaHoc) {
        this.fiTenMauKhoaHoc = fiTenMauKhoaHoc;
    }

    public Long getFiSoLuong() {
        return fiSoLuong;
    }

    public void setFiSoLuong(Long fiSoLuong) {
        this.fiSoLuong = fiSoLuong;
    }

    public String getFiDonViTinh() {
        return fiDonViTinh;
    }

    public void setFiDonViTinh(String fiDonViTinh) {
        this.fiDonViTinh = fiDonViTinh;
    }

    public String getFiDiaDiem() {
        return fiDiaDiem;
    }

    public void setFiDiaDiem(String fiDiaDiem) {
        this.fiDiaDiem = fiDiaDiem;
    }

    public String getFiCachThucThuThapMau() {
        return fiCachThucThuThapMau;
    }

    public void setFiCachThucThuThapMau(String fiCachThucThuThapMau) {
        this.fiCachThucThuThapMau = fiCachThucThuThapMau;
    }

    public Date getFiNgaycap() {
        return fiNgaycap;
    }

    public void setFiNgaycap(Date fiNgaycap) {
        this.fiNgaycap = fiNgaycap;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiIdNguonGen() {
        return fiIdNguonGen;
    }

    public void setFiIdNguonGen(Long fiIdNguonGen) {
        this.fiIdNguonGen = fiIdNguonGen;
    }

}
