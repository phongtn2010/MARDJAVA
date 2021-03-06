/*
 * Created on 18 Jul 2017 ( Time 08:51:08 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.vnsw.ws.p10.entity.db;

import java.io.Serializable;
import java.util.Date;

public class Tbdtbtt10 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long fiIdTb;
    private String fiMaHoso;
    private String fiNdSotien;
    private String fiChuthich;
    private String fiNguoinop;
    private Date fiNgaynop;
    private Long fiHoatdong;
    private Date fiNgaytao;
    private String fiNguoitao;
    private Date fiNgayCn;
    private String fiNguoiCn;
    private Long fiSotienCk;
    private Long fiIdApphi;
    private String fiSohoadon;
    private Long fiIdHoso;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbdtbtt10() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdTb(Long fiIdTb) {
        this.fiIdTb = fiIdTb;
    }

    public Long getFiIdTb() {
        return this.fiIdTb;
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

    //--- DATABASE MAPPING : FI_ND_SOTIEN ( VARCHAR2 ) 
    public void setFiNdSotien(String fiNdSotien) {
        this.fiNdSotien = fiNdSotien;
    }

    public String getFiNdSotien() {
        return this.fiNdSotien;
    }

    //--- DATABASE MAPPING : FI_CHUTHICH ( VARCHAR2 ) 
    public void setFiChuthich(String fiChuthich) {
        this.fiChuthich = fiChuthich;
    }

    public String getFiChuthich() {
        return this.fiChuthich;
    }

    //--- DATABASE MAPPING : FI_NGUOINOP ( VARCHAR2 ) 
    public void setFiNguoinop(String fiNguoinop) {
        this.fiNguoinop = fiNguoinop;
    }

    public String getFiNguoinop() {
        return this.fiNguoinop;
    }

    //--- DATABASE MAPPING : FI_NGAYNOP ( DATE ) 
    public void setFiNgaynop(Date fiNgaynop) {
        this.fiNgaynop = fiNgaynop;
    }

    public Date getFiNgaynop() {
        return this.fiNgaynop;
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

    //--- DATABASE MAPPING : FI_SOTIEN_CK ( NUMBER ) 
    public void setFiSotienCk(Long fiSotienCk) {
        this.fiSotienCk = fiSotienCk;
    }

    public Long getFiSotienCk() {
        return this.fiSotienCk;
    }

    //--- DATABASE MAPPING : FI_ID_APPHI ( NUMBER ) 
    public void setFiIdApphi(Long fiIdApphi) {
        this.fiIdApphi = fiIdApphi;
    }

    public Long getFiIdApphi() {
        return this.fiIdApphi;
    }

    //--- DATABASE MAPPING : FI_SOHOADON ( VARCHAR2 ) 
    public void setFiSohoadon(String fiSohoadon) {
        this.fiSohoadon = fiSohoadon;
    }

    public String getFiSohoadon() {
        return this.fiSohoadon;
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
        sb.append(fiIdTb);
        sb.append("]:");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiNdSotien);
        sb.append("|");
        sb.append(fiChuthich);
        sb.append("|");
        sb.append(fiNguoinop);
        sb.append("|");
        sb.append(fiNgaynop);
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
        sb.append(fiSotienCk);
        sb.append("|");
        sb.append(fiIdApphi);
        sb.append("|");
        sb.append(fiSohoadon);
        return sb.toString();
    }

}
