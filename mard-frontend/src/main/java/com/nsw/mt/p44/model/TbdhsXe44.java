package com.nsw.mt.p44.model;

import java.io.Serializable;
import java.util.Date;

public class TbdhsXe44 implements Serializable{

    private Long fiIdXe       ;


    
    private Long fiIdHoso     ;

    
    private Long fiStt        ;

    
    private String     fiBksXe      ;

    
    private String     fiTenChuxe   ;

    
    private String     fiMaLoaixe   ;

    
    private String     fiTenLoaixe  ;

    
    private String     fiSoGhe      ;

    
    private String     fiNamSx      ;

    
    private String     fiMaCkXn     ;

    
    private String     fiTenCkXn    ;

    
    private String     fiBksXeKoHd  ;

    
    private Long fiHoatdong   ;

    
    private String     fiNguoitao   ;

    
    
    private Date       fiNgaytao    ;

    
    
    private Date       fiNgCapnhat  ;



    public TbdhsXe44() {
		super();
    }
    
    public void setFiIdXe( Long fiIdXe ) {
        this.fiIdXe = fiIdXe ;
    }
    public Long getFiIdXe() {
        return this.fiIdXe;
    }

    public void setFiIdHoso( Long fiIdHoso ) {
        this.fiIdHoso = fiIdHoso;
    }
    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    public void setFiStt( Long fiStt ) {
        this.fiStt = fiStt;
    }
    public Long getFiStt() {
        return this.fiStt;
    }

    public void setFiBksXe( String fiBksXe ) {
        this.fiBksXe = fiBksXe;
    }
    public String getFiBksXe() {
        return this.fiBksXe;
    }

    public void setFiTenChuxe( String fiTenChuxe ) {
        this.fiTenChuxe = fiTenChuxe;
    }
    public String getFiTenChuxe() {
        return this.fiTenChuxe;
    }

    public void setFiMaLoaixe( String fiMaLoaixe ) {
        this.fiMaLoaixe = fiMaLoaixe;
    }
    public String getFiMaLoaixe() {
        return this.fiMaLoaixe;
    }

    public void setFiTenLoaixe( String fiTenLoaixe ) {
        this.fiTenLoaixe = fiTenLoaixe;
    }
    public String getFiTenLoaixe() {
        return this.fiTenLoaixe;
    }

    public void setFiSoGhe( String fiSoGhe ) {
        this.fiSoGhe = fiSoGhe;
    }
    public String getFiSoGhe() {
        return this.fiSoGhe;
    }

    public void setFiNamSx( String fiNamSx ) {
        this.fiNamSx = fiNamSx;
    }
    public String getFiNamSx() {
        return this.fiNamSx;
    }

    public void setFiMaCkXn( String fiMaCkXn ) {
        this.fiMaCkXn = fiMaCkXn;
    }
    public String getFiMaCkXn() {
        return this.fiMaCkXn;
    }

    public void setFiTenCkXn( String fiTenCkXn ) {
        this.fiTenCkXn = fiTenCkXn;
    }
    public String getFiTenCkXn() {
        return this.fiTenCkXn;
    }

    public void setFiBksXeKoHd( String fiBksXeKoHd ) {
        this.fiBksXeKoHd = fiBksXeKoHd;
    }
    public String getFiBksXeKoHd() {
        return this.fiBksXeKoHd;
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

}
