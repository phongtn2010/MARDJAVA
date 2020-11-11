/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.common.entity.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vnsw.ws.annotations.CustomJsonDateDeserializer;

import java.util.Date;

/**
 *
 * @author PhongNguyen
 */
public class DataPost {
    private Long fiIdHoso;
    private String fiMaHoSo;
    private String Content;
    private Date Time;
    
    public DataPost() {
    }

    public DataPost(Long fiIdHoso, String fiMaHoSo, String Content, Date Time) {
        this.fiIdHoso = fiIdHoso;
        this.fiMaHoSo = fiMaHoSo;
        this.Content = Content;
        this.Time = Time;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiMaHoSo() {
        return fiMaHoSo;
    }

    public void setFiMaHoSo(String fiMaHoSo) {
        this.fiMaHoSo = fiMaHoSo;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public Date getTime() {
        return Time;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setTime(Date Time) {
        this.Time = Time;
    }
    
}
