/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mt.p58.model;

import java.io.Serializable;

import java.util.Date;

public class TbdhsLhvt58 implements Serializable {

    private Long fiIdLhvt;
    private Long fiIdHoso;
    private String fiVtTuyencodinh;
    private String fiVtHkHopdong;
    private String fiVtHkDulich;
    private String fiVtHanghoa;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;
    private Date fiNgCapnhat;

    public TbdhsLhvt58() {
    }

    public TbdhsLhvt58(Long fiIdLhvt) {
        this.fiIdLhvt = fiIdLhvt;
    }

    public Long getFiIdLhvt() {
        return fiIdLhvt;
    }

    public void setFiIdLhvt(Long fiIdLhvt) {
        this.fiIdLhvt = fiIdLhvt;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiVtTuyencodinh() {
        return fiVtTuyencodinh;
    }

    public void setFiVtTuyencodinh(String fiVtTuyencodinh) {
        this.fiVtTuyencodinh = fiVtTuyencodinh;
    }

    public String getFiVtHkHopdong() {
        return fiVtHkHopdong;
    }

    public void setFiVtHkHopdong(String fiVtHkHopdong) {
        this.fiVtHkHopdong = fiVtHkHopdong;
    }

    public String getFiVtHkDulich() {
        return fiVtHkDulich;
    }

    public void setFiVtHkDulich(String fiVtHkDulich) {
        this.fiVtHkDulich = fiVtHkDulich;
    }

    public String getFiVtHanghoa() {
        return fiVtHanghoa;
    }

    public void setFiVtHanghoa(String fiVtHanghoa) {
        this.fiVtHanghoa = fiVtHanghoa;
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

    public Date getFiNgCapnhat() {
        return fiNgCapnhat;
    }

    public void setFiNgCapnhat(Date fiNgCapnhat) {
        this.fiNgCapnhat = fiNgCapnhat;
    }


}
