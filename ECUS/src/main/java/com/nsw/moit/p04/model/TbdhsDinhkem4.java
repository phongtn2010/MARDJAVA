package com.nsw.moit.p04.model;

import java.util.Date;

public class TbdhsDinhkem4 {

    private Long fiIdDk;

    //@Column(name = "FI_ID_HOSO")
    private Long fiIdHoso;
    //@Column(name = "FI_ID_TLIEU")
    private Long fiIdTlieu;
    //@Column(name = "FI_LOAI_TLIEU")
    private Integer fiLoaiTlieu;
    //@Size(max = 250)
    //@Column(name = "FI_TEN_TEP")
    private String fiTenTep;
    //@Lob
    //@Column(name = "FI_NOIDUNG")
    private String fiNoidung;
    //@Size(max = 255)
    //@Column(name = "FI_DUONG_DAN")
    private String fiDuongDan;
    //@Size(max = 500)
    //@Column(name = "FI_GUIID")
    private String fiGuiid;
    //@Column(name = "FI_HOATDONG")
    private Long fiHoatdong;
    //@Size(max = 50)
    //@Column(name = "FI_NGUOITAO")
    private String fiNguoitao;
    //@Column(name = "FI_NGAYTAO")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaytao;
    //@Column(name = "FI_NG_CAPNHAT")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date fiNgCapnhat;
    //@Size(max = 500)
    //@Column(name = "FI_TEN_LOAI_TL")
    private String fiTenLoaiTl;

    public TbdhsDinhkem4() {
        super();
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

    public Long getFiIdTlieu() {
        return fiIdTlieu;
    }

    public void setFiIdTlieu(Long fiIdTlieu) {
        this.fiIdTlieu = fiIdTlieu;
    }

    public Integer getFiLoaiTlieu() {
        return fiLoaiTlieu;
    }

    public void setFiLoaiTlieu(Integer fiLoaiTlieu) {
        this.fiLoaiTlieu = fiLoaiTlieu;
    }

    public String getFiTenTep() {
        return fiTenTep;
    }

    public void setFiTenTep(String fiTenTep) {
        this.fiTenTep = fiTenTep;
    }

    public String getFiNoidung() {
        return fiNoidung;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public String getFiDuongDan() {
        return fiDuongDan;
    }

    public void setFiDuongDan(String fiDuongDan) {
        this.fiDuongDan = fiDuongDan;
    }

    public String getFiGuiid() {
        return fiGuiid;
    }

    public void setFiGuiid(String fiGuiid) {
        this.fiGuiid = fiGuiid;
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

    public String getFiTenLoaiTl() {
        return fiTenLoaiTl;
    }

    public void setFiTenLoaiTl(String fiTenLoaiTl) {
        this.fiTenLoaiTl = fiTenLoaiTl;
    }

}
