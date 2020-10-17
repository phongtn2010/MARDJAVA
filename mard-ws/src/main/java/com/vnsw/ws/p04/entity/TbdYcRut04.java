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
@XmlType(name = "ResponseCancel")
public class TbdYcRut04  {
    @XmlTransient
    private Long fiIdYcRut;
    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;
    @XmlTransient
    private Date fiNgayYeucau;
    @XmlTransient
    private String fiNoidungYeucau;
    @XmlElement(name = "SignConfirmDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date fiNgayXuly;
    @XmlElement(name = "Reason")
    private String fiNoidungPhanhoi;
    @XmlElement(name = "Department")
    private String fiDonviXuly;
    @XmlElement(name = "CreaterName")
    private String fiChuyenvienXuly;
    @XmlTransient
    private Long fiIdHoso;
    @XmlTransient
    private Long fiTrangthai;
    @XmlTransient
    private String fiTenTt;

    public TbdYcRut04() {
    }

    public TbdYcRut04(Long fiIdYcRut) {
        this.fiIdYcRut = fiIdYcRut;
    }

    public Long getFiIdYcRut() {
        return fiIdYcRut;
    }

    public void setFiIdYcRut(Long fiIdYcRut) {
        this.fiIdYcRut = fiIdYcRut;
    }

    public String getFiMaHoso() {
        return fiMaHoso;
    }

    public void setFiMaHoso(String fiMaHoso) {
        this.fiMaHoso = fiMaHoso;
    }

    public Date getFiNgayYeucau() {
        return fiNgayYeucau;
    }

    public void setFiNgayYeucau(Date fiNgayYeucau) {
        this.fiNgayYeucau = fiNgayYeucau;
    }

    public String getFiNoidungYeucau() {
        return fiNoidungYeucau;
    }

    public void setFiNoidungYeucau(String fiNoidungYeucau) {
        this.fiNoidungYeucau = fiNoidungYeucau;
    }

    public String getFiNoidungPhanhoi() {
        return fiNoidungPhanhoi;
    }

    public void setFiNoidungPhanhoi(String fiNoidungPhanhoi) {
        this.fiNoidungPhanhoi = fiNoidungPhanhoi;
    }

    public String getFiDonviXuly() {
        return fiDonviXuly;
    }

    public void setFiDonviXuly(String fiDonviXuly) {
        this.fiDonviXuly = fiDonviXuly;
    }

    public String getFiChuyenvienXuly() {
        return fiChuyenvienXuly;
    }

    public void setFiChuyenvienXuly(String fiChuyenvienXuly) {
        this.fiChuyenvienXuly = fiChuyenvienXuly;
    }

    public Date getFiNgayXuly() {
        return fiNgayXuly;
    }

    public void setFiNgayXuly(Date fiNgayXuly) {
        this.fiNgayXuly = fiNgayXuly;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public Long getFiTrangthai() {
        return fiTrangthai;
    }

    public void setFiTrangthai(Long fiTrangthai) {
        this.fiTrangthai = fiTrangthai;
    }

    public String getFiTenTt() {
        return fiTenTt;
    }

    public void setFiTenTt(String fiTenTt) {
        this.fiTenTt = fiTenTt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdYcRut != null ? fiIdYcRut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdYcRut04)) {
            return false;
        }
        TbdYcRut04 other = (TbdYcRut04) object;
        if ((this.fiIdYcRut == null && other.fiIdYcRut != null) || (this.fiIdYcRut != null && !this.fiIdYcRut.equals(other.fiIdYcRut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.mard.p04.model.TbdYcRut04[ fiIdYcRut=" + fiIdYcRut + " ]";
    }
    
}
