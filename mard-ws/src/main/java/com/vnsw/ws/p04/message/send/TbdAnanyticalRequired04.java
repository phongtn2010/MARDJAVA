/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.message.send;

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
@XmlType(name = "AnanyticalRequiredList")
public class TbdAnanyticalRequired04 {
    @XmlTransient
    private Long ananyticalId;
    @XmlElement(name = "AnanyticalCode")
    private String ananyticalCode;
    @XmlElement(name = "AnanyticalName")
    private String ananyticalName;
    @XmlElement(name = "Unit")
    private String unit;
    @XmlElement(name = "Required")
    private String required;
    @XmlElement(name = "Note")
    private String note;
    @XmlTransient
    private Long goodsId;
    @XmlTransient
    private Long isActive;
    @XmlTransient
    private String createBy;
    @XmlTransient
    private Date createDate;

    public TbdAnanyticalRequired04() {
    }

    public TbdAnanyticalRequired04(Long ananyticalId) {
        this.ananyticalId = ananyticalId;
    }

    public Long getAnanyticalId() {
        return ananyticalId;
    }

    public void setAnanyticalId(Long ananyticalId) {
        this.ananyticalId = ananyticalId;
    }

    public String getAnanyticalCode() {
        return ananyticalCode;
    }

    public void setAnanyticalCode(String ananyticalCode) {
        this.ananyticalCode = ananyticalCode;
    }

    public String getAnanyticalName() {
        return ananyticalName;
    }

    public void setAnanyticalName(String ananyticalName) {
        this.ananyticalName = ananyticalName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
}
