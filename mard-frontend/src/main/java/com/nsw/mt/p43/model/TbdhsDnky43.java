package com.nsw.mt.p43.model;

import java.util.Date;

public class TbdhsDnky43 {

    private Long fiIdDnKy;

    private Long fiIdHoso;

    //@Column(name="FI_TEN_NG_KY", length=255)
    private String fiTenNgKy;

    //@Column(name="FI_CHUC_DANH", length=255)
    private String fiChucDanh;

    //@Column(name="FI_DIA_DIEM", length=255)
    private String fiDiaDiem;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAYKY")
    private Date fiNgayky;

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

    public TbdhsDnky43() {
        super();
    }

    public void setFiIdDnKy(Long fiIdDnKy) {
        this.fiIdDnKy = fiIdDnKy;
    }

    public Long getFiIdDnKy() {
        return this.fiIdDnKy;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    public void setFiTenNgKy(String fiTenNgKy) {
        this.fiTenNgKy = fiTenNgKy;
    }

    public String getFiTenNgKy() {
        return this.fiTenNgKy;
    }

    public void setFiChucDanh(String fiChucDanh) {
        this.fiChucDanh = fiChucDanh;
    }

    public String getFiChucDanh() {
        return this.fiChucDanh;
    }

    public void setFiDiaDiem(String fiDiaDiem) {
        this.fiDiaDiem = fiDiaDiem;
    }

    public String getFiDiaDiem() {
        return this.fiDiaDiem;
    }

    public void setFiNgayky(Date fiNgayky) {
        this.fiNgayky = fiNgayky;
    }

    public Date getFiNgayky() {
        return this.fiNgayky;
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

}
