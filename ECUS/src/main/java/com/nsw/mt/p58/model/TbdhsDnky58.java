/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mt.p58.model;

import java.io.Serializable;

import java.util.Date;

public class TbdhsDnky58 implements Serializable {

    private Long fiIdDnKy;
    private Long fiIdHoso;
    private String fiTenNgKy;
    private String fiChucDanh;
    private String fiDiaDiem;
    private Date fiNgayky;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;
    private Date fiNgCapnhat;

    public TbdhsDnky58() {
    }

    public TbdhsDnky58(Long fiIdDnKy) {
        this.fiIdDnKy = fiIdDnKy;
    }

    public Long getFiIdDnKy() {
        return fiIdDnKy;
    }

    public void setFiIdDnKy(Long fiIdDnKy) {
        this.fiIdDnKy = fiIdDnKy;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiTenNgKy() {
        return fiTenNgKy;
    }

    public void setFiTenNgKy(String fiTenNgKy) {
        this.fiTenNgKy = fiTenNgKy;
    }

    public String getFiChucDanh() {
        return fiChucDanh;
    }

    public void setFiChucDanh(String fiChucDanh) {
        this.fiChucDanh = fiChucDanh;
    }

    public String getFiDiaDiem() {
        return fiDiaDiem;
    }

    public void setFiDiaDiem(String fiDiaDiem) {
        this.fiDiaDiem = fiDiaDiem;
    }

    public Date getFiNgayky() {
        return fiNgayky;
    }

    public void setFiNgayky(Date fiNgayky) {
        this.fiNgayky = fiNgayky;
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
