/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p01.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nsw.annotations.AbstractEntity;
import com.nsw.annotations.DateAttribute;
import com.nsw.annotations.ExcelColRow;
import com.nsw.annotations.FieldName;
import com.nsw.annotations.Mandatory;
import com.nsw.annotations.Maxlength;
import com.nsw.util.CustomJsonDateDeserializer;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Phong84NV
 */
public class Tbdtokhaihq1 extends AbstractEntity {

    private Long fiIdTk;
    @Mandatory
    @FieldName(name = "fiSoTk")
    @Maxlength(maxLength = 12)
    @ExcelColRow(row = 0, col = 1, sheetName = "HS")
    private String fiSoTk;
    @Mandatory
    @FieldName(name = "fiNgayDk")
    @DateAttribute
    @ExcelColRow(row = 0, col = 2, sheetName = "HS")
    private Date fiNgayDk;
    @Mandatory
    @FieldName(name = "fiMaHq")
    @Maxlength(maxLength = 6)
    @ExcelColRow(row = 0, col = 3, sheetName = "HS")
    private String fiMaHq;
    private String fiNguoiNk;
    private String fiDiachiNnk;
    private String fiDtNnk;
    private String fiNguoiXk;
    private String fiDiachiNxk;
    private String fiNuocXk;
    private String fiDdLuu;
    private String fiDdDo;
    private String fiSoVandon;
    private String fiSoHoadon;
    private Date fiNgayCapHd;
    private Double fiSoluong;
    private String fiTenDv;
    private Double fiTong;
    private String fiTenDvTl;
    private Long fiIdHoso;
    private String fiGhichu;

    private Date fiNgaytao;
    private Long fiHoatdong;
    private String fiNguoitao;

    private Long stt;

    List<Tbdtokhaihqd1> toKhaiHQD1;

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

    public Date getFiNgayDk() {
        return fiNgayDk;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiNgayDk(Date fiNgayDk) {
        this.fiNgayDk = fiNgayDk;
    }

    public String getFiMaHq() {
        return fiMaHq;
    }

    public void setFiMaHq(String fiMaHq) {
        this.fiMaHq = fiMaHq;
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

    public String getFiNguoiXk() {
        return fiNguoiXk;
    }

    public void setFiNguoiXk(String fiNguoiXk) {
        this.fiNguoiXk = fiNguoiXk;
    }

    public String getFiDiachiNxk() {
        return fiDiachiNxk;
    }

    public void setFiDiachiNxk(String fiDiachiNxk) {
        this.fiDiachiNxk = fiDiachiNxk;
    }

    public String getFiNuocXk() {
        return fiNuocXk;
    }

    public void setFiNuocXk(String fiNuocXk) {
        this.fiNuocXk = fiNuocXk;
    }

    public String getFiDdLuu() {
        return fiDdLuu;
    }

    public void setFiDdLuu(String fiDdLuu) {
        this.fiDdLuu = fiDdLuu;
    }

    public String getFiDdDo() {
        return fiDdDo;
    }

    public void setFiDdDo(String fiDdDo) {
        this.fiDdDo = fiDdDo;
    }

    public String getFiSoVandon() {
        return fiSoVandon;
    }

    public void setFiSoVandon(String fiSoVandon) {
        this.fiSoVandon = fiSoVandon;
    }

    public String getFiSoHoadon() {
        return fiSoHoadon;
    }

    public void setFiSoHoadon(String fiSoHoadon) {
        this.fiSoHoadon = fiSoHoadon;
    }

    public Date getFiNgayCapHd() {
        return fiNgayCapHd;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiNgayCapHd(Date fiNgayCapHd) {
        this.fiNgayCapHd = fiNgayCapHd;
    }

    public Double getFiSoluong() {
        return fiSoluong;
    }

    public void setFiSoluong(Double fiSoluong) {
        this.fiSoluong = fiSoluong;
    }

    public String getFiTenDv() {
        return fiTenDv;
    }

    public void setFiTenDv(String fiTenDv) {
        this.fiTenDv = fiTenDv;
    }

    public Double getFiTong() {
        return fiTong;
    }

    public void setFiTong(Double fiTong) {
        this.fiTong = fiTong;
    }

    public String getFiTenDvTl() {
        return fiTenDvTl;
    }

    public void setFiTenDvTl(String fiTenDvTl) {
        this.fiTenDvTl = fiTenDvTl;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
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

    public List<Tbdtokhaihqd1> getToKhaiHQD1() {
        return toKhaiHQD1;
    }

    public void setToKhaiHQD1(List<Tbdtokhaihqd1> toKhaiHQD1) {
        this.toKhaiHQD1 = toKhaiHQD1;
    }

    public Long getStt() {
        return stt;
    }

    public void setStt(Long stt) {
        this.stt = stt;
    }

}
