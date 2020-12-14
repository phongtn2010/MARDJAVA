package com.nsw.monre.p08.model;

import java.io.Serializable;
import java.util.Date;

public class Tbdkqxl8 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdKqxl;

    private Long fiIdHoso;

    private String fiMaHoso;

    private String fiNoidung;

    private Date fiNgayXl;

    private String fiDonviXl;

    private String fiLinkCvan;

    private Long fiHoatdong;

    private String fiNguoitao;

    private Date fiNgaytao;

    private Date fiNgCapnhat;

    private String fiTenTt;

    private Long fiTrangthai;

    public Tbdkqxl8() {
        super();
    }

    public void setFiIdKqxl(Long fiIdKqxl) {
        this.fiIdKqxl = fiIdKqxl;
    }

    public Long getFiIdKqxl() {
        return this.fiIdKqxl;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiMaHoso() {
        return this.fiMaHoso;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public String getFiNoidung() {
        return this.fiNoidung;
    }

    public void setFiNgayXl(Date fiNgayXl) {
        this.fiNgayXl = fiNgayXl;
    }

    public Date getFiNgayXl() {
        return this.fiNgayXl;
    }

    public void setFiDonviXl(String fiDonviXl) {
        this.fiDonviXl = fiDonviXl;
    }

    public String getFiDonviXl() {
        return this.fiDonviXl;
    }

    public void setFiLinkCvan(String fiLinkCvan) {
        this.fiLinkCvan = fiLinkCvan;
    }

    public String getFiLinkCvan() {
        return this.fiLinkCvan;
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

    public void setFiTenTt(String fiTenTt) {
        this.fiTenTt = fiTenTt;
    }

    public String getFiTenTt() {
        return this.fiTenTt;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Long getFiTrangthai() {
        return this.fiTrangthai;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiIdKqxl);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiNoidung);
        sb.append("|");
        sb.append(fiNgayXl);
        sb.append("|");
        sb.append(fiDonviXl);
        sb.append("|");
        sb.append(fiLinkCvan);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNguoitao);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNgCapnhat);
        sb.append("|");
        sb.append(fiTenTt);
        sb.append("|");
        sb.append(fiTrangthai);
        return sb.toString();
    }

}
