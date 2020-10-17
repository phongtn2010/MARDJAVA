package com.nsw.monre.p07.model;

import java.io.Serializable;


import java.util.Date;



public class Tbdlichsu7 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdLichsu   ;


    private Long fiIdHoso     ;

    private String     fiMaHoso     ;

    private String     fiTenNggui   ;

    private String     fiTenDvgui   ;

    private String     fiTenNgnhan  ;

    private String     fiTenDvnhan  ;

    private Long fiTrangthai  ;

    private String     fiTenTt      ;

    private Long fiHoatdong   ;

    private String     fiNguoitao   ;

    private Date       fiNgaytao    ;

    private Date       fiNgCapnhat  ;

    private String     fiNoidung    ;

    private String     fiLinkCvan   ;

    public Tbdlichsu7() {
		super();
    }
    
    public void setFiIdLichsu( Long fiIdLichsu ) {
        this.fiIdLichsu = fiIdLichsu ;
    }
    public Long getFiIdLichsu() {
        return this.fiIdLichsu;
    }

    public void setFiIdHoso( Long fiIdHoso ) {
        this.fiIdHoso = fiIdHoso;
    }
    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    public void setFiMaHoso( String fiMaHoso ) {
        this.fiMaHoso = fiMaHoso;
    }
    public String getFiMaHoso() {
        return this.fiMaHoso;
    }

    public void setFiTenNggui( String fiTenNggui ) {
        this.fiTenNggui = fiTenNggui;
    }
    public String getFiTenNggui() {
        return this.fiTenNggui;
    }

    public void setFiTenDvgui( String fiTenDvgui ) {
        this.fiTenDvgui = fiTenDvgui;
    }
    public String getFiTenDvgui() {
        return this.fiTenDvgui;
    }

    public void setFiTenNgnhan( String fiTenNgnhan ) {
        this.fiTenNgnhan = fiTenNgnhan;
    }
    public String getFiTenNgnhan() {
        return this.fiTenNgnhan;
    }

    public void setFiTenDvnhan( String fiTenDvnhan ) {
        this.fiTenDvnhan = fiTenDvnhan;
    }
    public String getFiTenDvnhan() {
        return this.fiTenDvnhan;
    }

    public void setFiTrangthai( Long fiTrangthai ) {
        this.fiTrangthai = fiTrangthai;
    }
    public Long getFiTrangthai() {
        return this.fiTrangthai;
    }

    public void setFiTenTt( String fiTenTt ) {
        this.fiTenTt = fiTenTt;
    }
    public String getFiTenTt() {
        return this.fiTenTt;
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

    public void setFiNoidung( String fiNoidung ) {
        this.fiNoidung = fiNoidung;
    }
    public String getFiNoidung() {
        return this.fiNoidung;
    }

    public void setFiLinkCvan( String fiLinkCvan ) {
        this.fiLinkCvan = fiLinkCvan;
    }
    public String getFiLinkCvan() {
        return this.fiLinkCvan;
    }

    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(fiIdLichsu);
        sb.append("]:"); 
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiTenNggui);
        sb.append("|");
        sb.append(fiTenDvgui);
        sb.append("|");
        sb.append(fiTenNgnhan);
        sb.append("|");
        sb.append(fiTenDvnhan);
        sb.append("|");
        sb.append(fiTrangthai);
        sb.append("|");
        sb.append(fiTenTt);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNguoitao);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNgCapnhat);
        sb.append("|");
        sb.append(fiNoidung);
        sb.append("|");
        sb.append(fiLinkCvan);
        return sb.toString(); 
    } 

}
