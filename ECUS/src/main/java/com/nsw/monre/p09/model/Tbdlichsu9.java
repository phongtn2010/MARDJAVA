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
public class Tbdlichsu9 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long fiIdLichsu;
    private Long fiHoatdong;
    private Long fiIdHoso;
    private String fiLinkCvan;
    private String fiMaHoso;
    private Date fiNgCapnhat;
    private Date fiNgaytao;
    private String fiNguoitao;
    private String fiNoidung;
    private String fiTenDvgui;
    private String fiTenDvnhan;
    private String fiTenNggui;
    private String fiTenNgnhan;
    private String fiTenTt;
    private Long fiTrangthai;

    public Tbdlichsu9() {
    }

    public Tbdlichsu9(Long fiIdLichsu) {
        this.fiIdLichsu = fiIdLichsu;
    }

    public Long getFiIdLichsu() {
        return fiIdLichsu;
    }

    public void setFiIdLichsu(Long fiIdLichsu) {
        this.fiIdLichsu = fiIdLichsu;
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

    public String getFiTenDvgui() {
        return fiTenDvgui;
    }

    public void setFiTenDvgui(String fiTenDvgui) {
        this.fiTenDvgui = fiTenDvgui;
    }

    public String getFiTenDvnhan() {
        return fiTenDvnhan;
    }

    public void setFiTenDvnhan(String fiTenDvnhan) {
        this.fiTenDvnhan = fiTenDvnhan;
    }

    public String getFiTenNggui() {
        return fiTenNggui;
    }

    public void setFiTenNggui(String fiTenNggui) {
        this.fiTenNggui = fiTenNggui;
    }

    public String getFiTenNgnhan() {
        return fiTenNgnhan;
    }

    public void setFiTenNgnhan(String fiTenNgnhan) {
        this.fiTenNgnhan = fiTenNgnhan;
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

    
}
