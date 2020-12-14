/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p02.model;

import java.util.Date;

/**
 * @author HuongMK
 */
public class TbdNguoilienhe02 {

    private Long fiIdNgLienhe;
    private Long fiIdHoso;
    private String fiTenNgLienhe;
    private String fiSoDt;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;
    private Date fiNgCapnhat;
    private String fiEmail;

    public TbdNguoilienhe02() {
    }

    public TbdNguoilienhe02(Long fiIdNgLienhe) {
        this.fiIdNgLienhe = fiIdNgLienhe;
    }

    public Long getFiIdNgLienhe() {
        return fiIdNgLienhe;
    }

    public void setFiIdNgLienhe(Long fiIdNgLienhe) {
        this.fiIdNgLienhe = fiIdNgLienhe;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiTenNgLienhe() {
        return fiTenNgLienhe;
    }

    public void setFiTenNgLienhe(String fiTenNgLienhe) {
        this.fiTenNgLienhe = fiTenNgLienhe;
    }

    public String getFiSoDt() {
        return fiSoDt;
    }

    public void setFiSoDt(String fiSoDt) {
        this.fiSoDt = fiSoDt;
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

    public String getFiEmail() {
        return fiEmail;
    }

    public void setFiEmail(String fiEmail) {
        this.fiEmail = fiEmail;
    }
}
