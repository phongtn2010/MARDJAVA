package com.nsw.moit.p01.model;

import java.util.Date;
import java.util.List;

public class Tbdhoso1 {

    private Long fiIdHoso;

    //@Column(name = "FI_MA_HOSO", length = 50)
    private String fiMaHoso;

    //@Column(name = "FI_MST", length = 13)
    private String fiMst;

    //@Column(name = "FI_TEN_DN", length = 250)
    private String fiTenDn;

    //@Column(name = "FI_DIACHI_TSC", length = 250)
    private String fiDiachiTsc;

    //@Column(name = "FI_SDT", length = 50)
    private String fiSdt;

    //@Column(name = "FI_FAX", length = 50)
    private String fiFax;

    //@Column(name = "FI_WEB", length = 100)
    private String fiWeb;

    //@Column(name = "FI_SO_GCN_DK", length = 250)
    private String fiSoGcnDk;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYCAP_DK")
    private Date fiNgaycapDk;

    //@Column(name = "FI_NOICAP_DK", length = 250)
    private String fiNoicapDk;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYGUI")
    private Date fiNgaygui;

    //@Column(name = "FI_HOATDONG")
    private Long fiHoatdong;

    //@Column(name = "FI_NGUOITAO", length = 50)
    private String fiNguoitao;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYTAO")
    private Date fiNgaytao;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NG_CAPNHAT")
    private Date fiNgCapnhat;

    //@Column(name = "FI_TRANGTHAI")
    private Long fiTrangthai;

    //@Column(name = "FI_TEN_TT", length = 500)
    private String fiTenTt;

    //@Column(name = "FI_SO_VB", length = 50)
    private String fiSoVb;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "FI_NGAYCAP_VB") 
    private Date fiNgaycapVb;

    //@Column(name = "FI_ID_HOSOCHA")
    private Long fiIdHosocha;

    //@Column(name = "FI_LA_HOSOTAM")
    private Long fiLaHosotam;

//     @Column(name = "FI_SOLAN_YCSUA")
    private Long fiSolanYcsua;

//    @Column(name = "FI_HAUTO")
    private Long fiHauto;

    //@Transient
    private List<TbdhsHanghoa1> lstHanghoas;

    //@Transient
    private List<TbdhsDinhkem1> lstDinhkems;

    private String lyDo;

    public Tbdhoso1() {
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

    public void setFiMst(String fiMst) {
        this.fiMst = fiMst;
    }

    public String getFiMst() {
        return this.fiMst;
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

    public void setFiSdt(String fiSdt) {
        this.fiSdt = fiSdt;
    }

    public String getFiSdt() {
        return this.fiSdt;
    }

    public void setFiFax(String fiFax) {
        this.fiFax = fiFax;
    }

    public String getFiFax() {
        return this.fiFax;
    }

    public void setFiWeb(String fiWeb) {
        this.fiWeb = fiWeb;
    }

    public String getFiWeb() {
        return this.fiWeb;
    }

    public void setFiSoGcnDk(String fiSoGcnDk) {
        this.fiSoGcnDk = fiSoGcnDk;
    }

    public String getFiSoGcnDk() {
        return this.fiSoGcnDk;
    }

    public void setFiNgaycapDk(Date fiNgaycapDk) {
        this.fiNgaycapDk = fiNgaycapDk;
    }

    public Date getFiNgaycapDk() {
        return this.fiNgaycapDk;
    }

    public void setFiNoicapDk(String fiNoicapDk) {
        this.fiNoicapDk = fiNoicapDk;
    }

    public String getFiNoicapDk() {
        return this.fiNoicapDk;
    }

    public void setFiNgaygui(Date fiNgaygui) {
        this.fiNgaygui = fiNgaygui;
    }

    public Date getFiNgaygui() {
        return this.fiNgaygui;
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

    public void setFiSoVb(String fiSoVb) {
        this.fiSoVb = fiSoVb;
    }

    public String getFiSoVb() {
        return this.fiSoVb;
    }

    public void setFiNgaycapVb(Date fiNgaycapVb) {
        this.fiNgaycapVb = fiNgaycapVb;
    }

    public Date getFiNgaycapVb() {
        return this.fiNgaycapVb;
    }

    public void setFiIdHosocha(Long fiIdHosocha) {
        this.fiIdHosocha = fiIdHosocha;
    }

    public Long getFiIdHosocha() {
        return this.fiIdHosocha;
    }

    public void setFiLaHosotam(Long fiLaHosotam) {
        this.fiLaHosotam = fiLaHosotam;
    }

    public Long getFiLaHosotam() {
        return this.fiLaHosotam;
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

    public List<TbdhsHanghoa1> getLstHanghoas() {
        return lstHanghoas;
    }

    public void setLstHanghoas(List<TbdhsHanghoa1> lstHanghoas) {
        this.lstHanghoas = lstHanghoas;
    }

    public List<TbdhsDinhkem1> getLstDinhkems() {
        return lstDinhkems;
    }

    public void setLstDinhkems(List<TbdhsDinhkem1> lstDinhkems) {
        this.lstDinhkems = lstDinhkems;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

}
