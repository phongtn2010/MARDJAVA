/*
 * Created on 28 Dec 2018 ( Time 17:30:14 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.moh.p36.model;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import java.util.Date;


/**
 * Persistent class for entity stored in table "TBDHS_DN36"
 *
 * @author Telosys Tools Generator
 *
 */

public class TbdhsDn36 implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Long fiIdDn;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name="FI_ID_HOSO")
    private Long fiIdHoso;

    //@Column(name="FI_MA_HOSO", length=50)
    private String fiMaHoso;

    //@Column(name="FI_MST_DN", length=20)
    private String fiMstDn;

    //@Column(name="FI_TEN_DN", length=255)
    private String fiTenDn;

    //@Column(name="FI_MA_TINH", length=10)
    private String fiMaTinh;

    //@Column(name="FI_TEN_TINH", length=255)
    private String fiTenTinh;

    //@Column(name="FI_DIACHI_DN", length=255)
    private String fiDiachiDn;

    //@Column(name="FI_NGUOI_DD", length=255)
    private String fiNguoiDd;

    //@Column(name="FI_CHUCVU_NG_DD", length=255)
    private String fiChucvuNgDd;

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
    public TbdhsDn36() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdDn(Long fiIdDn) {
        this.fiIdDn = fiIdDn;
    }

    public Long getFiIdDn() {
        return this.fiIdDn;
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

    //--- DATABASE MAPPING : FI_MST_DN ( VARCHAR2 ) 
    public void setFiMstDn(String fiMstDn) {
        this.fiMstDn = fiMstDn;
    }

    public String getFiMstDn() {
        return this.fiMstDn;
    }

    //--- DATABASE MAPPING : FI_TEN_DN ( VARCHAR2 ) 
    public void setFiTenDn(String fiTenDn) {
        this.fiTenDn = fiTenDn;
    }

    public String getFiTenDn() {
        return this.fiTenDn;
    }

    //--- DATABASE MAPPING : FI_MA_TINH ( VARCHAR2 ) 
    public void setFiMaTinh(String fiMaTinh) {
        this.fiMaTinh = fiMaTinh;
    }

    public String getFiMaTinh() {
        return this.fiMaTinh;
    }

    //--- DATABASE MAPPING : FI_TEN_TINH ( VARCHAR2 ) 
    public void setFiTenTinh(String fiTenTinh) {
        this.fiTenTinh = fiTenTinh;
    }

    public String getFiTenTinh() {
        return this.fiTenTinh;
    }

    //--- DATABASE MAPPING : FI_DIACHI_DN ( VARCHAR2 ) 
    public void setFiDiachiDn(String fiDiachiDn) {
        this.fiDiachiDn = fiDiachiDn;
    }

    public String getFiDiachiDn() {
        return this.fiDiachiDn;
    }

    //--- DATABASE MAPPING : FI_NGUOI_DD ( VARCHAR2 ) 
    public void setFiNguoiDd(String fiNguoiDd) {
        this.fiNguoiDd = fiNguoiDd;
    }

    public String getFiNguoiDd() {
        return this.fiNguoiDd;
    }

    //--- DATABASE MAPPING : FI_CHUCVU_NG_DD ( VARCHAR2 ) 
    public void setFiChucvuNgDd(String fiChucvuNgDd) {
        this.fiChucvuNgDd = fiChucvuNgDd;
    }

    public String getFiChucvuNgDd() {
        return this.fiChucvuNgDd;
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
        sb.append(fiIdDn);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiMstDn);
        sb.append("|");
        sb.append(fiTenDn);
        sb.append("|");
        sb.append(fiMaTinh);
        sb.append("|");
        sb.append(fiTenTinh);
        sb.append("|");
        sb.append(fiDiachiDn);
        sb.append("|");
        sb.append(fiNguoiDd);
        sb.append("|");
        sb.append(fiChucvuNgDd);
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
