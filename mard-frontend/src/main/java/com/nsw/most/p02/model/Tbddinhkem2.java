package com.nsw.most.p02.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import com.nsw.annotations.*;
import com.nsw.util.CustomJsonDateDeserializer;

import java.util.Date;

/**
 * Persistent class for entity stored in table "TBDDINHKEM2"
 *
 * @author Telosys Tools Generator
 *
 */
public class Tbddinhkem2 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long fiIdDinhkem;

    private String fiMaLoai;

    private String fiTenLoai;

    private String fiSoVb;

    private Date fiNgayCap;
    private String fiTenTep;

    private Long fiIdHoso;

    private Date fiNgaytao;

    private Long fiHoatdong;

    private String fiDuongDan;

    private String fiGuiId;

    private String fiNguoitao;

    private String fiMaLoaiTaiLieu;

    private String fiTenLoaiTaiLieu;

    private Long fiFileSize;
    
    private Long fiMostId;

    private Long stt;

    public Tbddinhkem2() {
        super();
    }

    public Tbddinhkem2(Long fiIdDinhkem, String fiMaLoai, String fiTenLoai, String fiSoVb, Date fiNgayCap, String fiTenTep, Long fiIdHoso, Date fiNgaytao, Long fiHoatdong, String fiDuongDan, String fiGuiId, String fiNguoitao, String fiMaLoaiTaiLieu, String fiTenLoaiTaiLieu, Long fiFileSize, Long fiMostId, Long stt) {
        this.fiIdDinhkem = fiIdDinhkem;
        this.fiMaLoai = fiMaLoai;
        this.fiTenLoai = fiTenLoai;
        this.fiSoVb = fiSoVb;
        this.fiNgayCap = fiNgayCap;
        this.fiTenTep = fiTenTep;
        this.fiIdHoso = fiIdHoso;
        this.fiNgaytao = fiNgaytao;
        this.fiHoatdong = fiHoatdong;
        this.fiDuongDan = fiDuongDan;
        this.fiGuiId = fiGuiId;
        this.fiNguoitao = fiNguoitao;
        this.fiMaLoaiTaiLieu = fiMaLoaiTaiLieu;
        this.fiTenLoaiTaiLieu = fiTenLoaiTaiLieu;
        this.fiFileSize = fiFileSize;
        this.fiMostId = fiMostId;
        this.stt = stt;
    }

    public void setFiIdDinhkem(Long fiIdDinhkem) {
        this.fiIdDinhkem = fiIdDinhkem;
    }

    public Long getFiIdDinhkem() {
        return this.fiIdDinhkem;
    }

    //--- DATABASE MAPPING : FI_MA_LOAI ( VARCHAR2 ) 
    public void setFiMaLoai(String fiMaLoai) {
        this.fiMaLoai = fiMaLoai;
    }

    public String getFiMaLoai() {
        return this.fiMaLoai;
    }

    //--- DATABASE MAPPING : FI_TEN_LOAI ( VARCHAR2 ) 
    public void setFiTenLoai(String fiTenLoai) {
        this.fiTenLoai = fiTenLoai;
    }

    public String getFiTenLoai() {
        return this.fiTenLoai;
    }

    //--- DATABASE MAPPING : FI_SO_VB ( VARCHAR2 ) 
    public void setFiSoVb(String fiSoVb) {
        this.fiSoVb = fiSoVb;
    }

    public String getFiSoVb() {
        return this.fiSoVb;
    }

    //--- DATABASE MAPPING : FI_NGAY_CAP ( DATE ) 
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiNgayCap(Date fiNgayCap) {
        this.fiNgayCap = fiNgayCap;
    }

    public Date getFiNgayCap() {
        return this.fiNgayCap;
    }

    //--- DATABASE MAPPING : FI_TEN_TEP ( VARCHAR2 ) 
    public void setFiTenTep(String fiTenTep) {
        this.fiTenTep = fiTenTep;
    }

    public String getFiTenTep() {
        return this.fiTenTep;
    }

    //--- DATABASE MAPPING : FI_ID_HOSO ( NUMBER ) 
    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    //--- DATABASE MAPPING : FI_NGAYTAO ( TIMESTAMP(6) ) 
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaytao() {
        return this.fiNgaytao;
    }

    //--- DATABASE MAPPING : FI_HOATDONG ( NUMBER ) 
    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    //--- DATABASE MAPPING : FI_DUONG_DAN ( VARCHAR2 ) 
    public void setFiDuongDan(String fiDuongDan) {
        this.fiDuongDan = fiDuongDan;
    }

    public String getFiDuongDan() {
        return this.fiDuongDan;
    }

    //--- DATABASE MAPPING : FI_GUI_ID ( VARCHAR2 ) 
    public void setFiGuiId(String fiGuiId) {
        this.fiGuiId = fiGuiId;
    }

    public String getFiGuiId() {
        return this.fiGuiId;
    }

    //--- DATABASE MAPPING : FI_NGUOITAO ( VARCHAR2 ) 
    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public String getFiNguoitao() {
        return this.fiNguoitao;
    }

    //--- DATABASE MAPPING : FI_MA_LOAI_TAI_LIEU ( VARCHAR2 ) 
    public void setFiMaLoaiTaiLieu(String fiMaLoaiTaiLieu) {
        this.fiMaLoaiTaiLieu = fiMaLoaiTaiLieu;
    }

    public String getFiMaLoaiTaiLieu() {
        return this.fiMaLoaiTaiLieu;
    }

    //--- DATABASE MAPPING : FI_TEN_LOAI_TAI_LIEU ( VARCHAR2 ) 
    public void setFiTenLoaiTaiLieu(String fiTenLoaiTaiLieu) {
        this.fiTenLoaiTaiLieu = fiTenLoaiTaiLieu;
    }

    public String getFiTenLoaiTaiLieu() {
        return this.fiTenLoaiTaiLieu;
    }

    //--- DATABASE MAPPING : FI_FILE_SIZE ( NUMBER ) 
    public void setFiFileSize(Long fiFileSize) {
        this.fiFileSize = fiFileSize;
    }

    public Long getFiFileSize() {
        return this.fiFileSize;
    }

    public Long getFiMostId() {
        return fiMostId;
    }

    public void setFiMostId(Long fiMostId) {
        this.fiMostId = fiMostId;
    }

    public Long getStt() {
        return stt;
    }

    public void setStt(Long stt) {
        this.stt = stt;
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
//        sb.append(id);
        sb.append("]:");
        sb.append(fiIdDinhkem);
        sb.append("|");
        sb.append(fiMaLoai);
        sb.append("|");
        sb.append(fiTenLoai);
        sb.append("|");
        sb.append(fiSoVb);
        sb.append("|");
        sb.append(fiNgayCap);
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
        sb.append(fiMaLoaiTaiLieu);
        sb.append("|");
        sb.append(fiTenLoaiTaiLieu);
        sb.append("|");
        sb.append(fiFileSize);
        return sb.toString();
    }

}
