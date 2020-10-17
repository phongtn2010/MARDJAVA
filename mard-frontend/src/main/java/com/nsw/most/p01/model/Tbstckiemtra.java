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
 * @author Phong84NV
 */
public class Tbstckiemtra {
    private Long fiId;
    private String fiMa;
    private String fiViettat;
    private String fiTen;
    private Date fiNgaytao;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Long fiOrderId;
    public Tbstckiemtra() {
    }

    public Tbstckiemtra(Long fiId, String fiMa, String fiViettat, String fiTen, Date fiNgaytao, Long fiHoatdong, String fiNguoitao) {
        this.fiId = fiId;
        this.fiMa = fiMa;
        this.fiViettat = fiViettat;
        this.fiTen = fiTen;
        this.fiNgaytao = fiNgaytao;
        this.fiHoatdong = fiHoatdong;
        this.fiNguoitao = fiNguoitao;
    }

    public Tbstckiemtra(Long fiId, String fiMa, String fiViettat, String fiTen, Date fiNgaytao, Long fiHoatdong, String fiNguoitao, Long fiOrderId) {
        this.fiId = fiId;
        this.fiMa = fiMa;
        this.fiViettat = fiViettat;
        this.fiTen = fiTen;
        this.fiNgaytao = fiNgaytao;
        this.fiHoatdong = fiHoatdong;
        this.fiNguoitao = fiNguoitao;
        this.fiOrderId = fiOrderId;
    }

    public Long getFiOrderId() {
        return fiOrderId;
    }

    public void setFiOrderId(Long fiOrderId) {
        this.fiOrderId = fiOrderId;
    }

    public Long getFiId() {
        return fiId;
    }

    public void setFiId(Long fiId) {
        this.fiId = fiId;
    }

    public String getFiMa() {
        return fiMa;
    }

    public void setFiMa(String fiMa) {
        this.fiMa = fiMa;
    }

    public String getFiViettat() {
        return fiViettat;
    }

    public void setFiViettat(String fiViettat) {
        this.fiViettat = fiViettat;
    }

    public String getFiTen() {
        return fiTen;
    }

    public void setFiTen(String fiTen) {
        this.fiTen = fiTen;
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
    
    
}
