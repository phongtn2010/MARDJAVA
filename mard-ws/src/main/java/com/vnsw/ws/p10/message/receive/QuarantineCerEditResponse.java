/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p10.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuarantineCerEditResponse")
public class QuarantineCerEditResponse {
    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;
    
    @XmlElement(name = "Reason")
    private String fiLydoBnn;
    
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    private Date fiNgayXl;
    
    @XmlElement(name = "Department")
    private String fiDonviXl;
    
    @XmlElement(name = "CreaterName")
    private String fiNguoiTn;

    public QuarantineCerEditResponse() {
    }

    public QuarantineCerEditResponse(String fiMaHoso, String fiLydoBnn, Date fiNgayXl, String fiDonviXl, String fiNguoiTn) {
        this.fiMaHoso = fiMaHoso;
        this.fiLydoBnn = fiLydoBnn;
        this.fiNgayXl = fiNgayXl;
        this.fiDonviXl = fiDonviXl;
        this.fiNguoiTn = fiNguoiTn;
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

    public Date getFiNgayXl() {
        return fiNgayXl;
    }

    public void setFiNgayXl(Date fiNgayXl) {
        this.fiNgayXl = fiNgayXl;
    }

    public String getFiDonviXl() {
        return fiDonviXl;
    }

    public void setFiDonviXl(String fiDonviXl) {
        this.fiDonviXl = fiDonviXl;
    }

    public String getFiNguoiTn() {
        return fiNguoiTn;
    }

    public void setFiNguoiTn(String fiNguoiTn) {
        this.fiNguoiTn = fiNguoiTn;
    }
    
    
}
