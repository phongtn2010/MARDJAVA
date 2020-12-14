/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p02.model;

/**
 *
 * @author Fujitsu
 */
public class TbdGoodlist02  {

    private Long goodId;
    private Long goodSort;
    private String goodName;
    private Long quantity;
    private String quantityUnitCode;
    private String quantityUnitName;
    private String exporterState;
    private Long quarantineCerId;

    public TbdGoodlist02() {
    }

    public TbdGoodlist02(Long goodId) {
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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
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

    public Long getQuarantineCerId() {
        return quarantineCerId;
    }

    public void setQuarantineCerId(Long quarantineCerId) {
        this.quarantineCerId = quarantineCerId;
    }


}
