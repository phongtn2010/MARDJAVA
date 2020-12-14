package com.nsw.most.p02.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nsw.annotations.*;
import com.nsw.util.CustomJsonDateDeserializer;
import java.io.Serializable;

import java.util.Date;

public class Tbdlichsu2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdLichsu;

    private Long fiIdCqkt;

    private String fiMaNggui;

    private String fiTenNggui;

    private String fiMaDvgui;

    private String fiTenDvgui;

    private String fiMaNgnhan;

    private String fiTenNgnhan;

    private String fiMaDvnhan;

    private String fiTenDvnhan;

    private String fiNoidung;

    private Date fiThoihan;

    private Date fiNgaytao;

    private Long fiTrangthai;

    private String fiTenTt;

    private Long fiIdHoso;
    
    private String fiFilePath;
    
    private String fiFileCode;
    
    private String fiFileName;
    
    private String     fiMaHoso;
    
    public Tbdlichsu2() {
        super();
    }

    public Tbdlichsu2(Long fiIdLichsu, Long fiIdCqkt, String fiMaNggui, String fiTenNggui, String fiMaDvgui, String fiTenDvgui, String fiMaNgnhan, String fiTenNgnhan, String fiMaDvnhan, String fiTenDvnhan, String fiNoidung, Date fiThoihan, Date fiNgaytao, Long fiTrangthai, String fiTenTt, Long fiIdHoso, String fiFilePath, String fiFileCode, String fiFileName,String fiMaHoso ) {
        this.fiIdLichsu = fiIdLichsu;
        this.fiIdCqkt = fiIdCqkt;
        this.fiMaNggui = fiMaNggui;
        this.fiTenNggui = fiTenNggui;
        this.fiMaDvgui = fiMaDvgui;
        this.fiTenDvgui = fiTenDvgui;
        this.fiMaNgnhan = fiMaNgnhan;
        this.fiTenNgnhan = fiTenNgnhan;
        this.fiMaDvnhan = fiMaDvnhan;
        this.fiTenDvnhan = fiTenDvnhan;
        this.fiNoidung = fiNoidung;
        this.fiThoihan = fiThoihan;
        this.fiNgaytao = fiNgaytao;
        this.fiTrangthai = fiTrangthai;
        this.fiTenTt = fiTenTt;
        this.fiIdHoso = fiIdHoso;
        this.fiFilePath = fiFilePath;
        this.fiFileCode = fiFileCode;
        this.fiFileName = fiFileName;
        this.fiMaHoso = fiMaHoso;        
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

    public void setFiIdCqkt(Long fiIdCqkt) {
        this.fiIdCqkt = fiIdCqkt;
    }

    public Long getFiIdCqkt() {
        return this.fiIdCqkt;
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
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
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

    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiFilePath() {
        return fiFilePath;
    }

    public void setFiFilePath(String fiFilePath) {
        this.fiFilePath = fiFilePath;
    }

    public String getFiFileCode() {
        return fiFileCode;
    }

    public void setFiFileCode(String fiFileCode) {
        this.fiFileCode = fiFileCode;
    }

    public String getFiFileName() {
        return fiFileName;
    }

    public void setFiFileName(String fiFileName) {
        this.fiFileName = fiFileName;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }
    
    
    
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiIdLichsu);
        sb.append("]:");
        sb.append(fiIdCqkt);
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
        sb.append("|");
        sb.append(fiTenTt);
        return sb.toString();
    }

}
