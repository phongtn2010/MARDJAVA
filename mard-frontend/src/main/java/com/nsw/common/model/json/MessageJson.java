/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.common.model.json;

/**
 *
 * @author PhongNguyen
 */
public class MessageJson {
    private boolean success;
    private Object XmlData;
    public String message;
    public Long fiIdCqxl;
    public Long fiIdHoso;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getXmlData() {
        return XmlData;
    }

    public void setXmlData(Object XmlData) {
        this.XmlData = XmlData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getFiIdCqxl() {
        return fiIdCqxl;
    }

    public void setFiIdCqxl(Long fiIdCqxl) {
        this.fiIdCqxl = fiIdCqxl;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }
    
    
    
    public MessageJson()
    {
    }
}
