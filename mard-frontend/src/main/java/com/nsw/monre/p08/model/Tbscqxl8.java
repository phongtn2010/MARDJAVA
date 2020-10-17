/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.monre.p08.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Windows 10 TIMT
 */

public class Tbscqxl8 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Long fiIdCqxl;
    private String fiMaCoQuan;
    private String fiTenCoQuan;
    private Date fiNgayTao;
    private Long fiHoatdong;
    private String fiVietTat;

    public Tbscqxl8() { 
    }

    public Long getFiIdCqxl() {
        return fiIdCqxl;
    }

    public void setFiIdCqxl(Long fiIdCqxl) {
        this.fiIdCqxl = fiIdCqxl;
    }

    public String getFiMaCoQuan() {
        return fiMaCoQuan;
    }

    public void setFiMaCoQuan(String fiMaCoQuan) {
        this.fiMaCoQuan = fiMaCoQuan;
    }

    public String getFiTenCoQuan() {
        return fiTenCoQuan;
    }

    public void setFiTenCoQuan(String fiTenCoQuan) {
        this.fiTenCoQuan = fiTenCoQuan;
    }

    public Date getFiNgayTao() {
        return fiNgayTao;
    }

    public void setFiNgayTao(Date fiNgayTao) {
        this.fiNgayTao = fiNgayTao;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public String getFiVietTat() {
        return fiVietTat;
    }

    public void setFiVietTat(String fiVietTat) {
        this.fiVietTat = fiVietTat;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiIdCqxl != null ? fiIdCqxl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbscqxl8)) {
            return false;
        }
        Tbscqxl8 other = (Tbscqxl8) object;
        if ((this.fiIdCqxl == null && other.fiIdCqxl != null) || (this.fiIdCqxl != null && !this.fiIdCqxl.equals(other.fiIdCqxl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.monre.p08.model.Tbscqxl8[ fiIdCqxl=" + fiIdCqxl + " ]";
    }
    
}
