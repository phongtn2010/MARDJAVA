package com.nsw.moit.p05.model;

import java.util.Date;
import java.util.List;

public class Tbdhoso5 {

    private Long fiIdHoso;

    //@Size(max = 50)
    //@Column(name = "FI_MA_HOSO")
    private String fiMaHoso;
    //@Size(max = 13)
    //@Column(name = "FI_MST")
    private String fiMst;
    //@Size(max = 250)
    //@Column(name = "FI_TEN_DN")
    private String fiTenDn;
    //@Size(max = 250)
    //@Column(name = "FI_DIACHI_TSC")
    private String fiDiachiTsc;
    //@Size(max = 50)
    //@Column(name = "FI_SDT")
    private String fiSdt;
    //@Size(max = 50)
    //@Column(name = "FI_FAX")
    private String fiFax;
    //@Size(max = 100)
    //@Column(name = "FI_EMAIL")
    private String fiEmail;
    //@Size(max = 250)
    //@Column(name = "FI_SO_GCN_DK")
    private String fiSoGcnDk;
    //@Column(name = "FI_NGAYCAP_DK")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaycapDk;
    //@Size(max = 250)
    //@Column(name = "FI_NOICAP_DK")
    private String fiNoicapDk;
    //@Size(max = 250)
    //@Column(name = "FI_NGUOI_DAIDIEN")
    private String fiNguoiDaidien;
    //@Size(max = 250)
    //@Column(name = "FI_NGUOI_LAPBIEU")
    private String fiNguoiLapbieu;
    //@Size(max = 250)
    //@Column(name = "FI_NAMDK_NK")
    private String fiNamdkNk;
    //@Column(name = "FI_NGAYGUI")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaygui;
    //@Column(name = "FI_HOATDONG")
    private Long fiHoatdong;
    //@Size(max = 50)
    //@Column(name = "FI_NGUOITAO")
    private String fiNguoitao;
    //@Column(name = "FI_NGAYTAO")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaytao;
    //@Column(name = "FI_NG_CAPNHAT")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date fiNgCapnhat;
    //@Column(name = "FI_TRANGTHAI")
    private Long fiTrangthai;
    //@Size(max = 500)
    //@Column(name = "FI_TEN_TT")
    private String fiTenTt;
    //@Size(max = 50)
    //@Column(name = "FI_SO_VB")
    private String fiSoVb;
    //@Column(name = "FI_NGAYCAP_VB")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaycapVb;
    //@Column(name = "FI_ID_HOSOCHA")
    private Long fiIdHosocha;
    //@Column(name = "FI_LA_HOSOTAM")
    private Long fiLaHosotam;
    //@Column(name = "FI_SOLAN_YCSUA")
    private Long fiSolanYcsua;
//    @Column(name = "FI_SOLAN_YCSUA")
    private Long fiHauto;
    //@Transient
    private List<TbdhsNguyenlieu5> lstNguyenlieus;

    //@Transient
    private List<TbdhsDinhkem5> lstDinhkems;

    private String lyDo;

    public Tbdhoso5() {
        super();
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiMst() {
        return fiMst;
    }

    public void setFiMst(String fiMst) {
        this.fiMst = fiMst;
    }

    public String getFiTenDn() {
        return fiTenDn;
    }

    public void setFiTenDn(String fiTenDn) {
        this.fiTenDn = fiTenDn;
    }

    public String getFiDiachiTsc() {
        return fiDiachiTsc;
    }

    public void setFiDiachiTsc(String fiDiachiTsc) {
        this.fiDiachiTsc = fiDiachiTsc;
    }

    public String getFiSdt() {
        return fiSdt;
    }

    public void setFiSdt(String fiSdt) {
        this.fiSdt = fiSdt;
    }

    public String getFiFax() {
        return fiFax;
    }

    public void setFiFax(String fiFax) {
        this.fiFax = fiFax;
    }

    public String getFiEmail() {
        return fiEmail;
    }

    public void setFiEmail(String fiEmail) {
        this.fiEmail = fiEmail;
    }

    public String getFiSoGcnDk() {
        return fiSoGcnDk;
    }

    public void setFiSoGcnDk(String fiSoGcnDk) {
        this.fiSoGcnDk = fiSoGcnDk;
    }

    public Date getFiNgaycapDk() {
        return fiNgaycapDk;
    }

    public void setFiNgaycapDk(Date fiNgaycapDk) {
        this.fiNgaycapDk = fiNgaycapDk;
    }

    public String getFiNoicapDk() {
        return fiNoicapDk;
    }

    public void setFiNoicapDk(String fiNoicapDk) {
        this.fiNoicapDk = fiNoicapDk;
    }

    public String getFiNguoiDaidien() {
        return fiNguoiDaidien;
    }

    public void setFiNguoiDaidien(String fiNguoiDaidien) {
        this.fiNguoiDaidien = fiNguoiDaidien;
    }

    public String getFiNguoiLapbieu() {
        return fiNguoiLapbieu;
    }

    public void setFiNguoiLapbieu(String fiNguoiLapbieu) {
        this.fiNguoiLapbieu = fiNguoiLapbieu;
    }

    public String getFiNamdkNk() {
        return fiNamdkNk;
    }

    public void setFiNamdkNk(String fiNamdkNk) {
        this.fiNamdkNk = fiNamdkNk;
    }

    public Date getFiNgaygui() {
        return fiNgaygui;
    }

    public void setFiNgaygui(Date fiNgaygui) {
        this.fiNgaygui = fiNgaygui;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgCapnhat() {
        return fiNgCapnhat;
    }

    public void setFiNgCapnhat(Date fiNgCapnhat) {
        this.fiNgCapnhat = fiNgCapnhat;
    }

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public String getFiTenTt() {
        return fiTenTt;
    }

    public void setFiTenTt(String fiTenTt) {
        this.fiTenTt = fiTenTt;
    }

    public String getFiSoVb() {
        return fiSoVb;
    }

    public void setFiSoVb(String fiSoVb) {
        this.fiSoVb = fiSoVb;
    }

    public Date getFiNgaycapVb() {
        return fiNgaycapVb;
    }

    public void setFiNgaycapVb(Date fiNgaycapVb) {
        this.fiNgaycapVb = fiNgaycapVb;
    }

    public Long getFiIdHosocha() {
        return fiIdHosocha;
    }

    public void setFiIdHosocha(Long fiIdHosocha) {
        this.fiIdHosocha = fiIdHosocha;
    }

    public Long getFiLaHosotam() {
        return fiLaHosotam;
    }

    public void setFiLaHosotam(Long fiLaHosotam) {
        this.fiLaHosotam = fiLaHosotam;
    }

    public Long getFiSolanYcsua() {
        return fiSolanYcsua;
    }

    public void setFiSolanYcsua(Long fiSolanYcsua) {
        this.fiSolanYcsua = fiSolanYcsua;
    }

    public Long getFiHauto() {
        return fiHauto;
    }

    public void setFiHauto(Long fiHauto) {
        this.fiHauto = fiHauto;
    }

    public List<TbdhsNguyenlieu5> getLstNguyenlieus() {
        return lstNguyenlieus;
    }

    public void setLstNguyenlieus(List<TbdhsNguyenlieu5> lstNguyenlieus) {
        this.lstNguyenlieus = lstNguyenlieus;
    }

    public List<TbdhsDinhkem5> getLstDinhkems() {
        return lstDinhkems;
    }

    public void setLstDinhkems(List<TbdhsDinhkem5> lstDinhkems) {
        this.lstDinhkems = lstDinhkems;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

}
