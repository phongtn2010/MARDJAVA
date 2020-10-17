package com.nsw.monre.p07.model;

import java.io.Serializable;

import java.util.Date;


public class Tbdycrut7 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdYcrut    ;


    private Long fiIdHoso     ;

    private String     fiMaHoso     ;

    private Date       fiNgayRut    ;

    private String     fiNoidungYc  ;

    private String     fiNoidungPh  ;

    private Date       fiNgayXl     ;

    private String     fiDonviXl    ;

    private Long fiTrthaiCu   ;

    private String     fiTenTtCu    ;

    private Long fiHoatdong   ;

    private String     fiNguoitao   ;

    private Date       fiNgaytao    ;

    private Date       fiNgCapnhat  ;


    public Tbdycrut7() {
		super();
    }
    
    public void setFiIdYcrut( Long fiIdYcrut ) {
        this.fiIdYcrut = fiIdYcrut ;
    }
    public Long getFiIdYcrut() {
        return this.fiIdYcrut;
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

    public void setFiNgayRut( Date fiNgayRut ) {
        this.fiNgayRut = fiNgayRut;
    }
    public Date getFiNgayRut() {
        return this.fiNgayRut;
    }

    public void setFiNoidungYc( String fiNoidungYc ) {
        this.fiNoidungYc = fiNoidungYc;
    }
    public String getFiNoidungYc() {
        return this.fiNoidungYc;
    }

    public void setFiNoidungPh( String fiNoidungPh ) {
        this.fiNoidungPh = fiNoidungPh;
    }
    public String getFiNoidungPh() {
        return this.fiNoidungPh;
    }

    public void setFiNgayXl( Date fiNgayXl ) {
        this.fiNgayXl = fiNgayXl;
    }
    public Date getFiNgayXl() {
        return this.fiNgayXl;
    }

    public void setFiDonviXl( String fiDonviXl ) {
        this.fiDonviXl = fiDonviXl;
    }
    public String getFiDonviXl() {
        return this.fiDonviXl;
    }

    public void setFiTrthaiCu( Long fiTrthaiCu ) {
        this.fiTrthaiCu = fiTrthaiCu;
    }
    public Long getFiTrthaiCu() {
        return this.fiTrthaiCu;
    }

    public void setFiTenTtCu( String fiTenTtCu ) {
        this.fiTenTtCu = fiTenTtCu;
    }
    public String getFiTenTtCu() {
        return this.fiTenTtCu;
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
        sb.append(fiIdYcrut);
        sb.append("]:"); 
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiNgayRut);
        sb.append("|");
        sb.append(fiNoidungYc);
        sb.append("|");
        sb.append(fiNoidungPh);
        sb.append("|");
        sb.append(fiNgayXl);
        sb.append("|");
        sb.append(fiDonviXl);
        sb.append("|");
        sb.append(fiTrthaiCu);
        sb.append("|");
        sb.append(fiTenTtCu);
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
