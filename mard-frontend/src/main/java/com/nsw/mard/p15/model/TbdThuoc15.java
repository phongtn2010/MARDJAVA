package com.nsw.mard.p15.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/***
*
*
* @Model
* @class TbdThuoc15
* Created by Nguyen Van Quang
* 11/12/2018 10:06:156
*
*/
public class TbdThuoc15 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	@NotNull
	private Long fiIdHoSo;

	@NotNull
	private Integer fiSort;

	@NotNull
	@NotEmpty
	@Size(max = 250)
	private String fiNameSicenceOfGoods;

	@NotNull
	@NotBlank
	@Size(max = 250)
	private String fiNameOfGoods;

	@NotNull
	@NotBlank
	@Size(max = 250)
	private String fiSpecies;

	@NotNull
	@NotBlank
	@Size(max = 250)
	private String fiOriginal;

	@NotNull
	@NotBlank
	@Size(max = 100)
	private String fiDateCollect;

	@NotNull
	@NotBlank
	@Size(max = 250)
	private String fiOrganization;

	@NotNull
	@NotBlank
	@Size(max = 50)
	private String fiType;


	@NotNull
	private Double fiQuantity;

	@NotNull
	@NotBlank
	@Size(max = 18)
	private String fiQuantityUnitCode;

	@NotNull
	@NotBlank
	@Size(max = 255)
	private String fiQuantityUnitName;

	@NotNull
	@NotBlank
	@Size(max = 2000)
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

	@Override
	public String toString() {
		return "TbdGPThuoc15{" +
				"fiId=" + fiId +
				", fiIdHoSo=" + fiIdHoSo +
				", fiSort=" + fiSort +
				", fiNameSicenceOfGoods='" + fiNameSicenceOfGoods + '\'' +
				", fiNameOfGoods='" + fiNameOfGoods + '\'' +
				", fiSpecies='" + fiSpecies + '\'' +
				", fiOriginal='" + fiOriginal + '\'' +
				", fiDateCollect='" + fiDateCollect + '\'' +
				", fiOrganization='" + fiOrganization + '\'' +
				", fiType='" + fiType + '\'' +
				", fiQuantity=" + fiQuantity +
				", fiQuantityUnitCode='" + fiQuantityUnitCode + '\'' +
				", fiQuantityUnitName='" + fiQuantityUnitName + '\'' +
				", fiGateOfImportationName='" + fiGateOfImportationName + '\'' +
				'}';
	}
}