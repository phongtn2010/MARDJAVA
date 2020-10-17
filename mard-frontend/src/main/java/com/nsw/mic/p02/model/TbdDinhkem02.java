/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mic.p02.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Fujitsu
 */
public class TbdDinhkem02 implements Serializable {

     private static final long serialVersionUID = 1L;
    private Long fiId;
    private Long fiLoaiTepTin;
    private String fiTenLoaiTep;
    private String fiTenTepTin;
    private Long fiTepTinId;
    private Long fiIdHoSo;
    private String fiMaHoSo;
    private Date fiNgayTao;
    private String fiNguoiTao;
    private Long fiHoatDong;
    private Long fiIdDinhkem;
    private String fiTenDinhKem;
    private String fiMaDinhKem;
    private Long fiIdGiayphep;

    public TbdDinhkem02() {
    }

    public TbdDinhkem02(Long fiId) {
        this.fiId = fiId;
    }

    public Long getFiId() {
        return fiId;
    }

    public void setFiId(Long fiId) {
        this.fiId = fiId;
    }


    public String getFiTenLoaiTep() {
        return fiTenLoaiTep;
    }

    public void setFiTenLoaiTep(String fiTenLoaiTep) {
        this.fiTenLoaiTep = fiTenLoaiTep;
    }

    public String getFiTenTepTin() {
        return fiTenTepTin;
    }

    public void setFiTenTepTin(String fiTenTepTin) {
        this.fiTenTepTin = fiTenTepTin;
    }

    public Long getFiLoaiTepTin() {
        return fiLoaiTepTin;
    }

    public void setFiLoaiTepTin(Long fiLoaiTepTin) {
        this.fiLoaiTepTin = fiLoaiTepTin;
    }

    public Long getFiTepTinId() {
        return fiTepTinId;
    }

    public void setFiTepTinId(Long fiTepTinId) {
        this.fiTepTinId = fiTepTinId;
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

    public Long getFiIdDinhkem() {
        return fiIdDinhkem;
    }

    public void setFiIdDinhkem(Long fiIdDinhkem) {
        this.fiIdDinhkem = fiIdDinhkem;
    }

    public String getFiTenDinhKem() {
        return fiTenDinhKem;
    }

    public void setFiTenDinhKem(String fiTenDinhKem) {
        this.fiTenDinhKem = fiTenDinhKem;
    }

    public String getFiMaDinhKem() {
        return fiMaDinhKem;
    }

    public void setFiMaDinhKem(String fiMaDinhKem) {
        this.fiMaDinhKem = fiMaDinhKem;
    }

    public Long getFiIdGiayphep() {
        return fiIdGiayphep;
    }

    public void setFiIdGiayphep(Long fiIdGiayphep) {
        this.fiIdGiayphep = fiIdGiayphep;
    }
}
