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
public class Tbdkqxl9 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long fiIdKqxl;
    private String fiDonviXl;
    private Long fiHoatdong;
    private Long fiIdHoso;
    private String fiLinkCvan;
    private String fiMaHoso;
    private Date fiNgCapnhat;
    private Date fiNgayXl;
    private Date fiNgaytao;
    private String fiNguoitao;
    private String fiNoidung;
    private String fiTenTt;
    private Long fiTrangthai;
    private Tbddinhkem9 dinhkem;

    public Tbdkqxl9() {
    }

    public Tbdkqxl9(Long fiIdKqxl) {
        this.fiIdKqxl = fiIdKqxl;
    }

    public Long getFiIdKqxl() {
        return fiIdKqxl;
    }

    public void setFiIdKqxl(Long fiIdKqxl) {
        this.fiIdKqxl = fiIdKqxl;
    }

    public String getFiDonviXl() {
        return fiDonviXl;
    }

    public void setFiDonviXl(String fiDonviXl) {
        this.fiDonviXl = fiDonviXl;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiLinkCvan() {
        return fiLinkCvan;
    }

    public void setFiLinkCvan(String fiLinkCvan) {
        this.fiLinkCvan = fiLinkCvan;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public Date getFiNgCapnhat() {
        return fiNgCapnhat;
    }

    public void setFiNgCapnhat(Date fiNgCapnhat) {
        this.fiNgCapnhat = fiNgCapnhat;
    }

    public Date getFiNgayXl() {
        return fiNgayXl;
    }

    public void setFiNgayXl(Date fiNgayXl) {
        this.fiNgayXl = fiNgayXl;
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

    public String getFiNoidung() {
        return fiNoidung;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public String getFiTenTt() {
        return fiTenTt;
    }

    public void setFiTenTt(String fiTenTt) {
        this.fiTenTt = fiTenTt;
    }

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Tbddinhkem9 getDinhkem() {
        return dinhkem;
    }

    public void setDinhkem(Tbddinhkem9 dinhkem) {
        this.dinhkem = dinhkem;
    }


    
}
