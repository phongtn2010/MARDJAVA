/*
 * Created on 13 Nov 2018 ( Time 09:46:44 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.moh.p39.model;

import java.io.Serializable;

import java.util.Date;


public class TbdhsDinhkem39 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdDk;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name="FI_ID_HOSO")
    private Long fiIdHoso;

    //@Column(name="FI_LOAI_TEP")
    private Long fiLoaiTep;

    //@Column(name="FI_TEN_LOAI_TEP", length=255)
    private String fiTenLoaiTep;

    //@Column(name="FI_TEN_TEP", length=255)
    private String fiTenTep;

    //@Column(name="FI_DUONG_DAN_TEP", length=2000)
    private String fiDuongDanTep;

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

    //@Column(name="FI_GUIID", length=1000)
    private String fiGuiid;

    //@Column(name="FI_DUONG_DAN", length=1000)
    private String fiDuongDan;

    //@Column(name="FI_NOIDUNG", length=4000)
    private String fiNoidung;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TbdhsDinhkem39() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdDk(Long fiIdDk) {
        this.fiIdDk = fiIdDk;
    }

    public Long getFiIdDk() {
        return this.fiIdDk;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FI_ID_HOSO ( NUMBER ) 
    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    //--- DATABASE MAPPING : FI_LOAI_TEP ( NUMBER ) 
    public void setFiLoaiTep(Long fiLoaiTep) {
        this.fiLoaiTep = fiLoaiTep;
    }

    public Long getFiLoaiTep() {
        return this.fiLoaiTep;
    }

    //--- DATABASE MAPPING : FI_TEN_LOAI_TEP ( VARCHAR2 ) 
    public void setFiTenLoaiTep(String fiTenLoaiTep) {
        this.fiTenLoaiTep = fiTenLoaiTep;
    }

    public String getFiTenLoaiTep() {
        return this.fiTenLoaiTep;
    }

    //--- DATABASE MAPPING : FI_TEN_TEP ( VARCHAR2 ) 
    public void setFiTenTep(String fiTenTep) {
        this.fiTenTep = fiTenTep;
    }

    public String getFiTenTep() {
        return this.fiTenTep;
    }

    //--- DATABASE MAPPING : FI_DUONG_DAN_TEP ( VARCHAR2 ) 
    public void setFiDuongDanTep(String fiDuongDanTep) {
        this.fiDuongDanTep = fiDuongDanTep;
    }

    public String getFiDuongDanTep() {
        return this.fiDuongDanTep;
    }

    //--- DATABASE MAPPING : FI_HOATDONG ( NUMBER ) 
    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    //--- DATABASE MAPPING : FI_NGUOITAO ( VARCHAR2 ) 
    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public String getFiNguoitao() {
        return this.fiNguoitao;
    }

    //--- DATABASE MAPPING : FI_NGAYTAO ( TIMESTAMP(6) ) 
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaytao() {
        return this.fiNgaytao;
    }

    //--- DATABASE MAPPING : FI_NG_CAPNHAT ( TIMESTAMP(6) ) 
    public void setFiNgCapnhat(Date fiNgCapnhat) {
        this.fiNgCapnhat = fiNgCapnhat;
    }

    public Date getFiNgCapnhat() {
        return this.fiNgCapnhat;
    }

    //--- DATABASE MAPPING : FI_GUIID ( VARCHAR2 ) 
    public void setFiGuiid(String fiGuiid) {
        this.fiGuiid = fiGuiid;
    }

    public String getFiGuiid() {
        return this.fiGuiid;
    }

    //--- DATABASE MAPPING : FI_DUONG_DAN ( VARCHAR2 ) 
    public void setFiDuongDan(String fiDuongDan) {
        this.fiDuongDan = fiDuongDan;
    }

    public String getFiDuongDan() {
        return this.fiDuongDan;
    }

    //--- DATABASE MAPPING : FI_NOIDUNG ( VARCHAR2 ) 
    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public String getFiNoidung() {
        return this.fiNoidung;
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
        sb.append(fiIdDk);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiLoaiTep);
        sb.append("|");
        sb.append(fiTenLoaiTep);
        sb.append("|");
        sb.append(fiTenTep);
        sb.append("|");
        sb.append(fiDuongDanTep);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNguoitao);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNgCapnhat);
        sb.append("|");
        sb.append(fiGuiid);
        sb.append("|");
        sb.append(fiDuongDan);
        sb.append("|");
        sb.append(fiNoidung);
        return sb.toString();
    }

}
