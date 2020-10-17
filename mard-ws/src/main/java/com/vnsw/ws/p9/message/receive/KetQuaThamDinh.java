/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p9.message.receive;

import com.vnsw.ws.annotations.DateSerialization;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "Result")
@XmlAccessorType(XmlAccessType.FIELD)
public class KetQuaThamDinh {

    @XmlElement(name = "Reason")
    private String fiLydo;
    
    @XmlElement(name = "ResultDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date fiNgayXl;
    
    @XmlElement(name = "Department")
    private String fiDvXl;
    
    @XmlElement(name = "CreaterName")
    private String fiCvXl;

    public KetQuaThamDinh() {
    }

    public KetQuaThamDinh(String fiLydo, Date fiNgayXl, String fiDvXl, String fiCvXl) {
        this.fiLydo = fiLydo;
        this.fiNgayXl = fiNgayXl;
        this.fiDvXl = fiDvXl;
        this.fiCvXl = fiCvXl;
    }


    public String getFiLydo() {
        return fiLydo;
    }

    public void setFiLydo(String fiLydo) {
        this.fiLydo = fiLydo;
    }

    public Date getFiNgayXl() {
        return fiNgayXl;
    }

    public void setFiNgayXl(Date fiNgayXl) {
        this.fiNgayXl = fiNgayXl;
    }

    public String getFiDvXl() {
        return fiDvXl;
    }

    public void setFiDvXl(String fiDvXl) {
        this.fiDvXl = fiDvXl;
    }

    public String getFiCvXl() {
        return fiCvXl;
    }

    public void setFiCvXl(String fiCvXl) {
        this.fiCvXl = fiCvXl;
    }
}
