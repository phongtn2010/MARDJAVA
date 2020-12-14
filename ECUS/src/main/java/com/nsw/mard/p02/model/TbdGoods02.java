/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p02.model;

import java.io.Serializable;

/**
 *
 * @author Fujitsu
 */
public class TbdGoods02 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long goodId;
    private Long goodSort;
    private String goodName;
    private Long quantily;
    private String quantityUnitCode;
    private String quantityUnitName;
    private String exporterState;
    private Long regisGood17Id;
    private Long regisGood18Id;

    public TbdGoods02() {
    }

    public TbdGoods02(Long goodId) {
        this.goodId = goodId;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public Long getGoodSort() {
        return goodSort;
    }

    public void setGoodSort(Long goodSort) {
        this.goodSort = goodSort;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Long getQuantily() {
        return quantily;
    }

    public void setQuantily(Long quantily) {
        this.quantily = quantily;
    }

    public String getQuantityUnitCode() {
        return quantityUnitCode;
    }

    public void setQuantityUnitCode(String quantityUnitCode) {
        this.quantityUnitCode = quantityUnitCode;
    }

    public String getQuantityUnitName() {
        return quantityUnitName;
    }

    public void setQuantityUnitName(String quantityUnitName) {
        this.quantityUnitName = quantityUnitName;
    }

    public String getExporterState() {
        return exporterState;
    }

    public void setExporterState(String exporterState) {
        this.exporterState = exporterState;
    }

    public Long getRegisGood17Id() {
        return regisGood17Id;
    }

    public void setRegisGood17Id(Long regisGood17Id) {
        this.regisGood17Id = regisGood17Id;
    }

    public Long getRegisGood18Id() {
        return regisGood18Id;
    }

    public void setRegisGood18Id(Long regisGood18Id) {
        this.regisGood18Id = regisGood18Id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (goodId != null ? goodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdGoods02)) {
            return false;
        }
        TbdGoods02 other = (TbdGoods02) object;
        if ((this.goodId == null && other.goodId != null) || (this.goodId != null && !this.goodId.equals(other.goodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.mard.p02.model.TbdGoods02[ goodId=" + goodId + " ]";
    }
    
}
