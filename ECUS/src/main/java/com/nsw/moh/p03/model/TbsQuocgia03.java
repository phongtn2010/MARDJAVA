/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p03.model;

/**
 * @author HuongMK
 */
public class TbsQuocgia03 {

    private Long id;
    private String fiMaQg;
    private String fiTenQg;
    private String fiNguoitao;

    public TbsQuocgia03() {
    }

    public TbsQuocgia03(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFiMaQg() {
        return fiMaQg;
    }

    public void setFiMaQg(String fiMaQg) {
        this.fiMaQg = fiMaQg;
    }

    public String getFiTenQg() {
        return fiTenQg;
    }

    public void setFiTenQg(String fiTenQg) {
        this.fiTenQg = fiTenQg;
    }

    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

}
