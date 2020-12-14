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
public class TbdCuakhau03 {

    private Long fiIdCuakhau;
    private Long fiIdHoso;
    private String fiMaCuakhau;
    private String fiTenCuakhau;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;

    public TbdCuakhau03() {
    }

    public TbdCuakhau03(Long fiIdCuakhau) {
        this.fiIdCuakhau = fiIdCuakhau;
    }

    public Long getFiIdCuakhau() {
        return fiIdCuakhau;
    }

    public void setFiIdCuakhau(Long fiIdCuakhau) {
        this.fiIdCuakhau = fiIdCuakhau;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiMaCuakhau() {
        return fiMaCuakhau;
    }

    public void setFiMaCuakhau(String fiMaCuakhau) {
        this.fiMaCuakhau = fiMaCuakhau;
    }

    public String getFiTenCuakhau() {
        return fiTenCuakhau;
    }

    public void setFiTenCuakhau(String fiTenCuakhau) {
        this.fiTenCuakhau = fiTenCuakhau;
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

}
