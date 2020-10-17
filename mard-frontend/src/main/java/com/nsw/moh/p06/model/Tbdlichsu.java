/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p06.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nsw.annotations.AbstractEntity;
//import com.nsw.util.CustomJsonDateDeserializer;
import java.util.Date;

/**
 *
 * @author Nhan
 */
public class Tbdlichsu extends AbstractEntity{
    private  Long  fiIdLichsu   ;
    private   Long        fiIdHoso     ;
    private   String      fiMaNggui    ;
    private   String      fiTenNggui   ;
    private   String      fiMaDvgui    ;
    private   String      fiTenDvgui   ;
    private   String      fiMaNgnhan   ;
    private   String      fiTenNgnhan  ;
    private   String      fiIdDvnhan   ;
    private   String      fiMaDvnhan   ;
    private   String      fiTenDvnhan  ;
    private   Date        fiThoihan    ;
    private   String      fiTenTt      ;
    private   String      fiNoidung    ;
    private   Date        fiNgaytao    ;
    private   Long  fiTrangthai  ;

    public Tbdlichsu() {
    }

    public Tbdlichsu(Long fiIdLichsu, Long fiIdHoso, String fiMaNggui, String fiTenNggui, String fiMaDvgui, String fiTenDvgui, String fiMaNgnhan, String fiTenNgnhan, String fiIdDvnhan, String fiMaDvnhan, String fiTenDvnhan, Date fiThoihan, String fiTenTt, String fiNoidung, Date fiNgaytao, Long fiTrangthai) {
        this.fiIdLichsu = fiIdLichsu;
        this.fiIdHoso = fiIdHoso;
        this.fiMaNggui = fiMaNggui;
        this.fiTenNggui = fiTenNggui;
        this.fiMaDvgui = fiMaDvgui;
        this.fiTenDvgui = fiTenDvgui;
        this.fiMaNgnhan = fiMaNgnhan;
        this.fiTenNgnhan = fiTenNgnhan;
        this.fiIdDvnhan = fiIdDvnhan;
        this.fiMaDvnhan = fiMaDvnhan;
        this.fiTenDvnhan = fiTenDvnhan;
        this.fiThoihan = fiThoihan;
        this.fiTenTt = fiTenTt;
        this.fiNoidung = fiNoidung;
        this.fiNgaytao = fiNgaytao;
        this.fiTrangthai = fiTrangthai;
    }

    public Long getFiIdLichsu() {
        return fiIdLichsu;
    }

    public void setFiIdLichsu(Long fiIdLichsu) {
        this.fiIdLichsu = fiIdLichsu;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiMaNggui() {
        return fiMaNggui;
    }

    public void setFiMaNggui(String fiMaNggui) {
        this.fiMaNggui = fiMaNggui;
    }

    public String getFiTenNggui() {
        return fiTenNggui;
    }

    public void setFiTenNggui(String fiTenNggui) {
        this.fiTenNggui = fiTenNggui;
    }

    public String getFiMaDvgui() {
        return fiMaDvgui;
    }

    public void setFiMaDvgui(String fiMaDvgui) {
        this.fiMaDvgui = fiMaDvgui;
    }

    public String getFiTenDvgui() {
        return fiTenDvgui;
    }

    public void setFiTenDvgui(String fiTenDvgui) {
        this.fiTenDvgui = fiTenDvgui;
    }

    public String getFiMaNgnhan() {
        return fiMaNgnhan;
    }

    public void setFiMaNgnhan(String fiMaNgnhan) {
        this.fiMaNgnhan = fiMaNgnhan;
    }

    public String getFiTenNgnhan() {
        return fiTenNgnhan;
    }

    public void setFiTenNgnhan(String fiTenNgnhan) {
        this.fiTenNgnhan = fiTenNgnhan;
    }

    public String getFiIdDvnhan() {
        return fiIdDvnhan;
    }

    public void setFiIdDvnhan(String fiIdDvnhan) {
        this.fiIdDvnhan = fiIdDvnhan;
    }

    public String getFiMaDvnhan() {
        return fiMaDvnhan;
    }

    public void setFiMaDvnhan(String fiMaDvnhan) {
        this.fiMaDvnhan = fiMaDvnhan;
    }

    public String getFiTenDvnhan() {
        return fiTenDvnhan;
    }

    public void setFiTenDvnhan(String fiTenDvnhan) {
        this.fiTenDvnhan = fiTenDvnhan;
    }

    public Date getFiThoihan() {
        return fiThoihan;
    }

    public void setFiThoihan(Date fiThoihan) {
        this.fiThoihan = fiThoihan;
    }

    public String getFiTenTt() {
        return fiTenTt;
    }

    public void setFiTenTt(String fiTenTt) {
        this.fiTenTt = fiTenTt;
    }

    public String getFiNoidung() {
        return fiNoidung;
    }

    public void setFiNoidung(String fiNoidung) {
        this.fiNoidung = fiNoidung;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

//    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }
    
}
