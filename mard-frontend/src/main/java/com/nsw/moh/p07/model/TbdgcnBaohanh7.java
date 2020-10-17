/*
 * Created on 20 Feb 2019 ( Time 14:36:04 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.moh.p07.model;

import java.io.Serializable;

import java.util.Date;

public class TbdgcnBaohanh7 implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Long fiIdGcnBh;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name="FI_ID_GCN")
    private Long fiIdGcn;

    //@Column(name="FI_TEN_CSBH", length=250)
    private String fiTenCsbh;

    //@Column(name="FI_DIACHI_CSBH", length=250)
    private String fiDiachiCsbh;

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
    public TbdgcnBaohanh7() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdGcnBh(Long fiIdGcnBh) {
        this.fiIdGcnBh = fiIdGcnBh;
    }

    public Long getFiIdGcnBh() {
        return this.fiIdGcnBh;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FI_ID_GCN ( NUMBER ) 
    public void setFiIdGcn(Long fiIdGcn) {
        this.fiIdGcn = fiIdGcn;
    }

    public Long getFiIdGcn() {
        return this.fiIdGcn;
    }

    //--- DATABASE MAPPING : FI_TEN_CSBH ( VARCHAR2 ) 
    public void setFiTenCsbh(String fiTenCsbh) {
        this.fiTenCsbh = fiTenCsbh;
    }

    public String getFiTenCsbh() {
        return this.fiTenCsbh;
    }

    //--- DATABASE MAPPING : FI_DIACHI_CSBH ( VARCHAR2 ) 
    public void setFiDiachiCsbh(String fiDiachiCsbh) {
        this.fiDiachiCsbh = fiDiachiCsbh;
    }

    public String getFiDiachiCsbh() {
        return this.fiDiachiCsbh;
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
        sb.append(fiIdGcnBh);
        sb.append("]:");
        sb.append(fiIdGcn);
        sb.append("|");
        sb.append(fiTenCsbh);
        sb.append("|");
        sb.append(fiDiachiCsbh);
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
