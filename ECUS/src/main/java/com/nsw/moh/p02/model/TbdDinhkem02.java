/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p02.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author HuongMK
 */
public class TbdDinhkem02 {

    private Long fiIdDinhkem;
    private Long fiIdHoso;
    private Long fiLoaiTailieu;
    private String fiTenLoaiTl;
    private String fiTenTailieu;
    private String fiDuongdanTl;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;
    private Date fiNgCapnhat;
    private Long fiBatbuoc;
    private BigDecimal fiSize;

    public TbdDinhkem02() {
    }

    public TbdDinhkem02(Long fiIdDinhkem) {
        this.fiIdDinhkem = fiIdDinhkem;
    }

    public Long getFiIdDinhkem() {
        return fiIdDinhkem;
    }

    public void setFiIdDinhkem(Long fiIdDinhkem) {
        this.fiIdDinhkem = fiIdDinhkem;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiLoaiTailieu() {
        return fiLoaiTailieu;
    }

    public void setFiLoaiTailieu(Long fiLoaiTailieu) {
        this.fiLoaiTailieu = fiLoaiTailieu;
    }

    public String getFiTenLoaiTl() {
        return fiTenLoaiTl;
    }

    public void setFiTenLoaiTl(String fiTenLoaiTl) {
        this.fiTenLoaiTl = fiTenLoaiTl;
    }

    public String getFiTenTailieu() {
        return fiTenTailieu;
    }

    public void setFiTenTailieu(String fiTenTailieu) {
        this.fiTenTailieu = fiTenTailieu;
    }

    public String getFiDuongdanTl() {
        return fiDuongdanTl;
    }

    public void setFiDuongdanTl(String fiDuongdanTl) {
        this.fiDuongdanTl = fiDuongdanTl;
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

    public Long getFiBatbuoc() {
        return fiBatbuoc;
    }

    public void setFiBatbuoc(Long fiBatbuoc) {
        this.fiBatbuoc = fiBatbuoc;
    }

    public BigDecimal getFiSize() {
        return fiSize;
    }

    public void setFiSize(BigDecimal fiSize) {
        this.fiSize = fiSize;
    }
}
