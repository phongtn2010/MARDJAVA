package com.nsw.mt.p36.model;

import java.util.Date;
import java.util.List;

public class Tbdhoso36 {

    private Long fiIdHoso;

    //@Column(name="FI_MA_HOSO", length=50)
    private String fiMaHoso;

    //@Column(name="FI_ID_CQXL")
    private String fiMaCqxl;

    //@Column(name="FI_TEN_CQXL", length=255)
    private String fiTenCqxl;

    //@Column(name="FI_TEN_DN", length=255)
    private String fiTenDn;

    //@Column(name="FI_DIACHI_DN", length=255)
    private String fiDiachiDn;

    //@Column(name="FI_SDT_DN", length=255)
    private String fiSdtDn;

    //@Column(name="FI_MUCDICH", length=1000)
    private String fiMucdich;

    //@Column(name="FI_MST_DN", length=13)
    private String fiMstDn;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="FI_NGAYGUI")
    private Date fiNgaygui;

    //@Column(name="FI_HOATDONG")
    private Long fiHoatdong;

    //@Column(name="FI_NGUOITAO", length=50)
    private String fiNguoitao;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="FI_NGAYTAO")
    private Date fiNgaytao;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="FI_NG_CAPNHAT")
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

    //@Column(name="FI_TEN_NG_LH", length=255)
    private String fiTenNgLh;

    // @Column(name="FI_SDT_NG_LH", length=255)
    private String fiSdtNgLh;

    //@Transient
    private List<TbdhsXe36> lstXe;

    //@Transient
    private List<TbdhsDinhkem36> lstDinhKem;

    //@Transient
    private TbdhsDnky36 chuKyDoanhNghiep;

    public Tbdhoso36() {
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

//    public void setFiIdCqxl(String fiMaCqxl) {
//        this.fiMaCqxl = fiMaCqxl;
//    }
//
//    public String getFiIdCqxl() {
//        return this.fiMaCqxl;
//    }
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

    public void setFiMucdich(String fiMucdich) {
        this.fiMucdich = fiMucdich;
    }

    public String getFiMucdich() {
        return this.fiMucdich;
    }

    public void setFiMstDn(String fiMstDn) {
        this.fiMstDn = fiMstDn;
    }

    public String getFiMstDn() {
        return this.fiMstDn;
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

    public List<TbdhsXe36> getLstXe() {
        return lstXe;
    }

    public void setLstXe(List<TbdhsXe36> lstXe) {
        this.lstXe = lstXe;
    }

    public List<TbdhsDinhkem36> getLstDinhKem() {
        return lstDinhKem;
    }

    public void setLstDinhKem(List<TbdhsDinhkem36> lstDinhKem) {
        this.lstDinhKem = lstDinhKem;
    }

    public TbdhsDnky36 getChuKyDoanhNghiep() {
        return chuKyDoanhNghiep;
    }

    public void setChuKyDoanhNghiep(TbdhsDnky36 chuKyDoanhNghiep) {
        this.chuKyDoanhNghiep = chuKyDoanhNghiep;
    }

}
