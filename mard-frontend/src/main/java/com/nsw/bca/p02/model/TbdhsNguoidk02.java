/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.bca.p02.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 */
public class TbdhsNguoidk02 {

    private Long fiId;
    private Long fiIdHoso;
    private String fiTenNguoidk;
    private String fiSocmndNguoidk;
    private String fiBksPhuongtien;
    private BigDecimal fiKhoiluongVc;
    private String fiTenDv;
    private String fiGhichu;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Long fiLoai;
    private Date fiNgaytao;
    private Date fiNgCapnhat;

    public TbdhsNguoidk02() {
    }

    public TbdhsNguoidk02(Long fiId) {
        this.fiId = fiId;
    }

    public Long getFiId() {
        return fiId;
    }

    public void setFiId(Long fiId) {
        this.fiId = fiId;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiTenNguoidk() {
        return fiTenNguoidk;
    }

    public void setFiTenNguoidk(String fiTenNguoidk) {
        this.fiTenNguoidk = fiTenNguoidk;
    }

    public String getFiSocmndNguoidk() {
        return fiSocmndNguoidk;
    }

    public void setFiSocmndNguoidk(String fiSocmndNguoidk) {
        this.fiSocmndNguoidk = fiSocmndNguoidk;
    }

    public String getFiBksPhuongtien() {
        return fiBksPhuongtien;
    }

    public void setFiBksPhuongtien(String fiBksPhuongtien) {
        this.fiBksPhuongtien = fiBksPhuongtien;
    }

    public BigDecimal getFiKhoiluongVc() {
        return fiKhoiluongVc;
    }

    public void setFiKhoiluongVc(BigDecimal fiKhoiluongVc) {
        this.fiKhoiluongVc = fiKhoiluongVc;
    }

   
    public String getFiTenDv() {
        return fiTenDv;
    }

    public void setFiTenDv(String fiTenDv) {
        this.fiTenDv = fiTenDv;
    }

    public String getFiGhichu() {
        return fiGhichu;
    }

    public void setFiGhichu(String fiGhichu) {
        this.fiGhichu = fiGhichu;
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

    public Long getFiLoai() {
        return fiLoai;
    }

    public void setFiLoai(Long fiLoai) {
        this.fiLoai = fiLoai;
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
