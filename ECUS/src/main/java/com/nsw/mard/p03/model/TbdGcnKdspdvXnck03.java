/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p03.model;

import java.util.Date;
import java.util.List;

/**
 * @author HuongmK
 */
public class TbdGcnKdspdvXnck03 {

    private Long id;
    private Long idGcnKdspdv;
    private String fiNoidung;
    private Date fiNgayXn;
    private String fiNguoiXn;
    private String fiNoiXn;
    private String fiBacsy;
    private Long fiHoatdong;
    private Date fiNgaytao;
    private String fiNguoitao;
    private List<TbdGcnKdspdvHhXuat03> lstHanghoaxuatSpdv03;

    public TbdGcnKdspdvXnck03() {
    }

    public TbdGcnKdspdvXnck03(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdGcnKdspdv() {
        return idGcnKdspdv;
    }

    public void setIdGcnKdspdv(Long idGcnKdspdv) {
        this.idGcnKdspdv = idGcnKdspdv;
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

    public String getFiBacsy() {
        return fiBacsy;
    }

    public void setFiBacsy(String fiBacsy) {
        this.fiBacsy = fiBacsy;
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

    public List<TbdGcnKdspdvHhXuat03> getLstHanghoaxuatSpdv03() {
        return lstHanghoaxuatSpdv03;
    }

    public void setLstHanghoaxuatSpdv03(List<TbdGcnKdspdvHhXuat03> lstHanghoaxuatSpdv03) {
        this.lstHanghoaxuatSpdv03 = lstHanghoaxuatSpdv03;
    }
}
