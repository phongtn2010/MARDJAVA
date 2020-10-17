/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mt.p58.model;

import java.io.Serializable;

import java.util.Date;

public class TbdhsDinhkem58 implements Serializable {

    private Long fiIdDk;
    private Long fiIdHoso;
    private Long fiIdTailieu;
    private String fiGhichu;
    private String fiTenTep;
    private String fiDuongDan;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;
    private Date fiNgCapnhat;
    private String fiMaTailieu;
    private String fiTenTailieu;
    private String fiNoidung;
    private String fiGuiid;

    public TbdhsDinhkem58() {
    }

    public TbdhsDinhkem58(Long fiIdDk) {
        this.fiIdDk = fiIdDk;
    }

    public Long getFiIdDk() {
        return fiIdDk;
    }

    public void setFiIdDk(Long fiIdDk) {
        this.fiIdDk = fiIdDk;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdTailieu() {
        return fiIdTailieu;
    }

    public void setFiIdTailieu(Long fiIdTailieu) {
        this.fiIdTailieu = fiIdTailieu;
    }

    public String getFiGhichu() {
        return fiGhichu;
    }

    public void setFiGhichu(String fiGhichu) {
        this.fiGhichu = fiGhichu;
    }

    public String getFiTenTep() {
        return fiTenTep;
    }

    public void setFiTenTep(String fiTenTep) {
        this.fiTenTep = fiTenTep;
    }

    public String getFiDuongDan() {
        return fiDuongDan;
    }

    public void setFiDuongDan(String fiDuongDan) {
        this.fiDuongDan = fiDuongDan;
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

    public String getFiMaTailieu() {
        return fiMaTailieu;
    }

    public void setFiMaTailieu(String fiMaTailieu) {
        this.fiMaTailieu = fiMaTailieu;
    }

    public String getFiTenTailieu() {
        return fiTenTailieu;
    }

    public void setFiTenTailieu(String fiTenTailieu) {
        this.fiTenTailieu = fiTenTailieu;
    }

    public String getFiNoidung() {
        return fiNoidung;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public String getFiGuiid() {
        return fiGuiid;
    }

    public void setFiGuiid(String fiGuiid) {
        this.fiGuiid = fiGuiid;
    }
}
