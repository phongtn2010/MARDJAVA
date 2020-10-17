/*
 * Created on 18 Jul 2017 ( Time 08:44:47 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.vnsw.ws.p10.entity.db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Tbdhanghoa15a implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long fiIdHanghoa;
    private Long fiStt;
    private String fiTenHh;
    private String fiTuoi;
    private BigDecimal fiTinhbiet;
    private BigDecimal fiSoluong;
    private String fiDvSl;
    private String fiTenSl;
    private String fiMucdich;
    private Long fiIdMau15a;
    private Long fiHoatdong;
    private Date fiNgaytao;
    private Date fiNgayCn;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbdhanghoa15a() {
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

    //--- DATABASE MAPPING : FI_TUOI ( VARCHAR2 ) 
    public void setFiTuoi(String fiTuoi) {
        this.fiTuoi = fiTuoi;
    }

    public String getFiTuoi() {
        return this.fiTuoi;
    }

    //--- DATABASE MAPPING : FI_TINHBIET ( NUMBER ) 
    public void setFiTinhbiet(BigDecimal fiTinhbiet) {
        this.fiTinhbiet = fiTinhbiet;
    }

    public BigDecimal getFiTinhbiet() {
        return this.fiTinhbiet;
    }

    //--- DATABASE MAPPING : FI_SOLUONG ( NUMBER ) 
    public void setFiSoluong(BigDecimal fiSoluong) {
        this.fiSoluong = fiSoluong;
    }

    public BigDecimal getFiSoluong() {
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

    //--- DATABASE MAPPING : FI_ID_MAU15A ( NUMBER ) 
    public void setFiIdMau15a(Long fiIdMau15a) {
        this.fiIdMau15a = fiIdMau15a;
    }

    public Long getFiIdMau15a() {
        return this.fiIdMau15a;
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
        sb.append(fiStt);
        sb.append("|");
        sb.append(fiTenHh);
        sb.append("|");
        sb.append(fiTuoi);
        sb.append("|");
        sb.append(fiTinhbiet);
        sb.append("|");
        sb.append(fiSoluong);
        sb.append("|");
        sb.append(fiDvSl);
        sb.append("|");
        sb.append(fiTenSl);
        sb.append("|");
        sb.append(fiMucdich);
        sb.append("|");
        sb.append(fiIdMau15a);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNgayCn);
        return sb.toString();
    }

}
