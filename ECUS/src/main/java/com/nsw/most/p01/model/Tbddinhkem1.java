/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.p01.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nsw.util.CustomJsonDateDeserializer;
import java.util.Date;

/**
 *
 * @author Phong84NV
 */
public class Tbddinhkem1 {
    private Long fiIdDinhkem;
    private String fiMaLoai;
    private String fiTenLoai;
    private String fiSoVb;
    private Date fiNgayCap;
    private String fiDvCap;
    private String fiTenTep;
    private String fiNoiDung;
    private Long fiIdHoso;
    private Date fiNgaytao;
    private Long fiHoatdong;
    private String fiNguoitao;
    private String fiDuongDan;
    private String fiGuiId;
    private String fiMaLoaiTaiLieu;
    private String fiTenLoaiTaiLieu;
    private Long fiFileSize;

    public Tbddinhkem1() {
    }

    public Tbddinhkem1(Long fiIdDinhkem, String fiMaLoai, String fiTenLoai, 
            String fiSoVb, Date fiNgayCap, String fiDvCap, String fiTenTep, String fiNoiDung, 
            Long fiIdHoso, Date fiNgaytao, Long fiHoatdong, String fiNguoitao, String fiDuongDan, String fiGuiId,
            String fiMaLoaiTaiLieu, String fiTenLoaiTaiLieu, Long fiFileSize) {
        this.fiIdDinhkem = fiIdDinhkem;
        this.fiMaLoai = fiMaLoai;
        this.fiTenLoai = fiTenLoai;
        this.fiSoVb = fiSoVb;
        this.fiNgayCap = fiNgayCap;
        this.fiDvCap = fiDvCap;
        this.fiTenTep = fiTenTep;
        this.fiNoiDung = fiNoiDung;
        this.fiIdHoso = fiIdHoso;
        this.fiNgaytao = fiNgaytao;
        this.fiHoatdong = fiHoatdong;
        this.fiNguoitao = fiNguoitao;
        this.fiDuongDan = fiDuongDan;
        this.fiGuiId = fiGuiId;
        this.fiMaLoaiTaiLieu = fiMaLoaiTaiLieu;
        this.fiTenLoaiTaiLieu = fiTenLoaiTaiLieu;
        this.fiFileSize = fiFileSize;
    }

    public Long getFiIdDinhkem() {
        return fiIdDinhkem;
    }

    public void setFiIdDinhkem(Long fiIdDinhkem) {
        this.fiIdDinhkem = fiIdDinhkem;
    }

    public String getFiMaLoai() {
        return fiMaLoai;
    }

    public void setFiMaLoai(String fiMaLoai) {
        this.fiMaLoai = fiMaLoai;
    }

    public String getFiTenLoai() {
        return fiTenLoai;
    }

    public void setFiTenLoai(String fiTenLoai) {
        this.fiTenLoai = fiTenLoai;
    }

    public String getFiSoVb() {
        return fiSoVb;
    }

    public void setFiSoVb(String fiSoVb) {
        this.fiSoVb = fiSoVb;
    }

    public Date getFiNgayCap() {
        return fiNgayCap;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiNgayCap(Date fiNgayCap) {
        this.fiNgayCap = fiNgayCap;
    }

    public String getFiDvCap() {
        return fiDvCap;
    }

    public void setFiDvCap(String fiDvCap) {
        this.fiDvCap = fiDvCap;
    }

    public String getFiTenTep() {
        return fiTenTep;
    }

    public void setFiTenTep(String fiTenTep) {
        this.fiTenTep = fiTenTep;
    }

    public String getFiNoiDung() {
        return fiNoiDung;
    }

    public void setFiNoiDung(String fiNoiDung) {
        this.fiNoiDung = fiNoiDung;
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

    public String getFiDuongDan() {
        return fiDuongDan;
    }

    public void setFiDuongDan(String fiDuongDan) {
        this.fiDuongDan = fiDuongDan;
    }

    public String getFiGuiId() {
        return fiGuiId;
    }

    public void setFiGuiId(String fiGuiId) {
        this.fiGuiId = fiGuiId;
    }

    public String getFiMaLoaiTaiLieu() {
        return fiMaLoaiTaiLieu;
    }

    public void setFiMaLoaiTaiLieu(String fiMaLoaiTaiLieu) {
        this.fiMaLoaiTaiLieu = fiMaLoaiTaiLieu;
    }

    public String getFiTenLoaiTaiLieu() {
        return fiTenLoaiTaiLieu;
    }

    public void setFiTenLoaiTaiLieu(String fiTenLoaiTaiLieu) {
        this.fiTenLoaiTaiLieu = fiTenLoaiTaiLieu;
    }

    public Long getFiFileSize() {
        return fiFileSize;
    }

    public void setFiFileSize(Long fiFileSize) {
        this.fiFileSize = fiFileSize;
    }
    
    
}
