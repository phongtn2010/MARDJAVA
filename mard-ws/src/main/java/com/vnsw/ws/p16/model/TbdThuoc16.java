package com.vnsw.ws.p16.model;

import java.io.Serializable;


/***
*
*
* @Model
* @class TbdThuoc16
* Created by Nguyen Van Quang
* 06/12/2018 10:167:52
*
*/
public class TbdThuoc16 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	private Long fiIdHoSo;

	private Integer fiSort;

	private String fiNameOfGoods;

	private String fiNameSicenceOfGoods;

	private String fiType;

	private  Double fiQuantity;

	private String fiQuantityUnitCode;

	private String fiQuantityUnitName;

	private String fiExporterCode;

	private String fiExporterName;

	private String fiGateOfImportation;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

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

	@Override
	public String toString() {
		return "TbdThuoc16{" +
				"fiId=" + fiId +
				", fiIdHoSo=" + fiIdHoSo +
				", fiSort=" + fiSort +
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