package com.nsw.mard.p15.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


/***
*
*
* @Model
* @class TbdGPThuoc15
* Created by Nguyen Van Quang
* 11/12/2018 10:06:57
*
*/
public class TbdGPThuoc15 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	private Long fiIdHoSo;

	private Integer fiSort;

	private String fiNameSicenceOfGoods;

	private String fiNameOfGoods;

	private String fiSpecies;

	private String fiOriginal;

	private String fiDateCollect;

	private String fiOrganization;

	private String fiType;

	private Double fiQuantity;

	private String fiQuantityUnitCode;

	private String fiQuantityUnitName;

	private String fiGateOfImportationName;

	public Long getFiId() {
		return fiId;
	}

	public void setFiId(Long fiId) {
		this.fiId = fiId;
	}

	public Long getFiIdHoSo() {
		return fiIdHoSo;
	}

	public void setFiIdHoSo(Long fiIdHoSo) {
		this.fiIdHoSo = fiIdHoSo;
	}

	public Integer getFiSort() {
		return fiSort;
	}

	public void setFiSort(Integer fiSort) {
		this.fiSort = fiSort;
	}

	public String getFiNameSicenceOfGoods() {
		return fiNameSicenceOfGoods;
	}

	public void setFiNameSicenceOfGoods(String fiNameSicenceOfGoods) {
		this.fiNameSicenceOfGoods = fiNameSicenceOfGoods;
	}

	public String getFiNameOfGoods() {
		return fiNameOfGoods;
	}

	public void setFiNameOfGoods(String fiNameOfGoods) {
		this.fiNameOfGoods = fiNameOfGoods;
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