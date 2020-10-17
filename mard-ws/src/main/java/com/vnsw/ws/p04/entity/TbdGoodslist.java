/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.entity;

import com.vnsw.ws.annotations.DateSerialization;
import java.math.BigDecimal;
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
@XmlType(name = "GoodsList")
public class TbdGoodslist {

    @XmlTransient
    private Long goodslistId;
    @XmlElement(name = "CodeOfGoods")
    private String codeOfGoods;
    @XmlElement(name = "NameOfGoods")
    private String nameOfGoods;
    @XmlElement(name = "DescriptionOfGoods")
    private String descriptionOfGoods;
    @XmlElement(name = "Quantity")
    private Long quantity;
    @XmlElement(name = "QuantityUnitCode")
    private String quantityUnitCode;
    @XmlElement(name = "QuantityUnitName")
    private String quantityUnitName;
    @XmlTransient
    private String quantityText;
    @XmlElement(name = "GrossWeight")
    private BigDecimal grossWeight;
    @XmlElement(name = "GrossWeightName")
    private String grossWeightName;
    @XmlElement(name = "GrossWeightUnit")
    private String grossWeightUnit;
    @XmlElement(name = "GrossWeightUnitCode")
    private String grossWeightUnitCode;
    @XmlElement(name = "GrossWeightUnitName")
    private String grossWeightUnitName;
    @XmlTransient
    private String grossWeightText;
    @XmlTransient
    private Long phytosanitaryDetainId;
    @XmlTransient
    private Long isActive;
    @XmlTransient
    private String createBy;
    @XmlTransient
    private Long temporaryPhytosanitaryId;
    @XmlElement(name = "CriteriaAnalysisNo")
    private String criteriaAnalysisNo;
    @XmlElement(name = "CriteriaAnalysisDate")
    private String criteriaAnalysisDate;
    @XmlElement(name = "Result")
    private Long result;
    @XmlElement(name = "Reason")
    private String reason;

    public TbdGoodslist() {
    }

    public TbdGoodslist(Long goodslistId) {
        this.goodslistId = goodslistId;
    }

    public Long getGoodslistId() {
        return goodslistId;
    }

    public void setGoodslistId(Long goodslistId) {
        this.goodslistId = goodslistId;
    }

    public String getCodeOfGoods() {
        return codeOfGoods;
    }

    public void setCodeOfGoods(String codeOfGoods) {
        this.codeOfGoods = codeOfGoods;
    }

    public String getNameOfGoods() {
        return nameOfGoods;
    }

    public void setNameOfGoods(String nameOfGoods) {
        this.nameOfGoods = nameOfGoods;
    }

    public String getQuantityUnitName() {
        return quantityUnitName;
    }

    public void setQuantityUnitName(String quantityUnitName) {
        this.quantityUnitName = quantityUnitName;
    }

    public String getQuantityUnitCode() {
        return quantityUnitCode;
    }

    public void setQuantityUnitCode(String quantityUnitCode) {
        this.quantityUnitCode = quantityUnitCode;
    }

    public String getQuantityText() {
        return quantityText;
    }

    public void setQuantityText(String quantityText) {
        this.quantityText = quantityText;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getGrossWeightName() {
        return grossWeightName;
    }

    public void setGrossWeightName(String grossWeightName) {
        this.grossWeightName = grossWeightName;
    }

    public String getGrossWeightUnit() {
        return grossWeightUnit;
    }

    public void setGrossWeightUnit(String grossWeightUnit) {
        this.grossWeightUnit = grossWeightUnit;
    }

    public String getGrossWeightText() {
        return grossWeightText;
    }

    public void setGrossWeightText(String grossWeightText) {
        this.grossWeightText = grossWeightText;
    }

    public Long getPhytosanitaryDetainId() {
        return phytosanitaryDetainId;
    }

    public void setPhytosanitaryDetainId(Long phytosanitaryDetainId) {
        this.phytosanitaryDetainId = phytosanitaryDetainId;
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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getTemporaryPhytosanitaryId() {
        return temporaryPhytosanitaryId;
    }

    public void setTemporaryPhytosanitaryId(Long temporaryPhytosanitaryId) {
        this.temporaryPhytosanitaryId = temporaryPhytosanitaryId;
    }

    public String getDescriptionOfGoods() {
        return descriptionOfGoods;
    }

    public void setDescriptionOfGoods(String descriptionOfGoods) {
        this.descriptionOfGoods = descriptionOfGoods;
    }

    public String getCriteriaAnalysisNo() {
        return criteriaAnalysisNo;
    }

    public void setCriteriaAnalysisNo(String criteriaAnalysisNo) {
        this.criteriaAnalysisNo = criteriaAnalysisNo;
    }

    public String getCriteriaAnalysisDate() {
        return criteriaAnalysisDate;
    }

    public void setCriteriaAnalysisDate(String criteriaAnalysisDate) {
        this.criteriaAnalysisDate = criteriaAnalysisDate;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getGrossWeightUnitCode() {
        return grossWeightUnitCode;
    }

    public void setGrossWeightUnitCode(String grossWeightUnitCode) {
        this.grossWeightUnitCode = grossWeightUnitCode;
    }

    public String getGrossWeightUnitName() {
        return grossWeightUnitName;
    }

    public void setGrossWeightUnitName(String grossWeightUnitName) {
        this.grossWeightUnitName = grossWeightUnitName;
    }

}
