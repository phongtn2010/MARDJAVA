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
public class TbdDnXinchuyenCuakhau03 {

    private Long id;
    private Long fiIdHoso;//
    private String fiMaHoso;//
    private String fiMaCqxl;//
    private String fiTenCqxl;//
    private String fiSoGcnKd;//
    private String fiNoidung;//
    private String fiSoContainer;//
    private String fiTenCkChuyen;//
    private String fiMaCuakhau;//
    private Long fiHoatdong;
    private String fiNguoitao;
    private Date fiNgaytao;
    private Long fiTrangthai;
    private String fiTenTrangthai;
    private String fiNoiky;
    private Date fiNgayky;
    private String fiNguoiky;
    private List<TbdDnChuyenCkHh03> lstHanghoa;

    public TbdDnXinchuyenCuakhau03() {
    }

    public TbdDnXinchuyenCuakhau03(Long id) {
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

    public String getFiSoGcnKd() {
        return fiSoGcnKd;
    }

    public void setFiSoGcnKd(String fiSoGcnKd) {
        this.fiSoGcnKd = fiSoGcnKd;
    }

    public String getFiNoidung() {
        return fiNoidung;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public String getFiSoContainer() {
        return fiSoContainer;
    }

    public void setFiSoContainer(String fiSoContainer) {
        this.fiSoContainer = fiSoContainer;
    }

    public String getFiTenCkChuyen() {
        return fiTenCkChuyen;
    }

    public void setFiTenCkChuyen(String fiTenCkChuyen) {
        this.fiTenCkChuyen = fiTenCkChuyen;
    }

    public String getFiMaCuakhau() {
        return fiMaCuakhau;
    }

    public void setFiMaCuakhau(String fiMaCuakhau) {
        this.fiMaCuakhau = fiMaCuakhau;
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

    public String getFiNoiky() {
        return fiNoiky;
    }

    public void setFiNoiky(String fiNoiky) {
        this.fiNoiky = fiNoiky;
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

    public List<TbdDnChuyenCkHh03> getLstHanghoa() {
        return lstHanghoa;
    }

    public void setLstHanghoa(List<TbdDnChuyenCkHh03> lstHanghoa) {
        this.lstHanghoa = lstHanghoa;
    }
}
