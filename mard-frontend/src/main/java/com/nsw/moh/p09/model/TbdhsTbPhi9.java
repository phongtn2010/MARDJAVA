/*
 * Created on 15 Apr 2019 ( Time 10:11:17 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.moh.p09.model;

import java.io.Serializable;

import java.util.Date;

public class TbdhsTbPhi9 implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Long fiIdTbPhi;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name="FI_ID_HOSO")
    private Long fiIdHoso;

    //@Column(name="FI_MA_TCKT", length=12)
    private String fiMaTckt;

    //@Column(name="FI_TEN_TCKT", length=255)
    private String fiTenTckt;

    //@Column(name="FI_TONG_TIEN")
    private Long fiTongTien;

    //@Column(name="FI_SO_TK")
    private Long fiSoTk;

    //@Column(name="FI_NGAN_HANG", length=250)
    private String fiNganHang;

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
    public TbdhsTbPhi9() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdTbPhi(Long fiIdTbPhi) {
        this.fiIdTbPhi = fiIdTbPhi;
    }

    public Long getFiIdTbPhi() {
        return this.fiIdTbPhi;
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

    //--- DATABASE MAPPING : FI_MA_TCKT ( VARCHAR2 ) 
    public void setFiMaTckt(String fiMaTckt) {
        this.fiMaTckt = fiMaTckt;
    }

    public String getFiMaTckt() {
        return this.fiMaTckt;
    }

    //--- DATABASE MAPPING : FI_TEN_TCKT ( VARCHAR2 ) 
    public void setFiTenTckt(String fiTenTckt) {
        this.fiTenTckt = fiTenTckt;
    }

    public String getFiTenTckt() {
        return this.fiTenTckt;
    }

    //--- DATABASE MAPPING : FI_TONG_TIEN ( NUMBER ) 
    public void setFiTongTien(Long fiTongTien) {
        this.fiTongTien = fiTongTien;
    }

    public Long getFiTongTien() {
        return this.fiTongTien;
    }

    //--- DATABASE MAPPING : FI_SO_TK ( NUMBER ) 
    public void setFiSoTk(Long fiSoTk) {
        this.fiSoTk = fiSoTk;
    }

    public Long getFiSoTk() {
        return this.fiSoTk;
    }

    //--- DATABASE MAPPING : FI_NGAN_HANG ( VARCHAR2 ) 
    public void setFiNganHang(String fiNganHang) {
        this.fiNganHang = fiNganHang;
    }

    public String getFiNganHang() {
        return this.fiNganHang;
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
        sb.append(fiIdTbPhi);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaTckt);
        sb.append("|");
        sb.append(fiTenTckt);
        sb.append("|");
        sb.append(fiTongTien);
        sb.append("|");
        sb.append(fiSoTk);
        sb.append("|");
        sb.append(fiNganHang);
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
