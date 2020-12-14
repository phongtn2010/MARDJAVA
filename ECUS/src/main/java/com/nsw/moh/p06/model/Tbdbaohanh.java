/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.p06.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nsw.annotations.*;
import com.nsw.util.CustomJsonDateDeserializer;
import java.util.Date;

public class Tbdbaohanh {

    private Long fiBaohanhId;
    @Mandatory
    @FieldName(name = "fiTencoso")
    @Maxlength(maxLength = 250)
    //@FilterXSS
    private String fiTencoso;
    @Mandatory
    @FieldName(name = "fiDiachics")
    @Maxlength(maxLength = 250)
    //@FilterXSS
    private String fiDiachics;
    @Maxlength(maxLength = 50)
    @FieldName(name = "fiDienthoai")
    //@FilterXSS
    private String fiDienthoai;
    @Maxlength(maxLength = 50)
    @FieldName(name = "fiDidong")
    //@FilterXSS
    private String fiDidong;
    @Maxlength(maxLength = 20)
    @FieldName(name = "fiMstCsbh")
    //@FilterXSS
    private String fiMstCsbh;
    private Date fiNgaytao;
    private Long fiHosoid;

    public Tbdbaohanh() {
    }

    public Tbdbaohanh(Long fiBaohanhId, String fiTencoso, String fiDiachics, String fiDienthoai, String fiDidong, String fiMstCsbh, Date fiNgaytao, Long fiHosoid) {
        this.fiBaohanhId = fiBaohanhId;
        this.fiTencoso = fiTencoso;
        this.fiDiachics = fiDiachics;
        this.fiDienthoai = fiDienthoai;
        this.fiDidong = fiDidong;
        this.fiMstCsbh = fiMstCsbh;
        this.fiNgaytao = fiNgaytao;
        this.fiHosoid = fiHosoid;
    }

    public Long getFiBaohanhId() {
        return fiBaohanhId;
    }

    public void setFiBaohanhId(Long fiBaohanhId) {
        this.fiBaohanhId = fiBaohanhId;
    }

    public String getFiMstCsbh() {
        return fiMstCsbh;
    }

    public void setFiMstCsbh(String fiMstCsbh) {
        this.fiMstCsbh = fiMstCsbh;
    }

    public Long getFiHosoid() {
        return fiHosoid;
    }

    public void setFiHosoid(Long fiHosoid) {
        this.fiHosoid = fiHosoid;
    }

    public String getFiTencoso() {
        return fiTencoso;
    }

    public void setFiTencoso(String fiTencoso) {
        this.fiTencoso = fiTencoso;
    }

    public String getFiDiachics() {
        return fiDiachics;
    }

    public void setFiDiachics(String fiDiachics) {
        this.fiDiachics = fiDiachics;
    }

    public String getFiDienthoai() {
        return fiDienthoai;
    }

    public void setFiDienthoai(String fiDienthoai) {
        this.fiDienthoai = fiDienthoai;
    }

    public String getFiDidong() {
        return fiDidong;
    }

    public void setFiDidong(String fiDidong) {
        this.fiDidong = fiDidong;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

}
