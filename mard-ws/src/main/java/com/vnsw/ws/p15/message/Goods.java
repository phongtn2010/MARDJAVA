package com.vnsw.ws.p15.message;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/***
*
*
* @Model
* @class Goods
* Created by Nguyen Van Quang
* 05/12/2018 17:18:48
*
*/
@XmlRootElement(name = "Goods")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiSort", "fiNameOfGoods", "fiNameSicenceOfGoods", "fiSpecies", "fiOriginal", "fiDateCollect", "fiOrganization", "fiType", "fiQuantity", "fiQuantityUnitCode", "fiQuantityUnitName", "fiGateOfImportationName"})
public class Goods {

	public Goods() {}

	@XmlElement(name = "Sort", required = true)
	private Integer fiSort;

	@XmlElement(name = "NameOfGoods", required = true)
	private String fiNameOfGoods;

	@XmlElement(name = "NameSicenceOfGoods", required = true)
	private String fiNameSicenceOfGoods;

	@XmlElement(name = "Species", required = true)
	private String fiSpecies;

	@XmlElement(name = "Original", required = true)
	private String fiOriginal;

	@XmlElement(name = "DateCollect", required = true)
	private String fiDateCollect;

	@XmlElement(name = "Organization", required = true)
	private String fiOrganization;

	@XmlElement(name = "Type", required = true)
	private String fiType;

	@XmlElement(name = "Quantity", required = true)
	private Double fiQuantity;

	@XmlElement(name = "QuantityUnitCode", required = true)
	private String fiQuantityUnitCode;

	@XmlElement(name = "QuantityUnitName", required = true)
	private String fiQuantityUnitName;

	@XmlElement(name = "GateOfImportationName", required = true)
	private String fiGateOfImportationName;

	public Integer getFiSort() {
		return fiSort;
	}

	public void setFiSort(Integer fiSort) {
		this.fiSort = fiSort;
	}

	public String getFiNameOfGoods() {
		return fiNameOfGoods;
	}

	public void setFiNameOfGoods(String fiNameOfGoods) {
		this.fiNameOfGoods = fiNameOfGoods;
	}

	public String getFiNameSicenceOfGoods() {
		return fiNameSicenceOfGoods;
	}

	public void setFiNameSicenceOfGoods(String fiNameSicenceOfGoods) {
		this.fiNameSicenceOfGoods = fiNameSicenceOfGoods;
	}

	public String getFiSpecies() {
		return fiSpecies;
	}

	public void setFiSpecies(String fiSpecies) {
		this.fiSpecies = fiSpecies;
	}

	public String getFiOriginal() {
		return fiOriginal;
	}

	public void setFiOriginal(String fiOriginal) {
		this.fiOriginal = fiOriginal;
	}

	public String getFiDateCollect() {
		return fiDateCollect;
	}

	public void setFiDateCollect(String fiDateCollect) {
		this.fiDateCollect = fiDateCollect;
	}

	public String getFiOrganization() {
		return fiOrganization;
	}

	public void setFiOrganization(String fiOrganization) {
		this.fiOrganization = fiOrganization;
	}

	public String getFiType() {
		return fiType;
	}

	public void setFiType(String fiType) {
		this.fiType = fiType;
	}

	public Double getFiQuantity() {
		return fiQuantity;
	}

	public void setFiQuantity(Double fiQuantity) {
		this.fiQuantity = fiQuantity;
	}

	public String getFiQuantityUnitCode() {
		return fiQuantityUnitCode;
	}

	public void setFiQuantityUnitCode(String fiQuantityUnitCode) {
		this.fiQuantityUnitCode = fiQuantityUnitCode;
	}

	public String getFiQuantityUnitName() {
		return fiQuantityUnitName;
	}

	public void setFiQuantityUnitName(String fiQuantityUnitName) {
		this.fiQuantityUnitName = fiQuantityUnitName;
	}

	public String getFiGateOfImportationName() {
		return fiGateOfImportationName;
	}

	public void setFiGateOfImportationName(String fiGateOfImportationName) {
		this.fiGateOfImportationName = fiGateOfImportationName;
	}
}