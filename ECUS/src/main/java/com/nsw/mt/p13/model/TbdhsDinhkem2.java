package com.nsw.mt.p13.model;

import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

public class TbdhsDinhkem2 implements Serializable {

    private Long fiIdDk;

    private Long fiIdHoso;

    private Long fiIdTailieu;

    private String fiGhichu;

    private String fiTenTep;

    private String fiDuongDan;

    private Long fiHoatdong;

    private String fiNguoitao;

    private Date fiNgaytao;

    private Date fiNgCapnhat;

    private String fiMaTailieu;

    private String fiTenTailieu;

    private Clob fiNoidung;

    private String fiGuiid;

    public TbdhsDinhkem2() {
        super();
    }

    public void setFiIdDk(Long fiIdDk) {
        this.fiIdDk = fiIdDk;
    }

    public Long getFiIdDk() {
        return this.fiIdDk;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    public void setFiIdTailieu(Long fiIdTailieu) {
        this.fiIdTailieu = fiIdTailieu;
    }

    public Long getFiIdTailieu() {
        return this.fiIdTailieu;
    }

    public void setFiGhichu(String fiGhichu) {
        this.fiGhichu = fiGhichu;
    }

    public String getFiGhichu() {
        return this.fiGhichu;
    }

    public void setFiTenTep(String fiTenTep) {
        this.fiTenTep = fiTenTep;
    }

    public String getFiTenTep() {
        return this.fiTenTep;
    }

    public void setFiDuongDan(String fiDuongDan) {
        this.fiDuongDan = fiDuongDan;
    }

    public String getFiDuongDan() {
        return this.fiDuongDan;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public String getFiNguoitao() {
        return this.fiNguoitao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaytao() {
        return this.fiNgaytao;
    }

    public void setFiNgCapnhat(Date fiNgCapnhat) {
        this.fiNgCapnhat = fiNgCapnhat;
    }

    public Date getFiNgCapnhat() {
        return this.fiNgCapnhat;
    }

    public void setFiMaTailieu(String fiMaTailieu) {
        this.fiMaTailieu = fiMaTailieu;
    }

    public String getFiMaTailieu() {
        return this.fiMaTailieu;
    }

    public void setFiTenTailieu(String fiTenTailieu) {
        this.fiTenTailieu = fiTenTailieu;
    }

    public String getFiTenTailieu() {
        return this.fiTenTailieu;
    }

    public void setFiNoidung(Clob fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public Clob getFiNoidung() {
        return this.fiNoidung;
    }

    public String getFiGuiid() {
        return fiGuiid;
    }

    public void setFiGuiid(String fiGuiid) {
        this.fiGuiid = fiGuiid;
    }

}
