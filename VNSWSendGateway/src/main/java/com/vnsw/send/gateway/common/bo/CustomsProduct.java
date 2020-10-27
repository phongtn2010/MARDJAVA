package com.vnsw.send.gateway.common.bo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Linhdx
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomsProduct")
public class CustomsProduct {

	@XmlElement(name = "CustomsHSCode")
	private String CustomsHSCode;
	@XmlElement(name = "CustomsProductName")
	private String CustomsProductName;
	@XmlElement(name = "CustomsQuantityVolume")
	private String CustomsQuantityVolume;
	@XmlElement(name = "CustomsUnitName")
	private String CustomsUnitName;

	public CustomsProduct() {

	}

	public String getCustomsHSCode() {
		return CustomsHSCode;
	}

	public void setCustomsHSCode(String customsHSCode) {
		CustomsHSCode = customsHSCode;
	}

	public String getCustomsProductName() {
		return CustomsProductName;
	}

	public void setCustomsProductName(String customsProductName) {
		CustomsProductName = customsProductName;
	}

	public String getCustomsQuantityVolume() {
		return CustomsQuantityVolume;
	}

	public void setCustomsQuantityVolume(String customsQuantityVolume) {
		CustomsQuantityVolume = customsQuantityVolume;
	}

	public String getCustomsUnitName() {
		return CustomsUnitName;
	}

	public void setCustomsUnitName(String customsUnitName) {
		CustomsUnitName = customsUnitName;
	}

}
