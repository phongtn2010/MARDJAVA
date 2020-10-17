/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p06.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nsw.util.CustomJsonDateDeserializer;
import java.util.Date;

/**
 *
 * @author Nhan
 */
public class Tbdtaptin {
     private  Long  fiId         ;
    private   Long  fiObjectid   ;
    private   String      fiMataptin   ;
    private   String      fiLoai       ;
    private   String      fiTentaptin  ;
    private   String      fiTenloai    ;
    private   Long  fiLoaiobject ;
    private   Date  fiNgaytao ;
    private   String      fiUrltaptin  ;

    public Tbdtaptin() {
    }

    public Tbdtaptin(Long fiId, Long fiObjectid, String fiMataptin, String fiLoai, String fiTentaptin, String fiTenloai, Long fiLoaiobject, Date fiNgaytao, String fiUrltaptin) {
        this.fiId = fiId;
        this.fiObjectid = fiObjectid;
        this.fiMataptin = fiMataptin;
        this.fiLoai = fiLoai;
        this.fiTentaptin = fiTentaptin;
        this.fiTenloai = fiTenloai;
        this.fiLoaiobject = fiLoaiobject;
        this.fiNgaytao = fiNgaytao;
        this.fiUrltaptin = fiUrltaptin;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Long getFiId() {
        return fiId;
    }

    public void setFiId(Long fiId) {
        this.fiId = fiId;
    }

    public Long getFiObjectid() {
        return fiObjectid;
    }

    public void setFiObjectid(Long fiObjectid) {
        this.fiObjectid = fiObjectid;
    }

    public String getFiMataptin() {
        return fiMataptin;
    }

    public void setFiMataptin(String fiMataptin) {
        this.fiMataptin = fiMataptin;
    }

    public String getFiLoai() {
        return fiLoai;
    }

    public void setFiLoai(String fiLoai) {
        this.fiLoai = fiLoai;
    }

    public String getFiTentaptin() {
        return fiTentaptin;
    }

    public void setFiTentaptin(String fiTentaptin) {
        this.fiTentaptin = fiTentaptin;
    }

    public String getFiTenloai() {
        return fiTenloai;
    }

    public void setFiTenloai(String fiTenloai) {
        this.fiTenloai = fiTenloai;
    }

    public Long getFiLoaiobject() {
        return fiLoaiobject;
    }

    public void setFiLoaiobject(Long fiLoaiobject) {
        this.fiLoaiobject = fiLoaiobject;
    }

    public String getFiUrltaptin() {
        return fiUrltaptin;
    }

    public void setFiUrltaptin(String fiUrltaptin) {
        this.fiUrltaptin = fiUrltaptin;
    }
    
    
}
