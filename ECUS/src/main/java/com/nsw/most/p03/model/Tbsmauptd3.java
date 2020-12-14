package com.nsw.most.p03.model;

import java.io.Serializable;

import java.util.Date;

public class Tbsmauptd3 implements Serializable {

    private Long fiId;

    private String fiMa;

    private String fiLinhvuc;

    private String fiTen;

    private Date fiNgaytao;

    private Long fiHoatdong;

    private String fiNguoitao;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbsmauptd3() {
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
    //--- DATABASE MAPPING : FI_MA ( VARCHAR2 ) 
    public void setFiMa(String fiMa) {
        this.fiMa = fiMa;
    }

    public String getFiMa() {
        return this.fiMa;
    }

    //--- DATABASE MAPPING : FI_LINHVUC ( VARCHAR2 ) 
    public void setFiLinhvuc(String fiLinhvuc) {
        this.fiLinhvuc = fiLinhvuc;
    }

    public String getFiLinhvuc() {
        return this.fiLinhvuc;
    }

    //--- DATABASE MAPPING : FI_TEN ( VARCHAR2 ) 
    public void setFiTen(String fiTen) {
        this.fiTen = fiTen;
    }

    public String getFiTen() {
        return this.fiTen;
    }

    //--- DATABASE MAPPING : FI_NGAYTAO ( TIMESTAMP(6) ) 
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaytao() {
        return this.fiNgaytao;
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
        sb.append(fiMa);
        sb.append("|");
        sb.append(fiLinhvuc);
        sb.append("|");
        sb.append(fiTen);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNguoitao);
        return sb.toString();
    }

}
