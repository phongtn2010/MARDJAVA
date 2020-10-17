/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author phongnv
 */
@Entity
@Table(name = "\"Cmon_Dvkd\"")
@XmlRootElement
@NamedQueries({})
public class CmonDvkd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"DvkdID\"")
    private Long dvkdID;
    @Size(max = 20)
    @Column(name = "\"DvkdCode\"")
    private String dvkdCode;
    @Size(max = 250)
    @Column(name = "\"DvkdName\"")
    private String dvkdName;
    @Column(name = "\"SystemID\"")
    private Long systemID;
    @Column(name = "\"ParentID\"")
    private Long parentID;
    @Column(name = "\"OrderID\"")
    private Long orderID;

    public CmonDvkd() {
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public CmonDvkd(Long dvkdID) {
        this.dvkdID = dvkdID;
    }

    public Long getDvkdID() {
        return dvkdID;
    }

    public void setDvkdID(Long dvkdID) {
        this.dvkdID = dvkdID;
    }

    public String getDvkdCode() {
        return dvkdCode;
    }

    public void setDvkdCode(String dvkdCode) {
        this.dvkdCode = dvkdCode;
    }

    public String getDvkdName() {
        return dvkdName;
    }

    public void setDvkdName(String dvkdName) {
        this.dvkdName = dvkdName;
    }

    public Long getSystemID() {
        return systemID;
    }

    public void setSystemID(Long systemID) {
        this.systemID = systemID;
    }

    public Long getParentID() {
        return parentID;
    }

    public void setParentID(Long parentID) {
        this.parentID = parentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dvkdID != null ? dvkdID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CmonDvkd)) {
            return false;
        }
        CmonDvkd other = (CmonDvkd) object;
        if ((this.dvkdID == null && other.dvkdID != null) || (this.dvkdID != null && !this.dvkdID.equals(other.dvkdID))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "\"com.nsw.backend.mard.p10.model.CmonDvkd[ dvkdID="\" + dvkdID + "\" ]"\";
//    }
    
}
