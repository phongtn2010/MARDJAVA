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
public class TbsCuakhau03 {

    private Long id;
    private Long fiCuakhauId;
    private String fiCuakhauCode;
    private String fiTenCuakhau;
    private Date fiNgaytao;

    public TbsCuakhau03() {
    }

    public TbsCuakhau03(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFiCuakhauId() {
        return fiCuakhauId;
    }

    public void setFiCuakhauId(Long fiCuakhauId) {
        this.fiCuakhauId = fiCuakhauId;
    }

    public String getFiCuakhauCode() {
        return fiCuakhauCode;
    }

    public void setFiCuakhauCode(String fiCuakhauCode) {
        this.fiCuakhauCode = fiCuakhauCode;
    }

    public String getFiTenCuakhau() {
        return fiTenCuakhau;
    }

    public void setFiTenCuakhau(String fiTenCuakhau) {
        this.fiTenCuakhau = fiTenCuakhau;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }


}
