/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p01.model;


import com.nsw.annotations.*;
import java.util.Date;


/**
 *
 * @author Phong84NV
 */
public class Tbdhanghoa1 extends AbstractEntity{

    private Long fiIdHh;
    private String fiMaHh;
    
    @Mandatory
    @FieldName(name = "fiManhom")
    @Maxlength(maxLength = 20)
    @ExcelColRow(row = 0, col = 2, sheetName = "HH")
    private String fiManhom;
    
    @Mandatory
    @FieldName(name = "fiNhomHh")
    @Maxlength(maxLength = 255)
    @ExcelColRow(row = 0, col = 2, sheetName = "HH")
    private String fiNhomHh;
    
    @Mandatory
    @FieldName(name = "fiTenHh")
    @Maxlength(maxLength = 255)
    @ExcelColRow(row = 0, col = 3, sheetName = "HH")
    private String fiTenHh;
    
    @Mandatory
    @FieldName(name = "fiNhanHh")
    @Maxlength(maxLength = 255)
    @ExcelColRow(row = 0, col = 5, sheetName = "HH")
    private String fiNhanHh;
    
    @Mandatory
    @FieldName(name = "fiKyhieu")
    @Maxlength(maxLength = 255)
    @ExcelColRow(row = 0, col = 4, sheetName = "HH")
    private String fiKyhieu;
    
    @Mandatory
    @FieldName(name = "fiThongsoKt")
    @Maxlength(maxLength = 255)
    @ExcelColRow(row = 0, col = 12, sheetName = "HH")
    private String fiThongsoKt;
    
    @Mandatory
    @FieldName(name = "fiMaQg")
    @Maxlength(maxLength = 3)
    @ExcelColRow(row = 0, col = 6, sheetName = "HH")
    private String fiMaQg;
    
    @Mandatory
    @FieldName(name = "fiTenQg")
    @Maxlength(maxLength = 255)
    @ExcelColRow(row = 0, col = 7, sheetName = "HH")
    private String fiTenQg;
    
    @FieldName(name = "fiTenNsx")
    @Maxlength(maxLength = 255)
    @ExcelColRow(row = 0, col = 8, sheetName = "HH")
    private String fiTenNsx;
    
    @Mandatory
    @FieldName(name = "fiKlSl")
    @DecimalNumber(precision = 15, scale = 4)
    @Maxlength(maxLength = 20)
    @ExcelColRow(row = 0, col = 9, sheetName = "HH")
    private String fiKlSl;
    
    @Mandatory
    @FieldName(name = "fiMaDv")
    @Maxlength(maxLength = 20)
    @ExcelColRow(row = 0, col = 10, sheetName = "HH")
    private String fiMaDv;
    
    @Mandatory
    @FieldName(name = "fiTenDv")
    @Maxlength(maxLength = 100)
    @ExcelColRow(row = 0, col = 11, sheetName = "HH")
    private String fiTenDv;
    
    @Mandatory
    @FieldName(name = "fiMaHs")
    @Maxlength(maxLength = 12)
    @ExcelColRow(row = 0, col = 13, sheetName = "HH")
    private String fiMaHs;
    
    @FieldName(name = "fiGhiChu")
    @Maxlength(maxLength = 500)
    @ExcelColRow(row = 0, col = 16, sheetName = "HH")
    private String fiGhiChu;
    
    @Mandatory
    @FieldName(name = "fiCoGcn")
    @Maxlength(maxLength = 1)
    @ExcelColRow(row = 0, col = 14, sheetName = "HH")
    private Long fiCoGcn;
    
    @FieldName(name = "fiMaMk")
    @Maxlength(maxLength = 2)
    @ExcelColRow(row = 0, col = 15, sheetName = "HH")
    private String fiMaMk;
    
    @FieldName(name = "fiLoaiMk")
    @Maxlength(maxLength = 500)   
    @ExcelColRow(row = 0, col = 15, sheetName = "HH")
    private String fiLoaiMk;
    
    private Long fiIdHoso;
    private Date fiNgaytao;
    private Long fiHoatdong;
    private String fiNguoitao;
    private String fiPtchungnhan;
    private Long fiKqdanhgia;
    private Long fiKqkiemtra;
    private Long fiMatcGdlai;
    private String fiTetcGdlai;
    private String fiLydo;
    private String fiMaql;
    private Long fiIdDinhkem;
    private Long fiIdTk;
    private String fiSoTk;
    private Long stt;

    public Long getFiIdHh() {
        return fiIdHh;
    }

    public void setFiIdHh(Long fiIdHh) {
        this.fiIdHh = fiIdHh;
    }

    public String getFiMaHh() {
        return fiMaHh;
    }

    public void setFiMaHh(String fiMaHh) {
        this.fiMaHh = fiMaHh;
    }

    public String getFiManhom() {
        return fiManhom;
    }

    public void setFiManhom(String fiManhom) {
        this.fiManhom = fiManhom;
    }

    public String getFiNhomHh() {
        return fiNhomHh;
    }

    public void setFiNhomHh(String fiNhomHh) {
        this.fiNhomHh = fiNhomHh;
    }

    public String getFiTenHh() {
        return fiTenHh;
    }

    public void setFiTenHh(String fiTenHh) {
        this.fiTenHh = fiTenHh;
    }

    public String getFiNhanHh() {
        return fiNhanHh;
    }

    public void setFiNhanHh(String fiNhanHh) {
        this.fiNhanHh = fiNhanHh;
    }

    public String getFiKyhieu() {
        return fiKyhieu;
    }

    public void setFiKyhieu(String fiKyhieu) {
        this.fiKyhieu = fiKyhieu;
    }

    public String getFiThongsoKt() {
        return fiThongsoKt;
    }

    public void setFiThongsoKt(String fiThongsoKt) {
        this.fiThongsoKt = fiThongsoKt;
    }

    public String getFiMaQg() {
        return fiMaQg;
    }

    public void setFiMaQg(String fiMaQg) {
        this.fiMaQg = fiMaQg;
    }

    public String getFiTenQg() {
        return fiTenQg;
    }

    public void setFiTenQg(String fiTenQg) {
        this.fiTenQg = fiTenQg;
    }

    public String getFiTenNsx() {
        return fiTenNsx;
    }

    public void setFiTenNsx(String fiTenNsx) {
        this.fiTenNsx = fiTenNsx;
    }

    public String getFiKlSl() {
        return fiKlSl;
    }

    public void setFiKlSl(String fiKlSl) {
        this.fiKlSl = fiKlSl;
    }

    public String getFiMaDv() {
        return fiMaDv;
    }

    public void setFiMaDv(String fiMaDv) {
        this.fiMaDv = fiMaDv;
    }

    public String getFiTenDv() {
        return fiTenDv;
    }

    public void setFiTenDv(String fiTenDv) {
        this.fiTenDv = fiTenDv;
    }

    public String getFiMaHs() {
        return fiMaHs;
    }

    public void setFiMaHs(String fiMaHs) {
        this.fiMaHs = fiMaHs;
    }

    public String getFiGhiChu() {
        return fiGhiChu;
    }

    public void setFiGhiChu(String fiGhiChu) {
        this.fiGhiChu = fiGhiChu;
    }

    public Long getFiCoGcn() {
        return fiCoGcn;
    }

    public void setFiCoGcn(Long fiCoGcn) {
        this.fiCoGcn = fiCoGcn;
    }

    public String getFiMaMk() {
        return fiMaMk;
    }

    public void setFiMaMk(String fiMaMk) {
        this.fiMaMk = fiMaMk;
    }

    public String getFiLoaiMk() {
        return fiLoaiMk;
    }

    public void setFiLoaiMk(String fiLoaiMk) {
        this.fiLoaiMk = fiLoaiMk;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
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

    public String getFiPtchungnhan() {
        return fiPtchungnhan;
    }

    public void setFiPtchungnhan(String fiPtchungnhan) {
        this.fiPtchungnhan = fiPtchungnhan;
    }

    public Long getFiKqdanhgia() {
        return fiKqdanhgia;
    }

    public void setFiKqdanhgia(Long fiKqdanhgia) {
        this.fiKqdanhgia = fiKqdanhgia;
    }

    public Long getFiKqkiemtra() {
        return fiKqkiemtra;
    }

    public void setFiKqkiemtra(Long fiKqkiemtra) {
        this.fiKqkiemtra = fiKqkiemtra;
    }

    public Long getFiMatcGdlai() {
        return fiMatcGdlai;
    }

    public void setFiMatcGdlai(Long fiMatcGdlai) {
        this.fiMatcGdlai = fiMatcGdlai;
    }

    public String getFiTetcGdlai() {
        return fiTetcGdlai;
    }

    public void setFiTetcGdlai(String fiTetcGdlai) {
        this.fiTetcGdlai = fiTetcGdlai;
    }

    public String getFiLydo() {
        return fiLydo;
    }

    public void setFiLydo(String fiLydo) {
        this.fiLydo = fiLydo;
    }

    public Long getStt() {
        return stt;
    }

    public void setStt(Long stt) {
        this.stt = stt;
    }

    public Long getFiIdDinhkem() {
        return fiIdDinhkem;
    }

    public void setFiIdDinhkem(Long fiIdDinhkem) {
        this.fiIdDinhkem = fiIdDinhkem;
    }

    public Long getFiIdTk() {
        return fiIdTk;
    }

    public void setFiIdTk(Long fiIdTk) {
        this.fiIdTk = fiIdTk;
    }

    public String getFiSoTk() {
        return fiSoTk;
    }

    public void setFiSoTk(String fiSoTk) {
        this.fiSoTk = fiSoTk;
    }

    public String getFiMaql() {
        return fiMaql;
    }

    public void setFiMaql(String fiMaql) {
        this.fiMaql = fiMaql;
    }

}
