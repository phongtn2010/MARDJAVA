/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p10.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

//import javax.persistence.*;

/**
 * Persistent class for entity stored in table "TBDHOSO10"
 *
 * @author Telosys Tools Generator
 *
 */
//@Entity
//@Table(name = "TBDHOSO10", schema = "MARD")
//// Define named queries here
//@NamedQueries({
//    @NamedQuery(name = "Tbdhoso10.countAll", query = "SELECT COUNT(x) FROM Tbdhoso10 x")
//})
public class Tbdhoso10 implements Serializable {

//    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
//    @Id
//    //@Column(name = "FI_ID_HOSO", nullable = false)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDHOSO10_SEQ")
//    @SequenceGenerator(sequenceName = "TBDHOSO10_SEQ", schema = "MARD", initialValue = 1, allocationSize = 1, name = "TBDHOSO10_SEQ")
    private Long fiIdHoso;
    
    private String fiTenHanghoa;
    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    //@Column(name = "FI_MA_HOSO", nullable = false, length = 12)
    private String fiMaHoso;

    //@Column(name = "FI_TEN_CTY", nullable = false, length = 250)
    private String fiTenCty;

    //@Column(name = "FI_DIACHI_CTY", nullable = false, length = 500)
    private String fiDiachiCty;

    //@Column(name = "FI_SDT_CTY", length = 50)
    private String fiSdtCty;

    //@Column(name = "FI_FAX_CTY", length = 50)
    private String fiFaxCty;

    //@Column(name = "FI_SDK_CTY", length = 50)
    private String fiSdkCty;

    //@Column(name = "FI_SO_VANDON", nullable = false, length = 35)
    private String fiSoVandon;
    
//    @Column(name = "FI_DONKB")
    private String fiDonkb;

    //@Column(name = "FI_SO_TK", length = 13)
    private String fiSoTk;

    //@Column(name = "FI_TEN_DTXK", nullable = false, length = 250)
    private String fiTenDtxk;

    //@Column(name = "FI_TEN_QGXK", nullable = false, length = 100)
    private String fiTenQgxk;

    //@Column(name = "FI_MA_QGXK", nullable = false, length = 20)
    private String fiMaQgxk;

    //@Column(name = "FI_TEN_CKXK", length = 255)
    private String fiTenCkxk;

    //@Column(name = "FI_MA_CKXK", length = 2)
    private String fiMaCkxk;

    //@Column(name = "FI_TEN_DTNK", nullable = false, length = 250)
    private String fiTenDtnk;

    //@Column(name = "FI_TEN_QGNK", nullable = false, length = 250)
    private String fiTenQgnk;

    //@Column(name = "FI_PTVT", nullable = false, length = 250)
    private String fiPtvt;

    //@Column(name = "FI_TEN_CKNK", nullable = false, length = 255)
    private String fiTenCknk;

    //@Column(name = "FI_MA_CKNK", nullable = false, length = 2)
    private String fiMaCknk;

    //@Column(name = "FI_MUCDICH_SD", nullable = false, length = 500)
    private String fiMucdichSd;

    //@Column(name = "FI_VB_CTKD", length = 250)
    private String fiVbCtkd;

    //@Column(name = "FI_DDKD", nullable = false, length = 250)
    private String fiDdkd;

    //@Column(name = "FI_TGKD", nullable = false, length = 250)
    private String fiTgkd;

    //@Column(name = "FI_DDGS", length = 250)
    private String fiDdgs;

    //@Column(name = "FI_TGGS", length = 250)
    private String fiTggs;

    //@Column(name = "FI_SOBAN_GCN", length = 250)
    private String fiSobanGcn;

    //@Column(name = "FI_NOIKY", nullable = false, length = 250)
    private String fiNoiky;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYKY", nullable = false)
    private Date fiNgayky;

    //@Column(name = "FI_NGUOIKY", nullable = false, length = 250)
    private String fiNguoiky;

    //@Column(name = "FI_TRANGTHAI")
    private Long fiTrangthai;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYTAO")
    private Date fiNgaytao;

    //@Column(name = "FI_NGUOITAO", length = 100)
    private String fiNguoitao;

    //@Column(name = "FI_HOATDONG")
    private Long fiHoatdong;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAY_CN")
    private Date fiNgayCn;

    //@Column(name = "FI_NGUOI_CN", length = 100)
    private String fiNguoiCn;

    //@Column(name = "FI_XN_DDKD", length = 250)
    private String fiXnDdkd;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_XN_TGKD")
    private Date fiXnTgkd;

    //@Column(name = "FI_SO_VAOSO", length = 250)
    private String fiSoVaoso;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_XN_NGAYKY")
    private Date fiXnNgayky;

    //@Column(name = "FI_XN_NGUOIKY", length = 100)
    private String fiXnNguoiky;

    //@Column(name = "FI_XN_NOIKY", length = 100)
    private String fiXnNoiky;

    //@Column(name = "FI_ID_HOSOCHA")
    private Long fiIdHosocha;

    //@Column(name = "FI_LAHOSOTAM")
    private Long fiLahosotam;

    //@Column(name = "FI_EMAIL_CTY", length = 50)
    private String fiEmailCty;

    //@Column(name = "FI_MA_DVKD", length = 50)
    private String fiMaDvkd;

    //@Column(name = "FI_TEN_DVKD", length = 250)
    private String fiTenDvkd;

    //@Column(name = "FI_MA_DVGS", length = 50)
    private String fiMaDvgs;

    //@Column(name = "FI_TEN_DVGS", length = 50)
    private String fiTenDvgs;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //@Transient
    private List<Tbdhanghoa10> lstHanghoa10;

    //@Transient
    private List<Tbddinhkem10> lstDinhkem10;

    //@Transient
    private String fiLydo;

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbdhoso10() {
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

    //--- DATABASE MAPPING : FI_TEN_CTY ( VARCHAR2 ) 
    public void setFiTenCty(String fiTenCty) {
        this.fiTenCty = fiTenCty;
    }

    public String getFiTenCty() {
        return this.fiTenCty;
    }

    //--- DATABASE MAPPING : FI_DIACHI_CTY ( VARCHAR2 ) 
    public void setFiDiachiCty(String fiDiachiCty) {
        this.fiDiachiCty = fiDiachiCty;
    }

    public String getFiDiachiCty() {
        return this.fiDiachiCty;
    }

    //--- DATABASE MAPPING : FI_SDT_CTY ( VARCHAR2 ) 
    public void setFiSdtCty(String fiSdtCty) {
        this.fiSdtCty = fiSdtCty;
    }

    public String getFiSdtCty() {
        return this.fiSdtCty;
    }

    //--- DATABASE MAPPING : FI_FAX_CTY ( VARCHAR2 ) 
    public void setFiFaxCty(String fiFaxCty) {
        this.fiFaxCty = fiFaxCty;
    }

    public String getFiFaxCty() {
        return this.fiFaxCty;
    }

    //--- DATABASE MAPPING : FI_SDK_CTY ( VARCHAR2 ) 
    public void setFiSdkCty(String fiSdkCty) {
        this.fiSdkCty = fiSdkCty;
    }

    public String getFiSdkCty() {
        return this.fiSdkCty;
    }

    //--- DATABASE MAPPING : FI_SO_VANDON ( VARCHAR2 ) 
    public void setFiSoVandon(String fiSoVandon) {
        this.fiSoVandon = fiSoVandon;
    }

    public String getFiSoVandon() {
        return this.fiSoVandon;
    }

    //--- DATABASE MAPPING : FI_SO_TK ( VARCHAR2 ) 
    public void setFiSoTk(String fiSoTk) {
        this.fiSoTk = fiSoTk;
    }

    public String getFiSoTk() {
        return this.fiSoTk;
    }

    //--- DATABASE MAPPING : FI_TEN_DTXK ( VARCHAR2 ) 
    public void setFiTenDtxk(String fiTenDtxk) {
        this.fiTenDtxk = fiTenDtxk;
    }

    public String getFiTenDtxk() {
        return this.fiTenDtxk;
    }

    //--- DATABASE MAPPING : FI_TEN_QGXK ( VARCHAR2 ) 
    public void setFiTenQgxk(String fiTenQgxk) {
        this.fiTenQgxk = fiTenQgxk;
    }

    public String getFiTenQgxk() {
        return this.fiTenQgxk;
    }

    //--- DATABASE MAPPING : FI_MA_QGXK ( VARCHAR2 ) 
    public void setFiMaQgxk(String fiMaQgxk) {
        this.fiMaQgxk = fiMaQgxk;
    }

    public String getFiMaQgxk() {
        return this.fiMaQgxk;
    }

    //--- DATABASE MAPPING : FI_TEN_CKXK ( VARCHAR2 ) 
    public void setFiTenCkxk(String fiTenCkxk) {
        this.fiTenCkxk = fiTenCkxk;
    }

    public String getFiTenCkxk() {
        return this.fiTenCkxk;
    }

    //--- DATABASE MAPPING : FI_MA_CKXK ( VARCHAR2 ) 
    public void setFiMaCkxk(String fiMaCkxk) {
        this.fiMaCkxk = fiMaCkxk;
    }

    public String getFiMaCkxk() {
        return this.fiMaCkxk;
    }

    //--- DATABASE MAPPING : FI_TEN_DTNK ( VARCHAR2 ) 
    public void setFiTenDtnk(String fiTenDtnk) {
        this.fiTenDtnk = fiTenDtnk;
    }

    public String getFiTenDtnk() {
        return this.fiTenDtnk;
    }

    //--- DATABASE MAPPING : FI_TEN_QGNK ( VARCHAR2 ) 
    public void setFiTenQgnk(String fiTenQgnk) {
        this.fiTenQgnk = fiTenQgnk;
    }

    public String getFiTenQgnk() {
        return this.fiTenQgnk;
    }

    //--- DATABASE MAPPING : FI_PTVT ( VARCHAR2 ) 
    public void setFiPtvt(String fiPtvt) {
        this.fiPtvt = fiPtvt;
    }

    public String getFiPtvt() {
        return this.fiPtvt;
    }

    //--- DATABASE MAPPING : FI_TEN_CKNK ( VARCHAR2 ) 
    public void setFiTenCknk(String fiTenCknk) {
        this.fiTenCknk = fiTenCknk;
    }

    public String getFiTenCknk() {
        return this.fiTenCknk;
    }

    //--- DATABASE MAPPING : FI_MA_CKNK ( VARCHAR2 ) 
    public void setFiMaCknk(String fiMaCknk) {
        this.fiMaCknk = fiMaCknk;
    }

    public String getFiMaCknk() {
        return this.fiMaCknk;
    }

    //--- DATABASE MAPPING : FI_MUCDICH_SD ( VARCHAR2 ) 
    public void setFiMucdichSd(String fiMucdichSd) {
        this.fiMucdichSd = fiMucdichSd;
    }

    public String getFiMucdichSd() {
        return this.fiMucdichSd;
    }

    //--- DATABASE MAPPING : FI_VB_CTKD ( VARCHAR2 ) 
    public void setFiVbCtkd(String fiVbCtkd) {
        this.fiVbCtkd = fiVbCtkd;
    }

    public String getFiVbCtkd() {
        return this.fiVbCtkd;
    }

    //--- DATABASE MAPPING : FI_DDKD ( VARCHAR2 ) 
    public void setFiDdkd(String fiDdkd) {
        this.fiDdkd = fiDdkd;
    }

    public String getFiDdkd() {
        return this.fiDdkd;
    }

    //--- DATABASE MAPPING : FI_TGKD ( VARCHAR2 ) 
    public void setFiTgkd(String fiTgkd) {
        this.fiTgkd = fiTgkd;
    }

    public String getFiTgkd() {
        return this.fiTgkd;
    }

    //--- DATABASE MAPPING : FI_DDGS ( VARCHAR2 ) 
    public void setFiDdgs(String fiDdgs) {
        this.fiDdgs = fiDdgs;
    }

    public String getFiDdgs() {
        return this.fiDdgs;
    }

    //--- DATABASE MAPPING : FI_TGGS ( VARCHAR2 ) 
    public void setFiTggs(String fiTggs) {
        this.fiTggs = fiTggs;
    }

    public String getFiTggs() {
        return this.fiTggs;
    }

    //--- DATABASE MAPPING : FI_SOBAN_GCN ( VARCHAR2 ) 
    public void setFiSobanGcn(String fiSobanGcn) {
        this.fiSobanGcn = fiSobanGcn;
    }

    public String getFiSobanGcn() {
        return this.fiSobanGcn;
    }

    //--- DATABASE MAPPING : FI_NOIKY ( VARCHAR2 ) 
    public void setFiNoiky(String fiNoiky) {
        this.fiNoiky = fiNoiky;
    }

    public String getFiNoiky() {
        return this.fiNoiky;
    }

    //--- DATABASE MAPPING : FI_NGAYKY ( DATE ) 
    public void setFiNgayky(Date fiNgayky) {
        this.fiNgayky = fiNgayky;
    }

    public Date getFiNgayky() {
        return this.fiNgayky;
    }

    //--- DATABASE MAPPING : FI_NGUOIKY ( VARCHAR2 ) 
    public void setFiNguoiky(String fiNguoiky) {
        this.fiNguoiky = fiNguoiky;
    }

    public String getFiNguoiky() {
        return this.fiNguoiky;
    }

    //--- DATABASE MAPPING : FI_TRANGTHAI ( NUMBER ) 
    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Long getFiTrangthai() {
        return this.fiTrangthai;
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

    //--- DATABASE MAPPING : FI_HOATDONG ( NUMBER ) 
    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiHoatdong() {
        return this.fiHoatdong;
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

    //--- DATABASE MAPPING : FI_XN_DDKD ( VARCHAR2 ) 
    public void setFiXnDdkd(String fiXnDdkd) {
        this.fiXnDdkd = fiXnDdkd;
    }

    public String getFiXnDdkd() {
        return this.fiXnDdkd;
    }

    //--- DATABASE MAPPING : FI_XN_TGKD ( DATE ) 
    public void setFiXnTgkd(Date fiXnTgkd) {
        this.fiXnTgkd = fiXnTgkd;
    }

    public Date getFiXnTgkd() {
        return this.fiXnTgkd;
    }

    //--- DATABASE MAPPING : FI_SO_VAOSO ( VARCHAR2 ) 
    public void setFiSoVaoso(String fiSoVaoso) {
        this.fiSoVaoso = fiSoVaoso;
    }

    public String getFiSoVaoso() {
        return this.fiSoVaoso;
    }

    //--- DATABASE MAPPING : FI_XN_NGAYKY ( DATE ) 
    public void setFiXnNgayky(Date fiXnNgayky) {
        this.fiXnNgayky = fiXnNgayky;
    }

    public Date getFiXnNgayky() {
        return this.fiXnNgayky;
    }

    //--- DATABASE MAPPING : FI_XN_NGUOIKY ( VARCHAR2 ) 
    public void setFiXnNguoiky(String fiXnNguoiky) {
        this.fiXnNguoiky = fiXnNguoiky;
    }

    public String getFiXnNguoiky() {
        return this.fiXnNguoiky;
    }

    //--- DATABASE MAPPING : FI_XN_NOIKY ( VARCHAR2 ) 
    public void setFiXnNoiky(String fiXnNoiky) {
        this.fiXnNoiky = fiXnNoiky;
    }

    public String getFiXnNoiky() {
        return this.fiXnNoiky;
    }

    //--- DATABASE MAPPING : FI_ID_HOSOCHA ( NUMBER ) 
    public void setFiIdHosocha(Long fiIdHosocha) {
        this.fiIdHosocha = fiIdHosocha;
    }

    public Long getFiIdHosocha() {
        return this.fiIdHosocha;
    }

    //--- DATABASE MAPPING : FI_LAHOSOTAM ( NUMBER ) 
    public void setFiLahosotam(Long fiLahosotam) {
        this.fiLahosotam = fiLahosotam;
    }

    public Long getFiLahosotam() {
        return this.fiLahosotam;
    }

    //--- DATABASE MAPPING : FI_EMAIL_CTY ( VARCHAR2 ) 
    public void setFiEmailCty(String fiEmailCty) {
        this.fiEmailCty = fiEmailCty;
    }

    public String getFiEmailCty() {
        return this.fiEmailCty;
    }

    public String getFiMaDvkd() {
        return fiMaDvkd;
    }

    public void setFiMaDvkd(String fiMaDvkd) {
        this.fiMaDvkd = fiMaDvkd;
    }

    public String getFiTenDvkd() {
        return fiTenDvkd;
    }

    public void setFiTenDvkd(String fiTenDvkd) {
        this.fiTenDvkd = fiTenDvkd;
    }

    public String getFiMaDvgs() {
        return fiMaDvgs;
    }

    public void setFiMaDvgs(String fiMaDvgs) {
        this.fiMaDvgs = fiMaDvgs;
    }

    public String getFiTenDvgs() {
        return fiTenDvgs;
    }

    public void setFiTenDvgs(String fiTenDvgs) {
        this.fiTenDvgs = fiTenDvgs;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public List<Tbdhanghoa10> getLstHanghoa10() {
        return lstHanghoa10;
    }

    public void setLstHanghoa10(List<Tbdhanghoa10> lstHanghoa10) {
        this.lstHanghoa10 = lstHanghoa10;
    }

    public List<Tbddinhkem10> getLstDinhkem10() {
        return lstDinhkem10;
    }

    public void setLstDinhkem10(List<Tbddinhkem10> lstDinhkem10) {
        this.lstDinhkem10 = lstDinhkem10;
    }

    public String getFiLydo() {
        return fiLydo;
    }

    public void setFiLydo(String fiLydo) {
        this.fiLydo = fiLydo;
    }

    public String getFiTenHanghoa() {
        return fiTenHanghoa;
    }

    public void setFiTenHanghoa(String fiTenHanghoa) {
        this.fiTenHanghoa = fiTenHanghoa;
    }
//    @Transient
    private Tbdmau14a tbdmau14a;
//    @Transient
    private Tbdmau14b tbdmau14b;
//    @Transient
    private Tbdmau15a tbdmau15a;
//    @Transient
    private Tbdmau15b tbdmau15b;
//    @Transient
    private Tbdmau15c tbdmau15c;
    
//    @Transient
    private List<Tbdlichsu10> lstLichsu10;

    public List<Tbdlichsu10> getLstLichsu10() {
        return lstLichsu10;
    }

    public void setLstLichsu10(List<Tbdlichsu10> lstLichsu10) {
        this.lstLichsu10 = lstLichsu10;
    }

    public Tbdmau14a getTbdmau14a() {
        return tbdmau14a;
    }

    public Tbdmau14b getTbdmau14b() {
        return tbdmau14b;
    }

    public Tbdmau15a getTbdmau15a() {
        return tbdmau15a;
    }

    public Tbdmau15b getTbdmau15b() {
        return tbdmau15b;
    }

    public Tbdmau15c getTbdmau15c() {
        return tbdmau15c;
    }

    public void setTbdmau14a(Tbdmau14a Tbdmau14a) {
        this.tbdmau14a = Tbdmau14a;
    }

    public void setTbdmau14b(Tbdmau14b Tbdmau14b) {
        this.tbdmau14b = Tbdmau14b;
    }

    public void setTbdmau15a(Tbdmau15a Tbdmau15a) {
        this.tbdmau15a = Tbdmau15a;
    }

    public void setTbdmau15b(Tbdmau15b Tbdmau15b) {
        this.tbdmau15b = Tbdmau15b;
    }

    public void setTbdmau15c(Tbdmau15c Tbdmau15c) {
        this.tbdmau15c = Tbdmau15c;
    }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("[");
//        sb.append(fiIdHoso);
//        sb.append("]:");
//        sb.append(fiMaHoso);
//        sb.append("|");
//        sb.append(fiTenCty);
//        sb.append("|");
//        sb.append(fiDiachiCty);
//        sb.append("|");
//        sb.append(fiSdtCty);
//        sb.append("|");
//        sb.append(fiFaxCty);
//        sb.append("|");
//        sb.append(fiSdkCty);
//        sb.append("|");
//        sb.append(fiSoVandon);
//        sb.append("|");
//        sb.append(fiSoTk);
//        sb.append("|");
//        sb.append(fiTenDtxk);
//        sb.append("|");
//        sb.append(fiTenQgxk);
//        sb.append("|");
//        sb.append(fiMaQgxk);
//        sb.append("|");
//        sb.append(fiTenCkxk);
//        sb.append("|");
//        sb.append(fiMaCkxk);
//        sb.append("|");
//        sb.append(fiTenDtnk);
//        sb.append("|");
//        sb.append(fiTenQgnk);
//        sb.append("|");
//        sb.append(fiPtvt);
//        sb.append("|");
//        sb.append(fiTenCknk);
//        sb.append("|");
//        sb.append(fiMaCknk);
//        sb.append("|");
//        sb.append(fiMucdichSd);
//        sb.append("|");
//        sb.append(fiVbCtkd);
//        sb.append("|");
//        sb.append(fiDdkd);
//        sb.append("|");
//        sb.append(fiTgkd);
//        sb.append("|");
//        sb.append(fiDdgs);
//        sb.append("|");
//        sb.append(fiTggs);
//        sb.append("|");
//        sb.append(fiSobanGcn);
//        sb.append("|");
//        sb.append(fiNoiky);
//        sb.append("|");
//        sb.append(fiNgayky);
//        sb.append("|");
//        sb.append(fiNguoiky);
//        sb.append("|");
//        sb.append(fiTrangthai);
//        sb.append("|");
//        sb.append(fiNgaytao);
//        sb.append("|");
//        sb.append(fiNguoitao);
//        sb.append("|");
//        sb.append(fiHoatdong);
//        sb.append("|");
//        sb.append(fiNgayCn);
//        sb.append("|");
//        sb.append(fiNguoiCn);
//        sb.append("|");
//        sb.append(fiXnDdkd);
//        sb.append("|");
//        sb.append(fiXnTgkd);
//        sb.append("|");
//        sb.append(fiSoVaoso);
//        sb.append("|");
//        sb.append(fiXnNgayky);
//        sb.append("|");
//        sb.append(fiXnNguoiky);
//        sb.append("|");
//        sb.append(fiXnNoiky);
//        sb.append("|");
//        sb.append(fiIdHosocha);
//        sb.append("|");
//        sb.append(fiLahosotam);
//        sb.append("|");
//        sb.append(fiEmailCty);
//        return sb.toString();
//    }

    public String getFiDonkb() {
        return fiDonkb;
    }

    public void setFiDonkb(String fiDonkb) {
        this.fiDonkb = fiDonkb;
    }

}
