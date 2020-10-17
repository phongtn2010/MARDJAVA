/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p11.message.send;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PhytosanitaryRequestEditCer")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhytosanitaryRequestEditCer {
    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;
    
    @XmlElement(name = "RequestDate")
    private String fiNgayYc;
    
    @XmlElement(name = "Reason")
    private String fiNoidungYc;

    public PhytosanitaryRequestEditCer() {
    }

    public PhytosanitaryRequestEditCer(String fiMaHoso, String fiNgayYc, String fiNoidungYc) {
        this.fiMaHoso = fiMaHoso;
        this.fiNgayYc = fiNgayYc;
        this.fiNoidungYc = fiNoidungYc;
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

    public String getFiNoidungYc() {
        return fiNoidungYc;
    }

    public void setFiNoidungYc(String fiNoidungYc) {
        this.fiNoidungYc = fiNoidungYc;
    }
}
