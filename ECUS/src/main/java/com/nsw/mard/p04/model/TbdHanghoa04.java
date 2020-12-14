package com.nsw.mard.p04.model;

import java.math.BigDecimal;

public class TbdHanghoa04 {
    private Long fiIdHh;
    private Long fiIdHoso;
    private String fiMaHoso;

    //don 1
    private String fiMaHang; // dung 1 2 3 4
    private String fiTenHang; // dung 1 2 3 4
    private String fiTenhangKhac; // dung 1 2 3 4
    private String fiTenchitietHanghoa; // dung 1 2 3 4
    // luu y nhom hang hoa day la loai hang cua don 2 truoc kia
    private String fiMaNhomHh; // dung 1 2
    private String fiTenNhomHh; // dung 1 2
    private String fiTenNhomHhKhac; // dung 1 2
    private String fiTenKhoahoc; // dung 1 2 3
    private Long fiSoluong; // dung 1 2 3 4
    private String fiMaBaobi; // dung 1 2 3 4
    private String fiTenBaobi; // dung 1 2 3 4
    private BigDecimal fiKhoiluongTinh; // dung 1 2 3 4
    private String fiMaDvKlTinh; // dung 1 2 3 4
    private String fiTenDvKlTinh; // dung 1 2 3 4
    private String fiKlTinhTheoTan;
    private BigDecimal fiKhoiluongBaoBi; // dung 1 2 3 4
    private String fiMaDvKlBaobi; // dung 1 2 3 4
    private String fiTenDvKlBaobi; // dung 1 2 3 4
    private String fiKlCabiTheoTan;
    private String fiTenCosoSx; // dung 1 2 3 4
    private String fiMasoNhasanxuat; // dung 1 3
    private String fiDiachiCosoSx; // dung 1 2 3 4
    private String fiMaHs; // dung 1 2 3 4

    // don 2
    private Long fiMaBophanSd; // dung 2 3
    private String fiTenBophanSd; // dung 2 3
    private String fiTenBophanSdKhac;
    private String fiMasoThucan;
    private String fiMaNuocXx;
    private String fiNuocXuatxu;
    private BigDecimal fiGiatriHh;
    private String fiMaDvTiente;
    private String fiTenDvTiente;

    // don 3
    // danh muc nhom san pham o don 3 4 nay dung chung voi danh muc nhom hang hoa o don 1 va 2
    private String fiMaNhomSp; // dung 3 4
    private String fiNhomSp; // dung 3 4
    private String fiNhomSpKhac; // dung 3 4
    private String fiMaPhuongthucKt; // dung 3 4
    private String fiPhuongthucKt; // dung 3 4
    private String fiSoVbPhuongthuc; // dung 3 4

    private Long fiHoatdong;

    public Long getFiIdHh() {
        return fiIdHh;
    }

    public void setFiIdHh(Long fiIdHh) {
        this.fiIdHh = fiIdHh;
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

    public String getFiMaHang() {
        return fiMaHang;
    }

    public void setFiMaHang(String fiMaHang) {
        this.fiMaHang = fiMaHang;
    }

    public String getFiTenHang() {
        return fiTenHang;
    }

    public void setFiTenHang(String fiTenHang) {
        this.fiTenHang = fiTenHang;
    }

    public String getFiTenhangKhac() {
        return fiTenhangKhac;
    }

    public void setFiTenhangKhac(String fiTenhangKhac) {
        this.fiTenhangKhac = fiTenhangKhac;
    }

    public String getFiTenchitietHanghoa() {
        return fiTenchitietHanghoa;
    }

    public void setFiTenchitietHanghoa(String fiTenchitietHanghoa) {
        this.fiTenchitietHanghoa = fiTenchitietHanghoa;
    }

    public String getFiMaNhomHh() {
        return fiMaNhomHh;
    }

    public void setFiMaNhomHh(String fiMaNhomHh) {
        this.fiMaNhomHh = fiMaNhomHh;
    }

    public String getFiTenNhomHh() {
        return fiTenNhomHh;
    }

    public void setFiTenNhomHh(String fiTenNhomHh) {
        this.fiTenNhomHh = fiTenNhomHh;
    }

    public String getFiTenNhomHhKhac() {
        return fiTenNhomHhKhac;
    }

    public void setFiTenNhomHhKhac(String fiTenNhomHhKhac) {
        this.fiTenNhomHhKhac = fiTenNhomHhKhac;
    }

    public String getFiTenKhoahoc() {
        return fiTenKhoahoc;
    }

    public void setFiTenKhoahoc(String fiTenKhoahoc) {
        this.fiTenKhoahoc = fiTenKhoahoc;
    }

    public Long getFiSoluong() {
        return fiSoluong;
    }

    public void setFiSoluong(Long fiSoluong) {
        this.fiSoluong = fiSoluong;
    }

    public String getFiMaBaobi() {
        return fiMaBaobi;
    }

    public void setFiMaBaobi(String fiMaBaobi) {
        this.fiMaBaobi = fiMaBaobi;
    }

    public String getFiTenBaobi() {
        return fiTenBaobi;
    }

    public void setFiTenBaobi(String fiTenBaobi) {
        this.fiTenBaobi = fiTenBaobi;
    }

    public BigDecimal getFiKhoiluongTinh() {
        return fiKhoiluongTinh;
    }

    public void setFiKhoiluongTinh(BigDecimal fiKhoiluongTinh) {
        this.fiKhoiluongTinh = fiKhoiluongTinh;
    }

    public String getFiMaDvKlTinh() {
        return fiMaDvKlTinh;
    }

    public void setFiMaDvKlTinh(String fiMaDvKlTinh) {
        this.fiMaDvKlTinh = fiMaDvKlTinh;
    }

    public String getFiTenDvKlTinh() {
        return fiTenDvKlTinh;
    }

    public void setFiTenDvKlTinh(String fiTenDvKlTinh) {
        this.fiTenDvKlTinh = fiTenDvKlTinh;
    }

    public BigDecimal getFiKhoiluongBaoBi() {
        return fiKhoiluongBaoBi;
    }

    public void setFiKhoiluongBaoBi(BigDecimal fiKhoiluongBaoBi) {
        this.fiKhoiluongBaoBi = fiKhoiluongBaoBi;
    }

    public String getFiMaDvKlBaobi() {
        return fiMaDvKlBaobi;
    }

    public void setFiMaDvKlBaobi(String fiMaDvKlBaobi) {
        this.fiMaDvKlBaobi = fiMaDvKlBaobi;
    }

    public String getFiTenDvKlBaobi() {
        return fiTenDvKlBaobi;
    }

    public void setFiTenDvKlBaobi(String fiTenDvKlBaobi) {
        this.fiTenDvKlBaobi = fiTenDvKlBaobi;
    }

    public String getFiTenCosoSx() {
        return fiTenCosoSx;
    }

    public void setFiTenCosoSx(String fiTenCosoSx) {
        this.fiTenCosoSx = fiTenCosoSx;
    }

    public String getFiMasoNhasanxuat() {
        return fiMasoNhasanxuat;
    }

    public void setFiMasoNhasanxuat(String fiMasoNhasanxuat) {
        this.fiMasoNhasanxuat = fiMasoNhasanxuat;
    }

    public String getFiDiachiCosoSx() {
        return fiDiachiCosoSx;
    }

    public void setFiDiachiCosoSx(String fiDiachiCosoSx) {
        this.fiDiachiCosoSx = fiDiachiCosoSx;
    }

    public String getFiMaHs() {
        return fiMaHs;
    }

    public void setFiMaHs(String fiMaHs) {
        this.fiMaHs = fiMaHs;
    }

    public Long getFiMaBophanSd() {
        return fiMaBophanSd;
    }

    public void setFiMaBophanSd(Long fiMaBophanSd) {
        this.fiMaBophanSd = fiMaBophanSd;
    }

    public String getFiTenBophanSd() {
        return fiTenBophanSd;
    }

    public void setFiTenBophanSd(String fiTenBophanSd) {
        this.fiTenBophanSd = fiTenBophanSd;
    }

    public String getFiMasoThucan() {
        return fiMasoThucan;
    }

    public void setFiMasoThucan(String fiMasoThucan) {
        this.fiMasoThucan = fiMasoThucan;
    }

    public String getFiMaNuocXx() {
        return fiMaNuocXx;
    }

    public void setFiMaNuocXx(String fiMaNuocXx) {
        this.fiMaNuocXx = fiMaNuocXx;
    }

    public String getFiNuocXuatxu() {
        return fiNuocXuatxu;
    }

    public void setFiNuocXuatxu(String fiNuocXuatxu) {
        this.fiNuocXuatxu = fiNuocXuatxu;
    }

    public BigDecimal getFiGiatriHh() {
        return fiGiatriHh;
    }

    public void setFiGiatriHh(BigDecimal fiGiatriHh) {
        this.fiGiatriHh = fiGiatriHh;
    }

    public String getFiMaDvTiente() {
        return fiMaDvTiente;
    }

    public void setFiMaDvTiente(String fiMaDvTiente) {
        this.fiMaDvTiente = fiMaDvTiente;
    }

    public String getFiTenDvTiente() {
        return fiTenDvTiente;
    }

    public void setFiTenDvTiente(String fiTenDvTiente) {
        this.fiTenDvTiente = fiTenDvTiente;
    }

    public String getFiMaNhomSp() {
        return fiMaNhomSp;
    }

    public void setFiMaNhomSp(String fiMaNhomSp) {
        this.fiMaNhomSp = fiMaNhomSp;
    }

    public String getFiNhomSp() {
        return fiNhomSp;
    }

    public void setFiNhomSp(String fiNhomSp) {
        this.fiNhomSp = fiNhomSp;
    }

    public String getFiMaPhuongthucKt() {
        return fiMaPhuongthucKt;
    }

    public void setFiMaPhuongthucKt(String fiMaPhuongthucKt) {
        this.fiMaPhuongthucKt = fiMaPhuongthucKt;
    }

    public String getFiPhuongthucKt() {
        return fiPhuongthucKt;
    }

    public void setFiPhuongthucKt(String fiPhuongthucKt) {
        this.fiPhuongthucKt = fiPhuongthucKt;
    }

    public String getFiSoVbPhuongthuc() {
        return fiSoVbPhuongthuc;
    }

    public void setFiSoVbPhuongthuc(String fiSoVbPhuongthuc) {
        this.fiSoVbPhuongthuc = fiSoVbPhuongthuc;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public String getFiNhomSpKhac() {
        return fiNhomSpKhac;
    }

    public void setFiNhomSpKhac(String fiNhomSpKhac) {
        this.fiNhomSpKhac = fiNhomSpKhac;
    }

    public String getFiKlTinhTheoTan() {
        return fiKlTinhTheoTan;
    }

    public void setFiKlTinhTheoTan(String fiKlTinhTheoTan) {
        this.fiKlTinhTheoTan = fiKlTinhTheoTan;
    }

    public String getFiKlCabiTheoTan() {
        return fiKlCabiTheoTan;
    }

    public void setFiKlCabiTheoTan(String fiKlCabiTheoTan) {
        this.fiKlCabiTheoTan = fiKlCabiTheoTan;
    }

    public String getFiTenBophanSdKhac() {
        return fiTenBophanSdKhac;
    }

    public void setFiTenBophanSdKhac(String fiTenBophanSdKhac) {
        this.fiTenBophanSdKhac = fiTenBophanSdKhac;
    }
}