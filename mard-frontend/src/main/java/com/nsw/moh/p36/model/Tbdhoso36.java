/*
 * Created on 28 Dec 2018 ( Time 17:29:49 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.moh.p36.model;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import java.util.Date;
import java.util.List;

public class Tbdhoso36 implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Long fiIdHoso;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name="FI_MA_HOSO", length=50)
    private String fiMaHoso;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAYNOP")
    private Date fiNgaynop;

    //@Column(name="FI_LOAI_DON")
    private Long fiLoaiDon;

    //@Column(name="FI_MUC_DICH_NK")
    private Long fiMucDichNk;

    //@Column(name="FI_TEN_DE_TAI", length=255)
    private String fiTenDeTai;

    //@Column(name="FI_SO_QD", length=50)
    private String fiSoQd;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAY_KY_QD")
    private Date fiNgayKyQd;

    //@Column(name="FI_TEN_QD", length=50)
    private String fiTenQd;

    //@Column(name="FI_MA_CUA_KHAU", length=10)
    private String fiMaCuaKhau;

    //@Column(name="FI_TEN_CUA_KHAU", length=255)
    private String fiTenCuaKhau;

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

    //@Column(name="FI_TRANGTHAI")
    private Long fiTrangthai;

    //@Column(name="FI_TEN_TT", length=500)
    private String fiTenTt;

    //@Column(name="FI_SO_CONGVAN", length=255)
    private String fiSoCongvan;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAYCAP_CV")
    private Date fiNgaycapCv;

    //@Transient
    private TbdhsDn36 doanhNghiep;

    //@Transient
    private TbdhsDonhang36 donHang;

    //@Transient
    private List<TbdhsDinhkem36> lstDinhKems;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbdhoso36() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FI_MA_HOSO ( VARCHAR2 ) 
    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiMaHoso() {
        return this.fiMaHoso;
    }

    //--- DATABASE MAPPING : FI_NGAYNOP ( TIMESTAMP(6) ) 
    public void setFiNgaynop(Date fiNgaynop) {
        this.fiNgaynop = fiNgaynop;
    }

    public Date getFiNgaynop() {
        return this.fiNgaynop;
    }

    //--- DATABASE MAPPING : FI_LOAI_DON ( NUMBER ) 
    public void setFiLoaiDon(Long fiLoaiDon) {
        this.fiLoaiDon = fiLoaiDon;
    }

    public Long getFiLoaiDon() {
        return this.fiLoaiDon;
    }

    //--- DATABASE MAPPING : FI_MUC_DICH_NK ( NUMBER ) 
    public void setFiMucDichNk(Long fiMucDichNk) {
        this.fiMucDichNk = fiMucDichNk;
    }

    public Long getFiMucDichNk() {
        return this.fiMucDichNk;
    }

    //--- DATABASE MAPPING : FI_TEN_DE_TAI ( VARCHAR2 ) 
    public void setFiTenDeTai(String fiTenDeTai) {
        this.fiTenDeTai = fiTenDeTai;
    }

    public String getFiTenDeTai() {
        return this.fiTenDeTai;
    }

    //--- DATABASE MAPPING : FI_SO_QD ( VARCHAR2 ) 
    public void setFiSoQd(String fiSoQd) {
        this.fiSoQd = fiSoQd;
    }

    public String getFiSoQd() {
        return this.fiSoQd;
    }

    //--- DATABASE MAPPING : FI_NGAY_KY_QD ( TIMESTAMP(6) ) 
    public void setFiNgayKyQd(Date fiNgayKyQd) {
        this.fiNgayKyQd = fiNgayKyQd;
    }

    public Date getFiNgayKyQd() {
        return this.fiNgayKyQd;
    }

    //--- DATABASE MAPPING : FI_TEN_QD ( VARCHAR2 ) 
    public void setFiTenQd(String fiTenQd) {
        this.fiTenQd = fiTenQd;
    }

    public String getFiTenQd() {
        return this.fiTenQd;
    }

    //--- DATABASE MAPPING : FI_MA_CUA_KHAU ( VARCHAR2 ) 
    public void setFiMaCuaKhau(String fiMaCuaKhau) {
        this.fiMaCuaKhau = fiMaCuaKhau;
    }

    public String getFiMaCuaKhau() {
        return this.fiMaCuaKhau;
    }

    //--- DATABASE MAPPING : FI_TEN_CUA_KHAU ( VARCHAR2 ) 
    public void setFiTenCuaKhau(String fiTenCuaKhau) {
        this.fiTenCuaKhau = fiTenCuaKhau;
    }

    public String getFiTenCuaKhau() {
        return this.fiTenCuaKhau;
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

    //--- DATABASE MAPPING : FI_TRANGTHAI ( NUMBER ) 
    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Long getFiTrangthai() {
        return this.fiTrangthai;
    }

    //--- DATABASE MAPPING : FI_TEN_TT ( VARCHAR2 ) 
    public void setFiTenTt(String fiTenTt) {
        this.fiTenTt = fiTenTt;
    }

    public String getFiTenTt() {
        return this.fiTenTt;
    }

    //--- DATABASE MAPPING : FI_SO_CONGVAN ( VARCHAR2 ) 
    public void setFiSoCongvan(String fiSoCongvan) {
        this.fiSoCongvan = fiSoCongvan;
    }

    public String getFiSoCongvan() {
        return this.fiSoCongvan;
    }

    //--- DATABASE MAPPING : FI_NGAYCAP_CV ( TIMESTAMP(6) ) 
    public void setFiNgaycapCv(Date fiNgaycapCv) {
        this.fiNgaycapCv = fiNgaycapCv;
    }

    public Date getFiNgaycapCv() {
        return this.fiNgaycapCv;
    }

    public TbdhsDn36 getDoanhNghiep() {
        return doanhNghiep;
    }

    public void setDoanhNghiep(TbdhsDn36 doanhNghiep) {
        this.doanhNghiep = doanhNghiep;
    }

    public TbdhsDonhang36 getDonHang() {
        return donHang;
    }

    public void setDonHang(TbdhsDonhang36 donHang) {
        this.donHang = donHang;
    }

    public List<TbdhsDinhkem36> getLstDinhKems() {
        return lstDinhKems;
    }

    public void setLstDinhKems(List<TbdhsDinhkem36> lstDinhKems) {
        this.lstDinhKems = lstDinhKems;
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
        sb.append(fiIdHoso);
        sb.append("]:");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiNgaynop);
        sb.append("|");
        sb.append(fiLoaiDon);
        sb.append("|");
        sb.append(fiMucDichNk);
        sb.append("|");
        sb.append(fiTenDeTai);
        sb.append("|");
        sb.append(fiSoQd);
        sb.append("|");
        sb.append(fiNgayKyQd);
        sb.append("|");
        sb.append(fiTenQd);
        sb.append("|");
        sb.append(fiMaCuaKhau);
        sb.append("|");
        sb.append(fiTenCuaKhau);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNguoitao);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNgCapnhat);
        sb.append("|");
        sb.append(fiTrangthai);
        sb.append("|");
        sb.append(fiTenTt);
        sb.append("|");
        sb.append(fiSoCongvan);
        sb.append("|");
        sb.append(fiNgaycapCv);
        return sb.toString();
    }

}
