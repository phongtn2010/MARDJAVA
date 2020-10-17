/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p11.model;
import java.io.Serializable;
import java.util.Date;


public class FilterForm implements Serializable {
    private String fiMaHoso;
    private String fiNguoitao;
    private String fiTenHanghoa;
    private String fiTenDvkd;
    private Long fiTrangthai;
    private Date fromFiNgaytao;
    private Date toFiNgaytao;
    private int start;
    private int count;

    public String getFiTenHanghoa() {
        return fiTenHanghoa;
    }

    public void setFiTenHanghoa(String fiTenHanghoa) {
        this.fiTenHanghoa = fiTenHanghoa;
    }

    public String getFiTenDvkd() {
        return fiTenDvkd;
    }

    public void setFiTenDvkd(String fiTenDvkd) {
        this.fiTenDvkd = fiTenDvkd;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Date getFromFiNgaytao() {
        return fromFiNgaytao;
    }

    public void setFromFiNgaytao(Date fromFiNgaytao) {
        this.fromFiNgaytao = fromFiNgaytao;
    }

    public Date getToFiNgaytao() {
        return toFiNgaytao;
    }

    public void setToFiNgaytao(Date toFiNgaytao) {
        this.toFiNgaytao = toFiNgaytao;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
