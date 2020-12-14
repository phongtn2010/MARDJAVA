/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p10.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Persistent class for entity stored in table "TBDYCSUAHS10"
 *
 * @author Telosys Tools Generator
 *
 */
//@Entity
//@Table(name = "TBDYCSUAHS10", schema = "MARD")
//// Define named queries here
//@NamedQueries({
//    @NamedQuery(name = "Tbdycsuahs10.countAll", query = "SELECT COUNT(x) FROM Tbdycsuahs10 x")
//})
public class Tbdycsuahs10 implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
//    @Id
//    //@Column(name = "FI_ID_YC", nullable = false)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDYCSUAHS10_SEQ")
//    @SequenceGenerator(sequenceName = "TBDYCSUAHS10_SEQ", schema = "MARD", initialValue = 1, allocationSize = 1, name = "TBDYCSUAHS10_SEQ")
    private Long fiIdYc;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name = "FI_ID_HOSO", nullable = false)
    private Long fiIdHoso;

    //@Column(name = "FI_MA_HOSO", nullable = false, length = 20)
    private String fiMaHoso;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAY_YC", nullable = false)
    private Date fiNgayYc;

    //@Column(name = "FI_HOATDONG", nullable = false)
    private Long fiHoatdong;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYTAO", nullable = false)
    private Date fiNgaytao;

    //@Column(name = "FI_NGUOITAO", nullable = false, length = 100)
    private String fiNguoitao;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAY_CN")
    private Date fiNgayCn;

    //@Column(name = "FI_NGUOI_CN", length = 100)
    private String fiNguoiCn;

    //@Column(name = "FI_TRANGTHAI", nullable = false)
    private Long fiTrangthai;

    //@Column(name = "FI_LYDO", length = 2000)
    private String fiLydo;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAY_XL")
    private Date fiNgayXl;

    //@Column(name = "FI_DONVI_XL", length = 250)
    private String fiDonviXl;

    //@Column(name = "FI_NGUOI_XL", length = 250)
    private String fiNguoiXl;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbdycsuahs10() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdYc(Long fiIdYc) {
        this.fiIdYc = fiIdYc;
    }

    public Long getFiIdYc() {
        return this.fiIdYc;
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

    //--- DATABASE MAPPING : FI_MA_HOSO ( VARCHAR2 ) 
    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiMaHoso() {
        return this.fiMaHoso;
    }

    //--- DATABASE MAPPING : FI_NGAY_YC ( DATE ) 
    public void setFiNgayYc(Date fiNgayYc) {
        this.fiNgayYc = fiNgayYc;
    }

    public Date getFiNgayYc() {
        return this.fiNgayYc;
    }

    //--- DATABASE MAPPING : FI_HOATDONG ( NUMBER ) 
    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    //--- DATABASE MAPPING : FI_NGAYTAO ( DATE ) 
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaytao() {
        return this.fiNgaytao;
    }

    //--- DATABASE MAPPING : FI_NGUOITAO ( VARCHAR2 ) 
    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public String getFiNguoitao() {
        return this.fiNguoitao;
    }

    //--- DATABASE MAPPING : FI_NGAY_CN ( DATE ) 
    public void setFiNgayCn(Date fiNgayCn) {
        this.fiNgayCn = fiNgayCn;
    }

    public Date getFiNgayCn() {
        return this.fiNgayCn;
    }

    //--- DATABASE MAPPING : FI_NGUOI_CN ( VARCHAR2 ) 
    public void setFiNguoiCn(String fiNguoiCn) {
        this.fiNguoiCn = fiNguoiCn;
    }

    public String getFiNguoiCn() {
        return this.fiNguoiCn;
    }

    //--- DATABASE MAPPING : FI_TRANGTHAI ( NUMBER ) 
    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Long getFiTrangthai() {
        return this.fiTrangthai;
    }

    //--- DATABASE MAPPING : FI_LYDO ( VARCHAR2 ) 
    public void setFiLydo(String fiLydo) {
        this.fiLydo = fiLydo;
    }

    public String getFiLydo() {
        return this.fiLydo;
    }

    //--- DATABASE MAPPING : FI_NGAY_XL ( DATE ) 
    public void setFiNgayXl(Date fiNgayXl) {
        this.fiNgayXl = fiNgayXl;
    }

    public Date getFiNgayXl() {
        return this.fiNgayXl;
    }

    //--- DATABASE MAPPING : FI_DONVI_XL ( VARCHAR2 ) 
    public void setFiDonviXl(String fiDonviXl) {
        this.fiDonviXl = fiDonviXl;
    }

    public String getFiDonviXl() {
        return this.fiDonviXl;
    }

    //--- DATABASE MAPPING : FI_NGUOI_XL ( VARCHAR2 ) 
    public void setFiNguoiXl(String fiNguoiXl) {
        this.fiNguoiXl = fiNguoiXl;
    }

    public String getFiNguoiXl() {
        return this.fiNguoiXl;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(fiIdYc);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiNgayYc);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNguoitao);
        sb.append("|");
        sb.append(fiNgayCn);
        sb.append("|");
        sb.append(fiNguoiCn);
        sb.append("|");
        sb.append(fiTrangthai);
        sb.append("|");
        sb.append(fiLydo);
        sb.append("|");
        sb.append(fiNgayXl);
        sb.append("|");
        sb.append(fiDonviXl);
        sb.append("|");
        sb.append(fiNguoiXl);
        return sb.toString();
    }

}
