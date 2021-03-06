/*
 * Created on 2 Aug 2017 ( Time 15:44:16 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.most.p03.model;

import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

public class Tbddinhkem3 implements Serializable {

    private Long fiIdDinhkem;

    private String fiMaLoai;

    private String fiTenLoai;

    private String fiTenTep;

    private Long fiIdHoso;

    private Date fiNgaytao;

    private Long fiHoatdong;

    private String fiDuongDan;

    private String fiGuiId;

    private String fiNguoitao;

    private Long fiFileSize;

    private Long fiIdQd;

    private String fiMaHoso;

    private String fiMaLoaiTaiLieu;

    private String fiTenLoaiTaiLieu;

    private Date fiNgayCap;

    private Long fiMostId;

    private Long fiIdDt;

    private Long fiIdLoaiDt;

    private Clob fiNdTep;

//    private String fiSoVb;
    private Long stt;

    private Date fiNgayguiMau;

    private String fiDvThunghiem;

    private Date fiNgaynhanKq;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbddinhkem3() {
        super();
    }

    public Tbddinhkem3(Long fiIdDinhkem, String fiMaLoai, String fiTenLoai, String fiTenTep, Long fiIdHoso, Date fiNgaytao, Long fiHoatdong, String fiDuongDan, String fiGuiId, String fiNguoitao, Long fiFileSize, Long fiIdQd, String fiMaHoso, String fiMaLoaiTaiLieu, String fiTenLoaiTaiLieu, Date fiNgayCap, Long fiMostId, Long fiIdDt, Long fiIdLoaiDt, Clob fiNdTep, Long stt) {
        this.fiIdDinhkem = fiIdDinhkem;
        this.fiMaLoai = fiMaLoai;
        this.fiTenLoai = fiTenLoai;
        this.fiTenTep = fiTenTep;
        this.fiIdHoso = fiIdHoso;
        this.fiNgaytao = fiNgaytao;
        this.fiHoatdong = fiHoatdong;
        this.fiDuongDan = fiDuongDan;
        this.fiGuiId = fiGuiId;
        this.fiNguoitao = fiNguoitao;
        this.fiFileSize = fiFileSize;
        this.fiIdQd = fiIdQd;
        this.fiMaHoso = fiMaHoso;
        this.fiMaLoaiTaiLieu = fiMaLoaiTaiLieu;
        this.fiTenLoaiTaiLieu = fiTenLoaiTaiLieu;
        this.fiNgayCap = fiNgayCap;
        this.fiMostId = fiMostId;
        this.fiIdDt = fiIdDt;
        this.fiIdLoaiDt = fiIdLoaiDt;
        this.fiNdTep = fiNdTep;
        this.stt = stt;
    }

    public Long getFiIdDinhkem() {
        return fiIdDinhkem;
    }

    public void setFiIdDinhkem(Long fiIdDinhkem) {
        this.fiIdDinhkem = fiIdDinhkem;
    }

    public String getFiMaLoai() {
        return fiMaLoai;
    }

    public void setFiMaLoai(String fiMaLoai) {
        this.fiMaLoai = fiMaLoai;
    }

    public String getFiTenLoai() {
        return fiTenLoai;
    }

    public void setFiTenLoai(String fiTenLoai) {
        this.fiTenLoai = fiTenLoai;
    }

    public String getFiTenTep() {
        return fiTenTep;
    }

    public void setFiTenTep(String fiTenTep) {
        this.fiTenTep = fiTenTep;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public String getFiDuongDan() {
        return fiDuongDan;
    }

    public void setFiDuongDan(String fiDuongDan) {
        this.fiDuongDan = fiDuongDan;
    }

    public String getFiGuiId() {
        return fiGuiId;
    }

    public void setFiGuiId(String fiGuiId) {
        this.fiGuiId = fiGuiId;
    }

    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public Long getFiFileSize() {
        return fiFileSize;
    }

    public void setFiFileSize(Long fiFileSize) {
        this.fiFileSize = fiFileSize;
    }

    public Long getFiIdQd() {
        return fiIdQd;
    }

    public void setFiIdQd(Long fiIdQd) {
        this.fiIdQd = fiIdQd;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiMaLoaiTaiLieu() {
        return fiMaLoaiTaiLieu;
    }

    public void setFiMaLoaiTaiLieu(String fiMaLoaiTaiLieu) {
        this.fiMaLoaiTaiLieu = fiMaLoaiTaiLieu;
    }

    public String getFiTenLoaiTaiLieu() {
        return fiTenLoaiTaiLieu;
    }

    public void setFiTenLoaiTaiLieu(String fiTenLoaiTaiLieu) {
        this.fiTenLoaiTaiLieu = fiTenLoaiTaiLieu;
    }

    public Date getFiNgayCap() {
        return fiNgayCap;
    }

    public void setFiNgayCap(Date fiNgayCap) {
        this.fiNgayCap = fiNgayCap;
    }

    public Long getFiMostId() {
        return fiMostId;
    }

    public void setFiMostId(Long fiMostId) {
        this.fiMostId = fiMostId;
    }

    public Long getFiIdDt() {
        return fiIdDt;
    }

    public void setFiIdDt(Long fiIdDt) {
        this.fiIdDt = fiIdDt;
    }

    public Long getFiIdLoaiDt() {
        return fiIdLoaiDt;
    }

    public void setFiIdLoaiDt(Long fiIdLoaiDt) {
        this.fiIdLoaiDt = fiIdLoaiDt;
    }

    public Clob getFiNdTep() {
        return fiNdTep;
    }

    public void setFiNdTep(Clob fiNdTep) {
        this.fiNdTep = fiNdTep;
    }

    public Long getStt() {
        return stt;
    }

    public void setStt(Long stt) {
        this.stt = stt;
    }

    public Date getFiNgayguiMau() {
        return fiNgayguiMau;
    }

    public void setFiNgayguiMau(Date fiNgayguiMau) {
        this.fiNgayguiMau = fiNgayguiMau;
    }

    public String getFiDvThunghiem() {
        return fiDvThunghiem;
    }

    public void setFiDvThunghiem(String fiDvThunghiem) {
        this.fiDvThunghiem = fiDvThunghiem;
    }

    public Date getFiNgaynhanKq() {
        return fiNgaynhanKq;
    }

    public void setFiNgaynhanKq(Date fiNgaynhanKq) {
        this.fiNgaynhanKq = fiNgaynhanKq;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiIdDinhkem);
        sb.append("]:");
        sb.append(fiMaLoai);
        sb.append("|");
        sb.append(fiTenLoai);
        sb.append("|");
        sb.append(fiTenTep);
        sb.append("|");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiDuongDan);
        sb.append("|");
        sb.append(fiGuiId);
        sb.append("|");
        sb.append(fiNguoitao);
        sb.append("|");
        sb.append(fiFileSize);
        sb.append("|");
        sb.append(fiIdQd);
        sb.append("|");
        sb.append(fiMaHoso);
        return sb.toString();
    }

}
