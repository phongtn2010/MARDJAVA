package com.vnsw.ws.p14.message;

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
@XmlType(propOrder = { "fiSort", "fiTypeGood", "fiNameOfGoods", "fiWeight", "fiWeightUnitCode", "fiWeightUnitName", "fiMainUse", "fiOrigin"})
public class Goods {

	public Goods() {}

	@XmlElement(name = "Sort", required = true)
	private Integer fiSort;

	@XmlElement(name = "TypeGood", required = true)
	private Integer fiTypeGood;

	@XmlElement(name = "NameOfGoods", required = true)
	private String fiNameOfGoods;

	@XmlElement(name = "Weight", required = true)
	private Double fiWeight;

	@XmlElement(name = "WeightUnitCode", required = true)
	private String fiWeightUnitCode;

	@XmlElement(name = "WeightUnitName", required = true)
	private String fiWeightUnitName;

	@XmlElement(name = "MainUse", required = true)
	private String fiMainUse;

	@XmlElement(name = "Origin", required = true)
	private String fiOrigin;

	public Integer getFiSort() {
		return this.fiSort;
	}

	public void setFiSort(Integer fiSort) {
		this.fiSort = fiSort;
	}

	public Integer getFiTypeGood() {
		return this.fiTypeGood;
	}

	public void setFiTypeGood(Integer fiTypeGood) {
		this.fiTypeGood = fiTypeGood;
	}

	public String getFiNameOfGoods() {
		return this.fiNameOfGoods;
	}

	public void setFiNameOfGoods(String fiNameOfGoods) {
		this.fiNameOfGoods = fiNameOfGoods;
	}

	public Double getFiWeight() {
		return this.fiWeight;
	}

	public void setFiWeight(Double fiWeight) {
		this.fiWeight = fiWeight;
	}

	public String getFiWeightUnitCode() {
		return this.fiWeightUnitCode;
	}

	public void setFiWeightUnitCode(String fiWeightUnitCode) {
		this.fiWeightUnitCode = fiWeightUnitCode;
	}

	public String getFiWeightUnitName() {
		return this.fiWeightUnitName;
	}

	public void setFiWeightUnitName(String fiWeightUnitName) {
		this.fiWeightUnitName = fiWeightUnitName;
	}

	public String getFiMainUse() {
		return this.fiMainUse;
	}

	public void setFiMainUse(String fiMainUse) {
		this.fiMainUse = fiMainUse;
	}

	public String getFiOrigin() {
		return this.fiOrigin;
	}

	public void setFiOrigin(String fiOrigin) {
		this.fiOrigin = fiOrigin;
	}

	@Override
	public String toString() {
		return "Goods [" +
				"fiSort=" + fiSort + "," + 
				"fiTypeGood=" + fiTypeGood + "," + 
				"fiNameOfGoods=" + fiNameOfGoods + "," + 
				"fiWeight=" + fiWeight + "," + 
				"fiWeightUnitCode=" + fiWeightUnitCode + "," + 
				"fiWeightUnitName=" + fiWeightUnitName + "," + 
				"fiMainUse=" + fiMainUse + "," + 
				"fiOrigin=" + fiOrigin + "]";
	}
}