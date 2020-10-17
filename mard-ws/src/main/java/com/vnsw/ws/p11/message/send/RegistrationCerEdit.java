/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p11.message.send;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegistrationCerEdit")
public class RegistrationCerEdit {
    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;
    
    @XmlElement(name = "RequestDate")
    private String fiNgayYc;
    
    @XmlElement(name = "Reason")
    private String fiLydo;
    
    @XmlElement(name = "CerType")
    private Long fiLoaiGcn;

    public RegistrationCerEdit() {
    }

    public RegistrationCerEdit(String fiMaHoso, String fiNgayYc, String fiLydo, Long fiLoaiGcn) {
        this.fiMaHoso = fiMaHoso;
        this.fiNgayYc = fiNgayYc;
        this.fiLydo = fiLydo;
        this.fiLoaiGcn = fiLoaiGcn;
    }
    
    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiNgayYc() {
        return fiNgayYc;
    }

    public void setFiNgayYc(String fiNgayYc) {
        this.fiNgayYc = fiNgayYc;
    }

    public String getFiLydo() {
        return fiLydo;
    }

    public void setFiLydo(String fiLydo) {
        this.fiLydo = fiLydo;
    }

    public Long getFiLoaiGcn() {
        return fiLoaiGcn;
    }

    public void setFiLoaiGcn(Long fiLoaiGcn) {
        this.fiLoaiGcn = fiLoaiGcn;
    }
    
    
}
