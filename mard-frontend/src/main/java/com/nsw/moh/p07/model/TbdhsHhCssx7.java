/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p07.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class TbdhsHhCssx7 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdHhCssx;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name="FI_ID_HH_LOAI")
    private Long fiIdHhLoai;

    //@Column(name="FI_TEN_CSSX", length=250)
    private String fiTenCssx;

    //@Column(name="FI_DIACHI_CSSX", length=250)
    private String fiDiachiCssx;

    //@Column(name="FI_TEN_QG_SX", length=250)
    private String fiTenQgSx;

    //@Column(name="FI_MA_QG_SX", length=2)
    private String fiMaQgSx;

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
    public TbdhsHhCssx7() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdHhCssx(Long fiIdHhCssx) {
        this.fiIdHhCssx = fiIdHhCssx;
    }

    public Long getFiIdHhCssx() {
        return this.fiIdHhCssx;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FI_ID_HH_LOAI ( NUMBER ) 
    public void setFiIdHhLoai(Long fiIdHhLoai) {
        this.fiIdHhLoai = fiIdHhLoai;
    }

    public Long getFiIdHhLoai() {
        return this.fiIdHhLoai;
    }

    //--- DATABASE MAPPING : FI_TEN_CSSX ( VARCHAR2 ) 
    public void setFiTenCssx(String fiTenCssx) {
        this.fiTenCssx = fiTenCssx;
    }

    public String getFiTenCssx() {
        return this.fiTenCssx;
    }

    //--- DATABASE MAPPING : FI_DIACHI_CSSX ( VARCHAR2 ) 
    public void setFiDiachiCssx(String fiDiachiCssx) {
        this.fiDiachiCssx = fiDiachiCssx;
    }

    public String getFiDiachiCssx() {
        return this.fiDiachiCssx;
    }

    //--- DATABASE MAPPING : FI_TEN_QG_SX ( VARCHAR2 ) 
    public void setFiTenQgSx(String fiTenQgSx) {
        this.fiTenQgSx = fiTenQgSx;
    }

    public String getFiTenQgSx() {
        return this.fiTenQgSx;
    }

    //--- DATABASE MAPPING : FI_MA_QG_SX ( VARCHAR2 ) 
    public void setFiMaQgSx(String fiMaQgSx) {
        this.fiMaQgSx = fiMaQgSx;
    }

    public String getFiMaQgSx() {
        return this.fiMaQgSx;
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

}
