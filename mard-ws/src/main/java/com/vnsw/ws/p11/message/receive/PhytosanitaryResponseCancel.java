/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p11.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhytosanitaryResponseCancel")
public class PhytosanitaryResponseCancel {
    @XmlTransient
    private Long fiIdYc;
    
    @XmlTransient
    private Long fiIdHoso;
    
    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;
    
    @XmlTransient
    private Date fiNgayYc;
    
    @XmlTransient
    private Long fiHoatdong;
    
    @XmlTransient
    private Date fiNgaytao;
    
    @XmlTransient
    private String fiNguoitao;
    
    @XmlTransient
    private Date fiNgayCn;
    
    @XmlTransient
    private String fiNguoiCn;
    
    @XmlTransient
    private String fiLydo;
    
    @XmlElement(name = "Reason")
    private String fiLydoBnn;
    
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    private Date fiNgayXl;
    
    @XmlElement(name = "CreaterName")
    private String fiNguoiXl;
    
    @XmlTransient
    private Long fiTrangthai;

    public PhytosanitaryResponseCancel() {
    }

    public Long getFiIdYc() {
        return fiIdYc;
    }

    public void setFiIdYc(Long fiIdYc) {
        this.fiIdYc = fiIdYc;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public Date getFiNgayYc() {
        return fiNgayYc;
    }

    public void setFiNgayYc(Date fiNgayYc) {
        this.fiNgayYc = fiNgayYc;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public Date getFiNgayCn() {
        return fiNgayCn;
    }

    public void setFiNgayCn(Date fiNgayCn) {
        this.fiNgayCn = fiNgayCn;
    }

    public String getFiNguoiCn() {
        return fiNguoiCn;
    }

    public void setFiNguoiCn(String fiNguoiCn) {
        this.fiNguoiCn = fiNguoiCn;
    }

    public String getFiLydo() {
        return fiLydo;
    }

    public void setFiLydo(String fiLydo) {
        this.fiLydo = fiLydo;
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

    public String getFiNguoiXl() {
        return fiNguoiXl;
    }

    public void setFiNguoiXl(String fiNguoiXl) {
        this.fiNguoiXl = fiNguoiXl;
    }

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    
}
