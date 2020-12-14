package com.nsw.monre.p07.model;

import java.io.Serializable;

import java.util.Date;

public class Tbdcososx7 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdCssx;

    private Long fiIdHoso;

    private String fiTenCssx;

    private String fiDiachiCssx;

    private String fiSdtCssx;

    private String fiFaxCssx;

    private String fiEmailCssx;

    private String fiMaTinh;

    private String fiTenTinh;

    private String fiMaHuyen;

    private String fiTenHuyen;

    private String fiMaXaphuong;

    private String fiTenXaphuong;

    private Long fiHoatdong;

    private String fiNguoitao;

    private Date fiNgaytao;

    private Date fiNgCapnhat;

    public Tbdcososx7() {
        super();
    }

    public void setFiIdCssx(Long fiIdCssx) {
        this.fiIdCssx = fiIdCssx;
    }

    public Long getFiIdCssx() {
        return this.fiIdCssx;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    public void setFiTenCssx(String fiTenCssx) {
        this.fiTenCssx = fiTenCssx;
    }

    public String getFiTenCssx() {
        return this.fiTenCssx;
    }

    public void setFiDiachiCssx(String fiDiachiCssx) {
        this.fiDiachiCssx = fiDiachiCssx;
    }

    public String getFiDiachiCssx() {
        return this.fiDiachiCssx;
    }

    public void setFiSdtCssx(String fiSdtCssx) {
        this.fiSdtCssx = fiSdtCssx;
    }

    public String getFiSdtCssx() {
        return this.fiSdtCssx;
    }

    public void setFiFaxCssx(String fiFaxCssx) {
        this.fiFaxCssx = fiFaxCssx;
    }

    public String getFiFaxCssx() {
        return this.fiFaxCssx;
    }

    public void setFiEmailCssx(String fiEmailCssx) {
        this.fiEmailCssx = fiEmailCssx;
    }

    public String getFiEmailCssx() {
        return this.fiEmailCssx;
    }

    public void setFiMaTinh(String fiMaTinh) {
        this.fiMaTinh = fiMaTinh;
    }

    public String getFiMaTinh() {
        return this.fiMaTinh;
    }

    public void setFiMaHuyen(String fiMaHuyen) {
        this.fiMaHuyen = fiMaHuyen;
    }

    public String getFiMaHuyen() {
        return this.fiMaHuyen;
    }

    public void setFiMaXaphuong(String fiMaXaphuong) {
        this.fiMaXaphuong = fiMaXaphuong;
    }

    public String getFiMaXaphuong() {
        return this.fiMaXaphuong;
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

    public String getFiTenTinh() {
        return fiTenTinh;
    }

    public void setFiTenTinh(String fiTenTinh) {
        this.fiTenTinh = fiTenTinh;
    }

    public String getFiTenHuyen() {
        return fiTenHuyen;
    }

    public void setFiTenHuyen(String fiTenHuyen) {
        this.fiTenHuyen = fiTenHuyen;
    }

    public String getFiTenXaphuong() {
        return fiTenXaphuong;
    }

    public void setFiTenXaphuong(String fiTenXaphuong) {
        this.fiTenXaphuong = fiTenXaphuong;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiIdCssx);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiTenCssx);
        sb.append("|");
        sb.append(fiDiachiCssx);
        sb.append("|");
        sb.append(fiSdtCssx);
        sb.append("|");
        sb.append(fiFaxCssx);
        sb.append("|");
        sb.append(fiEmailCssx);
        sb.append("|");
        sb.append(fiMaTinh);
        sb.append("|");
        sb.append(fiMaHuyen);
        sb.append("|");
        sb.append(fiMaXaphuong);
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
