    /*
 * Created on 12 Jul 2017 ( Time 16:03:51 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.most.p02.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nsw.util.CustomJsonDateDeserializer;
import java.io.Serializable;
import com.nsw.annotations.*;
import java.util.Date;

/**
 * Persistent class for entity stored in table "TBDHANGHOA2"
 *
 * @author Telosys Tools Generator
 *
 */
public class Tbdhanghoa2 extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private Long fiIdHh;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    private String fiMaHh;
    
    private Long fiMaLoaiHh;      
    
    private String     fiTenLoaiHh       ;

    private String fiTenHh;

    private String fiNhanHh;

    private String fiKyhieu;

    private String fiThongsoKt;

    private String fiMaQg;

    private String fiTenQg;

    private String fiTenNsx;

    private String fiKlSl;

    private String fiMaDv;

    private String fiTenDv;

    private String fiMaCuakhau;

    private String fiTenCuakhau;

    private Date fiNkTu;

    private Date fiNkDen;

    private Long fiIdHoso;

    private Date fiNgaytao;

    private Long fiHoatdong;

    private String fiNguoitao;

    private Long fiIdDinhkem;

    private Long fiIdTk;

    private Long fiKqkiemtra;

    private String fiLydo;

    private String     fiSoTk       ;
    
    
    private String     fiMaHs       ;
    
  
    private Long fiCoGcn;
    
  
    private String fiGhiChu;
    
    private Long stt;

    
    
    public Tbdhanghoa2() {
        super();
    }

    public Tbdhanghoa2(Long fiIdHh, String fiMaHh, Long fiMaLoaiHh, String fiTenLoaiHh, String fiTenHh, String fiNhanHh, String fiKyhieu, String fiThongsoKt, String fiMaQg, String fiTenQg, String fiTenNsx, String fiKlSl, String fiMaDv, String fiTenDv, String fiMaCuakhau, String fiTenCuakhau, Date fiNkTu, Date fiNkDen, Long fiIdHoso, Date fiNgaytao, Long fiHoatdong, String fiNguoitao, Long fiIdDinhkem, Long fiIdTk, Long fiKqkiemtra, String fiLydo, String fiSoTk, String fiMaHs, Long fiCoGcn, String fiGhiChu, Long stt) {
        this.fiIdHh = fiIdHh;
        this.fiMaHh = fiMaHh;
        this.fiMaLoaiHh = fiMaLoaiHh;
        this.fiTenLoaiHh = fiTenLoaiHh;
        this.fiTenHh = fiTenHh;
        this.fiNhanHh = fiNhanHh;
        this.fiKyhieu = fiKyhieu;
        this.fiThongsoKt = fiThongsoKt;
        this.fiMaQg = fiMaQg;
        this.fiTenQg = fiTenQg;
        this.fiTenNsx = fiTenNsx;
        this.fiKlSl = fiKlSl;
        this.fiMaDv = fiMaDv;
        this.fiTenDv = fiTenDv;
        this.fiMaCuakhau = fiMaCuakhau;
        this.fiTenCuakhau = fiTenCuakhau;
        this.fiNkTu = fiNkTu;
        this.fiNkDen = fiNkDen;
        this.fiIdHoso = fiIdHoso;
        this.fiNgaytao = fiNgaytao;
        this.fiHoatdong = fiHoatdong;
        this.fiNguoitao = fiNguoitao;
        this.fiIdDinhkem = fiIdDinhkem;
        this.fiIdTk = fiIdTk;
        this.fiKqkiemtra = fiKqkiemtra;
        this.fiLydo = fiLydo;
        this.fiSoTk = fiSoTk;
        this.fiMaHs = fiMaHs;
        this.fiCoGcn = fiCoGcn;
        this.fiGhiChu = fiGhiChu;
        this.stt = stt;
    }
    
    public void setFiIdHh(Long fiIdHh) {
        this.fiIdHh = fiIdHh;
    }

    public Long getFiIdHh() {
        return this.fiIdHh;
    }

    public void setFiMaHh(String fiMaHh) {
        this.fiMaHh = fiMaHh;
    }

    public String getFiMaHh() {
        return this.fiMaHh;
    }

    public Long getFiMaLoaiHh() {
        return fiMaLoaiHh;
    }

    public void setFiMaLoaiHh(Long fiMaLoaiHh) {
        this.fiMaLoaiHh = fiMaLoaiHh;
    }

    public String getFiTenLoaiHh() {
        return fiTenLoaiHh;
    }

    public void setFiTenLoaiHh(String fiTenLoaiHh) {
        this.fiTenLoaiHh = fiTenLoaiHh;
    }
    
    //--- DATABASE MAPPING : FI_TEN_HH ( VARCHAR2 ) 
    public void setFiTenHh(String fiTenHh) {
        this.fiTenHh = fiTenHh;
    }

    public String getFiTenHh() {
        return this.fiTenHh;
    }

    //--- DATABASE MAPPING : FI_NHAN_HH ( VARCHAR2 ) 
    public void setFiNhanHh(String fiNhanHh) {
        this.fiNhanHh = fiNhanHh;
    }

    public String getFiNhanHh() {
        return this.fiNhanHh;
    }

    //--- DATABASE MAPPING : FI_KYHIEU ( VARCHAR2 ) 
    public void setFiKyhieu(String fiKyhieu) {
        this.fiKyhieu = fiKyhieu;
    }

    public String getFiKyhieu() {
        return this.fiKyhieu;
    }

    //--- DATABASE MAPPING : FI_THONGSO_KT ( VARCHAR2 ) 
    public void setFiThongsoKt(String fiThongsoKt) {
        this.fiThongsoKt = fiThongsoKt;
    }

    public String getFiThongsoKt() {
        return this.fiThongsoKt;
    }

    //--- DATABASE MAPPING : FI_MA_QG ( VARCHAR2 ) 
    public void setFiMaQg(String fiMaQg) {
        this.fiMaQg = fiMaQg;
    }

    public String getFiMaQg() {
        return this.fiMaQg;
    }

    //--- DATABASE MAPPING : FI_TEN_QG ( VARCHAR2 ) 
    public void setFiTenQg(String fiTenQg) {
        this.fiTenQg = fiTenQg;
    }

    public String getFiTenQg() {
        return this.fiTenQg;
    }

    //--- DATABASE MAPPING : FI_TEN_NSX ( VARCHAR2 ) 
    public void setFiTenNsx(String fiTenNsx) {
        this.fiTenNsx = fiTenNsx;
    }

    public String getFiTenNsx() {
        return this.fiTenNsx;
    }

    //--- DATABASE MAPPING : FI_KL_SL ( VARCHAR2 ) 
    public void setFiKlSl(String fiKlSl) {
        this.fiKlSl = fiKlSl;
    }

    public String getFiKlSl() {
        return this.fiKlSl;
    }

    //--- DATABASE MAPPING : FI_MA_DV ( VARCHAR2 ) 
    public void setFiMaDv(String fiMaDv) {
        this.fiMaDv = fiMaDv;
    }

    public String getFiMaDv() {
        return this.fiMaDv;
    }

    //--- DATABASE MAPPING : FI_TEN_DV ( VARCHAR2 ) 
    public void setFiTenDv(String fiTenDv) {
        this.fiTenDv = fiTenDv;
    }

    public String getFiTenDv() {
        return this.fiTenDv;
    }

    //--- DATABASE MAPPING : FI_MA_CUAKHAU ( VARCHAR2 ) 
    public void setFiMaCuakhau(String fiMaCuakhau) {
        this.fiMaCuakhau = fiMaCuakhau;
    }

    public String getFiMaCuakhau() {
        return this.fiMaCuakhau;
    }

    //--- DATABASE MAPPING : FI_TEN_CUAKHAU ( VARCHAR2 ) 
    public void setFiTenCuakhau(String fiTenCuakhau) {
        this.fiTenCuakhau = fiTenCuakhau;
    }

    public String getFiTenCuakhau() {
        return this.fiTenCuakhau;
    }

    //--- DATABASE MAPPING : FI_NK_TU ( DATE ) 
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiNkTu(Date fiNkTu) {
        this.fiNkTu = fiNkTu;
    }

    public Date getFiNkTu() {
        return this.fiNkTu;
    }

    //--- DATABASE MAPPING : FI_NK_DEN ( DATE ) 
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiNkDen(Date fiNkDen) {
        this.fiNkDen = fiNkDen;
    }

    public Date getFiNkDen() {
        return this.fiNkDen;
    }

    //--- DATABASE MAPPING : FI_ID_HOSO ( NUMBER ) 
    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    //--- DATABASE MAPPING : FI_NGAYTAO ( TIMESTAMP(6) ) 
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaytao() {
        return this.fiNgaytao;
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

    //--- DATABASE MAPPING : FI_ID_DINHKEM ( NUMBER ) 
    public void setFiIdDinhkem(Long fiIdDinhkem) {
        this.fiIdDinhkem = fiIdDinhkem;
    }

    public Long getFiIdDinhkem() {
        return this.fiIdDinhkem;
    }

    //--- DATABASE MAPPING : FI_ID_TK ( NUMBER ) 
    public void setFiIdTk(Long fiIdTk) {
        this.fiIdTk = fiIdTk;
    }

    public Long getFiIdTk() {
        return this.fiIdTk;
    }

    //--- DATABASE MAPPING : FI_KQKIEMTRA ( NUMBER ) 
    public void setFiKqkiemtra(Long fiKqkiemtra) {
        this.fiKqkiemtra = fiKqkiemtra;
    }

    public Long getFiKqkiemtra() {
        return this.fiKqkiemtra;
    }

    //--- DATABASE MAPPING : FI_LYDO ( VARCHAR2 ) 
    public void setFiLydo(String fiLydo) {
        this.fiLydo = fiLydo;
    }

    public String getFiLydo() {
        return this.fiLydo;
    }

    public String getFiSoTk() {
        return fiSoTk;
    }

    public void setFiSoTk(String fiSoTk) {
        this.fiSoTk = fiSoTk;
    }
    
    public Long getStt() {
        return stt;
    }

    public String getFiMaHs() {
        return fiMaHs;
    }

    public void setFiMaHs(String fiMaHs) {
        this.fiMaHs = fiMaHs;
    }

    public Long getFiCoGcn() {
        return fiCoGcn;
    }

    public void setFiCoGcn(Long fiCoGcn) {
        this.fiCoGcn = fiCoGcn;
    }

    public String getFiGhiChu() {
        return fiGhiChu;
    }

    public void setFiGhiChu(String fiGhiChu) {
        this.fiGhiChu = fiGhiChu;
    }

    public void setStt(Long stt) {
        this.stt = stt;
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
        sb.append(fiIdHh);
        sb.append("]:");
        sb.append(fiMaHh);
        sb.append("|");
        sb.append(fiTenHh);
        sb.append("|");
        sb.append(fiNhanHh);
        sb.append("|");
        sb.append(fiKyhieu);
        sb.append("|");
        sb.append(fiThongsoKt);
        sb.append("|");
        sb.append(fiMaQg);
        sb.append("|");
        sb.append(fiTenQg);
        sb.append("|");
        sb.append(fiTenNsx);
        sb.append("|");
        sb.append(fiKlSl);
        sb.append("|");
        sb.append(fiMaDv);
        sb.append("|");
        sb.append(fiTenDv);
        sb.append("|");
        sb.append(fiMaCuakhau);
        sb.append("|");
        sb.append(fiTenCuakhau);
        sb.append("|");
        sb.append(fiNkTu);
        sb.append("|");
        sb.append(fiNkDen);
        sb.append("|");
        sb.append(fiIdHoso);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNguoitao);
        sb.append("|");
        sb.append(fiIdDinhkem);
        sb.append("|");
        sb.append(fiIdTk);
        sb.append("|");
        sb.append(fiKqkiemtra);
        sb.append("|");
        sb.append(fiLydo);
        return sb.toString();
    }

}
