/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p03.model;

import java.util.Date;
import java.util.List;

/**
 * @author HuongMK
 */
public class TbdGcnKiemdichDv03 {

    private Long id;
    private Long fiIdHoso;
    private String fiMaHoso;
    private String fiLydoSua;
    private String fiMaCqlx;
    private String fiTenCqxl;
    private String fiSoGcn;
    private String fiTendiachiNgXh;
    private String fiTenChuhang;
    private String fiTendiachiNgNhanhang;
    private String fiTenCkXuat;
    private String fiMaCkXuat;
    private String fiTenCkNhap;
    private String fiMaCkNhap;
    private Date fiTgLuulaiTung;
    private Date fiTgLuulaiDenng;
    private String fiTongso;
    private String fiSoContainer;
    private String fiLotrinh;
    private Date fiGiatriDen;
    private String fiBacsyThuy;
    private Date fiNgayky;
    private String fiNguoiky;
    private String fiNoiky;
    private Long fiHoatdong;
    private Date fiNgaytao;
    private String fiNguoitao;
    private String fiDiachiChuhang;
    private Long fiTrangthai;
    private String fiTenTrangthai;
    private List<TbdGcnKddvHanghoa03> lstHanghoaKddv03;
    private TbdGcnKddvXacnhanCkXuat03 tbdXNCuakhauxuat;

    public TbdGcnKiemdichDv03() {
    }

    public TbdGcnKiemdichDv03(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFiLydoSua() {
        return fiLydoSua;
    }

    public void setFiLydoSua(String fiLydoSua) {
        this.fiLydoSua = fiLydoSua;
    }

    public String getFiMaCqlx() {
        return fiMaCqlx;
    }

    public void setFiMaCqlx(String fiMaCqlx) {
        this.fiMaCqlx = fiMaCqlx;
    }

    public String getFiTenCqxl() {
        return fiTenCqxl;
    }

    public void setFiTenCqxl(String fiTenCqxl) {
        this.fiTenCqxl = fiTenCqxl;
    }

    public String getFiSoGcn() {
        return fiSoGcn;
    }

    public void setFiSoGcn(String fiSoGcn) {
        this.fiSoGcn = fiSoGcn;
    }

    public String getFiTendiachiNgXh() {
        return fiTendiachiNgXh;
    }

    public void setFiTendiachiNgXh(String fiTendiachiNgXh) {
        this.fiTendiachiNgXh = fiTendiachiNgXh;
    }

    public String getFiTenChuhang() {
        return fiTenChuhang;
    }

    public void setFiTenChuhang(String fiTenChuhang) {
        this.fiTenChuhang = fiTenChuhang;
    }

    public String getFiTendiachiNgNhanhang() {
        return fiTendiachiNgNhanhang;
    }

    public void setFiTendiachiNgNhanhang(String fiTendiachiNgNhanhang) {
        this.fiTendiachiNgNhanhang = fiTendiachiNgNhanhang;
    }

    public String getFiTenCkXuat() {
        return fiTenCkXuat;
    }

    public void setFiTenCkXuat(String fiTenCkXuat) {
        this.fiTenCkXuat = fiTenCkXuat;
    }

    public String getFiMaCkXuat() {
        return fiMaCkXuat;
    }

    public void setFiMaCkXuat(String fiMaCkXuat) {
        this.fiMaCkXuat = fiMaCkXuat;
    }

    public String getFiTenCkNhap() {
        return fiTenCkNhap;
    }

    public void setFiTenCkNhap(String fiTenCkNhap) {
        this.fiTenCkNhap = fiTenCkNhap;
    }

    public String getFiMaCkNhap() {
        return fiMaCkNhap;
    }

    public void setFiMaCkNhap(String fiMaCkNhap) {
        this.fiMaCkNhap = fiMaCkNhap;
    }

    public Date getFiTgLuulaiTung() {
        return fiTgLuulaiTung;
    }

    public void setFiTgLuulaiTung(Date fiTgLuulaiTung) {
        this.fiTgLuulaiTung = fiTgLuulaiTung;
    }

    public Date getFiTgLuulaiDenng() {
        return fiTgLuulaiDenng;
    }

    public void setFiTgLuulaiDenng(Date fiTgLuulaiDenng) {
        this.fiTgLuulaiDenng = fiTgLuulaiDenng;
    }

    public String getFiTongso() {
        return fiTongso;
    }

    public void setFiTongso(String fiTongso) {
        this.fiTongso = fiTongso;
    }

    public String getFiSoContainer() {
        return fiSoContainer;
    }

    public void setFiSoContainer(String fiSoContainer) {
        this.fiSoContainer = fiSoContainer;
    }

    public String getFiLotrinh() {
        return fiLotrinh;
    }

    public void setFiLotrinh(String fiLotrinh) {
        this.fiLotrinh = fiLotrinh;
    }

    public Date getFiGiatriDen() {
        return fiGiatriDen;
    }

    public void setFiGiatriDen(Date fiGiatriDen) {
        this.fiGiatriDen = fiGiatriDen;
    }

    public String getFiBacsyThuy() {
        return fiBacsyThuy;
    }

    public void setFiBacsyThuy(String fiBacsyThuy) {
        this.fiBacsyThuy = fiBacsyThuy;
    }

    public Date getFiNgayky() {
        return fiNgayky;
    }

    public void setFiNgayky(Date fiNgayky) {
        this.fiNgayky = fiNgayky;
    }

    public String getFiNguoiky() {
        return fiNguoiky;
    }

    public void setFiNguoiky(String fiNguoiky) {
        this.fiNguoiky = fiNguoiky;
    }

    public String getFiNoiky() {
        return fiNoiky;
    }

    public void setFiNoiky(String fiNoiky) {
        this.fiNoiky = fiNoiky;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public String getFiDiachiChuhang() {
        return fiDiachiChuhang;
    }

    public void setFiDiachiChuhang(String fiDiachiChuhang) {
        this.fiDiachiChuhang = fiDiachiChuhang;
    }

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public String getFiTenTrangthai() {
        return fiTenTrangthai;
    }

    public void setFiTenTrangthai(String fiTenTrangthai) {
        this.fiTenTrangthai = fiTenTrangthai;
    }

    public List<TbdGcnKddvHanghoa03> getLstHanghoaKddv03() {
        return lstHanghoaKddv03;
    }

    public void setLstHanghoaKddv03(List<TbdGcnKddvHanghoa03> lstHanghoaKddv03) {
        this.lstHanghoaKddv03 = lstHanghoaKddv03;
    }

    public TbdGcnKddvXacnhanCkXuat03 getTbdXNCuakhauxuat() {
        return tbdXNCuakhauxuat;
    }

    public void setTbdXNCuakhauxuat(TbdGcnKddvXacnhanCkXuat03 tbdXNCuakhauxuat) {
        this.tbdXNCuakhauxuat = tbdXNCuakhauxuat;
    }
}
