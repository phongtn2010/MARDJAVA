/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p03.model;

import java.util.Date;
import java.util.List;

/**
 * @author HuongMK
 */
public class TbdGcnKddvXacnhanCkXuat03 {

    private Long id;
    private Long fiIdGcnKddv;
    private String fiNoidung;
    private Date fiNgayXn;
    private String fiNguoiXn;
    private String fiNoiXn;
    private String fiBacsyXn;
    private Long fiHoatdong;
    private Date fiNgaytao;
    private String fiNguoitao;
    private List<TbdGcnKddvHanghoaXuat03> lstHanghoaxuat03;

    public TbdGcnKddvXacnhanCkXuat03() {
    }

    public TbdGcnKddvXacnhanCkXuat03(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFiIdGcnKddv() {
        return fiIdGcnKddv;
    }

    public void setFiIdGcnKddv(Long fiIdGcnKddv) {
        this.fiIdGcnKddv = fiIdGcnKddv;
    }

    public String getFiNoidung() {
        return fiNoidung;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public Date getFiNgayXn() {
        return fiNgayXn;
    }

    public void setFiNgayXn(Date fiNgayXn) {
        this.fiNgayXn = fiNgayXn;
    }

    public String getFiNguoiXn() {
        return fiNguoiXn;
    }

    public void setFiNguoiXn(String fiNguoiXn) {
        this.fiNguoiXn = fiNguoiXn;
    }

    public String getFiNoiXn() {
        return fiNoiXn;
    }

    public void setFiNoiXn(String fiNoiXn) {
        this.fiNoiXn = fiNoiXn;
    }

    public String getFiBacsyXn() {
        return fiBacsyXn;
    }

    public void setFiBacsyXn(String fiBacsyXn) {
        this.fiBacsyXn = fiBacsyXn;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public List<TbdGcnKddvHanghoaXuat03> getLstHanghoaxuat03() {
        return lstHanghoaxuat03;
    }

    public void setLstHanghoaxuat03(List<TbdGcnKddvHanghoaXuat03> lstHanghoaxuat03) {
        this.lstHanghoaxuat03 = lstHanghoaxuat03;
    }
}
