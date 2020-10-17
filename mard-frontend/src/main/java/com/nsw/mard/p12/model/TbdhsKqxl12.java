/*
 * Created on 13 Oct 2018 ( Time 11:48:27 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.mard.p12.model;

import java.io.Serializable;

import java.util.Date;

public class TbdhsKqxl12 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdKqxl;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    private Long fiIdHoso;

    //@Column(name="FI_MA_HOSO", length=50)
    private String fiMaHoso;

    //@Column(name="FI_LYDO", length=2000)
    private String fiLydo;

    private Date fiNgayXl;

    //@Column(name="FI_DONVI_XL", length=250)
    private String fiDonviXl;

    //@Column(name="FI_NGUOI_XL", length=250)
    private String fiNguoiXl;

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

    //@Column(name="FI_TEN_TT", length=500)
    private String fiTenTt;

    //@Column(name="FI_TRANGTHAI")
    private Long fiTrangthai;

    //@Transient
    private Tbddinhkem12 attach;

    private Date fiNgaytraKq;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TbdhsKqxl12() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdKqxl(Long fiIdKqxl) {
        this.fiIdKqxl = fiIdKqxl;
    }

    public Long getFiIdKqxl() {
        return this.fiIdKqxl;
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

    //--- DATABASE MAPPING : FI_MA_HOSO ( VARCHAR2 ) 
    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiMaHoso() {
        return this.fiMaHoso;
    }

    //--- DATABASE MAPPING : FI_LYDO ( VARCHAR2 ) 
    public void setFiLydo(String fiLydo) {
        this.fiLydo = fiLydo;
    }

    public String getFiLydo() {
        return this.fiLydo;
    }

    //--- DATABASE MAPPING : FI_NGAY_XL ( TIMESTAMP(6) ) 
    public void setFiNgayXl(Date fiNgayXl) {
        this.fiNgayXl = fiNgayXl;
    }

    public Date getFiNgayXl() {
        return this.fiNgayXl;
    }

    //--- DATABASE MAPPING : FI_DONVI_XL ( VARCHAR2 ) 
    public void setFiDonviXl(String fiDonviXl) {
        this.fiDonviXl = fiDonviXl;
    }

    public String getFiDonviXl() {
        return this.fiDonviXl;
    }

    //--- DATABASE MAPPING : FI_NGUOI_XL ( VARCHAR2 ) 
    public void setFiNguoiXl(String fiNguoiXl) {
        this.fiNguoiXl = fiNguoiXl;
    }

    public String getFiNguoiXl() {
        return this.fiNguoiXl;
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

    //--- DATABASE MAPPING : FI_TEN_TT ( VARCHAR2 ) 
    public void setFiTenTt(String fiTenTt) {
        this.fiTenTt = fiTenTt;
    }

    public String getFiTenTt() {
        return this.fiTenTt;
    }

    //--- DATABASE MAPPING : FI_TRANGTHAI ( NUMBER ) 
    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Long getFiTrangthai() {
        return this.fiTrangthai;
    }

    public Tbddinhkem12 getAttach() {
        return attach;
    }

    public void setAttach(Tbddinhkem12 attach) {
        this.attach = attach;
    }

    public Date getFiNgaytraKq() {
        return fiNgaytraKq;
    }

    public void setFiNgaytraKq(Date fiNgaytraKq) {
        this.fiNgaytraKq = fiNgaytraKq;
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
        sb.append(fiIdKqxl);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiLydo);
        sb.append("|");
        sb.append(fiNgayXl);
        sb.append("|");
        sb.append(fiDonviXl);
        sb.append("|");
        sb.append(fiNguoiXl);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNguoitao);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNgCapnhat);
        sb.append("|");
        sb.append(fiTenTt);
        sb.append("|");
        sb.append(fiTrangthai);
        return sb.toString();
    }

}
