/*
 * Created on 13 Oct 2018 ( Time 11:47:58 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.mard.p12.model;

import java.io.Serializable;

import java.util.Date;

public class Tbddinhkem12 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdDk;

    private Long fiIdKqxl;

    //@Column(name="FI_TEN_TEP", length=500)
    private String fiTenTep;

    //@Column(name="FI_DUONGDAN", length=500)
    private String fiDuongdan;

    //@Column(name="FI_GUI_ID", length=500)
    private String fiGuiId;

    //@Column(name="FI_ID_DT")
    private Long fiIdDt;

    //@Column(name="FI_LOAI_DT")
    private Long fiLoaiDt;

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

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbddinhkem12() {
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
    //--- DATABASE MAPPING : FI_ID_KQXL ( NUMBER ) 
    public void setFiIdKqxl(Long fiIdKqxl) {
        this.fiIdKqxl = fiIdKqxl;
    }

    public Long getFiIdKqxl() {
        return this.fiIdKqxl;
    }

    //--- DATABASE MAPPING : FI_TEN_TEP ( VARCHAR2 ) 
    public void setFiTenTep(String fiTenTep) {
        this.fiTenTep = fiTenTep;
    }

    public String getFiTenTep() {
        return this.fiTenTep;
    }

    //--- DATABASE MAPPING : FI_DUONGDAN ( VARCHAR2 ) 
    public void setFiDuongdan(String fiDuongdan) {
        this.fiDuongdan = fiDuongdan;
    }

    public String getFiDuongdan() {
        return this.fiDuongdan;
    }

    //--- DATABASE MAPPING : FI_GUI_ID ( VARCHAR2 ) 
    public void setFiGuiId(String fiGuiId) {
        this.fiGuiId = fiGuiId;
    }

    public String getFiGuiId() {
        return this.fiGuiId;
    }

    //--- DATABASE MAPPING : FI_ID_DT ( NUMBER ) 
    public void setFiIdDt(Long fiIdDt) {
        this.fiIdDt = fiIdDt;
    }

    public Long getFiIdDt() {
        return this.fiIdDt;
    }

    //--- DATABASE MAPPING : FI_LOAI_DT ( NUMBER ) 
    public void setFiLoaiDt(Long fiLoaiDt) {
        this.fiLoaiDt = fiLoaiDt;
    }

    public Long getFiLoaiDt() {
        return this.fiLoaiDt;
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
        sb.append(fiIdKqxl);
        sb.append("|");
        sb.append(fiTenTep);
        sb.append("|");
        sb.append(fiDuongdan);
        sb.append("|");
        sb.append(fiGuiId);
        sb.append("|");
        sb.append(fiIdDt);
        sb.append("|");
        sb.append(fiLoaiDt);
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
