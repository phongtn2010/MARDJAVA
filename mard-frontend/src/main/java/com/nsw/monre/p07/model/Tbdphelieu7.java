package com.nsw.monre.p07.model;

import java.io.Serializable;
import java.math.BigDecimal;


import java.util.Date;



public class Tbdphelieu7 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdPl       ;


    private Long fiIdHoso     ;

    private String     fiTenPl      ;

    private String     fiMaHs       ;

    private BigDecimal fiKhoiluong  ;

    private Long fiHoatdong   ;

    private String     fiNguoitao   ;

    private Date       fiNgaytao    ;

    private Date       fiNgCapnhat  ;

    public Tbdphelieu7() {
		super();
    }
    
    public void setFiIdPl( Long fiIdPl ) {
        this.fiIdPl = fiIdPl ;
    }
    public Long getFiIdPl() {
        return this.fiIdPl;
    }

    public void setFiIdHoso( Long fiIdHoso ) {
        this.fiIdHoso = fiIdHoso;
    }
    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    public void setFiTenPl( String fiTenPl ) {
        this.fiTenPl = fiTenPl;
    }
    public String getFiTenPl() {
        return this.fiTenPl;
    }

    public void setFiMaHs( String fiMaHs ) {
        this.fiMaHs = fiMaHs;
    }
    public String getFiMaHs() {
        return this.fiMaHs;
    }

    public void setFiKhoiluong( BigDecimal fiKhoiluong ) {
        this.fiKhoiluong = fiKhoiluong;
    }
    public BigDecimal getFiKhoiluong() {
        return this.fiKhoiluong;
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
        sb.append(fiIdPl);
        sb.append("]:"); 
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiTenPl);
        sb.append("|");
        sb.append(fiMaHs);
        sb.append("|");
        sb.append(fiKhoiluong);
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
