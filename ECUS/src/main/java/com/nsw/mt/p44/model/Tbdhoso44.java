package com.nsw.mt.p44.model;

import java.util.Date;
import java.util.List;

public class Tbdhoso44 {

    private Long fiIdHoso     ;


    //@Column(name="FI_MA_HOSO", length=50)
    private String     fiMaHoso     ;

    //@Column(name="FI_ID_THUTUC")
    private Long fiIdThutuc   ;

    //@Column(name="FI_MA_THUTUC", length=50)
    private String     fiMaThutuc   ;

    //@Column(name="FI_TEN_THUTUC", length=500)
    private String     fiTenThutuc  ;

    //@Column(name="FI_MA_CQXL", length=50)
    private String     fiMaCqxl     ;

    //@Column(name="FI_TEN_CQXL", length=255)
    private String     fiTenCqxl    ;

    //@Column(name="FI_TEN_DN", length=255)
    private String     fiTenDn      ;

    //@Column(name="FI_SO_GT_VB", length=255)
    private String     fiSoGtVb     ;

    //@Column(name="FI_DIACHI_DN", length=255)
    private String     fiDiachiDn   ;

    //@Column(name="FI_SDT_DN", length=255)
    private String     fiSdtDn      ;
    
    //@Column(name="FI_FAX_DN", length=255)
    private String     fiFaxDn      ;
    
    //@Column(name="FI_EMAIL_DN", length=255)
    private String     fiEmailDn    ;

    //@Column(name="FI_MST_DN", length=13)
    private String     fiMstDn      ;

    //@Column(name="FI_WEB_DN", length=255)
    private String     fiWebDn      ;

    //@Column(name="FI_SO_GP_VTDB", length=255)
    private String     fiSoGpVtdb   ;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAYCAP_GP")
    private Date       fiNgaycapGp  ;

    //@Column(name="FI_CQCAP_GP", length=255)
    private String     fiCqcapGp    ;

    //@Column(name="FI_MA_TUYEN", length=255)
    private String     fiMaTuyen    ;

    //@Column(name="FI_TEN_TUYEN", length=255)
    private String     fiTenTuyen   ;

    //@Column(name="FI_BEN_DI", length=255)
    private String     fiBenDi      ;

    //@Column(name="FI_MA_TINH_DI", length=255)
    private String     fiMaTinhDi   ;

    //@Column(name="FI_TEN_TINH_DI", length=255)
    private String     fiTenTinhDi  ;

    //@Column(name="FI_BEN_DEN", length=255)
    private String     fiBenDen     ;

    //@Column(name="FI_MA_TINH_DEN", length=255)
    private String     fiMaTinhDen  ;

    //@Column(name="FI_TEN_TINH_DEN", length=255)
    private String     fiTenTinhDen ;

    //@Column(name="FI_KHOANGCACH", length=255)
    private String     fiKhoangcach ;

    //@Column(name="FI_HANHTRINH", length=255)
    private String     fiHanhtrinh  ;

    //@Column(name="FI_DIEM_DUNG", length=255)
    private String     fiDiemDung   ;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAYGUI")
    private Date       fiNgaygui    ;

    //@Column(name="FI_HOATDONG")
    private Long fiHoatdong   ;

    //@Column(name="FI_NGUOITAO", length=50)
    private String     fiNguoitao   ;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAYTAO")
    private Date       fiNgaytao    ;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NG_CAPNHAT")
    private Date       fiNgCapnhat  ;

    //@Column(name="FI_TRANGTHAI")
    private Long fiTrangthai  ;

    //@Column(name="FI_TEN_TT", length=500)
    private String     fiTenTt      ;

    //@Column(name="FI_SO_VB", length=255)
    private String     fiSoVb       ;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="FI_NGAYCAP_VB")
    private Date       fiNgaycapVb  ;

    //@Transient
    private List<TbdhsXe44> lstXe;
    
    //@Transient
    private List<TbdhsDinhkem44> lstDinhKem;

    //@Transient
    private TbdhsDnky44 chuKyDoanhNghiep;

    public Tbdhoso44() {
		super();
    }
    
    public void setFiIdHoso( Long fiIdHoso ) {
        this.fiIdHoso = fiIdHoso ;
    }
    public Long getFiIdHoso() {
        return this.fiIdHoso;
    }

    public void setFiMaHoso( String fiMaHoso ) {
        this.fiMaHoso = fiMaHoso;
    }
    public String getFiMaHoso() {
        return this.fiMaHoso;
    }

    public void setFiIdThutuc( Long fiIdThutuc ) {
        this.fiIdThutuc = fiIdThutuc;
    }
    public Long getFiIdThutuc() {
        return this.fiIdThutuc;
    }

    public void setFiMaThutuc( String fiMaThutuc ) {
        this.fiMaThutuc = fiMaThutuc;
    }
    public String getFiMaThutuc() {
        return this.fiMaThutuc;
    }

    public void setFiTenThutuc( String fiTenThutuc ) {
        this.fiTenThutuc = fiTenThutuc;
    }
    public String getFiTenThutuc() {
        return this.fiTenThutuc;
    }

    public void setFiMaCqxl( String fiMaCqxl ) {
        this.fiMaCqxl = fiMaCqxl;
    }
    public String getFiMaCqxl() {
        return this.fiMaCqxl;
    }

    public void setFiTenCqxl( String fiTenCqxl ) {
        this.fiTenCqxl = fiTenCqxl;
    }
    public String getFiTenCqxl() {
        return this.fiTenCqxl;
    }

    public void setFiTenDn( String fiTenDn ) {
        this.fiTenDn = fiTenDn;
    }
    public String getFiTenDn() {
        return this.fiTenDn;
    }

    public void setFiSoGtVb( String fiSoGtVb ) {
        this.fiSoGtVb = fiSoGtVb;
    }
    public String getFiSoGtVb() {
        return this.fiSoGtVb;
    }

    public void setFiDiachiDn( String fiDiachiDn ) {
        this.fiDiachiDn = fiDiachiDn;
    }
    public String getFiDiachiDn() {
        return this.fiDiachiDn;
    }

    public void setFiSdtDn( String fiSdtDn ) {
        this.fiSdtDn = fiSdtDn;
    }
    public String getFiSdtDn() {
        return this.fiSdtDn;
    }

    public void setFiMstDn( String fiMstDn ) {
        this.fiMstDn = fiMstDn;
    }
    public String getFiMstDn() {
        return this.fiMstDn;
    }

    public void setFiWebDn( String fiWebDn ) {
        this.fiWebDn = fiWebDn;
    }
    public String getFiWebDn() {
        return this.fiWebDn;
    }

    public String getFiFaxDn() {
        return fiFaxDn;
    }

    public void setFiFaxDn(String fiFaxDn) {
        this.fiFaxDn = fiFaxDn;
    }

    public String getFiEmailDn() {
        return fiEmailDn;
    }

    public void setFiEmailDn(String fiEmailDn) {
        this.fiEmailDn = fiEmailDn;
    }

    public void setFiSoGpVtdb( String fiSoGpVtdb ) {
        this.fiSoGpVtdb = fiSoGpVtdb;
    }
    public String getFiSoGpVtdb() {
        return this.fiSoGpVtdb;
    }

    public void setFiNgaycapGp( Date fiNgaycapGp ) {
        this.fiNgaycapGp = fiNgaycapGp;
    }
    public Date getFiNgaycapGp() {
        return this.fiNgaycapGp;
    }

    public void setFiCqcapGp( String fiCqcapGp ) {
        this.fiCqcapGp = fiCqcapGp;
    }
    public String getFiCqcapGp() {
        return this.fiCqcapGp;
    }

    public void setFiMaTuyen( String fiMaTuyen ) {
        this.fiMaTuyen = fiMaTuyen;
    }
    public String getFiMaTuyen() {
        return this.fiMaTuyen;
    }

    public void setFiTenTuyen( String fiTenTuyen ) {
        this.fiTenTuyen = fiTenTuyen;
    }
    public String getFiTenTuyen() {
        return this.fiTenTuyen;
    }

    public void setFiBenDi( String fiBenDi ) {
        this.fiBenDi = fiBenDi;
    }
    public String getFiBenDi() {
        return this.fiBenDi;
    }

    public void setFiMaTinhDi( String fiMaTinhDi ) {
        this.fiMaTinhDi = fiMaTinhDi;
    }
    public String getFiMaTinhDi() {
        return this.fiMaTinhDi;
    }

    public void setFiTenTinhDi( String fiTenTinhDi ) {
        this.fiTenTinhDi = fiTenTinhDi;
    }
    public String getFiTenTinhDi() {
        return this.fiTenTinhDi;
    }

    public void setFiBenDen( String fiBenDen ) {
        this.fiBenDen = fiBenDen;
    }
    public String getFiBenDen() {
        return this.fiBenDen;
    }

    public void setFiMaTinhDen( String fiMaTinhDen ) {
        this.fiMaTinhDen = fiMaTinhDen;
    }
    public String getFiMaTinhDen() {
        return this.fiMaTinhDen;
    }

    public void setFiTenTinhDen( String fiTenTinhDen ) {
        this.fiTenTinhDen = fiTenTinhDen;
    }
    public String getFiTenTinhDen() {
        return this.fiTenTinhDen;
    }

    public void setFiKhoangcach( String fiKhoangcach ) {
        this.fiKhoangcach = fiKhoangcach;
    }
    public String getFiKhoangcach() {
        return this.fiKhoangcach;
    }

    public void setFiHanhtrinh( String fiHanhtrinh ) {
        this.fiHanhtrinh = fiHanhtrinh;
    }
    public String getFiHanhtrinh() {
        return this.fiHanhtrinh;
    }

    public void setFiDiemDung( String fiDiemDung ) {
        this.fiDiemDung = fiDiemDung;
    }
    public String getFiDiemDung() {
        return this.fiDiemDung;
    }

    public void setFiNgaygui( Date fiNgaygui ) {
        this.fiNgaygui = fiNgaygui;
    }
    public Date getFiNgaygui() {
        return this.fiNgaygui;
    }

    public void setFiHoatdong( Long fiHoatdong ) {
        this.fiHoatdong = fiHoatdong;
    }
    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    public void setFiNguoitao( String fiNguoitao ) {
        this.fiNguoitao = fiNguoitao;
    }
    public String getFiNguoitao() {
        return this.fiNguoitao;
    }

    public void setFiNgaytao( Date fiNgaytao ) {
        this.fiNgaytao = fiNgaytao;
    }
    public Date getFiNgaytao() {
        return this.fiNgaytao;
    }

    public void setFiNgCapnhat( Date fiNgCapnhat ) {
        this.fiNgCapnhat = fiNgCapnhat;
    }
    public Date getFiNgCapnhat() {
        return this.fiNgCapnhat;
    }

    public void setFiTrangthai( Long fiTrangthai ) {
        this.fiTrangthai = fiTrangthai;
    }
    public Long getFiTrangthai() {
        return this.fiTrangthai;
    }

    public void setFiTenTt( String fiTenTt ) {
        this.fiTenTt = fiTenTt;
    }
    public String getFiTenTt() {
        return this.fiTenTt;
    }

    public void setFiSoVb( String fiSoVb ) {
        this.fiSoVb = fiSoVb;
    }
    public String getFiSoVb() {
        return this.fiSoVb;
    }

    public void setFiNgaycapVb( Date fiNgaycapVb ) {
        this.fiNgaycapVb = fiNgaycapVb;
    }
    public Date getFiNgaycapVb() {
        return this.fiNgaycapVb;
    }

    public List<TbdhsXe44> getLstXe() {
        return lstXe;
    }

    public void setLstXe(List<TbdhsXe44> lstXe) {
        this.lstXe = lstXe;
    }

    public List<TbdhsDinhkem44> getLstDinhKem() {
        return lstDinhKem;
    }

    public void setLstDinhKem(List<TbdhsDinhkem44> lstDinhKem) {
        this.lstDinhKem = lstDinhKem;
    }

    public TbdhsDnky44 getChuKyDoanhNghiep() {
        return chuKyDoanhNghiep;
    }

    public void setChuKyDoanhNghiep(TbdhsDnky44 chuKyDoanhNghiep) {
        this.chuKyDoanhNghiep = chuKyDoanhNghiep;
    }

}
