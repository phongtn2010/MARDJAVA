/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.entity;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Fujitsu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnanyticalRequiredList1")
public class TbdAnanytical04 {

    @XmlTransient
    private Long ananyticalId;

    @XmlElement(name = "AnanyticalName")
    private String ananyticalName;

    @XmlElement(name = "Required")
    private String required;

    @XmlElement(name = "Note")
    private String note;

    @XmlElement(name = "Unit")
    private String unit;

    @XmlTransient
    private Long  ananyticalGoodsId;

    @XmlTransient
    private Date createDate;

    public Long getAnanyticalId() {
        return ananyticalId;
    }

    public void setAnanyticalId(Long ananyticalId) {
        this.ananyticalId = ananyticalId;
    }

    public String getAnanyticalName() {
        return ananyticalName;
    }

    public void setAnanyticalName(String ananyticalName) {
        this.ananyticalName = ananyticalName;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getAnanyticalGoodsId() {
        return ananyticalGoodsId;
    }

    public void setAnanyticalGoodsId(Long ananyticalGoodsId) {
        this.ananyticalGoodsId = ananyticalGoodsId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
