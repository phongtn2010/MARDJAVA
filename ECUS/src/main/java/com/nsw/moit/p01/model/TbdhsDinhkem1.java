package com.nsw.moit.p01.model;

import java.util.Date;

public class TbdhsDinhkem1 {

    private Long fiIdDk;

    //@Column(name="FI_ID_HOSO")
    private Long fiIdHoso;

    //@Column(name="FI_ID_TLIEU")
    private Long fiIdTlieu;

    //@Column(name="FI_LOAI_TLIEU")
    private Long fiLoaiTlieu;

    //@Column(name="FI_TEN_TEP", length=250)
    private String fiTenTep;

    //@Column(name="FI_NOIDUNG")
    private String fiNoidung;

    //@Column(name="FI_DUONG_DAN", length=255)
    private String fiDuongDan;

    //@Column(name="FI_GUIID", length=500)
    private String fiGuiid;

    //@Column(name="FI_HOATDONG")
    private Long fiHoatdong;

    //@Column(name="FI_NGUOITAO", length=50)
    private String fiNguoitao;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAYTAO")
    private Date fiNgaytao;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NG_CAPNHAT")
    private Date fiNgCapnhat;

    private String fiTenLoaiTl;

    public TbdhsDinhkem1() {
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

    public void setFiIdTlieu(Long fiIdTlieu) {
        this.fiIdTlieu = fiIdTlieu;
    }

    public Long getFiIdTlieu() {
        return this.fiIdTlieu;
    }

    public void setFiLoaiTlieu(Long fiLoaiTlieu) {
        this.fiLoaiTlieu = fiLoaiTlieu;
    }

    public Long getFiLoaiTlieu() {
        return this.fiLoaiTlieu;
    }

    public void setFiTenTep(String fiTenTep) {
        this.fiTenTep = fiTenTep;
    }

    public String getFiTenTep() {
        return this.fiTenTep;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public String getFiNoidung() {
        return this.fiNoidung;
    }

    public void setFiDuongDan(String fiDuongDan) {
        this.fiDuongDan = fiDuongDan;
    }

    public String getFiDuongDan() {
        return this.fiDuongDan;
    }

    public void setFiGuiid(String fiGuiid) {
        this.fiGuiid = fiGuiid;
    }

    public String getFiGuiid() {
        return this.fiGuiid;
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

    public String getFiTenLoaiTl() {
        return fiTenLoaiTl;
    }

    public void setFiTenLoaiTl(String fiTenLoaiTl) {
        this.fiTenLoaiTl = fiTenLoaiTl;
    }

}
