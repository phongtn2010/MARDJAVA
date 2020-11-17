package com.vnsw.receive.gateway.common.bo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Linhdx
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomsDeclaration")
public class CustomsDeclaration {

	@XmlElement(name = "ImportNo")
	private String ImportNo;
	@XmlElement(name = "CustomsRegistrationDate")
	private String CustomsRegistrationDate;
	@XmlElement(name = "CustomsCode")
	private String CustomsCode;
	@XmlElement(name = "CustomsImportBussiness")
	private String CustomsImportBussiness;
	@XmlElement(name = "CustomsImportAddress")
	private String CustomsImportAddress;
	@XmlElement(name = "CustomsImportPhone")
	private String CustomsImportPhone;
	@XmlElement(name = "CustomsExportBussiness")
	private String CustomsExportBussiness;
	@XmlElement(name = "CustomsExportAddress")
	private String CustomsExportAddress;
	@XmlElement(name = "CustomsExportCountry")
	private String CustomsExportCountry;

	@XmlElementWrapper(name = "CustomsProductList")
	@XmlElement(name = "CustomsProduct")
	private List<CustomsProduct> CustomsProductList;

	@XmlElement(name = "CustomsGatheringPlace")
	private String CustomsGatheringPlace;
	@XmlElement(name = "CustomsDischargePlace")
	private String CustomsDischargePlace;

	@XmlElement(name = "CustomsBillOfLadingNo")
	private String CustomsBillOfLadingNo;
	@XmlElement(name = "CustomsInvoiceNo")
	private String CustomsInvoiceNo;
	@XmlElement(name = "CustomsInvoiceDate")
	private String CustomsInvoiceDate;
	@XmlElement(name = "CustomsQuantity")
	private String CustomsQuantity;

	@XmlElement(name = "CustomsQuantityUnitName")
	private String CustomsQuantityUnitName;
	@XmlElement(name = "CustomsGross")
	private String CustomsGross;
	@XmlElement(name = "CustomsGrossUnitName")
	private String CustomsGrossUnitName;

	public CustomsDeclaration() {

	}

	public String getImportNo() {
		return ImportNo;
	}

	public void setImportNo(String importNo) {
		ImportNo = importNo;
	}

	public String getCustomsRegistrationDate() {
		return CustomsRegistrationDate;
	}

	public void setCustomsRegistrationDate(String customsRegistrationDate) {
		CustomsRegistrationDate = customsRegistrationDate;
	}

	public String getCustomsCode() {
		return CustomsCode;
	}

	public void setCustomsCode(String customsCode) {
		CustomsCode = customsCode;
	}

	public String getCustomsImportBussiness() {
		return CustomsImportBussiness;
	}

	public void setCustomsImportBussiness(String customsImportBussiness) {
		CustomsImportBussiness = customsImportBussiness;
	}

	public String getCustomsImportAddress() {
		return CustomsImportAddress;
	}

	public void setCustomsImportAddress(String customsImportAddress) {
		CustomsImportAddress = customsImportAddress;
	}

	public String getCustomsImportPhone() {
		return CustomsImportPhone;
	}

	public void setCustomsImportPhone(String customsImportPhone) {
		CustomsImportPhone = customsImportPhone;
	}

	public String getCustomsExportBussiness() {
		return CustomsExportBussiness;
	}

	public void setCustomsExportBussiness(String customsExportBussiness) {
		CustomsExportBussiness = customsExportBussiness;
	}

	public String getCustomsExportAddress() {
		return CustomsExportAddress;
	}

	public void setCustomsExportAddress(String customsExportAddress) {
		CustomsExportAddress = customsExportAddress;
	}

	public String getCustomsExportCountry() {
		return CustomsExportCountry;
	}

	public void setCustomsExportCountry(String customsExportCountry) {
		CustomsExportCountry = customsExportCountry;
	}

	public List<CustomsProduct> getCustomsProductList() {
		return CustomsProductList;
	}

	public void setCustomsProductList(List<CustomsProduct> customsProductList) {
		CustomsProductList = customsProductList;
	}

	public String getCustomsGatheringPlace() {
		return CustomsGatheringPlace;
	}

	public void setCustomsGatheringPlace(String customsGatheringPlace) {
		CustomsGatheringPlace = customsGatheringPlace;
	}

	public String getCustomsDischargePlace() {
		return CustomsDischargePlace;
	}

	public void setCustomsDischargePlace(String customsDischargePlace) {
		CustomsDischargePlace = customsDischargePlace;
	}

	public String getCustomsBillOfLadingNo() {
		return CustomsBillOfLadingNo;
	}

	public void setCustomsBillOfLadingNo(String customsBillOfLadingNo) {
		CustomsBillOfLadingNo = customsBillOfLadingNo;
	}

	public String getCustomsInvoiceNo() {
		return CustomsInvoiceNo;
	}

	public void setCustomsInvoiceNo(String customsInvoiceNo) {
		CustomsInvoiceNo = customsInvoiceNo;
	}

	public String getCustomsInvoiceDate() {
		return CustomsInvoiceDate;
	}

	public void setCustomsInvoiceDate(String customsInvoiceDate) {
		CustomsInvoiceDate = customsInvoiceDate;
	}

	public String getCustomsQuantity() {
		return CustomsQuantity;
	}

	public void setCustomsQuantity(String customsQuantity) {
		CustomsQuantity = customsQuantity;
	}

	public String getCustomsQuantityUnitName() {
		return CustomsQuantityUnitName;
	}

	public void setCustomsQuantityUnitName(String customsQuantityUnitName) {
		CustomsQuantityUnitName = customsQuantityUnitName;
	}

	public String getCustomsGross() {
		return CustomsGross;
	}

	public void setCustomsGross(String customsGross) {
		CustomsGross = customsGross;
	}

	public String getCustomsGrossUnitName() {
		return CustomsGrossUnitName;
	}

	public void setCustomsGrossUnitName(String customsGrossUnitName) {
		CustomsGrossUnitName = customsGrossUnitName;
	}

}
