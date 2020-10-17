package com.vnsw.ws.p16.message;

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
@XmlType(propOrder = { "fiSort", "fiNameOfGoods", "fiNameSicenceOfGoods", "fiType", "fiQuantity", "fiQuantityUnitCode", "fiQuantityUnitName", "fiExporterCode","fiExporterName", "fiGateOfImportation"})
public class Goods {
	public Goods() {}
	@XmlElement(name = "Sort", required = true)
	private Integer fiSort;
	@XmlElement(name = "NameOfGoods", required = true)
	private String fiNameOfGoods;
	@XmlElement(name = "NameSicenceOfGoods", required = true)
	private String fiNameSicenceOfGoods;
	@XmlElement(name = "Type", required = true)
	private String fiType;
	@XmlElement(name = "Quantity", required = true)
	private  Double fiQuantity;
	@XmlElement(name = "QuantityUnitCode", required = true)
	private String fiQuantityUnitCode;
	@XmlElement(name = "QuantityUnitName", required = true)
	private String fiQuantityUnitName;
	@XmlElement(name = "ExporterCode", required = true)
	private String fiExporterCode;
	@XmlElement(name = "ExporterName", required = true)
	private String fiExporterName;
	@XmlElement(name = "GateOfImportation", required = true)
	private String fiGateOfImportation;

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

	public String getFiExporterCode() {
		return fiExporterCode;
	}

	public void setFiExporterCode(String fiExporterCode) {
		this.fiExporterCode = fiExporterCode;
	}

	public String getFiExporterName() {
		return fiExporterName;
	}

	public void setFiExporterName(String fiExporterName) {
		this.fiExporterName = fiExporterName;
	}

	public String getFiGateOfImportation() {
		return fiGateOfImportation;
	}

	public void setFiGateOfImportation(String fiGateOfImportation) {
		this.fiGateOfImportation = fiGateOfImportation;
	}

	@Override
	public String toString() {
		return "Goods{" +
				"fiSort=" + fiSort +
				", fiNameOfGoods='" + fiNameOfGoods + '\'' +
				", fiNameSicenceOfGoods='" + fiNameSicenceOfGoods + '\'' +
				", fiType='" + fiType + '\'' +
				", fiQuantity=" + fiQuantity +
				", fiQuantityUnitCode='" + fiQuantityUnitCode + '\'' +
				", fiQuantityUnitName='" + fiQuantityUnitName + '\'' +
				", fiExporterCode='" + fiExporterCode + '\'' +
				", fiExporterName='" + fiExporterName + '\'' +
				", fiGateOfImportation='" + fiGateOfImportation + '\'' +
				'}';
	}
}