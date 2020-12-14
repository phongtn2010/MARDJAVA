/*
 * Created on 18 Jul 2017 ( Time 08:45:43 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.mard.p10.model;

import java.io.Serializable;
import java.util.Date;

//import javax.persistence.*;

/**
 * Persistent class for entity stored in table "TBDHANGHOA15C"
 *
 * //@author Telosys Tools Generator
 *
 */
//@Entity
//@Table(name = "TBDHANGHOA15C", schema = "MARD")
// Define named queries here
//@NamedQueries({
    //@NamedQuery(name = "Tbdhanghoa15c.countAll", query = "SELECT COUNT(x) FROM Tbdhanghoa15c x")
//})
public class Tbdhanghoa15c implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    //@Id
    //@Column(name = "FI_ID_HANGHOA", nullable = false)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDHANGHOA15C_SEQ")
    //@SequenceGenerator(sequenceName = "TBDHANGHOA15C_SEQ", schema = "MARD", initialValue = 1, allocationSize = 1, name = "TBDHANGHOA15C_SEQ")
    private Long fiIdHanghoa;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name = "FI_STT", nullable = false)
    private Long fiStt;

    //@Column(name = "FI_TEN_HH", nullable = false, length = 250)
    private String fiTenHh;

    //@Column(name = "FI_QUYCACH_DG", nullable = false, length = 255)
    private String fiQuycachDg;

    //@Column(name = "FI_SOLUONG", nullable = false)
    private Long fiSoluong;

    //@Column(name = "FI_DV_SL", nullable = false, length = 18)
    private String fiDvSl;

    //@Column(name = "FI_TEN_SL", nullable = false, length = 255)
    private String fiTenSl;

    //@Column(name = "FI_MUCDICH", length = 500)
    private String fiMucdich;

    //@Column(name = "FI_ID_MAU15C", nullable = false)
    private Long fiIdMau15c;

    //@Column(name = "FI_HOATDONG", nullable = false)
    private Long fiHoatdong;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYTAO", nullable = false)
    private Date fiNgaytao;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAY_CN")
    private Date fiNgayCn;

    //@Column(name = "FI_KHOILUONG")
    private Long fiKhoiluong;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbdhanghoa15c() {
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
    //--- DATABASE MAPPING : FI_STT ( NUMBER ) 
    public void setFiStt(Long fiStt) {
        this.fiStt = fiStt;
    }

    public Long getFiStt() {
        return this.fiStt;
    }

    //--- DATABASE MAPPING : FI_TEN_HH ( VARCHAR2 ) 
    public void setFiTenHh(String fiTenHh) {
        this.fiTenHh = fiTenHh;
    }

    public String getFiTenHh() {
        return this.fiTenHh;
    }

    //--- DATABASE MAPPING : FI_QUYCACH_DG ( VARCHAR2 ) 
    public void setFiQuycachDg(String fiQuycachDg) {
        this.fiQuycachDg = fiQuycachDg;
    }

    public String getFiQuycachDg() {
        return this.fiQuycachDg;
    }

    //--- DATABASE MAPPING : FI_SOLUONG ( NUMBER ) 
    public void setFiSoluong(Long fiSoluong) {
        this.fiSoluong = fiSoluong;
    }

    public Long getFiSoluong() {
        return this.fiSoluong;
    }

    //--- DATABASE MAPPING : FI_DV_SL ( VARCHAR2 ) 
    public void setFiDvSl(String fiDvSl) {
        this.fiDvSl = fiDvSl;
    }

    public String getFiDvSl() {
        return this.fiDvSl;
    }

    //--- DATABASE MAPPING : FI_TEN_SL ( VARCHAR2 ) 
    public void setFiTenSl(String fiTenSl) {
        this.fiTenSl = fiTenSl;
    }

    public String getFiTenSl() {
        return this.fiTenSl;
    }

    //--- DATABASE MAPPING : FI_MUCDICH ( VARCHAR2 ) 
    public void setFiMucdich(String fiMucdich) {
        this.fiMucdich = fiMucdich;
    }

    public String getFiMucdich() {
        return this.fiMucdich;
    }

    //--- DATABASE MAPPING : FI_ID_MAU15C ( NUMBER ) 
    public void setFiIdMau15c(Long fiIdMau15c) {
        this.fiIdMau15c = fiIdMau15c;
    }

    public Long getFiIdMau15c() {
        return this.fiIdMau15c;
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

    //--- DATABASE MAPPING : FI_NGAY_CN ( DATE ) 
    public void setFiNgayCn(Date fiNgayCn) {
        this.fiNgayCn = fiNgayCn;
    }

    public Date getFiNgayCn() {
        return this.fiNgayCn;
    }

    //--- DATABASE MAPPING : FI_KHOILUONG ( NUMBER ) 
    public void setFiKhoiluong(Long fiKhoiluong) {
        this.fiKhoiluong = fiKhoiluong;
    }

    public Long getFiKhoiluong() {
        return this.fiKhoiluong;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    //@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(fiIdHanghoa);
        sb.append("]:");
        sb.append(fiStt);
        sb.append("|");
        sb.append(fiTenHh);
        sb.append("|");
        sb.append(fiQuycachDg);
        sb.append("|");
        sb.append(fiSoluong);
        sb.append("|");
        sb.append(fiDvSl);
        sb.append("|");
        sb.append(fiTenSl);
        sb.append("|");
        sb.append(fiMucdich);
        sb.append("|");
        sb.append(fiIdMau15c);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNgayCn);
        sb.append("|");
        sb.append(fiKhoiluong);
        return sb.toString();
    }

}
