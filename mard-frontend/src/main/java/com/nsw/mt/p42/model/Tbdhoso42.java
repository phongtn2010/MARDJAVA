package com.nsw.mt.p42.model;

import java.util.Date;
import java.util.List;

public class Tbdhoso42 {

    private Long fiIdHoso;

    //@Column(name="FI_MA_HOSO", length=50)
    private String fiMaHoso;

    // @Column(name="FI_MA_CQXL", length=50)
    private String fiMaCqxl;

    //@Column(name="FI_TEN_CQXL", length=255)
    private String fiTenCqxl;

    //@Column(name="FI_TEN_DN", length=255)
    private String fiTenDn;

    //@Column(name="FI_DIACHI_DN", length=255)
    private String fiDiachiDn;

    //@Column(name="FI_SDT_DN", length=255)
    private String fiSdtDn;

    //@Column(name="FI_FAX_DN", length=255)
    private String fiFaxDn;

    //@Column(name="FI_EMAIL_DN", length=255)
    private String fiEmailDn;

    //@Column(name="FI_MST_DN", length=13)
    private String fiMstDn;

    //@Column(name="FI_CQ_CAP_GPVT", length=255)
    private String fiCqCapGpvt;

    //@Column(name="FI_SO_GPVT", length=255)
    private String fiSoGpvt;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGCAP_GPVT")
    private Date fiNgcapGpvt;

    //@Column(name="FI_TEN_NG_LH", length=255)
    private String fiTenNgLh;

    //@Column(name="FI_SDT_NG_LH", length=255)
    private String fiSdtNgLh;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAYGUI")
    private Date fiNgaygui;

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

    //@Column(name="FI_SO_GP", length=255)
    private String fiSoGp;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAYCAP_GP")
    private Date fiNgaycapGp;

    //@Transient
    private List<TbdhsXe42> lstXe;

    //@Transient
    private List<TbdhsDinhkem42> lstDinhKem;

    //@Transient
    private TbdhsDnky42 chuKyDoanhNghiep;

    public Tbdhoso42() {
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

    public void setFiMaCqxl(String fiMaCqxl) {
        this.fiMaCqxl = fiMaCqxl;
    }

    public String getFiMaCqxl() {
        return this.fiMaCqxl;
    }

    public void setFiTenCqxl(String fiTenCqxl) {
        this.fiTenCqxl = fiTenCqxl;
    }

    public String getFiTenCqxl() {
        return this.fiTenCqxl;
    }

    public void setFiTenDn(String fiTenDn) {
        this.fiTenDn = fiTenDn;
    }

    public String getFiTenDn() {
        return this.fiTenDn;
    }

    public void setFiDiachiDn(String fiDiachiDn) {
        this.fiDiachiDn = fiDiachiDn;
    }

    public String getFiDiachiDn() {
        return this.fiDiachiDn;
    }

    public void setFiSdtDn(String fiSdtDn) {
        this.fiSdtDn = fiSdtDn;
    }

    public String getFiSdtDn() {
        return this.fiSdtDn;
    }

    public void setFiFaxDn(String fiFaxDn) {
        this.fiFaxDn = fiFaxDn;
    }

    public String getFiFaxDn() {
        return this.fiFaxDn;
    }

    public void setFiEmailDn(String fiEmailDn) {
        this.fiEmailDn = fiEmailDn;
    }

    public String getFiEmailDn() {
        return this.fiEmailDn;
    }

    public void setFiMstDn(String fiMstDn) {
        this.fiMstDn = fiMstDn;
    }

    public String getFiMstDn() {
        return this.fiMstDn;
    }

    public void setFiCqCapGpvt(String fiCqCapGpvt) {
        this.fiCqCapGpvt = fiCqCapGpvt;
    }

    public String getFiCqCapGpvt() {
        return this.fiCqCapGpvt;
    }

    public void setFiSoGpvt(String fiSoGpvt) {
        this.fiSoGpvt = fiSoGpvt;
    }

    public String getFiSoGpvt() {
        return this.fiSoGpvt;
    }

    public void setFiNgcapGpvt(Date fiNgcapGpvt) {
        this.fiNgcapGpvt = fiNgcapGpvt;
    }

    public Date getFiNgcapGpvt() {
        return this.fiNgcapGpvt;
    }

    public void setFiTenNgLh(String fiTenNgLh) {
        this.fiTenNgLh = fiTenNgLh;
    }

    public String getFiTenNgLh() {
        return this.fiTenNgLh;
    }

    public void setFiSdtNgLh(String fiSdtNgLh) {
        this.fiSdtNgLh = fiSdtNgLh;
    }

    public String getFiSdtNgLh() {
        return this.fiSdtNgLh;
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

    public void setFiSoGp(String fiSoGp) {
        this.fiSoGp = fiSoGp;
    }

    public String getFiSoGp() {
        return this.fiSoGp;
    }

    public void setFiNgaycapGp(Date fiNgaycapGp) {
        this.fiNgaycapGp = fiNgaycapGp;
    }

    public Date getFiNgaycapGp() {
        return this.fiNgaycapGp;
    }

    public List<TbdhsXe42> getLstXe() {
        return lstXe;
    }

    public void setLstXe(List<TbdhsXe42> lstXe) {
        this.lstXe = lstXe;
    }

    public List<TbdhsDinhkem42> getLstDinhKem() {
        return lstDinhKem;
    }

    public void setLstDinhKem(List<TbdhsDinhkem42> lstDinhKem) {
        this.lstDinhKem = lstDinhKem;
    }

    public TbdhsDnky42 getChuKyDoanhNghiep() {
        return chuKyDoanhNghiep;
    }

    public void setChuKyDoanhNghiep(TbdhsDnky42 chuKyDoanhNghiep) {
        this.chuKyDoanhNghiep = chuKyDoanhNghiep;
    }

}
