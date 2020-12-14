/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p03.model;

import java.util.Date;

/**
 * @author HuongMK
 */
public class TbsTailieu03 {

    private Long fiIdTailieu;
    private Long fiLoaiTl;
    private String fiTenLoaiTl;
    private String fiHoatdong;
    private Long fiBatbuoc;
    private String fiNguoitao;
    private Date fiNgaytao;

    public TbsTailieu03() {
    }

    public TbsTailieu03(Long fiIdTailieu) {
        this.fiIdTailieu = fiIdTailieu;
    }

    public Long getFiIdTailieu() {
        return fiIdTailieu;
    }

    public void setFiIdTailieu(Long fiIdTailieu) {
        this.fiIdTailieu = fiIdTailieu;
    }

    public Long getFiLoaiTl() {
        return fiLoaiTl;
    }

    public void setFiLoaiTl(Long fiLoaiTl) {
        this.fiLoaiTl = fiLoaiTl;
    }

    public String getFiTenLoaiTl() {
        return fiTenLoaiTl;
    }

    public void setFiTenLoaiTl(String fiTenLoaiTl) {
        this.fiTenLoaiTl = fiTenLoaiTl;
    }

    public String getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(String fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiBatbuoc() {
        return fiBatbuoc;
    }

    public void setFiBatbuoc(Long fiBatbuoc) {
        this.fiBatbuoc = fiBatbuoc;
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

}
