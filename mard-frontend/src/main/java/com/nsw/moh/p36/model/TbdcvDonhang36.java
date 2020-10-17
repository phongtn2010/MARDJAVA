/*
 * Created on 28 Dec 2018 ( Time 17:29:28 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.moh.p36.model;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import java.util.Date;
import java.util.List;

/**
 * Persistent class for entity stored in table "TBDCV_DONHANG36"
 *
 * @author Telosys Tools Generator
 *
 */
public class TbdcvDonhang36 implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Long fiIdDonhang;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name="FI_ID_CV")
    private Long fiIdCv;

    //@Column(name="FI_MA_HOSO", length=50)
    private String fiMaHoso;

    //@Column(name="FI_TEN_HANG", length=255)
    private String fiTenHang;

    //@Column(name="FI_BAO_CHE", length=255)
    private String fiBaoChe;

    //@Column(name="FI_DONG_GOI", length=255)
    private String fiDongGoi;

    //@Column(name="FI_HOAT_CHAT", length=255)
    private String fiHoatChat;

    //@Column(name="FI_HAM_LUONG", length=255)
    private String fiHamLuong;

    //@Column(name="FI_TEN_KHAC", length=255)
    private String fiTenKhac;

    //@Column(name="FI_BO_PHAN_DUNG", length=255)
    private String fiBoPhanDung;

    //@Column(name="FI_MA_DVTINH", length=5)
    private String fiMaDvtinh;

    //@Column(name="FI_TEN_DVTINH", length=255)
    private String fiTenDvtinh;

    //@Column(name="FI_SO_LUONG")
    private Long fiSoLuong;

    //@Column(name="FI_HAN_DUNG", length=255)
    private String fiHanDung;

    //@Column(name="FI_TCCL", length=255)
    private String fiTccl;

    //@Column(name="FI_CHI_DINH", length=255)
    private String fiChiDinh;

    //@Column(name="FI_MA_QG_SX", length=10)
    private String fiMaQgSx;

    //@Column(name="FI_TEN_QG_SX", length=255)
    private String fiTenQgSx;

    //@Column(name="FI_TEN_CO_SO_SX", length=255)
    private String fiTenCoSoSx;

    //@Column(name="FI_DIACHI_CSSX", length=1000)
    private String fiDiachiCssx;

    //@Column(name="FI_MA_QG_XK", length=10)
    private String fiMaQgXk;

    //@Column(name="FI_TEN_QG_XK", length=255)
    private String fiTenQgXk;

    //@Column(name="FI_TEN_CO_SO_XK", length=255)
    private String fiTenCoSoXk;

    //@Column(name="FI_DIACHI_CS_XK", length=255)
    private String fiDiachiCsXk;

    //@Column(name="FI_TEN_CS_SH", length=255)
    private String fiTenCsSh;

    //@Column(name="FI_MA_QG_SH", length=10)
    private String fiMaQgSh;

    //@Column(name="FI_TEN_QG_SH", length=255)
    private String fiTenQgSh;

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

    //@Column(name="FI_GHICHU", length=3000)
    private String fiGhichu;

    //@Transient
    private List<TbdcvNglieu36> lstNguyenLieus;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TbdcvDonhang36() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiIdDonhang(Long fiIdDonhang) {
        this.fiIdDonhang = fiIdDonhang;
    }

    public Long getFiIdDonhang() {
        return this.fiIdDonhang;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FI_ID_CV ( NUMBER ) 
    public void setFiIdCv(Long fiIdCv) {
        this.fiIdCv = fiIdCv;
    }

    public Long getFiIdCv() {
        return this.fiIdCv;
    }

    //--- DATABASE MAPPING : FI_MA_HOSO ( VARCHAR2 ) 
    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiMaHoso() {
        return this.fiMaHoso;
    }

    //--- DATABASE MAPPING : FI_TEN_HANG ( VARCHAR2 ) 
    public void setFiTenHang(String fiTenHang) {
        this.fiTenHang = fiTenHang;
    }

    public String getFiTenHang() {
        return this.fiTenHang;
    }

    //--- DATABASE MAPPING : FI_BAO_CHE ( VARCHAR2 ) 
    public void setFiBaoChe(String fiBaoChe) {
        this.fiBaoChe = fiBaoChe;
    }

    public String getFiBaoChe() {
        return this.fiBaoChe;
    }

    //--- DATABASE MAPPING : FI_DONG_GOI ( VARCHAR2 ) 
    public void setFiDongGoi(String fiDongGoi) {
        this.fiDongGoi = fiDongGoi;
    }

    public String getFiDongGoi() {
        return this.fiDongGoi;
    }

    //--- DATABASE MAPPING : FI_HOAT_CHAT ( VARCHAR2 ) 
    public void setFiHoatChat(String fiHoatChat) {
        this.fiHoatChat = fiHoatChat;
    }

    public String getFiHoatChat() {
        return this.fiHoatChat;
    }

    //--- DATABASE MAPPING : FI_HAM_LUONG ( VARCHAR2 ) 
    public void setFiHamLuong(String fiHamLuong) {
        this.fiHamLuong = fiHamLuong;
    }

    public String getFiHamLuong() {
        return this.fiHamLuong;
    }

    //--- DATABASE MAPPING : FI_TEN_KHAC ( VARCHAR2 ) 
    public void setFiTenKhac(String fiTenKhac) {
        this.fiTenKhac = fiTenKhac;
    }

    public String getFiTenKhac() {
        return this.fiTenKhac;
    }

    //--- DATABASE MAPPING : FI_BO_PHAN_DUNG ( VARCHAR2 ) 
    public void setFiBoPhanDung(String fiBoPhanDung) {
        this.fiBoPhanDung = fiBoPhanDung;
    }

    public String getFiBoPhanDung() {
        return this.fiBoPhanDung;
    }

    //--- DATABASE MAPPING : FI_MA_DVTINH ( VARCHAR2 ) 
    public void setFiMaDvtinh(String fiMaDvtinh) {
        this.fiMaDvtinh = fiMaDvtinh;
    }

    public String getFiMaDvtinh() {
        return this.fiMaDvtinh;
    }

    //--- DATABASE MAPPING : FI_TEN_DVTINH ( VARCHAR2 ) 
    public void setFiTenDvtinh(String fiTenDvtinh) {
        this.fiTenDvtinh = fiTenDvtinh;
    }

    public String getFiTenDvtinh() {
        return this.fiTenDvtinh;
    }

    //--- DATABASE MAPPING : FI_SO_LUONG ( NUMBER ) 
    public void setFiSoLuong(Long fiSoLuong) {
        this.fiSoLuong = fiSoLuong;
    }

    public Long getFiSoLuong() {
        return this.fiSoLuong;
    }

    //--- DATABASE MAPPING : FI_HAN_DUNG ( VARCHAR2 ) 
    public void setFiHanDung(String fiHanDung) {
        this.fiHanDung = fiHanDung;
    }

    public String getFiHanDung() {
        return this.fiHanDung;
    }

    //--- DATABASE MAPPING : FI_TCCL ( VARCHAR2 ) 
    public void setFiTccl(String fiTccl) {
        this.fiTccl = fiTccl;
    }

    public String getFiTccl() {
        return this.fiTccl;
    }

    //--- DATABASE MAPPING : FI_CHI_DINH ( VARCHAR2 ) 
    public void setFiChiDinh(String fiChiDinh) {
        this.fiChiDinh = fiChiDinh;
    }

    public String getFiChiDinh() {
        return this.fiChiDinh;
    }

    //--- DATABASE MAPPING : FI_MA_QG_SX ( VARCHAR2 ) 
    public void setFiMaQgSx(String fiMaQgSx) {
        this.fiMaQgSx = fiMaQgSx;
    }

    public String getFiMaQgSx() {
        return this.fiMaQgSx;
    }

    //--- DATABASE MAPPING : FI_TEN_QG_SX ( VARCHAR2 ) 
    public void setFiTenQgSx(String fiTenQgSx) {
        this.fiTenQgSx = fiTenQgSx;
    }

    public String getFiTenQgSx() {
        return this.fiTenQgSx;
    }

    //--- DATABASE MAPPING : FI_TEN_CO_SO_SX ( VARCHAR2 ) 
    public void setFiTenCoSoSx(String fiTenCoSoSx) {
        this.fiTenCoSoSx = fiTenCoSoSx;
    }

    public String getFiTenCoSoSx() {
        return this.fiTenCoSoSx;
    }

    //--- DATABASE MAPPING : FI_DIACHI_CSSX ( VARCHAR2 ) 
    public void setFiDiachiCssx(String fiDiachiCssx) {
        this.fiDiachiCssx = fiDiachiCssx;
    }

    public String getFiDiachiCssx() {
        return this.fiDiachiCssx;
    }

    //--- DATABASE MAPPING : FI_MA_QG_XK ( VARCHAR2 ) 
    public void setFiMaQgXk(String fiMaQgXk) {
        this.fiMaQgXk = fiMaQgXk;
    }

    public String getFiMaQgXk() {
        return this.fiMaQgXk;
    }

    //--- DATABASE MAPPING : FI_TEN_QG_XK ( VARCHAR2 ) 
    public void setFiTenQgXk(String fiTenQgXk) {
        this.fiTenQgXk = fiTenQgXk;
    }

    public String getFiTenQgXk() {
        return this.fiTenQgXk;
    }

    //--- DATABASE MAPPING : FI_TEN_CO_SO_XK ( VARCHAR2 ) 
    public void setFiTenCoSoXk(String fiTenCoSoXk) {
        this.fiTenCoSoXk = fiTenCoSoXk;
    }

    public String getFiTenCoSoXk() {
        return this.fiTenCoSoXk;
    }

    //--- DATABASE MAPPING : FI_DIACHI_CS_XK ( VARCHAR2 ) 
    public void setFiDiachiCsXk(String fiDiachiCsXk) {
        this.fiDiachiCsXk = fiDiachiCsXk;
    }

    public String getFiDiachiCsXk() {
        return this.fiDiachiCsXk;
    }

    //--- DATABASE MAPPING : FI_TEN_CS_SH ( VARCHAR2 ) 
    public void setFiTenCsSh(String fiTenCsSh) {
        this.fiTenCsSh = fiTenCsSh;
    }

    public String getFiTenCsSh() {
        return this.fiTenCsSh;
    }

    //--- DATABASE MAPPING : FI_MA_QG_SH ( VARCHAR2 ) 
    public void setFiMaQgSh(String fiMaQgSh) {
        this.fiMaQgSh = fiMaQgSh;
    }

    public String getFiMaQgSh() {
        return this.fiMaQgSh;
    }

    //--- DATABASE MAPPING : FI_TEN_QG_SH ( VARCHAR2 ) 
    public void setFiTenQgSh(String fiTenQgSh) {
        this.fiTenQgSh = fiTenQgSh;
    }

    public String getFiTenQgSh() {
        return this.fiTenQgSh;
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

    //--- DATABASE MAPPING : FI_GHICHU ( VARCHAR2 ) 
    public void setFiGhichu(String fiGhichu) {
        this.fiGhichu = fiGhichu;
    }

    public String getFiGhichu() {
        return this.fiGhichu;
    }

    public List<TbdcvNglieu36> getLstNguyenLieus() {
        return lstNguyenLieus;
    }

    public void setLstNguyenLieus(List<TbdcvNglieu36> lstNguyenLieus) {
        this.lstNguyenLieus = lstNguyenLieus;
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
        sb.append(fiIdDonhang);
        sb.append("]:");
        sb.append(fiIdCv);
        sb.append("|");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiTenHang);
        sb.append("|");
        sb.append(fiBaoChe);
        sb.append("|");
        sb.append(fiDongGoi);
        sb.append("|");
        sb.append(fiHoatChat);
        sb.append("|");
        sb.append(fiHamLuong);
        sb.append("|");
        sb.append(fiTenKhac);
        sb.append("|");
        sb.append(fiBoPhanDung);
        sb.append("|");
        sb.append(fiMaDvtinh);
        sb.append("|");
        sb.append(fiTenDvtinh);
        sb.append("|");
        sb.append(fiSoLuong);
        sb.append("|");
        sb.append(fiHanDung);
        sb.append("|");
        sb.append(fiTccl);
        sb.append("|");
        sb.append(fiChiDinh);
        sb.append("|");
        sb.append(fiMaQgSx);
        sb.append("|");
        sb.append(fiTenQgSx);
        sb.append("|");
        sb.append(fiTenCoSoSx);
        sb.append("|");
        sb.append(fiDiachiCssx);
        sb.append("|");
        sb.append(fiMaQgXk);
        sb.append("|");
        sb.append(fiTenQgXk);
        sb.append("|");
        sb.append(fiTenCoSoXk);
        sb.append("|");
        sb.append(fiDiachiCsXk);
        sb.append("|");
        sb.append(fiTenCsSh);
        sb.append("|");
        sb.append(fiMaQgSh);
        sb.append("|");
        sb.append(fiTenQgSh);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNguoitao);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNgCapnhat);
        sb.append("|");
        sb.append(fiGhichu);
        return sb.toString();
    }

}
