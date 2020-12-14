/*
 * Created on 11 Mar 2019 ( Time 12:47:30 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.moh.p01.model;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import java.util.Date;

public class TbdhsHanghoa1 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdHanghoa;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name="FI_ID_HOSO")
    private Long fiIdHoso;

    //@Column(name="FI_TEN_CP", length=250)
    private String fiTenCp;

    //@Column(name="FI_HAM_LUONG", length=250)
    private String fiHamLuong;

    //@Column(name="FI_TAC_DUNG_CP", length=500)
    private String fiTacDungCp;

    //@Column(name="FI_DVI_TINH", length=100)
    private String fiDviTinh;

    //@Column(name="FI_SO_LUONG")
    private Double fiSoLuong;

    //@Column(name="FI_TEN_NSX", length=500)
    private String fiTenNsx;

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
    public TbdhsHanghoa1() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdHanghoa(Long fiIdHanghoa) {
        this.fiIdHanghoa = fiIdHanghoa;
    }

    public Long getFiIdHanghoa() {
        return this.fiIdHanghoa;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FI_ID_HOSO ( NUMBER ) 
    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    //--- DATABASE MAPPING : FI_TEN_CP ( VARCHAR2 ) 
    public void setFiTenCp(String fiTenCp) {
        this.fiTenCp = fiTenCp;
    }

    public String getFiTenCp() {
        return this.fiTenCp;
    }

    //--- DATABASE MAPPING : FI_HAM_LUONG ( VARCHAR2 ) 
    public void setFiHamLuong(String fiHamLuong) {
        this.fiHamLuong = fiHamLuong;
    }

    public String getFiHamLuong() {
        return this.fiHamLuong;
    }

    //--- DATABASE MAPPING : FI_TAC_DUNG_CP ( VARCHAR2 ) 
    public void setFiTacDungCp(String fiTacDungCp) {
        this.fiTacDungCp = fiTacDungCp;
    }

    public String getFiTacDungCp() {
        return this.fiTacDungCp;
    }

    //--- DATABASE MAPPING : FI_DVI_TINH ( VARCHAR2 ) 
    public void setFiDviTinh(String fiDviTinh) {
        this.fiDviTinh = fiDviTinh;
    }

    public String getFiDviTinh() {
        return this.fiDviTinh;
    }

    //--- DATABASE MAPPING : FI_SO_LUONG ( NUMBER ) 
    public void setFiSoLuong(Double fiSoLuong) {
        this.fiSoLuong = fiSoLuong;
    }

    public Double getFiSoLuong() {
        return this.fiSoLuong;
    }

    //--- DATABASE MAPPING : FI_TEN_NSX ( VARCHAR2 ) 
    public void setFiTenNsx(String fiTenNsx) {
        this.fiTenNsx = fiTenNsx;
    }

    public String getFiTenNsx() {
        return this.fiTenNsx;
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

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiIdHanghoa);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiTenCp);
        sb.append("|");
        sb.append(fiHamLuong);
        sb.append("|");
        sb.append(fiTacDungCp);
        sb.append("|");
        sb.append(fiDviTinh);
        sb.append("|");
        sb.append(fiSoLuong);
        sb.append("|");
        sb.append(fiTenNsx);
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
