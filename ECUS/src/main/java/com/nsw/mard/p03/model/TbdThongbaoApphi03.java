/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p03.model;

import java.util.Date;

/**
 * @author HuongMK
 */
public class TbdThongbaoApphi03 {

    private Long id;
    private Long fiIdHoso;
    private String fiMaHoso;
    private Long fiTongSotien;
    private String fiTongTienBangchu;
    private String fiChuthich;
    private String fiDvXl;
    private String fiNguoiApphi;
    private Date fiNgaytao;
    private String fiNguoitao;
    private Long fiHoatdong;

    public TbdThongbaoApphi03() {
    }

    public TbdThongbaoApphi03(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getFiTongSotien() {
        return fiTongSotien;
    }

    public void setFiTongSotien(Long fiTongSotien) {
        this.fiTongSotien = fiTongSotien;
    }

    public String getFiTongTienBangchu() {
        return fiTongTienBangchu;
    }

    public void setFiTongTienBangchu(String fiTongTienBangchu) {
        this.fiTongTienBangchu = fiTongTienBangchu;
    }

    public String getFiChuthich() {
        return fiChuthich;
    }

    public void setFiChuthich(String fiChuthich) {
        this.fiChuthich = fiChuthich;
    }

    public String getFiDvXl() {
        return fiDvXl;
    }

    public void setFiDvXl(String fiDvXl) {
        this.fiDvXl = fiDvXl;
    }

    public String getFiNguoiApphi() {
        return fiNguoiApphi;
    }

    public void setFiNguoiApphi(String fiNguoiApphi) {
        this.fiNguoiApphi = fiNguoiApphi;
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

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

}
