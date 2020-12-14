/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p03.model;

/**
 * @author HuongMK
 */
public class TbsDuoclieu03 {

    private Long id;
    private String fiTenDuoclieu;
    private String fiTenLatinh;
    private String fiBophanDung;
    private String fiMaHs;
    private String fiNguoitao;

    public TbsDuoclieu03() {
    }

    public TbsDuoclieu03(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFiTenDuoclieu() {
        return fiTenDuoclieu;
    }

    public void setFiTenDuoclieu(String fiTenDuoclieu) {
        this.fiTenDuoclieu = fiTenDuoclieu;
    }

    public String getFiTenLatinh() {
        return fiTenLatinh;
    }

    public void setFiTenLatinh(String fiTenLatinh) {
        this.fiTenLatinh = fiTenLatinh;
    }

    public String getFiBophanDung() {
        return fiBophanDung;
    }

    public void setFiBophanDung(String fiBophanDung) {
        this.fiBophanDung = fiBophanDung;
    }

    public String getFiMaHs() {
        return fiMaHs;
    }

    public void setFiMaHs(String fiMaHs) {
        this.fiMaHs = fiMaHs;
    }

    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

}
