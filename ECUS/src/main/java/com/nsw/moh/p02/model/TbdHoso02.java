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
public class TbdHoso02 {

    private Long fiIdHoso;
    private String fiMaHoso;
    private Date fiNgaynopHoso;
    private Date fiNgaytao;
    private Date fiNgCapnhat;
    private String fiNguoitao;
    private Date fiNgaygui;
    private String fiTenTt;
    private Long fiTrangthai;
    private Long fiHoatdong;
    private TbdDoanhnghiep02 tbdDoanhnghiep02;
    private List<TbdDonhang02> tbdDonhang02List;
    private TbdLydo02 tbdLydo02;
    private TbdNguoilienhe02 tbdNguoilienhe02;
    private List<TbdDinhkem02> tbdDinhkem02List;

    public TbdHoso02() {
    }

    public TbdHoso02(Long fiIdHoso) {
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

    public Date getFiNgaynopHoso() {
        return fiNgaynopHoso;
    }

    public void setFiNgaynopHoso(Date fiNgaynopHoso) {
        this.fiNgaynopHoso = fiNgaynopHoso;
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

    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public Date getFiNgaygui() {
        return fiNgaygui;
    }

    public void setFiNgaygui(Date fiNgaygui) {
        this.fiNgaygui = fiNgaygui;
    }

    public String getFiTenTt() {
        return fiTenTt;
    }

    public void setFiTenTt(String fiTenTt) {
        this.fiTenTt = fiTenTt;
    }

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public TbdDoanhnghiep02 getTbdDoanhnghiep02() {
        return tbdDoanhnghiep02;
    }

    public void setTbdDoanhnghiep02(TbdDoanhnghiep02 tbdDoanhnghiep02) {
        this.tbdDoanhnghiep02 = tbdDoanhnghiep02;
    }

    public List<TbdDonhang02> getTbdDonhang02List() {
        return tbdDonhang02List;
    }

    public void setTbdDonhang02List(List<TbdDonhang02> tbdDonhang02List) {
        this.tbdDonhang02List = tbdDonhang02List;
    }

    public TbdLydo02 getTbdLydo02() {
        return tbdLydo02;
    }

    public void setTbdLydo02(TbdLydo02 tbdLydo02) {
        this.tbdLydo02 = tbdLydo02;
    }

    public TbdNguoilienhe02 getTbdNguoilienhe02() {
        return tbdNguoilienhe02;
    }

    public void setTbdNguoilienhe02(TbdNguoilienhe02 tbdNguoilienhe02) {
        this.tbdNguoilienhe02 = tbdNguoilienhe02;
    }

    public List<TbdDinhkem02> getTbdDinhkem02List() {
        return tbdDinhkem02List;
    }

    public void setTbdDinhkem02List(List<TbdDinhkem02> tbdDinhkem02List) {
        this.tbdDinhkem02List = tbdDinhkem02List;
    }
}
