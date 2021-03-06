package com.nsw.mard.p10.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Created on 5 May 2017 ( Time 10:32:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

import java.io.Serializable;
import java.util.Date;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;


/**
 * Persistent class for entity stored in table "TBDLICHSU1"
 *
 * @author Telosys Tools Generator
 *
 */
//@Entity
//@Table(name = "TBDLICHSU10", schema = "MARD")
//// Define named queries here
//@NamedQueries({
//    @NamedQuery(name = "Tbdlichsu10.countAll", query = "SELECT COUNT(x) FROM Tbdlichsu10 x")
//})
public class Tbdlichsu10 implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
//    @Id
//@Column(name = "FI_ID_LICHSU", nullable = false)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDLICHSU10_SEQ")
//    @SequenceGenerator(sequenceName = "TBDLICHSU10_SEQ", schema = "MARD", initialValue = 1, allocationSize = 1, name = "TBDLICHSU10_SEQ")
    private Long fiIdLichsu;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
//@Column(name = "FI_ID_CQXL")
    private Long fiIdCqxl;

//@Column(name = "FI_MA_NGGUI", length = 50)
    private String fiMaNggui;

//@Column(name = "FI_TEN_NGGUI", length = 255)
    private String fiTenNggui;

//@Column(name = "FI_MA_DVGUI", length = 50)
    private String fiMaDvgui;

//@Column(name = "FI_TEN_DVGUI", length = 255)
    private String fiTenDvgui;

    //@Column(name = "FI_MA_NGNHAN", length = 50)
    private String fiMaNgnhan;

//@Column(name = "FI_TEN_NGNHAN", length = 255)
    private String fiTenNgnhan;

    //@Column(name = "FI_MA_DVNHAN", length = 50)
    private String fiMaDvnhan;

    //@Column(name = "FI_TEN_DVNHAN", length = 255)
    private String fiTenDvnhan;

    //@Column(name = "FI_NOIDUNG", length = 2000)
    private String fiNoidung;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_THOIHAN")
    private Date fiThoihan;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYTAO")
    private Date fiNgaytao;

    //@Column(name = "FI_TRANGTHAI")
    private Long fiTrangthai;

    //@Column(name = "FI_TEN_TT")
    private String fiTenTt;
    
    //@Column(name = "FI_ID_HOSO")
    private Long fiIdHoso;

    //@Column(name = "FI_MA_HOSO", length = 12)
    private String fiMaHoso;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbdlichsu10() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdLichsu(Long fiIdLichsu) {
        this.fiIdLichsu = fiIdLichsu;
    }

    public Long getFiIdLichsu() {
        return this.fiIdLichsu;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FI_ID_CQXL ( NUMBER ) 
    public void setFiIdCqxl(Long fiIdCqxl) {
        this.fiIdCqxl = fiIdCqxl;
    }

    public Long getFiIdCqxl() {
        return this.fiIdCqxl;
    }

    //--- DATABASE MAPPING : FI_MA_NGGUI ( VARCHAR2 ) 
    public void setFiMaNggui(String fiMaNggui) {
        this.fiMaNggui = fiMaNggui;
    }

    public String getFiMaNggui() {
        return this.fiMaNggui;
    }

    //--- DATABASE MAPPING : FI_TEN_NGGUI ( VARCHAR2 ) 
    public void setFiTenNggui(String fiTenNggui) {
        this.fiTenNggui = fiTenNggui;
    }

    public String getFiTenNggui() {
        return this.fiTenNggui;
    }

    //--- DATABASE MAPPING : FI_MA_DVGUI ( VARCHAR2 ) 
    public void setFiMaDvgui(String fiMaDvgui) {
        this.fiMaDvgui = fiMaDvgui;
    }

    public String getFiMaDvgui() {
        return this.fiMaDvgui;
    }

    //--- DATABASE MAPPING : FI_TEN_DVGUI ( VARCHAR2 ) 
    public void setFiTenDvgui(String fiTenDvgui) {
        this.fiTenDvgui = fiTenDvgui;
    }

    public String getFiTenDvgui() {
        return this.fiTenDvgui;
    }

    //--- DATABASE MAPPING : FI_MA_NGNHAN ( VARCHAR2 ) 
    public void setFiMaNgnhan(String fiMaNgnhan) {
        this.fiMaNgnhan = fiMaNgnhan;
    }

    public String getFiMaNgnhan() {
        return this.fiMaNgnhan;
    }

    //--- DATABASE MAPPING : FI_TEN_NGNHAN ( VARCHAR2 ) 
    public void setFiTenNgnhan(String fiTenNgnhan) {
        this.fiTenNgnhan = fiTenNgnhan;
    }

    public String getFiTenNgnhan() {
        return this.fiTenNgnhan;
    }

    //--- DATABASE MAPPING : FI_MA_DVNHAN ( VARCHAR2 ) 
    public void setFiMaDvnhan(String fiMaDvnhan) {
        this.fiMaDvnhan = fiMaDvnhan;
    }

    public String getFiMaDvnhan() {
        return this.fiMaDvnhan;
    }

    //--- DATABASE MAPPING : FI_TEN_DVNHAN ( VARCHAR2 ) 
    public void setFiTenDvnhan(String fiTenDvnhan) {
        this.fiTenDvnhan = fiTenDvnhan;
    }

    public String getFiTenDvnhan() {
        return this.fiTenDvnhan;
    }

    //--- DATABASE MAPPING : FI_NOIDUNG ( VARCHAR2 ) 
    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public String getFiNoidung() {
        return this.fiNoidung;
    }

    //--- DATABASE MAPPING : FI_THOIHAN ( DATE ) 
    public void setFiThoihan(Date fiThoihan) {
        this.fiThoihan = fiThoihan;
    }

    public Date getFiThoihan() {
        return this.fiThoihan;
    }

    //--- DATABASE MAPPING : FI_NGAYTAO ( DATE ) 
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaytao() {
        return this.fiNgaytao;
    }

//    //--- DATABASE MAPPING : FI_TRANGTHAI ( NUMBER ) 
//    public void setFiTrangthai(  Long  fiTrangthai ) {
//    	
//        this.fiTrangthai = fiTrangthai;
//    }
    public Long getFiTrangthai() {
        return this.fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        if (fiTrangthai != null) {
            /*
            if (Constants01.DOCUMENT_STATUS.TAO_MOI.equals(fiTrangthai)) {
                this.setFiTenTt(Constants01.DOCUMENT_STATUS.TAO_MOI_STR);
            } else if (Constants01.DOCUMENT_STATUS.CHO_TIEP_NHAN.equals(fiTrangthai)) {
                this.setFiTenTt(Constants01.DOCUMENT_STATUS.CHO_TIEP_NHAN_STR);
            } else if (Constants01.DOCUMENT_STATUS.DA_TIEP_NHAN.equals(fiTrangthai)) {
                this.setFiTenTt(Constants01.DOCUMENT_STATUS.DA_TIEP_NHAN_STR);
            } else if (Constants01.DOCUMENT_STATUS.TC_TIEP_NHAN.equals(fiTrangthai)) {
                this.setFiTenTt(Constants01.DOCUMENT_STATUS.TC_TIEP_NHAN_STR);
            } else if (Constants01.DOCUMENT_STATUS.DA_RUT.equals(fiTrangthai)) {
                this.setFiTenTt(Constants01.DOCUMENT_STATUS.DA_RUT_STR);
            } else if (Constants01.DOCUMENT_STATUS.YC_BO_SUNG.equals(fiTrangthai)) {
                this.setFiTenTt(Constants01.DOCUMENT_STATUS.YC_BO_SUNG_STR);
            } else if (Constants01.DOCUMENT_STATUS.DA_BO_SUNG.equals(fiTrangthai)) {
                this.setFiTenTt(Constants01.DOCUMENT_STATUS.DA_BO_SUNG_STR);
            } else if (Constants01.DOCUMENT_STATUS.YC_RUT.equals(fiTrangthai)) {
                this.setFiTenTt(Constants01.DOCUMENT_STATUS.YC_RUT_STR);
            } else if (Constants01.DOCUMENT_STATUS.DONGY_YC_RUT.equals(fiTrangthai)) {
                this.setFiTenTt(Constants01.DOCUMENT_STATUS.DONGY_YC_RUT_STR);
            } else if (Constants01.DOCUMENT_STATUS.XIN_SUA.equals(fiTrangthai)) {
                this.setFiTenTt(Constants01.DOCUMENT_STATUS.XIN_SUA_STR);
            } else if (Constants01.DOCUMENT_STATUS.DONGY_XIN_SUA.equals(fiTrangthai)) {
                this.setFiTenTt(Constants01.DOCUMENT_STATUS.DONGY_XIN_SUA_STR);
            } else if (Constants01.DOCUMENT_STATUS.YC_LUIHAN.equals(fiTrangthai)) {
                this.setFiTenTt(Constants01.DOCUMENT_STATUS.YC_LUIHAN_STR);
            } else if (Constants01.DOCUMENT_STATUS.DONGY_YC_LUIHAN.equals(fiTrangthai)) {
                this.setFiTenTt(Constants01.DOCUMENT_STATUS.DONGY_YC_LUIHAN_STR);
            } else if (Constants01.DOCUMENT_STATUS.DACO_KQ_KIEMTRA.equals(fiTrangthai)) {
                this.setFiTenTt(Constants01.DOCUMENT_STATUS.DACO_KQ_KIEMTRA_STR);
            } else if (Constants01.DOCUMENT_STATUS.DATHUHOI_KQ_KIEMTRA.equals(fiTrangthai)) {
                this.setFiTenTt(Constants01.DOCUMENT_STATUS.DATHUHOI_KQ_KIEMTRA_STR);
            } else if (Constants01.DOCUMENT_STATUS.DACO_KQ_DANHGIA.equals(fiTrangthai)) {
                this.setFiTenTt(Constants01.DOCUMENT_STATUS.DACO_KQ_DANHGIA_STR);
            } else if (Constants01.DOCUMENT_STATUS.DATHUOI_KQ_DANHGIA.equals(fiTrangthai)) {
                this.setFiTenTt(Constants01.DOCUMENT_STATUS.DATHUHOI_KQ_DANHGIA_STR);
            }
            */
        }
        this.fiTrangthai = fiTrangthai;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public String getFiTenTt() {
        return fiTenTt;
    }

    public void setFiTenTt(String fiTenTt) {
        this.fiTenTt = fiTenTt;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }
    
    

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiIdLichsu);
        sb.append("]:");
        sb.append(fiIdCqxl);
        sb.append("|");
        sb.append(fiMaNggui);
        sb.append("|");
        sb.append(fiTenNggui);
        sb.append("|");
        sb.append(fiMaDvgui);
        sb.append("|");
        sb.append(fiTenDvgui);
        sb.append("|");
        sb.append(fiMaNgnhan);
        sb.append("|");
        sb.append(fiTenNgnhan);
        sb.append("|");
        sb.append(fiMaDvnhan);
        sb.append("|");
        sb.append(fiTenDvnhan);
        sb.append("|");
        sb.append(fiNoidung);
        sb.append("|");
        sb.append(fiThoihan);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiTrangthai);
        return sb.toString();
    }

}
