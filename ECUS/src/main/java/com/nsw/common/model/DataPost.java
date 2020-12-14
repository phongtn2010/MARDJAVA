/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.common.model;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nsw.util.CustomJsonDateDeserializer;
import java.util.Date;

/**
 *
 * @author PhongNguyen
 */
public class DataPost {
    private String fiIdHoso;
    private String fiMaHoSo;
    private String fiContent;
    private String fiIdCqxl;
    private Date fiTime;
    private String fiSignedXml;
    private Boolean fiGetMessage;
    
    public DataPost() {
    }

    public DataPost(String fiIdHoso, String fiMaHoSo, String fiContent, Date fiTime, String fiSignedXml, Boolean fiGetMessage) {
        this.fiIdHoso = fiIdHoso;
        this.fiMaHoSo = fiMaHoSo;
        this.fiContent = fiContent;
        this.fiTime = fiTime;
        this.fiSignedXml = fiSignedXml;
        this.fiGetMessage = fiGetMessage;
    }

    public String getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(String fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiMaHoSo() {
        return fiMaHoSo;
    }

    public void setFiMaHoSo(String fiMaHoSo) {
        this.fiMaHoSo = fiMaHoSo;
    }

    public String getFiContent() {
        return fiContent;
    }

    public void setFiContent(String fiContent) {
        this.fiContent = fiContent;
    }

    public Date getFiTime() {
        return fiTime;
    }

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    public void setFiTime(Date fiTime) {
        this.fiTime = fiTime;
    }

    public String getFiIdCqxl() {
        return fiIdCqxl;
    }

    public void setFiIdCqxl(String fiIdCqxl) {
        this.fiIdCqxl = fiIdCqxl;
    }

    public String getFiSignedXml() {
        return fiSignedXml;
    }

    public void setFiSignedXml(String fiSignedXml) {
        this.fiSignedXml = fiSignedXml;
    }

    public Boolean getFiGetMessage() {
        return fiGetMessage;
    }

    public void setFiGetMessage(Boolean fiGetMessage) {
        this.fiGetMessage = fiGetMessage;
    }
    
}