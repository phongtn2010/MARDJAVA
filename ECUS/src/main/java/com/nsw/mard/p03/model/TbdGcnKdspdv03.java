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
public class TbdGcnKdspdv03 {

    private Long id;
    private Long fiIdHoso;
    private String fiMaHoso;
    private Long fiTrangthai;
    private String fiTenTrangthai;
    private String fiLydo;
    private String fiMaCqxl;
    private String fiTenCqxl;
    private String fiSoGcn;
    private String fiTenNgXh;
    private String fiTenChuhang;
    private String fiDiachiChuhang;
    private String fiNguoiNhanhang;
    private String fiTenCkx;
    private String fiMaCkx;
    private String fiTenCkn;
    private String fiMaCkn;
    private Date fiTgTung;
    private Date fiTgDenng;
    private String fiSoContainer;
    private String fiLotrinh;
    private Date fiGiatriDenng;
    private String fiBacsy;
    private Date fiNgayky;
    private String fiNguoiky;
    private String fiNoiky;
    private Long fiHoatdong;
    private Date fiNgaytao;
    private String fiNguoitao;
    private List<TbdGcnKdspdvHh03> lstHanghoaSpdv;
    private TbdGcnKdspdvXnck03 tbdGcnKdspdvXnck03;

    public TbdGcnKdspdv03() {
    }

    public TbdGcnKdspdv03(Long id) {
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

    public String getFiLydo() {
        return fiLydo;
    }

    public void setFiLydo(String fiLydo) {
        this.fiLydo = fiLydo;
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

    public String getFiSoGcn() {
        return fiSoGcn;
    }

    public void setFiSoGcn(String fiSoGcn) {
        this.fiSoGcn = fiSoGcn;
    }

    public String getFiTenNgXh() {
        return fiTenNgXh;
    }

    public void setFiTenNgXh(String fiTenNgXh) {
        this.fiTenNgXh = fiTenNgXh;
    }

    public String getFiTenChuhang() {
        return fiTenChuhang;
    }

    public void setFiTenChuhang(String fiTenChuhang) {
        this.fiTenChuhang = fiTenChuhang;
    }

    public String getFiDiachiChuhang() {
        return fiDiachiChuhang;
    }

    public void setFiDiachiChuhang(String fiDiachiChuhang) {
        this.fiDiachiChuhang = fiDiachiChuhang;
    }

    public String getFiNguoiNhanhang() {
        return fiNguoiNhanhang;
    }

    public void setFiNguoiNhanhang(String fiNguoiNhanhang) {
        this.fiNguoiNhanhang = fiNguoiNhanhang;
    }

    public String getFiTenCkx() {
        return fiTenCkx;
    }

    public void setFiTenCkx(String fiTenCkx) {
        this.fiTenCkx = fiTenCkx;
    }

    public String getFiMaCkx() {
        return fiMaCkx;
    }

    public void setFiMaCkx(String fiMaCkx) {
        this.fiMaCkx = fiMaCkx;
    }

    public String getFiTenCkn() {
        return fiTenCkn;
    }

    public void setFiTenCkn(String fiTenCkn) {
        this.fiTenCkn = fiTenCkn;
    }

    public String getFiMaCkn() {
        return fiMaCkn;
    }

    public void setFiMaCkn(String fiMaCkn) {
        this.fiMaCkn = fiMaCkn;
    }

    public Date getFiTgTung() {
        return fiTgTung;
    }

    public void setFiTgTung(Date fiTgTung) {
        this.fiTgTung = fiTgTung;
    }

    public Date getFiTgDenng() {
        return fiTgDenng;
    }

    public void setFiTgDenng(Date fiTgDenng) {
        this.fiTgDenng = fiTgDenng;
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

    public Date getFiGiatriDenng() {
        return fiGiatriDenng;
    }

    public void setFiGiatriDenng(Date fiGiatriDenng) {
        this.fiGiatriDenng = fiGiatriDenng;
    }

    public String getFiBacsy() {
        return fiBacsy;
    }

    public void setFiBacsy(String fiBacsy) {
        this.fiBacsy = fiBacsy;
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

    public List<TbdGcnKdspdvHh03> getLstHanghoaSpdv() {
        return lstHanghoaSpdv;
    }

    public void setLstHanghoaSpdv(List<TbdGcnKdspdvHh03> lstHanghoaSpdv) {
        this.lstHanghoaSpdv = lstHanghoaSpdv;
    }

    public TbdGcnKdspdvXnck03 getTbdGcnKdspdvXnck03() {
        return tbdGcnKdspdvXnck03;
    }

    public void setTbdGcnKdspdvXnck03(TbdGcnKdspdvXnck03 tbdGcnKdspdvXnck03) {
        this.tbdGcnKdspdvXnck03 = tbdGcnKdspdvXnck03;
    }
}
