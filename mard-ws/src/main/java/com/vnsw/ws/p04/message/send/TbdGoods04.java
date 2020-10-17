/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.message.send;

import java.math.BigDecimal;
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
@XmlType(name = "Goodslist")
public class TbdGoods04 {

    @XmlTransient
    private Long goodsId;
    @XmlTransient
    private Long registrationProfileId;
    @XmlTransient
    private String nswfileCode;
    @XmlElement(name = "CodeOfGoods")
    private String codeOfGoods;
    @XmlElement(name = "NameOfGoods")
    private String nameOfGoods;
    @XmlElement(name = "ParentGoodsCode")
    private String parentGoodsCode;
    @XmlElement(name = "ParentGoodsName")
    private String parentGoodsName;
    @XmlElement(name = "TypeGoodsCode")
    private Long typeGoodsCode;
    @XmlElement(name = "TypeGoodsName")
    private String typeGoodsName;
    @XmlElement(name = "UseGoodsCode")
    private Long useGoodsCode;
    @XmlElement(name = "UseGoodsName")
    private String useGoodsName;
    @XmlElement(name = "NameSicenceOfGoods")
    private String nameSicenceOfGoods;
    @XmlElement(name = "Quantity")
    private BigDecimal quantity;
    @XmlElement(name = "QuantityUnitCode")
    private String quantityUnitCode;
    @XmlElement(name = "QuantityUnitName")
    private String quantityUnitName;
    @XmlElement(name = "NetWeight")
    private BigDecimal netWeight;
    @XmlElement(name = "NetWeightUnitCode")
    private String netWeightUnitCode;
    @XmlElement(name = "NetWeightUnitName")
    private String netWeightUnitName;
    @XmlElement(name = "GrossWeight")
    private BigDecimal grossWeight;
    @XmlElement(name = "GrossWeightUnitCode")
    private String grossWeightUnitCode;
    @XmlElement(name = "GrossWeightUnitName")
    private String grossWeightUnitName;
    @XmlElement(name = "RegistrationNo")
    private String registrationNo;
    @XmlElement(name = "Manufacture")
    private String manufacture;
    @XmlElement(name = "ManufactureAddress")
    private String manufactureAddress;
    @XmlElement(name = "OriginationCode")
    private String originationCode;
    @XmlElement(name = "OriginationName")
    private String originationName;
    @XmlElement(name = "Value")
    private BigDecimal value;
    @XmlElement(name = "ValueUnitCode")
    private String valueunitCode;
    @XmlElement(name = "ValueUnitName")
    private String valueunitName;
    @XmlTransient
    private Long isActive;
    @XmlTransient
    private String createBy;
    @XmlTransient
    private Date createDate;
    @XmlElementWrapper(name = "AnanyticalRequiredList")
    @XmlElement(name = "Ananytical")
    private List<TbdAnanyticalRequired04> lstChiTieu04;

    public TbdGoods04() {
    }

    public List<TbdAnanyticalRequired04> getLstChiTieu04() {
        return lstChiTieu04;
    }

    public void setLstChiTieu04(List<TbdAnanyticalRequired04> lstChiTieu04) {
        this.lstChiTieu04 = lstChiTieu04;
    }

    public TbdGoods04(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getRegistrationProfileId() {
        return registrationProfileId;
    }

    public void setRegistrationProfileId(Long registrationProfileId) {
        this.registrationProfileId = registrationProfileId;
    }

    public String getNswfileCode() {
        return nswfileCode;
    }

    public void setNswfileCode(String nswfileCode) {
        this.nswfileCode = nswfileCode;
    }

    public String getNameOfGoods() {
        return nameOfGoods;
    }

    public void setNameOfGoods(String nameOfGoods) {
        this.nameOfGoods = nameOfGoods;
    }

    public String getParentGoodsCode() {
        return parentGoodsCode;
    }

    public void setParentGoodsCode(String parentGoodsCode) {
        this.parentGoodsCode = parentGoodsCode;
    }

    public String getNameSicenceOfGoods() {
        return nameSicenceOfGoods;
    }

    public void setNameSicenceOfGoods(String nameSicenceOfGoods) {
        this.nameSicenceOfGoods = nameSicenceOfGoods;
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

    public String getNetWeightUnitCode() {
        return netWeightUnitCode;
    }

    public void setNetWeightUnitCode(String netWeightUnitCode) {
        this.netWeightUnitCode = netWeightUnitCode;
    }

    public String getNetWeightUnitName() {
        return netWeightUnitName;
    }

    public void setNetWeightUnitName(String netWeightUnitName) {
        this.netWeightUnitName = netWeightUnitName;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
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

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getManufactureAddress() {
        return manufactureAddress;
    }

    public void setManufactureAddress(String manufactureAddress) {
        this.manufactureAddress = manufactureAddress;
    }

    public String getOriginationCode() {
        return originationCode;
    }

    public void setOriginationCode(String originationCode) {
        this.originationCode = originationCode;
    }

    public String getOriginationName() {
        return originationName;
    }

    public void setOriginationName(String originationName) {
        this.originationName = originationName;
    }

    public String getCodeOfGoods() {
        return codeOfGoods;
    }

    public void setCodeOfGoods(String codeOfGoods) {
        this.codeOfGoods = codeOfGoods;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getValueunitCode() {
        return valueunitCode;
    }

    public void setValueunitCode(String valueunitCode) {
        this.valueunitCode = valueunitCode;
    }

    public String getValueunitName() {
        return valueunitName;
    }

    public void setValueunitName(String valueunitName) {
        this.valueunitName = valueunitName;
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

    public String getParentGoodsName() {
        return parentGoodsName;
    }

    public void setParentGoodsName(String parentGoodsName) {
        this.parentGoodsName = parentGoodsName;
    }

    public Long getTypeGoodsCode() {
        return typeGoodsCode;
    }

    public void setTypeGoodsCode(Long typeGoodsCode) {
        this.typeGoodsCode = typeGoodsCode;
    }

    public String getTypeGoodsName() {
        return typeGoodsName;
    }

    public void setTypeGoodsName(String typeGoodsName) {
        this.typeGoodsName = typeGoodsName;
    }

    public Long getUseGoodsCode() {
        return useGoodsCode;
    }

    public void setUseGoodsCode(Long useGoodsCode) {
        this.useGoodsCode = useGoodsCode;
    }

    public String getUseGoodsName() {
        return useGoodsName;
    }

    public void setUseGoodsName(String useGoodsName) {
        this.useGoodsName = useGoodsName;
    }
    

}
