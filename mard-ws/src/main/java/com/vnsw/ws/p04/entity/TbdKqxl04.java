/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.entity;

import com.vnsw.ws.annotations.DateSerialization;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Fujitsu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Result")
public class TbdKqxl04 {

    @XmlTransient
    private Long fiIdKqxl;
    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;
    @XmlElement(name = "Reason")
    private String fiNoiDung;
    @XmlElement(name = "ResultDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date fiNgayXl;
    @XmlElement(name = "Department")
    private String fiDonviXl;
    @XmlElement(name = "CreaterName")
    private String fiChuyenvienXl;
    @XmlTransient
    private Long fiIdHoso;
    @XmlTransient
    private Long fiTrangthai;
    @XmlTransient
    private Long fiHoatdong;
    @XmlTransient
    private String fiNguoitao;
    @XmlTransient
    private Date fiNgaytao;

    public TbdKqxl04() {
    }

    public TbdKqxl04(Long fiIdKqxl) {
        this.fiIdKqxl = fiIdKqxl;
    }

    public Long getFiIdKqxl() {
        return fiIdKqxl;
    }

    public void setFiIdKqxl(Long fiIdKqxl) {
        this.fiIdKqxl = fiIdKqxl;
    }

    public String getFiNoiDung() {
        return fiNoiDung;
    }

    public void setFiNoiDung(String fiNoiDung) {
        this.fiNoiDung = fiNoiDung;
    }

    public Date getFiNgayXl() {
        return fiNgayXl;
    }

    public void setFiNgayXl(Date fiNgayXl) {
        this.fiNgayXl = fiNgayXl;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiDonviXl() {
        return fiDonviXl;
    }

    public void setFiDonviXl(String fiDonviXl) {
        this.fiDonviXl = fiDonviXl;
    }

    public String getFiChuyenvienXl() {
        return fiChuyenvienXl;
    }

    public void setFiChuyenvienXl(String fiChuyenvienXl) {
        this.fiChuyenvienXl = fiChuyenvienXl;
    }

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdKqxl != null ? fiIdKqxl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdKqxl04)) {
            return false;
        }
        TbdKqxl04 other = (TbdKqxl04) object;
        if ((this.fiIdKqxl == null && other.fiIdKqxl != null) || (this.fiIdKqxl != null && !this.fiIdKqxl.equals(other.fiIdKqxl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.mard.p04.model.TbdKqxl04[ fiIdKqxl=" + fiIdKqxl + " ]";
    }

}
