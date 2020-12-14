/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p02.model;

import java.util.Date;
import java.util.List;

/**
 * @author HuongMK
 */
public class TbdGiayphepNk02 {

    private Long fiIdGiayphep;
    private Long fiIdHoso;
    private String fiMaHoso;
    private String fiCqCap;
    private String fiSoCongvan;
    private Date fiNgayky;
    private String fiNguoiky;
    private String fiTenCongvan;
    private String fiNoidungTeptin;
    private String fiLinkNoidung;
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;
    private Date fiNgCapnhat;
    private String fiTendoanhnghiep;
    private String fiMst;
    private List<TbdGpHanghoa02> lstHanghoa;

    public TbdGiayphepNk02() {
    }

    public TbdGiayphepNk02(Long fiIdGiayphep) {
        this.fiIdGiayphep = fiIdGiayphep;
    }

    public Long getFiIdGiayphep() {
        return fiIdGiayphep;
    }

    public void setFiIdGiayphep(Long fiIdGiayphep) {
        this.fiIdGiayphep = fiIdGiayphep;
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

    public String getFiCqCap() {
        return fiCqCap;
    }

    public void setFiCqCap(String fiCqCap) {
        this.fiCqCap = fiCqCap;
    }

    public String getFiSoCongvan() {
        return fiSoCongvan;
    }

    public void setFiSoCongvan(String fiSoCongvan) {
        this.fiSoCongvan = fiSoCongvan;
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

    public String getFiTenCongvan() {
        return fiTenCongvan;
    }

    public void setFiTenCongvan(String fiTenCongvan) {
        this.fiTenCongvan = fiTenCongvan;
    }

    public String getFiNoidungTeptin() {
        return fiNoidungTeptin;
    }

    public void setFiNoidungTeptin(String fiNoidungTeptin) {
        this.fiNoidungTeptin = fiNoidungTeptin;
    }

    public String getFiLinkNoidung() {
        return fiLinkNoidung;
    }

    public void setFiLinkNoidung(String fiLinkNoidung) {
        this.fiLinkNoidung = fiLinkNoidung;
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

    public List<TbdGpHanghoa02> getLstHanghoa() {
        return lstHanghoa;
    }

    public void setLstHanghoa(List<TbdGpHanghoa02> lstHanghoa) {
        this.lstHanghoa = lstHanghoa;
    }

    public String getFiTendoanhnghiep() {
        return fiTendoanhnghiep;
    }

    public void setFiTendoanhnghiep(String fiTendoanhnghiep) {
        this.fiTendoanhnghiep = fiTendoanhnghiep;
    }

    public String getFiMst() {
        return fiMst;
    }

    public void setFiMst(String fiMst) {
        this.fiMst = fiMst;
    }

}
