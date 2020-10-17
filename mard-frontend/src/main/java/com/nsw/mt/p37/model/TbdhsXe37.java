package com.nsw.mt.p37.model;

import java.util.Date;

public class TbdhsXe37 {

    private Long fiIdXe;

    //@Column(name="FI_ID_HOSO")
    private Long fiIdHoso;

    //@Column(name="FI_STT")
    private Long fiStt;

    //@Column(name="FI_BKS_XE", length=255)
    private String fiBksXe;

    //@Column(name="FI_MA_NHANHIEU", length=255)
    private String fiMaNhanhieu;

    //@Column(name="FI_TEN_HIEU", length=255)
    private String fiTenHieu;

    //@Column(name="FI_SO_GHE", length=255)
    private String fiSoGhe;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_DNCP_TU_NG")
    private Date fiDncpTuNg;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_DNCP_DEN_NG")
    private Date fiDncpDenNg;

    //@Column(name="FI_MA_TUYEN", length=255)
    private String fiMaTuyen;

    //@Column(name="FI_TEN_TUYEN", length=255)
    private String fiTenTuyen;

    //@Column(name="FI_HINHTHUC", length=255)
    private String fiHinhthuc;

    //@Column(name="FI_DIEM_DUNG", length=255)
    private String fiDiemDung;

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

    public TbdhsXe37() {
        super();
    }

    public void setFiIdXe(Long fiIdXe) {
        this.fiIdXe = fiIdXe;
    }

    public Long getFiIdXe() {
        return this.fiIdXe;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    public void setFiStt(Long fiStt) {
        this.fiStt = fiStt;
    }

    public Long getFiStt() {
        return this.fiStt;
    }

    public void setFiBksXe(String fiBksXe) {
        this.fiBksXe = fiBksXe;
    }

    public String getFiBksXe() {
        return this.fiBksXe;
    }

    public void setFiMaNhanhieu(String fiMaNhanhieu) {
        this.fiMaNhanhieu = fiMaNhanhieu;
    }

    public String getFiMaNhanhieu() {
        return this.fiMaNhanhieu;
    }

    public void setFiTenHieu(String fiTenHieu) {
        this.fiTenHieu = fiTenHieu;
    }

    public String getFiTenHieu() {
        return this.fiTenHieu;
    }

    public void setFiSoGhe(String fiSoGhe) {
        this.fiSoGhe = fiSoGhe;
    }

    public String getFiSoGhe() {
        return this.fiSoGhe;
    }

    public void setFiDncpTuNg(Date fiDncpTuNg) {
        this.fiDncpTuNg = fiDncpTuNg;
    }

    public Date getFiDncpTuNg() {
        return this.fiDncpTuNg;
    }

    public void setFiDncpDenNg(Date fiDncpDenNg) {
        this.fiDncpDenNg = fiDncpDenNg;
    }

    public Date getFiDncpDenNg() {
        return this.fiDncpDenNg;
    }

    public void setFiMaTuyen(String fiMaTuyen) {
        this.fiMaTuyen = fiMaTuyen;
    }

    public String getFiMaTuyen() {
        return this.fiMaTuyen;
    }

    public void setFiTenTuyen(String fiTenTuyen) {
        this.fiTenTuyen = fiTenTuyen;
    }

    public String getFiTenTuyen() {
        return this.fiTenTuyen;
    }

    public void setFiHinhthuc(String fiHinhthuc) {
        this.fiHinhthuc = fiHinhthuc;
    }

    public String getFiHinhthuc() {
        return this.fiHinhthuc;
    }

    public void setFiDiemDung(String fiDiemDung) {
        this.fiDiemDung = fiDiemDung;
    }

    public String getFiDiemDung() {
        return this.fiDiemDung;
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
