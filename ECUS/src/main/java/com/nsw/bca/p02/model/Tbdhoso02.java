/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.bca.p02.model;

import java.util.Date;
import java.util.List;

/**
 *
 */
public class Tbdhoso02 {

    private Long fiIdHoso;
    private String fiMaHoso;
    private String fiMst;
    private String fiTenDn;
    private String fiDiachiDn;
    private String fiSoDondk;
    private String fiMaCoquan;
    private String fiTenCoquan;
    private String fiNguoiDaidien;
    private String fiChucvuDaidien;
    private String fiSoCmnd;
    private Date fiNgaycapCmnd;
    private String fiNoicapCmnd;
    private String fiHoadonSo;
    private Date fiHoadonNgay;
    private String fiHoadonTencqc;
    private String fiTenHanghoa;
    private String fiHanhtrinhvcTu;
    private String fiHanhtrinhvcQua;
    private String fiHanhtrinhvcDen;
    private Date fiThoigianvcTu;
    private Date fiThoigianvcDen;
    private Date fiNgayky;
    private String fiNguoiky;
    private String fiDiadiemky;
    private Date fiNgaygui;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;
    private Date fiNgCapnhat;
    private Long fiTrangthai;
    private String fiTenTt;
    private String fiSoGp;
    private Date fiNgaycapGp;

    private Long fiIdHosocha;

    private Long fiIsHosotam;

    private Long fiNgaysua;

    private String fiLydo;

    private List<TbdhsDinhkem02> lstDinhKem;

    private List<TbdhsNguoidk02> lstNguoiDieukhien;

    public Tbdhoso02() {
    }

    public Tbdhoso02(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
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

    public String getFiMst() {
        return fiMst;
    }

    public void setFiMst(String fiMst) {
        this.fiMst = fiMst;
    }

    public String getFiTenDn() {
        return fiTenDn;
    }

    public void setFiTenDn(String fiTenDn) {
        this.fiTenDn = fiTenDn;
    }

    public String getFiDiachiDn() {
        return fiDiachiDn;
    }

    public void setFiDiachiDn(String fiDiachiDn) {
        this.fiDiachiDn = fiDiachiDn;
    }

    public String getFiSoDondk() {
        return fiSoDondk;
    }

    public void setFiSoDondk(String fiSoDondk) {
        this.fiSoDondk = fiSoDondk;
    }

    public String getFiMaCoquan() {
        return fiMaCoquan;
    }

    public void setFiMaCoquan(String fiMaCoquan) {
        this.fiMaCoquan = fiMaCoquan;
    }

    public String getFiTenCoquan() {
        return fiTenCoquan;
    }

    public void setFiTenCoquan(String fiTenCoquan) {
        this.fiTenCoquan = fiTenCoquan;
    }

    public String getFiNguoiDaidien() {
        return fiNguoiDaidien;
    }

    public void setFiNguoiDaidien(String fiNguoiDaidien) {
        this.fiNguoiDaidien = fiNguoiDaidien;
    }

    public String getFiChucvuDaidien() {
        return fiChucvuDaidien;
    }

    public void setFiChucvuDaidien(String fiChucvuDaidien) {
        this.fiChucvuDaidien = fiChucvuDaidien;
    }

    public String getFiSoCmnd() {
        return fiSoCmnd;
    }

    public void setFiSoCmnd(String fiSoCmnd) {
        this.fiSoCmnd = fiSoCmnd;
    }

    public Date getFiNgaycapCmnd() {
        return fiNgaycapCmnd;
    }

    public void setFiNgaycapCmnd(Date fiNgaycapCmnd) {
        this.fiNgaycapCmnd = fiNgaycapCmnd;
    }

    public String getFiNoicapCmnd() {
        return fiNoicapCmnd;
    }

    public void setFiNoicapCmnd(String fiNoicapCmnd) {
        this.fiNoicapCmnd = fiNoicapCmnd;
    }

    public String getFiHoadonSo() {
        return fiHoadonSo;
    }

    public void setFiHoadonSo(String fiHoadonSo) {
        this.fiHoadonSo = fiHoadonSo;
    }

    public Date getFiHoadonNgay() {
        return fiHoadonNgay;
    }

    public void setFiHoadonNgay(Date fiHoadonNgay) {
        this.fiHoadonNgay = fiHoadonNgay;
    }

    public String getFiHoadonTencqc() {
        return fiHoadonTencqc;
    }

    public void setFiHoadonTencqc(String fiHoadonTencqc) {
        this.fiHoadonTencqc = fiHoadonTencqc;
    }

    public String getFiTenHanghoa() {
        return fiTenHanghoa;
    }

    public void setFiTenHanghoa(String fiTenHanghoa) {
        this.fiTenHanghoa = fiTenHanghoa;
    }

    public String getFiHanhtrinhvcTu() {
        return fiHanhtrinhvcTu;
    }

    public void setFiHanhtrinhvcTu(String fiHanhtrinhvcTu) {
        this.fiHanhtrinhvcTu = fiHanhtrinhvcTu;
    }

    public String getFiHanhtrinhvcQua() {
        return fiHanhtrinhvcQua;
    }

    public void setFiHanhtrinhvcQua(String fiHanhtrinhvcQua) {
        this.fiHanhtrinhvcQua = fiHanhtrinhvcQua;
    }

    public String getFiHanhtrinhvcDen() {
        return fiHanhtrinhvcDen;
    }

    public void setFiHanhtrinhvcDen(String fiHanhtrinhvcDen) {
        this.fiHanhtrinhvcDen = fiHanhtrinhvcDen;
    }

    public Date getFiThoigianvcTu() {
        return fiThoigianvcTu;
    }

    public void setFiThoigianvcTu(Date fiThoigianvcTu) {
        this.fiThoigianvcTu = fiThoigianvcTu;
    }

    public Date getFiThoigianvcDen() {
        return fiThoigianvcDen;
    }

    public void setFiThoigianvcDen(Date fiThoigianvcDen) {
        this.fiThoigianvcDen = fiThoigianvcDen;
    }

    public Date getFiNgayky() {
        return fiNgayky;
    }

    public void setFiNgayky(Date fiNgayky) {
        this.fiNgayky = fiNgayky;
    }

    public String getFiNguoiky() {
        return fiNguoiky;
    }

    public void setFiNguoiky(String fiNguoiky) {
        this.fiNguoiky = fiNguoiky;
    }

    public String getFiDiadiemky() {
        return fiDiadiemky;
    }

    public void setFiDiadiemky(String fiDiadiemky) {
        this.fiDiadiemky = fiDiadiemky;
    }

    public Date getFiNgaygui() {
        return fiNgaygui;
    }

    public void setFiNgaygui(Date fiNgaygui) {
        this.fiNgaygui = fiNgaygui;
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

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public String getFiTenTt() {
        return fiTenTt;
    }

    public void setFiTenTt(String fiTenTt) {
        this.fiTenTt = fiTenTt;
    }

    public String getFiSoGp() {
        return fiSoGp;
    }

    public void setFiSoGp(String fiSoGp) {
        this.fiSoGp = fiSoGp;
    }

    public Date getFiNgaycapGp() {
        return fiNgaycapGp;
    }

    public void setFiNgaycapGp(Date fiNgaycapGp) {
        this.fiNgaycapGp = fiNgaycapGp;
    }

    public Long getFiIdHosocha() {
        return fiIdHosocha;
    }

    public void setFiIdHosocha(Long fiIdHosocha) {
        this.fiIdHosocha = fiIdHosocha;
    }

    public Long getFiIsHosotam() {
        return fiIsHosotam;
    }

    public void setFiIsHosotam(Long fiIsHosotam) {
        this.fiIsHosotam = fiIsHosotam;
    }

    public Long getFiNgaysua() {
        return fiNgaysua;
    }

    public void setFiNgaysua(Long fiNgaysua) {
        this.fiNgaysua = fiNgaysua;
    }

    public String getFiLydo() {
        return fiLydo;
    }

    public void setFiLydo(String fiLydo) {
        this.fiLydo = fiLydo;
    }

    public List<TbdhsDinhkem02> getLstDinhKem() {
        return lstDinhKem;
    }

    public void setLstDinhKem(List<TbdhsDinhkem02> lstDinhKem) {
        this.lstDinhKem = lstDinhKem;
    }

    public List<TbdhsNguoidk02> getLstNguoiDieukhien() {
        return lstNguoiDieukhien;
    }

    public void setLstNguoiDieukhien(List<TbdhsNguoidk02> lstNguoiDieukhien) {
        this.lstNguoiDieukhien = lstNguoiDieukhien;
    }

}
