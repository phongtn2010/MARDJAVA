package com.nsw.mard.p14.model;

import java.io.Serializable;


/***
*
*
* @Model
* @class TbdGPThuoc14
* Created by Nguyen Van Quang
* 11/12/2018 10:06:57
*
*/
public class TbdGPThuoc14 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	private Long fiIdHoSo;

	private Integer fiSort;

	private Integer fiTypeGood;

	private String fiNameOfGoods;

	private Double fiWeight;

	private String fiWeightUnitCode;

	private String fiWeightUnitName;

	private String fiMainUse;

	private String fiOrigin;

	public Long getFiId() {
		return this.fiId;
	}

	public void setFiId(Long fiId) {
		this.fiId = fiId;
	}

	public Long getFiIdHoSo() {
		return this.fiIdHoSo;
	}

	public void setFiIdHoSo(Long fiIdHoSo) {
		this.fiIdHoSo = fiIdHoSo;
	}

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
		return "TbdGPThuoc14 [" +
				"fiId=" + fiId + "," + 
				"fiIdHoSo=" + fiIdHoSo + "," + 
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