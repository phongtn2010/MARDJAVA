/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.bca.p02.model;

import java.util.Date;
import java.util.List;

/**
 *
 */
public class Tbdthanhtoanphi02 {

    private Long fiIdTtp;
    private Long fiIdHoso;
    private String fiMaHoso;
    private String fiSotien;
    private String fiNoidung;
    private String fiNguoinop;
    private Date fiNgaynop;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;
    private Date fiNgCapnhat;

    private List<TbdhsDinhkem02> lstDinhkem;

    public Tbdthanhtoanphi02() {
    }

    public Tbdthanhtoanphi02(Long fiIdTtp) {
        this.fiIdTtp = fiIdTtp;
    }

    public Long getFiIdTtp() {
        return fiIdTtp;
    }

    public void setFiIdTtp(Long fiIdTtp) {
        this.fiIdTtp = fiIdTtp;
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

    public String getFiSotien() {
        return fiSotien;
    }

    public void setFiSotien(String fiSotien) {
        this.fiSotien = fiSotien;
    }

    public String getFiNoidung() {
        return fiNoidung;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public String getFiNguoinop() {
        return fiNguoinop;
    }

    public void setFiNguoinop(String fiNguoinop) {
        this.fiNguoinop = fiNguoinop;
    }

    public Date getFiNgaynop() {
        return fiNgaynop;
    }

    public void setFiNgaynop(Date fiNgaynop) {
        this.fiNgaynop = fiNgaynop;
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

    public List<TbdhsDinhkem02> getLstDinhkem() {
        return lstDinhkem;
    }

    public void setLstDinhkem(List<TbdhsDinhkem02> lstDinhkem) {
        this.lstDinhkem = lstDinhkem;
    }

}
