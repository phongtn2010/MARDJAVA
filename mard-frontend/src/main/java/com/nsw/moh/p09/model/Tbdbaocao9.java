/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p09.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author quangnv
 */
public class Tbdbaocao9 {

    private Long fiIdBaocao;

    private Long fiIdHoso;

    private String fiMaHoso;

    private String fiNoidung;

    private Long fiHoatdong;

    private String fiNguoitao;

    private Date fiNgaytao;

    private Date fiNgCapnhat;

    private List<Tbddinhkem9> lstDinhKems;

    public Long getFiIdBaocao() {
        return fiIdBaocao;
    }

    public void setFiIdBaocao(Long fiIdBaocao) {
        this.fiIdBaocao = fiIdBaocao;
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

    public List<Tbddinhkem9> getLstDinhKems() {
        return lstDinhKems;
    }

    public void setLstDinhKems(List<Tbddinhkem9> lstDinhKems) {
        this.lstDinhKems = lstDinhKems;
    }
}
