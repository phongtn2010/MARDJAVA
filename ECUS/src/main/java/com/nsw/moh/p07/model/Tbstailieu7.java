/*
 * Created on 20 Feb 2019 ( Time 14:36:48 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.moh.p07.model;

import java.io.Serializable;

import java.util.Date;

public class Tbstailieu7 implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Long fiIdTailieu;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name="FI_MA_TAILIEU", length=50)
    private String fiMaTailieu;

    //@Column(name="FI_TEN_TAILIEU", length=2000)
    private String fiTenTailieu;

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

    //@Column(name="FI_BAT_BUOC")
    private Long fiBatBuoc;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbstailieu7() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdTailieu(Long fiIdTailieu) {
        this.fiIdTailieu = fiIdTailieu;
    }

    public Long getFiIdTailieu() {
        return this.fiIdTailieu;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FI_MA_TAILIEU ( VARCHAR2 ) 
    public void setFiMaTailieu(String fiMaTailieu) {
        this.fiMaTailieu = fiMaTailieu;
    }

    public String getFiMaTailieu() {
        return this.fiMaTailieu;
    }

    //--- DATABASE MAPPING : FI_TEN_TAILIEU ( VARCHAR2 ) 
    public void setFiTenTailieu(String fiTenTailieu) {
        this.fiTenTailieu = fiTenTailieu;
    }

    public String getFiTenTailieu() {
        return this.fiTenTailieu;
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

    //--- DATABASE MAPPING : FI_BAT_BUOC ( NUMBER ) 
    public void setFiBatBuoc(Long fiBatBuoc) {
        this.fiBatBuoc = fiBatBuoc;
    }

    public Long getFiBatBuoc() {
        return this.fiBatBuoc;
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
        sb.append(fiIdTailieu);
        sb.append("]:");
        sb.append(fiMaTailieu);
        sb.append("|");
        sb.append(fiTenTailieu);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNguoitao);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNgCapnhat);
        sb.append("|");
        sb.append(fiBatBuoc);
        return sb.toString();
    }

}
