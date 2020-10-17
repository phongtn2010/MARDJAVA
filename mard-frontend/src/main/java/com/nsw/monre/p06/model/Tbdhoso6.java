package com.nsw.monre.p06.model;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

//import javax.persistence.*;
//
//@Entity
//@Table(name="TBDHOSO6", schema="MONRE" )
//@NamedQueries ( {
//  @NamedQuery ( name="Tbdhoso6.countAll", query="SELECT COUNT(x) FROM Tbdhoso6 x" )
//} )
public class Tbdhoso6 implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Id
//    @Column(name="FI_ID_HOSO", nullable=false)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDHOSO6_SEQ")
//    @SequenceGenerator(sequenceName = "TBDHOSO6_SEQ", schema = "MONRE", initialValue = 1, allocationSize = 1, name = "TBDHOSO6_SEQ")
    private Long fiIdHoso;

    //@Column(name="FI_MA_HOSO", length=50)
    private String fiMaHoso;

    //@Column(name="FI_MA_CQ_CAP", length=50)
    private String fiMaCqCap;

    //@Column(name="FI_TEN_CQ_CAP", length=250)
    private String fiTenCqCap;

    //@Column(name="FI_MST_DN", length=13)
    private String fiMstDn;

    //@Column(name="FI_TEN_DN", length=250)
    private String fiTenDn;

    //@Column(name="FI_DIACHI_TSC", length=250)
    private String fiDiachiTsc;

    //@Column(name="FI_NG_DAIDIEN", length=250)
    private String fiNgDaidien;

    //@Column(name="FI_NG_LIENHE", length=250)
    private String fiNgLienhe;

    //@Column(name="FI_CHVU_NG_LH", length=50)
    private String fiChvuNgLh;

    //@Column(name="FI_SDT_NG_LH", length=50)
    private String fiSdtNgLh;

    //@Column(name="FI_FAX_NG_LH", length=50)
    private String fiFaxNgLh;

    //@Column(name="FI_EMAIL_NG_LH", length=50)
    private String fiEmailNgLh;

    //@Column(name="FI_HINHTHUC")
    private Long fiHinhthuc;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAYGUI")
    private Date fiNgaygui;

    //@Column(name="FI_SO_GCN", length=100)
    private String fiSoGcn;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAYCAP_GCN")
    private Date fiNgaycapGcn;

    //@Column(name="FI_CQ_CAP_GCN", length=250)
    private String fiCqCapGcn;

    //@Column(name="FI_TEN_PL_NK", length=2000)
    private String fiTenPlNk;

    //@Column(name="FI_XUATXU_PL", length=250)
    private String fiXuatxuPl;

    //@Column(name="FI_TEN_TCXK", length=500)
    private String fiTenTcxk;

    //@Column(name="FI_DIACHI_TCXK", length=500)
    private String fiDiachiTcxk;

    //@Column(name="FI_CANG_XK", length=250)
    private String fiCangXk;

    //@Column(name="FI_CUAKHAU_NK", length=250)
    private String fiCuakhauNk;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_TG_DUKIEN")
    private Date fiTgDukien;

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

    //@Column(name="FI_TRANGTHAI")
    private Long fiTrangthai;

    //@Column(name="FI_TEN_TT", length=500)
    private String fiTenTt;

    //@Column(name="FI_SO_TB_NK")
    private String fiSoTbNk;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAYCAP_TB")
    private Date fiNgaycapTb;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_HIEULUCTUNGAY")
    private Date fiHieuluctungay;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_HIEULUCDENNGAY")
    private Date fiHieulucdenngay;

    //@Transient
    private List<Tbdloaipl6> lstLoaiPheLieu;

    //@Transient
    private List<Tbddinhkem6> lstDinhKem;

    public Tbdhoso6() {
        super();
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiMaHoso() {
        return this.fiMaHoso;
    }

    public void setFiMaCqCap(String fiMaCqCap) {
        this.fiMaCqCap = fiMaCqCap;
    }

    public String getFiMaCqCap() {
        return this.fiMaCqCap;
    }

    public void setFiTenCqCap(String fiTenCqCap) {
        this.fiTenCqCap = fiTenCqCap;
    }

    public String getFiTenCqCap() {
        return this.fiTenCqCap;
    }

    public void setFiMstDn(String fiMstDn) {
        this.fiMstDn = fiMstDn;
    }

    public String getFiMstDn() {
        return this.fiMstDn;
    }

    public void setFiTenDn(String fiTenDn) {
        this.fiTenDn = fiTenDn;
    }

    public String getFiTenDn() {
        return this.fiTenDn;
    }

    public void setFiDiachiTsc(String fiDiachiTsc) {
        this.fiDiachiTsc = fiDiachiTsc;
    }

    public String getFiDiachiTsc() {
        return this.fiDiachiTsc;
    }

    public void setFiNgDaidien(String fiNgDaidien) {
        this.fiNgDaidien = fiNgDaidien;
    }

    public String getFiNgDaidien() {
        return this.fiNgDaidien;
    }

    public void setFiNgLienhe(String fiNgLienhe) {
        this.fiNgLienhe = fiNgLienhe;
    }

    public String getFiNgLienhe() {
        return this.fiNgLienhe;
    }

    public void setFiChvuNgLh(String fiChvuNgLh) {
        this.fiChvuNgLh = fiChvuNgLh;
    }

    public String getFiChvuNgLh() {
        return this.fiChvuNgLh;
    }

    public void setFiSdtNgLh(String fiSdtNgLh) {
        this.fiSdtNgLh = fiSdtNgLh;
    }

    public String getFiSdtNgLh() {
        return this.fiSdtNgLh;
    }

    public void setFiFaxNgLh(String fiFaxNgLh) {
        this.fiFaxNgLh = fiFaxNgLh;
    }

    public String getFiFaxNgLh() {
        return this.fiFaxNgLh;
    }

    public void setFiEmailNgLh(String fiEmailNgLh) {
        this.fiEmailNgLh = fiEmailNgLh;
    }

    public String getFiEmailNgLh() {
        return this.fiEmailNgLh;
    }

    public void setFiHinhthuc(Long fiHinhthuc) {
        this.fiHinhthuc = fiHinhthuc;
    }

    public Long getFiHinhthuc() {
        return this.fiHinhthuc;
    }

    public void setFiNgaygui(Date fiNgaygui) {
        this.fiNgaygui = fiNgaygui;
    }

    public Date getFiNgaygui() {
        return this.fiNgaygui;
    }

    public void setFiSoGcn(String fiSoGcn) {
        this.fiSoGcn = fiSoGcn;
    }

    public String getFiSoGcn() {
        return this.fiSoGcn;
    }

    public void setFiNgaycapGcn(Date fiNgaycapGcn) {
        this.fiNgaycapGcn = fiNgaycapGcn;
    }

    public Date getFiNgaycapGcn() {
        return this.fiNgaycapGcn;
    }

    public void setFiCqCapGcn(String fiCqCapGcn) {
        this.fiCqCapGcn = fiCqCapGcn;
    }

    public String getFiCqCapGcn() {
        return this.fiCqCapGcn;
    }

    public void setFiTenPlNk(String fiTenPlNk) {
        this.fiTenPlNk = fiTenPlNk;
    }

    public String getFiTenPlNk() {
        return this.fiTenPlNk;
    }

    public void setFiXuatxuPl(String fiXuatxuPl) {
        this.fiXuatxuPl = fiXuatxuPl;
    }

    public String getFiXuatxuPl() {
        return this.fiXuatxuPl;
    }

    public void setFiTenTcxk(String fiTenTcxk) {
        this.fiTenTcxk = fiTenTcxk;
    }

    public String getFiTenTcxk() {
        return this.fiTenTcxk;
    }

    public void setFiDiachiTcxk(String fiDiachiTcxk) {
        this.fiDiachiTcxk = fiDiachiTcxk;
    }

    public String getFiDiachiTcxk() {
        return this.fiDiachiTcxk;
    }

    public void setFiCangXk(String fiCangXk) {
        this.fiCangXk = fiCangXk;
    }

    public String getFiCangXk() {
        return this.fiCangXk;
    }

    public void setFiCuakhauNk(String fiCuakhauNk) {
        this.fiCuakhauNk = fiCuakhauNk;
    }

    public String getFiCuakhauNk() {
        return this.fiCuakhauNk;
    }

    public void setFiTgDukien(Date fiTgDukien) {
        this.fiTgDukien = fiTgDukien;
    }

    public Date getFiTgDukien() {
        return this.fiTgDukien;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public String getFiNguoitao() {
        return this.fiNguoitao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgaytao() {
        return this.fiNgaytao;
    }

    public void setFiNgCapnhat(Date fiNgCapnhat) {
        this.fiNgCapnhat = fiNgCapnhat;
    }

    public Date getFiNgCapnhat() {
        return this.fiNgCapnhat;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Long getFiTrangthai() {
        return this.fiTrangthai;
    }

    public void setFiTenTt(String fiTenTt) {
        this.fiTenTt = fiTenTt;
    }

    public String getFiTenTt() {
        return this.fiTenTt;
    }

    public void setFiSoTbNk(String fiSoTbNk) {
        this.fiSoTbNk = fiSoTbNk;
    }

    public String getFiSoTbNk() {
        return this.fiSoTbNk;
    }

    public void setFiNgaycapTb(Date fiNgaycapTb) {
        this.fiNgaycapTb = fiNgaycapTb;
    }

    public Date getFiNgaycapTb() {
        return this.fiNgaycapTb;
    }

    public List<Tbdloaipl6> getLstLoaiPheLieu() {
        return lstLoaiPheLieu;
    }

    public void setLstLoaiPheLieu(List<Tbdloaipl6> lstLoaiPheLieu) {
        this.lstLoaiPheLieu = lstLoaiPheLieu;
    }

    public List<Tbddinhkem6> getLstDinhKem() {
        return lstDinhKem;
    }

    public void setLstDinhKem(List<Tbddinhkem6> lstDinhKem) {
        this.lstDinhKem = lstDinhKem;
    }

    public Date getFiHieuluctungay() {
        return fiHieuluctungay;
    }

    public void setFiHieuluctungay(Date fiHieuluctungay) {
        this.fiHieuluctungay = fiHieuluctungay;
    }

    public Date getFiHieulucdenngay() {
        return fiHieulucdenngay;
    }

    public void setFiHieulucdenngay(Date fiHieulucdenngay) {
        this.fiHieulucdenngay = fiHieulucdenngay;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(fiIdHoso);
        sb.append("]:");
        sb.append(fiMaHoso);
        sb.append("|");
        sb.append(fiMaCqCap);
        sb.append("|");
        sb.append(fiTenCqCap);
        sb.append("|");
        sb.append(fiMstDn);
        sb.append("|");
        sb.append(fiTenDn);
        sb.append("|");
        sb.append(fiDiachiTsc);
        sb.append("|");
        sb.append(fiNgDaidien);
        sb.append("|");
        sb.append(fiNgLienhe);
        sb.append("|");
        sb.append(fiChvuNgLh);
        sb.append("|");
        sb.append(fiSdtNgLh);
        sb.append("|");
        sb.append(fiFaxNgLh);
        sb.append("|");
        sb.append(fiEmailNgLh);
        sb.append("|");
        sb.append(fiHinhthuc);
        sb.append("|");
        sb.append(fiNgaygui);
        sb.append("|");
        sb.append(fiSoGcn);
        sb.append("|");
        sb.append(fiNgaycapGcn);
        sb.append("|");
        sb.append(fiCqCapGcn);
        sb.append("|");
        sb.append(fiTenPlNk);
        sb.append("|");
        sb.append(fiXuatxuPl);
        sb.append("|");
        sb.append(fiTenTcxk);
        sb.append("|");
        sb.append(fiDiachiTcxk);
        sb.append("|");
        sb.append(fiCangXk);
        sb.append("|");
        sb.append(fiCuakhauNk);
        sb.append("|");
        sb.append(fiTgDukien);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNguoitao);
        sb.append("|");
        sb.append(fiNgaytao);
        sb.append("|");
        sb.append(fiNgCapnhat);
        sb.append("|");
        sb.append(fiTrangthai);
        sb.append("|");
        sb.append(fiTenTt);
        sb.append("|");
        sb.append(fiSoTbNk);
        sb.append("|");
        sb.append(fiNgaycapTb);
        return sb.toString();
    }

}
