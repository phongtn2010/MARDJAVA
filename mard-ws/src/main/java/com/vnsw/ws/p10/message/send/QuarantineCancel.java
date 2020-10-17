/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p10.message.send;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "QuarantineCancel")
@XmlAccessorType(XmlAccessType.FIELD)
public class QuarantineCancel {

    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;
    
    @XmlElement(name = "RequestDate")
    private String fiNgayYc;
    
    @XmlElement(name = "Reason")
    private String fiLydo;

    public QuarantineCancel() {
    }

    public QuarantineCancel(String fiMaHoso, String fiNgayYc, String fiLydo) {
        this.fiMaHoso = fiMaHoso;
        this.fiNgayYc = fiNgayYc;
        this.fiLydo = fiLydo;
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
    
}
