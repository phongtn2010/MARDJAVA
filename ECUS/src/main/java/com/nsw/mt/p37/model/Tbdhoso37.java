package com.nsw.mt.p37.model;

import java.util.Date;
import java.util.List;

public class Tbdhoso37 {

    private Long fiIdHoso;

    //@Column(name="FI_MA_HOSO", length=50)
    private String fiMaHoso;

    //@Column(name="FI_MA_CQXL", length=50)
    private String fiMaCqxl;

    //@Column(name="FI_TEN_CQXL", length=255)
    private String fiTenCqxl;

    //@Column(name="FI_TEN_DN", length=255)
    private String fiTenDn;

    //@Column(name="FI_DIACHI_DN", length=255)
    private String fiDiachiDn;

    //@Column(name="FI_SDT_DN", length=255)
    private String fiSdtDn;

    //@Column(name="FI_MST_DN", length=13)
    private String fiMstDn;

    //@Column(name="FI_SO_GP_DKKD", length=255)
    private String fiSoGpDkkd;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGCAP_DKKD")
    private Date fiNgcapDkkd;

    //@Column(name="FI_CQ_CAP_DKKD", length=255)
    private String fiCqCapDkkd;

    //@Column(name="FI_SO_GPVT", length=255)
    private String fiSoGpvt;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGCAP_GPVT")
    private Date fiNgcapGpvt;

    //@Column(name="FI_CQ_CAP_GPVT", length=255)
    private String fiCqCapGpvt;

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

    //@Column(name="FI_ID_THUTUC")
    private Long fiIdThutuc;

    //@Column(name="FI_MA_THUTUC", length=50)
    private String fiMaThutuc;

    //@Column(name="FI_TEN_THUTUC", length=500)
    private String fiTenThutuc;

    //@Transient
    private List<TbdhsXe37> lstXe;

    //@Transient
    private List<TbdhsDinhkem37> lstDinhKem;

    //@Transient
    private TbdhsDnky37 chuKyDoanhNghiep;

    public Tbdhoso37() {
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

    public String getFiMaCqxl() {
        return fiMaCqxl;
    }

    public void setFiMaCqxl(String fiMaCqxl) {
        this.fiMaCqxl = fiMaCqxl;
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

    public void setFiMstDn(String fiMstDn) {
        this.fiMstDn = fiMstDn;
    }

    public String getFiMstDn() {
        return this.fiMstDn;
    }

    public void setFiSoGpDkkd(String fiSoGpDkkd) {
        this.fiSoGpDkkd = fiSoGpDkkd;
    }

    public String getFiSoGpDkkd() {
        return this.fiSoGpDkkd;
    }

    public void setFiNgcapDkkd(Date fiNgcapDkkd) {
        this.fiNgcapDkkd = fiNgcapDkkd;
    }

    public Date getFiNgcapDkkd() {
        return this.fiNgcapDkkd;
    }

    public void setFiCqCapDkkd(String fiCqCapDkkd) {
        this.fiCqCapDkkd = fiCqCapDkkd;
    }

    public String getFiCqCapDkkd() {
        return this.fiCqCapDkkd;
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

    public void setFiCqCapGpvt(String fiCqCapGpvt) {
        this.fiCqCapGpvt = fiCqCapGpvt;
    }

    public String getFiCqCapGpvt() {
        return this.fiCqCapGpvt;
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

    public List<TbdhsXe37> getLstXe() {
        return lstXe;
    }

    public void setLstXe(List<TbdhsXe37> lstXe) {
        this.lstXe = lstXe;
    }

    public List<TbdhsDinhkem37> getLstDinhKem() {
        return lstDinhKem;
    }

    public void setLstDinhKem(List<TbdhsDinhkem37> lstDinhKem) {
        this.lstDinhKem = lstDinhKem;
    }

    public TbdhsDnky37 getChuKyDoanhNghiep() {
        return chuKyDoanhNghiep;
    }

    public void setChuKyDoanhNghiep(TbdhsDnky37 chuKyDoanhNghiep) {
        this.chuKyDoanhNghiep = chuKyDoanhNghiep;
    }

    public Long getFiIdThutuc() {
        return fiIdThutuc;
    }

    public void setFiIdThutuc(Long fiIdThutuc) {
        this.fiIdThutuc = fiIdThutuc;
    }

    public String getFiMaThutuc() {
        return fiMaThutuc;
    }

    public void setFiMaThutuc(String fiMaThutuc) {
        this.fiMaThutuc = fiMaThutuc;
    }

    public String getFiTenThutuc() {
        return fiTenThutuc;
    }

    public void setFiTenThutuc(String fiTenThutuc) {
        this.fiTenThutuc = fiTenThutuc;
    }

}
