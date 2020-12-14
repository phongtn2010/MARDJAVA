/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p01.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nsw.annotations.*;
import com.nsw.util.CustomJsonDateDeserializer;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Phong84NV
 */
public class Tbdhoso1 extends AbstractEntity {

    private Long fiIdHoso;
    private Long fiIdTckt;
    
    @Mandatory
    @FieldName(name="fiMaTckt")
    @ExcelColRow(row = 2, col = 2, sheetName = "HS")
    private String fiMaTckt;
    
    private Long fiDocumenttype;
    
    private String fiMaHoSo;    
    
    @Mandatory
    @FieldName(name="fiTenTcht")
    @ExcelColRow(row = 2, col = 2, sheetName = "HS")
    private String fiTenTcht;  
        
    @FieldName(name="fiMst")
    @Maxlength(maxLength = 13)  
    private String fiMst;
    
    @FieldName(name="fiNguoiNk")
    @Maxlength(maxLength = 255)  
    private String fiNguoiNk;    
    
    @FieldName(name="fiDiachiNnk")
    @Maxlength(maxLength = 255)    
    private String fiDiachiNnk;
    
    @Mandatory
    @FieldName(name="fiDtNnk")
    @Maxlength(maxLength = 50)
    @ExcelColRow(row = 3, col = 4, sheetName = "HS")
    private String fiDtNnk;
    
    @FieldName(name="fiFaxNnk")
    @Maxlength(maxLength = 50)
    @ExcelColRow(row = 3, col = 2, sheetName = "HS")
    private String fiFaxNnk;
    
    @FieldName(name="fiEmailNnk")
    @Maxlength(maxLength = 100)
    @Email
    @ExcelColRow(row = 4, col = 4, sheetName = "HS")
    private String fiEmailNnk;
    
    @Mandatory
    @FieldName(name="fiNguoiLh")
    @Maxlength(maxLength = 100)
    @ExcelColRow(row = 4, col = 2, sheetName = "HS")
    private String fiNguoiLh;
    
    @Mandatory
    @FieldName(name="fiTuNgay") 
    @DateAttribute
    @ExcelColRow(row = 6, col = 2, sheetName = "HS")
    private Date fiTuNgay;
    
    @Mandatory
    @FieldName(name="fiDenNgay")
    @DateAttribute
    @ExcelColRow(row = 6, col = 4, sheetName = "HS")
    private Date fiDenNgay;
    
    @FieldName(name="fiDiachiKho")
    @Maxlength(maxLength = 255)
    @ExcelColRow(row = 5, col = 2, sheetName = "HS")
    private String fiDiachiKho;
    
    @Mandatory
    @FieldName(name="fiMaQcvn")
    @Maxlength(maxLength = 50)
    @ExcelColRow(row = 7, col = 2, sheetName = "HS")
    private String fiMaQcvn;
    
    @Mandatory
    @FieldName(name="fiTenQcvn")
    @Maxlength(maxLength = 255)
    @ExcelColRow(row = 7, col = 4, sheetName = "HS")
    private String fiTenQcvn;    
    
    private Long fiIdTcdg;    
    
    @FieldName(name="fiMaTcdg")
    @Maxlength(maxLength = 20)    
    @ExcelColRow(row = 5, col = 4, sheetName = "HS")
    private String fiMaTcdg;
    
    @FieldName(name="fiTenTcdg")
    @Maxlength(maxLength = 255)
    @ExcelColRow(row = 5, col = 4, sheetName = "HS")
    private String fiTenTcdg;
    
    @FieldName(name="fiGhichu")
    @Maxlength(maxLength = 500)
    @ExcelColRow(row = 8, col = 2, sheetName = "HS")
    private String fiGhichu;
    
    private Date fiNgayThongBao;
    private String fiSoThongBao;
    
    private Date fiNgaytao;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Long fiTrangThai;
    private Date fiNgayGui;
    private Long fiIdCqxl;
    
    private List<Tbdtokhaihq1> toKhaiHQ;
    private List<Tbddinhkem1> tepDinhKem;
    private List<Tbdhanghoa1> hangHoa1;
    
    public Tbdhoso1() {
    }

    public Tbdhoso1(Long fiIdHoso, Long fiIdTckt, String fiMaTckt, 
            String fiMaHoSo, String fiTenTcht, String fiMst, String fiNguoiNk, 
            String fiDiachiNnk, String fiDtNnk, String fiFaxNnk, String fiEmailNnk, 
            String fiNguoiLh, Date fiTuNgay, Date fiDenNgay, String fiDiachiKho, 
            String fiMaQcvn, String fiTenQcvn, Long fiIdTcdg, String fiMaTcdg, 
            String fiTenTcdg, String fiGhichu, Date fiNgaytao, Long fiHoatdong, 
            String fiNguoitao, Long fiTrangThai, Date fiNgayGui, List<Tbdtokhaihq1> toKhaiHQ, 
            List<Tbddinhkem1> tepDinhKem, List<Tbdhanghoa1> hangHoa1, Long fiIdCqxl) {
        this.fiIdHoso = fiIdHoso;
        this.fiIdTckt = fiIdTckt;
        this.fiMaTckt = fiMaTckt;
        this.fiMaHoSo = fiMaHoSo;
        this.fiTenTcht = fiTenTcht;
        this.fiMst = fiMst;
        this.fiNguoiNk = fiNguoiNk;
        this.fiDiachiNnk = fiDiachiNnk;
        this.fiDtNnk = fiDtNnk;
        this.fiFaxNnk = fiFaxNnk;
        this.fiEmailNnk = fiEmailNnk;
        this.fiNguoiLh = fiNguoiLh;
        this.fiTuNgay = fiTuNgay;
        this.fiDenNgay = fiDenNgay;
        this.fiDiachiKho = fiDiachiKho;
        this.fiMaQcvn = fiMaQcvn;
        this.fiTenQcvn = fiTenQcvn;
        this.fiIdTcdg = fiIdTcdg;
        this.fiMaTcdg = fiMaTcdg;
        this.fiTenTcdg = fiTenTcdg;
        this.fiGhichu = fiGhichu;
        this.fiNgaytao = fiNgaytao;
        this.fiHoatdong = fiHoatdong;
        this.fiNguoitao = fiNguoitao;
        this.fiTrangThai = fiTrangThai;
        this.fiNgayGui = fiNgayGui;
        this.toKhaiHQ = toKhaiHQ;
        this.tepDinhKem = tepDinhKem;
        this.hangHoa1 = hangHoa1;
        this.fiIdCqxl = fiIdCqxl;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdTckt() {
        return fiIdTckt;
    }

    public void setFiIdTckt(Long fiIdTckt) {
        this.fiIdTckt = fiIdTckt;
    }

    public String getFiMaTckt() {
        return fiMaTckt;
    }

    public void setFiMaTckt(String fiMaTckt) {
        this.fiMaTckt = fiMaTckt;
    }

    public Long getFiDocumenttype() {
        return fiDocumenttype;
    }

    public void setFiDocumenttype(Long fiDocumenttype) {
        this.fiDocumenttype = fiDocumenttype;
    }

    public String getFiMaHoSo() {
        return fiMaHoSo;
    }

    public void setFiMaHoSo(String fiMaHoSo) {
        this.fiMaHoSo = fiMaHoSo;
    }

    public String getFiTenTcht() {
        return fiTenTcht;
    }

    public void setFiTenTcht(String fiTenTcht) {
        this.fiTenTcht = fiTenTcht;
    }

    public String getFiMst() {
        return fiMst;
    }

    public void setFiMst(String fiMst) {
        this.fiMst = fiMst;
    }

    public String getFiNguoiNk() {
        return fiNguoiNk;
    }

    public void setFiNguoiNk(String fiNguoiNk) {
        this.fiNguoiNk = fiNguoiNk;
    }

    public String getFiDiachiNnk() {
        return fiDiachiNnk;
    }

    public void setFiDiachiNnk(String fiDiachiNnk) {
        this.fiDiachiNnk = fiDiachiNnk;
    }

    public String getFiDtNnk() {
        return fiDtNnk;
    }

    public void setFiDtNnk(String fiDtNnk) {
        this.fiDtNnk = fiDtNnk;
    }

    public String getFiFaxNnk() {
        return fiFaxNnk;
    }

    public void setFiFaxNnk(String fiFaxNnk) {
        this.fiFaxNnk = fiFaxNnk;
    }

    public String getFiEmailNnk() {
        return fiEmailNnk;
    }

    public void setFiEmailNnk(String fiEmailNnk) {
        this.fiEmailNnk = fiEmailNnk;
    }

    public String getFiNguoiLh() {
        return fiNguoiLh;
    }

    public void setFiNguoiLh(String fiNguoiLh) {
        this.fiNguoiLh = fiNguoiLh;
    }

    public Date getFiTuNgay() {
        return fiTuNgay;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiTuNgay(Date fiTuNgay) {
        this.fiTuNgay = fiTuNgay;
    }

    public Date getFiDenNgay() {
        return fiDenNgay;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiDenNgay(Date fiDenNgay) {
        this.fiDenNgay = fiDenNgay;
    }

    public String getFiDiachiKho() {
        return fiDiachiKho;
    }

    public void setFiDiachiKho(String fiDiachiKho) {
        this.fiDiachiKho = fiDiachiKho;
    }

    public String getFiMaQcvn() {
        return fiMaQcvn;
    }

    public void setFiMaQcvn(String fiMaQcvn) {
        this.fiMaQcvn = fiMaQcvn;
    }

    public String getFiTenQcvn() {
        return fiTenQcvn;
    }

    public void setFiTenQcvn(String fiTenQcvn) {
        this.fiTenQcvn = fiTenQcvn;
    }

    public Long getFiIdTcdg() {
        return fiIdTcdg;
    }

    public void setFiIdTcdg(Long fiIdTcdg) {
        this.fiIdTcdg = fiIdTcdg;
    }

    public String getFiMaTcdg() {
        return fiMaTcdg;
    }

    public void setFiMaTcdg(String fiMaTcdg) {
        this.fiMaTcdg = fiMaTcdg;
    }

    public String getFiTenTcdg() {
        return fiTenTcdg;
    }

    public void setFiTenTcdg(String fiTenTcdg) {
        this.fiTenTcdg = fiTenTcdg;
    }

    public String getFiGhichu() {
        return fiGhichu;
    }

    public void setFiGhichu(String fiGhichu) {
        this.fiGhichu = fiGhichu;
    }
    
    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
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

    public Long getFiTrangThai() {
        return fiTrangThai;
    }

    public void setFiTrangThai(Long fiTrangThai) {
        this.fiTrangThai = fiTrangThai;
    }

    public Date getFiNgayGui() {
        return fiNgayGui;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiNgayGui(Date fiNgayGui) {
        this.fiNgayGui = fiNgayGui;
    }

    public List<Tbdtokhaihq1> getToKhaiHQ() {
        return toKhaiHQ;
    }

    public void setToKhaiHQ(List<Tbdtokhaihq1> toKhaiHQ) {
        this.toKhaiHQ = toKhaiHQ;
    }

    public List<Tbddinhkem1> getTepDinhKem() {
        return tepDinhKem;
    }

    public void setTepDinhKem(List<Tbddinhkem1> tepDinhKem) {
        this.tepDinhKem = tepDinhKem;
    }

    public List<Tbdhanghoa1> getHangHoa1() {
        return hangHoa1;
    }

    public void setHangHoa1(List<Tbdhanghoa1> hangHoa1) {
        this.hangHoa1 = hangHoa1;
    }

    public Long getFiIdCqxl() {
        return fiIdCqxl;
    }

    public void setFiIdCqxl(Long fiIdCqxl) {
        this.fiIdCqxl = fiIdCqxl;
    }

    public Date getFiNgayThongBao() {
        return fiNgayThongBao;
    }

    public void setFiNgayThongBao(Date fiNgayThongBao) {
        this.fiNgayThongBao = fiNgayThongBao;
    }

    public String getFiSoThongBao() {
        return fiSoThongBao;
    }

    public void setFiSoThongBao(String fiSoThongBao) {
        this.fiSoThongBao = fiSoThongBao;
    }
}
