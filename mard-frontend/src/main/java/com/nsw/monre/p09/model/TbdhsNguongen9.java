/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.monre.p09.model;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */

public class TbdhsNguongen9 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long fiIdNguongen;
    private Long fiIdHoso;
    private String fiMaNguongen;
    private String fiTenThongThuong;
    private String fiTenKhoaHoc;
    private String fiTenKhac;
    private String fiThongTinNguonGen;
    private String fiMoTaNguonGen;
    private Date fiNgaycapnhat;
    private Date fiNgaytao;
    private Long fiHoatdong;
    private String fiMaHoso;

    public TbdhsNguongen9() {
    }

    public TbdhsNguongen9(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiMaNguongen() {
        return fiMaNguongen;
    }

    public void setFiMaNguongen(String fiMaNguongen) {
        this.fiMaNguongen = fiMaNguongen;
    }

    public String getFiTenThongThuong() {
        return fiTenThongThuong;
    }

    public void setFiTenThongThuong(String fiTenThongThuong) {
        this.fiTenThongThuong = fiTenThongThuong;
    }

    public String getFiTenKhoaHoc() {
        return fiTenKhoaHoc;
    }

    public void setFiTenKhoaHoc(String fiTenKhoaHoc) {
        this.fiTenKhoaHoc = fiTenKhoaHoc;
    }

    public String getFiTenKhac() {
        return fiTenKhac;
    }

    public void setFiTenKhac(String fiTenKhac) {
        this.fiTenKhac = fiTenKhac;
    }

    public String getFiThongTinNguonGen() {
        return fiThongTinNguonGen;
    }

    public void setFiThongTinNguonGen(String fiThongTinNguonGen) {
        this.fiThongTinNguonGen = fiThongTinNguonGen;
    }

    public String getFiMoTaNguonGen() {
        return fiMoTaNguonGen;
    }

    public void setFiMoTaNguonGen(String fiMoTaNguonGen) {
        this.fiMoTaNguonGen = fiMoTaNguonGen;
    }

    public Date getFiNgaycapnhat() {
        return fiNgaycapnhat;
    }

    public void setFiNgaycapnhat(Date fiNgaycapnhat) {
        this.fiNgaycapnhat = fiNgaycapnhat;
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

    public Long getFiIdNguongen() {
        return fiIdNguongen;
    }

    public void setFiIdNguongen(Long fiIdNguongen) {
        this.fiIdNguongen = fiIdNguongen;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    
}
