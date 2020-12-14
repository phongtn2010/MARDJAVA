package com.nsw.moit.p04.model;

import com.nsw.moit.p01.model.*;
import java.util.Date;
import java.util.List;

public class Tbdhoso4 {

    private Long fiIdHoso;

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
    // @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaycapDk;
    //@Size(max = 250)
    //@Column(name = "FI_NOICAP_DK")
    private String fiNoicapDk;
    //@Size(max = 250)
    //@Column(name = "FI_MUCDICH_NK")
    private String fiMucdichNk;
    //@Size(max = 250)
    //@Column(name = "FI_SOLUONG")
    private String fiSoluong;
    //@Size(max = 250)
    //@Column(name = "FI_QUYCACH_DONGGOI")
    private String fiQuycachDonggoi;
    //@Size(max = 250)
    //@Column(name = "FI_CACHTHUC_KIEMSOAT")
    private String fiCachthucKiemsoat;
    //@Size(max = 250)
    //@Column(name = "FI_DV_GUIHANG")
    private String fiDvGuihang;
    //@Size(max = 250)
    //@Column(name = "FI_NGUOIGUI")
    private String fiNguoigui;
    //@Size(max = 250)
    //@Column(name = "FI_SDT_NGUOIGUI")
    private String fiSdtNguoigui;
    //@Size(max = 250)
    //@Column(name = "FI_DV_NHANHANG")
    private String fiDvNhanhang;
    //@Size(max = 250)
    //@Column(name = "FI_NGUOINHAN")
    private String fiNguoinhan;
    //@Size(max = 250)
    //@Column(name = "FI_SDT_NGUOINHAN")
    private String fiSdtNguoinhan;
    //@Column(name = "FI_NGAYGUI")
    // @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaygui;
    //@Column(name = "FI_HOATDONG")
    private Long fiHoatdong;
    //@Size(max = 50)
    //@Column(name = "FI_NGUOITAO")
    private String fiNguoitao;
    //@Column(name = "FI_NGAYTAO")
    // @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaytao;
    //@Column(name = "FI_NG_CAPNHAT")
    // @Temporal(TemporalType.TIMESTAMP)
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
    // @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaycapVb;
    //@Column(name = "FI_ID_HOSOCHA")
    private Long fiIdHosocha;
    //@Column(name = "FI_LA_HOSOTAM")
    private Long fiLaHosotam;
    //@Column(name = "FI_SOLAN_YCSUA")
    private Long fiSolanYcsua;
//    @Column(name = "FI_HAUTO")
    private Long fiHauto;
    //@Transient
    private List<TbdhsHanghoa4> lstHanghoas;

    //@Transient
    private List<TbdhsDinhkem4> lstDinhkems;

    private String lyDo;

    public Tbdhoso4() {
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

    public String getFiMucdichNk() {
        return fiMucdichNk;
    }

    public void setFiMucdichNk(String fiMucdichNk) {
        this.fiMucdichNk = fiMucdichNk;
    }

    public String getFiSoluong() {
        return fiSoluong;
    }

    public void setFiSoluong(String fiSoluong) {
        this.fiSoluong = fiSoluong;
    }

    public String getFiQuycachDonggoi() {
        return fiQuycachDonggoi;
    }

    public void setFiQuycachDonggoi(String fiQuycachDonggoi) {
        this.fiQuycachDonggoi = fiQuycachDonggoi;
    }

    public String getFiCachthucKiemsoat() {
        return fiCachthucKiemsoat;
    }

    public void setFiCachthucKiemsoat(String fiCachthucKiemsoat) {
        this.fiCachthucKiemsoat = fiCachthucKiemsoat;
    }

    public String getFiDvGuihang() {
        return fiDvGuihang;
    }

    public void setFiDvGuihang(String fiDvGuihang) {
        this.fiDvGuihang = fiDvGuihang;
    }

    public String getFiNguoigui() {
        return fiNguoigui;
    }

    public void setFiNguoigui(String fiNguoigui) {
        this.fiNguoigui = fiNguoigui;
    }

    public String getFiSdtNguoigui() {
        return fiSdtNguoigui;
    }

    public void setFiSdtNguoigui(String fiSdtNguoigui) {
        this.fiSdtNguoigui = fiSdtNguoigui;
    }

    public String getFiDvNhanhang() {
        return fiDvNhanhang;
    }

    public void setFiDvNhanhang(String fiDvNhanhang) {
        this.fiDvNhanhang = fiDvNhanhang;
    }

    public String getFiNguoinhan() {
        return fiNguoinhan;
    }

    public void setFiNguoinhan(String fiNguoinhan) {
        this.fiNguoinhan = fiNguoinhan;
    }

    public String getFiSdtNguoinhan() {
        return fiSdtNguoinhan;
    }

    public void setFiSdtNguoinhan(String fiSdtNguoinhan) {
        this.fiSdtNguoinhan = fiSdtNguoinhan;
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

    public List<TbdhsHanghoa4> getLstHanghoas() {
        return lstHanghoas;
    }

    public void setLstHanghoas(List<TbdhsHanghoa4> lstHanghoas) {
        this.lstHanghoas = lstHanghoas;
    }

    public List<TbdhsDinhkem4> getLstDinhkems() {
        return lstDinhkems;
    }

    public void setLstDinhkems(List<TbdhsDinhkem4> lstDinhkems) {
        this.lstDinhkems = lstDinhkems;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

}
