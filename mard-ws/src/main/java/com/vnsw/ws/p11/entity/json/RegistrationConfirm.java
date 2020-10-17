/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p11.entity.json;

import java.util.Date;

public class RegistrationConfirm {
    private String fiMaHoso;
    private String fiSoVaoso;
    private Date fiNgaykyBnn;
    private String fiNguoikyBnn;

    public RegistrationConfirm() {
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiSoVaoso() {
        return fiSoVaoso;
    }

    public void setFiSoVaoso(String fiSoVaoso) {
        this.fiSoVaoso = fiSoVaoso;
    }

    public Date getFiNgaykyBnn() {
        return fiNgaykyBnn;
    }

    public void setFiNgaykyBnn(Date fiNgaykyBnn) {
        this.fiNgaykyBnn = fiNgaykyBnn;
    }

    public String getFiNguoikyBnn() {
        return fiNguoikyBnn;
    }

    public void setFiNguoikyBnn(String fiNguoikyBnn) {
        this.fiNguoikyBnn = fiNguoikyBnn;
    }
}
