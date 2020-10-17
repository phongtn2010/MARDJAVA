package com.nsw.monre.p07.model;

import java.io.Serializable;

import java.util.Date;


public class Tbddinhkem7 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdDk       ;


    private Long fiMaloaiTep  ;

    private String     fiTenloaiTep ;

    private String     fiTenTep     ;

    private String     fiIdTep      ;

    private String     fiDuongdan   ;

    private String     fiTenteptin  ;

    private Long fiIdDt       ;

    private Long fiLoaiDt     ;

    private Long fiHoatdong   ;

    private String     fiNguoitao   ;

    private Date       fiNgaytao    ;

    private Date       fiNgCapnhat  ;

    public Tbddinhkem7() {
		super();
    }
    
    public void setFiIdDk( Long fiIdDk ) {
        this.fiIdDk = fiIdDk ;
    }
    public Long getFiIdDk() {
        return this.fiIdDk;
    }

    public void setFiMaloaiTep( Long fiMaloaiTep ) {
        this.fiMaloaiTep = fiMaloaiTep;
    }
    public Long getFiMaloaiTep() {
        return this.fiMaloaiTep;
    }

    public void setFiTenloaiTep( String fiTenloaiTep ) {
        this.fiTenloaiTep = fiTenloaiTep;
    }
    public String getFiTenloaiTep() {
        return this.fiTenloaiTep;
    }

    public void setFiTenTep( String fiTenTep ) {
        this.fiTenTep = fiTenTep;
    }
    public String getFiTenTep() {
        return this.fiTenTep;
    }

    public void setFiIdTep( String fiIdTep ) {
        this.fiIdTep = fiIdTep;
    }
    public String getFiIdTep() {
        return this.fiIdTep;
    }

    public void setFiDuongdan( String fiDuongdan ) {
        this.fiDuongdan = fiDuongdan;
    }
    public String getFiDuongdan() {
        return this.fiDuongdan;
    }

    public void setFiTenteptin( String fiTenteptin ) {
        this.fiTenteptin = fiTenteptin;
    }
    public String getFiTenteptin() {
        return this.fiTenteptin;
    }

    public void setFiIdDt( Long fiIdDt ) {
        this.fiIdDt = fiIdDt;
    }
    public Long getFiIdDt() {
        return this.fiIdDt;
    }

    public void setFiLoaiDt( Long fiLoaiDt ) {
        this.fiLoaiDt = fiLoaiDt;
    }
    public Long getFiLoaiDt() {
        return this.fiLoaiDt;
    }

    public void setFiHoatdong( Long fiHoatdong ) {
        this.fiHoatdong = fiHoatdong;
    }
    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    public void setFiNguoitao( String fiNguoitao ) {
        this.fiNguoitao = fiNguoitao;
    }
    public String getFiNguoitao() {
        return this.fiNguoitao;
    }

    public void setFiNgaytao( Date fiNgaytao ) {
        this.fiNgaytao = fiNgaytao;
    }
    public Date getFiNgaytao() {
        return this.fiNgaytao;
    }

    public void setFiNgCapnhat( Date fiNgCapnhat ) {
        this.fiNgCapnhat = fiNgCapnhat;
    }
    public Date getFiNgCapnhat() {
        return this.fiNgCapnhat;
    }


    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(fiIdDk);
        sb.append("]:"); 
        sb.append(fiMaloaiTep);
        sb.append("|");
        sb.append(fiTenloaiTep);
        sb.append("|");
        sb.append(fiTenTep);
        sb.append("|");
        sb.append(fiIdTep);
        sb.append("|");
        sb.append(fiDuongdan);
        sb.append("|");
        sb.append(fiTenteptin);
        sb.append("|");
        sb.append(fiIdDt);
        sb.append("|");
        sb.append(fiLoaiDt);
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
