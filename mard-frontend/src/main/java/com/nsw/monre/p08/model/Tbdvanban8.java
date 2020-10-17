package com.nsw.monre.p08.model;

import java.io.Serializable;
import java.util.Date;

public class Tbdvanban8 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdVb;

    private Long fiIdHoso;

    private String fiMaHoso;

    private String fiCoQuanCap;

    private String fiSoVanBan;

    private Date fiNgayKy;

    private String fiNguoiKy;
    private String fiTenTepTin;
    private String fiNoidungTepTin;

    private Long fiHoatdong;

    private String fiNguoitao;

    private Date fiNgaytao;

    private Date fiNgCapnhat;

    private Tbddinhkem8 dinhkem;

    public Tbdvanban8() {
        super();
    }

    public Long getFiIdVb() {
        return fiIdVb;
    }

    public void setFiIdVb(Long fiIdVb) {
        this.fiIdVb = fiIdVb;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiCoQuanCap() {
        return fiCoQuanCap;
    }

    public void setFiCoQuanCap(String fiCoQuanCap) {
        this.fiCoQuanCap = fiCoQuanCap;
    }

    public String getFiSoVanBan() {
        return fiSoVanBan;
    }

    public void setFiSoVanBan(String fiSoVanBan) {
        this.fiSoVanBan = fiSoVanBan;
    }

    public Date getFiNgayKy() {
        return fiNgayKy;
    }

    public void setFiNgayKy(Date fiNgayKy) {
        this.fiNgayKy = fiNgayKy;
    }

    public String getFiNguoiKy() {
        return fiNguoiKy;
    }

    public void setFiNguoiKy(String fiNguoiKy) {
        this.fiNguoiKy = fiNguoiKy;
    }

    public String getFiTenTepTin() {
        return fiTenTepTin;
    }

    public void setFiTenTepTin(String fiTenTepTin) {
        this.fiTenTepTin = fiTenTepTin;
    }

    public String getFiNoidungTepTin() {
        return fiNoidungTepTin;
    }

    public void setFiNoidungTepTin(String fiNoidungTepTin) {
        this.fiNoidungTepTin = fiNoidungTepTin;
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

    public Tbddinhkem8 getDinhkem() {
        return dinhkem;
    }

    public void setDinhkem(Tbddinhkem8 dinhkem) {
        this.dinhkem = dinhkem;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiIdVb);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiCoQuanCap);
        sb.append("|");
        sb.append(fiSoVanBan);
        sb.append("|");
        sb.append(fiNgayKy);
        sb.append("|");
        sb.append(fiNguoiKy);
        sb.append("|");
        sb.append(fiTenTepTin);
        sb.append("|");
        sb.append(fiNoidungTepTin);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNguoitao);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNgCapnhat);
        return sb.toString();
    }

}
