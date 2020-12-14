/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p03.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author HuongMK
 */
public class TbdDinhkem03 {

    private Long fiIdDinhkem;
    private Long fiIdHoso;
    private Long fiLoaiTailieu;
    private String fiTenLoaiTl;
    private String fiTenTailieu;
    private String fiDuongdanTl;
    private Long fiIdTailieu;
    private Long fiBatbuoc;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;
    private BigDecimal fiSize;

    public TbdDinhkem03() {
    }

    public TbdDinhkem03(Long fiIdDinhkem) {
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

    public Long getFiIdTailieu() {
        return fiIdTailieu;
    }

    public void setFiIdTailieu(Long fiIdTailieu) {
        this.fiIdTailieu = fiIdTailieu;
    }

    public Long getFiBatbuoc() {
        return fiBatbuoc;
    }

    public void setFiBatbuoc(Long fiBatbuoc) {
        this.fiBatbuoc = fiBatbuoc;
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

    public BigDecimal getFiSize() {
        return fiSize;
    }

    public void setFiSize(BigDecimal fiSize) {
        this.fiSize = fiSize;
    }
}
