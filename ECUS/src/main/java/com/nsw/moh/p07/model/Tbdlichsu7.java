/*
 * Created on 24 Jan 2019 ( Time 01:40:00 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.moh.p07.model;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import java.util.Date;

public class Tbdlichsu7 implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Long fiIdLichsu;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name="FI_ID_HOSO")
    private Long fiIdHoso;

    //@Column(name="FI_MA_HOSO", length=50)
    private String fiMaHoso;

    //@Column(name="FI_TEN_NGGUI", length=250)
    private String fiTenNggui;

    //@Column(name="FI_TEN_DVGUI", length=250)
    private String fiTenDvgui;

    //@Column(name="FI_TEN_NGNHAN", length=250)
    private String fiTenNgnhan;

    //@Column(name="FI_TEN_DVNHAN", length=250)
    private String fiTenDvnhan;

    //@Column(name="FI_NOIDUNG", length=4000)
    private String fiNoidung;

    //@Column(name="FI_DUONG_DAN_CV", length=4000)
    private String fiDuongDanCv;

    //@Column(name="FI_TRANGTHAI")
    private Long fiTrangthai;

    //@Column(name="FI_TEN_TT", length=500)
    private String fiTenTt;

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
    public Tbdlichsu7() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdLichsu(Long fiIdLichsu) {
        this.fiIdLichsu = fiIdLichsu;
    }

    public Long getFiIdLichsu() {
        return this.fiIdLichsu;
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

    //--- DATABASE MAPPING : FI_TEN_NGGUI ( VARCHAR2 ) 
    public void setFiTenNggui(String fiTenNggui) {
        this.fiTenNggui = fiTenNggui;
    }

    public String getFiTenNggui() {
        return this.fiTenNggui;
    }

    //--- DATABASE MAPPING : FI_TEN_DVGUI ( VARCHAR2 ) 
    public void setFiTenDvgui(String fiTenDvgui) {
        this.fiTenDvgui = fiTenDvgui;
    }

    public String getFiTenDvgui() {
        return this.fiTenDvgui;
    }

    //--- DATABASE MAPPING : FI_TEN_NGNHAN ( VARCHAR2 ) 
    public void setFiTenNgnhan(String fiTenNgnhan) {
        this.fiTenNgnhan = fiTenNgnhan;
    }

    public String getFiTenNgnhan() {
        return this.fiTenNgnhan;
    }

    //--- DATABASE MAPPING : FI_TEN_DVNHAN ( VARCHAR2 ) 
    public void setFiTenDvnhan(String fiTenDvnhan) {
        this.fiTenDvnhan = fiTenDvnhan;
    }

    public String getFiTenDvnhan() {
        return this.fiTenDvnhan;
    }

    //--- DATABASE MAPPING : FI_NOIDUNG ( VARCHAR2 ) 
    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public String getFiNoidung() {
        return this.fiNoidung;
    }

    //--- DATABASE MAPPING : FI_DUONG_DAN_CV ( VARCHAR2 ) 
    public void setFiDuongDanCv(String fiDuongDanCv) {
        this.fiDuongDanCv = fiDuongDanCv;
    }

    public String getFiDuongDanCv() {
        return this.fiDuongDanCv;
    }

    //--- DATABASE MAPPING : FI_TRANGTHAI ( NUMBER ) 
    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Long getFiTrangthai() {
        return this.fiTrangthai;
    }

    //--- DATABASE MAPPING : FI_TEN_TT ( VARCHAR2 ) 
    public void setFiTenTt(String fiTenTt) {
        this.fiTenTt = fiTenTt;
    }

    public String getFiTenTt() {
        return this.fiTenTt;
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
        sb.append(fiIdLichsu);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiTenNggui);
        sb.append("|");
        sb.append(fiTenDvgui);
        sb.append("|");
        sb.append(fiTenNgnhan);
        sb.append("|");
        sb.append(fiTenDvnhan);
        sb.append("|");
        sb.append(fiNoidung);
        sb.append("|");
        sb.append(fiDuongDanCv);
        sb.append("|");
        sb.append(fiTrangthai);
        sb.append("|");
        sb.append(fiTenTt);
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