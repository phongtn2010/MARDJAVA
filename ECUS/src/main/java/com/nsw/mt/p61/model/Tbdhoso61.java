/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mt.p61.model;

import java.util.Date;
import java.util.List;

public class Tbdhoso61 {

    private Long fiIdHoso;
    private String fiMaHoso;
    private String fiMaCqxl;
    private String fiTenCqxl;
    private String fiTenDn;
    private String fiDiachiDn;
    private String fiSdtDn;
    private String fiFaxDn;
    private String fiSoGp;
    private Date fiNgaycap;

    private String fiLoaihinhDn;
    private String fiLydo;

    private String fiMaTuyen;
    private String fiTenTuyen;
    private String fiBenDi;
    private String fiMaTinhDi;
    private String fiTenTinhDi;
    private String fiBenDen;
    private String fiMaTinhDen;
    private String fiTenTinhDen;
    private String fiCuly;
    private String fiSoCv;
    private Date fiNgaycapCv;
    private String fiHanhtrinh;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;
    private Date fiNgCapnhat;
    private Long fiTrangthai;
    private String fiTenTt;
    private Long fiIdThutuc;
    private String fiMaThutuc;
    private String fiTenThutuc;
    private Date fiNgaycapGp;
    private Date fiNgaygui;
    private String fiMstDn;

    private TbdhsLhvt61 loaiHinhVantai;

    private List<TbdhsXe61> lstXe;

    private List<TbdhsDinhkem61> lstDinhKem;

    private TbdhsDnky61 chuKyDoanhNghiep;

    public Tbdhoso61() {
    }

    public Tbdhoso61(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
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

    public String getFiMaCqxl() {
        return fiMaCqxl;
    }

    public void setFiMaCqxl(String fiMaCqxl) {
        this.fiMaCqxl = fiMaCqxl;
    }

    public String getFiTenCqxl() {
        return fiTenCqxl;
    }

    public void setFiTenCqxl(String fiTenCqxl) {
        this.fiTenCqxl = fiTenCqxl;
    }

    public String getFiTenDn() {
        return fiTenDn;
    }

    public void setFiTenDn(String fiTenDn) {
        this.fiTenDn = fiTenDn;
    }

    public String getFiDiachiDn() {
        return fiDiachiDn;
    }

    public void setFiDiachiDn(String fiDiachiDn) {
        this.fiDiachiDn = fiDiachiDn;
    }

    public String getFiSdtDn() {
        return fiSdtDn;
    }

    public void setFiSdtDn(String fiSdtDn) {
        this.fiSdtDn = fiSdtDn;
    }

    public String getFiFaxDn() {
        return fiFaxDn;
    }

    public void setFiFaxDn(String fiFaxDn) {
        this.fiFaxDn = fiFaxDn;
    }

    public String getFiSoGp() {
        return fiSoGp;
    }

    public void setFiSoGp(String fiSoGp) {
        this.fiSoGp = fiSoGp;
    }

    public Date getFiNgaycap() {
        return fiNgaycap;
    }

    public void setFiNgaycap(Date fiNgaycap) {
        this.fiNgaycap = fiNgaycap;
    }

    public String getFiLoaihinhDn() {
        return fiLoaihinhDn;
    }

    public void setFiLoaihinhDn(String fiLoaihinhDn) {
        this.fiLoaihinhDn = fiLoaihinhDn;
    }

    public String getFiLydo() {
        return fiLydo;
    }

    public void setFiLydo(String fiLydo) {
        this.fiLydo = fiLydo;
    }

    public String getFiMaTuyen() {
        return fiMaTuyen;
    }

    public void setFiMaTuyen(String fiMaTuyen) {
        this.fiMaTuyen = fiMaTuyen;
    }

    public String getFiTenTuyen() {
        return fiTenTuyen;
    }

    public void setFiTenTuyen(String fiTenTuyen) {
        this.fiTenTuyen = fiTenTuyen;
    }

    public String getFiBenDi() {
        return fiBenDi;
    }

    public void setFiBenDi(String fiBenDi) {
        this.fiBenDi = fiBenDi;
    }

    public String getFiMaTinhDi() {
        return fiMaTinhDi;
    }

    public void setFiMaTinhDi(String fiMaTinhDi) {
        this.fiMaTinhDi = fiMaTinhDi;
    }

    public String getFiTenTinhDi() {
        return fiTenTinhDi;
    }

    public void setFiTenTinhDi(String fiTenTinhDi) {
        this.fiTenTinhDi = fiTenTinhDi;
    }

    public String getFiBenDen() {
        return fiBenDen;
    }

    public void setFiBenDen(String fiBenDen) {
        this.fiBenDen = fiBenDen;
    }

    public String getFiMaTinhDen() {
        return fiMaTinhDen;
    }

    public void setFiMaTinhDen(String fiMaTinhDen) {
        this.fiMaTinhDen = fiMaTinhDen;
    }

    public String getFiTenTinhDen() {
        return fiTenTinhDen;
    }

    public void setFiTenTinhDen(String fiTenTinhDen) {
        this.fiTenTinhDen = fiTenTinhDen;
    }

    public String getFiCuly() {
        return fiCuly;
    }

    public void setFiCuly(String fiCuly) {
        this.fiCuly = fiCuly;
    }

    public String getFiSoCv() {
        return fiSoCv;
    }

    public void setFiSoCv(String fiSoCv) {
        this.fiSoCv = fiSoCv;
    }

    public Date getFiNgaycapCv() {
        return fiNgaycapCv;
    }

    public void setFiNgaycapCv(Date fiNgaycapCv) {
        this.fiNgaycapCv = fiNgaycapCv;
    }

    public String getFiHanhtrinh() {
        return fiHanhtrinh;
    }

    public void setFiHanhtrinh(String fiHanhtrinh) {
        this.fiHanhtrinh = fiHanhtrinh;
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

    public Date getFiNgaycapGp() {
        return fiNgaycapGp;
    }

    public void setFiNgaycapGp(Date fiNgaycapGp) {
        this.fiNgaycapGp = fiNgaycapGp;
    }

    public Date getFiNgaygui() {
        return fiNgaygui;
    }

    public void setFiNgaygui(Date fiNgaygui) {
        this.fiNgaygui = fiNgaygui;
    }

    public String getFiMstDn() {
        return fiMstDn;
    }

    public void setFiMstDn(String fiMstDn) {
        this.fiMstDn = fiMstDn;
    }

    public TbdhsLhvt61 getLoaiHinhVantai() {
        return loaiHinhVantai;
    }

    public void setLoaiHinhVantai(TbdhsLhvt61 loaiHinhVantai) {
        this.loaiHinhVantai = loaiHinhVantai;
    }

    public List<TbdhsXe61> getLstXe() {
        return lstXe;
    }

    public void setLstXe(List<TbdhsXe61> lstXe) {
        this.lstXe = lstXe;
    }

    public List<TbdhsDinhkem61> getLstDinhKem() {
        return lstDinhKem;
    }

    public void setLstDinhKem(List<TbdhsDinhkem61> lstDinhKem) {
        this.lstDinhKem = lstDinhKem;
    }

    public TbdhsDnky61 getChuKyDoanhNghiep() {
        return chuKyDoanhNghiep;
    }

    public void setChuKyDoanhNghiep(TbdhsDnky61 chuKyDoanhNghiep) {
        this.chuKyDoanhNghiep = chuKyDoanhNghiep;
    }
}
