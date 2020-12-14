package com.nsw.mard.p20.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
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
 * @class TbdThuoc20
 * Created by Nguyen Van Quang
 * 11/12/2020 10:06:246
 *
 */
public class TbdThuoc20 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	private Long fiIdHoSo;

	private Integer fiSort;

	private Integer fiProductType;

	private Double fiWeight;

	private Double fiWeightKG;

	private Double fiWeightML;

	private String fiWeightUnitCode;


	private String fiWeightUnitName;


	private String fiCountryCode;


	private String fiCountryName;


	private String fiNameOfGoods;


	private String fiCirculationNo;


	private String fiSerialNo;


	private String fiDocumentNo;


	private String fiTypeOfPackage;


	private String fiManufacturerName;

	private String fiActiveIngredient;

	private String fiTestResult;

	private String fiDosageType;

	private String fiImporterName;

	private String fiLicenseFileByte;

	private String fiLicenseFileNo;


	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone="GMT+7")
	private Date fiImportTimeFrom;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT+7")
	private Date fiImportTimeTo;


	private String fiGate;


	public String getFiImporterName() {
		return fiImporterName;
	}

	public void setFiImporterName(String fiImporterName) {
		this.fiImporterName = fiImporterName;
	}



	private List<TbdDinhKem20> fiTepDinhKemThuocs;

	public List<TbdDinhKem20> getFiTepDinhKemThuocs() {
		return fiTepDinhKemThuocs;
	}

	public void setFiTepDinhKemThuocs(List<TbdDinhKem20> fiTepDinhKemThuocs) {
		this.fiTepDinhKemThuocs = fiTepDinhKemThuocs;
	}

	public String getFiLicenseFileByte() {
		return fiLicenseFileByte;
	}

	public void setFiLicenseFileByte(String fiLicenseFileByte) {
		this.fiLicenseFileByte = fiLicenseFileByte;
	}

	public String getFiLicenseFileNo() {
		return fiLicenseFileNo;
	}

	public void setFiLicenseFileNo(String fiLicenseFileNo) {
		this.fiLicenseFileNo = fiLicenseFileNo;
	}


	////
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

	public String getFiSerialNo() {
		return fiSerialNo;
	}

	public void setFiSerialNo(String fiSerialNo) {
		this.fiSerialNo = fiSerialNo;
	}

	public String getFiCountryCode() {
		return fiCountryCode;
	}

	public void setFiCountryCode(String fiCountryCode) {
		this.fiCountryCode = fiCountryCode;
	}

	public String getFiCountryName() {
		return fiCountryName;
	}

	public void setFiCountryName(String fiCountryName) {
		this.fiCountryName = fiCountryName;
	}

	public String getFiCirculationNo() {
		return fiCirculationNo;
	}

	public void setFiCirculationNo(String fiCirculationNo) {
		this.fiCirculationNo = fiCirculationNo;
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

	public Date getFiImportTimeFrom() {
		return fiImportTimeFrom;
	}

	public void setFiImportTimeFrom(Date fiImportTimeFrom) {
		this.fiImportTimeFrom = fiImportTimeFrom;
	}

	public Date getFiImportTimeTo() {
		return fiImportTimeTo;
	}

	public void setFiImportTimeTo(Date fiImportTimeTo) {
		this.fiImportTimeTo = fiImportTimeTo;
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
	public String getFiGate() {
		return fiGate;
	}

	public void setFiGate(String fiGate) {
		this.fiGate = fiGate;
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
		return "TbdThuoc20{" +
				"fiId=" + fiId +
				", fiIdHoSo=" + fiIdHoSo +
				", fiSort=" + fiSort +
				", fiDosageType=" + fiDosageType + '\'' +
				", fiProductType=" + fiProductType +
				", fiNameOfGoods='" + fiNameOfGoods + '\'' +
				", fiWeight=" + fiWeight +
				", fiWeightUnitCode='" + fiWeightUnitCode + '\'' +
				", fiWeightUnitName='" + fiWeightUnitName + '\'' +
				", fiWeightKG=" + fiWeightKG + '\'' +
				", fiWeightML=" + fiWeightML + '\'' +
				", fiSerialNo='" + fiSerialNo + '\'' +
				", fiCountryCode='" + fiCountryCode + '\'' +
				", fiCountryName='" + fiCountryName + '\'' +
				", fiCirculationNo='" + fiCirculationNo + '\'' +
				", fiDocumentNo='" + fiDocumentNo + '\'' +
				", fiTypeOfPackage='" + fiTypeOfPackage + '\'' +
				", fiManufacturerName='" + fiManufacturerName + '\'' +
				", fiActiveIngredient='" + fiActiveIngredient + '\'' +
				", fiImportTimeFrom=" + fiImportTimeFrom +
				", fiImportTimeTo=" + fiImportTimeTo +
				", fiLicenseFileNo=" + fiLicenseFileNo + '\'' +
				", fiLicenseFileBye=" + fiLicenseFileByte + '\'' +
				", fiGate=" + fiGate +
				'}';
	}


}
