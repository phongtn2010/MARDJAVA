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
public class TbdLoHangCanXl03 {

    private Long id;
    private Long fiIdHoso;
    private String fiMaHoso;
    private String fiNoidungXl;
    private String fiDonviXl;
    private String fiChuyenvienXl;
    private String fiTenTeptin;
    private String fiNoidungFile;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;

    public TbdLoHangCanXl03() {
    }

    public TbdLoHangCanXl03(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFiNoidungXl() {
        return fiNoidungXl;
    }

    public void setFiNoidungXl(String fiNoidungXl) {
        this.fiNoidungXl = fiNoidungXl;
    }

    public String getFiDonviXl() {
        return fiDonviXl;
    }

    public void setFiDonviXl(String fiDonviXl) {
        this.fiDonviXl = fiDonviXl;
    }

    public String getFiChuyenvienXl() {
        return fiChuyenvienXl;
    }

    public void setFiChuyenvienXl(String fiChuyenvienXl) {
        this.fiChuyenvienXl = fiChuyenvienXl;
    }

    public String getFiTenTeptin() {
        return fiTenTeptin;
    }

    public void setFiTenTeptin(String fiTenTeptin) {
        this.fiTenTeptin = fiTenTeptin;
    }

    public String getFiNoidungFile() {
        return fiNoidungFile;
    }

    public void setFiNoidungFile(String fiNoidungFile) {
        this.fiNoidungFile = fiNoidungFile;
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
