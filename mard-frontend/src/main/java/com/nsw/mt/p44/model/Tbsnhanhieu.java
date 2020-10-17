package com.nsw.mt.p44.model;

import java.io.Serializable;
import java.util.Date;

public class Tbsnhanhieu implements Serializable{

    private Long fiIdNhanhieu;

    private String fiMaNhanhieu;

    private String fiTenHieu;

    private Long fiHoatdong;

    private String fiNguoitao;

    private Date fiNgaytao;

    private Date fiNgCapnhat;

    public Tbsnhanhieu() {
        super();
    }

    public void setFiIdNhanhieu(Long fiIdNhanhieu) {
        this.fiIdNhanhieu = fiIdNhanhieu;
    }

    public Long getFiIdNhanhieu() {
        return this.fiIdNhanhieu;
    }

    public void setFiMaNhanhieu(String fiMaNhanhieu) {
        this.fiMaNhanhieu = fiMaNhanhieu;
    }

    public String getFiMaNhanhieu() {
        return this.fiMaNhanhieu;
    }

    public void setFiTenHieu(String fiTenHieu) {
        this.fiTenHieu = fiTenHieu;
    }

    public String getFiTenHieu() {
        return this.fiTenHieu;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public String getFiNguoitao() {
        return this.fiNguoitao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaytao() {
        return this.fiNgaytao;
    }

    public void setFiNgCapnhat(Date fiNgCapnhat) {
        this.fiNgCapnhat = fiNgCapnhat;
    }

    public Date getFiNgCapnhat() {
        return this.fiNgCapnhat;
    }

}
