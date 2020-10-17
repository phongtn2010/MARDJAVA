/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.entity;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Fujitsu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnanyticalCheckedList")
public class TbdAnanyticalCheckedList04 {

    @XmlTransient
    private Long ananyticalCheckedListId;

    @XmlElement(name = "NSWFileCode")
    private String nswFilecode;

    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods")
    private List<TbdAnanyticalGoods04> goodsList;

    @XmlTransient
    private Long isActive;

    @XmlTransient
    private Date createDate;

    public Long getAnanyticalCheckedListId() {
        return ananyticalCheckedListId;
    }

    public void setAnanyticalCheckedListId(Long ananyticalCheckedListId) {
        this.ananyticalCheckedListId = ananyticalCheckedListId;
    }

    public String getNswFilecode() {
        return nswFilecode;
    }

    public void setNswFilecode(String nswFilecode) {
        this.nswFilecode = nswFilecode;
    }

    public List<TbdAnanyticalGoods04> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<TbdAnanyticalGoods04> goodsList) {
        this.goodsList = goodsList;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
