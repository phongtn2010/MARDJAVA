package com.nsw.mard.p03.model;

import java.io.Serializable;


public class TbdHangHoa03 implements Serializable {

    private Long productId;
    private Long productSort;
    private String fiHsCode;
    private String productName;
    private Long quantity;
    private String quantityUnitCode;
    private String quantityUnitName;
    private String animalBreed;
    private Long animalMale;
    private String animalMaleName;
    private Long animalAge;
    private Long netWeight;
    private String netWeightUnitCode;
    private String netWeightUnitName;
    private Long grossWeight;
    private String grossWeightUnitCode;
    private String grossWeightUnitName;
    private String packings;
    private Long fiIdHoSo;
    private String fiMaHoSo;
    private String productFrom;
    private Long productValue;

    //them cho transient
    private String donviXl;
    private String fiCuakhauXuat;
    private String ptVanchuyen;
    private String soNiemphong;
    private String ptVchuyenMoi;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductSort() {
        return productSort;
    }

    public void setProductSort(Long productSort) {
        this.productSort = productSort;
    }

    public String getFiHsCode() {
        return fiHsCode;
    }

    public void setFiHsCode(String fiHsCode) {
        this.fiHsCode = fiHsCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getAnimalBreed() {
        return animalBreed;
    }

    public void setAnimalBreed(String animalBreed) {
        this.animalBreed = animalBreed;
    }

    public Long getAnimalMale() {
        return animalMale;
    }

    public void setAnimalMale(Long animalMale) {
        this.animalMale = animalMale;
    }

    public String getAnimalMaleName() {
        return animalMaleName;
    }

    public void setAnimalMaleName(String animalMaleName) {
        this.animalMaleName = animalMaleName;
    }

    public Long getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(Long animalAge) {
        this.animalAge = animalAge;
    }

    public Long getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Long netWeight) {
        this.netWeight = netWeight;
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

    public Long getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Long grossWeight) {
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

    public String getPackings() {
        return packings;
    }

    public void setPackings(String packings) {
        this.packings = packings;
    }

    public Long getFiIdHoSo() {
        return fiIdHoSo;
    }

    public void setFiIdHoSo(Long fiIdHoSo) {
        this.fiIdHoSo = fiIdHoSo;
    }

    public String getFiMaHoSo() {
        return fiMaHoSo;
    }

    public void setFiMaHoSo(String fiMaHoSo) {
        this.fiMaHoSo = fiMaHoSo;
    }

    public String getProductFrom() {
        return productFrom;
    }

    public void setProductFrom(String productFrom) {
        this.productFrom = productFrom;
    }

    public Long getProductValue() {
        return productValue;
    }

    public void setProductValue(Long productValue) {
        this.productValue = productValue;
    }

    public String getDonviXl() {
        return donviXl;
    }

    public void setDonviXl(String donviXl) {
        this.donviXl = donviXl;
    }

    public String getFiCuakhauXuat() {
        return fiCuakhauXuat;
    }

    public void setFiCuakhauXuat(String fiCuakhauXuat) {
        this.fiCuakhauXuat = fiCuakhauXuat;
    }

    public String getPtVanchuyen() {
        return ptVanchuyen;
    }

    public void setPtVanchuyen(String ptVanchuyen) {
        this.ptVanchuyen = ptVanchuyen;
    }

    public String getSoNiemphong() {
        return soNiemphong;
    }

    public void setSoNiemphong(String soNiemphong) {
        this.soNiemphong = soNiemphong;
    }

    public String getPtVchuyenMoi() {
        return ptVchuyenMoi;
    }

    public void setPtVchuyenMoi(String ptVchuyenMoi) {
        this.ptVchuyenMoi = ptVchuyenMoi;
    }
}