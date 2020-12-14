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
public class TbdCvChuyenckHh03 {

    private Long id;
    private Long idCvCck;
    private Long fiStt;
    private Long fiIdHang;
    private String fiTenHang;
    private Long fiSoluong;
    private String fiMaDvSl;
    private String fiTenDvSl;
    private Long fiKhoiluong;
    private String fiMaDvKl;
    private String fiTenDvKl;
    private String fiNguoitao;
    private Date fiNgaytao;
    private Long fiHoatdong;

    public TbdCvChuyenckHh03() {
    }

    public TbdCvChuyenckHh03(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCvCck() {
        return idCvCck;
    }

    public void setIdCvCck(Long idCvCck) {
        this.idCvCck = idCvCck;
    }

    public Long getFiStt() {
        return fiStt;
    }

    public void setFiStt(Long fiStt) {
        this.fiStt = fiStt;
    }

    public Long getFiIdHang() {
        return fiIdHang;
    }

    public void setFiIdHang(Long fiIdHang) {
        this.fiIdHang = fiIdHang;
    }

    public String getFiTenHang() {
        return fiTenHang;
    }

    public void setFiTenHang(String fiTenHang) {
        this.fiTenHang = fiTenHang;
    }

    public Long getFiSoluong() {
        return fiSoluong;
    }

    public void setFiSoluong(Long fiSoluong) {
        this.fiSoluong = fiSoluong;
    }

    public String getFiMaDvSl() {
        return fiMaDvSl;
    }

    public void setFiMaDvSl(String fiMaDvSl) {
        this.fiMaDvSl = fiMaDvSl;
    }

    public String getFiTenDvSl() {
        return fiTenDvSl;
    }

    public void setFiTenDvSl(String fiTenDvSl) {
        this.fiTenDvSl = fiTenDvSl;
    }

    public Long getFiKhoiluong() {
        return fiKhoiluong;
    }

    public void setFiKhoiluong(Long fiKhoiluong) {
        this.fiKhoiluong = fiKhoiluong;
    }

    public String getFiMaDvKl() {
        return fiMaDvKl;
    }

    public void setFiMaDvKl(String fiMaDvKl) {
        this.fiMaDvKl = fiMaDvKl;
    }

    public String getFiTenDvKl() {
        return fiTenDvKl;
    }

    public void setFiTenDvKl(String fiTenDvKl) {
        this.fiTenDvKl = fiTenDvKl;
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

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

}
