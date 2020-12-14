/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p06.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class TbdhsDinhkem06 implements Serializable {

//    @XmlTransient
    private static final long serialVersionUID = 1L;

//    @XmlTransient
    private Long fiIdDk;

//    @XmlTransient
    private Long fiIdHoso;
//    @XmlElement(name = "loai_tep_tin")
    private String fiMaTailieu;

//    @XmlElement(name = "ten_loai_tep")
    private String fiTenTailieu;

//    @XmlElement(name = "ten_tep_tin")
    private String fiTenTep;

//    @XmlElement(name = "tep_tin_id")
    private Long fiIdTailieu;

//    @XmlTransient
    private String fiGhichu;

//    @XmlTransient
    private String fiDuongDan;

//    @XmlTransient
    private Long fiHoatdong;

//    @XmlTransient
    private String fiNguoitao;

//    @XmlTransient
    private Date fiNgaytao;

//    @XmlTransient
    private Date fiNgCapnhat;

//    @XmlTransient
    private String fiNoidung;

//    @XmlTransient
    private String fiGuiid;

    public TbdhsDinhkem06() {
    }

    public TbdhsDinhkem06(Long fiIdDk) {
        this.fiIdDk = fiIdDk;
    }

    public Long getFiIdDk() {
        return fiIdDk;
    }

    public void setFiIdDk(Long fiIdDk) {
        this.fiIdDk = fiIdDk;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdTailieu() {
        return fiIdTailieu;
    }

    public void setFiIdTailieu(Long fiIdTailieu) {
        this.fiIdTailieu = fiIdTailieu;
    }

    public String getFiGhichu() {
        return fiGhichu;
    }

    public void setFiGhichu(String fiGhichu) {
        this.fiGhichu = fiGhichu;
    }

    public String getFiTenTep() {
        return fiTenTep;
    }

    public void setFiTenTep(String fiTenTep) {
        this.fiTenTep = fiTenTep;
    }

    public String getFiDuongDan() {
        return fiDuongDan;
    }

    public void setFiDuongDan(String fiDuongDan) {
        this.fiDuongDan = fiDuongDan;
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

    public String getFiMaTailieu() {
        return fiMaTailieu;
    }

    public void setFiMaTailieu(String fiMaTailieu) {
        this.fiMaTailieu = fiMaTailieu;
    }

    public String getFiTenTailieu() {
        return fiTenTailieu;
    }

    public void setFiTenTailieu(String fiTenTailieu) {
        this.fiTenTailieu = fiTenTailieu;
    }

    public String getFiNoidung() {
        return fiNoidung;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public String getFiGuiid() {
        return fiGuiid;
    }

    public void setFiGuiid(String fiGuiid) {
        this.fiGuiid = fiGuiid;
    }
}
