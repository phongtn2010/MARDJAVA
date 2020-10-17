/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p11.message.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhytosanitaryResponseEditCer")
public class PhytosanitaryResponseEditCer {
    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;
    
    @XmlElement(name = "Reason")
    private String fiLydoBnn;
    
    @XmlElement(name = "CreaterName")
    private String fiNguoiXl;

    public PhytosanitaryResponseEditCer() {
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public String getFiLydoBnn() {
        return fiLydoBnn;
    }

    public void setFiLydoBnn(String fiLydoBnn) {
        this.fiLydoBnn = fiLydoBnn;
    }

    public String getFiNguoiXl() {
        return fiNguoiXl;
    }

    public void setFiNguoiXl(String fiNguoiXl) {
        this.fiNguoiXl = fiNguoiXl;
    }
}
