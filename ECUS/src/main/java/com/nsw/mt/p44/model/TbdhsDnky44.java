package com.nsw.mt.p44.model;

import java.io.Serializable;
import java.util.Date;

public class TbdhsDnky44 implements Serializable{

    private Long fiIdDnKy     ;


    
    private Long fiIdHoso     ;

    
    private String     fiTenNgKy    ;

    
    private String     fiChucDanh   ;

    
    private String     fiDiaDiem    ;

    
    
    private Date       fiNgayky     ;

    
    private Long fiHoatdong   ;

    
    private String     fiNguoitao   ;

    
    
    private Date       fiNgaytao    ;

    
    
    private Date       fiNgCapnhat  ;



    public TbdhsDnky44() {
		super();
    }
    
    public void setFiIdDnKy( Long fiIdDnKy ) {
        this.fiIdDnKy = fiIdDnKy ;
    }
    public Long getFiIdDnKy() {
        return this.fiIdDnKy;
    }

    public void setFiIdHoso( Long fiIdHoso ) {
        this.fiIdHoso = fiIdHoso;
    }
    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    public void setFiTenNgKy( String fiTenNgKy ) {
        this.fiTenNgKy = fiTenNgKy;
    }
    public String getFiTenNgKy() {
        return this.fiTenNgKy;
    }

    public void setFiChucDanh( String fiChucDanh ) {
        this.fiChucDanh = fiChucDanh;
    }
    public String getFiChucDanh() {
        return this.fiChucDanh;
    }

    public void setFiDiaDiem( String fiDiaDiem ) {
        this.fiDiaDiem = fiDiaDiem;
    }
    public String getFiDiaDiem() {
        return this.fiDiaDiem;
    }

    public void setFiNgayky( Date fiNgayky ) {
        this.fiNgayky = fiNgayky;
    }
    public Date getFiNgayky() {
        return this.fiNgayky;
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
