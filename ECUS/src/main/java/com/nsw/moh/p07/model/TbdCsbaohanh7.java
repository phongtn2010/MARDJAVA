/*
 * Created on 7 Mar 2019 ( Time 06:46:35 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.moh.p07.model;

import java.io.Serializable;

import java.util.Date;

public class TbdCsbaohanh7 implements Serializable {

    private Long fiIdCsbh;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name="FI_MST", length=20)
    private String fiMst;

    //@Column(name="FI_TEN_CSBH", length=250)
    private String fiTenCsbh;

    //@Column(name="FI_DIACHI_CSBH", length=250)
    private String fiDiachiCsbh;

    //@Column(name="FI_SDT_CD_CSBH", length=50)
    private String fiSdtCdCsbh;

    //@Column(name="FI_SDT_DD_CSBH", length=50)
    private String fiSdtDdCsbh;

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
    public TbdCsbaohanh7() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdCsbh(Long fiIdCsbh) {
        this.fiIdCsbh = fiIdCsbh;
    }

    public Long getFiIdCsbh() {
        return this.fiIdCsbh;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FI_MST ( VARCHAR2 ) 
    public void setFiMst(String fiMst) {
        this.fiMst = fiMst;
    }

    public String getFiMst() {
        return this.fiMst;
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

    //--- DATABASE MAPPING : FI_SDT_CD_CSBH ( VARCHAR2 ) 
    public void setFiSdtCdCsbh(String fiSdtCdCsbh) {
        this.fiSdtCdCsbh = fiSdtCdCsbh;
    }

    public String getFiSdtCdCsbh() {
        return this.fiSdtCdCsbh;
    }

    //--- DATABASE MAPPING : FI_SDT_DD_CSBH ( VARCHAR2 ) 
    public void setFiSdtDdCsbh(String fiSdtDdCsbh) {
        this.fiSdtDdCsbh = fiSdtDdCsbh;
    }

    public String getFiSdtDdCsbh() {
        return this.fiSdtDdCsbh;
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
        sb.append(fiIdCsbh);
        sb.append("]:");
        sb.append(fiMst);
        sb.append("|");
        sb.append(fiTenCsbh);
        sb.append("|");
        sb.append(fiDiachiCsbh);
        sb.append("|");
        sb.append(fiSdtCdCsbh);
        sb.append("|");
        sb.append(fiSdtDdCsbh);
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