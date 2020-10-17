package com.nsw.monre.p07.model;

import java.io.Serializable;

import java.util.Date;


public class TbdvanbanCt7 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdVanban   ;


    private Long fiIdHoso     ;

    private String     fiMaHoso     ;

    private String     fiTenCqCap   ;

    private String     fiSoVanban   ;

    private Date       fiNgayKy     ;

    private String     fiNguoiKy    ;

    private Long fiHoatdong   ;

    private String     fiNguoitao   ;

    private Date       fiNgaytao    ;

    private Date       fiNgCapnhat  ;

    private Tbddinhkem7 dinhkem;

    public TbdvanbanCt7() {
		super();
    }
    
    public void setFiIdVanban( Long fiIdVanban ) {
        this.fiIdVanban = fiIdVanban ;
    }
    public Long getFiIdVanban() {
        return this.fiIdVanban;
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

    public void setFiTenCqCap( String fiTenCqCap ) {
        this.fiTenCqCap = fiTenCqCap;
    }
    public String getFiTenCqCap() {
        return this.fiTenCqCap;
    }

    public void setFiSoVanban( String fiSoVanban ) {
        this.fiSoVanban = fiSoVanban;
    }
    public String getFiSoVanban() {
        return this.fiSoVanban;
    }

    public void setFiNgayKy( Date fiNgayKy ) {
        this.fiNgayKy = fiNgayKy;
    }
    public Date getFiNgayKy() {
        return this.fiNgayKy;
    }

    public void setFiNguoiKy( String fiNguoiKy ) {
        this.fiNguoiKy = fiNguoiKy;
    }
    public String getFiNguoiKy() {
        return this.fiNguoiKy;
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

    public Tbddinhkem7 getDinhkem() {
        return dinhkem;
    }

    public void setDinhkem(Tbddinhkem7 dinhkem) {
        this.dinhkem = dinhkem;
    }


    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(fiIdVanban);
        sb.append("]:"); 
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiTenCqCap);
        sb.append("|");
        sb.append(fiSoVanban);
        sb.append("|");
        sb.append(fiNgayKy);
        sb.append("|");
        sb.append(fiNguoiKy);
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
