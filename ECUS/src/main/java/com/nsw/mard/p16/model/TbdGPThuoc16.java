package com.nsw.mard.p16.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


/***
*
*
* @Model
* @class TbdGPThuoc16
* Created by Nguyen Van Quang
* 11/12/2018 10:06:57
*
*/
public class TbdGPThuoc16 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	@NotNull
	private Long fiIdHoSo;

	@NotNull
	private Integer fiSort;

	@NotNull
	@Size(max = 250)
	@NotEmpty
	private String fiNameOfGoods;

	@NotNull
	@Size(max = 250)
	@NotEmpty
	private String fiNameSicenceOfGoods;


	@NotNull
	@NotEmpty
	@Size(max = 250)
	private String fiType;

	@NotNull
	private  Double fiQuantity;

	@NotEmpty
	@NotNull
	@Size(max = 18)
	private String fiQuantityUnitCode;

	@NotEmpty
	@NotNull
	@Size(max = 255)
	private String fiQuantityUnitName;

	@NotEmpty
	@NotNull
	@Size(max = 6)
	private String fiExporterCode;

	@NotEmpty
	@NotNull
	@Size(max = 255)
	private String fiExporterName;

	@NotEmpty
	@NotNull
	@Size(max = 2000)
	private String fiGateOfImportation;

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
}