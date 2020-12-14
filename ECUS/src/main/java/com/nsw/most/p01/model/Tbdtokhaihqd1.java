/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p01.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nsw.util.CustomJsonDateDeserializer;
import java.util.Date;

/**
 *
 * @author PhongNguyen
 */
public class Tbdtokhaihqd1 {

    private Long fiIdSp;

    private String fiMaHs;

    private String fiTenHh;

    private Double fiKlSl;

    private String fiTenDv;

    private Long fiIdTk;

    private String fiGhichu;

    private Date fiNgaytao;

    private Long fiHoatdong;

    private String fiNguoitao;

    private String fiMaql;
    
    private Long stt;

    public Long getFiIdSp() {
        return fiIdSp;
    }

    public void setFiIdSp(Long fiIdSp) {
        this.fiIdSp = fiIdSp;
    }

    public String getFiMaHs() {
        return fiMaHs;
    }

    public void setFiMaHs(String fiMaHs) {
        this.fiMaHs = fiMaHs;
    }

    public String getFiTenHh() {
        return fiTenHh;
    }

    public void setFiTenHh(String fiTenHh) {
        this.fiTenHh = fiTenHh;
    }

    public Double getFiKlSl() {
        return fiKlSl;
    }

    public void setFiKlSl(Double fiKlSl) {
        this.fiKlSl = fiKlSl;
    }

    public String getFiTenDv() {
        return fiTenDv;
    }

    public void setFiTenDv(String fiTenDv) {
        this.fiTenDv = fiTenDv;
    }

    public Long getFiIdTk() {
        return fiIdTk;
    }

    public void setFiIdTk(Long fiIdTk) {
        this.fiIdTk = fiIdTk;
    }

    public String getFiGhichu() {
        return fiGhichu;
    }

    public void setFiGhichu(String fiGhichu) {
        this.fiGhichu = fiGhichu;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
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

    public Long getStt() {
        return stt;
    }

    public void setStt(Long stt) {
        this.stt = stt;
    }

    public String getFiMaql() {
        return fiMaql;
    }

    public void setFiMaql(String fiMaql) {
        this.fiMaql = fiMaql;
    }

}
