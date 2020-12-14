/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mt.qlpt.model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class TbdqlPhuongtien {
//     @Id
//    @Column(name = "FI_ID_XE", nullable = false)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBSMAUSON_SEQ")
//    @SequenceGenerator(sequenceName = "TBSMAUSON_SEQ", schema = "MT", initialValue = 1, allocationSize = 1, name = "TBSMAUSON_SEQ")

    private Long fiIdXe;

//    @Column(name = "FI_BKS_XE")
    private String fiBksXe;

//    @Column(name = "FI_SO_KHUNG")
    private String fiSoKhung;

//    @Column(name = "FI_SO_MAY")
    private String fiSoMay;

//    @Column(name = "FI_TEN_CHUXE")
    private String fiTenChuxe;

//    @Column(name = "FI_MA_LOAIXE")
    private String fiMaLoaixe;

//    @Column(name = "FI_TEN_LOAIXE")
    private String fiTenLoaixe;

//    @Column(name = "FI_MA_QGIA")
    private String fiMaQgia;

//    @Column(name = "FI_TEN_QGIA")
    private String fiTenQgia;

//    @Column(name = "FI_MA_NHANHIEU")
    private String fiMaNhanhieu;

//    @Column(name = "FI_TEN_NHANHIEU")
    private String fiTenNhanhieu;

//    @Column(name = "FI_MA_MAUSON")
    private String fiMaMauson;

//    @Column(name = "FI_TEN_MAUSON")
    private String fiTenMauson;

//    @Column(name = "FI_SO_GHE")
    private String fiSoGhe;

//    @Column(name = "FI_NAM_SX")
    private String fiNamSx;

//    @Column(name = "FI_NAM_HSD")
    private String fiNamHsd;

//    @Column(name = "FI_HOATDONG")
    private Long fiHoatdong;

//    @Column(name = "FI_NGUOITAO")
    private String fiNguoitao;

//    @Column(name = "FI_NGAYTAO")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaytao;

//    @Column(name = "FI_NG_CAPNHAT")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgCapnhat;

//    @Column(name = "FI_SUA")
    private Long fiSua;

    public TbdqlPhuongtien() {
    }

    public Long getFiIdXe() {
        return fiIdXe;
    }

    public void setFiIdXe(Long fiIdXe) {
        this.fiIdXe = fiIdXe;
    }

    public String getFiBksXe() {
        return fiBksXe;
    }

    public void setFiBksXe(String fiBksXe) {
        this.fiBksXe = fiBksXe;
    }

    public String getFiSoKhung() {
        return fiSoKhung;
    }

    public void setFiSoKhung(String fiSoKhung) {
        this.fiSoKhung = fiSoKhung;
    }

    public String getFiSoMay() {
        return fiSoMay;
    }

    public void setFiSoMay(String fiSoMay) {
        this.fiSoMay = fiSoMay;
    }

    public String getFiTenChuxe() {
        return fiTenChuxe;
    }

    public void setFiTenChuxe(String fiTenChuxe) {
        this.fiTenChuxe = fiTenChuxe;
    }

    public String getFiMaLoaixe() {
        return fiMaLoaixe;
    }

    public void setFiMaLoaixe(String fiMaLoaixe) {
        this.fiMaLoaixe = fiMaLoaixe;
    }

    public String getFiTenLoaixe() {
        return fiTenLoaixe;
    }

    public void setFiTenLoaixe(String fiTenLoaixe) {
        this.fiTenLoaixe = fiTenLoaixe;
    }

    public String getFiMaQgia() {
        return fiMaQgia;
    }

    public void setFiMaQgia(String fiMaQgia) {
        this.fiMaQgia = fiMaQgia;
    }

    public String getFiTenQgia() {
        return fiTenQgia;
    }

    public void setFiTenQgia(String fiTenQgia) {
        this.fiTenQgia = fiTenQgia;
    }

    public String getFiMaNhanhieu() {
        return fiMaNhanhieu;
    }

    public void setFiMaNhanhieu(String fiMaNhanhieu) {
        this.fiMaNhanhieu = fiMaNhanhieu;
    }

    public String getFiTenNhanhieu() {
        return fiTenNhanhieu;
    }

    public void setFiTenNhanhieu(String fiTenNhanhieu) {
        this.fiTenNhanhieu = fiTenNhanhieu;
    }

    public String getFiMaMauson() {
        return fiMaMauson;
    }

    public void setFiMaMauson(String fiMaMauson) {
        this.fiMaMauson = fiMaMauson;
    }

    public String getFiTenMauson() {
        return fiTenMauson;
    }

    public void setFiTenMauson(String fiTenMauson) {
        this.fiTenMauson = fiTenMauson;
    }

    public String getFiSoGhe() {
        return fiSoGhe;
    }

    public void setFiSoGhe(String fiSoGhe) {
        this.fiSoGhe = fiSoGhe;
    }

    public String getFiNamSx() {
        return fiNamSx;
    }

    public void setFiNamSx(String fiNamSx) {
        this.fiNamSx = fiNamSx;
    }

    public String getFiNamHsd() {
        return fiNamHsd;
    }

    public void setFiNamHsd(String fiNamHsd) {
        this.fiNamHsd = fiNamHsd;
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

    public Long getFiSua() {
        return fiSua;
    }

    public void setFiSua(Long fiSua) {
        this.fiSua = fiSua;
    }

}
