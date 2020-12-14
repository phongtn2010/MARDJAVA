/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p03.model;

import java.util.Date;

/**
 * @author HuongMK
 */
public class TbdGcnKdspdvHh03 {

    private Long id;
    private Long idKdspdv;
    private Long fiStt;
    private Long fiIdHanghoa;
    private String fiTenhang;
    private String fiDonggoi;
    private Long fiSoluong;
    private Long fiKhoiluong;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;

    public TbdGcnKdspdvHh03() {
    }

    public TbdGcnKdspdvHh03(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdKdspdv() {
        return idKdspdv;
    }

    public void setIdKdspdv(Long idKdspdv) {
        this.idKdspdv = idKdspdv;
    }

    public Long getFiStt() {
        return fiStt;
    }

    public void setFiStt(Long fiStt) {
        this.fiStt = fiStt;
    }

    public Long getFiIdHanghoa() {
        return fiIdHanghoa;
    }

    public void setFiIdHanghoa(Long fiIdHanghoa) {
        this.fiIdHanghoa = fiIdHanghoa;
    }

    public String getFiTenhang() {
        return fiTenhang;
    }

    public void setFiTenhang(String fiTenhang) {
        this.fiTenhang = fiTenhang;
    }

    public String getFiDonggoi() {
        return fiDonggoi;
    }

    public void setFiDonggoi(String fiDonggoi) {
        this.fiDonggoi = fiDonggoi;
    }

    public Long getFiSoluong() {
        return fiSoluong;
    }

    public void setFiSoluong(Long fiSoluong) {
        this.fiSoluong = fiSoluong;
    }

    public Long getFiKhoiluong() {
        return fiKhoiluong;
    }

    public void setFiKhoiluong(Long fiKhoiluong) {
        this.fiKhoiluong = fiKhoiluong;
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
