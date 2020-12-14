package com.nsw.mt.p43.model;

import java.util.Date;
import java.util.List;

public class Tbdhoso43 {

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

    // @Column(name="FI_SDT_DN", length=255)
    private String fiSdtDn;

    //@Column(name="FI_FAX_DN", length=255)
    private String fiFaxDn;

    // @Column(name="FI_EMAIL_DN", length=255)
    private String fiEmailDn;

    //@Column(name="FI_MST_DN", length=13)
    private String fiMstDn;

    //@Column(name="FI_CQCAP_GP_VN", length=255)
    private String fiCqcapGpVn;

    //@Column(name="FI_SO_GPVT_VN", length=255)
    private String fiSoGpvtVn;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAY_GPVT_VN")
    private Date fiNgayGpvtVn;

    //@Column(name="FI_CQCAP_GP_TQ", length=255)
    private String fiCqcapGpTq;

    //@Column(name="FI_SO_GPVT_TQ", length=255)
    private String fiSoGpvtTq;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAY_GPVT_TQ")
    private Date fiNgayGpvtTq;

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
    private List<TbdhsXe43> lstXe;

    //@Transient
    private List<TbdhsDinhkem43> lstDinhKem;

    //@Transient
    private TbdhsDnky43 chuKyDoanhNghiep;

    public Tbdhoso43() {
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

    public void setFiCqcapGpVn(String fiCqcapGpVn) {
        this.fiCqcapGpVn = fiCqcapGpVn;
    }

    public String getFiCqcapGpVn() {
        return this.fiCqcapGpVn;
    }

    public void setFiSoGpvtVn(String fiSoGpvtVn) {
        this.fiSoGpvtVn = fiSoGpvtVn;
    }

    public String getFiSoGpvtVn() {
        return this.fiSoGpvtVn;
    }

    public void setFiNgayGpvtVn(Date fiNgayGpvtVn) {
        this.fiNgayGpvtVn = fiNgayGpvtVn;
    }

    public Date getFiNgayGpvtVn() {
        return this.fiNgayGpvtVn;
    }

    public void setFiCqcapGpTq(String fiCqcapGpTq) {
        this.fiCqcapGpTq = fiCqcapGpTq;
    }

    public String getFiCqcapGpTq() {
        return this.fiCqcapGpTq;
    }

    public void setFiSoGpvtTq(String fiSoGpvtTq) {
        this.fiSoGpvtTq = fiSoGpvtTq;
    }

    public String getFiSoGpvtTq() {
        return this.fiSoGpvtTq;
    }

    public void setFiNgayGpvtTq(Date fiNgayGpvtTq) {
        this.fiNgayGpvtTq = fiNgayGpvtTq;
    }

    public Date getFiNgayGpvtTq() {
        return this.fiNgayGpvtTq;
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

    public List<TbdhsXe43> getLstXe() {
        return lstXe;
    }

    public void setLstXe(List<TbdhsXe43> lstXe) {
        this.lstXe = lstXe;
    }

    public List<TbdhsDinhkem43> getLstDinhKem() {
        return lstDinhKem;
    }

    public void setLstDinhKem(List<TbdhsDinhkem43> lstDinhKem) {
        this.lstDinhKem = lstDinhKem;
    }

    public TbdhsDnky43 getChuKyDoanhNghiep() {
        return chuKyDoanhNghiep;
    }

    public void setChuKyDoanhNghiep(TbdhsDnky43 chuKyDoanhNghiep) {
        this.chuKyDoanhNghiep = chuKyDoanhNghiep;
    }

}
