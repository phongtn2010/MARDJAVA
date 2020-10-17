/*
 * Created on 13 Oct 2018 ( Time 11:47:55 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.mard.p12.model;

import java.io.Serializable;

import java.util.Date;

public class TbdcvHanghoa12 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long fiIdHh;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name="FI_ID_CV")
    private Long fiIdCv;

    //@Column(name="FI_TEN_HH", length=250)
    private String fiTenHh;

    //@Column(name="FI_MS_CHUNGNHAN", length=20)
    private String fiMsChungnhan;

    //@Column(name="FI_HANG_SX", length=250)
    private String fiHangSx;

    //@Column(name="FI_NUOC_SX", length=150)
    private String fiNuocSx;

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

    private String fiMucChatluong;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TbdcvHanghoa12() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdHh(Long fiIdHh) {
        this.fiIdHh = fiIdHh;
    }

    public Long getFiIdHh() {
        return this.fiIdHh;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FI_ID_CV ( NUMBER ) 
    public void setFiIdCv(Long fiIdCv) {
        this.fiIdCv = fiIdCv;
    }

    public Long getFiIdCv() {
        return this.fiIdCv;
    }

    //--- DATABASE MAPPING : FI_TEN_HH ( VARCHAR2 ) 
    public void setFiTenHh(String fiTenHh) {
        this.fiTenHh = fiTenHh;
    }

    public String getFiTenHh() {
        return this.fiTenHh;
    }

    //--- DATABASE MAPPING : FI_MS_CHUNGNHAN ( VARCHAR2 ) 
    public void setFiMsChungnhan(String fiMsChungnhan) {
        this.fiMsChungnhan = fiMsChungnhan;
    }

    public String getFiMsChungnhan() {
        return this.fiMsChungnhan;
    }

    //--- DATABASE MAPPING : FI_HANG_SX ( VARCHAR2 ) 
    public void setFiHangSx(String fiHangSx) {
        this.fiHangSx = fiHangSx;
    }

    public String getFiHangSx() {
        return this.fiHangSx;
    }

    //--- DATABASE MAPPING : FI_NUOC_SX ( VARCHAR2 ) 
    public void setFiNuocSx(String fiNuocSx) {
        this.fiNuocSx = fiNuocSx;
    }

    public String getFiNuocSx() {
        return this.fiNuocSx;
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

    public String getFiMucChatluong() {
        return fiMucChatluong;
    }

    public void setFiMucChatluong(String fiMucChatluong) {
        this.fiMucChatluong = fiMucChatluong;
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
        sb.append(fiIdHh);
        sb.append("]:");
        sb.append(fiIdCv);
        sb.append("|");
        sb.append(fiTenHh);
        sb.append("|");
        sb.append(fiMsChungnhan);
        sb.append("|");
        sb.append(fiHangSx);
        sb.append("|");
        sb.append(fiNuocSx);
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
