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
public class Tbdycrut9 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long fiIdYcrut;
    private String fiDonviXl;
    private Long fiHoatdong;
    private Long fiIdHoso;
    private String fiMaHoso;
    private Date fiNgCapnhat;
    private Date fiNgayRut;
    private Date fiNgayXl;
    private Date fiNgaytao;
    private String fiNguoitao;
    private String fiNoidungPh;
    private String fiNoidungYc;
    private String fiTenTtCu;
    private Long fiTrthaiCu;

    public Tbdycrut9() {
    }

    public Tbdycrut9(Long fiIdYcrut) {
        this.fiIdYcrut = fiIdYcrut;
    }

    public Long getFiIdYcrut() {
        return fiIdYcrut;
    }

    public void setFiIdYcrut(Long fiIdYcrut) {
        this.fiIdYcrut = fiIdYcrut;
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

    public Date getFiNgayRut() {
        return fiNgayRut;
    }

    public void setFiNgayRut(Date fiNgayRut) {
        this.fiNgayRut = fiNgayRut;
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

    public String getFiNoidungPh() {
        return fiNoidungPh;
    }

    public void setFiNoidungPh(String fiNoidungPh) {
        this.fiNoidungPh = fiNoidungPh;
    }

    public String getFiNoidungYc() {
        return fiNoidungYc;
    }

    public void setFiNoidungYc(String fiNoidungYc) {
        this.fiNoidungYc = fiNoidungYc;
    }

    public String getFiTenTtCu() {
        return fiTenTtCu;
    }

    public void setFiTenTtCu(String fiTenTtCu) {
        this.fiTenTtCu = fiTenTtCu;
    }

    public Long getFiTrthaiCu() {
        return fiTrthaiCu;
    }

    public void setFiTrthaiCu(Long fiTrthaiCu) {
        this.fiTrthaiCu = fiTrthaiCu;
    }

    
}
