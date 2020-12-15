/*
 * Created on 11 Nov 2018 ( Time 15:01:14 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.moh.p39.model;

import java.io.Serializable;

import java.util.Date;


public class Tbscqxl implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Long fiId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    ////@Column(name="FI_MA_CQXL", length=50)
    private String fiMaCqxl;

    ////@Column(name="FI_TEN_CQXL", length=250)
    private String fiTenCqxl;

    ////@Column(name="FI_HOATDONG")
    private Long fiHoatdong;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAYTAO")
    private Date fiNgaytao;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbscqxl() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiId(Long fiId) {
        this.fiId = fiId;
    }

    public Long getFiId() {
        return this.fiId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FI_MA_CQXL ( VARCHAR2 ) 
    public void setFiMaCqxl(String fiMaCqxl) {
        this.fiMaCqxl = fiMaCqxl;
    }

    public String getFiMaCqxl() {
        return this.fiMaCqxl;
    }

    //--- DATABASE MAPPING : FI_TEN_CQXL ( VARCHAR2 ) 
    public void setFiTenCqxl(String fiTenCqxl) {
        this.fiTenCqxl = fiTenCqxl;
    }

    public String getFiTenCqxl() {
        return this.fiTenCqxl;
    }

    //--- DATABASE MAPPING : FI_HOATDONG ( NUMBER ) 
    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    //--- DATABASE MAPPING : FI_NGAYTAO ( TIMESTAMP(6) ) 
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaytao() {
        return this.fiNgaytao;
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
        sb.append(fiId);
        sb.append("]:");
        sb.append(fiMaCqxl);
        sb.append("|");
        sb.append(fiTenCqxl);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNgaytao);
        return sb.toString();
    }

}