package com.nsw.mard.p18.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


/***
*
*
* @Model
* @class TbdGPThuoc18
* Created by Nguyen Van Quang
* 11/12/2018 10:06:58
*
*/
public class TbdTBKetQuaThuoc18 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	private Long fiIdHoSo;

	private Integer fiSort;

	private Integer fiProductType;

	private String fiNameOfGoods;

	private String fiCirculationNo;

	private String fiSerialNo;

	private String fiDocumentNo;

	private String fiTypeOfPackage;

	private String fiManufacturerName;


	private String fiActiveIngredient;


	private Double fiWeight;

	private String fiWeightUnitCode;

	private String fiWeightUnitName;

	private String fiCountryName;

	private String fiCountryCode;

	private Double fiWeightKG;

	private Double fiWeightML;

	private String fiTestResult;

	private String fiDosageType;

	private String fiNote;

	private String fiTotalResult;

	private String fiImporterName;

	public String getFiTotalResult() {
		return fiTotalResult;
	}

	public void setFiTotalResult(String fiTotalResult) {
		this.fiTotalResult = fiTotalResult;
	}

	public String getFiImporterName() {
		return fiImporterName;
	}

	public void setFiImporterName(String fiImporterName) {
		this.fiImporterName = fiImporterName;
	}

	public Double getFiWeightKG() {
		return fiWeightKG;
	}

	public void setFiWeightKG(Double fiWeightKG) {
		this.fiWeightKG = fiWeightKG;
	}

	public Double getFiWeightML() {
		return fiWeightML;
	}

	public void setFiWeightML(Double fiWeightML) {
		this.fiWeightML = fiWeightML;
	}

	public String getFiNote() {
		return fiNote;
	}

	public void setFiNote(String fiNote) {
		this.fiNote = fiNote;
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

	public Integer getFiProductType() {
		return fiProductType;
	}

	public void setFiProductType(Integer fiProductType) {
		this.fiProductType = fiProductType;
	}

	public String getFiNameOfGoods() {
		return fiNameOfGoods;
	}

	public void setFiNameOfGoods(String fiNameOfGoods) {
		this.fiNameOfGoods = fiNameOfGoods;
	}

	public String getFiCirculationNo() {
		return fiCirculationNo;
	}

	public void setFiCirculationNo(String fiCirculationNo) {
		this.fiCirculationNo = fiCirculationNo;
	}

	public String getFiSerialNo() {
		return fiSerialNo;
	}

	public void setFiSerialNo(String fiSerialNo) {
		this.fiSerialNo = fiSerialNo;
	}

	public String getFiDocumentNo() {
		return fiDocumentNo;
	}

	public void setFiDocumentNo(String fiDocumentNo) {
		this.fiDocumentNo = fiDocumentNo;
	}

	public String getFiTypeOfPackage() {
		return fiTypeOfPackage;
	}

	public void setFiTypeOfPackage(String fiTypeOfPackage) {
		this.fiTypeOfPackage = fiTypeOfPackage;
	}

	public String getFiManufacturerName() {
		return fiManufacturerName;
	}

	public void setFiManufacturerName(String fiManufacturerName) {
		this.fiManufacturerName = fiManufacturerName;
	}

	public String getFiActiveIngredient() {
		return fiActiveIngredient;
	}

	public void setFiActiveIngredient(String fiActiveIngredient) {
		this.fiActiveIngredient = fiActiveIngredient;
	}

	public Double getFiWeight() {
		return fiWeight;
	}

	public void setFiWeight(Double fiWeight) {
		this.fiWeight = fiWeight;
	}

	public String getFiWeightUnitCode() {
		return fiWeightUnitCode;
	}

	public void setFiWeightUnitCode(String fiWeightUnitCode) {
		this.fiWeightUnitCode = fiWeightUnitCode;
	}

	public String getFiWeightUnitName() {
		return fiWeightUnitName;
	}

	public void setFiWeightUnitName(String fiWeightUnitName) {
		this.fiWeightUnitName = fiWeightUnitName;
	}

	public String getFiCountryName() {
		return fiCountryName;
	}

	public void setFiCountryName(String fiCountryName) {
		this.fiCountryName = fiCountryName;
	}

	public String getFiCountryCode() {
		return fiCountryCode;
	}

	public void setFiCountryCode(String fiCountryCode) {
		this.fiCountryCode = fiCountryCode;
	}

	public String getFiTestResult() {
		return fiTestResult;
	}

	public void setFiTestResult(String fiTestResult) {
		this.fiTestResult = fiTestResult;
	}

	public String getFiDosageType() {
		return fiDosageType;
	}

	public void setFiDosageType(String fiDosageType) {
		this.fiDosageType = fiDosageType;
	}

	@Override
	public String toString() {
		return "TbdGPThuoc18{" +
				"fiId=" + fiId +
				", fiIdHoSo=" + fiIdHoSo +
				", fiSort=" + fiSort +
				", fiProductType=" + fiProductType +
				", fiNameOfGoods='" + fiNameOfGoods + '\'' +
				", fiCirculationNo='" + fiCirculationNo + '\'' +
				", fiSerialNo='" + fiSerialNo + '\'' +
				", fiDocumentNo='" + fiDocumentNo + '\'' +
				", fiTypeOfPackage='" + fiTypeOfPackage + '\'' +
				", fiManufacturerName='" + fiManufacturerName + '\'' +
				", fiActiveIngredient='" + fiActiveIngredient + '\'' +
				", fiWeight=" + fiWeight +
				", fiWeightUnitCode='" + fiWeightUnitCode + '\'' +
				", fiWeightUnitName='" + fiWeightUnitName + '\'' +
				", fiCountryName='" + fiCountryName + '\'' +
				", fiCountryCode='" + fiCountryCode + '\'' +
				'}';
	}


}
