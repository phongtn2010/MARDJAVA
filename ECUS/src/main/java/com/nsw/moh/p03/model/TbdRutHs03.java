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
public class TbdRutHs03 {

    private Long fiIdRutHs;
    private Long fiIdHoso;
    private String fiMaHoso;
    private Date fiNgayRut;
    private String fiNoidung;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;
    private Date fiNgCapnhat;

    public TbdRutHs03() {
    }

    public TbdRutHs03(Long fiIdRutHs) {
        this.fiIdRutHs = fiIdRutHs;
    }

    public Long getFiIdRutHs() {
        return fiIdRutHs;
    }

    public void setFiIdRutHs(Long fiIdRutHs) {
        this.fiIdRutHs = fiIdRutHs;
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

    public Date getFiNgayRut() {
        return fiNgayRut;
    }

    public void setFiNgayRut(Date fiNgayRut) {
        this.fiNgayRut = fiNgayRut;
    }

    public String getFiNoidung() {
        return fiNoidung;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
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
