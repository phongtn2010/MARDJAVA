package com.nsw.mt.p41.model;

import java.util.Date;

public class TbdhsDinhkem41 {

    private Long fiIdDk;

    //@Column(name="FI_ID_HOSO")
    private Long fiIdHoso;

    //@Column(name="FI_ID_TAILIEU")
    private Long fiIdTailieu;

    //@Column(name="FI_GHICHU", length=255)
    private String fiGhichu;

    //@Column(name="FI_TEN_TEP", length=255)
    private String fiTenTep;

    //@Column(name="FI_DUONG_DAN", length=255)
    private String fiDuongDan;

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

    //@Column(name="FI_MA_TAILIEU", length=50)
    private String fiMaTailieu;

    // @Column(name="FI_TEN_TAILIEU", length=500)
    private String fiTenTailieu;

    //@Column(name="FI_GUIID", length=500)
    private String fiGuiid;

    //@Column(name="FI_NOIDUNG", length=4000)
    private String fiNoidung;

    public TbdhsDinhkem41() {
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

    public void setFiGuiid(String fiGuiid) {
        this.fiGuiid = fiGuiid;
    }

    public String getFiGuiid() {
        return this.fiGuiid;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public String getFiNoidung() {
        return this.fiNoidung;
    }

}
