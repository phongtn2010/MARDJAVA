package com.nsw.moit.p05.model;

import java.math.BigDecimal;
import java.util.Date;

public class TbdhsNguyenlieu5 {

    private Long fiIdNl;

    //@Column(name = "FI_ID_HOSO")
    private Long fiIdHoso;
    //@Size(max = 250)
    //@Column(name = "FI_MA_NGUYENLIEU")
    private String fiMaNguyenlieu;
    //@Size(max = 250)
    //@Column(name = "FI_LOAI_NGUYENLIEU")
    private String fiLoaiNguyenlieu;
    //@Size(max = 250)
    //@Column(name = "FI_TEN_NGUYENLIEU")
    private String fiTenNguyenlieu;
    //@Size(max = 250)
    //@Column(name = "FI_DANGKY_NHAPKHAU_NAMX1")
    private BigDecimal fiDangkyNhapkhauNamx1;
    //@Size(max = 250)
    //@Column(name = "FI_SOLUONG_CAP_X1")
    private BigDecimal fiSoluongCapX1;
    //@Size(max = 250)
    //@Column(name = "FI_UOC_THUCHIEN_X1")
    private BigDecimal fiUocThuchienX1;
    //@Size(max = 250)
    //@Column(name = "FI_DANGKY_NHAPKHAU_NAMX")
    private BigDecimal fiDangkyNhapkhauNamx;
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

    public TbdhsNguyenlieu5() {
        super();
    }

    public void setFiIdHh(Long fiIdHh) {
        this.fiIdNl = fiIdHh;
    }

    public Long getFiIdHh() {
        return this.fiIdNl;
    }

    public Long getFiIdNl() {
        return fiIdNl;
    }

    public void setFiIdNl(Long fiIdNl) {
        this.fiIdNl = fiIdNl;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiMaNguyenlieu() {
        return fiMaNguyenlieu;
    }

    public void setFiMaNguyenlieu(String fiMaNguyenlieu) {
        this.fiMaNguyenlieu = fiMaNguyenlieu;
    }

    public String getFiLoaiNguyenlieu() {
        return fiLoaiNguyenlieu;
    }

    public void setFiLoaiNguyenlieu(String fiLoaiNguyenlieu) {
        this.fiLoaiNguyenlieu = fiLoaiNguyenlieu;
    }

    public String getFiTenNguyenlieu() {
        return fiTenNguyenlieu;
    }

    public void setFiTenNguyenlieu(String fiTenNguyenlieu) {
        this.fiTenNguyenlieu = fiTenNguyenlieu;
    }

    public BigDecimal getFiDangkyNhapkhauNamx1() {
        return fiDangkyNhapkhauNamx1;
    }

    public void setFiDangkyNhapkhauNamx1(BigDecimal fiDangkyNhapkhauNamx1) {
        this.fiDangkyNhapkhauNamx1 = fiDangkyNhapkhauNamx1;
    }

    public BigDecimal getFiSoluongCapX1() {
        return fiSoluongCapX1;
    }

    public void setFiSoluongCapX1(BigDecimal fiSoluongCapX1) {
        this.fiSoluongCapX1 = fiSoluongCapX1;
    }

    public BigDecimal getFiUocThuchienX1() {
        return fiUocThuchienX1;
    }

    public void setFiUocThuchienX1(BigDecimal fiUocThuchienX1) {
        this.fiUocThuchienX1 = fiUocThuchienX1;
    }

    public BigDecimal getFiDangkyNhapkhauNamx() {
        return fiDangkyNhapkhauNamx;
    }

    public void setFiDangkyNhapkhauNamx(BigDecimal fiDangkyNhapkhauNamx) {
        this.fiDangkyNhapkhauNamx = fiDangkyNhapkhauNamx;
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

}
