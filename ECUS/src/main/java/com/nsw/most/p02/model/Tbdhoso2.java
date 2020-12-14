package com.nsw.most.p02.model;

import java.io.Serializable;
import com.nsw.annotations.*;
import java.util.Date;
import java.util.List;

/**
 * Persistent class for entity stored in table "TBDHOSO2"
 *
 * @author Telosys Tools Generator
 *
 */
public class Tbdhoso2 extends AbstractEntity {


    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Long fiIdHoso;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    private String fiMaCqCap;

    private String fiTenCqCap;

    private String fiMstDn;

    private String fiTenDnNk;

    private String fiDiachiDnNk;

    private String fiDtDnNk;

    private String fiFaxDnNk;

    private String fiNguoiDd;

    private String fiSoDkkt;

    private Date fiNgayGui;

    private String fiDiachiKho;

    private Long fiHoatdong;

    private String fiMaHoso;

    private String fiNguoitao;

    private Date fiNgaytao;

    private String fiLydoSua;

    private List<Tbdtokhaihq2> toKhaiHQs;

    private List<Tbddinhkem2> tepDinhKems;

    private List<Tbdhanghoa2> hangHoas;

    private Long fiTrangthai;

    private String fiTenTT;
    
    private String fiSoTb;

    private Date fiNgaycapTb;
    
    public Tbdhoso2() {
        super();
    }

    public Tbdhoso2(Long fiIdHoso, String fiMaCqCap, String fiTenCqCap, String fiMstDn, String fiTenDnNk, String fiDiachiDnNk, String fiDtDnNk, String fiFaxDnNk, String fiNguoiDd, String fiSoDkkt, Date fiNgayGui, String fiDiachiKho, Long fiHoatdong, String fiMaHoso, String fiNguoitao, Date fiNgaytao, String fiLydoSua, List<Tbdtokhaihq2> toKhaiHQs, List<Tbddinhkem2> tepDinhKems, List<Tbdhanghoa2> hangHoas, Long fiTrangthai, String fiTenTT) {
        this.fiIdHoso = fiIdHoso;
        this.fiMaCqCap = fiMaCqCap;
        this.fiTenCqCap = fiTenCqCap;
        this.fiMstDn = fiMstDn;
        this.fiTenDnNk = fiTenDnNk;
        this.fiDiachiDnNk = fiDiachiDnNk;
        this.fiDtDnNk = fiDtDnNk;
        this.fiFaxDnNk = fiFaxDnNk;
        this.fiNguoiDd = fiNguoiDd;
        this.fiSoDkkt = fiSoDkkt;
        this.fiNgayGui = fiNgayGui;
        this.fiDiachiKho = fiDiachiKho;
        this.fiHoatdong = fiHoatdong;
        this.fiMaHoso = fiMaHoso;
        this.fiNguoitao = fiNguoitao;
        this.fiNgaytao = fiNgaytao;
        this.fiLydoSua = fiLydoSua;
        this.toKhaiHQs = toKhaiHQs;
        this.tepDinhKems = tepDinhKems;
        this.hangHoas = hangHoas;
        this.fiTrangthai = fiTrangthai;
        this.fiTenTT = fiTenTT;
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

    //--- DATABASE MAPPING : FI_MA_CQ_CAP ( VARCHAR2 ) 
    public void setFiMaCqCap(String fiMaCqCap) {
        this.fiMaCqCap = fiMaCqCap;
    }

    public String getFiMaCqCap() {
        return this.fiMaCqCap;
    }

    //--- DATABASE MAPPING : FI_TEN_CQ_CAP ( VARCHAR2 ) 
    public void setFiTenCqCap(String fiTenCqCap) {
        this.fiTenCqCap = fiTenCqCap;
    }

    public String getFiTenCqCap() {
        return this.fiTenCqCap;
    }

    //--- DATABASE MAPPING : FI_MST_DN ( VARCHAR2 ) 
    public void setFiMstDn(String fiMstDn) {
        this.fiMstDn = fiMstDn;
    }

    public String getFiMstDn() {
        return this.fiMstDn;
    }

    //--- DATABASE MAPPING : FI_TEN_DN_NK ( VARCHAR2 ) 
    public void setFiTenDnNk(String fiTenDnNk) {
        this.fiTenDnNk = fiTenDnNk;
    }

    public String getFiTenDnNk() {
        return this.fiTenDnNk;
    }

    //--- DATABASE MAPPING : FI_DIACHI_DN_NK ( VARCHAR2 ) 
    public void setFiDiachiDnNk(String fiDiachiDnNk) {
        this.fiDiachiDnNk = fiDiachiDnNk;
    }

    public String getFiDiachiDnNk() {
        return this.fiDiachiDnNk;
    }

    //--- DATABASE MAPPING : FI_DT_DN_NK ( VARCHAR2 ) 
    public void setFiDtDnNk(String fiDtDnNk) {
        this.fiDtDnNk = fiDtDnNk;
    }

    public String getFiDtDnNk() {
        return this.fiDtDnNk;
    }

    //--- DATABASE MAPPING : FI_FAX_DN_NK ( VARCHAR2 ) 
    public void setFiFaxDnNk(String fiFaxDnNk) {
        this.fiFaxDnNk = fiFaxDnNk;
    }

    public String getFiFaxDnNk() {
        return this.fiFaxDnNk;
    }

    //--- DATABASE MAPPING : FI_NGUOI_DD ( VARCHAR2 ) 
    public void setFiNguoiDd(String fiNguoiDd) {
        this.fiNguoiDd = fiNguoiDd;
    }

    public String getFiNguoiDd() {
        return this.fiNguoiDd;
    }

    //--- DATABASE MAPPING : FI_SO_DKKT ( VARCHAR2 ) 
    public void setFiSoDkkt(String fiSoDkkt) {
        this.fiSoDkkt = fiSoDkkt;
    }

    public String getFiSoDkkt() {
        return this.fiSoDkkt;
    }

    //--- DATABASE MAPPING : FI_NGAY_GUI ( DATE ) 
    public void setFiNgayGui(Date fiNgayGui) {
        this.fiNgayGui = fiNgayGui;
    }

    public Date getFiNgayGui() {
        return this.fiNgayGui;
    }

    //--- DATABASE MAPPING : FI_DIACHI_KHO ( VARCHAR2 ) 
    public void setFiDiachiKho(String fiDiachiKho) {
        this.fiDiachiKho = fiDiachiKho;
    }

    public String getFiDiachiKho() {
        return this.fiDiachiKho;
    }

    //--- DATABASE MAPPING : FI_HOATDONG ( NUMBER ) 
    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    //--- DATABASE MAPPING : FI_MA_HOSO ( VARCHAR2 ) 
    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiMaHoso() {
        return this.fiMaHoso;
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

    //--- DATABASE MAPPING : FI_LYDO_SUA ( VARCHAR2 ) 
    public void setFiLydoSua(String fiLydoSua) {
        this.fiLydoSua = fiLydoSua;
    }

    public String getFiLydoSua() {
        return this.fiLydoSua;
    }

    public List<Tbdtokhaihq2> getToKhaiHQs() {
        return toKhaiHQs;
    }

    public void setToKhaiHQs(List<Tbdtokhaihq2> toKhaiHQs) {
        this.toKhaiHQs = toKhaiHQs;
    }

    public List<Tbddinhkem2> getTepDinhKems() {
        return tepDinhKems;
    }

    public void setTepDinhKems(List<Tbddinhkem2> tepDinhKems) {
        this.tepDinhKems = tepDinhKems;
    }

    public List<Tbdhanghoa2> getHangHoas() {
        return hangHoas;
    }

    public void setHangHoas(List<Tbdhanghoa2> hangHoas) {
        this.hangHoas = hangHoas;
    }

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public String getFiTenTT() {
        return fiTenTT;
    }

    public void setFiTenTT(String fiTenTT) {
        this.fiTenTT = fiTenTT;
    }

    public String getFiSoTb() {
        return fiSoTb;
    }

    public void setFiSoTb(String fiSoTb) {
        this.fiSoTb = fiSoTb;
    }

    public Date getFiNgaycapTb() {
        return fiNgaycapTb;
    }

    public void setFiNgaycapTb(Date fiNgaycapTb) {
        this.fiNgaycapTb = fiNgaycapTb;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiIdHoso);
        sb.append("]:");
        sb.append(fiMaCqCap);
        sb.append("|");
        sb.append(fiTenCqCap);
        sb.append("|");
        sb.append(fiMstDn);
        sb.append("|");
        sb.append(fiTenDnNk);
        sb.append("|");
        sb.append(fiDiachiDnNk);
        sb.append("|");
        sb.append(fiDtDnNk);
        sb.append("|");
        sb.append(fiFaxDnNk);
        sb.append("|");
        sb.append(fiNguoiDd);
        sb.append("|");
        sb.append(fiSoDkkt);
        sb.append("|");
        sb.append(fiNgayGui);
        sb.append("|");
        sb.append(fiDiachiKho);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiNguoitao);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiLydoSua);
        sb.append("|");
        sb.append(fiTrangthai);
        sb.append("|");
        sb.append(fiTenTT);
        return sb.toString();
    }

}
